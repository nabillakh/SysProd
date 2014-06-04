 <div class="sidebar-nav-fixed">
<ul class="menu" id="accordion-menu-js">
<g:if test="${calcul == 1}">
  <g:set var="calcul" value="$calcul+1}" />


                  <!-- compteur du Nombre de message à afficher-->
	 <g:set var="counteur" value="${0}" />   
                  <!-- Boucle des maileffectif-->
      
         <g:each in="${mesEffectifsMails}" status="i" var="mailEffectifInstance"> 
           
            
 <li class="current">
	

                  <!-- les messages lus-->
       <g:set var="imagenlu" value="${mailEffectifInstance.lu}" />
                <!-- on augmente le compteur des messages à afficher-->
       <g:set var="counteur" value="${counteur+1}" />  
                <!-- on affiche que 4 messages puis on arrette la boucle -->
       <g:if test="${counter <= 4}">
            <g:link  controller="MailEffectif"  action="show"  id="${mailEffectifInstance.id}" style=" color :#000000;">  
                 <!-- on teste si le message est lu ou pas et on affiche l'image qui correspond -->
            <g:if test="${imagenlu == false}">
                <img src="${request.contextPath}/img/email-unread.png" alt="important mail">
            </g:if>
            <g:else>
                <img src="${request.contextPath}/img/email-read.png" alt="important mail">
            </g:else>
                ${mailEffectifInstance.mail.objet}: ${mailEffectifInstance.mail.author.username}.
            </g:link>
            ${mailEffectifInstance.mail.message}
         
      </g:if>
 </li>
          
      </g:each>

</g:if>
 
 </ul>
 </div>