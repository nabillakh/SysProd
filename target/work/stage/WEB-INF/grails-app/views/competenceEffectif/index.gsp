
<%@ page import="application.RH.CompetenceEffectif" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'competenceEffectif.label', default: 'CompetenceEffectif')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-competenceEffectif" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-competenceEffectif" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="competenceEffectif.competence.label" default="Competence" /></th>
					
						<th><g:message code="competenceEffectif.effectif.label" default="Effectif" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${competenceEffectifInstanceList}" status="i" var="competenceEffectifInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${competenceEffectifInstance.id}">${fieldValue(bean: competenceEffectifInstance, field: "competence")}</g:link></td>
					
						<td>${fieldValue(bean: competenceEffectifInstance, field: "effectif")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${competenceEffectifInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
