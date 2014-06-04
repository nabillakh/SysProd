<%@ page import="application.PP.CompteRendu" %>



<div class="fieldcontain ${hasErrors(bean: compteRenduInstance, field: 'of', 'error')} ">
	<label for="of">
		<g:message code="compteRendu.of.label" default="Of" />
		
	</label>
	<g:select id="of" name="of.id" from="${application.PP.OF.list()}" optionKey="id" value="${compteRenduInstance?.of?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: compteRenduInstance, field: 'kanban', 'error')} ">
	<label for="kanban">
		<g:message code="compteRendu.kanban.label" default="Kanban" />
		
	</label>
	<g:select id="kanban" name="kanban.id" from="${application.PP.Kanban.list()}" optionKey="id" value="${compteRenduInstance?.kanban?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: compteRenduInstance, field: 'author', 'error')} required">
	<label for="author">
		<g:message code="compteRendu.author.label" default="Author" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="author" name="author.id" from="${application.RH.Effectif.list()}" optionKey="id" required="" value="${compteRenduInstance?.author?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: compteRenduInstance, field: 'message', 'error')} ">
	<label for="message">
		<g:message code="compteRendu.message.label" default="Message" />
		
	</label>
	<g:textField name="message" value="${compteRenduInstance?.message}"/>

</div>

