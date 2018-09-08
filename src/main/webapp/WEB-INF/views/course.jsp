<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="home.jsp" %>

<section id="main-content">
      <section class="wrapper">

	<h1>Course Maintenance</h1>
	
<!-- 	<form action="course.html" method="post"> -->
<!-- 		<label>Course Id</label><input type="text" name="courseid"/> -->
<!-- 		<br> -->
<!-- 		<label>Course Title</label><input type="text" name="coursetitle"/> -->
<!-- 		<br> -->
<!-- 		<label>Course</label><input type="text" name="Course"/> -->
<!-- 		<br>				 -->
<!-- 		<input type="submit" value="Create"/> -->
<!-- 	</form> -->
	
	
		 <div class="row">
          <div class="col-lg-12">
            <section class="panel">
              <header class="panel-heading">
                Book Maintenance
              </header>
              <div class="panel-body">
                <div class="form">
				  	<form:form class="form-validate form-horizontal" action="course.html" method="post">
				  	
				  	<div class="form-group ">
                      <form:label path="courseid" class="control-label col-lg-2">course id <span class="required">*</span></form:label>
                      <div class="col-lg-5">
                        <form:input path="courseid" class="form-control" minlength="5" maxlength="25" required="true"/>
                      </div>
                    </div>
				  	
				  	<div class="form-group ">
                      <form:label path="coursetitle" class="control-label col-lg-2">course Title <span class="required">*</span></form:label>
                      <div class="col-lg-5">
                        <form:input path="coursetitle" class="form-control" minlength="5" maxlength="25" required="true"/>	
                      </div>
                    </div>
				  	<div class="form-group ">
                      <form:label path="course" class="control-label col-lg-2">course <span class="required">*</span></form:label>
                      <div class="col-lg-5">
                        <form:input path="course" class="form-control" minlength="5" maxlength="25" required="true"/>	
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
    
		<c:if test="${not empty COURSELIST}">


		<div class="col-sm-6">
            <section class="panel">
              <header class="panel-heading">Book Details</header>
              <table class="table">
                <thead>
                  <tr>
                    <th>Course Id</th>
                    <th>Course Title</th>
                    <th>Course</th>
		    		<th>Delete</th>
                  </tr>
                </thead>
                <tbody>
                 <c:forEach var="s" items="${COURSELIST}">
					<tr>
						<td> <c:out value="${s.courseid}"/> </td>
						<td><c:out value="${s.coursetitle}"/></td>
						<td><c:out value="${s.course}"/></td>
						<td><a href="delete-${s.courseid}">delete</a></td>
					</tr>
				</c:forEach>
                </tbody>
              </table>
            </section>
          </div>
          		</c:if>
	</div>
		


		</section>
		</section>

