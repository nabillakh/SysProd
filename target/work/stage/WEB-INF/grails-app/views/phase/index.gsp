
<%@ page import="application.PP.Phase" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'phase.label', default: 'Phase')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-phase" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-phase" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="valeurAjoutee" title="${message(code: 'phase.valeurAjoutee.label', default: 'Valeur Ajoutee')}" />
					
						<th><g:message code="phase.competence.label" default="Competence" /></th>
					
						<th><g:message code="phase.monOrdo.label" default="Mon Ordo" /></th>
					
						<g:sortableColumn property="cleRepartition" title="${message(code: 'phase.cleRepartition.label', default: 'Cle Repartition')}" />
					
						<g:sortableColumn property="nom" title="${message(code: 'phase.nom.label', default: 'Nom')}" />
					
						<g:sortableColumn property="ordre" title="${message(code: 'phase.ordre.label', default: 'Ordre')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${phaseInstanceList}" status="i" var="phaseInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${phaseInstance.id}">${fieldValue(bean: phaseInstance, field: "valeurAjoutee")}</g:link></td>
					
						<td>${fieldValue(bean: phaseInstance, field: "competence")}</td>
					
						<td>${fieldValue(bean: phaseInstance, field: "monOrdo")}</td>
					
						<td>${fieldValue(bean: phaseInstance, field: "cleRepartition")}</td>
					
						<td>${fieldValue(bean: phaseInstance, field: "nom")}</td>
					
						<td>${fieldValue(bean: phaseInstance, field: "ordre")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${phaseInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
