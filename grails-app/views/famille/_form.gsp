<%@ page import="application.PP.Famille" %>



<div class="fieldcontain ${hasErrors(bean: familleInstance, field: 'ordo', 'error')} ">
	<label for="ordo">
		<g:message code="famille.ordo.label" default="Ordo" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${familleInstance?.ordo?}" var="o">
    <li><g:link controller="ordonnancement" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="ordonnancement" action="create" params="['famille.id': familleInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'ordonnancement.label', default: 'Ordonnancement')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: familleInstance, field: 'travaille', 'error')} ">
	<label for="travaille">
		<g:message code="famille.travaille.label" default="Travaille" />
		
	</label>
	<g:checkBox name="travaille" value="${familleInstance?.travaille}" />

</div>

<div class="fieldcontain ${hasErrors(bean: familleInstance, field: 'nom', 'error')} ">
	<label for="nom">
		<g:message code="famille.nom.label" default="Nom" />
		
	</label>
	<g:textField name="nom" value="${familleInstance?.nom}"/>

</div>

