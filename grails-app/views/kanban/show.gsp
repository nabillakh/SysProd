
  <head>
		<meta name="layout" content="main2"/>
		<title>Sysprod</title>
                <g:javascript library="jquery" plugin="jquery" />
  </head>

 <g:render template="/menues/menuGauche" />



 

		<!-- MAIN PANEL -->
		<div id="main" role="main">

			<!-- RIBBON -->
			<div id="ribbon">

				<span class="ribbon-button-alignment"> <span id="refresh" class="btn btn-ribbon" data-action="resetWidgets" data-title="refresh"  rel="tooltip" data-placement="bottom" data-original-title="<i class='text-warning fa fa-warning'></i> Warning! This will reset all your widget settings." data-html="true"> <i class="fa fa-refresh"></i> </span> </span>

				<!-- breadcrumb -->
				<ol class="breadcrumb">
					<li>
						Accueil
					</li>
					<li>
						Gestion du portefeuille
					</li>
					<li>
						Fiche : ${kanbanInstance?.nomKanban}
					</li>
				</ol>
				<!-- end breadcrumb -->

				<!-- You can also add more buttons to the
				ribbon for further usability

				Example below:

				<span class="ribbon-button-alignment pull-right">
				<span id="search" class="btn btn-ribbon hidden-xs" data-title="search"><i class="fa-grid"></i> Change Grid</span>
				<span id="add" class="btn btn-ribbon hidden-xs" data-title="add"><i class="fa-plus"></i> Add</span>
				<span id="search" class="btn btn-ribbon" data-title="search"><i class="fa-search"></i> <span class="hidden-mobile">Search</span></span>
				</span> -->

			</div>
			<!-- END RIBBON -->
    <div class="content">
      
      <div id="content">

				<!-- Bread crumb is created dynamically -->
				<!-- row -->
				<div class="row">
				
					<!-- col -->
					<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
						<h1 class="page-title txt-color-blueDark"><!-- PAGE HEADER --><i class="fa-fw fa fa-file-o"></i> Projet <span>>
							Synthèse </span></h1>
					</div>
					<!-- end col -->
				
					<!-- right side of the page with the sparkline graphs -->
					<!-- col -->
                                        
					<!-- end col -->
				
				</div>
				<!-- end row -->
				
				<!-- row -->
				
				<div class="row">
				
					<div class="col-sm-12">
                                          
				
								<div class="row">
                                                                  <div class="col-sm-12 col-md-12 col-lg-2">
                                                                  </div>
									<div class="col-sm-12 col-md-12 col-lg-8">
										<div class="well well-light well-sm no-margin no-padding">
				
											<div class="row">
                                                                                          
				
												<div class="col-sm-12">
				
													<div class="row">
				
														<div class="col-sm-3 profile-pic">
															<img src="${request.contextPath}/img/mesimages/agenda.jpg" alt="Projet">
															<div class="padding-10">
																<h4 class="font-md"><strong>1,543</strong>
																<br>
																<small>Followers</small></h4>
																<br>
																<h4 class="font-md"><strong>419</strong>
																<br>
																<small>Connections</small></h4>
															</div>
														</div>
														<div class="col-sm-6">
															<h1>Projet :  <span class="semi-bold">${kanbanInstance.nomKanban}</span>
															<br>
															<small> Famille : ${kanbanInstance.famille.nom}</small></h1>
				
															<ul class="list-unstyled">
																<li>
																	<p class="text-muted">
																		<i class="fa fa-male"></i>&nbsp;&nbsp;<span class="txt-color-darken">Chef de projet : <a href="javascript:void(0);" rel="tooltip" title="" data-placement="top" data-original-title="Aller sur sa page">${kanbanInstance?.chefProjet.nom} ${kanbanInstance?.chefProjet.prenom}</a></span>
																	</p>
																</li>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-star"></i>&nbsp;&nbsp;<span class="txt-color-darken">Client : <a href="javascript:void(0);" rel="tooltip" title="" data-placement="top" data-original-title="Aller sur sa page">${kanbanInstance?.client.nom}</a></span>
																	</p>
																</li>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-calendar"></i>&nbsp;&nbsp;<span class="txt-color-darken">Livraison prévue : <a href="javascript:void(0);" rel="tooltip" title="" data-placement="top" data-original-title="Planifier une tâche"><g:formatDate class="input-xlarge uneditable-input"  code="kanban.dateFinPlanifie.label" format="dd-MM-yyyy" date="${kanbanInstance?.dateFinPlanifie}" /></a></span>
																	</p>
																</li>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-bookmark-o"></i>&nbsp;&nbsp;<span class="txt-color-darken">Etat d'avancement : <a href="javascript:void(0);" rel="tooltip" title="" data-placement="top" data-original-title="Aller sur la page de cette activité">${kanbanInstance?.phaseActuelle.nom}</a></span>
																	
                                                                                                                                        </p>
																</li>
															</ul>
															<br>
															<p class="font-md">
																<i>Description : </i>
															</p>
															<p>
				
																${kanbanInstance.description}
				
															</p>
															<br>
															<a href="javascript:void(0);" class="btn btn-default btn-xs"><i class="fa fa-envelope-o"></i> Modifier </a> 
                                                                                                                        <a href="javascript:void(0);" class="btn btn-default btn-xs"><i class="fa fa-envelope-o"></i> Affecter </a> 
                                                                                                                        <a href="javascript:void(0);" class="btn btn-default btn-xs"><i class="fa fa-envelope-o"></i> Autre </a>
															<br>
  
				
														</div>
														<div class="col-sm-3">
                                                                                                                  </br>Avancement :  </br></br>
                                                                                                                  <div class="easy-pie-chart txt-color-blue easyPieChart" data-percent="${kanbanInstance.getAvancementRealise()}" data-size="140" data-pie-size="120"><span class="percent percent-sign txt-color-blue font-xl semi-bold">${Math.round(kanbanInstance.getAvancementRealise()*10)/10} %</span> </div>                  

                                                                                                                </div>
				
													</div>
				
												</div>
				
											</div>
				
											<div class="row">
				
												<div class="col-sm-12">
				
													<hr>
				
													<div class="padding-10">
				
														<ul class="nav nav-tabs tabs-pull-right">
															<li class="">
																<a href="#a3" data-toggle="tab">Organigramme</a>
															</li>
															<li class="active">
																<a href="#a1" data-toggle="tab">Recent Articles</a>
															</li>
															<li>
																<a href="#a2" data-toggle="tab">New Members</a>
															</li>
															<li class="pull-left">
																<span class="margin-top-10 display-inline"><i class="fa fa-rss text-success"></i> Activitée </span>
															</li>
														</ul>
				
														<div class="tab-content padding-top-10">
                                                                                                                  <div class="tab-pane fade" id="a3">
				
																<div class="row">
                                                                                                                                
                                                                                                                        <div class="widget-body col-xs-2 col-sm-3"></div>
																			
									<div class="widget-body col-xs-2 col-sm-3"><h1><small>Affectations par activités : </small></h1>	
                                                                                                                        <div class="tree smart-form">
											<ul>
												<li>
													<span><i class="fa fa-lg fa-folder-open"></i> ${kanbanInstance.nomKanban} : </span>
													<ul>
														<g:each in="${ofs}" status="i" var="ofInstance">
                                                                                                                  <li>
															<span><i class="fa fa-lg fa-plus-circle"></i> ${ofInstance.phase.nom}</span>
															<ul><g:each in="${ofInstance.affectes}" status="j" var="aff">
																<li style="display:none">
																	<span>
                                                                                                                                          <i></i>  ${aff.effectif*.nom}, ${aff.effectif*.prenom}
																</li>	
                                                                                                                </g:each>															
															</ul>
														</li>
                                                                                                                </g:each>
														
													</ul>
												</li>												
											</ul>
										</div>
										</div>
                                                                                                                        <div class="widget-body col-xs-2 col-sm-3"><h1><small>Affectations par effectif : </small></h1>	
                                                                                                                        <div class="tree smart-form">
											<ul>
												<li>
													<span><i class="fa fa-lg fa-folder-open"></i> Effectifs : </span>
													<ul>
														<g:each in="${ofs}" status="i" var="ofInstance">
                                                                                                                  <li>
															<span><i class="fa fa-lg fa-plus-circle"></i> ${ofInstance.phase.nom}</span>
															<ul><g:each in="${ofInstance.affectes}" status="j" var="aff">
																<li style="display:none">
																	<span>
                                                                                                                                          <i></i>  ${aff.effectif*.nom}, ${aff.effectif*.prenom}
																</li>	
                                                                                                                </g:each>															
															</ul>
														</li>
                                                                                                                </g:each>
														
													</ul>
												</li>												
											</ul>
										</div>
										</div>
                                                                                                                        <div class="widget-body col-xs-2 col-sm-3"></div>      
                                                                                                                        <div class="widget-body col-xs-2 col-sm-12">
                                                                                                                        <div class="tree smart-form">
                                                                                                                          <ul><li>
                                                                                                                              <span><i class="fa fa-lg fa-plus-circle"></i> Ressources affectables : </span>
                                                                                                                           
                                                                                                                          <ul id="categories-source">
                                                                                                                            <g:each in="${mesEffectifs}" status="k" var="eff"> 

                                                                                                                              <li id="${eff.id}"  style="display:none">
																	<span>
                                                                                                                                          <i></i>  ${eff.nom} </br> ${eff.emploi}</li>

                                                                                                                            </g:each>
                                                                                                                          </ul>  
                                                                                                                          </li>  
                                                                                                                          </ul>  
                                                                                                                          </li>  
                                                                                                                          </ul>     
                                                                                                                        </div>
                                                                                                                          
                                                                                                                        <div class="control-group">
                                                                                                                          <ul id="categories-chosen" class='news-list interested categories-sortable'>
                                                                                                                            Ressources affectées :   
                                                                                                                            <g:each in="${application.RH.Effectif.list()}" status="k" var="eff">  
                                                                                                                              <li class="btn" id="${eff.id}">${eff.nom} </br>  ${eff.emploi}</li>
                                                                                                                            </g:each>     
                                                                                                                          </ul>
                                                                                                                        </div>   
                                                                                                                        </div>    

                                                                                                                        <script type="text/javascript">
                                                                                                                          
  $(function () {
    var oldList
  }, newList, item;
    $(".categories-sortable").sortable({
        connectWith: $('.categories-sortable'),
        start: function (event, ui) {
            item = ui.item;
            newList = oldList = ui.item.parent();
        },
        stop: function (event, ui) {
            console.log("Moved " + item.text() + " from " + oldList.attr('id') + " to " + newList.attr('id'));
        },
        change: function (event, ui) {
            if (ui.sender) {
                newList = ui.placeholder.parent();
            }
        },
    })
        .disableSelection();

});</script>
				
														
                                                                                                                                
                                                                                                                                </div>
				
															</div>
															<div class="tab-pane fade in active" id="a1">
				
																<div class="row">
				
																	<div class="col-xs-2 col-sm-1">
																		<time datetime="2014-09-20" class="icon">
																			<strong>Jan</strong>
																			<span>10</span>
																		</time>
																	</div>
				
																	<div class="col-xs-10 col-sm-11">
																		<h6 class="no-margin"><a href="javascript:void(0);">Allice in Wonderland</a></h6>
																		<p>
																			Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi Nam eget dui.
																			Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero,
																			sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel.
																		</p>
																	</div>
				
																	<div class="col-sm-12">
				
																		<hr>
				
																	</div>
				
																	<div class="col-xs-2 col-sm-1">
																		<time datetime="2014-09-20" class="icon">
																			<strong>Jan</strong>
																			<span>10</span>
																		</time>
																	</div>
				
																	<div class="col-xs-10 col-sm-11">
																		<h6 class="no-margin"><a href="javascript:void(0);">World Report</a></h6>
																		<p>
																			Morning our be dry. Life also third land after first beginning to evening cattle created let subdue you'll winged don't Face firmament.
																			You winged you're was Fruit divided signs lights i living cattle yielding over light life life sea, so deep.
																			Abundantly given years bring were after. Greater you're meat beast creeping behold he unto She'd doesn't. Replenish brought kind gathering Meat.
																		</p>
																	</div>
				
																	<div class="col-sm-12">
				
																		<br>
				
																	</div>
				
																</div>
				
															</div>
															<div class="tab-pane fade" id="a2">
				
																<div class="alert alert-info fade in">
																	<button class="close" data-dismiss="alert">
																		×
																	</button>
																	<i class="fa-fw fa fa-info"></i>
																	<strong>51 new members </strong>joined today!
																</div>
				
																<div class="user" title="email@company.com">
																	<img src="img/avatars/female.png" alt="demo user"><a href="javascript:void(0);">Jenn Wilson</a>
																	<div class="email">
																		travis@company.com
																	</div>
																</div>
																<div class="user" title="email@company.com">
																	<img src="img/avatars/male.png" alt="demo user"><a href="javascript:void(0);">Marshall Hitt</a>
																	<div class="email">
																		marshall@company.com
																	</div>
																</div>
																<div class="user" title="email@company.com">
																	<img src="img/avatars/male.png" alt="demo user"><a href="javascript:void(0);">Joe Cadena</a>
																	<div class="email">
																		joe@company.com
																	</div>
																</div>
																<div class="user" title="email@company.com">
																	<img src="img/avatars/male.png" alt="demo user"><a href="javascript:void(0);">Mike McBride</a>
																	<div class="email">
																		mike@company.com
																	</div>
																</div>
																<div class="user" title="email@company.com">
																	<img src="img/avatars/male.png" alt="demo user"><a href="javascript:void(0);">Travis Wilson</a>
																	<div class="email">
																		travis@company.com
																	</div>
																</div>
																<div class="user" title="email@company.com">
																	<img src="img/avatars/male.png" alt="demo user"><a href="javascript:void(0);">Marshall Hitt</a>
																	<div class="email">
																		marshall@company.com
																	</div>
																</div>
																<div class="user" title="Joe Cadena joe@company.com">
																	<img src="img/avatars/male.png" alt="demo user"><a href="javascript:void(0);">Joe Cadena</a>
																	<div class="email">
																		joe@company.com
																	</div>
																</div>
																<div class="user" title="email@company.com">
																	<img src="img/avatars/male.png" alt="demo user"><a href="javascript:void(0);">Mike McBride</a>
																	<div class="email">
																		mike@company.com
																	</div>
																</div>
																<div class="user" title="email@company.com">
																	<img src="img/avatars/male.png" alt="demo user"><a href="javascript:void(0);">Marshall Hitt</a>
																	<div class="email">
																		marshall@company.com
																	</div>
																</div>
																<div class="user" title="email@company.com">
																	<img src="img/avatars/male.png" alt="demo user"><a href="javascript:void(0);">Joe Cadena</a>
																	<div class="email">
																		joe@company.com
																	</div>
																</div>
																<div class="user" title="email@company.com">
																	<img src="img/avatars/male.png" alt="demo user"><a href="javascript:void(0);"> Mike McBride</a>
																	<div class="email">
																		mike@company.com
																	</div>
																</div>
				
																<div class="text-center">
																	<ul class="pagination pagination-sm">
																		<li class="disabled">
																			<a href="javascript:void(0);">Prev</a>
																		</li>
																		<li class="active">
																			<a href="javascript:void(0);">1</a>
																		</li>
																		<li>
																			<a href="javascript:void(0);">2</a>
																		</li>
																		<li>
																			<a href="javascript:void(0);">3</a>
																		</li>
																		<li>
																			<a href="javascript:void(0);">...</a>
																		</li>
																		<li>
																			<a href="javascript:void(0);">99</a>
																		</li>
																		<li>
																			<a href="javascript:void(0);">Next</a>
																		</li>
																	</ul>
																</div>
				
															</div><!-- end tab -->
														</div>
				
													</div>
				
												</div>
				
											</div>
											<!-- end row -->
				
										</div>
				
									</div>
									<div class="col-sm-12 col-md-12 col-lg-8">
				
										<form method="post" class="well padding-bottom-10" onsubmit="return false;">
											<textarea rows="2" class="form-control" placeholder="What are you thinking?"></textarea>
											<div class="margin-top-10">
												<button type="submit" class="btn btn-sm btn-primary pull-right">
													Post
												</button>
												<a href="javascript:void(0);" class="btn btn-link profile-link-btn" rel="tooltip" data-placement="bottom" title="Add Location"><i class="fa fa-location-arrow"></i></a>
												<a href="javascript:void(0);" class="btn btn-link profile-link-btn" rel="tooltip" data-placement="bottom" title="Add Voice"><i class="fa fa-microphone"></i></a>
												<a href="javascript:void(0);" class="btn btn-link profile-link-btn" rel="tooltip" data-placement="bottom" title="Add Photo"><i class="fa fa-camera"></i></a>
												<a href="javascript:void(0);" class="btn btn-link profile-link-btn" rel="tooltip" data-placement="bottom" title="Add File"><i class="fa fa-file"></i></a>
											</div>
										</form>
				
										<div class="timeline-seperator text-center"> <span>10:30PM January 1st, 2013</span>
											<div class="btn-group pull-right">
												<a href="javascript:void(0);" data-toggle="dropdown" class="btn btn-default btn-xs dropdown-toggle"><span class="caret single"></span></a>
												<ul class="dropdown-menu text-left">
													<li>
														<a href="javascript:void(0);">Hide this post</a>
													</li>
													<li>
														<a href="javascript:void(0);">Hide future posts from this user</a>
													</li>
													<li>
														<a href="javascript:void(0);">Mark as spam</a>
													</li>
												</ul>
											</div> 
										</div>
										<div class="chat-body no-padding profile-message">
											<ul>
												<li class="message">
													<img src="img/avatars/sunny.png" class="online" alt="sunny">
													<span class="message-text"> <a href="javascript:void(0);" class="username">John Doe <small class="text-muted pull-right ultra-light"> 2 Minutes ago </small></a> Can't divide were divide fish forth fish to. Was can't form the, living life grass darkness very
														image let unto fowl isn't in blessed fill life yielding above all moved </span>
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-info"><i class="fa fa-reply"></i> Reply</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-muted">Show All Comments (14)</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-primary">Edit</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger">Delete</a>
														</li>
													</ul>
												</li>
												<li class="message message-reply">
													<img src="img/avatars/3.png" class="online" alt="user">
													<span class="message-text"> <a href="javascript:void(0);" class="username">Serman Syla</a> Haha! Yeah I know what you mean. Thanks for the file Sadi! <i class="fa fa-smile-o txt-color-orange"></i> </span>
				
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-muted">1 minute ago </a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
													</ul>
				
												</li>
												<li class="message message-reply">
													<img src="img/avatars/4.png" class="online" alt="user">
													<span class="message-text"> <a href="javascript:void(0);" class="username">Sadi Orlaf </a> Haha! Yeah I know what you mean. Thanks for the file Sadi! <i class="fa fa-smile-o txt-color-orange"></i> </span>
				
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-muted">a moment ago </a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
													</ul>
													<input class="form-control input-xs" placeholder="Type and enter" type="text">
												</li>
											</ul>
				
										</div>
				
										<div class="timeline-seperator text-center"> <span>11:30PM November 27th, 2013</span>
											<div class="btn-group pull-right">
												<a href="javascript:void(0);" data-toggle="dropdown" class="btn btn-default btn-xs dropdown-toggle"><span class="caret single"></span></a>
												<ul class="dropdown-menu text-left">
													<li>
														<a href="javascript:void(0);">Hide this post</a>
													</li>
													<li>
														<a href="javascript:void(0);">Hide future posts from this user</a>
													</li>
													<li>
														<a href="javascript:void(0);">Mark as spam</a>
													</li>
												</ul>
											</div> 
										</div>
										<div class="chat-body no-padding profile-message">
											<ul>
												<li class="message">
													<img src="img/avatars/1.png" class="online" alt="user">
													<span class="message-text"> <a href="javascript:void(0);" class="username">John Doe <small class="text-muted pull-right ultra-light"> 2 Minutes ago </small></a> Can't divide were divide fish forth fish to. Was can't form the, living life grass darkness very image let unto fowl isn't in blessed fill life yielding above all moved </span>
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-info"><i class="fa fa-reply"></i> Reply</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-muted">Show All Comments (14)</a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-primary">Hide</a>
														</li>
													</ul>
												</li>
												<li class="message message-reply">
													<img src="img/avatars/3.png" class="online" alt="user">
													<span class="message-text"> <a href="javascript:void(0);" class="username">Serman Syla</a> Haha! Yeah I know what you mean. Thanks for the file Sadi! <i class="fa fa-smile-o txt-color-orange"></i> </span>
				
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-muted">1 minute ago </a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
													</ul>
				
												</li>
												<li class="message message-reply">
													<img src="img/avatars/4.png" class="online" alt="user">
													<span class="message-text"> <a href="javascript:void(0);" class="username">Sadi Orlaf </a> Haha! Yeah I know what you mean. Thanks for the file Sadi! <i class="fa fa-smile-o txt-color-orange"></i> </span>
				
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-muted">a moment ago </a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
													</ul>
				
												</li>
												<li class="message message-reply">
													<img src="img/avatars/4.png" class="online" alt="user">
													<span class="message-text"> <a href="javascript:void(0);" class="username">Sadi Orlaf </a> Haha! Yeah I know what you mean. Thanks for the file Sadi! <i class="fa fa-smile-o txt-color-orange"></i> </span>
				
													<ul class="list-inline font-xs">
														<li>
															<a href="javascript:void(0);" class="text-muted">a moment ago </a>
														</li>
														<li>
															<a href="javascript:void(0);" class="text-danger"><i class="fa fa-thumbs-up"></i> Like</a>
														</li>
													</ul>
				
												</li>
												<li>
													<div class="input-group wall-comment-reply">
														<input id="btn-input" type="text" class="form-control" placeholder="Type your message here...">
														<span class="input-group-btn">
															<button class="btn btn-primary" id="btn-chat">
																<i class="fa fa-reply"></i> Reply
															</button> </span>
													</div>
												</li>
											</ul>
				
										</div>
				
				
									</div>
								</div>
				
							</div>
				
				
					</div>
				
				</div>
      
      
      <div class="alert adjusted alert-info">
							<button class="close" data-dismiss="alert">×</button>
							<i class="cus-exclamation"></i>
							<strong>Info!</strong> Les principales informations de vos projets sont accessibles sur cette page. Ne perdez plus de temps à chercher les données essentielles à l'avancement de vos tâches.
						</div>
      
      
                                                  <div class="row">
                                  <article class="col-sm-12 col-md-12 col-lg-2">
                                    </article>
                                                    <article class="col-sm-12 col-md-12 col-lg-6">
                                                      
                                                      <center>
    <h4> Projet : ${kanbanInstance?.nomKanban} </h4> 
   <g:link  action="show" controller="Famille" id="${kanbanInstance.famille.id}"> <h4> Famille : ${kanbanInstance?.famille.nom}</h4></g:link>
    
    <div id="start">
      <ul class="list-inline">
        
      <li>
        <g:link controller ="kanban" action ="show" id ="${kanbanInstance.id}" title="Informations">
          <img src="${request.contextPath}/img/start-icons/mass.png" alt=""> </br>
          <span>Informations</span>
        </g:link>
      </li>
        <li>
        <g:link controller ="kanban" action ="obtenirJournal" id ="${kanbanInstance.id}" title="Journal">
          <img src="${request.contextPath}/img/start-icons/pending-message.png" alt=""></br>
          <span>Journal</span>
        </g:link>
      </li>
      
      <li>
        
        <g:link controller ="kanban" action ="indicateurKanban" id="${kanbanInstance.id}" title="Indicateurs">
          <img src="${request.contextPath}/img/start-icons/stats.png" alt=""></br>
          <span>Indicateurs</span>
        </g:link>
      </li>
      </ul>
      
    </div>
                                                      </center>
                                                    </article>
                                                    <article class="col-sm-12 col-md-12 col-lg-2">
                                                      <div class="easypie">
								<div class="percentage" data-percent=${kanbanInstance.getAvancementRealise()}>
									<span>${Math.round(kanbanInstance.getAvancementRealise()*10)/10}</span>%
								</div>
							</div>
    
                                                    </article>
                                                    
                                                    
                                                    
                                                    
                                                  </div>
                                                  
      <div class="row-fluid">
        <article class="span12">
        
        <div id="temp">
          
      </div>
          
									    <!-- a modifier-->
