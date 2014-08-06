<%@ page import="application.communication.MailEffectif" %>



<div class="fieldcontain ${hasErrors(bean: mailEffectifInstance, field: 'lu', 'error')} ">
	<label for="lu">
		<g:message code="mailEffectif.lu.label" default="Lu" />
		
	</label>
	<g:checkBox name="lu" value="${mailEffectifInstance?.lu}" />

</div>

<div class="fieldcontain ${hasErrors(bean: mailEffectifInstance, field: 'mail', 'error')} required">
	<label for="mail">
		<g:message code="mailEffectif.mail.label" default="Mail" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="mail" name="mail.id" from="${application.communication.Mail.list()}" optionKey="id" required="" value="${mailEffectifInstance?.mail?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mailEffectifInstance, field: 'recepteur', 'error')} required">
	<label for="recepteur">
		<g:message code="mailEffectif.recepteur.label" default="Recepteur" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="recepteur" name="recepteur.id" from="${application.RH.Effectif.list()}" optionKey="id" required="" value="${mailEffectifInstance?.recepteur?.id}" class="many-to-one"/>

</div>

