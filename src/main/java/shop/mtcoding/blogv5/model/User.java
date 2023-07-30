package shop.mtcoding.blogv5.model;


import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//ORM -> Java(다른언어) Object -> 테이블로 매핑해주는 기술
//@Dynamiclnsert //insert시에 null인 필드를 제외시켜준다.
@Data@NoArgsConstructor@AllArgsConstructor@Builder
@Entity //테이블화해주기위함 //User클래스가 MySQL에 테이블이 생성된다.
public class User {
	@Id//Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id;//auto_increment 전략 가져갈거야
	@Column(nullable = false,length = 30)			
	private String username;
	@Column(nullable = false,length = 100) //123456 우리가 넣는 패스워드를 해쉬로 변경해서 비밀번호암호화해야하니까 크게잡는다
	private String password;
	@Column(nullable = false,length = 50)
	private String email;
	//도메인이라는건 범위다. 사람이면 남녀성별 대학생이면 1-4 고등학생이면 1-3
//	@ColumnDefault("user")
	//DB는 Role Type이라는게 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role; //Enum을 쓰는게 좋다. //Admin 관리자,user,manager 권한설정 (managerrr 스트링은 오타가 날 수 있지)
	//ADMIN,USER
	
	
	@CreationTimestamp //시간이 자동으로 입력이 된다.
	private Timestamp createDate;

	
}

