<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<fmt:message key="manga.list.page.title" var="pageTitle"/>

<security:csrfMetaTags />

<tags:pageTemplate title="${pageTitle }">
	
	<jsp:attribute name="extraScripts">
		<script >
		
			function remove(id, element) {
				$.ajax({
				    url: "/mangaorganizer/mangas/removeManga",
				    method: "POST",
				    data: {id: id},				
				    headers: {'X-CSRF-TOKEN': $("meta[name='_csrf']").attr('content') },
				    datatype: "json",
				    success: deleted(element)
				});
			}
				function deleted(element) {
					$(element).closest("tr").hide();
					alert("Manga removido do sistema ");
				}
				
		</script>
	</jsp:attribute>

	<jsp:body>
		<div class="container my-4" >		
			<h2>${message }</h2>
			<h2 class="text-center my-4">${pageTitle}</h2>
			<table class="table table-bordered table-hover">	
				<thead class="thead-dark text-center">
					<tr>
						<th><fmt:message key="manga.title"/></th>
						<th><fmt:message key="manga.status"/></th>
						<th><fmt:message key="manga.publication"/></th>
						<th><fmt:message key="manga.finalization"/></th>
						<th><fmt:message key="manga.chapters"/></th>
						<th><fmt:message key="manga.remove"/></th>
					</tr>
				</thead>	
		
				<c:forEach items="${mangas}" var="manga">
					<tr>
						<td><a href="${s:mvcUrl('MC#detail').arg(0, manga.id).build()}">${manga.title}</a></td>
						<td class="text-center">${manga.status}</td>
						<td class="text-center"><fmt:formatDate value="${manga.publicationDate.time}" pattern="dd-MM-yyyy"/></td>
						<td class="text-center"><fmt:formatDate value="${manga.finalizationDate.time}" pattern="dd-MM-yyyy"/></td>
						<td class="text-center">${manga.chapters}</td>
		 				<td class="text-center text-lowercase"><a href="#" onclick="remove(${manga.id}, this)"><fmt:message key="manga.remove"/></a></td> 
					</tr>
				</c:forEach>
			</table>
		</div>	
	</jsp:body>
	
</tags:pageTemplate>

