<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<jsp:include page="commonincludes.jsp" />
</head>
<style>
.site {
	margin: 0;
	padding: 0;
	border: 0;
	width: 100%;
}

.header {
	width: 100%;
	height: 50px;
	background-color: #000;
	left: 0px;
	top: 3px;
	right: 0px;
	position: fixed;
	opacity: 0.8;
}

.header_left {
	height: 48px;
	width: 200px;
	background-color: #424242;
	left: 215px;
	margin-top: 1px;
	position: absolute;
	
}

.header_left2 {
	height: 48px;
	width: 300px;
	background-color: #BDBDBD;
	left: 417px;
	margin-top: 1px;
	position: absolute;
}

.header_right {
	height: 48px;
	width: 200px;
	background-color: #424242;
	right: 15px;
	margin-top: 1px;
	position: absolute;
}

.header_right2 {
	height: 48px;
	width: 200px;
	background-color: #BDBDBD;
	right: 217px;
	margin-top: 1px;
	position: absolute;
}

.suchfeld {
	height: 40px;
	width: 200px;
	background-color: #E6E6E6;
	margin-top: 4px;
	margin-left: 10px; position : absolute;
	border: 0px;
	padding: 0px;
	position: absolute;
}

.bar_left {
	height: 1000px;
	width: 200px;
	outline: 2px  ;
	outline-style: inherit;
	outline-color: #000000;
	left: 2px;
	margin-top: 60px;
	background-color: #F2F2F2;
}
</style>
<body>
	<div class="site">
		<div class="header">
			<div class="header_left">DIV</div>
			<div class="header_left2">
				<input name="textfeld" placeholder="textfeld" type="text"
					class="suchfeld">
			</div>

			<div class="header_right2">DIV</div>
			<div class="header_right">DIV</div>
		</div>
		<div class="bar_left">
		
		  <div class="sidebarbox_element"><a href ="index.jsp">Index</a></div>
        <div class="sidebarbox_element"><a href ="login.jsp">Login</a></div>
        <div class="sidebarbox_element"><a href ="register.jsp">Register</a></div>
        <div class="sidebarbox_element"><span>Menu</span></div>
        <div class="sidebarbox_element"><span>Suicide</span></div>
        <div class="sidebarbox_element"><span>SuperMario</span></div>
        <div class="sidebarbox_element"><span>Bananas</span></div>
        <div class="sidebarbox_element"><span>Robots</span></div>
        <div class="sidebarbox_element"><span>Help</span></div>
        <div class="sidebarbox_element"><span>China</span></div>
        <div style="height:100px">&nbsp;</div>
</div>
		
		</div>
	</div>

</body>
</html>