<div class="jarviswidget" id="contenu2" data-widget-collapsed="false">
  
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
                                                                                 <td><center>
													<div class="switch switch-small" data-on-label="<i class='icon-ok icon-white'></i>" data-off-label="<i class='icon-remove'></i>" onclick="valider()" >
                                                                                                          <input id="fini" onclick="valider()" type="checkbox" checked /> 
													</div></center></td>
                                                                                </g:each>
                                                                                </tr>
                                                                                
                                                                                      </table>
                                                                                    
                                                                                    
                                                                                  
                                                                                  </center>
                                                                                  
											<!-- end content -->
									        </div>
									        
									    </div>
									    <!-- end widget div -->
									</div></article>
                  
                                                   
                           
  
  
        </div>
          
        
        </article>       
        
      </div>
      
      
      
									    <!-- end widget div -->
									</div>

							</div>
 <script>
           function valider() {
             alert("ok");
           }
         </script>
  <script type="text/javascript">
		
		// DO NOT REMOVE : GLOBAL FUNCTIONS!
		
		$(document).ready(function() {
			
			pageSetUp();
			
			// PAGE RELATED SCRIPTS
		
			$('.tree > ul').attr('role', 'tree').find('ul').attr('role', 'group');
			$('.tree').find('li:has(ul)').addClass('parent_li').attr('role', 'treeitem').find(' > span').attr('title', 'Collapse this branch').on('click', function(e) {
				var children = $(this).parent('li.parent_li').find(' > ul > li');
				if (children.is(':visible')) {
					children.hide('fast');
					$(this).attr('title', 'Expand this branch').find(' > i').removeClass().addClass('fa fa-lg fa-plus-circle');
				} else {
					children.show('fast');
					$(this).attr('title', 'Collapse this branch').find(' > i').removeClass().addClass('fa fa-lg fa-minus-circle');
				}
				e.stopPropagation();
			});			
		
		})

		</script>
                                                                      
                                                          
                                                        
                                                        				<!-- end main content -->


		<g:render template="/menues/menuDroite" />


    
    <script src="${request.contextPath}/js/include/amchart/amcharts.js"></script>
    <script src="${request.contextPath}/js/include/amchart/serial.js"></script>
    <script src="${request.contextPath}/js/include/amcharts/amcharts/themes/black.js"></script>
    
    
    <!-- creer par NL pour gerer tous les graphiques -->
    <script src="${request.contextPath}/js/include/indicateur.js"></script>
    