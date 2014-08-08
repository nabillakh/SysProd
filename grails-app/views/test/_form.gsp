<%@ page import="application.PP.Test" %>



<div class="fieldcontain ${hasErrors(bean: testInstance, field: 'nom', 'error')} ">
	<label for="nom">
		<g:message code="test.nom.label" default="Nom" />
		
	</label>
	<g:textField name="nom" value="${testInstance?.nom}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: testInstance, field: 'test', 'error')} ">
	<label for="test">
		<g:message code="test.test.label" default="Test" />
		
	</label>
	<g:checkBox name="test" value="${testInstance?.test}" />

</div>

