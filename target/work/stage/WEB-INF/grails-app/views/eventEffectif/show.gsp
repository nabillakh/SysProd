
<%@ page import="application.communication.EventEffectif" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'eventEffectif.label', default: 'EventEffectif')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-eventEffectif" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-eventEffectif" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list eventEffectif">
			
				<g:if test="${eventEffectifInstance?.dateCreation}">
				<li class="fieldcontain">
					<span id="dateCreation-label" class="property-label"><g:message code="eventEffectif.dateCreation.label" default="Date Creation" /></span>
					
						<span class="property-value" aria-labelledby="dateCreation-label"><g:formatDate date="${eventEffectifInstance?.dateCreation}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventEffectifInstance?.event}">
				<li class="fieldcontain">
					<span id="event-label" class="property-label"><g:message code="eventEffectif.event.label" default="Event" /></span>
					
						<span class="property-value" aria-labelledby="event-label"><g:link controller="event" action="show" id="${eventEffectifInstance?.event?.id}">${eventEffectifInstance?.event?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventEffectifInstance?.participe}">
				<li class="fieldcontain">
					<span id="participe-label" class="property-label"><g:message code="eventEffectif.participe.label" default="Participe" /></span>
					
						<span class="property-value" aria-labelledby="participe-label"><g:formatBoolean boolean="${eventEffectifInstance?.participe}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventEffectifInstance?.recepteur}">
				<li class="fieldcontain">
					<span id="recepteur-label" class="property-label"><g:message code="eventEffectif.recepteur.label" default="Recepteur" /></span>
					
						<span class="property-value" aria-labelledby="recepteur-label"><g:link controller="effectif" action="show" id="${eventEffectifInstance?.recepteur?.id}">${eventEffectifInstance?.recepteur?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:eventEffectifInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${eventEffectifInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
