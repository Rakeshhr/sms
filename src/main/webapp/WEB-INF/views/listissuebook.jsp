<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of IssueBook</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css" />

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>



 
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



<!-- Custom styles -->
  <link href="static/css/style.css" rel="stylesheet">
  <link href="static/css/style-responsive.css" rel="stylesheet" />
  
  <script src="static/js/bootstrap.min.js"></script>
  <!-- nice scroll -->
  <script src="static/js/jquery.scrollTo.min.js"></script>


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

  <script src="static/js/moment.js"></script>

  <script type="text/javascript">

$(document).ready(function() {
	  $(function() {
	    $('#datetimepicker6').datetimepicker();
	    $('#datetimepicker7').datetimepicker({
	      useCurrent: false //Important! See issue #1075
	    });
	    $("#datetimepicker6").on("dp.change", function(e) {
	      $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
	    });
	    $("#datetimepicker7").on("dp.change", function(e) {
	      $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
	    });
	  });
	});


</script>

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



	<section id="main-content">
     <section class="wrapper">
	 <div class="row">
          <div class="col-lg-12">
            <section class="panel">
              
              <div class="panel-body">
                <div class="form">
				  	


      <div class='col-md-5'>
      <div class="form-group">
      <h3>Starting date</h3>
   
        <div class='input-group date' id='datetimepicker6'>
          <input type='text' class="form-control" />
          <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
          </span>
        </div>
      </div>
    </div>
    <div class='col-md-5'>
      <div class="form-group">
      <h3>Final date</h3>
        <div class='input-group date' id='datetimepicker7'>
          <input type='text' class="form-control" />
          <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
          </span>
        </div>
      </div>
    </div>
  
      
	      </div>
         </div>
        </section>
              
     </div>
    </div>
   </section>
  </section>
     
              
					<div class="form-group">
                      <div class="col-lg-offset-2 col-lg-10">
                        <button class="btn btn-primary" type="submit">Search</button>
                        <a href="cancel.html" class="btn btn-default" type="button">Cancel</a>
                      </div>
                    </div>							
									
							
</body>
</html>