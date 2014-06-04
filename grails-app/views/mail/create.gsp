<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
  </head>

  
 <g:render template="/menues/mainleft"/>

		
							
							<!-- end row-fluid -->
							
							<!-- row-fluid -->
							<div id="page-content">
                                                            <div class="fluid-container">
							<div class="row-fluid">
								
								<article class="span6"  style="width: 100%; height: 1000px;">
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-4" >
									    <header  style="height: 70px;">
									        <h3>Nouveau message :</h3>                           
									    </header>
                                                                            
									    <div>
									    
									        <div class="jarviswidget-editbox">
									            <div>
									                <label>Title:</label>
									                <input type="text" />
									            </div>
									            <div>
									                <label>Styles:</label>
									                <span data-widget-setstyle="purple" class="purple-btn"></span>
									                <span data-widget-setstyle="navyblue" class="navyblue-btn"></span>
									                <span data-widget-setstyle="green" class="green-btn"></span>
									                <span data-widget-setstyle="yellow" class="yellow-btn"></span>
									                <span data-widget-setstyle="orange" class="orange-btn"></span>
									                <span data-widget-setstyle="pink" class="pink-btn"></span>
									                <span data-widget-setstyle="red" class="red-btn"></span>
									                <span data-widget-setstyle="darkgrey" class="darkgrey-btn"></span>
									                <span data-widget-setstyle="black" class="black-btn"></span>
									            </div>
									        </div>
            
									        <div class="inner-spacer wysihtml5-widget"> 
                                                                                  <g:form url="[action:'save']">
									        <!-- content -->
                                                                                     A : <g:select name="recepteur" from="${application.RH.Effectif.list(username)}" multiple="multiple" optionKey="id" style="width: 100%; height: 60px;" value="${effectifInstance?.id?.username}" class="many-to-many"/>
                                                                                      <div class="fieldcontain ${hasErrors(bean: mailInstance, field: 'objet', 'error')} ">
                                                                                        <textArea   name="objet"  value="${mailInstance?.objet}"  placeholder="Objet..." style="width: 100%; height: 20px;"></textArea>
                                                                                      </div>
                                                                                      <div class="fieldcontain ${hasErrors(bean: mailInstance, field: 'message', 'error')} ">
                                                                                        <textArea    id="wysihtml5" name="message"   value="${mailInstance?.message}"  placeholder="Enter text ..."  style="width: 100%; height: 600px;" ></textArea>
                                                                                      </div>	
                                                                                      <div class="pull-right post-msg">
                                                                                        <fieldset class="buttons">
                                                                                          <g:submitButton name="create" controller="Mail" class="btn medium btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                                                                                        </fieldset>
                                                                                        
                                                                                  </g:form>
</div>   		
											<!-- end content -->	
									        </div>
									        <!-- end inner spacer -->
									    </div>
									</div>
									<!-- end widget -->
								</article>

									
												<!-- end SLIDING MENU -->
											


										</div>
									    <!-- end content-->
									   
									    <!-- end wrap div -->
									</div>
									
									
									<!-- end widget -->
								</article>
							</div>
					
				<!-- end main content -->
			
				<!-- aside right on high res -->
				
				
				<g:render template="/menues/mainright" />