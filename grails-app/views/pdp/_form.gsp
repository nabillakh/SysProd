<%@ page import="application.pilotage.Pdp" %>



<div class="fieldcontain ${hasErrors(bean: pdpInstance, field: 'dateVersion', 'error')} ">
	<label for="dateVersion">
		<g:message code="pdp.dateVersion.label" default="Date Version" />
		
	</label>
	<g:datePicker name="dateVersion" precision="day"  value="${pdpInstance?.dateVersion}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: pdpInstance, field: 'dateMaj', 'error')} ">
	<label for="dateMaj">
		<g:message code="pdp.dateMaj.label" default="Date Maj" />
		
	</label>
	<g:datePicker name="dateMaj" precision="day"  value="${pdpInstance?.dateMaj}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: pdpInstance, field: 'uniteActivite', 'error')} ">
	<label for="uniteActivite">
		<g:message code="pdp.uniteActivite.label" default="Unite Activite" />
		
	</label>
	<g:field name="uniteActivite" value="${fieldValue(bean: pdpInstance, field: 'uniteActivite')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pdpInstance, field: 'kanbansRealises', 'error')} ">
	<label for="kanbansRealises">
		<g:message code="pdp.kanbansRealises.label" default="Kanbans Realises" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${pdpInstance?.kanbansRealises?}" var="k">
    <li><g:link controller="pdpKanban" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="pdpKanban" action="create" params="['pdp.id': pdpInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'pdpKanban.label', default: 'PdpKanban')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: pdpInstance, field: 'mois', 'error')} required">
	<label for="mois">
		<g:message code="pdp.mois.label" default="Mois" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="mois" type="number" value="${pdpInstance.mois}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: pdpInstance, field: 'picFamille', 'error')} required">
	<label for="picFamille">
		<g:message code="pdp.picFamille.label" default="Pic Famille" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="picFamille" name="picFamille.id" from="${application.pilotage.PicFamille.list()}" optionKey="id" required="" value="${pdpInstance?.picFamille?.id}" class="many-to-one"/>

</div>

