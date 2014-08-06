<div class="jarviswidget">
									    <header>
									        <h2>Grille d'imputation</h2>                           
									    </header>
									    <!-- wrap div -->
									    <div>
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
                                                                                
												<table class="table hover table-bordered responsive">
													<thead>
														<tr>
                                                                                                                  <th>Nom du projet</th>
                                                                                                                  <th>Phase</th>
															<th>Lundi</th>
															<th>Mardi</th>
															<th>Mercredi</th>
															<th>Jeudi</th>
															<th>Vendredi</th>
														</tr>
													</thead>
													<tbody class="responsive"><g:each in="${lignes}" status="i" var="ligne">
                                                                                                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                                                              <td><center><g:link action="show" controller="Kanban" id="${ligne.get("Of").kanban.id}" class="btn-link"  data-toggle="tooltip" title="afficher le projet">${ligne.get("Of").kanban.nomKanban}</g:link></center></td>
                                                                                                          
                                                                                                              <td><center>${ligne.get("Of").phase.nom}</center></td>
                                                                                                          
                                                                                                           <td>
                                                                                                           <center>
                                                                                                             <input type="text" class="input-mini" value="${ligne.get("Lundi")*.eventEffectif.event.dureeHeures.sum()}" id ="i1${i}">
                                                                                                             <input type="hidden" class="input-mini" value="${ligne.get("Lundi").id}" id ="v1${i}">
                                                                                                           </center>                                                                                                           
                                                                                                           </td>
                                                                                                           <td>
                                                                                                           <center>
                                                                                                             <input type="text" class="input-mini" value="${ligne.get("Mardi")*.eventEffectif.event.dureeHeures.sum()}" id ="i2${i}">
                                                                                                             <input type="hidden" class="input-mini" value="${ligne.get("Mardi").id}" id ="v2${i}">
                                                                                                           </center>                                                                                                           
                                                                                                           </td>
                                                                                                           <td>
                                                                                                           <center>
                                                                                                             <input type="text" class="input-mini" value="${ligne.get("Mercredi")*.eventEffectif.event.dureeHeures.sum()}" id ="i3${i}">
                                                                                                             <input type="hidden" class="input-mini" value="${ligne.get("Mercredi").id}" id ="v3${i}">
                                                                                                           </center>                                                                                                           
                                                                                                           </td>
                                                                                                           <td>
                                                                                                           <center>
                                                                                                             <input type="text" class="input-mini" value="${ligne.get("Jeudi")*.eventEffectif.event.dureeHeures.sum()}" id ="i4${i}">
                                                                                                             <input type="hidden" class="input-mini" value="${ligne.get("Jeudi").id}" id ="v4${i}">
                                                                                                           </center>                                                                                                           
                                                                                                           </td>
                                                                                                           <td>
                                                                                                           <center>
                                                                                                             <input type="text" class="input-mini" value="${ligne.get("Vendredi")*.eventEffectif.event.dureeHeures.sum()}" id ="i5${i}">
                                                                                                             <input type="hidden" class="input-mini" value="${ligne.get("Vendredi").id}" id ="v5${i}">
                                                                                                           </center>                                                                                                           
                                                                                                           </td>
                                                                                                          </tr>
                                                                                                          </g:each>
													</tbody>
												</table>
										        	
										    </div>
										    <!-- end content-->
									    </div>  </div>
                                                                        
                                                                            
                                                                        <a class="btn btn-info pull-right" href="#" onClick ="imputer(${lignes.size()});return false;">Valider</a>
                                                                         <g:link  action="imputer" controller="imputation"  class=" btn btn-warning pull-right">Annuler</g:link>      
                                                                            