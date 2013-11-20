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
	String password = request.getParameter("pw");

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

	secnum *= 100;
	secnum /= 24; // 24 == optimal (6 chars * 4categories)
	
	secnum = (secnum > 100) ? 100 : secnum;
			
	out.println(secnum);
%>