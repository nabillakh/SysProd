
<%@ page import="application.communication.MailEffectif" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mailEffectif.label', default: 'MailEffectif')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-mailEffectif" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-mailEffectif" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="lu" title="${message(code: 'mailEffectif.lu.label', default: 'Lu')}" />
					
						<th><g:message code="mailEffectif.mail.label" default="Mail" /></th>
					
						<th><g:message code="mailEffectif.recepteur.label" default="Recepteur" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${mailEffectifInstanceList}" status="i" var="mailEffectifInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${mailEffectifInstance.id}">${fieldValue(bean: mailEffectifInstance, field: "lu")}</g:link></td>
					
						<td>${fieldValue(bean: mailEffectifInstance, field: "mail")}</td>
					
						<td>${fieldValue(bean: mailEffectifInstance, field: "recepteur")}</td>
                                                <td>${fieldValue(bean: mailEffectifInstance, field: "archive")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${mailEffectifInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
