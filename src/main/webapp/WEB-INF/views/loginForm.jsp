<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:url value="/" var="contextPath"/>
<c:url value="/resources/js" var="jsPath" />
<c:url value="/resources/css" var="cssPath" />
<script type="text/javascript" src="${jsPath}/jquery.js"></script>
<script type="text/javascript" src="${jsPath}/bootstrap.min.js"></script>
<link rel="stylesheet" href="${cssPath}/bootstrap.min.css">
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css">
</head>
<body>
	
	<div class="container">
		<h2>Login - Manga Organizer</h2>
		<form:form servletRelativeAction="/login" method="POST">
			<div class="form-group">
				<label >e-mail</label>
				<input type="text" name="username" class="form-control"/>
			</div>
		
			<div class="form-group">
				<label>Senha</label>
				<input type="password" name="password" class="form-control"/>
			</div>
		
			<div class="form-group">
				<button type="submit" class="btn btn-primary" >Login</button>
			</div>
		</form:form>
	</div>

</body>
</html>