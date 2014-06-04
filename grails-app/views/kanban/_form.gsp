
<input type="hidden"  name="monId"  value="${kanbanInstance?.id}">
<div class="control-group">
	<label for="nomKanban" class="control-label" >
		<g:message code="kanban.nomKanban.label" default="Nom du projet" />

	</label>
  <div class="controls"  size="16" >
	<g:textField name="nomKanban"  class="span12" value="${kanbanInstance?.nomKanban}" />

</div>
</div>


<div class="control-group">
	<label for="description" class="control-label" >
		<g:message code="kanban.description.label" default="Description" />

	</label>
  <div class="controls"  size="16" >
	<g:textField name="description" class="span12" value="${kanbanInstance?.description}" />

</div>
</div>


<div class="control-group">
  <label class="control-label" for="multiSelect">Chef de projet</label>
  <div class="controls"  size="16" >
	<select id="multiSelect" name="chefProjet" value="${kanbanInstance.chefProjet?.id}" required="" class="span12 with-search"/>
          <option value="${kanbanInstance.chefProjet?.id}">${kanbanInstance.chefProjet?.nom} ${kanbanInstance.chefProjet?.prenom}</option>
        <g:each in="${application.RH.Effectif.list()}" status="i" var="ordoInstance">
          <option value="${ordoInstance.id}">${ordoInstance.nom} ${ordoInstance.prenom}</option>
        </g:each>
        </select>
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="multiSelect">Famille de projet</label>
  <div class="controls"  size="16" >
	<select id="multiSelect" name="famille" value="${kanbanInstance.famille?.id}" required="" class="span12 with-search">
          <option value="${kanbanInstance.famille?.id}" selected>${kanbanInstance.famille?.nom}</option>
        <g:each in="${application.PP.Famille.list()}" status="i" var="familleInstance">
          <option value="${familleInstance.id}">${familleInstance.nom}</option>
        </g:each>
        </select>
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="multiSelect">sous famille</label>
  <div class="controls"  size="16" >
	<select id="multiSelect" name="ordo" value="${kanbanInstance.ordo?.id}" required="" class="span12 with-search"/>
          <option value="${kanbanInstance.ordo?.id}">${kanbanInstance.ordo?.nom}</option>
        <g:each in="${application.PP.Ordonnancement.list()}" status="i" var="ordoInstance">
          <option value="${ordoInstance.id}">${ordoInstance.nom}</option>
        </g:each>
        </select>
  </div>
</div>

<div class="control-group">
  <label class="control-label">Date de lancement</label>

  <div class="controls" size="16" >
    <div class="input-append date" id="datepicker-js" data-date="${dateDeb}" data-date-format="dd/mm/yyyy">
      <input class="datepicker-input" size="16" type="text"  value="${dateDeb}" name="dateLancement" 
              placeholder="Select a date" />
      <span class="add-on"><i class="cus-calendar-2"></i></span>
    </div>
  </div>
</div>


<div class="control-group">
  <label class="control-label">Date de livraison prévisionnelle</label>

  <div class="controls" size="16" >
    <div class="input-append date" id="datepicker-js" data-date="${dateFin}" data-date-format="dd/mm/yyyy">
      <input class="datepicker-input" size="16" type="text"  value="${dateFin}" name="dateLivraison" 
              placeholder="Select a date" />
      <span class="add-on"><i class="cus-calendar-2"></i></span>
    </div>
  </div>
</div>

<div class="control-group">
	<label for="charge" class="control-label" >
		<g:message code="kanban.charge.label" default="Charge" />

	</label>
  <div class="controls"  size="16" >
	<g:field name="chargePlanifiee"  value="${kanbanInstance.chargePlanifiee}"  class="span12"  />

</div>
</div>
