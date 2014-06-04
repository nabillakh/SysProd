
<%@ page import="application.RH.EffectifDroit" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'effectifDroit.label', default: 'EffectifDroit')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-effectifDroit" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-effectifDroit" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="effectifDroit.droit.label" default="Droit" /></th>
					
						<th><g:message code="effectifDroit.effectif.label" default="Effectif" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${effectifDroitInstanceList}" status="i" var="effectifDroitInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${effectifDroitInstance.id}">${fieldValue(bean: effectifDroitInstance, field: "droit")}</g:link></td>
					
						<td>${fieldValue(bean: effectifDroitInstance, field: "effectif")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${effectifDroitInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
