package by.bsu.app.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

	@GetMapping("/start")
    public String index() {
        return "/start";
    }
 
	
	                       
    
 
//    @GetMapping("/user")
//    public String user() {
//        return "/user";
//    }
// 
 
	 @GetMapping("/temp")
	    public String temp() {
		 Date d = new Date(2020,4,17);
		 Date f = new Date(2020,3,15);
		 if(d.after(f)){ 
			return "/temp"; 
		 }
	        return "/temp";
	    }	
	   
	
    @GetMapping("/login")
    public String login() {
        return "/login";
    }	
   
	
	
}
