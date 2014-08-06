<%@ page import="application.communication.EventEffectif" %>



<div class="fieldcontain ${hasErrors(bean: eventEffectifInstance, field: 'dateCreation', 'error')} required">
	<label for="dateCreation">
		<g:message code="eventEffectif.dateCreation.label" default="Date Creation" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateCreation" precision="day"  value="${eventEffectifInstance?.dateCreation}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: eventEffectifInstance, field: 'event', 'error')} required">
	<label for="event">
		<g:message code="eventEffectif.event.label" default="Event" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="event" name="event.id" from="${application.communication.Event.list()}" optionKey="id" required="" value="${eventEffectifInstance?.event?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: eventEffectifInstance, field: 'participe', 'error')} ">
	<label for="participe">
		<g:message code="eventEffectif.participe.label" default="Participe" />
		
	</label>
	<g:checkBox name="participe" value="${eventEffectifInstance?.participe}" />

</div>

<div class="fieldcontain ${hasErrors(bean: eventEffectifInstance, field: 'recepteur', 'error')} required">
	<label for="recepteur">
		<g:message code="eventEffectif.recepteur.label" default="Recepteur" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="recepteur" name="recepteur.id" from="${application.RH.Effectif.list()}" optionKey="id" required="" value="${eventEffectifInstance?.recepteur?.id}" class="many-to-one"/>

</div>

