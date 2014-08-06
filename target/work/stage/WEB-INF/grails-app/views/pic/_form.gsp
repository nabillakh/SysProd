<%@ page import="application.pilotage.Pic" %>



<div class="fieldcontain ${hasErrors(bean: picInstance, field: 'dateVersion', 'error')} ">
	<label for="dateVersion">
		<g:message code="pic.dateVersion.label" default="Date Version" />
		
	</label>
	<g:datePicker name="dateVersion" precision="day"  value="${picInstance?.dateVersion}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: picInstance, field: 'dateMaj', 'error')} ">
	<label for="dateMaj">
		<g:message code="pic.dateMaj.label" default="Date Maj" />
		
	</label>
	<g:datePicker name="dateMaj" precision="day"  value="${picInstance?.dateMaj}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: picInstance, field: 'annee', 'error')} required">
	<label for="annee">
		<g:message code="pic.annee.label" default="Annee" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="annee" type="number" value="${picInstance.annee}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: picInstance, field: 'picFamille', 'error')} ">
	<label for="picFamille">
		<g:message code="pic.picFamille.label" default="Pic Famille" />
		
	</label>
	<g:select name="picFamille" from="${application.pilotage.PicFamille.list()}" multiple="multiple" optionKey="id" size="5" value="${picInstance?.picFamille*.id}" class="many-to-many"/>

</div>

