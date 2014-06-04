<%@ page import="application.PP.Imputation" %>



<div class="fieldcontain ${hasErrors(bean: imputationInstance, field: 'event', 'error')} required">
	<label for="event">
		<g:message code="imputation.event.label" default="Event" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="event" name="event.id" from="${application.communication.Event.list()}" optionKey="id" required="" value="${imputationInstance?.event?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: imputationInstance, field: 'of', 'error')} required">
	<label for="of">
		<g:message code="imputation.of.label" default="Of" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="of" name="of.id" from="${application.PP.OF.list()}" optionKey="id" required="" value="${imputationInstance?.of?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: imputationInstance, field: 'realise', 'error')} ">
	<label for="realise">
		<g:message code="imputation.realise.label" default="Realise" />
		
	</label>
	<g:checkBox name="realise" value="${imputationInstance?.realise}" />

</div>

