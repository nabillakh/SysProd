
<%@ page import="application.pilotage.PdpKanbanEvent" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pdpKanbanEvent.label', default: 'PdpKanbanEvent')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-pdpKanbanEvent" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-pdpKanbanEvent" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="pdpKanbanEvent.kanban.label" default="Kanban" /></th>
					
						<g:sortableColumn property="kanbanReel" title="${message(code: 'pdpKanbanEvent.kanbanReel.label', default: 'Kanban Reel')}" />
					
						<th><g:message code="pdpKanbanEvent.pdp.label" default="Pdp" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${pdpKanbanEventInstanceList}" status="i" var="pdpKanbanEventInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${pdpKanbanEventInstance.id}">${fieldValue(bean: pdpKanbanEventInstance, field: "kanban")}</g:link></td>
					
						<td><g:formatBoolean boolean="${pdpKanbanEventInstance.kanbanReel}" /></td>
					
						<td>${fieldValue(bean: pdpKanbanEventInstance, field: "pdp")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${pdpKanbanEventInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
