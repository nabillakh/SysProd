
<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    
    <title>SysProd</title>
    <meta name="description" content="">
    <meta name="author" content="">
    
	<!-- http://davidbcalhoun.com/2010/viewport-metatag -->
	<meta name="HandheldFriendly" content="True">
	<meta name="MobileOptimized" content="320">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<!--// OPTIONAL & CONDITIONAL CSS FILES //-->   
	<!-- date picker css -->
	<link rel="stylesheet" href="${request.contextPath}/css/datepicker.css?v=1">
	<!-- full calander css -->
	<link rel="stylesheet" href="${request.contextPath}/css/fullcalendar.css?v=1">
	<!-- data tables extended CSS -->
	<link rel="stylesheet" href="${request.contextPath}/css/TableTools.css?v=1">
	<!-- bootstrap wysimhtml5 editor -->
	<link rel="stylesheet" href="${request.contextPath}/css/bootstrap-wysihtml5.css?v=1">
	<link rel="stylesheet" href="${request.contextPath}/css/wysiwyg-color.css">
	<!-- custom/responsive growl messages -->
	<link rel="stylesheet" href="${request.contextPath}/css/toastr.custom.css?v=1">
	<link rel="stylesheet" href="${request.contextPath}/css/toastr-responsive.css?v=1">
	<link rel="stylesheet" href="${request.contextPath}/css/jquery.jgrowl.css?v=1">

	<!-- // DO NOT REMOVE OR CHANGE ORDER OF THE FOLLOWING // -->
	<!-- bootstrap default css (DO NOT REMOVE) -->
	<link rel="stylesheet" href="${request.contextPath}/css/bootstrap.min.css?v=1">
	<link rel="stylesheet" href="${request.contextPath}/css/bootstrap-responsive.min.css?v=1">
	<!-- font awsome and custom icons -->
	<link rel="stylesheet" href="${request.contextPath}/css/font-awesome.min.css?v=1">
	<link rel="stylesheet" href="${request.contextPath}/css/cus-icons.css?v=1">
	<!-- jarvis widget css -->
	<link rel="stylesheet" href="${request.contextPath}/css/jarvis-widgets.css?v=1">
	<!-- Data tables, normal tables and responsive tables css -->
	<link rel="stylesheet" href="${request.contextPath}/css/DT_bootstrap.css?v=1">
	<link rel="stylesheet" href="${request.contextPath}/css/responsive-tables.css?v=1">
	<!-- used where radio, select and form elements are used -->
	<link rel="stylesheet" href="${request.contextPath}/css/uniform.default.css?v=1">
	<link rel="stylesheet" href="${request.contextPath}/css/select2.css?v=1">
	<!-- main theme files -->
	<link rel="stylesheet" href="${request.contextPath}/css/theme.css?v=1">
	<link rel="stylesheet" href="${request.contextPath}/css/theme-responsive.css?v=1">
    
	<!-- // THEME CSS changed by javascript: the CSS link below will override the rules above // -->
	<!-- For more information, please see the documentation for "THEMES" -->
    <link rel="stylesheet" id="switch-theme-js" href="${request.contextPath}/css/themes/default.css?v=1">   

   	<!-- To switch to full width -->
    <link rel="stylesheet" id="switch-width" href="${request.contextPath}/css/full-width.css?v=1">
    
	<!-- Webfonts -->
	<link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Lato:300,400,700' type='text/css'>

	<!-- All javascripts are located at the bottom except for HTML5 Shim -->
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
   		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
   		<script src="${request.contextPath}/js/include/respond.min.js"></script>
   	<![endif]-->

	<!-- For Modern Browsers -->
	<link rel="shortcut icon" href="${request.contextPath}/img/favicons/favicon.png">
	<!-- For everything else -->
	<link rel="shortcut icon" href="${request.contextPath}/img/favicons/favicon.ico">
	<!-- For retina screens -->
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="${request.contextPath}/img/favicons/apple-touch-icon-retina.png">
	<!-- For iPad 1 -->
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="${request.contextPath}/img/favicons/apple-touch-icon-ipad.png">
	<!-- For iPhone 3G, iPod Touch and Android -->
	<link rel="apple-touch-icon-precomposed" href="${request.contextPath}/img/favicons/apple-touch-icon.png">

	<!-- iOS web-app metas -->
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<!-- Add your custom home screen title: -->
	<meta name="apple-mobile-web-app-title" content="Sysprod"> 

	<!-- Startup image for web apps -->
	<link rel="apple-touch-startup-image" href="${request.contextPath}/img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
	<link rel="apple-touch-startup-image" href="${request.contextPath}/img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
	<link rel="apple-touch-startup-image" href="${request.contextPath}/img/splash/iphone.png" media="screen and (max-device-width: 320px)">

  </head>

  <body>
  
 <g:render template="/menues/mainleft" />	

