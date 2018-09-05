<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Page</title>
</head>
<body>

	<h1>Student Maintenance</h1>
	
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
			<form:label path="rollNo">Roll No</form:label>
			<form:input path="rollNo"/>
			
			<form:label path="firstName">First Name</form:label>
			<form:input path="firstName"/>			

			<form:label path="lastName">Last Name</form:label>
			<form:input path="lastName"/>		
			<input type="submit" value="Create"/>
		
		</form:form>
		
		<h2>Existing Students</h2>
		
		<c:if test="${not empty STUDENTLIST}">
			<table>
				<tr>
					<th>
						<td>Roll No</td>
						<td>First Name</td>
						<td>Last Name</td>
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

</body>
</html>