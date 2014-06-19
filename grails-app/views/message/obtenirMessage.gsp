<g:each in="${mesMessages}" var="message">
  
  <g:if test="${message.auteur == moi}">
<p id="message-id-3" class="message-box you">
    </g:if>
  <g:else>
<p id="message-id-3" class="message-box">
  </g:else>
  
  <span class="message">
    <strong><g:link action="show" controller="Effectif" id="${message.auteur.id}"><i class="cus-user-business-boss"></i> ${message.auteur.nom} ${message.auteur.prenom}</g:link></strong> 
     <g:if test="${message.kanban}">
       <g:link action="show" controller="Kanban" id="${message.kanban.id}">,  <i class="cus-briefcase"></i> ${message.kanban.nomKanban}</g:link>
       </g:if>
    <span class="message-time"><g:formatDate format="dd-MM-yyyy hh:mm a" date="${message.date}"/></span>
    <span class="message-text">${message.message}
      <g:link  action="index" controller="kanban"  class="pull-right"><i class="cus-comment"></i></g:link> 
      
    
  </span>
</p>
  
</g:each>