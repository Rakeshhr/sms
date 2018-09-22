<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
 
  <!-- Bootstrap CSS -->
  <link href="static/css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="static/css/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="static/css/elegant-icons-style.css" rel="stylesheet" />
  <link href="static/css/font-awesome.min.css" rel="stylesheet" />
  <link href="static/css/daterangepicker.css" rel="stylesheet" />
  <link href="static/css/bootstrap-datepicker.css" rel="stylesheet" />
  <link href="static/css/bootstrap-colorpicker.css" rel="stylesheet" />
  <!-- date picker -->

  <!-- color picker -->

  <!-- Custom styles -->
  <link href="static/css/style.css" rel="stylesheet">
  <link href="static/css/style-responsive.css" rel="stylesheet" />
  
    <script src="static/js/jquery.js"></script>
  <script src="static/js/bootstrap.min.js"></script>
  <!-- nice scroll -->
  <script src="static/js/jquery.scrollTo.min.js"></script>
  <script src="static/js/jquery.nicescroll.js" type="text/javascript"></script>

  <!-- jquery ui -->
  <script src="static/js/jquery-ui-1.9.2.custom.min.js"></script>

  <!--custom checkbox & radio-->
  <script type="text/javascript" src="static/js/ga.js"></script>
  <!--custom switch-->
  <script src="static/js/bootstrap-switch.js"></script>
  <!--custom tagsinput-->
  <script src="static/js/jquery.tagsinput.js"></script>

  <!-- colorpicker -->

  <!-- bootstrap-wysiwyg -->
  <script src="static/js/jquery.hotkeys.js"></script>
  <script src="static/js/bootstrap-wysiwyg.js"></script>
  <script src="static/js/bootstrap-wysiwyg-custom.js"></script>
  <script src="static/js/moment.js"></script>
  <script src="static/js/bootstrap-colorpicker.js"></script>
  <script src="static/js/daterangepicker.js"></script>
  <script src="static/js/bootstrap-datepicker.js"></script>
  <!-- ck editor -->
  <script type="text/javascript" src="static/assets/ckeditor/ckeditor.js"></script>
 
  <!-- custome script for all page -->
  <script src="static/js/scripts.js"></script>
   <!-- custom form component script for this page-->
 <!--  <script src="static/js/form-component.js"></script> -->


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
			<a class="" href="search.html">
                          <i class="icon_book_alt"></i>
                          <span>Search a Book</span>
            </a>
			</li>
		
			<li>
			<a class="" href="listissuebook.html">
                          <i class="icon_book_alt"></i>
                          <span>List of IssueBook</span>
            </a>
			</li>
		 
        </ul>
      </div>
    </aside>
    </section>

</body>
</html>