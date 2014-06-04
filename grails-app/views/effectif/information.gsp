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
        <article class="span12">
        
        <div id="temp">
          
      </div>
        
									    <!-- a modifier-->
<div class="jarviswidget" id="contenu2" data-widget-collapsed="false">
mettre infos</div>
          
        
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
  
  


    <script src="${request.contextPath}/js/include/indicateur.js"></script> 