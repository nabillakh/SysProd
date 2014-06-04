
<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Mes indicateurs</title>
  </head>

  
 <g:render template="/menues/mainleft" />




				<div id="page-content">
                                <article>
                                  <!-- new widget -->
                                  
                                  
                                
                                                                              avanement kanban
                                                                                  <div id="avancementKanban" class="chart" style="height:350px; margin:0;"></div>
									        
                                	
						
                                                <div class="inner-spacer"> 
									        	<!-- content goes here -->
									        	
									        	
									        	<div id="chargeCapa" class="chart" style="height:350px; margin:0;"></div>
									        													
									        	<!-- end calendar container -->
									        </div>
                                  <div class="jarviswidget" id="widget-id-4" data-widget-fullscreenbutton="false">
									    <header>
									        <h2>ok</h2>                           
									    </header>
									    <div>
									    
									        <div class="jarviswidget-editbox">
									            <div>
									                <label>Title:</label>
									                <input type="text" />
									            </div>
									            <div>
									                <label>Styles:</label>
									                <span data-widget-setstyle="purple" class="purple-btn"></span>
									                <span data-widget-setstyle="navyblue" class="navyblue-btn"></span>
									                <span data-widget-setstyle="green" class="green-btn"></span>
									                <span data-widget-setstyle="yellow" class="yellow-btn"></span>
									                <span data-widget-setstyle="orange" class="orange-btn"></span>
									                <span data-widget-setstyle="pink" class="pink-btn"></span>
									                <span data-widget-setstyle="red" class="red-btn"></span>
									                <span data-widget-setstyle="darkgrey" class="darkgrey-btn"></span>
									                <span data-widget-setstyle="black" class="black-btn"></span>
									            </div>
									        </div>
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->

												<!-- chart -->
												<div id="chargePIC"></div>

									        </div>
									        
									    </div>
									</div>
									
									<!-- end widget -->
									
								</article>
                                  
                                  <article class="span9">
                                    
                                    
                                  <!-- new widget -->
                                  <div class="jarviswidget" id="widget-id-4" data-widget-fullscreenbutton="false">
									    <header>
									        <h2>ok</h2>                           
									    </header>
									    <div>
									    
									        <div class="jarviswidget-editbox">
									            <div>
									                <label>Title:</label>
									                <input type="text" />
									            </div>
									            <div>
									                <label>Styles:</label>
									                <span data-widget-setstyle="purple" class="purple-btn"></span>
									                <span data-widget-setstyle="navyblue" class="navyblue-btn"></span>
									                <span data-widget-setstyle="green" class="green-btn"></span>
									                <span data-widget-setstyle="yellow" class="yellow-btn"></span>
									                <span data-widget-setstyle="orange" class="orange-btn"></span>
									                <span data-widget-setstyle="pink" class="pink-btn"></span>
									                <span data-widget-setstyle="red" class="red-btn"></span>
									                <span data-widget-setstyle="darkgrey" class="darkgrey-btn"></span>
									                <span data-widget-setstyle="black" class="black-btn"></span>
									            </div>
									        </div>
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->

												<!-- chart -->
												<div id="1barPIC"></div>

									        </div>
									    </div>
                                    
                                    
									</div>
									
									<!-- end widget -->
									
								</article>
                                
                                
                                
                                </div>
				<!-- end main content -->
<g:render template="/menues/mainright" />


    
    <script src="${request.contextPath}/js/include/amchart/amcharts.js"></script>
    <script src="${request.contextPath}/js/include/amchart/serial.js"></script>
    <script src="${request.contextPath}/js/include/amchart/light.js"></script>
    
    
    <!-- creer par NL pour gerer tous les graphiques -->
    <script src="${request.contextPath}/js/include/indicateur.js"></script>
    