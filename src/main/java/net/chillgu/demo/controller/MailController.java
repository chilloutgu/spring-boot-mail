package net.chillgu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import net.chillgu.demo.dto.MailDto;
import net.chillgu.demo.service.MailService;

@Controller
@RequiredArgsConstructor
public class MailController {

	private final MailService mailService;
	
	@GetMapping("/mail")
	public String dispMail() {
		
		return "mail";
	}
	
	@PostMapping("/mail")
	public void execMail(MailDto mailDto) throws Exception {
		mailService.sendMail(mailDto);
	}
}
