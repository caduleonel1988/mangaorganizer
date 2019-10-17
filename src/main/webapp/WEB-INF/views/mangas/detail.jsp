<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<fmt:message key="manga.detail.page.title" var="pageTitle"/>
<fmt:message key="manga.button.addtocollection"  var="buttonAddToCollection"/>
<fmt:message key="manga.button.modify"  var="buttonModify"/>
<fmt:message key="manga.button.remove"  var="buttonRemove"/>

<security:authorize access="hasRole('ROLE_ADMIN')" var="hasRole"/>

<tags:pageTemplate title="">
	
	<jsp:body>
		<h2 class="text-center mt-4 mb-5">${manga.title}</h2>
		<div class="container my-4 col-md-8 offset-md-4">
			
			<c:if test="${!hasRole }">
				<sf:form modelAttribute="manga" id="addManga" action="${s:mvcUrl('UAC#addManga').arg(0, manga.id).build() }" method="post" >
					<div class="form-row">
						<div class="form-group col-md-4">				
							<sf:label path="title" cssClass="h5" ><fmt:message key="manga.title"/></sf:label>
							<sf:input path="title" cssClass="form-control" readonly="true"/>
							<sf:errors path="title" cssClass="error" />
						</div>	
						
						<div class="form-group col-md-2">
							<sf:label for="status" path="status" cssClass="h5"><fmt:message key="manga.status"/></sf:label>
							<sf:select path="status" cssClass="form-control" readonly="true" items="${mangaStatus }"/>	
							<sf:errors cssClass="error" path="status"/>
						</div>		
					</div>	
					
					<div class="form-row">
						<div class="form-group col-md-2">
							<sf:label for="publicationDate" path="publicationDate" cssClass="h5"><fmt:message key="manga.publication"/></sf:label>
							<sf:input path="publicationDate" cssClass="form-control text-center" readonly="true"/>
							<sf:errors cssClass="error" path="publicationDate" />
						</div>
						
						<div class="form-group col-md-2" >
							<sf:label for="finalizationDate" path="finalizationDate" cssClass="h5"><fmt:message key="manga.finalization"/></sf:label>
							<sf:input path="finalizationDate" cssClass="form-control text-center" readonly="true"/>
							<sf:errors cssClass="error" path="finalizationDate" />
						</div>
	
						<div class="form-group col-md-2">
							<sf:label for="chapters" path="chapters" cssClass="h5"><fmt:message key="manga.chapters"/></sf:label>
							<sf:input path="chapters" cssClass="form-control text-center" readonly="true"/>
							<sf:errors cssClass="error" path="chapters" />
						</div>
				
					</div>
					
					<div class="form-row">
						<div class="form-group col-md-6">
							<sf:label for="chapters" path="chapters" cssClass="h5"><fmt:message key="manga.summary"/></sf:label>
							<sf:textarea path="summary" cssClass="form-control" readonly="true"/>
							<sf:errors cssClass="error" path="summary" />
						</div>					
					</div>		
					
					<input type="submit" value="${buttonAddToCollection }"  class="btn btn-primary">
				</sf:form>
			</c:if>
			
			<c:if test="${hasRole }">
				<sf:form modelAttribute="manga" id="addManga" action="${s:mvcUrl('MC#modifyManga').arg(0, manga.id).build() }" method="post" >
					<div class="form-row">
						<sf:input type="hidden" path="id" cssClass="form-control" />
						
						<div class="form-group col-md-4">				
							<sf:label path="title" cssClass="h5" ><fmt:message key="manga.title"/></sf:label>
							<sf:input path="title" cssClass="form-control" />
							<sf:errors path="title" cssClass="error" />
						</div>	
						
						<div class="form-group col-md-2">
							<sf:label for="status" path="status" cssClass="h5"><fmt:message key="manga.status"/></sf:label>
							<sf:select path="status" cssClass="form-control" items="${mangaStatus }"/>	
							<sf:errors cssClass="error" path="status"/>
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
							<sf:input path="chapters" cssClass="form-control text-center" />
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
					
					<input type="submit" value="${buttonModify }"  class="btn btn-primary">
				</sf:form>
			</c:if>
			
		</div>
	</jsp:body>
</tags:pageTemplate>