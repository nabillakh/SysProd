 

<g:each in="${mesMessages}" var="message" status="k" >
  
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
                                                                                    
      <g:link  action="index" controller="commentaire"  class="pull-right"><i class="cus-comment"></i></g:link> 
          <g:if test="${message.commentaires}">
            </br> </br> </br>
            <input type="hidden"  name="monId" id="monId${k}"  value="${message?.id}">
  <input class="input-xlarge span12 type-effect"  type="text" id="messageBox2"  placeholder="Tapez votre message..." name="message" onkeypress="commentaire(this,event, ${k});"/> 
  
      <g:each var="commentaire" status="i" in="${message.commentaires}">
        
        <span class="input-xlarge uneditable-input span9"> <strong><g:link action="show" controller="Effectif" id="${commentaire.auteur.id}"><i class="cus-user-business-boss"></i> ${commentaire.auteur.nom} ${commentaire.auteur.prenom}</g:link></strong>  : ${commentaire.texte} <span class="message-time"><g:formatDate format="dd-MM-yyyy hh:mm a" date="${commentaire.date}"/></span></span>
    
    

</g:each></g:if>
 
      
  </span>
    
  </span>
                                                                     

</p>
  
</g:each>
 
 <script>
                                                          function commentaire(field,event,ok) {  
                                                            var theCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
                                                            var message = $('#messageBox2').val();
                                                            var monId = $('#monId'+ok).val();
                                                            if (theCode == 13){
                                                        <g:remoteFunction controller = "message" action="posterMessageCommentaire" params="\'message=\'+message+ '&monId=\' + monId" update="temp"/>
                                                                    $('#messageBox').val('');
                                                                    return false;
                                                                  } else {
                                                                    return true;
                                                                  }
                                                                  }
                                                                  function obtenirCommentaire() {
                                                                  // var kanban = $('#monKanban').val()
                                                                          <g:remoteFunction controller="message" action="obtenirMessage" update="newsfeed"/>
                                                                        };
                                                                                                                               
                                                        </script>