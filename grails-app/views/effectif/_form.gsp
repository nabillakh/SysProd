<%@ page import="application.RH.Effectif" %>



<div class="fieldcontain ${hasErrors(bean: effectifInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="effectif.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${effectifInstance?.username}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: effectifInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="effectif.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${effectifInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: effectifInstance, field: 'mailEffectif', 'error')} ">
	<label for="mailEffectif">
		<g:message code="effectif.mailEffectif.label" default="Mail Effectif" />
		
	</label>
	<g:field type="email" name="mailEffectif" value="${effectifInstance?.mailEffectif}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: effectifInstance, field: 'nom', 'error')} ">
	<label for="nom">
		<g:message code="effectif.nom.label" default="Nom" />
		
	</label>
	<g:textField name="nom" value="${effectifInstance?.nom}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: effectifInstance, field: 'prenom', 'error')} ">
	<label for="prenom">
		<g:message code="effectif.prenom.label" default="Prenom" />
		
	</label>
	<g:textField name="prenom" value="${effectifInstance?.prenom}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: effectifInstance, field: 'equipe', 'error')} ">
	<label for="equipe">
		<g:message code="effectif.equipe.label" default="Equipe" />
		
	</label>
	<g:select id="equipe" name="equipe.id" from="${application.RH.Equipe.list()}" optionKey="id" value="${effectifInstance?.equipe?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: effectifInstance, field: 'accountExpired', 'error')} ">
	<label for="accountExpired">
		<g:message code="effectif.accountExpired.label" default="Account Expired" />
		
	</label>
	<g:checkBox name="accountExpired" value="${effectifInstance?.accountExpired}" />

</div>

<div class="fieldcontain ${hasErrors(bean: effectifInstance, field: 'accountLocked', 'error')} ">
	<label for="accountLocked">
		<g:message code="effectif.accountLocked.label" default="Account Locked" />
		
	</label>
	<g:checkBox name="accountLocked" value="${effectifInstance?.accountLocked}" />

</div>

<div class="fieldcontain ${hasErrors(bean: effectifInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="effectif.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" value="${effectifInstance?.enabled}" />

</div>

<div class="fieldcontain ${hasErrors(bean: effectifInstance, field: 'passwordExpired', 'error')} ">
	<label for="passwordExpired">
		<g:message code="effectif.passwordExpired.label" default="Password Expired" />
		
	</label>
	<g:checkBox name="passwordExpired" value="${effectifInstance?.passwordExpired}" />

</div>

