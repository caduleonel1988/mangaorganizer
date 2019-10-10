<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ attribute name="title" required="true" %>
<%@ attribute name="extraScripts" fragment="true" %>
<%@ attribute name="bodyClass" required="false" %>

<c:url value="/" var="contextPath" />


<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>${title} - Manga Organizer</title>
		<script type="text/javascript" src="${contextPath}resources/js/jquery.js"></script>
		<script type="text/javascript" src="${contextPath}resources/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="${contextPath}resources/css/bootstrap.min.css">
		<link rel="stylesheet" href="${contextPath}resources/css/bootstrap-theme.min.css">
	</head>
	
	<body class="${bodyClass}">
		<%@ include  file="/WEB-INF/views/header.jsp" %>
		
		<jsp:doBody />
		<jsp:invoke fragment="extraScripts"/>
		
		<%@ include  file="/WEB-INF/views/footer.jsp" %>
	</body>
</html>