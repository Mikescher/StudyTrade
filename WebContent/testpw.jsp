<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.regex.*"%>

<%
	String password = request.getParameter("q");

	if (password == null) {
		out.println("No PW given");
		return;
	}

	int secnum = password.length();

	if (Pattern.matches("/[a-z]+/", password)) {
		secnum = secnum + 5;
	}

	if (Pattern.matches("/[A-Z]+/", password)) {
		secnum = secnum + 5;
	}

	if (Pattern.matches("/[0-9]+/", password)) {
		secnum = secnum + 5;
	}

	if (Pattern.matches("[.,;:-_ #'+*~!§$%&/()\\[\\]{}\\=?<>|]+", password)) {
		secnum = secnum + 5;

	}

	if (secnum <= 18) {
		out.println("unsicher (" + secnum + " Punkte)");
	} else if (secnum <= 25) {
		out.println("sicher (" + secnum + " Punkte)");
	} else if (secnum > 25) {
		out.println("sehr sicher (" + secnum + " Punkte)");
	}
%>