package shop.mtcoding.blogv5.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private int id;

	@Column(nullable = false, length = 100)
	private String title;

	@Lob
	private String content; // 섬머노트 라이브러리 <html>태그가 섞여서 디자인됨

	@ColumnDefault("0")
	private int count; // 조회수

	@ManyToOne(fetch = FetchType.EAGER) // Many = Board, User = one 한명의 유저는 여러개의 게시글을 쓸 수 있다.
	//들고올지말지 결정해야하는데 얘는 한건만 들고 오면 되니까 들고 오겠다. 보드테이블 셀렉하면 바로 가져올게.
	@JoinColumn(name = "userID") 
	private User user; // DB는 오브젝트를 저장할 수 없다.FK, 자바는 오브젝트를 저장할 수 있다.

	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) //하나의 게시글은 여러개의 답변이 달리지
	//기본 전략이 답변이 엄청 많으면 어케다가져와 필요하면 들고올게!(LAZY) (상세보기 누르면 가져오는식)
	// 그러나 우리는 게시판 열면 댓글이 바로 다 보이게 할거니까 다시 EAGER로 바꿀거야.
	//mappedBy연관관계의 주인이 아니다.(난 FK가 아니에요) DB에 칼럼을 만들지 마세요. FK키는 reply테이블에board가 들고있으니가
	private List<Reply> reply; //테이블에 생성되는 포링키는 아니다.
	
	@CreationTimestamp // 데이터가 업데이트될때 자동으로 시간이 들어간다.
	private Timestamp createDate;
}
