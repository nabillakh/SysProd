<%@ page import="application.communication.Message" %>



<div class="fieldcontain ${hasErrors(bean: messageInstance, field: 'kanban', 'error')} ">
	<label for="kanban">
		<g:message code="message.kanban.label" default="Kanban" />
		
	</label>
	<g:select id="kanban" name="kanban.id" from="${application.PP.Kanban.list()}" optionKey="id" value="${messageInstance?.kanban?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: messageInstance, field: 'auteur', 'error')} required">
	<label for="auteur">
		<g:message code="message.auteur.label" default="Auteur" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="auteur" name="auteur.id" from="${application.RH.Effectif.list()}" optionKey="id" required="" value="${messageInstance?.auteur?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: messageInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="message.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${messageInstance?.date}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: messageInstance, field: 'message', 'error')} ">
	<label for="message">
		<g:message code="message.message.label" default="Message" />
		
	</label>
	<g:textField name="message" value="${messageInstance?.message}"/>

</div>

