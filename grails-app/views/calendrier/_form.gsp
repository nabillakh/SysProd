<%@ page import="application.communication.Calendrier" %>



<div class="fieldcontain ${hasErrors(bean: calendrierInstance, field: 'mesEvents', 'error')} ">
	<label for="mesEvents">
		<g:message code="calendrier.mesEvents.label" default="Mes Events" />
		
	</label>
	<g:select name="mesEvents" from="${application.communication.Event.list()}" multiple="multiple" optionKey="id" size="5" value="${calendrierInstance?.mesEvents*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: calendrierInstance, field: 'nom', 'error')} ">
	<label for="nom">
		<g:message code="calendrier.nom.label" default="Nom" />
		
	</label>
	<g:textField name="nom" value="${calendrierInstance?.nom}"/>

</div>

