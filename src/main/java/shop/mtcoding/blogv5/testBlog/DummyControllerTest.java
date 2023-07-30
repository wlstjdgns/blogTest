package shop.mtcoding.blogv5.testBlog;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import shop.mtcoding.blogv5.model.RoleType;
import shop.mtcoding.blogv5.model.User;
import shop.mtcoding.blogv5.repository.UserRepository;

//html 파일이 아니라 data를 리턴해주는 controller = restcontroller
@RestController
public class DummyControllerTest {
	
	@Autowired //유저레파지토리 객체가 잇다면 뒤에 이름에 넣어줘 //의존성주입
	private UserRepository userRepository;
	
	//{id} 주소로 파라메터를 전달 받을 수 있음
	// http://localhost:8080/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}") //3이 아이디에 쏙 들어올거에요.
	public User detail(@PathVariable int id) {
		
		//user/4를 찾으면 내가 DB에서 못찾아오게 되면 user가 null이 될거고 
		//그럼 return null이 리턴이 되잖아... 그럼 프로그램에 문제가 있지 않겠니?
		// Optional로 너의 User객체를 감싸서 가져올테니 null인지 아닌지 판단해서 return해!
//		ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ1번ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
//		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
//			@Override
//			public User get() {
//				
//				return new User();
//		ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ2번ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
		@Override
		public IllegalArgumentException get() {
			return new IllegalArgumentException("해당 유저는 없습니다. id : "+id);
		}
	});
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ3번ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
//		User user = userRepository.findById(id).orElseThrow(()->{
//			return new IllegalArgumentException("해당 사용자는 없습니다.");
//		}); //이렇게하면 서플라이어 타입이 들어가야한다던지 뭐라던지 신경안쓰고 하시면 됩니다. // 여기서 지원을 안해줘서 문제지
// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ		
	//요청 : 웹브라우저
	// user 객체 = 	자바 오브젝트
	//변환 (웹브라우저가 이해할 수 있는 데이터) -> json(Gson 라이브러리)
	//스프링부트 = MessageConverter라는 애가 응답시에 자동 작동
	// 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서
	//user 오브젝트를 json으로 변환해서 브라우저에게 던져줍니다.
	return user;
		
	}
	//http://localhost:8000/blog/dummy/join(요청)
	//http의body에 username,password,email 데이터를 가지고 (요청)
@PostMapping("/dummy/join")
public String join(User user) {
	
	
	System.out.println("username: "+ user.getUsername());
	System.out.println("password: "+ user.getPassword());
	System.out.println("email: "+ user.getEmail());
	user.setRole(RoleType.USER);
	userRepository.save(user);
	return "회원가입이 완료되었습니다."; //왜안되는거지.......
}
}
