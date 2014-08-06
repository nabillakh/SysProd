<article class="span12">
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-0">
									    <header>
									        <h2>${OFInstance?.phase?.nom}</h2>                           
									    </header>
									    <!-- wrap div -->
									    <div>
                                                                              <div class="inner-spacer"> 
                                                                                <g:if test="${flash.message}">
                                                                                  <div class="message" role="status">${flash.message}</div>
                                                                                </g:if>

                                                                                  <input type="hidden"  name="monId"  id="monId" value="${OFInstance?.phase?.id}">
                                                                                  <fieldset class="form-horizontal themed"> 
                                                                                    <div class="control-group">
                                                                                      <label for="chargePlanifiee" class="control-label">
                                                                                        <g:message code="OF.chargePlanifiee.label" default="Charge Planifiee" />
                                                                                      </label>
                                                                                      <div class="controls"  size="16" >
                                                                                        <g:field name="chargePlanifiee" value="${fieldValue(bean: OFInstance, field: 'chargePlanifiee')}" />
                                                                                      </div>
                                                                                    </div>                                                                                 

                                                                                    <div class="control-group">
                                                                                      <label for="affectes" class="control-label">
                                                                                        <g:message code="OF.affectes.label" default="Affectes" />

                                                                                      </label>  <div class="controls"  size="16" >
                                                                                        <g:select id="multiSelect" multiple="multiple" name="affectes" from="${application.RH.Effectif.list()}" optionKey="id" required="" value="${OFInstance?.affectes*.id}" class="span12 with-search"/>
                                                                                      </div>
                                                                                    </div>
                                                                                    
                                                                                    <div class="control-group">

                                                                                      <div>
                                                                                        <label class="control-label">Date de lancement <span class="required-indicator">*</span></label>
                                                                                        

                                                                                        <div class="controls" size="16" >
                                                                                          <div>
                                                                                            <g:field type="date" name="dateDebutPlanifie" 
                                                                                                     default="${new Date()}" precision="day"  />
                                                                                          </div>
                                                                                        </div>
                                                                                      </div></div>
                                                                                    <div class="control-group">
                                                                                      <div>
                                                                                        <label class="control-label">Date de fin planifiée <span class="required-indicator">*</span></label>
                                                                                        <div class="controls" size="16" >
                                                                                          <div>
                                                                                            <g:field type="date" name="dateFinPlanifie" 
                                                                                                     default="${new Date()}" precision="day"  />
                                                                                          </div>
                                                                                        </div>
                                                                                      </div>
                                                                                    </div>

                                                                                  </fieldset>  
                                                                                  <div class="span5">
                                                                                  </div>
                                                                                    <div class="aside-buttons span2">
                                                                                      <a onclick="javascript:majOF(this.id);return false;" class="btn">Mise à jour</a>
                                                                                    </div>
                                                                                  <div class="span5">
                                                                                  </div>
                                                                              </div>
                                                                              <!-- end content-->
                                                                            </div>
                                                                            <script>
                                                                              function majOF(of) {
                                                                                var kanban = $('#monId').val();
                                                                                alert(kanban);
                                                                                // <g:remoteFunction controller = "message" action="obtenirMessage" params="\'kanban=\' + kanban" update="chatMessages"/>
                                                                              }
                                                                              function pollMessages() {
                                                                                obtenirMessage();
                                                                                setTimeout('pollMessages()', 25000);
                                                                              }
                                                                              // pollMessages();
                                                                             </script>
                                                                                       
                                                                        </div>
                                                                        <!-- end widget -->
                                                                </article>