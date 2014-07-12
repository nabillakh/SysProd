<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
                 <g:javascript library="jquery" plugin="jquery" />
  </head>

 <sec:ifLoggedIn>
 <g:render template="/menues/mainleft" />		
<div id="page-content">
    <div class="fluid-container">
						<section id="widget-grid" class="well light">
                                                  <div class="row-fluid">
                                                    <article class="span3">
    <img src="${request.contextPath}/img/start-icons/coucou.jpg" alt="" style="width: 160px; height: 160px;">
    
                                                    </article>
                                                    <article class="span9">
                                                      
                                                      <center>
    <h4>${effectifInstance?.prenom} ${effectifInstance?.nom}</h4> 
   <g:link  action="show" controller="Equipe" id=" ${effectifInstance.equipe.id}"> <h4> Equipe: ${effectifInstance?.equipe.nom}</h4></g:link>
    
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
      <section>
      <div class="row-fluid">
        <g:hiddenField name="monId" id="monId" value="${effectifInstance.id}"/>
        <article>
            <div class="span6">
              <center><h5> Adéquation charge capacité </h5></center>
              <div id="chargeCapaEffectif" style="height:350px; margin:0;"></div>
									        		
            
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
									  
									        		
            
            </div>             
                     
      
            <div class="span6"> 
              <center><h5>Avancement par équipe</h5></center><div id="chargePIC" class="chart" style="height:350px; margin:0;"></div>
									</div>
									
									<!-- end widget -->
									
								</article>
        <article class="span12">
        
        <div id="temp">
          
      </div>
          
        
									    <!-- a modifier-->
<div class="jarviswidget" id="contenu2" data-widget-collapsed="false">


  <header>
									        <h2>Indicateurs</h2>                           
									    </header> 
					<div class="fluid-container">

<div class="inner-spacer"> 
  <div class="row-fluid">
								
								<article class="span6">
									<!-- new widget -->
                                                      <div id="indicateurSocial"></div>
                                                                        <center>Impact social (nombre de messages envoyés)</center>
                                                      <g:hiddenField name="messagesKanban" id="messagesKanban" value="${messagesKanban}"/>
                                                      <g:hiddenField name="messagesAutre" id="messagesAutre" value="${messagesAutre}"/>
                                                      <g:hiddenField name="messagesKanbanMoyen" id="messagesKanbanMoyen" value="${messagesKanbanMoyen}"/>
                                                      <g:hiddenField name="messagesAutreMoyen" id="messagesAutreMoyen" value="${messagesAutreMoyen}"/>
                                                      
                                                      
                                                                        
                                                                        
									<!-- end widget -->
								</article>
								<article class="span6"> jkhdsgjklm </article>
  </div>  </div></div>
 </div>
          
        
        </article>       
        
      </div>
      </section>
      
      
									    <!-- end widget div -->
									</div>

							</div>
 
 
				

<g:render template="/menues/mainright" />



 
</sec:ifLoggedIn>
  
  
  
  
  <sec:ifNotLoggedIn>
    <h2> <g:link  action="index" controller="login"> <font size="3" face="georgia" color="red"> Se connecter </font></g:link> <h2>
  </sec:ifNotLoggedIn>
  
  


 <script src="${request.contextPath}/js/include/amchart/amcharts.js"></script>
    <script src="${request.contextPath}/js/include/amchart/serial.js"></script>
    <script src="${request.contextPath}/js/include/amcharts/amcharts/themes/black.js"></script>
    
    
    <!-- creer par NL pour gerer tous les graphiques -->
    <script src="${request.contextPath}/js/include/indicateur.js"></script>
    <script src="${request.contextPath}/js/include/indicateurEffectif.js"></script>
    <script src="${request.contextPath}/js/include/indicateur2.js"></script>