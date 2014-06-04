<g:if test="${listcompteur == 1}">
  <g:set var="listcompteur" value="${listcompteur+1}" />

                                                             
                                                                        <div class="inbox-menu">
                                                                          <div class="inbox-control-panel">
                                                                            
                                                                            <a href="#" OnClick="javascript:window.location.reload()" id='refresh-inbox-menu' class="btn medium pull-right"><i class="icon-refresh"></i> Refresh</a>
                                                                          </div>
												<!-- SLIDING MENU -->
												<div class="slashc-sliding-menu" id="inbox-menu-js">	
													<h1 id="inbox-menu-header-js">
														<span>test</span> 
														<a title="Slide Back Home" href="${request.contextPath}/javascript:void(0);" class="slashc-sliding-menu-home btn btn-inverse">
															<i class="icon-angle-left"></i>
														</a>
													</h1>
													<ul class="mailbox" id="mailbox-js">
														<li><a href="${request.contextPath}/javascript:void(0);"><span>Inbox</span><script> if (${mailNonLu.size()} != 0)  {  document.write('<span class="badge">${mailNonLu.size()} </span> ');}  </script><i class="icon-angle-right"></i></a>
															<ul>
                                                                                                                          <g:each in="${mesEffectifsMails}" status="i" var="mailEffectifInstance">
																<li>
																	<g:link  controller="MailEffectif"  action="show"  id="${mailEffectifInstance.id}">  
																		<span class="tiny-sub">
																			From: ${mailEffectifInstance.mail.author.username}
                                                                                                                                                        Objet: ${mailEffectifInstance.mail.objet}
																			
																			<span class="tiny-des">${mailEffectifInstance.mail.message}</span>
																		</span>
																	</g:link>
																</li>
                                                                                                                          </g:each>
																
																<li>
																	<div class="push-down"></div>
																</li>
															</ul>
														</li>
														<li>
															<a href="${request.contextPath}/javascript:void(0);"><span>Envoyés</span><i class="icon-angle-right"></i></a>
															<ul>
															<g:each in="${mesMailsSent}" status="i" var="mailInstance">	
                                                                                                                            <li>
                                                                                                                                 <g:link  controller="Mail"  action="show"  id="${mailInstance.id}">
                                                                                                                              <span class="tiny-sub">
                                                                                                                                From :${mailInstance.recepteur.recepteur.username}                                                                                                                              
                                                                                                                                Objet : ${mailInstance.objet}
                                                                                                                               
                   <!--<i class="icon-paper-clip"></i>-->
                                                                                                                                <span class="tiny-des">${mailInstance.message}</span>
                                                                                                                              </span>
                                                                                                                               </g:link>
                                                                                                                        </li> 
                                                                                                                        </g:each>
															</ul>
														</li>
                                                                                                               
														<li>
															<a href="${request.contextPath}/javascript:void(0);"><span>Corbeille</span><i class="icon-angle-right"></i></a>
															<ul>
																 <g:each in="${mesEffectifMailsArchiver}" status="i" var="mailEffectifArchiverInstance">
																<li>
																	<g:link  controller="MailEffectif"  action="show"  id="${mailEffectifArchiverInstance.id}">  
																		<span class="tiny-sub">
																			From: ${mailEffectifArchiverInstance.mail.author.username}
                                                                                                                                                        Objet: ${mailEffectifArchiverInstance.mail.objet}
																			
																			<span class="tiny-des">${mailEffectifArchiverInstance.mail.message}</span>
																		</span>
																	</g:link>
																</li>
                                                                                                                          </g:each>
															</ul>
														</li>
														<li>
															<a href="${request.contextPath}/javascript:void(0);"><span>Favoris</span><i class="icon-angle-right"></i></a>
															<ul>
																 <g:each in="${mesmailEffectifFavoris}" status="i" var="mesmailEffectifFavorisInstance">
																<li>
																	<g:link  controller="MailEffectif"  action="show"  id="${mesmailEffectifFavorisInstance.id}">  
																		<span class="tiny-sub">
																			From: ${mesmailEffectifFavorisInstance.mail.author.username}
                                                                                                                                                        Objet: ${mesmailEffectifFavorisInstance.mail.objet}
																			
																			<span class="tiny-des">${mesmailEffectifFavorisInstance.mail.message}</span>
																		</span>
																	</g:link>
																</li>
                                                                                                                          </g:each>
															</ul>
														</li>
													</ul>
												</div>
												<!-- end SLIDING MENU -->
											</div>
  
  
  
  
</g:if>