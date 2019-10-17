<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>  
<security:authentication property="principal" var="user"/>

<tags:pageTemplate title="">
	<jsp:body>
		<h2 class="text-center mt-4 mb-5">Hello World! - ${user.name}</h2>
	</jsp:body>
</tags:pageTemplate>
