package shop.mtcoding.blogv5.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
@Entity
public class Reply {
	@Id//Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id;//auto_increment 전략 가져갈거야
	
	@Column(nullable = false,length=200)
	private String content; // 섬머노트 라이브러리 <html>태그가 섞여서 디자인됨
	
	@ManyToOne //여러개의 답변은 하나의 게시글에 있을 수 있다.
	@JoinColumn(name="boardId")
	private Board board;
	@ManyToOne //여러개의 답변은 하나의 유저가 쓸 수 있다.
	@JoinColumn(name="userID")
	private User user;
	
	@CreationTimestamp
	private Timestamp createTimestamp;

}
