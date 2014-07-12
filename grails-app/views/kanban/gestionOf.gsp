
<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <style>.news-list {
    padding: 0;
}
.news-list li {
    cursor: pointer;
    display: inline-block;
    padding: 5px 10px;
    border-radius: 5px;
    -moz-border-radius: 5px;
    background: #fff;
    margin: 0 10px 0 0;
}
.news-list.interested li {
    background: #74ce9c;
}
.source-news h3 {
    font-size: 13px;
    margin: 0;
}
.interested-in {
    background: #e9f5f1;
    border-radius: 4px;
    -moz-border-radius: 4px;
    padding: 13px 18px;
    margin: 18px 0 0 0;
}
.interested-in h3 {
    color: #74ce9c;
    font-size: 13px;
    margin: 0;
}</style>
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
  	<!-- .height-wrapper -->
	 <g:render template="/menues/mainleft" />
                                
                                
				<div id="page-content">
                                  <div class="alert adjusted alert-info">
							<button class="close" data-dismiss="alert">×</button>
							<i class="cus-exclamation"></i>
							<strong>Info!</strong> Affecter vos projets simplement avec ce module. Les tâches sont automatiquement pré ordonnancer mais vous avez la main pour réajuster au plus juste les données (dates, charge etc.)
						</div>
					<!-- page header -->
					<h1 id="page-header">Gestion des activités et des affectations</h1>	

					<div class="fluid-container">
                                            
                                
  
  </div><!--/container-fluid-->
												
				<g:link  action="index" controller="kanban" ><i class="icon-star"></i>  Liste des kanbans </g:link></br>
                                <g:link  action="show" controller="kanban" id="${kanbanInstance.id}" ><i class="icon-star"></i>  Afficher ce kanban </g:link>
												
                                        
				
												
                                                  <g:each in="${mesof}" status="i" var="mesofInstance">
                                                      <g:set var="of" value="${mesofInstance.id}" />
                                                        <g:each in="${dateLIst}" status="j" var="dateLIstInstance">
                                                        <g:set var="laof" value="${dateLIstInstance.id}" /> 
                                                                <g:if test="${laof == of}">
                                                              <g:set var="deb" value="${dateLIstInstance.start}" />
                                                               <g:set var="fin" value="${dateLIstInstance.end}" />
                                                                    </g:if>         
                                                        </g:each>
						<!-- widget grid -->
						<section id="widget-grid" class="">
							<div class="row-fluid">

								<article>
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-0">
									    <header>
									        <h2>${mesofInstance?.phase?.nom}</h2>                           
									    </header>
									    <!-- wrap div -->
									    <div>
                                                                              <div class="inner-spacer"> 
                                                                                <g:if test="${flash.message}">
                                                                                  <div class="message" role="status">${flash.message}</div>
                                                                                </g:if>

                                                                                <g:form url="[action:'majOF']">

                                                                                  <input type="hidden"  name="monId" id="monId${i}"  value="${mesofInstance?.id}">
                                                                                  <fieldset class="form-horizontal themed"> 
                                                                                    <div class="control-group">
                                                                                      <label for="chargePlanifiee" class="control-label">
                                                                                        <g:message code="OF.chargePlanifiee.label" default="Charge Planifiee" />
                                                                                      </label>
                                                                                      <div class="controls"  size="16" >
                                                                                        <g:field name="chargePlanifiee"  id="chargeplanifiee${i}" value="${fieldValue(bean: mesofInstance, field: 'chargePlanifiee')}" />
                                                                                      </div>
                                                                                    </div>                                                                                 

                                                                                    <div class="control-group hidden">
                                                                                      <label for="affectes" class="control-label">
                                                                                        <g:message code="OF.affectes.label" default="Affectes" />

                                                                                      </label>  <div class="controls"  size="16" >
                                                                                        <g:select id="multiSelect" multiple="multiple"  id="affectes${i}"  name="affectes" from="${application.RH.Effectif.list()}" optionKey="id" required="" value="${mesofInstance?.affectes*.id}" class="span12 with-search"/>
                                                                                       </div>
                                                                                    </div>
                                                                                    
  <div class="control-group">
    <ul id="categories-source${i}" class='news-list categories-sortable'>
      Ressources affectables : 
      <g:each in="${effectifs}" status="k" var="eff">    
        
      <g:if test="${mesofInstance.getEffectifsAffectes().find {it.id == eff.id}}">  
        
      </g:if>     
        <g:else>
      <li class="btn" id="${eff.id}">${eff.nom} </br> ${eff.emploi}</li>
        </g:else>
      </g:each>
    </ul>     
