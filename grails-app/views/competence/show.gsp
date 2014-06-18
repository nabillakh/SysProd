<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
  </head>

 
 <g:render template="/menues/mainleft" />		
<div id="page-content">
					<!-- page header -->
					<h1 id="page-header"> Competence  </h1>	
					
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
									        <h2>Fiche de competence : </h2>                           
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
                                                                                    
                                                                            <g:if test="${competenceInstance?.nom}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="nom">
                                                                                   <g:message code="Competence.nom.label" default="Nom : " /><g:fieldValue bean="${competenceInstance}" field="nom"/>
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if>
                                                                              
                                                                                
                                                                                 <g:if test="${competenceInstance?.effectifs}">
                                                                                     <g:each in="${competenceInstance.effectifs}" var="o">
                                                                                <div class="control-group" style=" text-align: left;">
                                                                                  <label class="control-label"  for="effectifs">
                                                                                <g:message code="competence.effectifs.label" default="Effectifs associés : " />  <g:link controller="Effectif" action="show" id="${o.id}">${o?.nom.encodeAsHTML()}</g:link>
                                                                                  </label>
                                                                                </div>
                                                                                </g:each>
                                                                                </g:if>
                                                                               
                                                                                
                                                                                  </center>
                                                                                </div>
                                                                              
                                                                              
                                                                              
										    <!-- end content-->
									    </div>
									    <!-- end wrap div -->
									</div></td>
                                                                          <td style=" width:500px;"><div class="jarviswidget" id="widget-id-1">
									    <header>
									        <h2>Fiche de competence : </h2>                           
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
                                                                                    
                                                                                    
                                                                                    <g:if test="${competenceInstance?.nom}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="nom">
                                                                                   <g:message code="Competence.nom.label" default="Nom : " /><g:fieldValue bean="${competenceInstance}" field="nom"/>
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if>
                                                                              
                                                                                  <g:if test="${competenceInstance?.effectifs}">
                                                                                     <g:each in="${competenceInstance.effectifs}" var="o">
                                                                                <div class="control-group" style=" text-align: left;">
                                                                                  <label class="control-label"  for="effectifs">
                                                                                <g:message code="competence.effectifs.label" default="Effectifs associés : " />  <g:link controller="Effectif" action="show" id="${o.id}">${o?.nom.encodeAsHTML()}</g:link>
                                                                                  </label>
                                                                                </div>
                                                                                </g:each>
                                                                                </g:if>
                                                                                 
                                                                               
                                                                                
                                                                                  </center>
                                                                                </div>
                                                                              
                                                                              
                                                                              
										    <!-- end content-->
									    </div>
									    <!-- end wrap div -->
									</div></td></tr></table>
                                                              
                                                                   
                                            <g:link  action="ressource" controller="administration"  class="btn medium">Retour</g:link>                                 
                                                                            
                                                                      
							
<g:render template="/menues/mainright" />