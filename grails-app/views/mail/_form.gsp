
<div class="fieldcontain ${hasErrors(bean: mailInstance, field: 'message', 'error')} ">
	<label for="message">
		<g:message code="mail.message.label" default="Message" />
		
	</label>
	<g:textField name="message" value="${mailInstance?.message}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mailInstance, field: 'recepteur', 'error')} ">
	<label for="recepteur">
		<g:message code="mail.recepteur.label" default="Recepteur" />
		
	</label>
	<g:select name="recepteur" from="${application.RH.Effectif.list()}" multiple="multiple" optionKey="id" size="5" value="${mailInstance?.recepteur*.id}" class="many-to-many"/>

</div>

