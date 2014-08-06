<%@ page import="application.RH.Equipe" %>



<div class="fieldcontain ${hasErrors(bean: equipeInstance, field: 'mesEffectifs', 'error')} ">
	<label for="mesEffectifs">
		<g:message code="equipe.mesEffectifs.label" default="Mes Effectifs" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${equipeInstance?.mesEffectifs?}" var="m">
    <li><g:link controller="effectif" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="effectif" action="create" params="['equipe.id': equipeInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'effectif.label', default: 'Effectif')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: equipeInstance, field: 'nom', 'error')} ">
	<label for="nom">
		<g:message code="equipe.nom.label" default="Nom" />
		
	</label>
	<g:textField name="nom" value="${equipeInstance?.nom}"/>

</div>

