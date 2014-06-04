
<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Gestion des activités</title>
  </head>

  
 <g:render template="/menues/mainleft" />
   				
     <!-- main content --><div id="page-content">
					<!-- page header -->
					<h1 id="page-header">Management des activités</h1>	
                                        <!-- images avec données macro -->
                                        <div id="start">
							<ul>
								<li>
									<label>246 </label>
									<a href="javascript:void(0)" title="">
										<img src="${request.contextPath}/img/start-icons/orders.png" alt="">
										<span>Projets en cours</span>
									</a>
								</li>
								<li>
									<a href="javascript:void(0)" title="">
										<img src="${request.contextPath}/img/start-icons/orders.png" alt="">
										<span>Projets cloturés</span>
									</a>
								</li>
								<li>
									<label>new</label>
									<a href="javascript:void(0)" title="">
										<img src="${request.contextPath}/img/start-icons/stats.png" alt="">
										<span>Indicateurs</span>
									</a>
								</li>
								<li>
									<label>657</label>
									<a href="javascript:void(0)" title="">
										<img src="${request.contextPath}/img/start-icons/pending-message.png" alt="">
										<span>Projets en retard</span>
									</a>
								</li>
							</ul>

						</div>
					
                                        
                                        
                                        <div class="row-fluid">
								
								<article class="span12">
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-2">
									    <header>
									        <h2>Gestion opérationnelle</h2>                           
									    </header>
									    
									    <!-- widget div-->
									    <div>
									    	<!-- widget edit box -->
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
									        <!-- end widget edit box -->
            
									        <div class="inner-spacer widget-content-padding"> 
									        <!-- content -->	
												<ul id="myTab" class="nav nav-tabs default-tabs">
													<li class="active">
														<a href="#s1" data-toggle="tab">Famille d'activités</a>
													</li>
													<li>
														<a href="#s2" data-toggle="tab">Sous-Famille</a>
													</li>
                                                                                                        <li>
														<a href="#s3" data-toggle="tab">Liste d'activités</a>
													</li>
                                                                                                        <li>
														<a href="#s4" data-toggle="tab">Gestion des projets</a>
													</li>
													
												</ul>
												<div id="myTabContent" class="tab-content">
													<div class="tab-pane fade in active" id="s1">
                                                                                                          <div>
                                                                                                            <div class="inner-spacer"> 
                                                                                                              <table class="table table-striped table-bordered responsive" id="dtable">
                                                                                                                <thead>
                                                                                                                  <tr>
                                                                                                                    <th>Nom</th>
                                                                                                                    <th>Charge planifiee</th>
                                                                                                                    <th>Nombre de sous famille</th>
                                                                                                                    <th>Nombre de projets</th>
                                                                                                                  </tr>
                                                                                                                </thead>
                                                                                                                <tbody>

                                                                                                                <g:each in="${familleInstanceList}" status="i" var="familleInstance">
                                                                                                                  <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                                                                    <td><g:link action="show" controller="famille" id="${familleInstance.id}">${fieldValue(bean: familleInstance, field: "nom")}</g:link></td>
                                                                                                                <td>${familleInstance.chargePlanifiee}</td>
                                                                                                                <td>${familleInstance.ordo.size()}</td>
                                                                                                                <td>${familleInstance.nbProjets}</td>
                                                                                                                </tr>
                                                                                                                </g:each>
                                                                                                              </tbody>
                                                                                                              </table>


                                                                                                            </div>
                                                                                                            <!-- end content-->
                                                                                                          </div>
                                                                                                          <!-- end wrap div -->
                                                                                                        </div>
                                                                                                  <div class="tab-pane fade" id="s2">
                                                                                                    <div>
                                                                                                      <div class="inner-spacer"> 
                                                                                                        <table class="table table-striped table-bordered responsive" id="dtable">
													<thead>
                                                                                                          <tr>
                                                                                                            <th>Nom</th>
                                                                                                            <th>Famille associée</th>
                                                                                                            <th>Nb d'activités</th>
                                                                                                          </tr>
                                                                                                        </thead>
													<tbody>
                                                                                                        
                                                                                                        <g:each in="${ordoInstanceList}" status="i" var="ordoInstance">
                                                                                                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                                                              <td><g:link action="show" controller="Ordonnancement" id="${ordoInstance.id}">${fieldValue(bean: ordoInstance, field: "nom")}</g:link></td>
                                                                                                          <td>${ordoInstance.famille}</td>
                                                                                                          <td>${ordoInstance.phases.size()}</td>
                                                                                                          </tr>
                                                                                                          </g:each>
                                                                                                        </tbody>
												</table>
										
										        	
										    </div>
										    <!-- end content-->
									    </div>
													</div>
													<div class="tab-pane fade" id="s3">
													 <div>
									    
									        
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
                                                                                
												<table class="table table-striped table-bordered responsive" id="dtable">
													<thead>
														<tr>
															<th>Nom</th>
															<th>Sous Famille associée</th>
															<th>Competence necessaire</th>
															<th>Nb kanbans</th>
														</tr>
													</thead>
													<tbody>
                                                                                                        
                                                                                                        <g:each in="${phaseInstanceList}" status="i" var="phaseInstance">
                                                                                                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                                                              <td><g:link action="show" controller="phase" id="${phaseInstance.id}">${fieldValue(bean: phaseInstance, field: "nom")}</g:link></td>
                                                                                                          <td>${phaseInstance.monOrdo.nom}</td>
                                                                                                          <td>${phaseInstance.competence.nom}</td>
                                                                                                          <td>${phaseInstance.kanbans.size()}</td>
                                                                                                          </tr>
                                                                                                          </g:each>
                                                                                                        </tbody>
												</table>
										
										        	
										    </div>
										    <!-- end content-->
									    </div>
													</div>
													<div class="tab-pane fade" id="s4">
														<div>
									    
									        
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
                                                                                
												<table class="table table-striped table-bordered responsive" id="dtable">
													<thead>
														<tr>
															<th>Nom projet</th>
															<th>Description</th>
															<th>Etape du projet</th>
															<th>Date de livraison</th>
															<th>Charge</th>
														</tr>
													</thead>
													<tbody>
                                                                                                        
                                                                                                        <g:each in="${kanbanInstanceList}" status="i" var="kanbanInstance">
                                                                                                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                                                              <td><g:link action="show" controller="kanban" id="${kanbanInstance.id}">${fieldValue(bean: kanbanInstance, field: "nomKanban")}</g:link></td>
                                                                                                          <td>${fieldValue(bean: kanbanInstance, field: "description")}</td>
                                                                                                          <td>${kanbanInstance.phaseActuelle.nom}</td>
                                                                                                          <td><g:formatDate format ='dd-MM-yyyy'date="${kanbanInstance.dateFinPlanifie}" /></td>
                                                                                                          <td>${fieldValue(bean: kanbanInstance, field: "chargePlanifiee")}</td>
                                                                                                          </tr>
                                                                                                          </g:each>
                                                                                                        </tbody>
												</table>
										
										        	
										    </div>
										    <!-- end content-->
									    </div>
                                                                                                        </div>
												</div>
											<!-- end content -->	
									        </div>
									        
									    </div>
									    <!-- end widget div -->
									</div>
									<!-- end widget -->
								</article>
								
								
							</div>
                                        
                                        
                                        <!-- fin tableau superieru -->
                                        
						<!-- end widget grid -->
					</div>	

<g:render template="/menues/mainright" />



 
