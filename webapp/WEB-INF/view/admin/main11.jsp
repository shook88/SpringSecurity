<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>	
</head>

<body>

<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="com.homeshowping.security.MemberInfo" %>
<%
Authentication auth = SecurityContextHolder.getContext().getAuthentication();

Object principal = auth.getPrincipal();
String name = "";
if(principal != null && principal instanceof MemberInfo){
	name = ((MemberInfo)principal).getName();
}
%>

<div style="width:200px;float:left;">
	<sec:authorize access="isAnonymous()">
	<form id="loginfrm" name="loginfrm" method="POST" action="/loginProcess">
	<table>
		<tr>
			<td style="width:50px;">id</td>
			<td style="width:150px;">
				<input style="width:145px;" type="text" id="loginid" name="loginid" value="" />
			</td>
			
		</tr>
		<tr>
			<td>pwd</td>
			<td>
				<input style="width:145px;" type="text" id="loginpwd" name="loginpwd" value="" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" id="loginbtn" value="로그인" />
			</td>
		</tr>
	</table>
	
	<input type="hidden" name="loginRedirect" value="${loginRedirect}" />
	</form>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
	<%=name%>님 반갑습니다<br/>
	<c:if test="${not empty user }">
	<span>${user.name }</span>
	</c:if>
	<a href="/logout">로그아웃</a>
	</sec:authorize>
	<ul>
    	<sec:authorize access="hasRole('ROLE_ADMIN')">
        <li>관리자 화면</li>
        </sec:authorize>
        <sec:authorize access="permitAll">
        <li>비회원 게시판</li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
        <li>준회원 게시판</li>
        </sec:authorize>
        <sec:authorize access="hasAnyRole('ROLE_MEMBER2', 'ROLE_ADMIN')">
        <li>정회원 게시판</li>
        </sec:authorize>
    </ul>
</div>


</body>
</html>
