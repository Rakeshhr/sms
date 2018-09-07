<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap CSS -->
  <link href="static/css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="static/css/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="static/css/elegant-icons-style.css" rel="stylesheet" />
  <link href="static/css/font-awesome.min.css" rel="stylesheet" />
  <!-- Custom styles -->
  <link href="static/css/style.css" rel="stylesheet">
  <link href="static/css/style-responsive.css" rel="stylesheet" />

<title>SignUp Page</title>
</head>
<body>

	 <div class="row">
          <div class="col-lg-12">
            <section class="panel">
              <header class="panel-heading">
                SignUp Page
              </header>
              <div class="panel-body">
                <div class="form">
				  	<form:form class="form-validate form-horizontal" action="createuser.html" method="post" modelAttribute="user">
				  	
				  	<div class="form-group ">
                      <form:label path="firstName" class="control-label col-lg-2">FirstName <span class="required">*</span></form:label>
                      <div class="col-lg-5">
                        <form:input path="firstName" class="form-control" minlength="5" maxlength="25" required="true"/>
                      </div>
                    </div>
				  	
				  	<div class="form-group ">
                      <form:label path="lastName" class="control-label col-lg-2">LastName <span class="required">*</span></form:label>
                      <div class="col-lg-5">
                        <form:input path="lastName" class="form-control" minlength="5" maxlength="25" required="true"/>	
                      </div>
                    </div>
				  	<div class="form-group ">
                      <form:label path="email" class="control-label col-lg-2">Email <span class="required">*</span></form:label>
                      <div class="col-lg-5">
                        <form:input path="email" class="form-control" minlength="5" maxlength="25" required="true"/>	
                      </div>
                    </div>
				  	<div class="form-group ">
                      <form:label path="mobNo" class="control-label col-lg-2">MobNo <span class="required">*</span></form:label>
                      <div class="col-lg-5">
                        <form:input path="mobNo" class="form-control" minlength="5" maxlength="25" required="true"/>
                      </div>
                    </div> 
                    	<div class="form-group ">
                      <form:label path="password" class="control-label col-lg-2">Password <span class="required">*</span></form:label>
                      <div class="col-lg-5">
                        <form:input path="password" class="form-control" minlength="5" maxlength="25" required="true"/>
                      </div>
                    </div>                                              							
							
					<div class="form-group">
                      <div class="col-lg-offset-2 col-lg-10">
                        <button class="btn btn-primary" type="submit">Save</button>
                        <button class="btn btn-default" type="button">Cancel</button>
                      </div>
                    </div>							
									
							
						
				</form:form>
                </div>

              </div>
            </section>
          </div>
        </div>	
	

</body>
</html>