<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>Login</title>

<jsp:include page="commonincludes.jsp" />

</head>
<body class="standard_body">

    <div class="mainBox">

        <jsp:include page="header.jsp" />
        <jsp:include page="sidebar.jsp" />

        <div class="contentbox" id="contentbox_login">
            <h1 class="contentbox_title">You've been logged in</h1>
        </div>
    </div>
    
    <jsp:include page="footer.jsp" />
    
</body>
</html>