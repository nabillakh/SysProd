
<%@ page import="application.pilotage.PicFamille" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'picFamille.label', default: 'PicFamille')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-picFamille" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-picFamille" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="dateVersion" title="${message(code: 'picFamille.dateVersion.label', default: 'Date Version')}" />
					
						<g:sortableColumn property="dateMaj" title="${message(code: 'picFamille.dateMaj.label', default: 'Date Maj')}" />
					
						<th><g:message code="picFamille.ordo.label" default="Ordo" /></th>
					
						<g:sortableColumn property="uniteActivite" title="${message(code: 'picFamille.uniteActivite.label', default: 'Unite Activite')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${picFamilleInstanceList}" status="i" var="picFamilleInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${picFamilleInstance.id}">${fieldValue(bean: picFamilleInstance, field: "dateVersion")}</g:link></td>
					
						<td><g:formatDate date="${picFamilleInstance.dateMaj}" /></td>
					
						<td>${fieldValue(bean: picFamilleInstance, field: "ordo")}</td>
					
						<td>${fieldValue(bean: picFamilleInstance, field: "uniteActivite")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${picFamilleInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
