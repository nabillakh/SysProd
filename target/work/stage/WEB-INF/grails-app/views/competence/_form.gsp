<%@ page import="application.RH.Competence" %>



<div class="fieldcontain ${hasErrors(bean: competenceInstance, field: 'effectifs', 'error')} ">
	<label for="effectifs">
		<g:message code="competence.effectifs.label" default="Effectifs" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${competenceInstance?.effectifs?}" var="e">
    <li><g:link controller="competenceEffectif" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="competenceEffectif" action="create" params="['competence.id': competenceInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'competenceEffectif.label', default: 'CompetenceEffectif')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: competenceInstance, field: 'nom', 'error')} ">
	<label for="nom">
		<g:message code="competence.nom.label" default="Nom" />
		
	</label>
	<g:textField name="nom" value="${competenceInstance?.nom}"/>

</div>

