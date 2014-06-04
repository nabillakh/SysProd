

<div class="row-fluid">
  <article class="span3">
    
<div class="fieldcontain ${hasErrors(bean: OFInstance, field: 'phase', 'error')} required">
	<label for="phase">
		Phase  : ${OFInstance?.phase?.nom}
	</label>
</div>
  </article>
<article class="span6">
<div class="fieldcontain ${hasErrors(bean: OFInstance, field: 'chargePlanifiee', 'error')} ">
	<label for="chargePlanifiee">
		<g:message code="OF.chargePlanifiee.label" default="Charge Planifiee" />
		
	</label>
	<g:field name="chargePlanifiee" value="${fieldValue(bean: OFInstance, field: 'chargePlanifiee')}"/>

</div>

<div class="control-group">
	<label for="affectes">
		<g:message code="OF.affectes.label" default="Affectes" />
		
        </label><div class="controls"  size="16" >
	
	<g:select id="multiSelect" name="chefProjet" from="${application.RH.Effectif.list()}" optionKey="id" required="" class="span12 with-search"/>
        <g:select id="multiSelect" name="affectes" from="${application.RH.Effectif.list()}" optionKey="id" required="" value="${OFInstance?.affectes*.id}" class="span12 with-search"/>
</div>
</div>
  
  
  
  
</article>
<article class="span3">
<div>
  <label class="control-label">Date de lancement <span class="required-indicator">*</span></label>

  
  <div class="controls" size="16" >
    <div>
      <g:field type="date" name="dateDebutPlanifie" 
              default="${new Date()}" precision="day"  />
    </div>
  </div>
</div>


<div>
  <label class="control-label">Date de fin planifiée <span class="required-indicator">*</span></label>

  
  <div class="controls" size="16" >
    <div>
      <g:field type="date" name="dateFinPlanifie" 
              default="${new Date()}" precision="day"  />
    </div>
  </div>
</div>
</article></div>