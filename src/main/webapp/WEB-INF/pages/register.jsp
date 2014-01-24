<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>

<html>
<head>

<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>Registrierung</title>

<jsp:include page="commonincludes.jsp" />

<script src="register_scripts.js" type="text/javascript"></script>

</head>
<body class="standard_body">

	<div class="mainBox">



		<div class="contentbox" id="contentbox_register">
			<h1 class="contentbox_title">Register</h1>

			<form:form id="form" method="POST" modelAttribute="userBean">
				<form:input path="user_forename" placeholder="Vorname" type="text" class="inputbox_textfield" ></form:input>
				<br>
				<form:input path="user_lastname" placeholder="Nachname" type="text" class="inputbox_textfield"></form:input>
				<br>
				<form:input path="user_nickname" placeholder="Nickname" type="text" class="inputbox_textfield" ></form:input>
				<br>
				<form:input path="user_city" placeholder="Wohnort" type="text" class="inputbox_textfield" ></form:input>
				<br> <form:select path="user_school" class="inputbox_selectionfield" >
					<option  value="10" disabled selected>Hochschule</option>
					<option value=11>Hochschule 1</option>
					<option value=12>Hochschule 2</option>
					<option value=13>Hochschule 3</option>
					<option value=14>Hochschule 4</option>
					<option value=15>Hochschule 5</option>
				</form:select> <br>
				<form:input path="user_studydirection" placeholder="Studienrichtung" type="text" class="inputbox_textfield" id="register_branch_field"></form:input>
				<br>
				<form:input path="user_mail" placeholder="E-Mail" type="text" class="inputbox_textfield" id="register_email_field"></form:input>
				<br>
				<form:input path="user_password" type="password" placeholder="Passwort" class="inputbox_textfield" id="register_password_field"></form:input>
				<br>
				<input name="password_check" type="password" placeholder="Passwort" class="inputbox_textfield" id="register_password_field_check" />
				<div class="pw_meter pw_meter_orange">
					<span style="width: 0%" id="pw_meter_innerspan"><span></span></span>
				</div>
				<br>
				<input value="Registrieren" name=register type="submit" class="standard_content_button" />
				<br> <br>
			</form:form>
			<div class="contentbox_login_message">${infomsg}</div>
		</div>
	</div>
	
	
	
</body>

</html>
