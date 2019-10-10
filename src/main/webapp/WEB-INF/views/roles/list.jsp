<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Produtos</title>
</head>
<body>
	<h2>${message }</h2>
	<h2>Lista de Roles</h2>
	<table>
		<tr>
			<th>nome</th>
		</tr>

		<c:forEach items="${roles}" var="role">
			<tr>
				<td><a href="${role.name}">${role.name}</a></td>
				<%-- 
				<td><a href="${s:mvcUrl('UC#remove').arg(0, user.id).build() }">remover</a></td>
				
				 --%> 
			</tr>


		</c:forEach>
	</table>

</body>
</html>