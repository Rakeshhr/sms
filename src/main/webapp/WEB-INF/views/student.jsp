<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="home.jsp" %>

 <section id="main-content">
      <section class="wrapper">
	<h1>List Student Based on USN</h1>
	
	 <div class="row">
          <div class="col-lg-12">
            <section class="panel">
              <header class="panel-heading">
                Add Student
              </header>
              <div class="panel-body">
                <div class="form">
				<form:form class="form-validate form-horizontal" action="student.html" method="post">
					<div class="form-group">
						<label class="control-label col-lg-2">Roll No<span class="required">*</span></label><input type="text" name="rollNo"/>
					</div>
						<br>
					<div class="form-group ">
						<label class="control-label col-lg-2">First Name<span class="required">*</span></label><input type="text" name="firstName"/>
					</div>
						<br>
					<div class="form-group ">
						<label class="control-label col-lg-2">Last Name<span class="required">*</span></label><input type="text" name="lastName"/>
					</div>
					<br>				
					<input type="submit" value="Create"/>
				</form:form>
				</div>
				</div>
	</section>
	</div>
	</div>
			
		<h2>Existing Students</h2>
		
			<c:if test="${not empty STUDENTLIST}">
				<table>
					<tr>
						<th>
							<td>RollNO</td>
							<td>firstName</td>
							<td>lastName</td>
						</th>
					</tr>
					<c:forEach var="s" items="${STUDENTLIST}">
						<tr>
							<td> <c:out value="${s.rollNo}"/> </td>
							<td><c:out value="${s.firstName}"/></td>
							<td><c:out value="${s.lastName}"/></td>
						</tr>
					</c:forEach>				
			
				</table>
		
		
			</c:if>
		</section>
	</section>
	