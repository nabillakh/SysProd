
<%@ page import="application.PP.Ordonnancement" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ordonnancement.label', default: 'Ordonnancement')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-ordonnancement" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-ordonnancement" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list ordonnancement">
			
				<g:if test="${ordonnancementInstance?.phases}">
				<li class="fieldcontain">
					<span id="phases-label" class="property-label"><g:message code="ordonnancement.phases.label" default="Phases" /></span>
					
						<g:each in="${ordonnancementInstance.phases}" var="p">
						<span class="property-value" aria-labelledby="phases-label"><g:link controller="phase" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${ordonnancementInstance?.chargeStandard}">
				<li class="fieldcontain">
					<span id="chargeStandard-label" class="property-label"><g:message code="ordonnancement.chargeStandard.label" default="Charge Standard" /></span>
					
						<span class="property-value" aria-labelledby="chargeStandard-label"><g:fieldValue bean="${ordonnancementInstance}" field="chargeStandard"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ordonnancementInstance?.famille}">
				<li class="fieldcontain">
					<span id="famille-label" class="property-label"><g:message code="ordonnancement.famille.label" default="Famille" /></span>
					
						<span class="property-value" aria-labelledby="famille-label"><g:link controller="famille" action="show" id="${ordonnancementInstance?.famille?.id}">${ordonnancementInstance?.famille?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${ordonnancementInstance?.nom}">
				<li class="fieldcontain">
					<span id="nom-label" class="property-label"><g:message code="ordonnancement.nom.label" default="Nom" /></span>
					
						<span class="property-value" aria-labelledby="nom-label"><g:fieldValue bean="${ordonnancementInstance}" field="nom"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:ordonnancementInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${ordonnancementInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
