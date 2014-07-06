<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Indicateurs : ${kanbanInstance.nomKanban}</title>
                <g:javascript library="jquery" plugin="jquery" />
                
                
  </head>

 
 <g:render template="/menues/mainleft" />


 
 <div id="page-content">
    <div class="fluid-container">
      <div class="alert adjusted alert-info">
							<button class="close" data-dismiss="alert">×</button>
							<i class="cus-exclamation"></i>
							<strong>Info!</strong> Où en est le projet? Combien de charge a été consommée? Quel est le point de sortie prévisionnel? Obtenez en un clic toutes les données d'avancement de vos projets.
						</div>
      
						<section id="widget-grid" class="well light">
                                                  <div class="row-fluid">
                                                    <article class="span3">
    <img src="${request.contextPath}/img/start-icons/coucou.jpg" alt="" style="width: 160px; height: 160px;">
    
                                                    </article>
                                                    <article class="span9">
                                                      
                                                      <center>
    <h4> Projet : ${kanbanInstance?.nomKanban} </h4> 
   <g:link  action="show" controller="Famille" id="${kanbanInstance.famille.id}"> <h4> Famille : ${kanbanInstance?.famille.nom}</h4></g:link>
    
    <div id="start">
      <ul>
        
      <li>
        <g:link controller ="kanban" action ="show" id ="${kanbanInstance.id}" title="Informations">
          <img src="${request.contextPath}/img/start-icons/mass.png" alt="">
          <span>Informations</span>
        </g:link>
      </li>
        <li>
        <g:link controller ="kanban" action ="obtenirJournal" id ="${kanbanInstance.id}" title="Journal">
          <img src="${request.contextPath}/img/start-icons/pending-message.png" alt="">
          <span>Journal</span>
        </g:link>
      </li>
      
        <li>
          
        <a href="javascript:voirProjets(${kanbanInstance.id})" title="Projets">
          <img src="${request.contextPath}/img/start-icons/orders.png" alt="">
          <span>Projets en cours</span>
        </a>
      </li>
      <li>
        
        <g:link controller ="kanban" action ="indicateurKanban" id="${kanbanInstance.id}" title="Indicateurs">
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
        <article class="span12">
        
        <div id="temp">
          
      </div>
<div id="contenu2">
  
      
  <div class="span6">
									    <header>
									        <h4>Avancement du projet</h4>                           
									    </header>
    
                                                                                  <div id="avancementKanban" class="chart" style="height:350px; margin:0;"></div>
									         <g:hiddenField name="monId" id="monId" value="${kanbanInstance.id}"/>
      
      
        
		
          </div>
  
  <div class="span6">
									    <header>
									        <h4>avancement par phase</h4>                           
									    </header>
									<!-- new widget -->
									    <div>
									    
									       
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
												<div class="progress-stats">
			                                        <div class="widget-content-padding">
                                                                  <g:each in="${kanbanInstance.of}" status="k" var="ofInstance">
			                                            <div class="semi-block">
			                                                <strong>${ofInstance.phase.nom}</strong><strong class="pull-right">${ofInstance.chargeAgenda / ofInstance.chargePlanifiee * 100} %</strong>
			                                                <div class="progress progress-info value"><div class="bar" data-percentage="40" data-amount-part="${ofInstance.chargeAgenda}" data-amount-total="${ofInstance.chargePlanifiee}">456 / 631</div></div>
			                                            </div>
                                                                  </g:each>
			                                        </div>
			                                    </div>
									        <!-- end content -->
									        </div>
									        
									        
									    </div>
									    </div>
        
  <div class="span6">
									    <header>
									        <h4>Avancement du projet</h4>                           
									    </header>
									<!-- new widget -->
							                        
                                                                        
                                                      <div id="avancementOf"></div>
                                                      <g:hiddenField name="kanban" id="monKanban" value="${kanbanInstance.nomKanban}"/>
                                                      <g:hiddenField name="chargePlanifiee" id="chargePlanifiee" value="${kanbanInstance.chargePlanifiee}"/>
                                                      
                                                                        
                                                      <div id="chargePIC"></div>
                                                                      </div>  

  
									<!-- end widget -->
                                                                        
        
  
								
							</div>  
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
    