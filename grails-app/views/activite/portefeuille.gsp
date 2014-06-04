

<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Gestion du portefeuille</title>
                <g:javascript library="jquery" plugin="jquery" />
  </head>

  
 <g:render template="/menues/mainleft" />
				
				<!-- main content -->
				<div id="page-content">
					<!-- page header -->
					<h1 id="page-header">Gestion du portefeuille</h1>	
					
					<div class="fluid-container">
						
						<!-- widget grid -->
						<section id="widget-grid" class="">
							

							<!-- row-fluid -->
							
							<div class="row-fluid">
								
                                                                                                                  
                                                      <!-- wiazrd de creation d'un kanban -->
                                                      
								<article class="span6">
									
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-0">
									    <header>
									        <h2>Edition d'un projet</h2> 
									                                  
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
												<form id="wizard" class="themed">
																							
													<div id="wizard_kanban">
														
														<!-- wizard steps -->
														<ul class="bwizard-steps">
														  	<li>
														  		<span class="label badge-inverse">1</span>
														  		<a href="#inverse-tab1" data-toggle="tab">Général</a>
														  	</li>
															<li>
																<span class="label badge-inverse">2</span>
																<a href="#inverse-tab2" data-toggle="tab">Ordonnancement</a>
															</li>
															<li>
																<span class="label badge-inverse">3</span>
																<a href="#inverse-tab3" data-toggle="tab">Affectations</a>
															</li>
															<li>
																<span class="label badge-inverse">4</span>
																<a href="#inverse-tab4" data-toggle="tab">Indicateur</a>
															</li>
														</ul>
                                                                                                                
                                                                                                                      <input type="hidden" id="monId" value = "NC" >
														<!-- end wizard steps -->
														
														<div class="tab-content">
															<!-- step 1-->
														    <fieldset class="tab-pane" id="inverse-tab1">
																<div class="control-group">
																	<label class="control-label" for="nomKanban">Nom du projet</label>
                                                                                                                                        
																		<input type="text" class="span12" id="nomKanban" required value=${monKanban.nomKanban}>
                                                                                                                                                
																</div>
																<div class="control-group">
																	<label class="control-label" for="description">Description</label>
                                                                                                                                        
																		<input type="text" class="span12" id="description" value=${monKanban.description}>
                                                                                                                                                
																</div>
																<div class="control-group">
																	<label class="control-label" for="fam" >Famille de projet</label>
																	<div class="controls">
                                                                                                                                          <select id="fam" class="span12" value=${monKanban.famille}>
                                                                                                                                            <g:each in="${familleInstanceList}" status="i" var="famille">
                                                                                                                                            <option value=${famille.id} > ${famille.nom}</option>
                                                                                                                                            </g:each>
                                                                                                                                          </select>
                                                                                                                                        </div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="sfam">Sous famille de projet</label>
																	<div class="controls">
                                                                                                                                          <select id="sfam" class="span12" value=${monKanban.ordo}>
                                                                                                                                            <g:each in="${application.PP.Ordonnancement.list()}" status="i" var="ordo">
                                                                                                                                            <option value=${ordo.id} > ${ordo.nom}</option>
                                                                                                                                            </g:each>
                                                                                                                                          </select>
                                                                                                                                        </div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="dateLivraison">Date de livraison prévisionnelle</label>
																	<div class="controls">
																		<input type="date" class="span12" id="dateLivraison" value=${monKanban.dateFinPlanifie}>
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="chargePlanifiee">Charge facturable</label>
																	<div class="controls">
																		<input type="text" class="span12" id="chargePlanifiee" value=${monKanban.chargePlanifiee}>
																	</div>
																</div>
														    </fieldset>
														    <!-- step 2-->
														    <fieldset class="tab-pane" id="inverse-tab2">
                                                                                                                      
                                                                                                                      
                                                                                                                    <div id="gestionOF">
                                                                                                                      
                                                                                                                      <g:if test="${mesOF}">
                                                                                                                      <g:each in="${mesOF}" status="o" var="unOF">
                                                                                                                        l'id est : ${unOF.kanban.id} et son nom est : ${unOF.kanban.nomKanban}
                                                                                                                        <div class="control-group">
                                                                                                                          <label class="control-label" for="nomPhase">Nom de l'activité</label>
                                                                                                                          <div class="controls">${unOF.phase.nom}                                                                                                                          </div>
                                                                                                                          <label class="control-label" for="nomPhase">Charge</label>
                                                                                                                          <div class="controls">${unOF.chargePlanifiee}
                                                                                                                    </div>
                                                                                                                          <label class="control-label" for="nomPhase">Ressources</label>
                                                                                                                          <div class="controls">${unOF.affectes.nom}
                                                                                                                          </div>
                                                                                                                        </div>
                                                                                                                      </g:each>
                                                                                                                      </g:if>
                                                                                      
                                                                                                                                                                          
                                                                                    

														    </fieldset> 
                                                                                                                    
                                                                                                                    
														    <!-- step 3-->
														    <fieldset class="tab-pane" id="inverse-tab3">
																<div class="control-group">
																	<label class="control-label" for="s4">Sample Input</label>
																	<div class="controls">
																		<input type="text" class="span12" id="s4">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="s5">Sample Input</label>
																	<div class="controls">
																		<input type="text" class="span12" id="s5">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="s6">Sample Input</label>
																	<div class="controls">
																		<input type="text" class="span12" id="s6">
																	</div>
																</div>
														    </fieldset>
														    <!-- step 4-->
														    <fieldset class="tab-pane" id="inverse-tab4">
																<div class="control-group">
																	<label class="control-label" for="s7">Sample Input</label>
																	<div class="controls">
																		<input type="text" class="span12" id="s7">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="s8">Sample Input</label>
																	<div class="controls">
																		<input type="text" class="span12" id="s8">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="s9">Sample Input</label>
																	<div class="controls">
																		<input type="text" class="span12" id="s9">
																	</div>
																</div>
														    </fieldset>
														    
														    <!-- wizard -->
														    <div class="form-actions wizard">
														    	<div class="span6 hidden-phone">
														    		<strong class="" style="margin-right: 5px; line-height: 25px; float:left;">Start</strong>
														    		<strong class="" style="margin-left: 5px; line-height: 25px;">Finish</strong>
																	<div id="bar" class="progress progress-info slim" style="margin-bottom:0;">
																		<div class="bar"></div>
																	</div>
														    	</div>

																<div class="span6">
															    	<ul style="list-style: none;">
																		<li class="previous">
																			<a href="javascript:void(0);" class="btn medium btn-danger">
																				Precedent
																			</a>
																		</li>
																		<li class="next">
																			<a href="javascript:void(0);" class="next">
																				Page suivante
																			</a>
																		</li>
															    	</ul>
																</div>

															</div>
														</div>
															
													</div>
									
												</form>
                                                                                
                                                                                                                   
																
										    </div>
										    <!-- end content-->
									    </div>
									    <!-- end wrap div -->
									</div>
									
									
									<!-- end widget -->
								</article>
                                                      
                                                      <article class="span6">
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-1">
									    <header>
									        <h2>Portefeuille</h2>                           
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
            
									        <div class="inner-spacer" id="listeKanbans"> 
                                                                                  
										    </div>
                                                                              <script type="text/javascript">
                                                                                        <g:remoteFunction action="listeKanban" update="listeKanbans"/>;
                                                                                      </script>
										    <!-- end content-->
                                                                                  </div>
									    <!-- end wrap div -->
									</div>
                                                                        
									<!-- end widget -->
								</article>
							</div>
                                                        
                                                        

						</section>
                                                
                                                
                                                
						<!-- end widget grid -->
					</div>		
				</div>
                                
                                
                                
                                                                                    
                                                                                     
                               
				<!-- end main content -->
			
<g:render template="/menues/mainright" />