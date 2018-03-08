package com.homeshowping.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;

import org.springframework.security.authentication.BadCredentialsException;

import org.springframework.security.authentication.LockedException;

import org.springframework.security.core.AuthenticationException;

import org.springframework.security.web.authentication.AuthenticationFailureHandler;


import org.apache.log4j.Logger;
/**
 * 인증 실패 핸들러
 * @author ChangDae
 *
 */
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	
	private Logger logger = Logger.getLogger(CustomAuthenticationFailureHandler.class);
	
	private String loginidname;			// 로그인 id값이 들어오는 input 태그 name
	private String loginpasswdname;		// 로그인 password 값이 들어오는 input 태그 name
	private String loginredirectname;		// 로그인 성공시 redirect 할 URL이 지정되어 있는 input 태그 name
	private String exceptionmsgname;		// 예외 메시지를 request의 Attribute에 저장할 때 사용될 key 값
	private String defaultFailureUrl;		// 화면에 보여줄 URL(로그인 화면)
	
	public CustomAuthenticationFailureHandler(){
		this.loginidname = "j_username";
		this.loginpasswdname = "j_password";
		this.loginredirectname = "loginRedirect";
		this.exceptionmsgname = "securityexceptionmsg";
		this.defaultFailureUrl = "/login?fail=true";
	}
	
	
	public String getLoginidname() {
		return loginidname;
	}


	public void setLoginidname(String loginidname) {
		this.loginidname = loginidname;
	}


	public String getLoginpasswdname() {
		return loginpasswdname;
	}


	public void setLoginpasswdname(String loginpasswdname) {
		this.loginpasswdname = loginpasswdname;
	}

	public String getExceptionmsgname() {
		return exceptionmsgname;
	}

	public void setExceptionmsgname(String exceptionmsgname) {
		this.exceptionmsgname = exceptionmsgname;
	}
	
	public String getLoginredirectname() {
		return loginredirectname;
	}


	public void setLoginredirectname(String loginredirectname) {
		this.loginredirectname = loginredirectname;
	}


	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}

	@Override
	public void onAuthenticationFailure
	(HttpServletRequest request, HttpServletResponse response, 
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		logger.error("This is 1");

		// Request 객체의 Attribute에 사용자가 실패시 입력했던 로그인 ID와 비밀번호를 저장해두어 로그인 페이지에서 이를 접근하도록 한다
		String loginid = request.getParameter(loginidname);
		logger.error(loginid);
		
		String loginpasswd = request.getParameter(loginpasswdname);
		logger.error(loginpasswd);
		String loginRedirect = request.getParameter(loginredirectname);
		logger.error(loginRedirect);
		
		request.setAttribute(loginidname, loginid);
		request.setAttribute(loginpasswdname, loginpasswd);
		request.setAttribute(loginredirectname, loginRedirect);
		
		
		// Request 객체의 Attribute에 예외 메시지 저장
		request.setAttribute(exceptionmsgname, exception.getMessage());
		request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
		logger.error(exception.getMessage());
		logger.error(exception.toString());
		
//		if(exception instanceof AuthenticationServiceException){
//
//			logger.error(exception.toString());
//			exception.printStackTrace();
//			response.sendRedirect("/login?exceptionmsgname="+exception.getMessage()+"&loginid="+request.getParameter(loginidname));
////			request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
//
//
//		}
//
//		
//
//		if(exception instanceof BadCredentialsException){
//
//			logger.error(exception.toString());
//			exception.printStackTrace();
////			response.sendRedirect("/login?exceptionmsgname="+exception.getMessage()+"&loginid="+request.getParameter(loginidname));
//			
//			
//		}
//
//		
//
//		if(exception instanceof LockedException){
//
////			request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
//			logger.error(exception.toString());
//			exception.printStackTrace();
//			response.sendRedirect("/login?exceptionmsgname="+exception.getMessage()+"&loginid="+request.getParameter(loginidname));
//
//		}


		
		logger.error("This is 9");
	}

}