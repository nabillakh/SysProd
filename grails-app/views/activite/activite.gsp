
<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Gestion des activités</title>
  </head>

  
 <g:render template="/menues/mainleft" />


				
				<!-- main content -->
				<div id="page-content">
					<!-- page header -->
					<h1 id="page-header">Activités en cours</h1>	
					
					<div class="fluid-container">
						
						<!-- widget grid -->
						<section id="widget-grid" class="">
							

							<!-- row-fluid -->
							
							<div class="row-fluid">
								<article class="span12">
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-1">
									    <header>
									        <h2>Column Filtering</h2>                           
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
									        
												<table class="table table-striped table-bordered responsive" id="col-filter">
													<thead>
														<tr>
															<th>Rendering engine</th>
															<th>Browser</th>
															<th>Platform(s)</th>
															<th>Engine version</th>
															<th>CSS grade</th>
														</tr>
														<tr class="second">
															<td>
																<input type="text" name="nomKanban" value="Filter engines" class="search_init">
															</td>
															<td>
																<input type="text" name="search_browser" value="Filter browsers" class="search_init">
															</td>
															<td>
																<input type="text" name="search_platform" value="Filter platforms" class="search_init">
															</td>
															<td>
																<input type="text" name="search_version" value="Filter versions" class="search_init">
															</td>
															<td>
																<input type="text" name="search_grade" value="Filter grades" class="search_init">
															</td>
														</tr>
													</thead>
													<tbody>
                                                                                                          <g:each in="${kanbanInstanceList}" status="i" var="kanbanInstance">
                                                                                                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                                                              <td><g:link controller="kanban" action="show" id="${kanbanInstance.id}">${fieldValue(bean: kanbanInstance, field: "nomKanban")}</g:link></td>
                                                                                                          <td>${fieldValue(bean: kanbanInstance, field: "description")}</td>
                                                                                                          <td>${fieldValue(bean: kanbanInstance, field: "phaseActuelle")}</td>
                                                                                                          <td><g:formatDate date="${kanbanInstance.dateFinPlanifie}" /></td>
                                                                                                          <td>${fieldValue(bean: kanbanInstance, field: "chargePlanifiee")}</td>
                                                                                                          </tr>
                                                                                                          </g:each>
                                                                                                          
                                                                                                          </tbody>
												</table>
										        	
										    </div>
										    <!-- end content-->
									    </div>
									    <!-- end wrap div -->
									</div>
									<!-- end widget -->
								</article>
							</div>
							
							<!-- end row-fluid -->

						
						<!-- end widget grid -->
					</div>		
				</div>
				<!-- end main content -->
			
<g:render template="/menues/mainright" />