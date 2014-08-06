<%@ page import="application.RH.CompetenceEffectif" %>



<div class="fieldcontain ${hasErrors(bean: competenceEffectifInstance, field: 'competence', 'error')} required">
	<label for="competence">
		<g:message code="competenceEffectif.competence.label" default="Competence" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="competence" name="competence.id" from="${application.RH.Competence.list()}" optionKey="id" required="" value="${competenceEffectifInstance?.competence?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: competenceEffectifInstance, field: 'effectif', 'error')} required">
	<label for="effectif">
		<g:message code="competenceEffectif.effectif.label" default="Effectif" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="effectif" name="effectif.id" from="${application.RH.Effectif.list()}" optionKey="id" required="" value="${competenceEffectifInstance?.effectif?.id}" class="many-to-one"/>

</div>

