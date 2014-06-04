
<%@ page import="application.communication.EventEffectif" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'eventEffectif.label', default: 'EventEffectif')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-eventEffectif" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-eventEffectif" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="dateCreation" title="${message(code: 'eventEffectif.dateCreation.label', default: 'Date Creation')}" />
					
						<th><g:message code="eventEffectif.event.label" default="Event" /></th>
					
						<g:sortableColumn property="participe" title="${message(code: 'eventEffectif.participe.label', default: 'Participe')}" />
					
						<th><g:message code="eventEffectif.recepteur.label" default="Recepteur" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${eventEffectifInstanceList}" status="i" var="eventEffectifInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${eventEffectifInstance.id}">${fieldValue(bean: eventEffectifInstance, field: "dateCreation")}</g:link></td>
					
						<td>${fieldValue(bean: eventEffectifInstance, field: "event")}</td>
					
						<td><g:formatBoolean boolean="${eventEffectifInstance.participe}" /></td>
					
						<td>${fieldValue(bean: eventEffectifInstance, field: "recepteur")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${eventEffectifInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
