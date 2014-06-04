<%@ page import="application.RH.Competence" %>



<div class="fieldcontain ${hasErrors(bean: competenceInstance, field: 'effectifs', 'error')} ">
	<label for="effectifs">
		<g:message code="competence.effectifs.label" default="Effectifs" />
		
	</label>
	<g:select name="effectifs" from="${application.RH.Effectif.list()}" multiple="multiple" optionKey="id" size="5" value="${competenceInstance?.effectifs*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: competenceInstance, field: 'nom', 'error')} ">
	<label for="nom">
		<g:message code="competence.nom.label" default="Nom" />
		
	</label>
	<g:textField name="nom" value="${competenceInstance?.nom}"/>

</div>

