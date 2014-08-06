<%@ page import="application.RH.Droit" %>



<div class="fieldcontain ${hasErrors(bean: droitInstance, field: 'authority', 'error')} required">
	<label for="authority">
		<g:message code="droit.authority.label" default="Authority" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="authority" required="" value="${droitInstance?.authority}"/>

</div>

