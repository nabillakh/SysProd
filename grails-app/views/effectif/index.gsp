
<%@ page import="application.RH.Effectif" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'effectif.label', default: 'Effectif')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-effectif" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-effectif" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="username" title="${message(code: 'effectif.username.label', default: 'Username')}" />
					
						<g:sortableColumn property="password" title="${message(code: 'effectif.password.label', default: 'Password')}" />
					
						<g:sortableColumn property="mailEffectif" title="${message(code: 'effectif.mailEffectif.label', default: 'Mail Effectif')}" />
					
						<g:sortableColumn property="nom" title="${message(code: 'effectif.nom.label', default: 'Nom')}" />
					
						<g:sortableColumn property="prenom" title="${message(code: 'effectif.prenom.label', default: 'Prenom')}" />
					
						<th><g:message code="effectif.equipe.label" default="Equipe" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${effectifInstanceList}" status="i" var="effectifInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${effectifInstance.id}">${fieldValue(bean: effectifInstance, field: "username")}</g:link></td>
					
						<td>${fieldValue(bean: effectifInstance, field: "password")}</td>
					
						<td>${fieldValue(bean: effectifInstance, field: "mailEffectif")}</td>
					
						<td>${fieldValue(bean: effectifInstance, field: "nom")}</td>
					
						<td>${fieldValue(bean: effectifInstance, field: "prenom")}</td>
					
						<td>${fieldValue(bean: effectifInstance, field: "equipe")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${effectifInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
