<table class="table table-striped table-bordered responsive" id="dtable">
													<thead>
														<tr>
                                                                                                                  
															<th> </th>
                                                                                                                        <th><center>Nom du projet</center></th>
															<th><center>Description</center></th>
														</tr>
													</thead>
													<tbody>
                                                                                                          <g:each in="${kanbanInstanceList}" status="i" var="kanbanInstance">
                                                                                                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                                                              <input type="hidden" id="kanban${i}" value = "${kanbanInstance.id}" >
                                                                                                              <td><center><a class="btn btn-primary medium" href="#" id="${kanbanInstance.id}" onClick ="modifierKanban(this.id);return false;">Modifier</a></center></td>
                                                                                                              <td><g:link action="show" controller = "kanban" id="${kanbanInstance.id}"><center> ${fieldValue(bean: kanbanInstance, field: "nomKanban")}</center></g:link></td>
                                                                                                          <td><center>${fieldValue(bean: kanbanInstance, field: "description")}</center></td>
                                                                                                          
                                                                                                          </tr>
                                                                                                          </g:each>
                                                                                                          
                                                                                                          </tbody>
												</table>