<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
                 <g:javascript library="jquery" plugin="jquery" />
  </head>

  
 <g:render template="/menues/mainleft" />		
<div id="page-content">
    <div class="fluid-container">
      <div class="alert adjusted alert-info">
						<button class="close" data-dismiss="alert">×</button>
						<i class="cus-exclamation"></i>
                                                Ceci est la page de profil de l'équipe ${equipeInstance?.nom}. Vous pouvez accéder
                                                 aux messages concernant cette équipe, aux indicateurs la concernant et le portefeuille de projets des collaborateurs.
					</div>
      
						<section id="widget-grid" class="well light">
                                                  <div class="row-fluid">
                                                    
                                                    <article class="span12">
                                                      
                                                      <center>
    <h4>${equipeInstance?.nom}</h4> 
    
    
    <div id="start">
      <ul>
        
      <li>
        <g:link controller="equipe" action="information" id="${equipeInstance.id}" title="Informations">
          <img src="${request.contextPath}/img/start-icons/mass.png" alt="">
          <span>Informations</span>
        </g:link>
      </li>
        <li>
        <g:link controller="equipe" action="show" id="${equipeInstance.id}" title="Journal">
          <img src="${request.contextPath}/img/start-icons/pending-message.png" alt="">
          <span>Journal</span>
        </g:link>
      </li>
      
        <li>
          
        <g:link controller="equipe" action="obtenirKanbanEquipe" id="${equipeInstance.id}" title="Projets">
          <img src="${request.contextPath}/img/start-icons/orders.png" alt="">
          <span>Projets en cours</span>
        </g:link>
      </li>
      <li>
        
        <g:link controller="equipe" action="indicateurEquipe" id="${equipeInstance.id}" title="Indicateurs">
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
        
<div class="jarviswidget" id="contenu2" data-widget-collapsed="false">
        </div>
          <script type="text/javascript">
      <g:remoteFunction controller="message" action="obtenirMessageEffectif" update="contenu2"/>;
          </script>
        
        </article>       
        
      </div>
      </section>
      
      
									    <!-- end widget div -->
									</div>

							</div>
 
				

<g:render template="/menues/mainright" />

