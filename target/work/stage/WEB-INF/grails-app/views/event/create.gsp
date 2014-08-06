
<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
  </head>

  
 <g:render template="/menues/mainleft" />	
<div id="page-content">
					<!-- page header -->
					<h1 id="page-header">Ajouter un Evennement  </h1>	
					
					<div class="fluid-container">
						
						<!-- widget grid -->
						<section id="widget-grid" class="">
							
							<!-- row-fluid -->
							
							<div class="row-fluid">
								<article class="span12">
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-0">
									    <header>
									        <h2>Compléter ce formulaire</h2>                           
									    </header>
									    <!-- wrap div -->
									    <div>
									    
									        <div class="jarviswidget-editbox">
									            <div>
									                <label>Title:</label>
									                <input type="text"  />
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
            
									        <div class="inner-spacer"> 
                                                                                  <div id="create-mail" class="content scaffold-create" role="main">
                                                                                    <g:if test="${flash.message}">
                                                                                      <div class="message" role="status">${flash.message}</div>
                                                                                    </g:if>
                                                                                    <g:hasErrors bean="${eventInstance}">
                                                                                      <ul class="errors" role="alert">
                                                                                        <g:eachError bean="${eventInstance}" var="error">
                                                                                          <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                                                                                        </g:eachError>
                                                                                      </ul>
                                                                                    </g:hasErrors>
                                                                                    <g:form url="[resource:eventInstance, action:'save']">
                                                                                      <fieldset class="form-horizontal themed">
                                                                                        <g:render template="form"/>
                                                                                      </fieldset>
                                                                                      <fieldset class="buttons">
                                                                                        <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                                                                                      </fieldset>
                                                                                    </g:form>
                                                                                  </div>
                                                                                  
                                                                                  
									        <!-- content goes here -->
										
										    </div>
										    <!-- end content-->
									    </div>
									    <!-- end wrap div -->
									</div>
									<!-- end widget -->
								</article>
							</div>
							
							<!-- end row-fluid -->

							<!-- row-fluid -->
							
							
							
						</section>
						<!-- end widget grid -->
					</div>		
				</div>
        
        <!-- menu de droite -->
                                <g:render template="/menues/mainright" />
