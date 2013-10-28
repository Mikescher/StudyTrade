<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">

</head>
<body>


<% 
String aUser = request.getParameter("user");
String aPasswort = request.getParameter("password");
String aTestPasswort = "test"; 			//Wird irgendwo aus DB abgerufen
//print(aPasswort, aTestPasswort);
%>

<%!
String check_pass(String a, String b){
	if(a==b){return "richtig";}
	else{return "falsch";}
	
}
%>

<%out.println("das Passwort ist" + check_pass(aPasswort, aTestPasswort) ); %>


 

</body>
</html>