
<%@ page import="application.PP.OF" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'OF.label', default: 'OF')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-OF" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-OF" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list OF">
			
				<g:if test="${OFInstance?.chargePlanifiee}">
				<li class="fieldcontain">
					<span id="chargePlanifiee-label" class="property-label"><g:message code="OF.chargePlanifiee.label" default="Charge Planifiee" /></span>
					
						<span class="property-value" aria-labelledby="chargePlanifiee-label"><g:fieldValue bean="${OFInstance}" field="chargePlanifiee"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${OFInstance?.affectes}">
				<li class="fieldcontain">
					<span id="affectes-label" class="property-label"><g:message code="OF.affectes.label" default="Affectes" /></span>
					
						<g:each in="${OFInstance.affectes}" var="a">
						<span class="property-value" aria-labelledby="affectes-label"><g:link controller="effectif" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${OFInstance?.dateDebutPlanifie}">
				<li class="fieldcontain">
					<span id="dateDebutPlanifie-label" class="property-label"><g:message code="OF.dateDebutPlanifie.label" default="Date Debut Planifie" /></span>
					
						<span class="property-value" aria-labelledby="dateDebutPlanifie-label"><g:formatDate date="${OFInstance?.dateDebutPlanifie}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${OFInstance?.dateFinPlanifie}">
				<li class="fieldcontain">
					<span id="dateFinPlanifie-label" class="property-label"><g:message code="OF.dateFinPlanifie.label" default="Date Fin Planifie" /></span>
					
						<span class="property-value" aria-labelledby="dateFinPlanifie-label"><g:formatDate date="${OFInstance?.dateFinPlanifie}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${OFInstance?.kanban}">
				<li class="fieldcontain">
					<span id="kanban-label" class="property-label"><g:message code="OF.kanban.label" default="Kanban" /></span>
					
						<span class="property-value" aria-labelledby="kanban-label"><g:link controller="kanban" action="show" id="${OFInstance?.kanban?.id}">${OFInstance?.kanban?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${OFInstance?.phase}">
				<li class="fieldcontain">
					<span id="phase-label" class="property-label"><g:message code="OF.phase.label" default="Phase" /></span>
					
						<span class="property-value" aria-labelledby="phase-label"><g:link controller="phase" action="show" id="${OFInstance?.phase?.id}">${OFInstance?.phase?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:OFInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${OFInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
