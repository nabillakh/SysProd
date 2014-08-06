
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
						Liste des projets
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

			<!-- MAIN CONTENT -->
			<div id="content">
                          
   <div class="alert adjusted alert-info">
							<button class="close" data-dismiss="alert">×</button>
							<i class="cus-exclamation"></i>
							<strong>Info!</strong> Créez facilement vos projets ! La juste info le plus simplement possible.
						</div>
					<!-- page header -->

							
				<!-- row -->
				<div class="row">
                                  <article class="col-sm-12 col-md-12 col-lg-2">
                                    </article>
                                  <article class="col-sm-12 col-md-12 col-lg-8">
				
							<!-- Widget ID (each widget will need unique ID)-->
							<div class="jarviswidget" id="wid-id-2" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-custombutton="false">
								<!-- widget options:
								usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">
				
								data-widget-colorbutton="false"
								data-widget-editbutton="false"
								data-widget-togglebutton="false"
								data-widget-deletebutton="false"
								data-widget-fullscreenbutton="false"
								data-widget-custombutton="false"
								data-widget-collapsed="true"
								data-widget-sortable="false"
				
								-->
								<header>
									<span class="widget-icon"> <i class="fa fa-edit"></i> </span>
									<h2>Nouveau projet </h2>
				
								</header>
				
								<!-- widget div-->
								<div>
				
									<!-- widget edit box -->
									<div class="jarviswidget-editbox">
										<!-- This area used as dropdown edit box -->
				
									</div>
									<!-- end widget edit box -->
				
									<!-- widget content -->
									<div class="widget-body">
				
										<form class="" url="[action:'nouveauKanban']">
				
											<fieldset>
												<legend>
													Données générales
												</legend>
                                                                                          <input type="hidden"  name="monId"  value="${kanbanInstance?.id}">
                                                                                          
                                                                                          <div class="row">
                                                                                          
													<div class="col-sm-12">
													<label>Nom du projet : </label>
				
														<div class="form-group">
															<div class="input-group">
																<input class="form-control" id="nomKanban" type="text" placeholder="Nom du projet" value="${kanbanInstance?.nomKanban}"/>
																<span class="input-group-addon"></span>
															</div>
														</div>
				
													</div>
													<div class="col-sm-12">
													<label>Description :</label>
				
														<div class="form-group">
															<div class="input-group">
																<input class="form-control" id="description" type="text" placeholder="Description du projet" value="${kanbanInstance?.description}"/>
																<span class="input-group-addon"></span>
															</div>
														</div>
				
													</div>
													</div>

                                                                                          
				
												
                                                                                          
				
											</fieldset>
				
											<fieldset>
												<legend>
													Référencement du projet
												</legend>
                                                                                          
                                                                                          <div class="row">
													<div class="col-sm-12">
													<label>Responsable du projet :</label>
				
                                                                                                        <div class="form-group">
                                                                                                          <select style="width:100%" class="select2">
														<optgroup label="Interne">
                                                                                                                <g:each in="${application.RH.Effectif.list()}" status="i" var="ordoInstance">
                                                                                                                  <option value="${ordoInstance.id}">${ordoInstance.nom} ${ordoInstance.prenom}</option>
                                                                                                                </g:each>
														</optgroup>
														<optgroup label="Externe">
															<option value="CA">En ajouter</option>
															<option value="NV">Nevada</option>
															<option value="OR">Oregon</option>
															<option value="WA">Washington</option>
														</optgroup>
														<span class="input-group-addon"></span>
													</select>
				
												</div>
												</div>
				
                                                                                                  <div class="col-sm-6">
													<label>Famille de projet :</label>
                                                                                                  <div class="form-group">
                                                                                                      <select style="width:100%" name="famille" value="${kanbanInstance.famille?.id}" class="select2 with-search">
                                                                                                       
														<optgroup label="Famille opérationnelle">
                                                                                                                <g:each in="${application.PP.Famille.list()}" status="i" var="familleInstance">
                                                                                                                  <option value="${familleInstance.id}">${familleInstance.nom}</option>
                                                                                                                </g:each>
														</optgroup>
                                                                                                      </select>
                                                                                                  </div>
                                                                                                </div>
                                                                                          
				
                                                                                                  <div class="col-sm-6">
													<label>Sous Famille :</label>
                                                                                                  <div class="form-group">
                                                                                                      <select style="width:100%" name="famille" value="${kanbanInstance.ordo?.id}" class="select2 with-search">
                                                                                                       
														<optgroup label="Famille opérationnelle">
                                                                                                                <g:each in="${application.PP.Ordonnancement.list()}" status="i" var="familleInstance">
                                                                                                                  <option value="${familleInstance.id}">${familleInstance.nom}</option>
                                                                                                                </g:each>
														</optgroup>
                                                                                                      </select>
                                                                                                  </div>
                                                                                                </div>
                                                                                                </div>
                                                                                          </fieldset>
				
											<fieldset>

												<legend>
													Données charges / délais
												</legend>
                                                                                          <div class="row">
                                                                                            
				
													<div class="col-sm-6">
														<label>Date de début planifiée : </label>
				
														<div class="form-group">
                                                                                                                  
                                                                                                                  <div class="input-group date" data-date="${dateDeb}" data-date-format="dd/mm/yyyy">
                                                                                                                    <input class="datepicker-input form-control" type="text"  value="${dateDeb}" name="dateLancement" 
                                                                                                                           placeholder="Select a date" />
                                                                                                                    <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                                                                                                  </div>
														</div>
				
													</div>
													<div class="col-sm-6">
														<label>Date de fin planifiée : </label>
				
														<div class="form-group">
                                                                                                                  <div class="input-group date" data-date="${dateDeb}" data-date-format="dd/mm/yyyy">
                                                                                                                    <input class="datepicker-input form-control" type="text"  value="${dateDeb}" name="dateLivraison" 
                                                                                                                           placeholder="Select a date" />
                                                                                                                    <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                                                                                                  
														</div>
				
													</div>
				
													</div>
													<div class="col-sm-12">
														<label>Charge planifiée : </label>
				
														<div class="form-group">
															<div class="input-group">
																<input class="form-control" id="to" type="text" placeholder="Saissisez la charge planifiée" name="chargePlanifiee"  value="${kanbanInstance.chargePlanifiee}" >
																<span class="input-group-addon"><i class="fa fa-clock-o"></i></span>
															</div>
														</div>
				
													</div>
												</div>
												</div>
											</fieldset>
												
											<div class="form-actions" 
												<div class="row">
													<div class="col-md-12">
                                                                                          <g:link  action="index" controller="kanban"  class="btn  btn-default">Annuler</g:link> 
                                                                                          <g:submitButton action="nouveauKanban" controller="kanban"  class="btn  btn-default" name="creer">enregistrer</g:submitButton> 
                                                                                          <g:submitButton  class="btn btn-primary" name="enregistrer"/>
													</div>
												</div>
											</div>
				
										</form>
				
									</div>
									<!-- end widget content -->
				
								</div>
								<!-- end widget div -->
				
							</div>
							<!-- end widget -->
				
						</article>

				</div>
                        
				<!-- end widget grid -->

			
                                
		<g:render template="/menues/menuDroite" />