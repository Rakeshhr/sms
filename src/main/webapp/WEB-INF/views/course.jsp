<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>course Page</title>
</head>
<style>
h1	{
color:bule
	};
h2	{
color:bule
	};
</style>
<body bgcolor=#00CED1>
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
	
	
		<form:form action="course.html" method="post">
			<form:label path="courseid">Course Id</form:label>
			<form:input path="courseid"/>
			
			<form:label path="coursetitle">Course Title</form:label>
			<form:input path="coursetitle"/>			

			<form:label path="course">Course</form:label>
			<form:input path="course"/>	
					
			<input type="submit" value="Create"/>
			
		
		</form:form>
		
		<h2>Existing Course</h2>
		
		<c:if test="${not empty COURSELIST}">
			<table>
				<tr>
					<th>
						<td>Course Id</td>
						<td>Course Title</td>
						<td>Course</td>
						<td>Delete</td>
					</th>
				</tr>
				<c:forEach var="s" items="${COURSELIST}">
				<tr>
					<th>
						<td> <c:out value="${s.courseid}"/> </td>
						<td><c:out value="${s.coursetitle}"/></td>
						<td><c:out value="${s.course}"/></td>
						<td><a href="delete-${s.courseid}">delete</a></td>
					</th>
				</tr>	
				</c:forEach>				
			
			</table>
		
		
		</c:if>
		</section>
		</section>

</body>
</html>