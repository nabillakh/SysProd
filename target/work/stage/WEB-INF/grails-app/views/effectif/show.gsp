<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
                 <g:javascript library="jquery" plugin="jquery" />
  </head>

 <sec:ifLoggedIn>
 <g:render template="/menues/mainleft" />		
<div id="page-content">
    <div class="fluid-container">
       <div class="alert adjusted alert-info">
						<button class="close" data-dismiss="alert">×</button>
						<i class="cus-exclamation"></i>
                                                Ceci est la page de profil de ${effectifInstance?.prenom} ${effectifInstance?.nom} . Vous pouvez accéder
                                                 aux messages de ce collaborateur, aux indicateurs le concernant et son portefeuille de projet.
					</div>
						<section id="widget-grid" class="well light">
                                                  <div class="row-fluid">
                                                    <article class="span3">
    <img src="${request.contextPath}/img/start-icons/coucou.jpg" alt="" style="width: 160px; height: 160px;">
    
                                                    </article>
                                                    <article class="span9">
                                                      
                                                      <center>
    <h4>${effectifInstance?.prenom} ${effectifInstance?.nom}</h4> 
   <g:link  action="show" controller="Equipe" id=" ${effectifInstance.equipe.id}"> <h4> Equipe: ${effectifInstance?.equipe.nom}</h4></g:link>
    
    <div id="start">
      <ul>
        
      <li>
        <g:link controller="effectif" action="information" id="${effectifInstance.id}" title="Informations">
          <img src="${request.contextPath}/img/start-icons/mass.png" alt="">
          <span>Informations</span>
        </g:link>
      </li>
        <li>
        <g:link controller="effectif" action="show" id="${effectifInstance.id}" title="Journal">
          <img src="${request.contextPath}/img/start-icons/pending-message.png" alt="">
          <span>Journal</span>
        </g:link>
      </li>
      
        <li>
          
        <g:link controller="kanban" action="obtenirKanbanEffectif" id="${effectifInstance.id}" title="Projets">
          <img src="${request.contextPath}/img/start-icons/orders.png" alt="">
          <span>Projets en cours</span>
        </g:link>
      </li>
      <li>
        
        <g:link controller="effectif" action="indicateurEffectif" id="${effectifInstance.id}" title="Indicateurs">
          <img src="${request.contextPath}/img/start-icons/stats.png" alt="">
          <span>Indicateurs</span>
        </g:link>
      </li>
      </ul>
      
    </div>
                                                      </center>
                                                    </article>
                                                  </div>
                                                  
                                                </section>
      <section>
      <div class="row-fluid">
        <article class="span12">
        
        <div id="temp">
          
      </div>
        
									    <!-- a modifier-->
<div class="jarviswidget" id="contenu2" data-widget-collapsed="false">
    <header>
									        <h2>Journal</h2>                           
  </header> <div>
    <div class="inner-spacer chat-widget widget-content-padding"> 

									        	<!-- chat tabs -->
												<ul id="myChat" class="nav nav-tabs chat-tabs">
									              <li class="active">
									              	<a href="#newsfeed" data-toggle="tab"><i class="online"></i>Principal</a>
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
									        </div>
									        <!-- end content -->	
									        
									    
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
        </div>
          
        
        </article>       
        
      </div>
      </section>
      
      
									    <!-- end widget div -->
									</div>

							</div>
 
 
				

<g:render template="/menues/mainright" />



 
</sec:ifLoggedIn>
  
  
  
  
  <sec:ifNotLoggedIn>
    <h2> <g:link  action="index" controller="login"> <font size="3" face="georgia" color="red"> Se connecter </font></g:link> <h2>
  </sec:ifNotLoggedIn>