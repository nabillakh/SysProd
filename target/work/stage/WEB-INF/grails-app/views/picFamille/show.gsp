
<%@ page import="application.pilotage.PicFamille" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'picFamille.label', default: 'PicFamille')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-picFamille" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-picFamille" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list picFamille">
			
				<g:if test="${picFamilleInstance?.dateVersion}">
				<li class="fieldcontain">
					<span id="dateVersion-label" class="property-label"><g:message code="picFamille.dateVersion.label" default="Date Version" /></span>
					
						<span class="property-value" aria-labelledby="dateVersion-label"><g:formatDate date="${picFamilleInstance?.dateVersion}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${picFamilleInstance?.dateMaj}">
				<li class="fieldcontain">
					<span id="dateMaj-label" class="property-label"><g:message code="picFamille.dateMaj.label" default="Date Maj" /></span>
					
						<span class="property-value" aria-labelledby="dateMaj-label"><g:formatDate date="${picFamilleInstance?.dateMaj}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${picFamilleInstance?.ordo}">
				<li class="fieldcontain">
					<span id="ordo-label" class="property-label"><g:message code="picFamille.ordo.label" default="Ordo" /></span>
					
						<span class="property-value" aria-labelledby="ordo-label"><g:link controller="ordonnancement" action="show" id="${picFamilleInstance?.ordo?.id}">${picFamilleInstance?.ordo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${picFamilleInstance?.pdp}">
				<li class="fieldcontain">
					<span id="pdp-label" class="property-label"><g:message code="picFamille.pdp.label" default="Pdp" /></span>
					
						<g:each in="${picFamilleInstance.pdp}" var="p">
						<span class="property-value" aria-labelledby="pdp-label"><g:link controller="pdp" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${picFamilleInstance?.uniteActivite}">
				<li class="fieldcontain">
					<span id="uniteActivite-label" class="property-label"><g:message code="picFamille.uniteActivite.label" default="Unite Activite" /></span>
					
						<span class="property-value" aria-labelledby="uniteActivite-label"><g:fieldValue bean="${picFamilleInstance}" field="uniteActivite"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:picFamilleInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${picFamilleInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