<div id="page-content">
  <div class="alert adjusted alert-info">
							<button class="close" data-dismiss="alert">×</button>
							<i class="cus-exclamation"></i>
							<strong>Info!</strong> Cette page propose à vos collaborateurs d'accéder simplement à leur to do list complète
						</div>
    <div class="fluid-container" style="margin-bottom:300px; ">
						<section id="widget-grid" class="well light">
                                                  <div class="row-fluid">
                                                    <article class="span3">
    <img src="${request.contextPath}/img/start-icons/coucou.jpg" alt="" style="width: 160px; height: 160px;">
    
                                                    </article>
                                                    <article class="span9">
                                                      
                                                      <center>
    <h4>${effectifInstance?.prenom} ${effectifInstance?.nom}</h4> 
   <g:link  action="show" controller="Equipe" id=" ${effectifInstance.equipe?.id}"> <h4> Equipe: ${effectifInstance?.equipe.nom}</h4></g:link>
    
    <div id="start">
      <ul>
        
      <li>
        <g:link controller="effectif" action="information" id="${effectifInstance.id}" title="Informations">
          <img src="${request.contextPath}/img/start-icons/mass.png" alt="">
          <span>Informations</span>
        </g:link>
      </li>
        <li>
        <g:link controller="effectif" action="show" id="${effectifInstance.id}" title="Journal">
          <img src="${request.contextPath}/img/start-icons/pending-message.png" alt="">
          <span>Journal</span>
        </g:link>
      </li>
      
        <li>
          
        <g:link controller="kanban" action="obtenirKanbanEffectif" id="${effectifInstance.id}" title="Projets">
          <img src="${request.contextPath}/img/start-icons/orders.png" alt="">
          <span>Projets en cours</span>
        </g:link>
      </li>
      <li>
        
        <g:link controller="effectif" action="indicateurEffectif" id="${effectifInstance.id}" title="Indicateurs">
          <img src="${request.contextPath}/img/start-icons/stats.png" alt="">
          <span>Indicateurs</span>
        </g:link>
      </li>
      </ul>
      
    </div>
                                                      </center>
                                                    </article>
                                                  </div>
                                                  
                                                </section>
      <section id="widget-grid" class="">
      <div class="row-fluid">
        <article class="span12">
        						    <!-- a modifier-->
                                                            <div class="jarviswidget" id="contenu2" data-widget-collapsed="false">
<header>
									        <h2>Liste des projets</h2>                           
									    </header>
									    <!-- wrap div -->
                                                                            
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
                                                                                
												<table class="table table-striped table-bordered responsive" id="dtable">
													<thead>
														<tr>
                                                                                                                        <th></th>
                                                                                                                  <th>Nom du projet</th>
															<th>Description</th>
															<th>Phase du projet</th>
															<th>Date de fin planifiée</th>
															<th>Charge associée</th>
														</tr>
													</thead>
													<tbody class="responsive"><g:each in="${kanbanInstanceList}" status="i" var="kanbanInstance">
                                                                                                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                                                          <td><center>
                                                                                                            
                                                                                                            <div class="btn-group">
																<a class="btn dropdown-toggle" data-toggle="dropdown" href="javascript:void(0);" class=" pull-left"><i class="icon-edit"></i> Edition  <span class="caret"></span></a>
																
																<ul class="dropdown-menu">
																	<li>
																		<a href="javascript:voir(${kanbanInstance.id});" class=" pull-left"><i class="icon-zoom-in"></i> Voir</a>
																	</li>
																	<li>
																		<a href="javascript:editer(${kanbanInstance.id});" class=" pull-left"><i class="icon-pencil"></i> Modifier</a>
																	</li>
																	<li>
																		<a href="javascript:gererOf(${kanbanInstance.id});" class=" pull-left"><i class="icon-user icon-white"></i> Affecter</a>
																	</li>
                                                                                                                                        
																	<li>
																		<a href="javascript:supprimer(${kanbanInstance.id});" class=" pull-left"><i class="icon-trash"></i> Supprimer</a>
																	</li>
																</ul>
															</div>
                                                                                                            
                                                                                                            </center></td>
                                                                                                              <td><g:link action="show" controller="Kanban" id="${kanbanInstance.id}">${fieldValue(bean: kanbanInstance, field: "nomKanban")}</g:link></td>
                                                                                                          <td>${fieldValue(bean: kanbanInstance, field: "description")}</td>
                                                                                                          <td>${kanbanInstance.phaseActuelle?.nom}</td>
                                                                                                          <td><g:formatDate date="${kanbanInstance.dateFinPlanifie}" /></td>
                                                                                                          <td>${fieldValue(bean: kanbanInstance, field: "chargePlanifiee")}</td>
                                                                                                          </tr>
                                                                                                          </g:each>
													</tbody>
												</table>

										    <!-- end content-->
									    </div></div>
          
        
        </article>       
        
      </div>
      </section>
  <script>
                                                          function voir(monId) {
                                                                    window.location = "/application/kanban/show/"+monId;
                                                          }        
                                                          function editer(monId) {
                                                                    window.location = "/application/kanban/edit/"+monId;
                                                          }       
                                                          function gererOf(monId) {
                                                                    window.location = "/application/kanban/gestionOf/"+monId;
                                                          }       
                                                          function supprimer(monId) {
                                                                    bootbox.confirm("'Voulez vous confirmer la suppression du projet?" , function(result) {
					 //console.log("Confirm result: "+result);
                                        
                                                                                   <g:remoteFunction controller = "kanban" action="delete"   params ="\'kanban=\' + monId" />
                                         					  // toastr.info("Confirm result: "+result);
                                                                                });
                                                          }                                                                                                                                    
                                                        </script>
      
      
									    <!-- end widget div -->
									</div>

							</div>
 
 
				

