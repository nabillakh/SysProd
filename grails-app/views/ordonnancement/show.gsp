<!DOCTYPE html>
<%@ page import="application.MailService" %>
<%
    def myService = grailsApplication.classLoader.loadClass('application.MailService').newInstance()
%>
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
                                                                                    
                                                                                    
                                                                                    <g:if test="${ordonnancementInstance?.nom}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="description">
                                                                                   <g:message code="ordonnancement.nom.label" default="Nom : " /><g:fieldValue bean="${ordonnancementInstance}" field="nom"/>
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if>
                                                                                    
                                                                                    <g:if test="${ordonnancementInstance?.famille}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="famille">
                                                                                   <g:message code="ordonnancement.famille.label" default="Famille : " /><g:fieldValue bean="${ordonnancementInstance}" field="famille"/>
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
                                                                                    
                                                                                    
                                                                                    <g:if test="${ordonnancementInstance?.nom}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="description">
                                                                                   <g:message code="ordonnancement.nom.label" default="Nom : " /><g:fieldValue bean="${ordonnancementInstance}" field="nom"/>
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if>
                                                                                    
                                                                                    <g:if test="${ordonnancementInstance?.famille}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="famille">
                                                                                   <g:message code="ordonnancement.famille.label" default="Famille : " /><g:fieldValue bean="${ordonnancementInstance}" field="famille"/>
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