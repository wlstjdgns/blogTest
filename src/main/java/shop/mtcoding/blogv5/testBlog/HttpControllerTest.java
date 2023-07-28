package shop.mtcoding.blogv5.testBlog;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청 -> 응답(HTML 파일)
//@controller
@RestController // 사용자가 요청 -> 응답(Data)
public class HttpControllerTest {
	
	//http://localhost:8080/http/post(select)
	@GetMapping("/http/get")
	public String getTest() {
		return "get 요청";
	}
	//http://localhost:8080/http/post(insert)
	@PostMapping("/http/post")
	public String postTest() {
		return "post 요청";
	}
	//http://localhost:8080/http/post(update)
	@PutMapping("/http/put")
	public String putTest() {
		return "put 요청";
	}
	//http://localhost:8080/http/post(delete)
	@DeleteMapping("/http/deleteTest")
	public String deleteTest() {
		return "delete 요청";
	}

}
