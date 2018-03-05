//package com.homeshowping.admin.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//
//import org.springframework.mail.MailException;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//
//
//@Controller
//public class AdminController {
//	
//	@Autowired
//	private JavaMailSender mailSender;
//	
//	public void setMailSender(JavaMailSender mailSender) {
//		this.mailSender = mailSender;
//	}
//	
//	  @RequestMapping(value = "/admin/mail", method = RequestMethod.POST) // ajax에서 호출하는 부분
//	  @ResponseBody
//	  public String upload(String email) {
//		  
//		  System.out.println(email);
//		  
//		  SimpleMailMessage message = new SimpleMailMessage();
//			message.setSubject("[Simple] 회원 가입 안내");
//			message.setFrom("shook88@naver.com");
//			message.setText("회원 가입을 환영합니다.");
//			message.setTo(email);
//			try {
//				mailSender.send(message);
//			} catch (MailException ex) {
//				ex.printStackTrace();
//			}
//
//			return "success";
//	  }
//	  
//	
//}