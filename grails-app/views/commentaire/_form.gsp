<%@ page import="application.communication.Commentaire" %>



<div class="fieldcontain ${hasErrors(bean: commentaireInstance, field: 'auteur', 'error')} required">
	<label for="auteur">
		<g:message code="commentaire.auteur.label" default="Auteur" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="auteur" name="auteur.id" from="${application.RH.Effectif.list()}" optionKey="id" required="" value="${commentaireInstance?.auteur?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: commentaireInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="commentaire.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${commentaireInstance?.date}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: commentaireInstance, field: 'message', 'error')} required">
	<label for="message">
		<g:message code="commentaire.message.label" default="Message" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="message" name="message.id" from="${application.communication.Message.list()}" optionKey="id" required="" value="${commentaireInstance?.message?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: commentaireInstance, field: 'texte', 'error')} ">
	<label for="texte">
		<g:message code="commentaire.texte.label" default="Texte" />
		
	</label>
	<g:textField name="texte" value="${commentaireInstance?.texte}"/>

</div>

