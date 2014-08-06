<%@ page import="application.PP.Phase" %>



<div class="fieldcontain ${hasErrors(bean: phaseInstance, field: 'valeurAjoutee', 'error')} ">
	<label for="valeurAjoutee">
		<g:message code="phase.valeurAjoutee.label" default="Valeur Ajoutee" />
		
	</label>
	<g:checkBox name="valeurAjoutee" value="${phaseInstance?.valeurAjoutee}" />

</div>

<div class="fieldcontain ${hasErrors(bean: phaseInstance, field: 'kanbans', 'error')} ">
	<label for="kanbans">
		<g:message code="phase.kanbans.label" default="Kanbans" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${phaseInstance?.kanbans?}" var="k">
    <li><g:link controller="kanban" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="kanban" action="create" params="['phase.id': phaseInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'kanban.label', default: 'Kanban')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: phaseInstance, field: 'competence', 'error')} ">
	<label for="competence">
		<g:message code="phase.competence.label" default="Competence" />
		
	</label>
	<g:select id="competence" name="competence.id" from="${application.RH.Competence.list()}" optionKey="id" value="${phaseInstance?.competence?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: phaseInstance, field: 'monOrdo', 'error')} ">
	<label for="monOrdo">
		<g:message code="phase.monOrdo.label" default="Mon Ordo" />
		
	</label>
	<g:select id="monOrdo" name="monOrdo.id" from="${application.PP.Ordonnancement.list()}" optionKey="id" value="${phaseInstance?.monOrdo?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: phaseInstance, field: 'cleRepartition', 'error')} required">
	<label for="cleRepartition">
		<g:message code="phase.cleRepartition.label" default="Cle Repartition" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="cleRepartition" value="${fieldValue(bean: phaseInstance, field: 'cleRepartition')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: phaseInstance, field: 'nom', 'error')} ">
	<label for="nom">
		<g:message code="phase.nom.label" default="Nom" />
		
	</label>
	<g:textField name="nom" value="${phaseInstance?.nom}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: phaseInstance, field: 'ordre', 'error')} required">
	<label for="ordre">
		<g:message code="phase.ordre.label" default="Ordre" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ordre" type="number" value="${phaseInstance.ordre}" required=""/>

</div>

