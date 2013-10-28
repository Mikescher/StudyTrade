<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.regex.*"%>

<%!
public boolean rexinclude(String rex, String txt) {
	Pattern p = Pattern.compile(rex);
	Matcher m = p.matcher(txt);
	return m.find();
}
%>

<%
	String password = request.getParameter("q");

	if (password == null) {
		out.println("No PW given");
		return;
	}

	int secnum = password.length();
	
	int catcount = 0;

	if (rexinclude("[a-z]+", password)) {
		catcount++;
	}

	if (rexinclude("[A-Z]+", password)) {
		catcount++;
	}

	if (rexinclude("[0-9]+", password)) {
		catcount++;
	}

	if (rexinclude("[.,;:\\-_ #'+*~!§$%&/()\\[\\]{}\\=?<>|]+", password)) {
		catcount++;
	}
	
	secnum *= catcount;

	if (secnum <= 18) {
		out.println("<font color=\"red\">unsicher (" + secnum + " Punkte)</font>");
	} else if (secnum <= 30) {
		out.println("<font color=\"yellow\">sicher (" + secnum + " Punkte)</font>");
	} else {
		out.println("<font color=\"green\">sehr sicher (" + secnum + " Punkte)</font>");
	}
%>