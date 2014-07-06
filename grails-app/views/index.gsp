
<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
                <g:javascript library="jquery" plugin="jquery" />
  </head>

  
                                          <sec:ifLoggedIn>
 <g:render template="/menues/mainleft" />
   				
     <!-- main content -->
				<div id="page-content">
					<!-- breadcrumb -->

					<!-- end breadcrumb -->

					<!-- page header
                                        
                                        <sec:ifLoggedIn>
					<div class="alert adjusted alert-info">
						<button class="close" data-dismiss="alert">×</button>
						<i class="cus-exclamation"></i>
						<strong>Welcome to  <sec:username/></strong> 
					</div>
					</sec:ifLoggedIn> -->
					<div class="fluid-container">

                                          <div class="alert adjusted alert-info">
						<button class="close" data-dismiss="alert">×</button>
						<i class="cus-exclamation"></i>
						<strong>Bienvenue sur SysProd </strong> Sur cette page, il y a le news feed de votre evironnement de travail. Toute l'actualité de 
                                                vos projets, de votre équipe et de vos collaborateurs y est indiquée en temps réel.
					</div>
                                          
                                          
						<!-- start icons -->
						<div id="start">
							<ul>
                                                          
								<li>
									<g:link   controller="effectif" action="show" id="${sec.loggedInUserInfo(field:"id")}" title="Mon mur">
										<img src="${request.contextPath}/img/start-icons/pending-message.png" alt="">
										<span>Mon mur</span>
									</g:link>
								</li>
								<li>
									<!-- <label></label> -->
									<g:link controller="kanban" action="obtenirKanbanEffectif" id="${sec.loggedInUserInfo(field:"id")}" title="Projets">
										<img src="${request.contextPath}/img/start-icons/orders.png" alt="">
										<span>Projets en cours</span>
                                                                        </g:link>
								</li>
                                                                
								<li>
									<!-- <label>new</label> -->
									<g:link   controller="effectif" action="indicateurEffectif" id="${sec.loggedInUserInfo(field:"id")}" title="Mes indicateurs">
										<img src="${request.contextPath}/img/start-icons/stats.png" alt="">
										<span>Indicateurs</span>
                                                                </g:link>
								</li>
							</ul>

						</div>						
						<!-- end start icons -->

						<!-- widget grid -->
						<section id="widget-grid" class="">

							<!-- row-fluid -->

							<div class="row-fluid">

								<article class="span12">

									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-0">
									    <header>
									        <h2>Mon mur</h2>                           
									    </header>

									    <!-- widget div-->
									    <div>
									    	<!-- widget edit box -->

									        <!-- content -->	            
									        <div class="inner-spacer chat-widget widget-content-padding"> 

									        	<!-- chat tabs -->
												<ul id="myChat" class="nav nav-tabs chat-tabs">
									              <li class="active">
									              	<a href="#newsfeed" data-toggle="tab"><i class="online"></i>Principal</a>
									              	</li>
									              <li>
									              	<a href="#activite" data-toggle="tab"><i class="away"></i>Activités</a>
									              </li>
									              <li class="pull-right">

													<div id="chat-user-control" class="btn-group hidden-phone">
                                                                                                          <button class="btn dropdown-toggle btn-small btn-link" data-toggle="dropdown"><i class="cus-status-online"></i></button>
		                                                <ul class="dropdown-menu btn-small pull-right">
															<li>
																<a href="javascript:void(0);"><i class="cus-status-online"></i> Available</a>
															</li>
															<li>
																<a href="javascript:void(0);"><i class="cus-cross-shield-2"></i> Busy</a>
															</li>
															<li>
																<a href="javascript:void(0);"><i class="cus-clock"></i> Away</a>
															</li>
															<li class="divider"></li>
															<li>
																<a href="javascript:void(0);"><i class="cus-disconnect"></i> Disconnect</a>
															</li>
		                                                </ul>
		                                            </div>


									              </li>
									            </ul>
									            <!-- end chat tabs -->

									            <!-- chat box -->
									            <div id="myChatTab" class="tab-content chat-content">

                                                                                      <div class="row-fluid chat-box">
                                                                                        
                                                                                      <div class="controls">
                                                                                        <input type="hidden" id="message_id" name="message_id" value="" />
																	<div class="input-append span10">  
                                                                                    <input class="span12 type-effect"  type="text" id="messageBox"  placeholder="Tapez votre message..." name="message" onkeypress="messageKeyPress(this,event);"/> 
                                                                                      
                                                                                    <div class="btn-group">
						                                                    <button class="btn dropdown-toggle medium" data-toggle="dropdown">Action <span class="caret"></span></button>
						                                                    <ul class="dropdown-menu btn-small pull-right">
						                                                        <li><a href="javascript:void(0);">Favorite it</a></li>
						                                                        <li><a href="javascript:void(0);">Reload page</a></li>
						                                                        <li><a href="javascript:void(0);">Attach something</a></li>
						                                                    </ul>
						                                                </div>
						                                            </div>
                                            					</div>  
                                                                                    <g:hiddenField name="kanban" id="monKanban"/>
                                                                                    <div id="temp"></div>
                                                                                        
                                                                                      </div>
                                                                                      <!-- chat user1 -->	
                                                                                      <div class="tab-pane fade in active" id="newsfeed">
                                                                                        
									              	<!-- chat messages -->
									              	<div class="newsfeed1"></div>
									              	<!-- end chat messages -->

									              </div>
                                                                                      <script type="text/javascript">
                                                                                        <g:remoteFunction controller="message" action="obtenirMessage" update="newsfeed1"/>;
                                                                                      </script>
									              <!-- end chat user1 -->

									              <!-- chat user2 -->
									              <div class="tab-pane fade" id="activite">

									              	<!-- chat messages -->
									              	<div class="chat-messages">														

									              	</div>
									              	<!-- end chat messages -->

									              </div>
                                                                                      
									              <!-- end chat user2 -->

									            </div>
									            <!-- end chat box -->




									        </div>
									        <!-- end content -->	

									    </div>
									    <!-- end widget div -->
									</div>
                                                                        
									<!-- end widget -->

								</article>

							</div>
                                                        
                                                        <script>
                                                          function messageKeyPress(field,event) {
                                                            var theCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
                                                            var message = $('#messageBox').val();
                                                            if (theCode == 13){
                                                        <g:remoteFunction controller = "message" action="posterMessage" params="\'message=\'+message" update="temp"/>
                                                                    $('#messageBox').val('');
                                                                    return false;
                                                                  } else {
                                                                    return true;
                                                                  }
                                                                  }
                                                                  function obtenirMessage() {
                                                                  // var kanban = $('#monKanban').val()
                                                                          <g:remoteFunction controller="message" action="obtenirMessage" update="newsfeed"/>
                                                                        }
                                                                function maj() {
                                                                  obtenirMessage();
                                                                  setTimeout('pollMessages()', 25000);
                                                                }
                                                                maj();
                                                                $(document).ready(function() {
                                                                  $.ajax({
                                                                    url: '/application/Effectif/listEffectif',
                                                                    type: 'GET',
                                                                    dataType: "json",
                                                                    success : function(response) {
                                                                    //Create a map.
                                                                    var data =
                                                                            $.map(response, function(item){
                                                                      console.log("id: " + item.id);
                                                                      console.log("nom: " + item.nom );
                                                                      return{
                                                                        id: item.id,
                                                                        value: item.nom 
                                                                      }
                                                                    });
                                                                    $("#messageBox").autocomplete({

                                                                    source: data,
                                                                    beforeRetrieve: function(string){
                                                                      if (string.indexOf('@') == 0) return "";
                                                                      return string;
                                                                    },
                                                                    select: function (event, ui){
                                                                      console.log("selected id:" + ui.item.id);
                                                                      console.log("selected nom:" + ui.item.value);
                                                                      //change the value of hidden field to the country's id.
                                                                      $('#message_id').val(ui.item.id);
                                                                      }
                                                                            });
                                                                            }
                                                                            });
                                                                            });                                            
   
      
      
                                                                                                                               
                                                        </script>
						</section>
					</div>		
				</div>

<g:render template="/menues/mainright" />



 
</sec:ifLoggedIn>
  
  
  
  
  <sec:ifNotLoggedIn>
    <h2> <g:link  action="index" controller="login"> <font size="3" face="georgia" color="red"> Se connecter </font></g:link> <h2>
  </sec:ifNotLoggedIn>
