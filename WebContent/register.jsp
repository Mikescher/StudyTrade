<html>
<body>

<%

  	String aVorname = request.getParameter("vorname");
	String aNachname = request.getParameter("nachname");
	String aNickname = request.getParameter("nickname");
	String aWohnort = request.getParameter("wohnort");
	String aHochschule = request.getParameter("hochschule");
	String aStudienrichtung = request.getParameter("studienrichtung");
	String aEmail = request.getParameter("email");
	String aPasswort = request.getParameter("pass");
  	
	
	
%>
<%-- Print out the variables. --%>
Vorname: <%=aVorname%><br>
Nachname: <%=aNachname %><br>
Nickname: <%=aNickname %><br>
Wohnort: <%=aWohnort %><br>
Hochschule: <%= aHochschule  %><br>
Studienrichtung: <%=aStudienrichtung %><br>
E-Mail: <%=aEmail %><br>
Passwort: <%=aPasswort %><br>

<%if(aVorname == ""){
out.println("fick dich!");	
}
%>
</body>
</html>