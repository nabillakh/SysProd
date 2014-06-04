
<%@ page import="application.pilotage.Pic" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pic.label', default: 'Pic')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-pic" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-pic" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list pic">
			
				<g:if test="${picInstance?.dateVersion}">
				<li class="fieldcontain">
					<span id="dateVersion-label" class="property-label"><g:message code="pic.dateVersion.label" default="Date Version" /></span>
					
						<span class="property-value" aria-labelledby="dateVersion-label"><g:formatDate date="${picInstance?.dateVersion}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${picInstance?.dateMaj}">
				<li class="fieldcontain">
					<span id="dateMaj-label" class="property-label"><g:message code="pic.dateMaj.label" default="Date Maj" /></span>
					
						<span class="property-value" aria-labelledby="dateMaj-label"><g:formatDate date="${picInstance?.dateMaj}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${picInstance?.annee}">
				<li class="fieldcontain">
					<span id="annee-label" class="property-label"><g:message code="pic.annee.label" default="Annee" /></span>
					
						<span class="property-value" aria-labelledby="annee-label"><g:fieldValue bean="${picInstance}" field="annee"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${picInstance?.picFamille}">
				<li class="fieldcontain">
					<span id="picFamille-label" class="property-label"><g:message code="pic.picFamille.label" default="Pic Famille" /></span>
					
						<g:each in="${picInstance.picFamille}" var="p">
						<span class="property-value" aria-labelledby="picFamille-label"><g:link controller="picFamille" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:picInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${picInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
