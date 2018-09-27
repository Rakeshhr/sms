<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ include file="home.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<section id="main-content">
      <section class="wrapper">
      	
      	<h1>Search Book</h1>
      	<div class="row">
          <div class="col-lg-12">
          
          <section class="panel">
          	<div class="panel-body">
                <div class="form">
				 <form class="form-validate form-horizontal" action="search.html" method="post">
				 
				 	<div class="form-group ">
                      
                        Search by Book Title or category or Author Name<input class="form-control" name="searchKey"  required="true" />
                      
                    </div>
                    
                    
                    <div class="form-group">
                      <div class="col-lg-offset-2 col-lg-10">
                      <button class="btn btn-primary" type="submit">Search</button>
                     </div>
                    </div>							
									
							
						
				</form>
                </div>

              </div>
            </section>
          </div>
        </div>	
        
        <div class="row">
    
 		<c:if test="${not empty LIST}"/> 

		<div class="col-sm-6">
            <section class="panel">
              <header class="panel-heading">Book Details</header>
              <table class="table">
                <thead>
                  <tr>
                    <th>ISBN</th>
                    <th>Category</th>
                    <th>Title</th>
		    		<th>Author Name</th>
		    		<th>Author MailID</th>
		    		<th></th>
                  </tr>
                </thead>
                <tbody>
                 <c:forEach var="s" items="${LIST}">
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
        
                      
                      
                      
                      
                      
                      
