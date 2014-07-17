
<%@ page import="application.RH.CompetenceEffectif" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'competenceEffectif.label', default: 'CompetenceEffectif')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-competenceEffectif" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-competenceEffectif" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list competenceEffectif">
			
				<g:if test="${competenceEffectifInstance?.competence}">
				<li class="fieldcontain">
					<span id="competence-label" class="property-label"><g:message code="competenceEffectif.competence.label" default="Competence" /></span>
					
						<span class="property-value" aria-labelledby="competence-label"><g:link controller="competence" action="show" id="${competenceEffectifInstance?.competence?.id}">${competenceEffectifInstance?.competence?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${competenceEffectifInstance?.effectif}">
				<li class="fieldcontain">
					<span id="effectif-label" class="property-label"><g:message code="competenceEffectif.effectif.label" default="Effectif" /></span>
					
						<span class="property-value" aria-labelledby="effectif-label"><g:link controller="effectif" action="show" id="${competenceEffectifInstance?.effectif?.id}">${competenceEffectifInstance?.effectif?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:competenceEffectifInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${competenceEffectifInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
