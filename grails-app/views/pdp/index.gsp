


<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Indicateurs</title>
                <g:javascript library="jquery" plugin="jquery" />
                
                
  </head>

 
 <g:render template="/menues/mainleft" />


 
 <div id="page-content">
    <div class="fluid-container">
      
						<section id="widget-grid" class="well light">
                                                  <div class="row-fluid">
                                                    
                                                    <article class="span12">
                                                      
                                                      <center>
    <h4> Tableau de bord </h4> 
    
    
    <div id="start">
      <ul>
        
      <li>
        <g:link controller ="kanban" action ="show" title="Informations">
          <img src="${request.contextPath}/img/start-icons/mass.png" alt="">
          <span>Informations</span>
        </g:link>
      </li>
        <li>
        <g:link controller ="kanban" action ="obtenirJournal" title="Journal">
          <img src="${request.contextPath}/img/start-icons/pending-message.png" alt="">
          <span>Journal</span>
        </g:link>
      </li>
      
        <li>
          
        <a href="javascript:voirProjets()" title="Projets">
          <img src="${request.contextPath}/img/start-icons/orders.png" alt="">
          <span>Projets en cours</span>
        </a>
      </li>
      <li>
        
        <g:link controller ="kanban" action ="indicateurKanban" title="Indicateurs">
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
      <section>
                                      
                                                  
      <div class="row-fluid">
        
        
        <article>
            <div class="span6">
              <center><h5> Adéquation charge capacité </h5></center>
              <div id="chargeCapa" style="height:350px; margin:0;"></div>
									        		
            
            </div>
            <div class="span6"> 
              <center><h5> Delta charge capacité </h5></center>
              <div id="deltaChargeCapa" class="chart" style="height:350px; margin:0;"></div>
                                                      <g:hiddenField name="kanban" id="monKanban" value="ok"/>
                                                      <g:hiddenField name="chargePlanifiee" id="chargePlanifiee" value="40"/>
            </div>
                                  <!-- new widget -->
              </article><article>                    
            <div class="span6"> 
              <center><h5> Evolution taux de VA </h5></center>
              	<div id="vadMensuelle" style="height:350px; margin:0;"></div>
								        		
            
            </div>   
            <div class="span6"> 
              <center><h5> Taux de VA par équipe </h5></center><div id="chargeCapa2" style="height:350px; margin:0;"></div>
									        		
            
            </div>     
                   </article><article> 
            <div class="span6"> 
              <center><h5> Avancement de l'activité</h5></center><div id="avancementKanban" class="chart" style="height:350px; margin:0;"></div>
									        <g:hiddenField name="monId" id="monId" value="1"/>
									        		
            
            </div>             
                     
      
            <div class="span6"> 
              <center><h5>Avancement par équipe</h5></center><div id="chargePIC" class="chart" style="height:350px; margin:0;"></div>
									</div>
									
									<!-- end widget -->
									
								</article>
                                  
                                  
        
        
          				
        </div>
  
  
        
                                                </section>
      </div>
      
      
      
									    <!-- end widget div -->
									</div>
 
                                                                        
                                                          
                                                        
                                                        				<!-- end main content -->
			
				<g:render template="/menues/mainright" />


    
    <script src="${request.contextPath}/js/include/amchart/amcharts.js"></script>
    <script src="${request.contextPath}/js/include/amchart/serial.js"></script>
    <script src="${request.contextPath}/js/include/amcharts/amcharts/themes/black.js"></script>
    
    
    <!-- creer par NL pour gerer tous les graphiques -->
    <script src="${request.contextPath}/js/include/indicateur.js"></script>
    <script src="${request.contextPath}/js/include/indicateur2.js"></script>
    