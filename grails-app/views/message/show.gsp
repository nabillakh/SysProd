
<%@ page import="application.communication.Message" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'message.label', default: 'Message')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-message" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-message" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list message">
			
				<g:if test="${messageInstance?.kanban}">
				<li class="fieldcontain">
					<span id="kanban-label" class="property-label"><g:message code="message.kanban.label" default="Kanban" /></span>
					
						<span class="property-value" aria-labelledby="kanban-label"><g:link controller="kanban" action="show" id="${messageInstance?.kanban?.id}">${messageInstance?.kanban?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${messageInstance?.auteur}">
				<li class="fieldcontain">
					<span id="auteur-label" class="property-label"><g:message code="message.auteur.label" default="Auteur" /></span>
					
						<span class="property-value" aria-labelledby="auteur-label"><g:link controller="effectif" action="show" id="${messageInstance?.auteur?.id}">${messageInstance?.auteur?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${messageInstance?.date}">
				<li class="fieldcontain">
					<span id="date-label" class="property-label"><g:message code="message.date.label" default="Date" /></span>
					
						<span class="property-value" aria-labelledby="date-label"><g:formatDate date="${messageInstance?.date}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${messageInstance?.message}">
				<li class="fieldcontain">
					<span id="message-label" class="property-label"><g:message code="message.message.label" default="Message" /></span>
					
						<span class="property-value" aria-labelledby="message-label"><g:fieldValue bean="${messageInstance}" field="message"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:messageInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${messageInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
