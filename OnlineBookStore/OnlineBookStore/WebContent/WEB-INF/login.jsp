<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="./css/stylesheet.css">
</head>
<body>

<c:if test="${exception ne null}">
    <div class="error">
        ${exception.message}
    </div>
</c:if>

<%@include file="header.jsp" %>
<br/>
<br/>
<br/>
<form action="<c:url value="/login.htm"/>" method="post">
    <fieldset>
        <legend>Login</legend>
        <table>
        <tr>
            <td>Username</td>
            <td><input type="text" id="username" name="username" placeholder="Usename"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" id="password" name="password" placeholder="Password"/></td>
        </tr>
        <tr><td colspan="2" align="center"><button id="login">Login</button></td></tr>
        </table>
    </fieldset>
</form>
</body>
</html>