package shop.mtcoding.blogv5.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

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

	@ManyToOne // Many = Board, User = one 한명의 유저는 여러개의 게시글을 쓸 수 있다.
	@JoinColumn(name = "userID")
	private User user; // DB는 오브젝트를 저장할 수 없다.FK, 자바는 오브젝트를 저장할 수 있다.

	@CreationTimestamp // 데이터가 업데이트될때 자동으로 시간이 들어간다.
	private Timestamp createDate;
}
