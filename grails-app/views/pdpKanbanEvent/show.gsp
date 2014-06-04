
<%@ page import="application.pilotage.PdpKanbanEvent" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pdpKanbanEvent.label', default: 'PdpKanbanEvent')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-pdpKanbanEvent" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-pdpKanbanEvent" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list pdpKanbanEvent">
			
				<g:if test="${pdpKanbanEventInstance?.imputations}">
				<li class="fieldcontain">
					<span id="imputations-label" class="property-label"><g:message code="pdpKanbanEvent.imputations.label" default="Imputations" /></span>
					
						<g:each in="${pdpKanbanEventInstance.imputations}" var="i">
						<span class="property-value" aria-labelledby="imputations-label"><g:link controller="event" action="show" id="${i.id}">${i?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${pdpKanbanEventInstance?.kanban}">
				<li class="fieldcontain">
					<span id="kanban-label" class="property-label"><g:message code="pdpKanbanEvent.kanban.label" default="Kanban" /></span>
					
						<span class="property-value" aria-labelledby="kanban-label"><g:link controller="kanban" action="show" id="${pdpKanbanEventInstance?.kanban?.id}">${pdpKanbanEventInstance?.kanban?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${pdpKanbanEventInstance?.kanbanReel}">
				<li class="fieldcontain">
					<span id="kanbanReel-label" class="property-label"><g:message code="pdpKanbanEvent.kanbanReel.label" default="Kanban Reel" /></span>
					
						<span class="property-value" aria-labelledby="kanbanReel-label"><g:formatBoolean boolean="${pdpKanbanEventInstance?.kanbanReel}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${pdpKanbanEventInstance?.pdp}">
				<li class="fieldcontain">
					<span id="pdp-label" class="property-label"><g:message code="pdpKanbanEvent.pdp.label" default="Pdp" /></span>
					
						<span class="property-value" aria-labelledby="pdp-label"><g:link controller="pdp" action="show" id="${pdpKanbanEventInstance?.pdp?.id}">${pdpKanbanEventInstance?.pdp?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:pdpKanbanEventInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${pdpKanbanEventInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
