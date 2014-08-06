
<%@ page import="application.pilotage.Pdp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pdp.label', default: 'Pdp')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-pdp" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-pdp" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list pdp">
			
				<g:if test="${pdpInstance?.dateVersion}">
				<li class="fieldcontain">
					<span id="dateVersion-label" class="property-label"><g:message code="pdp.dateVersion.label" default="Date Version" /></span>
					
						<span class="property-value" aria-labelledby="dateVersion-label"><g:formatDate date="${pdpInstance?.dateVersion}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${pdpInstance?.dateMaj}">
				<li class="fieldcontain">
					<span id="dateMaj-label" class="property-label"><g:message code="pdp.dateMaj.label" default="Date Maj" /></span>
					
						<span class="property-value" aria-labelledby="dateMaj-label"><g:formatDate date="${pdpInstance?.dateMaj}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${pdpInstance?.uniteActivite}">
				<li class="fieldcontain">
					<span id="uniteActivite-label" class="property-label"><g:message code="pdp.uniteActivite.label" default="Unite Activite" /></span>
					
						<span class="property-value" aria-labelledby="uniteActivite-label"><g:fieldValue bean="${pdpInstance}" field="uniteActivite"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pdpInstance?.kanbansRealises}">
				<li class="fieldcontain">
					<span id="kanbansRealises-label" class="property-label"><g:message code="pdp.kanbansRealises.label" default="Kanbans Realises" /></span>
					
						<g:each in="${pdpInstance.kanbansRealises}" var="k">
						<span class="property-value" aria-labelledby="kanbansRealises-label"><g:link controller="pdpKanban" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${pdpInstance?.mois}">
				<li class="fieldcontain">
					<span id="mois-label" class="property-label"><g:message code="pdp.mois.label" default="Mois" /></span>
					
						<span class="property-value" aria-labelledby="mois-label"><g:fieldValue bean="${pdpInstance}" field="mois"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pdpInstance?.picFamille}">
				<li class="fieldcontain">
					<span id="picFamille-label" class="property-label"><g:message code="pdp.picFamille.label" default="Pic Famille" /></span>
					
						<span class="property-value" aria-labelledby="picFamille-label"><g:link controller="picFamille" action="show" id="${pdpInstance?.picFamille?.id}">${pdpInstance?.picFamille?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:pdpInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${pdpInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