</div>
<div class="control-group">
    <ul id="categories-chosen${i}" class='news-list interested categories-sortable'>
     Ressources affectées :   
      <g:each in="${mesofInstance.getEffectifsAffectes()}" status="k" var="eff">  
      <li class="btn" id="${eff.id}">${eff.nom} </br>  ${eff.emploi}</li>
      </g:each>     
    </ul>
</div>
                                                                                    
                                                                                    <div class="control-group">

                                                                                      <div>
                                                                                        <label class="control-label">Date de lancement <span class="required-indicator">*</span></label>
                                                                                        

                                                                                        <div class="controls" size="16" >
                                                                                         
                                                                                         
                                                                                          
                                                                                                       <div class="input-append date" id="datepicker-js" data-date="${fin}" data-date-format="dd/mm/yyyy">
                                                                                                    <input class="datepicker-input" size="16" type="text"   name="dateDebutPlanifie" id="dateDebutPlanifie${i}"  value="${deb}"    placeholder="Select a date" />
                                                                                                    <span class="add-on"><i class="cus-calendar-2"></i></span>
                                                                                                     </div>
                                                                                          
                                                                                        </div>
                                                                                      </div></div>
                                                                                    <div class="control-group">
                                                                                      <div>
                                                                                        <label class="control-label">Date de fin planifiée <span class="required-indicator">*</span></label>
                                                                                        <div class="controls" size="16" >
                                                                                          <div>
                                                                                           
                                                                                                    <div class="input-append date" id="datepicker-js" data-date="${fin}" data-date-format="dd/mm/yyyy">
                                                                                                    <input class="datepicker-input" size="16" type="text"  value="${fin}" name="dateFinPlanifie" id="dateFinPlanifie${i}" placeholder="Select a date" />
                                                                                                    <span class="add-on"><i class="cus-calendar-2"></i></span>
                                                                                                     </div>
             
                                                                                          </div>
                                                                                        </div>
                                                                                      </div>
                                                                                    </div>

                                                                                  </fieldset>     

                                                                                  <fieldset class="buttons">
                                                                                    <center><a class="btn btn-primary medium" href="#" id="${i}" onClick ="majOF(this.id);return false;">Modifier</a></center>
                                                                                  </fieldset> 
                                                                                </g:form>
                                                                              </div>
                                                                              <!-- end content-->
                                                                            </div>
                                                                            <!-- end wrap div -->
                                                                        </div>
                                                                        <!-- end widget -->
                                                                </article>
                                                        </div>
                                                  </g:each>
						<!-- end widget grid -->
					</div>	
                                        
                                                </section>	
				</div>
         <script>
           function majOF(monId) {
             var id = $('#monId'+monId).val();
             var charge = $('#chargeplanifiee'+monId).val();
             var dateFinPlanifie = $('#dateFinPlanifie'+monId).val();
             var dateDebutPlanifie = $('#dateDebutPlanifie'+monId).val();
             var affectes = $('#affectes'+monId).val();
             var items = [];
             $('#categories-chosen'+monId).children().each(function() {
               var item = {eff : $(this).attr('id')};
               items.push(item);
             });
             var jsonData = JSON.stringify(items);             
             
             <g:remoteFunction controller="kanban" action="majOF"  params="\'monId=\' + id+ '&charge=\' + charge+ '&dateFinPlanifie=\' + dateFinPlanifie+ '&dateDebutPlanifie=\' + dateDebutPlanifie+ '&affectes=\' + affectes+ '&jsonData=\' + jsonData"/>;
                toastr.info('Activité mise à jour !');   }
           function pollMessages() {
             obtenirMessage();
             setTimeout('pollMessages()', 25000);
           }
           // pollMessages();
         </script>
                                
                                
                                
                                                               
				<!-- end main content -->

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
        
                                            $(function () {
    var oldList, newList, item;
    $(".categories-sortable").sortable({
        connectWith: $('.categories-sortable'),
        start: function (event, ui) {
            item = ui.item;
            newList = oldList = ui.item.parent();
        },
        stop: function (event, ui) {
            console.log("Moved " + item.text() + " from " + oldList.attr('id') + " to " + newList.attr('id'));
        },
        change: function (event, ui) {
            if (ui.sender) {
                newList = ui.placeholder.parent();
            }
        },
    })
        .disableSelection();

});</script>
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