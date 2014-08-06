<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mail.label', default: 'Mail')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-mail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-mail" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list mail">
			
				<g:if test="${mailEffectifInstance.mail?.author}">
				<li class="fieldcontain">
					<span id="author-label" class="property-label"><g:message code="maileffectif.mail.author.label" default="Author" /></span>
					
						<span class="property-value" aria-labelledby="author-label"><g:link controller="effectif" action="show" id="${mailEffectifInstance.mail?.author?.id}">${mailEffectifInstance.mail?.author?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${mailEffectifInstance?.mail.objet}">
				<li class="fieldcontain">
					<span id="objet-label" class="property-label"><g:message code=".mailEffectif.mail.objet" default="objet" /></span>
					
						<span class="property-value" aria-labelledby="objet-label"><g:formatDate date="${mailEffectifInstance.mail?.objet}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${mailEffectifInstance?.lu}">
				<li class="fieldcontain">
					<span id="lu-label" class="property-label"><g:message code="mailEffectif.lu.label" default="Lu" /></span>
					
						<span class="property-value" aria-labelledby="lu-label"><g:formatBoolean boolean="${mailEffectifInstance?.lu}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${mailEffectifInstance.mail?.message}">
				<li class="fieldcontain">
					<span id="message-label" class="property-label"><g:message code="mailEffectif.mail.message.label" default="Message" /></span>
					
						<span class="property-value" aria-labelledby="message-label"><g:fieldValue bean="${mailEffectifInstance}" field="message"/></span>
					
				</li>
				</g:if>
			
				
			
			</ol>
			<g:form url="[resource:mailInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${mailInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
