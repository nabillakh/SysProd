<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Gestion de la famille ${familleInstance?.nom}</title>
                <g:javascript library="jquery" plugin="jquery" />
                
                
  </head>

 
 <g:render template="/menues/mainleft" />


 
 <div id="page-content">
    <div class="fluid-container">
      <div class="alert adjusted alert-info">
							<button class="close" data-dismiss="alert">×</button>
							<i class="cus-exclamation"></i>
							<strong>Info!</strong> Les principales informations sur vos familles d'activités sont accessibles sur cette page.
						</div>
      
						<section id="widget-grid" class="well light">
                                                  <div class="row-fluid">
                                                    <article class="span12">
                                                      
                                                      <center>
    <h4> Famille d'activité : ${familleInstance?.nom} </h4> 
    
    
    <div id="start">
      <ul>
        
      <li>
        <g:link controller ="famille" action ="show" id ="${familleInstance.id}" title="Informations">
          <img src="${request.contextPath}/img/start-icons/mass.png" alt="">
          <span>Informations</span>
        </g:link>
      </li>
            
        <li>
          
        <g:link controller ="famille" action ="projetFamille" id="${familleInstance.id}" title="Projets">
          <img src="${request.contextPath}/img/start-icons/orders.png" alt="">
          <span>Projets associés</span>
        </g:link>
      </li>
      <li>
        
        <g:link controller ="famille" action ="indicateurFamille" id="${familleInstance.id}" title="Indicateurs">
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
       <td><g:message code="famille.nom.label" default="Description : " /></td>
       <td><span class="input-xlarge uneditable-input"> ${familleInstance?.nom}</span></td>
       
   </tr>
   <tr>
       <td><g:message code="famille.travaille.label" default="Famille travaillée : " /></td>
       <td><span class="input-xlarge uneditable-input"> ${familleInstance?.travaille}</span></td>
       
   </tr>
   <tr>
       <td><g:message code="famille.ordo.label" default="Nombre de types de livrables : " /></td>
       <td><span class="input-xlarge uneditable-input"> ${familleInstance?.ordo.size()}</span></td>
       
   </tr>
   <tr>
       <td><g:message code="famille.ordo.label" default="Livrables associés : " /></td>
       <td><g:each in="${familleInstance.ordo}" status="i" var="ordoInstance">
         <span class="input-xlarge uneditable-input"> ${ordoInstance.nom.toString()}</span>
         </br></g:each></td>
       
   </tr>
   <tr>
       <td><g:message code="famille.ordo.label" default="Activités : " /></td>
       <td><g:each in="${familleInstance.ordo}" status="i" var="ordoInstance">
         <span class="input-xlarge uneditable-input"> ${ordoInstance.phases}</span>
         </br></g:each></td>
       
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
 <script>
           function valider() {
             alert("ok");
           }
         </script>
                                                                      
                                                          
                                                        
                                                        				<!-- end main content -->
			
				<g:render template="/menues/mainright" />


    
    <script src="${request.contextPath}/js/include/amchart/amcharts.js"></script>
    <script src="${request.contextPath}/js/include/amchart/serial.js"></script>
    <script src="${request.contextPath}/js/include/amcharts/amcharts/themes/black.js"></script>
    
    
    <!-- creer par NL pour gerer tous les graphiques -->
    <script src="${request.contextPath}/js/include/indicateur.js"></script>
    