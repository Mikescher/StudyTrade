<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>Login</title>

<jsp:include page="commonincludes.jsp" />

</head>
<body class="standard_body">

	<div class="mainBox">

		<jsp:include page="header.jsp" />
		<jsp:include page="sidebar.jsp" />

		<div class="contentbox" id="contentbox_login">
			<h1 class="contentbox_title">Login</h1>
			<div class="contentbox_login_message">${infomsg}</div>
			
			<form:form id="form" method="POST" modelAttribute="loginBean"> 
				<form:input path="username" placeholder="Username" type="text" class="inputbox_textfield" />
				<br>
				<form:input path="password" placeholder="Password" type="password" class="inputbox_textfield" />
				<br>
				<input value="Log In" name="login" type="submit" class="standard_content_button" />
			</form:form>
			
			<i>BN: root // PW: 123</i>
		</div>
	</div>
	
	<jsp:include page="footer.jsp" />
	
</body>
</html>