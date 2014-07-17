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
       <div class="alert adjusted alert-info">
						<button class="close" data-dismiss="alert">×</button>
						<i class="cus-exclamation"></i>
                                                Ceci est la page de profil de ${effectifInstance?.prenom} ${effectifInstance?.nom} . Vous pouvez accéder
                                                 aux messages de ce collaborateur, aux indicateurs le concernant et son portefeuille de projet.
					</div>
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
        
        <g:link controller="effectif" action="indicateurEquipe" id="${effectifInstance.id}" title="Indicateurs">
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
  
  <article>
  <div class="jarviswidget" id="widget-id-12" data-widget-fullscreenbutton="false" data-widget-editbutton="false" data-widget-deletebutton="false" data-widget-collapsed="false">
									    <header>
									        <h2>Informations générales</h2>                           
									    </header>
									    
									    <!-- widget div-->
									    <div>
									        <!-- end widget edit box -->
									                    
									        <div class="inner-spacer widget-content-padding"> 
                                                                                  <center>
                                                                                  <table>
   <tr>
       <td>Nom : </td>
       <td><span class="input-xlarge uneditable-input"> ${effectifInstance?.nom}</span></td>
       
   </tr>
   <tr>
       <td>Prénom : </td>
       <td><span class="input-xlarge uneditable-input"> ${effectifInstance?.prenom}</span></td>
       
   </tr>
   <tr>
       <td>Emploi : </td>
       <td><span class="input-xlarge uneditable-input"> ${effectifInstance?.emploi}</span></td>
       
   </tr>
   <tr>
       <td>Equipe : </td>
       <td><span class="input-xlarge uneditable-input"> ${effectifInstance?.equipe.nom}</span></td>
       
   </tr>
   <tr>
       <td>Competence : </td>
       <td><span class="input-xlarge uneditable-input"> ${effectifInstance?.competence.competence.nom}</span></td>
       
   </tr>
   
</table></center>
                                                                                  
											<!-- end content -->
									        </div>
									        
									    </div>
									    <!-- end widget div -->
									</div>

</article>
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
  
  


    <script src="${request.contextPath}/js/include/indicateur.js"></script> 