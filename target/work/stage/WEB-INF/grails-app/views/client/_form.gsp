<%@ page import="application.CRM.Client" %>



<div class="fieldcontain ${hasErrors(bean: clientInstance, field: 'projets', 'error')} ">
	<label for="projets">
		<g:message code="client.projets.label" default="Projets" />
		
	</label>
	<g:select name="projets" from="${application.PP.Kanban.list()}" multiple="multiple" optionKey="id" size="5" value="${clientInstance?.projets*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: clientInstance, field: 'nom', 'error')} ">
	<label for="nom">
		<g:message code="client.nom.label" default="Nom" />
		
	</label>
	<g:textField name="nom" value="${clientInstance?.nom}"/>

</div>

