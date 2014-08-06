<%@ page import="application.communication.Conversation" %>



<div class="fieldcontain ${hasErrors(bean: conversationInstance, field: 'mails', 'error')} ">
	<label for="mails">
		<g:message code="conversation.mails.label" default="Mails" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${conversationInstance?.mails?}" var="m">
    <li><g:link controller="mail" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="mail" action="create" params="['conversation.id': conversationInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'mail.label', default: 'Mail')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: conversationInstance, field: 'lastDate', 'error')} required">
	<label for="lastDate">
		<g:message code="conversation.lastDate.label" default="Last Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="lastDate" precision="day"  value="${conversationInstance?.lastDate}"  />

</div>

