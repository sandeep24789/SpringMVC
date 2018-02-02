<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>

</head>
<body>
	<div>
		<c:url value="/index.htm" var="homeUrl" />
		<div class="logo">
			<a href="${homeUrl}"><img
				src="<c:url value="/images/bookstore.jpg"/>" alt="" title=""
				border="0" /></a>
		</div>
		<div >

			<ul style="float: left;">
				<li><a href="${homeUrl}">Home</a></li>
				<li><a href="<c:url value="/book/search"/>">Book</a>
				
				<li><a href="<c:url value="/book/add"/>">Add Book</a>
				
				</li>
				<li><a href="<c:url value="/customer/account"/>">Account</a></li>
				
				<c:if test="${sessionScope.account eq null}">
					<li><a href="<c:url value="/customer/register.htm"/>">Register</a></li>
					<li><a href="<c:url value="/login.htm"/>">Login</a></li>
				</c:if>
				<c:if test="${sessionScope.account ne null}">
					<li><a href="<c:url value="/logout.htm"/>">Logout</a></li>
				</c:if>
				
				<li><a href="?lang=en" class="selected">
				<img src="<c:url value="/images/gb.gif"/>" alt ="" title="" border="0" />
				</a></li>
				<li><a href="?lang=hi">
				<img style="height: 20px; width: 20px;" src="<c:url value="/images/indiaflag.jpg"/>" alt ="" title="" border="0" />
				</a></li>
				
			</ul>
			

		</div>

	</div>
</body>
</html>