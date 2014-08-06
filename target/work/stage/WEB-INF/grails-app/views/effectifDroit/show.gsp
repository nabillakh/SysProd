
<%@ page import="application.RH.EffectifDroit" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'effectifDroit.label', default: 'EffectifDroit')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-effectifDroit" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-effectifDroit" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list effectifDroit">
			
				<g:if test="${effectifDroitInstance?.droit}">
				<li class="fieldcontain">
					<span id="droit-label" class="property-label"><g:message code="effectifDroit.droit.label" default="Droit" /></span>
					
						<span class="property-value" aria-labelledby="droit-label"><g:link controller="droit" action="show" id="${effectifDroitInstance?.droit?.id}">${effectifDroitInstance?.droit?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${effectifDroitInstance?.effectif}">
				<li class="fieldcontain">
					<span id="effectif-label" class="property-label"><g:message code="effectifDroit.effectif.label" default="Effectif" /></span>
					
						<span class="property-value" aria-labelledby="effectif-label"><g:link controller="effectif" action="show" id="${effectifDroitInstance?.effectif?.id}">${effectifDroitInstance?.effectif?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:effectifDroitInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${effectifDroitInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
