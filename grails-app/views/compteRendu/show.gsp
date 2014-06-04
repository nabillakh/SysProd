
<%@ page import="application.PP.CompteRendu" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'compteRendu.label', default: 'CompteRendu')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-compteRendu" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-compteRendu" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list compteRendu">
			
				<g:if test="${compteRenduInstance?.of}">
				<li class="fieldcontain">
					<span id="of-label" class="property-label"><g:message code="compteRendu.of.label" default="Of" /></span>
					
						<span class="property-value" aria-labelledby="of-label"><g:link controller="OF" action="show" id="${compteRenduInstance?.of?.id}">${compteRenduInstance?.of?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${compteRenduInstance?.kanban}">
				<li class="fieldcontain">
					<span id="kanban-label" class="property-label"><g:message code="compteRendu.kanban.label" default="Kanban" /></span>
					
						<span class="property-value" aria-labelledby="kanban-label"><g:link controller="kanban" action="show" id="${compteRenduInstance?.kanban?.id}">${compteRenduInstance?.kanban?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${compteRenduInstance?.author}">
				<li class="fieldcontain">
					<span id="author-label" class="property-label"><g:message code="compteRendu.author.label" default="Author" /></span>
					
						<span class="property-value" aria-labelledby="author-label"><g:link controller="effectif" action="show" id="${compteRenduInstance?.author?.id}">${compteRenduInstance?.author?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${compteRenduInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="compteRendu.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${compteRenduInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${compteRenduInstance?.message}">
				<li class="fieldcontain">
					<span id="message-label" class="property-label"><g:message code="compteRendu.message.label" default="Message" /></span>
					
						<span class="property-value" aria-labelledby="message-label"><g:fieldValue bean="${compteRenduInstance}" field="message"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:compteRenduInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${compteRenduInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
