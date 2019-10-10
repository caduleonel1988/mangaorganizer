<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<c:url value="/" var="contextPath"/>
<security:authentication property="principal" var="user"/>

<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark " >
	<a class="navbar-brand" href=""><fmt:message key="navigation.menu.home"/></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<li class="nav-item">
					<a class="nav-link" href="${s:mvcUrl('UC#form').build()}"><fmt:message key="navigation.menu.register.user"/></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${s:mvcUrl('MC#form').build()}"><fmt:message key="navigation.menu.register.manga"/></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="${s:mvcUrl('UC#list').build()}"><fmt:message key="navigation.menu.list.user"/></a></li>
			</security:authorize>
			
			<li class="nav-item">
				<a class="nav-link" href="${s:mvcUrl('MC#list').build() }"><fmt:message key="navigation.menu.list.manga"/></a>
			</li>
			<li><a href="?locale=pt_BR" rel="nofollow"><img alt="language-pt-Br" src="${contextPath}resources/images/brazil.png"></a></li>
			<li><a href="?locale=en_US" rel="nofollow"><img alt="language-en-Us" src="${contextPath}resources/images/united-states.png"></a></li>
			
		</ul>
		
		<ul class="nav navbar-nav ml-auto navbar-right">
			<li class="nav-item active">
				<a class="nav-link" 
					href="${s:mvcUrl('UAC#detail').arg(0,user.email).build()}">${user.email}
				</a> 
			</li>
			<li class="nav-item active"><a class="nav-link" href="${contextPath}logout">(logout)</a></li>	
		
		</ul>
	</div>
</nav>