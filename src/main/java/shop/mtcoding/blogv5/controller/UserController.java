package shop.mtcoding.blogv5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//스프링이  특정 어노테이션이 붙어있는 클래스 파일들을 new해서(IoC) 스프링컨테이너에 관리해준다.
public class UserController {
	 
	    // a태그 form태그 method=get
	//http://localhost:8080/joinFrom
	    @GetMapping("/joinForm")
	    public String joinForm() {
	        // templates/
	        // .mustache
	    	// templates//user/joinForm.mustache
	        return "user/joinForm";
	    }

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    @GetMapping("/loginForm")
	    public String loginForm() {
	        return "user/loginForm";
	    }

	    @GetMapping("/user/updateForm")
	    public String updateForm() {
	        return "user/updateForm";
	    }

	    @GetMapping("/logout")
	    public String logout() {
	        return "redirect:/";
	    }

	
}
