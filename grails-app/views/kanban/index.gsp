
  <head>
		<meta name="layout" content="main2"/>
		<title>Sysprod</title>
                <g:javascript library="jquery" plugin="jquery" />
  </head>

 <g:render template="/menues/menuGauche" />



		<!-- END NAVIGATION -->

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
							<strong>Info!</strong> Le portefeuille de projets de votre entreprise est synthétisé ici. Vous pouvez alors accéder rapidement à toutes les données et à tous les renseignements utiles à l'avancemet de votre activité
						</div>
					<!-- page header -->

							
				<!-- row -->
				<div class="row">

					<!-- col -->
					<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
						<h1 class="page-title txt-color-blueDark"><i class="fa-fw fa fa-home"></i> Gestion du portefeuille <span>>
							Liste des projets </span></h1>
					</div>
					<!-- end col -->

					<!-- right side of the page with the sparkline graphs -->
					<!-- col -->
					<div class="col-xs-12 col-sm-5 col-md-5 col-lg-8">
						<!-- sparks -->
						<ul id="sparks">
							<li class="sparks-info">
								<h5> Nombre de projets <span class="txt-color-blue">${application.PP.Kanban.list().size()}</span></h5>
							</li>
                                                        
						</ul>
						<!-- end sparks -->
					</div>
					<!-- end col -->

				</div>
				<!-- end row -->

				<!--
				The ID "widget-grid" will start to initialize all widgets below
				You do not need to use widgets if you dont want to. Simply remove
				the <section></section> and you can use wells or panels instead
				-->

				<!-- widget grid -->
				<section id="widget-grid" class="">

					<!-- row -->
					<div class="row">

						<!-- NEW WIDGET START -->
						<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

							<table id="tabKanban"></table>
							<div id="ptabKanban"></div>

						</article>
						<!-- WIDGET END -->

					</div>

					<!-- end row -->

				</section>
				<!-- end widget grid -->

			</div>
			<!-- END MAIN CONTENT -->

		</div>
		<!-- END MAIN PANEL -->

		<g:render template="/menues/menuDroite" />