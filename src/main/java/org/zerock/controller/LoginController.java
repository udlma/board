package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.MemberVO;
import org.zerock.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/login/*")
@Log4j
public class LoginController {
	
	@Setter(onMethod_={@Autowired})	
	MemberService service;
	
	@GetMapping("/login")
	public void login() {
		
		log.info("get login");
		
	}
	
	@PostMapping("/action")
	public void loginPost(String username, String password, Model model) {
		
		MemberVO vo = service.getLogin(username, password);
		
		model.addAttribute("member", vo);
		
	}

}
