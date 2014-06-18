<div class="height-wrapper"> 

		<header>
			<!-- tool bar -->
			<div id="header-toolbar" class="container-fluid">
				<!-- .contained -->
				<div class="contained">
					
					<!-- theme name -->
                                        <h1> SysProd <span class="hidden-phone">- Mon tableau de bord</span> </h1>
					<!-- end theme name -->
																		
					<!-- span4 -->
					<div class="pull-right">
						<!-- demo theme switcher-->
						<div id="theme-switcher" class="btn-toolbar">
							
							<!-- search and log off button for phone devices -->
							<div class="btn-group pull-right visible-phone">
								<a href="javascript:void(0)" class="btn btn-inverse btn-small"><i class="icon-search"></i></a>
								<a href="login.html" class="btn btn-inverse btn-small"><i class="icon-off"></i></a>
							</div>
							<!-- end buttons for phone device -->
							
                                                                <g:link  action="show" controller="Effectif" id="${sec.loggedInUserInfo(field:"id")}" class="btn btn-inverse btn-small">Mon profil</g:link>
							<!-- dropdown mini-inbox-->
                                                        <g:set var="affichage" value="${1}" /> 
                                                          
                                                       
                                                                <messagerie:miniMessagerie>
                                                                   
                                                                   
                                                                </messagerie:miniMessagerie>
                                                                                                   
                                                         <g:set var="affichageKanban" value="${1}" /> 
							<!-- end dropdown mini-inbox-->
							
							<!-- Tasks -->
                                                        <kanbans:kanbanmini>
                                                        </kanbans:kanbanmini>
                                                       
                                                        
                                                        
							<!-- end Tasks -->
							
							<!-- theme dropdown -->
							<div class="btn-group hidden-phone">
								<a href="javascript:void(0)" class="btn btn-small btn-inverse" id="reset-widget"><i class="icon-refresh"></i></a>
								
							</div>
							<!-- end theme dropdown-->
							
						</div>
					  	<!-- end demo theme switcher-->
					</div>
					<!-- end span4 -->
				</div>
				<!-- end .contained -->
			</div>
			<!-- end tool bar -->
			
		</header>
<!-- aside -->	
		
		<div id="main" role="main" class="container-fluid">
	    	
			<div class="contained">			
<aside>	
					
					<!-- search box -->
					<div class="main-search">
						<label for="main-search"><i class="icon-search"></i></label>
	                    <input id="main-search" type="text" placeholder="Recherche">
                	</div>
					<div class="divider"></div>
					<!-- end search box -->
										
					<!-- aside item: Mini profile -->
                                        <center>
					<div class="my-profile">
                                          Bienvenue
                                       <g:link  action="show" controller="Effectif" id="${sec.loggedInUserInfo(field:"id")}">   <sec:ifLoggedIn><sec:username/></sec:ifLoggedIn></g:link>
					<span><g:link  action="edit" controller="Effectif" id="${sec.loggedInUserInfo(field:"id")}"> Modifier profil </g:link></span>
					</div>
                                        </center>
					<div class="divider"></div>
					<!-- end aside item: Mini profile -->

					<!-- aside item: Menu -->
					<div class="sidebar-nav-fixed">
						
						<ul class="menu" id="accordion-menu-js">
							<li class="current">
								<a href="javascript:void(0)"><i class="icon-off"></i>Général <!--  <span class="badge">2</span> --></a>
								<ul>
									<li>
										<g:link  action="index" controller="Login">Page d'accueil</g:link>
									</li>
                                                                        
									<li>
                                                                                <g:link   controller="effectif" action="show" id="${sec.loggedInUserInfo(field:"id")}" > Mon profil </g:link>
									</li>
									<li>
                                                                                <sec:ifLoggedIn>
										 <g:link  action="index" controller="Logout">  Se déconnecter </g:link>
                                                                                 </sec:ifLoggedIn>
                                                                        <sec:ifNotLoggedIn>
										 <g:link  action="index" controller="Login">  Se connecter </g:link>
                                                                                 </sec:ifNotLoggedIn>
                                                                        
									</li>
								</ul>
							</li>
                                                        
							<li class="">
								<g:link  action="index" controller="mail"> <i class="icon-envelope"></i>Boite de réception</g:link>
							</li>
							<li class="">
								<a href="javascript:void(0)"><i class="cus-briefcase"></i>Suvi d'activités<!--<span class="badge">3</span>--></a>
								<ul>
                                                                        
                                                                        <li>
                                                                                <g:link controller="kanban" action="obtenirKanbanEffectif" id="${sec.loggedInUserInfo(field:"id")}" > Mon activité </g:link>
									</li>
                                                                        <li>
                                                                                <g:link  action="index" controller="kanban"> Portefeuille de projets </g:link>
									</li>
							<li class="">
								<g:link  action="feuilleImputation" controller="imputation">Feuille d'imputation</g:link>
							</li>
								</ul>
							</li>
                                                        <li class="">
								<a href="javascript:void(0)"><i class="cus-chart-bar"></i>Pilotage</a>
								<ul>
                                                                        
									<li>
                                                                                <g:link   controller="effectif" action="indicateurEffectif" id="${sec.loggedInUserInfo(field:"id")}" > Mes indicateurs </g:link>
									</li>
									<li>
                                                                                <g:link  action="index" controller="pdp"> Plan annuel </g:link>
									</li>
                                                                        <li>
                                                                                <g:link  action="index" controller="pic"> Plan pluri-annuel </g:link>
									</li>
								</ul>
							</li>
                                                        <li class="">
								<g:link  action="index" controller="event"> <i class="cus-calendar-2"></i> Mon agenda </g:link>
							</li>
                                                        

							
							<li class="">
								<a href="javascript:void(0)"><i class="icon-plus"></i>Administration</a>
								<ul>
									<li>
										<g:link  action="ressource" controller="administration">Gestion des ressources</g:link>
									</li>
									<li>
										<g:link  action="activite" controller="administration">Gestion d'activite</g:link>
									</li>
								</ul>
							</li>
						</ul>
						
					</div>
					<div class="divider"></div>
					<!-- end aside item: Menu -->
					
					<!-- aside item: Inbox -->
					<!-- inbox message 1-->
                                                                                
                                           <g:set var="calcul" value="${1}" /> 
                                           
                                          
                                                 
                                                    <messagerie:gaucheMessagerie>
                                                  
                                                    </messagerie:gaucheMessagerie>
                                          
                                           
					<div class="divider"></div>
					<!-- end aside item: Inbox -->
					
                                        
					
		            <!-- end aside buttons -->
				</aside>
        <!-- aside end -->