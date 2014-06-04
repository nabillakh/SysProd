<%@ page import="application.communication.Event" %>


<div class="control-group">
	<label for="nomKanban" class="control-label" >
		<g:message code="Event.TitleKanban.label" default="Titre : " />
		
	</label>
	<g:textField name="title" value="${eventInstance?.title}"  class="span12"  />

</div>
<div class="control-group">
	<label for="description" class="control-label" >
		<g:message code="Event.location.label" default="Lieu : " />
		
	</label>
	<g:textField name="location" value="${eventInstance?.location}" class="span12"  />

</div>

<div class="control-group">
	<label for="description" class="control-label" >
		<g:message code="Event.description.label" default="Description : " />
		
	</label>
	<g:textField name="description" value="${eventInstance?.description}" class="span12"  />

</div>






<div class="control-group">
  <label class="control-label">Date de lancement : </label>

  
  <div class="controls" size="16" >
    <div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'startTime', 'error')}">
    <label for="startTime"><g:message code="event.startTime.label" default="Start Time" /></label>
    <g:datePicker name="startTime" precision="day"  value="${eventInstance?.startTime}"  />
</div>
    
     <p class="help-block">
      
    </p>
  </div>
</div>


<div class="control-group">
  <label class="control-label">Date de fin  : </label>

  
  <div class="controls" size="16" >
   <div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'endTime', 'error')}">
    <label for="endTime"><g:message code="event.startTime.label" default="End Time" /></label>
    <g:datePicker name="endTime" precision="day"  value="${eventInstance?.endTime}"  />
</div>
     <p class="help-block">
    
    </p>
  </div>
</div>



