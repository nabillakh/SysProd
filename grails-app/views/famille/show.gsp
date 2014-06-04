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
					<h1 id="page-header"> Famille  </h1>	
					
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
									        <h2> Fiche de famille : </h2>                           
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
                                                                                    <g:if test="${familleInstance?.nom}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="description">
                                                                                   <g:message code="famille.nom.label" default="Nom : " /><g:fieldValue bean="${familleInstance}" field="nom"/>
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if>
                                                                                 <g:if test="${familleInstance?.ordo}">
                                                                                     <g:each in="${familleInstance.ordo}" var="o">
                                                                                <div class="control-group" style=" text-align: left;">
                                                                                  <label class="control-label"  for="Ordonnancement">
                                                                                  <g:link controller="ordonnancement" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link>
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
                                                                          <td style=" width:500px;"> <div class="jarviswidget" id="widget-id-1">
									    <header>
									        <h2>Fiche de famille : </h2>                           
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
                                                                                 <g:if test="${familleInstance?.ordo}">
                                                                                     <g:each in="${familleInstance.ordo}" var="o">
                                                                                <div class="control-group" style=" text-align: left;">
                                                                                  <label class="control-label"  for="Ordonnancement">
                                                                                  <g:link controller="ordonnancement" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link>
                                                                                  </label>
                                                                                </div>
                                                                                </g:each>
                                                                                </g:if>
                                                                                 <g:if test="${familleInstance?.nom}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="description">
                                                                                    <g:message code="famille.nom.label" default="Nom : " />
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