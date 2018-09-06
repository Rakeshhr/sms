<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Page</title>
</head>
<body>
	
	<h1>Book Maintenance</h1>
	<form:form action="book.html" method="post">
			<form:label path="ISBN">ISBN</form:label>
			<form:input path="ISBN"/>
			
			<form:label path="title">Title</form:label>
			<form:input path="title"/>			

			<form:label path="price">Price</form:label>
			<form:input path="price"/>	
				
			<form:label path="category">Category</form:label>
			<form:input path="category"/>		
			<input type="submit" value="Create"/>
		
		</form:form>
		
		
		<h2>Existing Books</h2>
		
		<c:if test="${not empty BOOKLIST}">
			<table>
				<tr>
					<th>
						<td>ISBN</td>
						<td>TITLE</td>
						<td>PRICE</td>
						<td>CATEGORY</td>
					</th>
				</tr>
				<c:forEach var="s" items="${BOOKLIST}">
					<tr>
						<td> <c:out value="${s.ISBN}"/> </td>
						<td><c:out value="${s.title}"/></td>
						<td><c:out value="${s.price}"/></td>
						<td><c:out value="${s.category}"/></td>
						<%-- <td><a href="/book/del/${s.ISBN}">Delete</a></td> --%>
						<td><a href="<c:url value='/bookdel-${s.ISBN}'/>">Delete</a></td>
					</tr>
				</c:forEach>				
			
			</table>
		
		
		</c:if>
		
</body>
</html>