<g:render template="/menues/mainright" />




	<!-- end footer -->

    <!--================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="${request.contextPath}/js/libs/jquery.min.js"><\/script>')</script>
    	<!-- OPTIONAL: Use this migrate scrpit for plugins that are not supported by jquery 1.9+ -->
		<!-- DISABLED <script src="${request.contextPath}/js/libs/jquery.migrate-1.0.0.min.js"></script> -->
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
    <script>window.jQuery.ui || document.write('<script src="${request.contextPath}/js/libs/jquery.ui.min.js"><\/script>')</script>
    
    <!-- IMPORTANT: Jquery Touch Punch is always placed under Jquery UI -->
    <script src="${request.contextPath}/js/include/jquery.ui.touch-punch.min.js"></script>
    
    <!-- REQUIRED: Mobile responsive menu generator -->
	<script src="${request.contextPath}/js/include/selectnav.min.js"></script>

	<!-- REQUIRED: Datatable components -->
    <script src="${request.contextPath}/js/include/jquery.accordion.min.js"></script>

	<!-- REQUIRED: Toastr & Jgrowl notifications  -->
    <script src="${request.contextPath}/js/include/toastr.min.js"></script>
    <script src="${request.contextPath}/js/include/jquery.jgrowl.min.js"></script>
    
    <!-- REQUIRED: Sleek scroll UI  -->
    <script src="${request.contextPath}/js/include/slimScroll.min.js"></script>

	<!-- REQUIRED: Datatable components -->
	<script src="${request.contextPath}/js/include/jquery.dataTables.min.js"></script> 
	<script src="${request.contextPath}/js/include/DT_bootstrap.min.js"></script>

    <!-- REQUIRED: Form element skin  -->
    <script src="${request.contextPath}/js/include/jquery.uniform.min.js"></script> 

	<!-- REQUIRED: AmCharts  -->
    <script src="${request.contextPath}/js/include/amchart/amcharts.js"></script>
	<script src="${request.contextPath}/js/include/amchart/amchart-draw1.js"></script>

	<script type="text/javascript">
		var ismobile = (/iphone|ipad|ipod|android|blackberry|mini|windows\sce|palm/i.test(navigator.userAgent.toLowerCase()));	
	    if(!ismobile){

	    	/** ONLY EXECUTE THESE CODES IF MOBILE DETECTION IS FALSE **/

	    	/* REQUIRED: Datatable PDF/Excel output componant */

	    	document.write('<script src="${request.contextPath}/js/include/ZeroClipboard.min.js"><\/script>');
	    	document.write('<script src="${request.contextPath}/js/include/TableTools.min.js"><\/script>'); 
	    	document.write('<script src="${request.contextPath}/js/include/select2.min.js"><\/script>');
	    	document.write('<script src="${request.contextPath}/js/include/jquery.excanvas.min.js"><\/script>');
	    	document.write('<script src="${request.contextPath}/js/include/jquery.placeholder.min.js"><\/script>');
	    }else{

	    	/** ONLY EXECUTE THESE CODES IF MOBILE DETECTION IS TRUE **/

	    	document.write('<script src="${request.contextPath}/js/include/responsive-tables.min.js"><\/script>');
	    }
	</script>

	<!-- REQUIRED: iButton -->
    <script src="${request.contextPath}/js/include/jquery.ibutton.min.js"></script>

	<!-- REQUIRED: Justgage animated charts -->
	<script src="${request.contextPath}/js/include/raphael.2.1.0.min.js"></script>
    <script src="${request.contextPath}/js/include/justgage.min.js"></script>
    
    <!-- REQUIRED: Morris Charts -->
    <script src="${request.contextPath}/js/include/morris.min.js"></script> 
    <script src="${request.contextPath}/js/include/morris-chart-settings.js"></script> 
    
    <!-- REQUIRED: Animated pie chart -->
    <script src="${request.contextPath}/js/include/jquery.easy-pie-chart.min.js"></script>
    
    <!-- REQUIRED: Functional Widgets -->
    <script src="${request.contextPath}/js/include/jarvis.widget.min.js"></script>
    <script src="${request.contextPath}/js/include/mobiledevices.min.js"></script>
    <!-- DISABLED (only needed for IE7 <script src="${request.contextPath}/js/include/json2.js"></script> -->

	<!-- REQUIRED: Full Calendar -->
    <script src="${request.contextPath}/js/include/jquery.fullcalendar.min.js"></script>		
    
    <!-- REQUIRED: Flot Chart Engine -->
    <script src="${request.contextPath}/js/include/jquery.flot.cust.min.js"></script>			
    <script src="${request.contextPath}/js/include/jquery.flot.resize.min.js"></script>		
    <script src="${request.contextPath}/js/include/jquery.flot.tooltip.min.js"></script>		
    <script src="${request.contextPath}/js/include/jquery.flot.orderBar.min.js"></script> 	
    <script src="${request.contextPath}/js/include/jquery.flot.fillbetween.min.js"></script>	
    <script src="${request.contextPath}/js/include/jquery.flot.pie.min.js"></script> 	 
    
    <!-- REQUIRED: Sparkline Charts -->
    <script src="${request.contextPath}/js/include/jquery.sparkline.min.js"></script>

	<!-- REQUIRED: Infinite Sliding Menu (used with inbox page) -->
	<script src="${request.contextPath}/js/include/jquery.inbox.slashc.sliding-menu.js"></script> 

	<!-- REQUIRED: Form validation plugin -->
    <script src="${request.contextPath}/js/include/jquery.validate.min.js"></script>
    
    <!-- REQUIRED: Progress bar animation -->
    <script src="${request.contextPath}/js/include/bootstrap-progressbar.min.js"></script>
    
    <!-- REQUIRED: wysihtml5 editor -->
    <script src="${request.contextPath}/js/include/wysihtml5-0.3.0.min.js"></script>
    <script src="${request.contextPath}/js/include/bootstrap-wysihtml5.min.js"></script>

	<!-- REQUIRED: Masked Input -->
    <script src="${request.contextPath}/js/include/jquery.maskedinput.min.js"></script>
    
    <!-- REQUIRED: Bootstrap Date Picker -->
    <script src="${request.contextPath}/js/include/bootstrap-datepicker.min.js"></script>

    <!-- REQUIRED: Bootstrap Wizard -->
    <script src="${request.contextPath}/js/include/bootstrap.wizard.min.js"></script> 
    
	<!-- REQUIRED: Bootstrap Color Picker -->
    <script src="${request.contextPath}/js/include/bootstrap-colorpicker.min.js"></script>

    
	<!-- REQUIRED: Bootstrap Time Picker -->
    <script src="${request.contextPath}/js/include/bootstrap-timepicker.min.js"></script> 
    
    <!-- REQUIRED: Bootstrap Prompt -->
    <script src="${request.contextPath}/js/include/bootbox.min.js"></script>
    
    <!-- REQUIRED: Bootstrap engine -->
    <script src="${request.contextPath}/js/include/bootstrap.min.js"></script>
    
    <!-- DO NOT REMOVE: Theme Config file -->
    <script src="${request.contextPath}/js/config.js"></script>
    
    <!-- d3 library placed at the bottom for better performance -->
    <!-- DISABLED  <script src="${request.contextPath}/js/include/d3.v3.min.js"></script> -->
    <!-- DISABLED  <script src="${request.contextPath}/js/include/adv_charts/d3-chart-1.js"></script> -->
    <!-- DISABLED  <script src="${request.contextPath}/js/include/adv_charts/d3-chart-2.js"></script> -->

    <!-- Google Geo Chart -->
    <!-- DISABLED <script src="http://maps.google.com/maps/api/js?sensor=true" type="text/javascript"></script> -->
    <!-- DISABLED <script type='text/javascript' src='https://www.google.com/jsapi'></script>-->
    <!-- DISABLED <script src="${request.contextPath}/js/include/adv_charts/geochart.js"></script> -->
    
    <!-- end scripts -->
  </body>
</html>