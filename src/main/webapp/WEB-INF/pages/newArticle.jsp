<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>neuen Artikel einstellen</title>

<jsp:include page="commonincludes.jsp" />
<script src="" type="text/javascript"></script>

</head>
<body class="standard_body">
	<div class="contentbox" id="contentbox_newarticle">
		<h1 class="contentbox_title">neuen Artikel einstellen</h1>
		<form:form id="form" method="POST" modelAttribute="articleBean">
			<form:input path="article_name" maxlength="50"
				placeholder="Artikelbezeichnung (max. 50 Zeichen)" type="text"
				class="inputbox_textfield_long" id="newarticle_artikelbez_field" />
			<form:select path="article_condition" style="margin-left: 10px"
				class="inputbox_selectionfield" id="register_university_field">
				<option value="h0" disabled selected>Zustand</option>
				<option value="h1">neu</option>
				<option value="h2">neuwertig</option>
				<option value="h3">gut</option>
				<option value="h4">beschädigt</option>
			</form:select>
			<br>
			<br>
			<form:textarea path="article_description" maxlength="500"
				placeholder="Artikelbescheibung (max. 500 Zeichen)"
				class="textarea_newarticle"></form:textarea>
			<form:input path="article_city" maxlength="20" placeholder="Standort"
				type="text" class="inputbox_textfield"
				id="newarticle_artikelbez_field"></form:input>
			<br>
			<form:input path="article_contact" maxlength="20"
				placeholder="Telefon" type="text" class="inputbox_textfield"
				id="newarticle_artikelbez_field"></form:input>
			<form:input path="article_category" maxlength="20"
				placeholder="Kategorie TEST" type="text" class="inputbox_textfield"
				id="newarticle_artikelbez_field"></form:input>
			<input value="Überprüfen" name="newarticle_check" type="submit"
				class="standard_content_button">
				<table>
		<c:forEach var="us" items="${articleBean.testlist}">
			<tr>
				<td>${us}</td>

			</tr>
		</c:forEach>
	</table>
		</form:form>
		<div class="contentbox_login_message">${infomsg}</div>

	</div>
	

</body>
</html>