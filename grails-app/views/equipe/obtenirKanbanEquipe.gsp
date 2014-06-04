<header>
									        <h2>Projets</h2>                           
									    </header> <div>

<div class="inner-spacer"> 
									        <!-- content goes here -->
									        
												<table class="table table-striped table-bordered responsive" id="dtable">
													<thead>
														<tr>
                                                                                                                  <th>Nom du projet</th>
															<th>Description</th>
															<th>Phase du projet</th>
															<th>Date de fin planifiée</th>
														</tr>
													</thead>
													<tbody class="responsive"><g:each in="${kanbanInstanceList}" status="i" var="kanbanInstance">
                                                                                                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                                                              <td><g:link action="show" controller="Kanban" id="${kanbanInstance.id}">${fieldValue(bean: kanbanInstance, field: "nomKanban")}</g:link></td>
                                                                                                          <td>${fieldValue(bean: kanbanInstance, field: "description")}</td>
                                                                                                          <td>${kanbanInstance.phaseActuelle?.nom}</td>
                                                                                                          <td><g:formatDate date="${kanbanInstance.dateFinPlanifie}" /></td>
                                                                                                          </tr>
                                                                                                          </g:each>
													</tbody>
												</table>
										        	
										    </div>
										    </div>