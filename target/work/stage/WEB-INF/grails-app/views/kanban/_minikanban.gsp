
 
<g:if test="${affichageKanban == 1}">
  <g:set var="affichageKanban" value="$affichageKanban+1}" />

<div class="btn-group hidden-phone">
								<a href="javascript:void(0)" class="btn btn-inverse btn-small">Mes actions</a>
								<a href="javascript:void(0)" class="btn btn-inverse dropdown-toggle btn-small" data-toggle="dropdown"><span class="caret"></span></a>
					
								<div class="dropdown-menu toolbar pull-right">
									<h3>Afficher toutes mes tâches</h3>
									<ul class="progressbox">
                                                                          
                                                                          <g:each in="${mesOF}" status="i" var="monOF">
						                <li><g:link controller ="kanban" action ="show" id ="${monOF.kanban.id}"><strong>${monOF.kanban.nomKanban} - ${monOF.phase.nom}</br>En cours : ${monOF.getChargeRealisee() / monOF.chargePlanifiee *100}%</strong></b></g:link>
						                    <div class="progress progress-success slim"><div class="bar" style="width: ${monOF.getChargeRealisee() / monOF.chargePlanifiee *100}%;"></div></div>
						                </li>
                                                                          </g:each>
						                
						            </ul>
								</div>

							</div></g:if>