<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
  </head>

  
 <g:render template="/menues/mainleft" />
				
				
				<div id="page-content">
					<!-- page header -->
					<h1 id="page-header">Messages Envoyés</h1>	
					
					<div class="fluid-container">

						<div class="alert adjusted alert-info">
							<button class="close" data-dismiss="alert">×</button>
							<i class="cus-exclamation"></i>
							<strong>Info!</strong> Mobile version of this page is currently not supported.
						</div>
						<!-- NO WIDGETS ON THIS PAGE -->
							<div class="row-fluid">
								<article class="span12">
									
									<!-- new widget -->
									<div class="jarviswidget">

									    <!-- wrap div -->
									    
            							
								        <div class="inner-spacer"> 
								        <!-- content goes here -->
											<div class="inbox-body" id="inbox-body-js">
												<div class="inbox-control-panel">
												<g:link  action="create" controller="mail" class="btn medium btn-primary pull-right"><i class="icon-star"></i>  Nouveau message </g:link>
												</div>
												<div class="inbox-body-content" id="inbox-loading-panel-js">
													<h1 class="message-title">Objet :  ${mailInstance.objet} </h1>
													<h3 class="message-from">From ${mailInstance.author.username}</h3>
													 <h3 class="message-from">A: ${mailInstance.recepteur.recepteur.username} </h3>
													
													<div class="message-container">
														<div class="message-control-panel">
															<div class="btn-group">
																<a class="btn btn-primary medium" href="javascript:void(0);"><i class="icon-reply"></i> Reply</a>
																<a class="btn btn-primary medium dropdown-toggle" data-toggle="dropdown" href="javascript:void(0);"><span class="caret"></span></a>
																<ul class="dropdown-menu btn-small">
																	<li>
																		<a href="javascript:void(0);"><i class="cus-arrow-undo"></i> Reply All</a>
																	</li>
																	<li>
																		<a href="javascript:void(0);"><i class="cus-envelope"></i> Mark as unread</a>
																	</li>
																	<li>
																		<a href="javascript:void(0);"><i class=" cus-arrow-right"></i> Forward</a>
																	</li>
																	<li class="divider"></li>
																	<li>
																		<a href="javascript:void(0);"><i class="cus-cancel"></i> Cancel</a>
																	</li>
																</ul>
															</div>
															</div>
														<div class="message-body">
															<p>${mailInstance.message}</p>
															
															
															
															
														</div>
													</div>
												</div>
												<g:set var="listcompteur" value="${1}" />  
											</div><messagerie:listMessagerie>
                                                                            </messagerie:listMessagerie>
											</div>


										</div>
									    <!-- end content-->
									   
									    <!-- end wrap div -->
									</div>
									
									
									<!-- end widget -->
								</article>
							</div>
					</div>		
				</div>
				<!-- end main content -->
			
				
							
					
				
				
<g:render template="/menues/mainright" />