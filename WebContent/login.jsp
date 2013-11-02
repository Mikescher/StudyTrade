<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

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
			<form action="./login.jsp" method="get" onsubmit="shakeContentBox('#contentbox_login'); return false;">
				<input name="user" placeholder="Username" type="text" class="inputbox_textfield">
				<br>
				<input name="pass" placeholder="Password" type="password" class="inputbox_textfield">
				<br>
				<input value="Log In" name="login" type="submit" class="standard_content_button">
			</form>
		</div>
	</div>
	
	<jsp:include page="footer.jsp" />
	
</body>
</html>