<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    
    <title>sysprod authentification</title>
    <meta name="description" content="">
    <meta name="author" content="">
    
	<!-- http://davidbcalhoun.com/2010/viewport-metatag -->
	<meta name="HandheldFriendly" content="True">
	<meta name="MobileOptimized" content="320">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<!--// OPTIONAL & CONDITIONAL CSS FILES //-->   
	<!-- date picker css -->
	<link rel="stylesheet" href="../css/datepicker.css?v=1">
	<!-- full calander css -->
	<link rel="stylesheet" href="../css/fullcalendar.css?v=1">
	<!-- data tables extended CSS -->
	<link rel="stylesheet" href="../css/TableTools.css?v=1">
	<!-- bootstrap wysimhtml5 editor -->
	<link rel="stylesheet" href="../css/bootstrap-wysihtml5.css?v=1">
	<link rel="stylesheet" href="../css/wysiwyg-color.css">
	<!-- custom/responsive growl messages -->
	<link rel="stylesheet" href="../css/toastr.custom.css?v=1">
	<link rel="stylesheet" href="../css/toastr-responsive.css?v=1">
	<link rel="stylesheet" href="../css/jquery.jgrowl.css?v=1">
	
	<!-- // DO NOT REMOVE OR CHANGE ORDER OF THE FOLLOWING // -->
	<!-- bootstrap default css (DO NOT REMOVE) -->
	<link rel="stylesheet" href="../css/bootstrap.min.css?v=1">
	<link rel="stylesheet" href="../css/bootstrap-responsive.min.css?v=1">
	<!-- font awsome and custom icons -->
	<link rel="stylesheet" href="../css/font-awesome.min.css?v=1">
	<link rel="stylesheet" href="../css/cus-icons.css?v=1">
	<!-- jarvis widget css -->
	<link rel="stylesheet" href="../css/jarvis-widgets.css?v=1">
	<!-- Data tables, normal tables and responsive tables css -->
	<link rel="stylesheet" href="../css/DT_bootstrap.css?v=1">
	<link rel="stylesheet" href="../css/responsive-tables.css?v=1">
	<!-- used where radio, select and form elements are used -->
	<link rel="stylesheet" href="../css/uniform.default.css?v=1">
	<link rel="stylesheet" href="../css/select2.css?v=1">
	<!-- main theme files -->
	<link rel="stylesheet" href="../css/theme.css?v=1">
	<link rel="stylesheet" href="css/theme-responsive.css?v=1">
    
	<!-- // THEME CSS changed by javascript: the CSS link below will override the rules above // -->
	<!-- For more information, please see the documentation for "THEMES" -->
    <link rel="stylesheet" id="switch-theme-js" href="../css/themes/default.css?v=1">   
	
   	<!-- To switch to full width -->
    <link rel="stylesheet" id="switch-width" href="../css/full-width.css?v=1">
    
	<!-- Webfonts -->
	<link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Lato:300,400,700' type='text/css'>

	<!-- Print Invoice CSS -->
	<link rel="stylesheet" href="../css/print-invoice.css">
	
	<!-- All javascripts are located at the bottom except for HTML5 Shim -->
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
   		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
   		<script src=../js/include/respond.min.js"></script>
   	<![endif]-->

	<!-- For Modern Browsers -->
	<link rel="shortcut icon" href="../img/favicons/favicon.png">
	<!-- For everything else -->
	<link rel="shortcut icon" href="../img/favicons/favicon.ico">
	<!-- For retina screens -->
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="./img/favicons/apple-touch-icon-retina.png">
	<!-- For iPad 1-->
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="./img/favicons/apple-touch-icon-ipad.png">
	<!-- For iPhone 3G, iPod Touch and Android -->
	<link rel="apple-touch-icon-precomposed" href="./img/favicons/apple-touch-icon.png">
	
	<!-- iOS web-app metas -->
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<!-- Add your custom home screen title: -->
	<meta name="apple-mobile-web-app-title" content="Jarvis"> 

	<!-- Startup image for web apps -->
	<link rel="apple-touch-startup-image" href="./img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
	<link rel="apple-touch-startup-image" href="./img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
	<link rel="apple-touch-startup-image" href="img/splash/iphone.png" media="screen and (max-device-width: 320px)">
	
  </head>

  <body>
  	<!-- .height-wrapper -->
	<div class="height-wrapper">
				
		<!-- header -->
		<header>
			<!-- tool bar -->
			<div id="header-toolbar" class="container-fluid">
				<!-- .contained -->
				<div class="contained">
					
					<!-- theme name -->
					<h1> <span class="hidden-phone">Sysprod - Authentification</span> </h1>
					<!-- end theme name -->
					
					<!-- span4 -->
					<div class="pull-right">
						<!-- demo theme switcher-->
						<div id="theme-switcher" class="btn-toolbar">
							
							<!-- search and log off button for phone devices -->
							<div class="btn-group pull-right visible-phone">
								<a href="javascript:void(0)" class="btn btn-inverse btn-small"><i class="icon-search"></i></a>
								<a href="login.html" class="btn btn-inverse btn-small"><i class="icon-off"></i></a>
							</div>
							<!-- end buttons for phone device -->
							
							<!-- theme dropdown -->
							
							<!-- end theme dropdown-->
							
						</div>
					  	<!-- end demo theme switcher-->
					</div>
					<!-- end span4 -->
				</div>
				<!-- end .contained -->
			</div>
			<!-- end tool bar -->
			
		</header>
		<!-- end header -->	
			<div id="login-logo">
				
			</div>
			<div class="jarviswidget login">
				<header>
					<h2>Connectez-vous : </h2>
				</header>
				
					<div class="widget alert alert-info adjusted">
						<i class="cus-exclamation"></i>
						<strong>Entrez vos identifiants de connection</strong>
					</div>
					<!-- content goes here -->
					<div id="main-content">
						
						<form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
							<div class="control-group">
                                                           <input  class="input-block-level" autofocus type="ext" class="text_" name="j_username" id="username" >
							</div>
							<div class="control-group">
								<input type="password" class="input-block-level" autofocus  class='text_' name='j_password' id='password'>
							</div>
                                                  <div class="widget alert alert-info adjusted">
                                                    <label for='remember_me'>Remember me</label>
                                                    <input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me'
                                                           <g:if test='${hasCookie}'>checked='checked'</g:if> />
                                                  </div>
							<div class="control-group no-border">
								<div style="text-align: right;">
									<input class="btn btn-primary" type="submit" value="Login" id="login_button">
								</div>
							</div>
						</form>
						
					</div>
					<!-- end content goes here -->
						
			</div>
		
	</div>
	<!-- end .height-wrapper -->	
	
	<!-- footer -->
	
	<!-- if you like you can insert your footer here -->
	
	<!-- end footer -->

    <!--================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../js/libs/jquery.min.js"><\/script>')</script>
    	<!-- OPTIONAL: Use this migrate scrpit for plugins that are not supported by jquery 1.9+ -->
		<!-- DISABLED <script src=../js/libs/jquery.migrate-1.0.0.min.js"></script> -->
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
    <script>window.jQuery.ui || document.write('<script src="../js/libs/jquery.ui.min.js"><\/script>')</script>
    
    <!-- IMPORTANT: Jquery Touch Punch is always placed under Jquery UI -->
    <script src="../js/include/jquery.ui.touch-punch.min.js"></script>
    
    <!-- REQUIRED: Mobile responsive menu generator -->
	<script src="../js/include/selectnav.min.js"></script>

	<!-- REQUIRED: Datatable components -->
    <script src="../js/include/jquery.accordion.min.js"></script>

	<!-- REQUIRED: Toastr & Jgrowl notifications  -->
    <script src="../js/include/toastr.min.js"></script>
    <script src="../js/include/jquery.jgrowl.min.js"></script>
    
    <!-- REQUIRED: Sleek scroll UI  -->
    <script src="../js/include/slimScroll.min.js"></script>
	
	<!-- REQUIRED: Datatable components -->
	<script src="../js/include/jquery.dataTables.min.js"></script> 
	<script src="../js/include/DT_bootstrap.min.js"></script> 

    <!-- REQUIRED: Form element skin  -->
    <script src="../js/include/jquery.uniform.min.js"></script> 

	<!-- REQUIRED: AmCharts  -->
    <script src="../js/include/amchart/amcharts.js"></script>
	<script src=../js/include/amchart/amchart-draw1.js"></script>
	    
	<script type="text/javascript">
		var ismobile = (/iphone|ipad|ipod|android|blackberry|mini|windows\sce|palm/i.test(navigator.userAgent.toLowerCase()));	
	    if(!ismobile){
	    	
	    	/** ONLY EXECUTE THESE CODES IF MOBILE DETECTION IS FALSE **/
	    	
	    	/* REQUIRED: Datatable PDF/Excel output componant */
	    	
	    	document.write('<script src=../js/include/ZeroClipboard.min.js"><\/script>'); 
	    	document.write('<script src=../js/include/TableTools.min.js"><\/script>'); 
	    	document.write('<script src=../js/include/select2.min.js"><\/script>'); 
	    	document.write('<script src=../js/include/jquery.excanvas.min.js"><\/script>');  
	    	document.write('<script src=../js/include/jquery.placeholder.min.js"><\/script>');  
			
			/** DEMO SCRIPTS **/
	        $(function() {
	            /* jarvis tooltips */
				$.jGrowl("No authentication is needed <strong>press</strong> on <strong>Sign in</strong> to continue...", { 
					header: 'Hey there stranger!', 
					sticky: false,
					life: 5000,
					speed: 500,
					theme: 'with-icon',
					position: 'top-right', //this is default position
					easing: 'easeOutBack',
					animateOpen: { 
						height: "show"
					},
					animateClose: { 
						opacity: 'hide' 
					}
				});	
	        });
	        
	    }else{
	    	
	    	/** ONLY EXECUTE THESE CODES IF MOBILE DETECTION IS TRUE **/
	    	
	    	document.write('<script src=../js/include/responsive-tables.min.js"><\/script>');
	    }
	</script>

	<!-- REQUIRED: iButton -->
    <script src=../js/include/jquery.ibutton.min.js"></script>
	
	<!-- REQUIRED: Justgage animated charts -->
	<script src=../js/include/raphael.2.1.0.min.js"></script>
    <script src=../js/include/justgage.min.js"></script>
    
    <!-- REQUIRED: Morris Charts -->
    <script src=../js/include/morris.min.js"></script> 
    <script src=../js/include/morris-chart-settings.js"></script> 
    
    <!-- REQUIRED: Animated pie chart -->
    <script src=../js/include/jquery.easy-pie-chart.min.js"></script>
    
    <!-- REQUIRED: Functional Widgets -->
    <script src=../js/include/jarvis.widget.min.js"></script>
    <script src=../js/include/mobiledevices.min.js"></script>
    <!-- DISABLED (only needed for IE7 <script src=../js/include/json2.js"></script> -->
	
	<!-- REQUIRED: Full Calendar -->
    <script src=../js/include/jquery.fullcalendar.min.js"></script>		
    
    <!-- REQUIRED: Flot Chart Engine -->
    <script src=../js/include/jquery.flot.cust.min.js"></script>			
    <script src=../js/include/jquery.flot.resize.min.js"></script>		
    <script src=../js/include/jquery.flot.tooltip.min.js"></script>		
    <script src=../js/include/jquery.flot.orderBar.min.js"></script> 	
    <script src=../js/include/jquery.flot.fillbetween.min.js"></script>	
    <script src=../js/include/jquery.flot.pie.min.js"></script> 	 
    
    <!-- REQUIRED: Sparkline Charts -->
    <script src=../js/include/jquery.sparkline.min.js"></script>

	<!-- REQUIRED: Infinite Sliding Menu (used with inbox page) -->
	<script src=../js/include/jquery.inbox.slashc.sliding-menu.js"></script> 

	<!-- REQUIRED: Form validation plugin -->
    <script src=../js/include/jquery.validate.min.js"></script>
    
    <!-- REQUIRED: Progress bar animation -->
    <script src=../js/include/bootstrap-progressbar.min.js"></script>
    
    <!-- REQUIRED: wysihtml5 editor -->
    <script src=../js/include/wysihtml5-0.3.0.min.js"></script>
    <script src=../js/include/bootstrap-wysihtml5.min.js"></script>

	<!-- REQUIRED: Masked Input -->
    <script src=../js/include/jquery.maskedinput.min.js"></script>
    
    <!-- REQUIRED: Bootstrap Date Picker -->
    <script src=../js/include/bootstrap-datepicker.min.js"></script>

    <!-- REQUIRED: Bootstrap Wizard -->
    <script src=../js/include/bootstrap.wizard.min.js"></script> 
    
	<!-- REQUIRED: Bootstrap Color Picker -->
    <script src=../js/include/bootstrap-colorpicker.min.js"></script>

    
	<!-- REQUIRED: Bootstrap Time Picker -->
    <script src=../js/include/bootstrap-timepicker.min.js"></script> 
    
    <!-- REQUIRED: Bootstrap Prompt -->
    <script src=../js/include/bootbox.min.js"></script>
    
    <!-- REQUIRED: Bootstrap engine -->
    <script src=../js/include/bootstrap.min.js"></script>
    
    <!-- DO NOT REMOVE: Theme Config file -->
    <script src=../js/config.js"></script>
    
    <!-- d3 library placed at the bottom for better performance -->
    <!-- DISABLED  <script src=../js/include/d3.v3.min.js"></script> -->
    <!-- DISABLED  <script src=../js/include/adv_charts/d3-chart-1.js"></script> -->
    <!-- DISABLED  <script src=../js/include/adv_charts/d3-chart-2.js"></script> -->

    <!-- Google Geo Chart -->
    <!-- DISABLED <script src="http://maps.google.com/maps/api/js?sensor=true" type="text/javascript"></script> -->
    <!-- DISABLED <script type='text/javascript' src='https://www.google.com/jsapi'></script>-->
    <!-- DISABLED <script src=../js/include/adv_charts/geochart.js"></script> -->
    
    <!-- end scripts -->
  </body>
</html>
