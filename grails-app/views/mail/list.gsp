
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'Mail.label', default: 'Mail')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-Mail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-Mail" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="author" title="${message(code: 'Mail.author.label', default: 'author')}" />
					
						<g:sortableColumn property="message" title="${message(code: 'Mail.message.label', default: 'message')}" />
					
											
						<g:sortableColumn property="recepteur" title="${message(code: 'Mail.recepteur.label', default: 'recepteur')}" />
					
						<g:sortableColumn property="Lu" title="${message(code: 'Mail.Lu.label', default: 'Lu')}" />
                                                <g:sortableColumn property="dateCreated" title="${message(code: 'Mail.Lu.label', default: 'dateCreated')}" />
					       
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${MailInstanceList}" status="i" var="MailInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${MailInstance.id}">
                                                    ${fieldValue(bean: MailInstance, field: "author")}</g:link></td>
					
						<td>${fieldValue(bean: MailInstance, field: "message")}</td>
                                                <td>${fieldValue(bean: MailInstance, field: "recepteur")}</td>
					
						
					
						<td><g:formatBoolean boolean="${MailInstance.Lu}" /></td>
					
						 <td>${fieldValue(bean: MailInstance, field: "dateCreated")}</td>
					
						
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${MailInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
