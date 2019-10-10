<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<fmt:message key="manga.list.page.title" var="pageTitle"/>
<fmt:message key="manga.button.save"  var="buttonSave"/>

<tags:pageTemplate title="${pageTitle }">
	<div class="container my-4" >	
		<h2 class="text-center my-4">${pageTitle} - ${userManga.manga.title}</h2>
	
		<sf:form modelAttribute="userManga" action="${s:mvcUrl('UMC#modifyUserManga').arg(0, userManga.id).build() }"	method="post">
				<!-- Imagem? -->
				<table class="table table-bordered table-hover">
					<thead class="thead-dark text-center">
						<tr>
							<th><fmt:message key="manga.status"/></th>
							<th><fmt:message key="manga.lastchapter"/></th>
							<th><fmt:message key="manga.notes"/></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="text-center col-sm-2">${userManga.manga.status}</td>
							<td class="col-sm-2"><sf:input style="width:100%;" path="lastChapter" class="text-center border-0 bg-transparent"></sf:input></td>
							<td><sf:input style="width:100%;" path="notes" class="text-center border-0 bg-transparent"></sf:input></td>
						</tr>	
					</tbody>							
				
				</table>
			
			<input type="submit" value="${ buttonSave}" class="btn btn-primary">
			
		</sf:form>
	</div>
</tags:pageTemplate>