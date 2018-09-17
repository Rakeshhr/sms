<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <!-- Bootstrap CSS -->
  <link href="static/css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="static/css/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="static/css/elegant-icons-style.css" rel="stylesheet" />
  <link href="static/css/font-awesome.min.css" rel="stylesheet" />
  
 
  <link rel="stylesheet" href="css/owl.carousel.css" type="text/css">
  <link href="static/css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
  <!-- Custom styles -->
  <link rel="stylesheet" href="css/fullcalendar.css">
  <link href="static/css/widgets.css" rel="stylesheet">
  <link href="static/css/style.css" rel="stylesheet">
  <link href="static/css/style-responsive.css" rel="stylesheet" />
  <link href="static/css/xcharts.min.css" rel=" stylesheet">
  <link href="static/scss/jquery-ui-1.10.4.min.css" rel="stylesheet">
</head>
<body>

	<section id="container" class="">
		<header class="header dark-bg">
		 	 <div class="toggle-nav">
        		<div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
      			</div>
      		 <!--logo start-->
      		<a href="home.html" class="logo">CRUDS <span class="lite">INFOTECH</span></a>
      		<!--logo end-->
     <div class="top-nav notification-row">
     
      <div class="nav search-row" id="top_menu">
        <!--  search form start -->
        <ul class="nav top-menu">
          <li>
            <form class="navbar-form">
            <span>Search here</span>
              <input class="form-control" placeholder="Search" type="text">
            </form>
          </li>
        </ul>
        <!--  search form end -->
      </div>
        	
        <ul class="nav pull-right top-menu">
        	
       		 		
      				<a href="#">
            			<span class="profile-ava">
              			<img alt="" src="static/img/avatar1_small.jpg">
            			</span>
         				<span class="username">Hii ${uname}</span>
            			<b class="caret"></b>
            		</a>
            		
						<div class="log-arrow-up"></div>
						
						
						<a href="logout.html"> Log Out</a>
						
					</ul>	
				
		
       
       </div>
            
       </header>
        <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
       <ul class="sidebar-menu">
        	<li class="active">
            <a class="" href="book.html">
                          <i class="icon_house_alt"></i>
                          <span>Add a Book</span>
            </a>
            </li>
			<li>		  
			<a class="" href="issueBook.html">
                          <i class="icon_book_alt"></i>
                          <span>Issue Book</span>
            </a>
            </li>
            <li>
			<a class="" href="course.html">
                          <i class="icon_book_alt"></i>
                          <span>course</span>
            </a>
		</li>
		
		 
        </ul>
      </div>
    </aside>
    </section>

</body>
</html>