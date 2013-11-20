<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.File"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Dat Title</title>
  </head>
  <body>
    <h3> studyTrade temporary index file </h3>
    <%
    File jsp = new File(request.getSession().getServletContext().getRealPath(request.getServletPath()));
    File dir = jsp.getParentFile();
    File[] list = dir.listFiles();
    
    for(int i = 0; i < list.length; i++) {
    	if (list[i].isFile()) 
    	out.println(String.format("<a href=\"%s\">%s</a><br>", list[i].getName(), list[i].getName()));
    }
    %>
    <p> <a href='/studyTrade/MainPage'>zur&uuml;ck</a> </p>
  </body>
</html>