<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Gestion projet</title>
                <g:javascript library="jquery" plugin="jquery" />
                
                
  </head>

 
 <g:render template="/menues/mainleft" />


 
 <div id="page-content">
    <div class="fluid-container">
      
						<section id="widget-grid" class="well light">
                                                  <div class="row-fluid">
                                                    <article class="span3">
    <img src="${request.contextPath}/img/start-icons/coucou.jpg" alt="" style="width: 160px; height: 160px;">
    
                                                    </article>
                                                    <article class="span9">
                                                      
                                                      <center>
    <h4> Projet : ${kanbanInstance?.nomKanban} </h4> 
   <g:link  action="show" controller="Famille" id="${kanbanInstance.famille.id}"> <h4> Famille : ${kanbanInstance?.famille.nom}</h4></g:link>
    
    <div id="start">
      <ul>
        
      <li>
        <g:link controller ="kanban" action ="show" id ="${kanbanInstance.id}" title="Informations">
          <img src="${request.contextPath}/img/start-icons/mass.png" alt="">
          <span>Informations</span>
        </g:link>
      </li>
        <li>
        <g:link controller ="kanban" action ="obtenirJournal" id ="${kanbanInstance.id}" title="Journal">
          <img src="${request.contextPath}/img/start-icons/pending-message.png" alt="">
          <span>Journal</span>
        </g:link>
      </li>
      
        <li>
          
        <a href="javascript:voirProjets(${kanbanInstance.id})" title="Projets">
          <img src="${request.contextPath}/img/start-icons/orders.png" alt="">
          <span>Projets en cours</span>
        </a>
      </li>
      <li>
        
        <g:link controller ="kanban" action ="indicateurKanban" id="${kanbanInstance.id}" title="Indicateurs">
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
									        <h2>Compte Rendu</h2>                           
									    </header> 
									    
									    <div>
                                                                              
                                                                              <div class="row-fluid chat-box">
                                                                                <center> <input class="span10 type-effect" type="text" id="messageKanban" name="message" placeholder="Tapez votre message..." onkeypress="messageKanban(this,event);"/>   </center> 
                                                                                        <g:hiddenField name="kanban" id="monKanban" value="${kanbanInstance.id}"/>
                                                                                    <div id="temp"></div>
                                                                                    <!-- script de gestion des messages -->
                                                                                    </div>
                                                                                    <div id="messagesKanban">
                                                                                    </div>
                                                                                      <script type="text/javascript">
                                                                                        <g:remoteFunction controller="message" action="obtenirMessageKanban" params="\'kanban=\' + ${kanbanInstance.id}" update="messagesKanban"/>;
                                                                                      </script>
                                                                                      
                                                                                      
                                                                                    
                                                                                    
                                                                                    <script>
                                                                                      function messageKanban(field,event) {
                                                                                        var theCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
                                                                                        var message = $('#messageKanban').val();
                                                                                        var kanban = $('#monKanban').val()
                                                                                        if (theCode == 13){
                                                                                    <g:remoteFunction controller = "message" action="posterMessageKanban" params="\'message=\'+message+ '&kanban=\' + kanban" update="temp"/>
                                                                                                $('#messageKanban').val('');
                                                                                                return false;
                                                                                              } else {
                                                                                                return true;
                                                                                              }
                                                                                              obtenirMessageKanban();
                                                                                              }
                                                                                              function obtenirMessageKanban() {
                                                                                        var kanban = $('#monKanban').val();
                                                                                              <g:remoteFunction controller = "message" action="obtenirMessageKanban" params="\'kanban=\' + kanban" update="messagesKanban"/>
                                                                                            }
                                                                                                function pollMessages() {
                                                                                                          obtenirMessageKanban();
                                                                                                          setTimeout('pollMessages()', 25000);
                                                                                                        }
                                                                                                        pollMessages();                                                                                                       
                                                                                    </script>
                                                                                    
                                                                                    
                                                                                    
                                                                                    
									</div>
  
  
        </div>
          
        
        </article>       
        
      </div>
                                                </section>
      
      
      
									    <!-- end widget div -->
									</div>

							</div>
 
                                                                      
                                                          
                                                        
                                                        				<!-- end main content -->
			
				<g:render template="/menues/mainright" />


    
    <script src="${request.contextPath}/js/include/amchart/amcharts.js"></script>
    <script src="${request.contextPath}/js/include/amchart/serial.js"></script>
    <script src="${request.contextPath}/js/include/amcharts/amcharts/themes/black.js"></script>
    
    
    <!-- creer par NL pour gerer tous les graphiques -->
    <script src="${request.contextPath}/js/include/indicateur.js"></script>
    
                                                          