<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:url value="/" var="contextPath"/>
<script type="text/javascript" src="${contextPath}resources/js/jquery.js"></script>
<script type="text/javascript" src="${contextPath}resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${contextPath}resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${contextPath}resources/css/bootstrap-theme.min.css">
</head>
<body>
	
	<div class="container">
        <div class="row">
			<div class="col-md-5 mx-auto mt-5">
				<div id="first">
					<div class="myform form ">
						 <div class="logo mb-3">
							 <div class="col-md-12 text-center">
								 <h2 class="mt-5 mb-5">Login - Manga Organizer</h2>
							 </div>
						</div>
                   		<sf:form servletRelativeAction="/login" method="post" name="login">
                         	<div class="form-group">
                            	<label for="exampleInputEmail1">Email</label>
                              	<input type="email" name="username"  class="form-control" aria-describedby="emailHelp" />
                           </div>
                           <div class="form-group">
                           		<label for="exampleInputEmail1">Password</label>
                              	<input type="password" name="password"   class="form-control" aria-describedby="emailHelp"  />
                           </div>
                           <div class="form-group">
                              <p class="text-center">By signing up you accept our <a href="#">Terms Of Use</a></p>
                           </div>
                           <div class="col-md-12 text-center ">
                              <button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">Login</button>
                           </div>
                           
                        </sf:form>
					</div>
				</div>
			</div>
		</div>
	</div> 

</body>
</html>