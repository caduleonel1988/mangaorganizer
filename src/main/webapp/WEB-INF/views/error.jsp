<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>


<tags:pageTemplate title="">
	<jsp:body>
		<h2 class="text-center mt-4 mb-5">Ops, Aconteceu um erro!! </h2>
		<h3 class="text-center mt-4 mb-5">Por favor entre em contato com a nossa equipe.</h3>
		<p class="message-text text-center mt-4 mb-5">The page you requested is not available. You might try returning to the <a
				href='<c:url value="/"/>'>home page</a>.</p>
	</jsp:body>
</tags:pageTemplate>