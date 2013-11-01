<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
<head>

<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>neuen Artikel einstellen</title>

<jsp:include page="commonincludes.jsp"/>

<script src="" type="text/javascript"></script> 

</head>
<body class="standard_body">


	<div class="contentbox" id="contentbox_newarticle">	
		<h1 class="contentbox_title">neuen Artikel einstellen</h1>
		<form action="./index.jsp" method="GET" onsubmit="return validateData()">
			<input name="artikelbezeichnung" maxlength="50" placeholder="Artikelbezeichnung (max. 50 Zeichen)" type="text" class="inputbox_textfield_long" id="newarticle_artikelbez_field">
				<select name="zustand" style="margin-left: 10px" class="inputbox_selectionfield" id="register_university_field">
				<option value="h0" disabled selected>Zustand</option>
				<option value="h1">neu</option>
				<option value="h2">neuwertig</option>
				<option value="h3">gut</option>
				<option value="h4">beschädigt</option>
			</select>
			<br>
			<br>
			<textarea name="artikelbeschreibung" maxlength="500" placeholder="Artikelbescheibung (max. 500 Zeichen)" class="textarea_newarticle"></textarea>
			<table border="0" align="center" bordercolor="#FFFFF" style="background-color:#FFFFF" width="580" cellpadding="0" cellspacing="0">
			<tr>
			<td> 
				<input name="standort" maxlength="20" placeholder="Standort" type="text" class="inputbox_textfield" id="newarticle_artikelbez_field">
			  	<br>
			   	<input name="telefon" maxlength="20" placeholder="Telefon" type="text" class="inputbox_textfield" id="newarticle_artikelbez_field">
			</td>
			<td	>
				<div class="upload_file" style="border: 1px; height: 60px; width: 260px; background-color: grey; margin-bottom: 10px">Hier kommt der Dateiupload hin</div>
			
			</td>
			</tr>
			</table>
			
			<input value="Überprüfen" name="newarticle_check" type="submit" class="standard_content_button">
			
			
		</form>
		
		
	</div>
</body>

</html>
