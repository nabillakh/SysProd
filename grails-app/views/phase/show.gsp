
<%@ page import="application.PP.Phase" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'phase.label', default: 'Phase')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-phase" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-phase" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list phase">
			
				<g:if test="${phaseInstance?.valeurAjoutee}">
				<li class="fieldcontain">
					<span id="valeurAjoutee-label" class="property-label"><g:message code="phase.valeurAjoutee.label" default="Valeur Ajoutee" /></span>
					
						<span class="property-value" aria-labelledby="valeurAjoutee-label"><g:formatBoolean boolean="${phaseInstance?.valeurAjoutee}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${phaseInstance?.kanbans}">
				<li class="fieldcontain">
					<span id="kanbans-label" class="property-label"><g:message code="phase.kanbans.label" default="Kanbans" /></span>
					
						<g:each in="${phaseInstance.kanbans}" var="k">
						<span class="property-value" aria-labelledby="kanbans-label"><g:link controller="kanban" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${phaseInstance?.competence}">
				<li class="fieldcontain">
					<span id="competence-label" class="property-label"><g:message code="phase.competence.label" default="Competence" /></span>
					
						<span class="property-value" aria-labelledby="competence-label"><g:link controller="competence" action="show" id="${phaseInstance?.competence?.id}">${phaseInstance?.competence?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${phaseInstance?.monOrdo}">
				<li class="fieldcontain">
					<span id="monOrdo-label" class="property-label"><g:message code="phase.monOrdo.label" default="Mon Ordo" /></span>
					
						<span class="property-value" aria-labelledby="monOrdo-label"><g:link controller="ordonnancement" action="show" id="${phaseInstance?.monOrdo?.id}">${phaseInstance?.monOrdo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${phaseInstance?.cleRepartition}">
				<li class="fieldcontain">
					<span id="cleRepartition-label" class="property-label"><g:message code="phase.cleRepartition.label" default="Cle Repartition" /></span>
					
						<span class="property-value" aria-labelledby="cleRepartition-label"><g:fieldValue bean="${phaseInstance}" field="cleRepartition"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${phaseInstance?.nom}">
				<li class="fieldcontain">
					<span id="nom-label" class="property-label"><g:message code="phase.nom.label" default="Nom" /></span>
					
						<span class="property-value" aria-labelledby="nom-label"><g:fieldValue bean="${phaseInstance}" field="nom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${phaseInstance?.ordre}">
				<li class="fieldcontain">
					<span id="ordre-label" class="property-label"><g:message code="phase.ordre.label" default="Ordre" /></span>
					
						<span class="property-value" aria-labelledby="ordre-label"><g:fieldValue bean="${phaseInstance}" field="ordre"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:phaseInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${phaseInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
