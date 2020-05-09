package net.chillgu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MailController {

	private final MailService mailService;
	
	@GetMapping("/mail")
	public String dispMail() {
		
		return "mail";
	}
	
	@PostMapping("/mail")
	public void execMail(MailDto mailDto) {
		mailService.sendMail(mailDto);
	}
}
