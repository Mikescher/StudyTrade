<%@ page language="java" import="de.dh_karlsruhe.it.softweng.studyTrade.login.LoginBean" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>

<jsp:include page="commonincludes.jsp" />

</head>
<body class="standard_body">

	<div class="mainBox">



		<div class="contentbox" id="contentbox_login">
			<h1 class="contentbox_title">Login</h1>
			<div class="contentbox_login_message">${infomsg}</div>
			
			<form:form id="form" method="POST" modelAttribute="loginBean"> 
				<form:input path="username" placeholder="Username" type="text" class="inputbox_textfield" />
				<br>
				<form:input path="password" placeholder="Password" type="password" class="inputbox_textfield" />
				<br>
				<input value="Log In" name="login" type="submit" class="standard_content_button" />
			</form:form>
			
			<i>BN: root // PW: 123</i>
		</div>
		
		
		<table>
<c:forEach var="us" items="${loginBean.userlist}" >
    <tr>
     <td>${us.Id}</td>
      <td>${us.username}</td>
      <td>${emp.password}</td>
    </tr>
  </c:forEach>
</table>
	</div>
	
	
	
</body>
</html>