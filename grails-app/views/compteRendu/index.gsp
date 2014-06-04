
<%@ page import="application.PP.CompteRendu" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'compteRendu.label', default: 'CompteRendu')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-compteRendu" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-compteRendu" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="compteRendu.of.label" default="Of" /></th>
					
						<th><g:message code="compteRendu.kanban.label" default="Kanban" /></th>
					
						<th><g:message code="compteRendu.author.label" default="Author" /></th>
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'compteRendu.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="message" title="${message(code: 'compteRendu.message.label', default: 'Message')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${compteRenduInstanceList}" status="i" var="compteRenduInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${compteRenduInstance.id}">${fieldValue(bean: compteRenduInstance, field: "of")}</g:link></td>
					
						<td>${fieldValue(bean: compteRenduInstance, field: "kanban")}</td>
					
						<td>${fieldValue(bean: compteRenduInstance, field: "author")}</td>
					
						<td><g:formatDate date="${compteRenduInstance.dateCreated}" /></td>
					
						<td>${fieldValue(bean: compteRenduInstance, field: "message")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${compteRenduInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
