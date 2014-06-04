
<%@ page import="application.PP.Ordonnancement" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ordonnancement.label', default: 'Ordonnancement')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-ordonnancement" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-ordonnancement" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="ordonnancement.famille.label" default="Famille" /></th>
					
						<g:sortableColumn property="chargeStandard" title="${message(code: 'ordonnancement.chargeStandard.label', default: 'Charge Standard')}" />
					
						<g:sortableColumn property="nom" title="${message(code: 'ordonnancement.nom.label', default: 'Nom')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${ordonnancementInstanceList}" status="i" var="ordonnancementInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${ordonnancementInstance.id}">${fieldValue(bean: ordonnancementInstance, field: "famille")}</g:link></td>
					
						<td>${fieldValue(bean: ordonnancementInstance, field: "chargeStandard")}</td>
					
						<td>${fieldValue(bean: ordonnancementInstance, field: "nom")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${ordonnancementInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
