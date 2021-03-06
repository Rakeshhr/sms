<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="home.jsp" %>


	 <section id="main-content">
      <section class="wrapper">
     
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
                      <form:label path="title" class="control-label col-lg-2">Title <span class="required">*</span></form:label>
                      <div class="col-lg-5">
                        <form:input path="title" class="form-control"  required="true"/>	
                      </div>
                    </div>
				  	
				  	<div class="form-group ">
                      <form:label path="category" class="control-label col-lg-2">Category <span class="required">*</span></form:label>
                      <div class="col-lg-5">
                        <form:input path="category" class="form-control"  required="true"/>
                      </div>
                    </div>     
                    
                    <div class="form-group ">
                      <form:label path="authorName" class="control-label col-lg-2">Author Name <span class="required">*</span></form:label>
                      <div class="col-lg-5">
                        <form:input path="authorName" class="form-control"  required="true"/>
                      </div>
                    </div>               
                    
                    <div class="form-group ">
                      <form:label path="mailID" class="control-label col-lg-2">Author MailID <span class="required">*</span></form:label>
                      <div class="col-lg-5">
                        <form:input path="mailID" class="form-control"  required="true"/>
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
		    		<th>Category</th>
		    		<th>Author Name</th>
		    		<th>Author MailID</th>
		    		<th></th>
                  </tr>
                </thead>
                <tbody>
                 <c:forEach var="s" items="${BOOKLIST}">
					<tr>
						<td> <c:out value="${s.ISBN}"/> </td>
						<td><c:out value="${s.category}"/></td>
						<td><c:out value="${s.title}"/></td>
						<td><c:out value="${s.authorName}"/></td>
						<td><c:out value="${s.mailID}"/></td>
<%-- 						<td><a href="<c:url value='/bookdel-${s.ISBN}'/>">Delete</a></td> --%>
					</tr>
				</c:forEach>
                </tbody>
              </table>
            </section>
          </div>
	</div>
		
	</section>
	</section>
	
	
