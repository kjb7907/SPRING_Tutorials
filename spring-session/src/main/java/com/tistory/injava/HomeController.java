package com.tistory.injava;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.tistory.injava.service.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes(value="loginMember")
public class HomeController {
	
	public String signin(Model model){
		model.addAttribute("loginMember", "로그인정보");
		return "redirect:/";
	}
		
	public String signout(SessionStatus status){
		status.isComplete();
		return "redirect:/";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session,Member member){
		
		boolean result = false;
		if(!result){
			return "login";
		}else{
			session.setAttribute("loginMember", member);
		}
	
		return "home";
	}
	
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
}
