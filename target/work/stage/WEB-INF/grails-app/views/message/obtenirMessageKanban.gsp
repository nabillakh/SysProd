

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
      
      <g:link  action="index" controller="commentaire"  class="pull-right"><i class="cus-comment"></i></g:link> 
      
    
  </span>
    
  </span>
                                                                     
    <g:if test="${message.commentaires}">
      
      <p id="message-id-3" class="message-box">
        <span class="message">
  <input class="span12 type-effect"  type="text" id="messageBox"  placeholder="Tapez votre message..." name="message" onkeypress="commentaire(this,event);"/> 
         
      <g:each var="commentaire" status="i" in="${message.commentaires}">
 
${commentaire.auteur.nom}
  
  
    <span class="message-time"><g:formatDate format="dd-MM-yyyy hh:mm a" date="${commentaire.date}"/></span>
    <span class="message-text">${commentaire.texte}
           
    
  </span>

</g:each></span></p></g:if>
</p>
  
</g:each>
 
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