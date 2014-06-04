
 
<g:if test="${affichage == 1}">
  <g:set var="affichage" value="$affichage+1}" />

     
                                                        <div class="btn-group">
                                                          
                                                          <a href="${request.contextPath}/javascript:void(0)" class="btn btn-small btn-inverse dropdown-toggle" data-toggle="dropdown">
									<script> if (${mailNonLu.size()} != 0)  {  document.write('<span class="mail-sticker">${mailNonLu.size()} </span> ');}  </script>
                                                                        
                                                                        		

                                                                        
									<i class="cus-email"></i>
								</a>
                                                          
                                                         <div class="dropdown-menu toolbar pull-right">
									<h3>Inbox</h3>
                                                                        
									<ul id="mailbox-slimscroll-js" class="mailbox">
                                                                                <g:set var="counter" value="${0}" /> 
                                                                                <g:each in="${mesEffectifsMails}" status="i" var="mailEffectifInstance">
                                                                                <g:set var="imagenlu" value="${mailEffectifInstance.lu}" />
                                                                                <g:set var="counter" value="${counter+1}" />   
                                                                                  
                                                                                          <g:if test="${counter <= 4}">
                                                                                             <table>
                                                                                              <tr>  <g:if test="${imagenlu == false}">
                                                                                                      <td>  <img src="${request.contextPath}/img/email-unread.png" alt="important mail"></td>
                                                                                                </g:if>
                                                                                                   <g:else>
                                                                                                  <td>  <img src="${request.contextPath}/img/email-read.png" alt="important mail"></td>
                                                                                                  </g:else>
                                                                             <li> 
                                                                                              <td> <g:link  controller="MailEffectif"  action="show"  id="${mailEffectifInstance.id}">   
                                                                                       
                                                                                          
                                                                                                ${mailEffectifInstance.mail.objet}: ${mailEffectifInstance.mail.author.username}
                                                                                          
																			
                                                                                                <span >${mailEffectifInstance.mail.message}</span></td>
                                                                                        </li>  
                                                                                        
                                                                                                </g:link>
                                                                                  
                                                                                   </g:if>
                                                                                         </tr>    
                                                                                 </g:each>
									 </table> 	
									</ul>
                                                                        
									 <g:link  action="index" controller="mail" id="go-to-inbox">Go to Inbox <i class="icon-double-angle-right"></i></g:link>
                                                                       
								</div>
                                                            
                                                          
                                                          <!-- end new mail ticker -->
                                                          
                                                          
                                                        </div> 
</g:if>