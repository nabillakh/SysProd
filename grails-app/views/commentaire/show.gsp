
<%@ page import="application.communication.Commentaire" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'commentaire.label', default: 'Commentaire')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-commentaire" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-commentaire" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list commentaire">
			
				<g:if test="${commentaireInstance?.auteur}">
				<li class="fieldcontain">
					<span id="auteur-label" class="property-label"><g:message code="commentaire.auteur.label" default="Auteur" /></span>
					
						<span class="property-value" aria-labelledby="auteur-label"><g:link controller="effectif" action="show" id="${commentaireInstance?.auteur?.id}">${commentaireInstance?.auteur?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${commentaireInstance?.date}">
				<li class="fieldcontain">
					<span id="date-label" class="property-label"><g:message code="commentaire.date.label" default="Date" /></span>
					
						<span class="property-value" aria-labelledby="date-label"><g:formatDate date="${commentaireInstance?.date}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${commentaireInstance?.message}">
				<li class="fieldcontain">
					<span id="message-label" class="property-label"><g:message code="commentaire.message.label" default="Message" /></span>
					
						<span class="property-value" aria-labelledby="message-label"><g:link controller="message" action="show" id="${commentaireInstance?.message?.id}">${commentaireInstance?.message?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${commentaireInstance?.texte}">
				<li class="fieldcontain">
					<span id="texte-label" class="property-label"><g:message code="commentaire.texte.label" default="Texte" /></span>
					
						<span class="property-value" aria-labelledby="texte-label"><g:fieldValue bean="${commentaireInstance}" field="texte"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:commentaireInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${commentaireInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
