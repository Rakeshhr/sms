
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ include file="home.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<section id="main-content">
     <section class="wrapper">
    
    	
    	 <%
    	 String err_msg=request.getParameter("errorMessage");

    	     if(err_msg!= null ){
    	 %>
    	  <script type="text/javascript" >
    	      alert("Error:No more Copies of Books");

    	   </script>
    	<%
    	  }
    	%>
    	 
    	 
     
     
     
     </script>
	 <div class="row">
          <div class="col-lg-12">
            <section class="panel">
              
              <div class="panel-body">
                <div class="form">
				  	
				  	
				  <h1>Search Book</h1>
		      	<div class="row">
		          <div class="col-lg-12">
		          
		          <section class="panel">
		          	<div class="panel-body">
                <div class="form">
				 <form class="form-validate form-horizontal" action="searchBook.html" method="post">
				 
				 	<div class="form-group ">
                      
                        Search by Book Title or category or Author Name<input class="form-control" name="searchKey1"  required="true" />
                      
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
    
		<c:if test="${not empty LIST2}"/> 

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
                 <c:forEach var="s" items="${LIST2}">
					<tr>
						<td> <c:out value="${s.ISBN}"/> </td>
						<td><c:out value="${s.category}"/></td>
						<td><c:out value="${s.title}"/></td>
						<td><c:out value="${s.authorName}"/></td>
						<td><c:out value="${s.mailID}"/></td>
 						<td><a href="<c:url value='/book1-${s.ISBN}'/>">Select</a></td>
					</tr>
				</c:forEach>
                </tbody>
              </table>
            </section>
          </div>
	</div>
				  	
        <h1>Search USN</h1>
      	<div class="row">
          <div class="col-lg-12">
          
          <section class="panel">
          	<div class="panel-body">
                <div class="form">
				 <form class="form-validate form-horizontal" action="searchUSN.html" method="post">
				 
				 	<div class="form-group ">
                      
                        Search by Student Name<input class="form-control" name="searchKey2"  required="true" />
                      
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
    
 		<c:if test="${not empty LIST1}"/> 

		<div class="col-sm-6">
            <section class="panel">
              <header class="panel-heading">Book Details</header>
              <table class="table">
                <thead>
                  <tr>
                    <th>USN</th>
                    <th>Name</th>
		    		<th></th>
                  </tr>
                </thead>
                <tbody>
                 <c:forEach var="s" items="${LIST1}">
					<tr>
						<td> <c:out value="${s.USN}"/> </td>
						<td><c:out value="${s.name}"/></td>
 						<td><a href="<c:url value='/book2-${s.USN}'/>">Select</a></td>
					</tr>
				</c:forEach>
                </tbody>
              </table>
            </section>
          </div>
	</div>
                    
         <form action="issueBook.html" method="post">
					<div class="form-group">
                      <div class="col-lg-offset-2 col-lg-10">
                        <button class="btn btn-primary" type="submit" onclick="myFunction()">Save</button>
                        <a href="cancel.html" class="btn btn-default" type="button">Cancel</a>
                      </div>
                    </div>							
					</form>				
                </div>

              </div>
            </section>
          </div>
        </div>	
	</section>
	</section>


