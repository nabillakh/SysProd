<%@ page import="application.RH.EffectifDroit" %>



<div class="fieldcontain ${hasErrors(bean: effectifDroitInstance, field: 'droit', 'error')} required">
	<label for="droit">
		<g:message code="effectifDroit.droit.label" default="Droit" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="droit" name="droit.id" from="${application.RH.Droit.list()}" optionKey="id" required="" value="${effectifDroitInstance?.droit?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: effectifDroitInstance, field: 'effectif', 'error')} required">
	<label for="effectif">
		<g:message code="effectifDroit.effectif.label" default="Effectif" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="effectif" name="effectif.id" from="${application.RH.Effectif.list()}" optionKey="id" required="" value="${effectifDroitInstance?.effectif?.id}" class="many-to-one"/>

</div>

