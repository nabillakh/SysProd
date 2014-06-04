 
	<!-- main theme files -->
	<link rel="stylesheet" href="${request.contextPath}/css/theme.css?v=1">
	<link rel="stylesheet" href="${request.contextPath}/css/theme-responsive.css?v=1">
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
       <td><g:message code="kanban.description.label" default="Description : " /></td>
       <td><span class="input-xlarge uneditable-input"> ${kanbanInstance?.description}</span></td>
       
   </tr>
   <tr>
       <td><g:message code="kanban.phaseActuelle.label" default="Etat d'avancement du projet : " /></td>
       <td><span class="input-xlarge uneditable-input"> ${kanbanInstance?.phaseActuelle.nom}</span></td>
       
   </tr>
   <tr>
       <td><g:message code="kanban.dateFinPlanifie.label" default="Date de fin planifiée : " /></td>
       <td><span class="input-xlarge uneditable-input"><g:formatDate class="input-xlarge uneditable-input"  code="kanban.dateFinPlanifie.label" format="dd-MM-yyyy" date="${kanbanInstance?.dateFinPlanifie}" /></span></td>
       
   </tr>
   <tr>
       <td><g:message code="kanban.chargePlanifiee.label" default="Charge planifiee : " /></td>
       <td><span class="input-xlarge uneditable-input">${kanbanInstance?.chargePlanifiee}</span></td>
       
   </tr>
   <tr>
       <td><g:message code="kanban.avancementAgenda.label" default="Charge dans agenda : " /></td>
       <td><span class="input-xlarge uneditable-input"> ${kanbanInstance?.getAvancementAgenda()}</span></td>
       
   </tr>
</table></center>
                                                                                  
											<!-- end content -->
									        </div>
									        
									    </div>
									    <!-- end widget div -->
									</div>

</article>
<article>

<div class="jarviswidget" id="widget-id-12" data-widget-fullscreenbutton="false" data-widget-editbutton="false" data-widget-deletebutton="false" data-widget-collapsed="false">
									    <header>
									        <h2>Organisation du projet</h2>                           
									    </header>
									    
									    <!-- widget div-->
									    <div>
									        <!-- end widget edit box -->
									                    
									        <div class="inner-spacer widget-content-padding"> 
                                                                                  <center>
                                                                                  
                                                                                  <table class="table table-responsive table-hover table-bordered" >
                                                                                    
                                                                                    
                                                                                    <tr><center><h4>Chef de projet :<g:link controller="Effectif" action="show" id="${kanbanInstance.chefProjet.id}" class="btn-link"> ${kanbanInstance.chefProjet.nom} ${kanbanInstance.chefProjet.prenom}</h4> </g:link> </center></tr>
                                                                                
                                                                                    
                                                                                    <tr><td>Phase : </td><g:each in="${ofs}" status="i" var="ofInstance">
                                                                                  <td><center><g:link controller="OF" action="show" id="${ofInstance.id}">${ofInstance.phase.ordre} : ${ofInstance.phase.nom} </g:link></br></center></td>
                                                                                </g:each> </tr>
                                                                                     <tr><td> Livraison : </td><g:each in="${ofs}" status="i" var="ofInstance">
                                                                                     <td><center><g:formatDate format ='dd-MM-yyyy' date="${ofInstance.dateFinPlanifie}" /> </br>
                                                                                     </td></g:each> </tr>
                                                                                     <tr><td>Affecté à : </td><g:each in="${ofs}" status="i" var="ofInstance"><td> <center><g:if test="${ofInstance.affectes}">
                                                                                         
                                                                                      <g:each in="${ofInstance.affectes}" status="j" var="aff">
                                                                                     <g:link controller="Effectif" action="show" id="${aff.effectif.id}" class="btn-link"><i class="icon-user icon-white"></i>  ${aff.effectif.nom} ${aff.effectif.prenom},</g:link></br>
                                                                                </g:each></g:if>
                                                                                       <g:else> 
                                                                                       </g:else></center></td>
                                                                                </g:each></tr>
                                                                                <tr> <td>Actif?</td><g:each in="${ofs}" status="i" var="ofInstance">
                                                                                 <td>
													<div class="switch switch-small" data-on-label="<i class='icon-ok icon-white'></i>" data-off-label="<i class='icon-remove'></i>">
													    <input type="checkbox" checked /> 
													</div></td>
                                                                                </g:each>
                                                                                </tr>
                                                                                
                                                                                      </table>
                                                                                    
                                                                                    
                                                                                  
                                                                                  </center>
                                                                                  
											<!-- end content -->
									        </div>
									        
									    </div>
									    <!-- end widget div -->
									</div></article>
                  
                                                   
                         

                                                    <article class="span3">
                                                                                   
                                                        </br>
                                                        </br>
                                                        </br>
                                                      <!-- easy pie chart -->
							<div class="easypie">
								<div class="percentage" data-percent=${kanbanInstance.getAvancementRealise()}>
									<span>${kanbanInstance.getAvancementRealise()}</span>%
								</div>
							</div>
                                                    </article>   
        
        
        
        
	<!-- REQUIRED: iButton -->
    <script src="${request.contextPath}/js/include/jquery.ibutton.min.js"></script>
 
 
 
 
 
 
 
 
 