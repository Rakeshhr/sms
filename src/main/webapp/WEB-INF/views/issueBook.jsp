<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="home.jsp" %>
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

<title>Issue Book Page</title>
</head>
<body>
	 <section id="main-content">
      <section class="wrapper">
	 <div class="row">
          <div class="col-lg-12">
            <section class="panel">
              
              <div class="panel-body">
                <div class="form">
				  	<form:form class="form-validate form-horizontal" action="issueBook.html" method="post" >
				  	
				  	<div class="form-group ">
                      <form:label path="USN" name="USN" class="control-label col-lg-2">USN <span class="required">*</span></form:label>
                      <div class="col-lg-5">
                        <form:input path="USN" class="form-control" minlength="3" maxlength="25" required="true"/>
                        <a href="student.html"><i class="fa fa-search"></i></a>
                      </div>
                    </div>
				  	
				  	

				  
                    	<div class="form-group ">
                      <form:label path="ISBN" name="ISBN" class="control-label col-lg-2">ISBN <span class="required">*</span></form:label>
                      <div class="col-lg-5">
                        <form:input path="ISBN" class="form-control" minlength="5" maxlength="25" required="true"/>
                        <a href="book.html"><i class="fa fa-search"></i></a>
                      </div>
                    </div>
                    
          
					<div class="form-group">
                      <div class="col-lg-offset-2 col-lg-10">
                        <button class="btn btn-primary" type="submit">Save</button>
                        <a href="cancel.html" class="btn btn-default" type="button">Cancel</a>
                      </div>
                    </div>							
									
				</form:form>
                </div>

              </div>
            </section>
          </div>
        </div>	
	</section>
	</section>

</body>
</html>