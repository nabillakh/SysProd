
<%@ page import="application.PP.Imputation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'imputation.label', default: 'Imputation')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-imputation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-imputation" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list imputation">
			
				<g:if test="${imputationInstance?.event}">
				<li class="fieldcontain">
					<span id="event-label" class="property-label"><g:message code="imputation.event.label" default="Event" /></span>
					
						<span class="property-value" aria-labelledby="event-label"><g:link controller="event" action="show" id="${imputationInstance?.event?.id}">${imputationInstance?.event?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${imputationInstance?.of}">
				<li class="fieldcontain">
					<span id="of-label" class="property-label"><g:message code="imputation.of.label" default="Of" /></span>
					
						<span class="property-value" aria-labelledby="of-label"><g:link controller="OF" action="show" id="${imputationInstance?.of?.id}">${imputationInstance?.of?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${imputationInstance?.realise}">
				<li class="fieldcontain">
					<span id="realise-label" class="property-label"><g:message code="imputation.realise.label" default="Realise" /></span>
					
						<span class="property-value" aria-labelledby="realise-label"><g:formatBoolean boolean="${imputationInstance?.realise}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:imputationInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${imputationInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
