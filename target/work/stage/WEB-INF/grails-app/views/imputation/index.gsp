
<%@ page import="application.PP.Imputation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'imputation.label', default: 'Imputation')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-imputation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-imputation" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="imputation.event.label" default="Event" /></th>
					
						<th><g:message code="imputation.of.label" default="Of" /></th>
						<th>charge</th>
					
						<g:sortableColumn property="realise" title="${message(code: 'imputation.realise.label', default: 'Realise')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${imputationInstanceList}" status="i" var="imputationInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${imputationInstance.id}">${fieldValue(bean: imputationInstance, field: "eventEffectif")}</g:link></td>
					
						<td>${fieldValue(bean: imputationInstance, field: "of")}</td>
                                                <td>${fieldValue(bean: imputationInstance, field: "tempsImpute")}</td>
					
						<td><g:formatBoolean boolean="${imputationInstance.realise}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${imputationInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
