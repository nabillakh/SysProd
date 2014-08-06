
<div class="mailMessage" id="message_${messageCounter}">
    <strong><span class="author">${mailMessage.author.username}</span> said</strong>
    <strong><span class="recepteur">${mailMessage.recepteur.username}</span> pour</strong>
    <span class="mailMessage">${mailMessage.message}</span><br/>
    <div class="mailMessageTime">at <g:formatDate date="${mailMessage.dateCreated}"/></div>
</div>
