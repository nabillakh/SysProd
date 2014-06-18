<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
  </head>

 
 <g:render template="/menues/mainleft" />		
<div id="page-content">
					<!-- page header -->
					<h1 id="page-header"> Ordonnancement  </h1>	
					
					<div class="fluid-container">
						
						<!-- widget grid -->
						<section id="widget-grid" class="">
							

							<!-- row-fluid -->
							
							<div class="row-fluid">
								<article class="span12">
                                                                   
									<!-- new widget -->
									<table>
									<!-- new widget -->
									<tr><td style=" width:500px;"><div class="jarviswidget" id="widget-id-1">
									    <header>
									        <h2>Fiche de l'Ordonnancement : </h2>                           
									    </header>
									    <!-- wrap div -->
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
                                                                                <center>
                                                                                    
                                                                                     <g:if test="${phaseInstance?.nom}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="Nom">
                                                                                   <g:message code="phase.nom.label" default="Nom : " /><g:fieldValue bean="${phaseInstance}" field="nom"/>
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if>
                                                                                    
                                                                                    <g:if test="${phaseInstance?.cleRepartition}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="famille">
                                                                                   <g:message code="phase.cleRepartition.label" default="cleRepartition : " /><g:fieldValue bean="${phaseInstance}" field="cleRepartition"/>
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if>
                                                                                 
                                                                               <g:if test="${phaseInstance?.competence}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="competence">
                                                                                   <g:message code="phase.competence.label" default="competence : " /><g:fieldValue bean="${phaseInstance}" field="competence.nom"/>
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if> 
                                                                                   <g:if test="${phaseInstance?.monOrdo.nom}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="monOrdo">
                                                                                   <g:message code="phase.monOrdo.label" default="monOrdo : " /><g:fieldValue bean="${phaseInstance}" field="monOrdo.nom"/>
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if>  
                                                                                    <g:if test="${phaseInstance?.kanbans}">
                                                                                     <g:each in="${phaseInstance.kanbans}" var="o">
                                                                                <div class="control-group" style=" text-align: left;">
                                                                                  <label class="control-label"  for="kanbans">
                                                                                <g:message code="phase.kanbans.label" default="Kanban : " />  <g:link controller="kanbans" action="show" id="${o.id}">${o?.nomKanban.encodeAsHTML()}</g:link>
                                                                                  </label>
                                                                                </div>
                                                                                </g:each>
                                                                                </g:if>
                                                                                    
                                                                                     <g:if test="${phaseInstance?.ordre}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="ordre">
                                                                                   <g:message code="phase.ordre.label" default="monOrdo : " /><g:fieldValue bean="${phaseInstance}" field="ordre"/>
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if>
                                                                                 
                                                                               
                                                                                
                                                                                  </center>
                                                                                </div>
                                                                              
                                                                              
                                                                              
										    <!-- end content-->
									    </div>
									    <!-- end wrap div -->
									</div></td>
                                                                          <td style=" width:500px;"><div class="jarviswidget" id="widget-id-1">
									    <header>
									        <h2>Fiche d'activité : </h2>                           
									    </header>
									    <!-- wrap div -->
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
                                                                                <center>
                                                                                    
                                                                                    
                                                                                   <g:if test="${phaseInstance?.nom}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="Nom">
                                                                                   <g:message code="phase.nom.label" default="Nom : " />
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if>
                                                                                    
                                                                                    <g:if test="${phaseInstance?.cleRepartition}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="famille">
                                                                                   <g:message code="phase.cleRepartition.label" default="cleRepartition : " />
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if>
                                                                                 
                                                                               <g:if test="${phaseInstance?.competence}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="competence">
                                                                                   <g:message code="phase.competence.label" default="competence : " />
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if> 
                                                                                   <g:if test="${phaseInstance?.monOrdo.nom}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="monOrdo">
                                                                                   <g:message code="phase.monOrdo.label" default="monOrdo : " />
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if>  
                                                                                    <g:if test="${phaseInstance?.kanbans}">
                                                                                     <g:each in="${phaseInstance.kanbans}" var="o">
                                                                                <div class="control-group" style=" text-align: left;">
                                                                                  <label class="control-label"  for="kanbans">
                                                                                <g:message code="phasekanbans.label" default="Kanban : " />  <g:link controller="kanbans" action="show" id="${o.id}"></g:link>
                                                                                  </label>
                                                                                </div>
                                                                                </g:each>
                                                                                </g:if>
                                                                                    
                                                                                     <g:if test="${phaseInstance?.ordre}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="ordre">
                                                                                   <g:message code="phase.ordre.label" default="monOrdo : " />
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if>
                                                                                 
                                                                               
                                                                                
                                                                                  </center>
                                                                                </div>
                                                                              
                                                                              
                                                                              
										    <!-- end content-->
									    </div>
									    <!-- end wrap div -->
									</div></td></tr></table>
                                                              
                                                                   
                                                          <g:link  action="activite" controller="administration"  class="btn medium">Retour</g:link>                   
                                                                            
                                                                      
							
<g:render template="/menues/mainright" />