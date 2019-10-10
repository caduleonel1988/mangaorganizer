<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<fmt:message key="user.list.page.title"  var="pageTitle"/>
<tags:pageTemplate title="${pageTitle}">
	<jsp:body>
		<div class="container my-4" >
			<h3>${message}</h3>
			<h2 class="text-center my-4">${pageTitle}</h2>
			<table class="table table-bordered table-hover">
				<thead class="thead-dark text-center">	
					<tr>
						<th><fmt:message key="user.email"/></th>
						<th><fmt:message key="user.name"/></th>
						<th><fmt:message key="user.remove"/></th>
					</tr>
				</thead>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><a
							href="${s:mvcUrl('UAC#detail').arg(0,user.email).build()}">${user.email}</a></td>
						<td>${user.name}</td>
						<td class="text-center"><a
							href="${s:mvcUrl('UC#remove').arg(0, user.email).build()}">remover</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</jsp:body>
</tags:pageTemplate>
