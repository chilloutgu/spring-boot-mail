package net.chillgu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import net.chillgu.demo.dto.MailDto;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	private final String FROM_ADDRESS = "bbonggu92@gmail.com";
	
	public void sendMail(MailDto mailDto) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(mailDto.getAddress());
		mailMessage.setFrom(this.FROM_ADDRESS);
		mailMessage.setSubject(mailDto.getTitle());
		mailMessage.setText(mailDto.getContents());
		
		mailSender.send(mailMessage);
	}
}
