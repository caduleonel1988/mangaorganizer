<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix= "s" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Cadastro de Permissões</h1>
	<sf:form modelAttribute="role" action="${s:mvcUrl('RC#add').build()}" method="post">
		<div>
			<sf:label for="name" path="name">Nome</sf:label> 
			<sf:input path="name" />
			<sf:errors cssClass="error" path="name"/>
		</div>
		
		
		<sf:input type="submit" value="Salvar" path="" /> <sf:input type="reset" value="Resetar" path="" /> 
	</sf:form>

</body>
</html>