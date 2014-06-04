<%@ page import="application.pilotage.PdpKanbanEvent" %>



<div class="fieldcontain ${hasErrors(bean: pdpKanbanEventInstance, field: 'imputations', 'error')} ">
	<label for="imputations">
		<g:message code="pdpKanbanEvent.imputations.label" default="Imputations" />
		
	</label>
	<g:select name="imputations" from="${application.communication.Event.list()}" multiple="multiple" optionKey="id" size="5" value="${pdpKanbanEventInstance?.imputations*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pdpKanbanEventInstance, field: 'kanban', 'error')} required">
	<label for="kanban">
		<g:message code="pdpKanbanEvent.kanban.label" default="Kanban" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="kanban" name="kanban.id" from="${application.PP.Kanban.list()}" optionKey="id" required="" value="${pdpKanbanEventInstance?.kanban?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pdpKanbanEventInstance, field: 'kanbanReel', 'error')} ">
	<label for="kanbanReel">
		<g:message code="pdpKanbanEvent.kanbanReel.label" default="Kanban Reel" />
		
	</label>
	<g:checkBox name="kanbanReel" value="${pdpKanbanEventInstance?.kanbanReel}" />

</div>

<div class="fieldcontain ${hasErrors(bean: pdpKanbanEventInstance, field: 'pdp', 'error')} required">
	<label for="pdp">
		<g:message code="pdpKanbanEvent.pdp.label" default="Pdp" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="pdp" name="pdp.id" from="${application.pilotage.Pdp.list()}" optionKey="id" required="" value="${pdpKanbanEventInstance?.pdp?.id}" class="many-to-one"/>

</div>

