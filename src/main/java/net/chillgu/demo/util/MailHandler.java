package net.chillgu.demo.util;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailHandler {

	private JavaMailSender mailSender;
	private MimeMessage message;
	private MimeMessageHelper messageHelper;
	
	public MailHandler(JavaMailSender mailSender) throws MessagingException {
		this.mailSender = mailSender;
		this.message = mailSender.createMimeMessage();
		messageHelper = new MimeMessageHelper(message, true, "UTF-8");
	}
	
	public void setFrom(String from) throws MessagingException {
		messageHelper.setFrom(from);
	}
	
	public void setTo(String to) throws MessagingException {
		messageHelper.setTo(to);
	}
	
	public void setSubject(String subject) throws MessagingException {
		messageHelper.setSubject(subject);
	}
	
	public void setText(String text) throws MessagingException {
		messageHelper.setText(text);
	}
	
	public void setAttach(String filename, String path) throws MessagingException, IOException {
		File file = new ClassPathResource(path).getFile();	
		FileSystemResource fsr = new FileSystemResource(file);
		
		messageHelper.addAttachment(filename, fsr);
	}
	
	public void setInline(String contentId, String path) throws MessagingException, IOException {
		File file = new ClassPathResource(path).getFile();
		FileSystemResource fsr = new FileSystemResource(file);
		
		messageHelper.addInline(contentId, fsr);
	}
	
	public void send() throws Exception {
		mailSender.send(message);
	}
	
}
