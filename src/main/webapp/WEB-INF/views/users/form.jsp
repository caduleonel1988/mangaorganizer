<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<fmt:message key="user.form.page.title"  var="pageTitle"/>
<fmt:message key="user.button.save"  var="buttonSave"/>
<fmt:message key="user.button.reset"  var="buttonReset"/>

<tags:pageTemplate title="${pageTitle}">
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
					<table>
						<tr>
							<td><sf:label for="roles" path="roles">Permissões</sf:label></td>
							<td><sf:select path="roles" multiple="true" itemValue="name">
									<sf:options items="${roleList}" />
								</sf:select></td>
		
							<td>
							
							<sf:errors cssClass="error" path="roles" />
						</tr>
					</table>
				</div> --%>
				
				<input type="submit" value="${ buttonSave}" class="btn btn-primary">
				<input type="reset" value="${buttonReset}" class="btn btn-primary">
				
			</sf:form>
		</div>	
	</jsp:body> 
</tags:pageTemplate>	

>