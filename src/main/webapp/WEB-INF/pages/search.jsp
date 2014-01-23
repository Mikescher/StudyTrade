<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>Suche</title>
<jsp:include page="commonincludes.jsp" />
</head>
<body class="standard_body">
	<div class="mainBox">
		<div class="contentbox" id="contentbox_login">
			<h1 class="contentbox_title">Suche</h1>
			<div class="contentbox_login_message">${infomsg}</div>
			<form:form id="form" method="POST" modelAttribute="searchBean">
				<form:input path="searchString" placeholder="Suchfeld" type="text"
					class="inputbox_textfield" />
				<br>
				<input value="Suchen" name="search" type="submit"
					class="standard_content_button" />
			</form:form>
		</div>
	</div>
</body>
</html>