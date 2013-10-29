<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
<head>

<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>Registrierung</title>

<jsp:include page="commonincludes.jsp"/>

<script src="register_scripts.js" type="text/javascript"></script>

</head>
<body class="standard_body">

    <jsp:include page="header.jsp"/>
    <jsp:include page="sidebar.jsp"/>

	<div class="contentbox" id="contentbox_register">	
		<h1 class="contentbox_title">Register</h1>

		<form action="./index.jsp" method="GET" onsubmit="return validateData()">
			<input name="forname" placeholder="Vorname" type="text" class="inputbox_textfield" id="register_forename_field">
			<br>
			<input name="surname" placeholder="Nachname" type="text" class="inputbox_textfield" id="register_lastname_field">
			<br>
			<input name="nickname" placeholder="Nickname" type="text" class="inputbox_textfield" id="register_nickname_field">
			<br>
			<input name="address" placeholder="Wohnort" type="text" class="inputbox_textfield" id="register_address_field">
			<br>
			<select name="university" class="inputbox_selectionfield" id="register_university_field">
				<option value="h0" disabled selected>Hochschule</option>
				<option value="h1">Hochschule 1</option>
				<option value="h2">Hochschule 2</option>
				<option value="h3">Hochschule 3</option>
				<option value="h4">Hochschule 4</option>
				<option value="h5">Hochschule 5</option>
			</select>
			<br>
			<input name="branch" placeholder="Studienrichtung" type="text" class="inputbox_textfield" id="register_branch_field">
			<br>
			<input name="email" placeholder="E-Mail" type="text" class="inputbox_textfield" id="register_email_field">
			<br>
			<input name="password" type="password" placeholder="Passwort" class="inputbox_textfield" id="register_password_field"/>
			<br>
			<input name="password_check" type="password" placeholder="Passwort" class="inputbox_textfield" id="register_password_field_check"/>
			<div class="pw_meter pw_meter_orange">
                <span style="width: 0%" id="pw_meter_innerspan"><span></span></span>
            </div>
			<br>
			<input value="Registrierung" name="register" type="submit" class="standard_content_button">
			<br>
			<br>
		</form>
	</div>
</body>

</html>
