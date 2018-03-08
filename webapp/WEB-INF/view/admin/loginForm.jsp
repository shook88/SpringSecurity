<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>HOMESHOWPING</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<!-- css -->
 <link href="${ pageContext.request.contextPath }/resources/css/login-modal.css" rel="stylesheet" />

  


</head>

<body>
	<div id="wrapper">
		

		<div class="container">
			<div class="col-lg-12">
				<div class="row ">
				<div style="padding: 100px 0 0 0;">
				<h2 style="text-align: center;">HOME SHOW PING
				</h2>
				</div>
				</div>
			</div>
		</div>



		<div class="container" style="width: 100%">
			<div class="col-lg-12">
				<div class="row ">
					<div id="modal-login">
						<div id="cd-login">
							<!-- log in form -->
							<form id="loginfrm" class="cd-form" name="loginfrm" action="<c:url value='/loginProcess'/>" method="POST">
								<p class="fieldset">
									<label class="image-replace cd-email" for="signin-email">E-mail</label>
									<input class="full-width has-padding has-border"
										id="signin-email" name="loginid" type="text" placeholder="id" value="${loginid }"> <span
										class="cd-error-message"></span>
								</p>

								<p class="fieldset">
									<label class="image-replace cd-password" for="signin-password">Password</label>
									<input class="full-width has-padding has-border"
										id="signin-password" type="password" name="loginpwd" placeholder="password" value="${loginpwd }" >
									<a href="#0" class="hide-password">Hide</a>
									<span class="cd-error-message"></span>
								</p>

								
								<c:if test="${not empty securityexceptionmsg}">
    	<tr>
    		<td colspan="2">
				<font color="red">
				<p>Your login attempt was not successful, try again.</p>
				<p>${securityexceptionmsg}</p>
				</font>
    		</td>
    	</tr>
    	</c:if>
								<p class="fieldset">
									<!-- <input class="full-width" type="submit" value="Login"> -->
									<input class="full-width" type="button" value="Login" id="loginbtn" />
								</p>
								<input type="hidden" name="loginRedirect" value="${loginRedirect}" />
							</form>
						</div>
						<!-- cd-login -->
					</div>
				</div>


			</div>
		</div>

	</div>

</body>
   <script src="${ pageContext.request.contextPath }/resources/js/jquery.js"></script>
   <script src="${ pageContext.request.contextPath }/resources/js/jquery.easing.1.3.js"></script>
   <script type="text/javascript">
 $(document).ready(function (){
	
	 $("#loginbtn").click(function(){
			if($("#signin-email").val() == ""){
				alert("로그인 아이디를 입력해주세요");
				$("#signin-email").focus();
			}else if($("#signin-password").val() == ""){
				alert("로그인 비밀번호를 입력해주세요");
				$("#signin-password").focus();
			}else{
				$("#loginfrm").attr("action", "<c:url value='/loginProcess'/>");
				$("#loginfrm").submit();
			}
		});
	 
		
 }); 
</script> 

</html>