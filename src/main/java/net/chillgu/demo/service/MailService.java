package net.chillgu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import net.chillgu.demo.dto.MailDto;
import net.chillgu.demo.util.MailHandler;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	private final String FROM_ADDRESS = "bbonggu92@gmail.com";
	
	public void sendMail(MailDto mailDto) throws Exception {
		
		MailHandler mailHandler = new MailHandler(mailSender);
		
		mailHandler.setFrom(this.FROM_ADDRESS);
		mailHandler.setTo(mailDto.getAddress());
		mailHandler.setSubject(mailDto.getTitle());
		String htmlContent = "<p>" + mailDto.getContents() + "</p> <img src='cid:sample-img'>";
		mailHandler.setText(htmlContent, true);
		mailHandler.setAttach("test.txt", "static/originalText.txt");
		mailHandler.setInline("sample-img", "static/sample1.jpg");
		
		mailHandler.send();
		/*SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(mailDto.getAddress());
		mailMessage.setFrom(this.FROM_ADDRESS);
		mailMessage.setSubject(mailDto.getTitle());
		mailMessage.setText(mailDto.getContents());
		
		mailSender.send(mailMessage);*/
	}
}
