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

<title>Book Page</title>
</head>
<body>
	 <section id="main-content">
      <section class="wrapper">
      <jsp:include page="home.jsp"> 
	<h1>Book Maintenance</h1>
	
	
        <div class="row">
          <div class="col-lg-12">
            <section class="panel">
              <header class="panel-heading">
                Book Maintenance
              </header>
              <div class="panel-body">
                <div class="form">
				  	<form:form class="form-validate form-horizontal" action="book.html" method="post">
				  	
				  	<div class="form-group ">
                      <form:label path="ISBN" class="control-label col-lg-2">ISBN <span class="required">*</span></form:label>
                      <div class="col-lg-5">
                        <form:input path="ISBN" class="form-control" minlength="5" maxlength="25" required="true"/>
                      </div>
                    </div>
				  	
				  	<div class="form-group ">
                      <form:label path="title" class="control-label col-lg-2">Title <span class="required">*</span></form:label>
                      <div class="col-lg-5">
                        <form:input path="title" class="form-control" minlength="5" maxlength="25" required="true"/>	
                      </div>
                    </div>
				  	<div class="form-group ">
                      <form:label path="price" class="control-label col-lg-2">Price <span class="required">*</span></form:label>
                      <div class="col-lg-5">
                        <form:input path="price" class="form-control" minlength="5" maxlength="25" required="true"/>	
                      </div>
                    </div>
				  	<div class="form-group ">
                      <form:label path="category" class="control-label col-lg-2">Category <span class="required">*</span></form:label>
                      <div class="col-lg-5">
                        <form:input path="category" class="form-control" minlength="5" maxlength="25" required="true"/>
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

		
		
		<h2>Existing Books</h2>
		
    <div class="row">
    
		<c:if test="${not empty BOOKLIST}"/>

		<div class="col-sm-6">
            <section class="panel">
              <header class="panel-heading">Book Details</header>
              <table class="table">
                <thead>
                  <tr>
                    <th>ISBN</th>
                    <th>Title</th>
                    <th>Price</th>
		    		<th>Category</th>
                  </tr>
                </thead>
                <tbody>
                 <c:forEach var="s" items="${BOOKLIST}">
					<tr>
						<td> <c:out value="${s.ISBN}"/> </td>
						<td><c:out value="${s.title}"/></td>
						<td><c:out value="${s.price}"/></td>
						<td><c:out value="${s.category}"/></td>
						<td><a href="<c:url value='/bookdel-${s.ISBN}'/>">Delete</a></td>
					</tr>
				</c:forEach>
                </tbody>
              </table>
            </section>
          </div>
	</div>
		</jsp:include>	
	</section>
	</section>
	
	
</body>
</html>