
<div class="control-group">
	<label for="nom" class="control-label" >
		<g:message code="famille.nom.label" default="Nom famille" /> : 

	</label>
  <div class="controls"  size="16" >
	<g:textField name="nom"  value="${familleInstance?.nom}" />

</div>
</div>
<div class="control-group">
  <label for="travaille" class="control-label" >
		<g:message code="famille.nom.label" default="travaille" />

</label>
  <div class="controls">
	<g:checkBox name="travaille" value="${familleInstance?.travaille}" />

</div>
</div>
<div class="control-group">
   <label for="operationnel" class="control-label" >
		<g:message code="famille.nom.label" default="operationnel" />

</label>
   <div class="controls">
	<g:checkBox name="travaille" value="${familleInstance?.operationnel}" />

</div>
</div>



<div class="control-group">
  <label class="control-label" for="multiSelect">Ordonnancement</label>
  <div class="controls"  size="16" >
	<select id="multiSelect" name="ordonnancement" value="${familleInstance.ordo?.id}" required="" class="span12 with-search"/>
          <g:each in="${application.PP.Ordonnancement.list()}" status="i" var="ordoInstance">
          <option value="${ordoInstance.id}">${ordoInstance.nom}</option>
        </g:each>
        </select>
  </div>
  <div id="nouveauOrdo">
  </div>
  
  <a href="#" onClick ="creerOrdo();">Ajouter un ordonnancement</a>



</div>
    

