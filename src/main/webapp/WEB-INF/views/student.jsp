<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


 <section id="main-content">
      <section class="wrapper">
	<h1>List Student Based on USN</h1>
	
<!-- 	<form action="student.html" method="post"> -->
<!-- 		<label>Roll No</label><input type="text" name="rollNo"/> -->
<!-- 		<br> -->
<!-- 		<label>First Name</label><input type="text" name="firstName"/> -->
<!-- 		<br> -->
<!-- 		<label>Last Name</label><input type="text" name="lastName"/> -->
<!-- 		<br>				 -->
<!-- 		<input type="submit" value="Create"/> -->
<!-- 	</form> -->
	
	
		<form:form action="student.html" method="post">
			<form:label path="USN">USN</form:label>
			<form:input path="USN"/>
				
			<input type="submit" value="Submit"/>
		
		</form:form>
		
		<h2>Existing Students</h2>
		
		<c:if test="${not empty STUDENTLIST}">
			<table>
				<tr>
					<th>
						<td>Book Title</td>
						<td>Name</td>
						<td>Return Date</td>
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
