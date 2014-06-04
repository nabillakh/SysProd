<%@ page import="application.PP.Ordonnancement" %>



<div class="fieldcontain ${hasErrors(bean: ordonnancementInstance, field: 'famille', 'error')} ">
	<label for="famille">
		<g:message code="ordonnancement.famille.label" default="Famille" />
		
	</label>
	<g:select id="famille" name="famille.id" from="${application.PP.Famille.list()}" optionKey="id" value="${ordonnancementInstance?.famille?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: ordonnancementInstance, field: 'phases', 'error')} ">
	<label for="phases">
		<g:message code="ordonnancement.phases.label" default="Phases" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${ordonnancementInstance?.phases?}" var="p">
    <li><g:link controller="phase" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="phase" action="create" params="['ordonnancement.id': ordonnancementInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'phase.label', default: 'Phase')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: ordonnancementInstance, field: 'chargeStandard', 'error')} required">
	<label for="chargeStandard">
		<g:message code="ordonnancement.chargeStandard.label" default="Charge Standard" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="chargeStandard" value="${fieldValue(bean: ordonnancementInstance, field: 'chargeStandard')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: ordonnancementInstance, field: 'nom', 'error')} ">
	<label for="nom">
		<g:message code="ordonnancement.nom.label" default="Nom" />
		
	</label>
	<g:textField name="nom" value="${ordonnancementInstance?.nom}"/>

</div>

