<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<fmt:message key="manga.form.page.title"  var="pageTitle"/>
<fmt:message key="manga.button.save"  var="buttonSave"/>
<fmt:message key="manga.button.reset"  var="buttonReset"/>


<tags:pageTemplate title="${pageTitle }">
	<jsp:body>
		<h2 class="text-center my-5">${pageTitle}</h2>
		<div class="container my-4 col-md-8 offset-md-4">
					
			<sf:form modelAttribute="manga" action="${s:mvcUrl('MC#add').build()}"	method="POST">
				
				<div class="form-row">
					<div class="form-group col-md-4">
						<sf:label for="title" path="title" cssClass="h5"><fmt:message key="manga.title"/></sf:label>
						<sf:input path="title" cssClass="form-control" />
						<sf:errors cssClass="error" path="title" />
					</div>
		
					 <div class="form-group col-md-2">
						<sf:label for="status" path="status" cssClass="h5"><fmt:message key="manga.status"/></sf:label>
						<sf:select path="status" items="${mangaStatus}" cssClass="form-control"/>
						<sf:errors cssClass="error" path="status" />
					</div>
				</div>
				
				<div class="form-row">
					<div class="form-group col-md-2">
						<sf:label for="publicationDate" path="publicationDate" cssClass="h5"><fmt:message key="manga.publication"/></sf:label>
						<sf:input path="publicationDate" cssClass="form-control text-center" />
						<sf:errors cssClass="error" path="publicationDate" />
					</div>
					
					<div class="form-group col-md-2" >
						<sf:label for="finalizationDate" path="finalizationDate" cssClass="h5"><fmt:message key="manga.finalization"/></sf:label>
						<sf:input path="finalizationDate" cssClass="form-control text-center" />
						<sf:errors cssClass="error" path="finalizationDate" />
					</div>

					<div class="form-group col-md-2">
						<sf:label for="chapters" path="chapters" cssClass="h5"><fmt:message key="manga.chapters"/></sf:label>
						<sf:input path="chapters" cssClass="form-control text-center"/>
						<sf:errors cssClass="error" path="chapters" />
					</div>
			
				</div>
				
				<div class="form-row">
					<div class="form-group col-md-6">
						<sf:label for="chapters" path="chapters" cssClass="h5"><fmt:message key="manga.summary"/></sf:label>
						<sf:textarea path="summary" cssClass="form-control"/>
						<sf:errors cssClass="error" path="summary" />
					</div>					
				</div>
					
				<input type="submit" value="${buttonSave }" class="btn btn-primary">
				<input type="reset" value="${buttonReset }" class="btn btn-primary">
			</sf:form>
			
		</div>
		</jsp:body>

</tags:pageTemplate>
