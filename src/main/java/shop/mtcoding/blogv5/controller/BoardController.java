package shop.mtcoding.blogv5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //스프링이  특정 어노테이션이 붙어있는 클래스 파일들을 new해서(IoC) 스프링컨테이너에 관리해준다.

public class BoardController {

	 @GetMapping({ "/", "/board" })
	    public String index() {
	        return "index"; 
	    }
		//http://localhost:8080/board/saveForm
	    @GetMapping("/board/saveForm")
	    public String saveForm() {
	        return "/board/saveForm";
	    }

	    @GetMapping("/board/detail")
	    public String detail() {
	        return "/board/detail";
	    }
	    
	    
	    

	
}
