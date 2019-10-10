<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath"/>

<fmt:message key="user.account.page.title"  var="pageTitle"/>
<fmt:message key="manga.list.page.title"  var="mangaList"/>
<fmt:message key="user.button.save"  var="buttonSave"/>
<fmt:message key="user.button.reset"  var="buttonReset"/>

<security:csrfMetaTags />

<tags:pageTemplate title="${pageTitle}" >

	<jsp:attribute name="extraScripts"> 
		<script>
	
		function remove(id, element) {
			$.ajax({
			    url: "/mangaorganizer/mangas/usersManga/removeUserManga",
			    method: "POST",
			    data: {id: id},				
			    headers: {'X-CSRF-TOKEN': $("meta[name='_csrf']").attr('content') },
			    datatype: "json",
			    success: deleted(element)
			});
		}
			function deleted(element) {
				$(element).closest("tr").hide();
				alert("Manga removido da sua conta ");
			}
	
			//Exemplo de $.post sem utilizar a função do Ajax
			function pagaAgora(id, element) {
			    $.post("pagaConta", {'id' : id}, function() {
			      alert("Conta paga com sucesso");
			    });
			  }
			  
		</script>
		
	</jsp:attribute>	
	
	<jsp:body>
		<h2 class="text-center mt-4 mb-5">${pageTitle}</h2>
		<div class="container my-4 col-md-8 offset-md-4">
	
			<sf:form modelAttribute="user" action="${s:mvcUrl('UC#add').build()}" method="post">
			
				<div class="form-row">
					<div class="form-group col-md-4">				
						<sf:label for="email" path="email" cssClass="h5"><fmt:message key="user.email"/></sf:label>
						<sf:input path="email" cssClass="form-control" />
						<sf:errors cssClass="error" path="email" />
					</div>
					
					<div class="form-group col-md-2">
						<sf:label for="password" path="password" cssClass="h5"><fmt:message key="user.password"/></sf:label>
						<sf:password path="password" cssClass="form-control" />
						<sf:errors cssClass="error" path="password" />
					</div>	
				</div>
		
				<div class="form-row">
					<div class="form-group col-md-6">
						<sf:label for="name" path="name" cssClass="h5"><fmt:message key="user.name" /></sf:label>
						<sf:input path="name" cssClass="form-control" />
						<sf:errors cssClass="error" path="name" />
					</div>
				</div>
		
			  <%-- <div>
					<sf:label for="roles" path="roles">Permissões</sf:label>
					<sf:select path="roles" multiple="true" >
						<sf:option value="-" label="Selecione Uma Permissão" ></sf:option>
						<sf:options items="${user.roles }}" ></sf:options>
					</sf:select>
					<sf:errors cssClass="error" path="roles" />
				</div> --%>
				
				<input type="submit" value="${buttonSave}" class="btn btn-primary">
				<input type="reset" value="${buttonReset}" class="btn btn-primary">
				
			</sf:form>
		</div>
		
		<div class="container my-4" >	
			<h2 class="text-center my-4">${mangaList}</h2>
			<table class="table table-bordered table-hover">
				<thead class="thead-dark text-center">
					<tr>
						<th><fmt:message key="manga.title"/></th>
						<th><fmt:message key="manga.status"/></th>
						<th><fmt:message key="manga.notes"/></th>
						<th><fmt:message key="manga.lastchapter"/></th>
						<th><fmt:message key="manga.remove"/></th>
					</tr>
				</thead>		
				<c:forEach items="${mangas}" var="userManga">
					<tr>
						<td class="col-sm-2"><a	
								href="${s:mvcUrl('UMC#detail').arg(0, userManga.manga.title).arg(1, userManga.id).build()}">${userManga.manga.title}
							</a>
						</td>
						<td class="text-center col-sm-2">${userManga.manga.status}</td>
						<td class="col-sm-5">${userManga.notes}</td>
						<td class="text-center col-sm-2">${userManga.lastChapter}</td>
						<td class="text-center text-lowercase col-sm-2"><a	href="#" onclick="remove(${userManga.id}, this)"><fmt:message key="manga.remove"/></a></td>
					</tr>
				</c:forEach> 
			</table>	
		</div>		
	</jsp:body>
	
</tags:pageTemplate>