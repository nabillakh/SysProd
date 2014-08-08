<%@ page import="application.PP.Ordonnancement" %> 
<%@ page import="application.PP.Phase" %>
<!--
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
    
<script>

  function function()
    { 
    
    $( "#dialog" ).dialog();

    });
</script> -->
 <!-- 
            <div class="control-group" size="16">
                <form name=myform1 >
                    <a href="#" onClick="function()">Popup window</a> 
                </form>
            </div> -->


<!--Javascript function partial form slide down -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
    
    <script type="text/javascript">
    function creerOrdoSlideDown()
    {
                $("#creerOrdo").slideDown("slow");
    };
     $(document).ready(function(){
            });
    
    </script>   
    
    <script type="text/javascript">
    function creerPhaseSlideDown()
    {
    
                $("#creerPhase").slideDown("slow"); 
    };
     $(document).ready(function(){
            });
    </script>
    <script type="text/javascript">
    function creerOrdoSlideUp()
    {
                $("#creerOrdo").slideUp("slow");
    };
     $(document).ready(function(){
            });
    
    </script>
    
<div class="control-group">
    <label for="nom" class="control-label" >
		<g:message code="famille.nom.label" default="Nom famille" /> : 

    </label>
    <div class="controls"  size="16" >
	<g:textField name="nom"  value="${familleInstance?.nom}" />
    </div>
</div>

<div class="control-group">
   <div class="controls">
	<g:checkBox name="travaille" value="${familleInstance?.travaille}" />
    </div>
        
    <label for="travaille" class="control-label" >
		<g:message code="famille.nom.label" default="Travaille" />
    </label>
</div>

<div class="control-group">
   <div class="controls">
	<g:checkBox name="travaille" value="${familleInstance?.operationnel}" />
    </div>
   <label for="operationnel" class="control-label" >
	<g:message code="famille.nom.label" default="Operationnel" />
    </label>
</div>

<div class="control-group">
    <label class="control-label" for="multiSelect">Ordonnancement</label>
  <div class="controls"  size="16" >
	<select id="multiSelect" name="ordonnancement" value="${familleInstance.ordo?.id}"  class="span12 with-search"/>
          <g:each in="${application.PP.Ordonnancement.list()}" status="i" var="ordoInstance">
          <option value="${ordoInstance.id}">${ordoInstance.nom}</option>
        </g:each>
        </select>
  </div>
   
  

 <div class="control-group" size="16">       
            <a href="#" style="float: right" onClick="creerOrdoSlideDown()">[+]Ajouter un nouveau ordonnancement</a> 
        
  </div>

  
 
<!-- --------------------- Ajouter le ordonnancement  --------------- -->

    <div id="creerOrdo" style="display: none;">

       

        <div class="fieldcontain ${hasErrors(bean: ordonnancementInstance, field: 'chargeStandard', 'error')} required">
            <label for="chargeStandard">
                    <g:message code="ordonnancement.chargeStandard.label" default="Charge Standard" />
                    <span class="required-indicator">*</span>
            </label>
            <g:field name="chargeStandard" value="${fieldValue(bean: ordonnancementInstance, field: 'chargeStandard')}" required=""/>

        </div>

        <div class="fieldcontain ${hasErrors(bean: ordonnancementInstance, field: 'famille', 'error')} required">
                <label for="famille">
                        <g:message code="ordonnancement.famille.label" default="Famille" />
                        <span class="required-indicator">*</span>
                </label>
                <g:select id="famille" name="famille.id" from="${application.PP.Famille.list()}" optionKey="id" required="" value="${ordonnancementInstance?.famille?.id}" class="many-to-one"/>

        </div>

        <div class="fieldcontain ${hasErrors(bean: ordonnancementInstance, field: 'nom', 'error')} ">
                <label for="nom">
                        <g:message code="ordonnancement.nom.label" default="Nom" />

                </label>
                <g:textField name="nom" value="${ordonnancementInstance?.nom}"/>

        </div>
            <fieldset class="aside-buttons">
                </br>
                <div class="btn-group">
                  <center>
                  <g:link  action="index" controller="famille"  class="btn  btn-small">Annuler</g:link> 
                  <g:submitButton  class="btn btn-primary btn-small" name="create" value="Mettre à jour" />
                  </center>
                </div>

              </fieldset>
              
                
     <div class="fieldcontain ${hasErrors(bean: ordonnancementInstance, field: 'phases', 'error')} ">
            <label for="phases">
                    <g:message code="ordonnancement.phases.label" default="Phase" />
            </label>
            
            <div class="control-group" size="16">
                <form name=myform >
                    <a href="#" style="float: right" onClick="creerPhaseSlideDown()">[+]Ajouter une nouveau Phase</a> 
                </form>
            </div> 
            
          
               
                    <ul class="one-to-many">
                <g:each in="${ordonnancementInstance?.phases?}" var="p">
                    <li><g:link controller="phase" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
                </g:each>
               <!-- <li class="add">
                <g:link controller="phase" action="create" params="['ordonnancement.id': ordonnancementInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'phase.label', default: 'Phase')])}</g:link>
                </li> -->
                </ul> 
                
        </div>
    </div>
      
  
    <!-- -----------------end ordonnacement block ------------------ -->
   


             
    <!-- -----------------Ajouter Phase block  --------------------------- -->
                  
    <div id="creerPhase" style="display: none;">        
        <div class="fieldcontain ${hasErrors(bean: phaseInstance, field: 'valeurAjoutee', 'error')} ">
            <label for="valeurAjoutee">
                    <g:message code="phase.valeurAjoutee.label" default="Valeur Ajoutee" />

            </label>
            <g:checkBox name="valeurAjoutee" value="${phaseInstance?.valeurAjoutee}" />

        </div>

        <div class="fieldcontain ${hasErrors(bean: phaseInstance, field: 'kanbans', 'error')} ">
                <label for="kanbans">
                        <g:message code="phase.kanbans.label" default="Kanbans" />
                </label>

            <ul class="one-to-many">
                <g:each in="${phaseInstance?.kanbans?}" var="k">
                    <li><g:link controller="kanban" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></li>
                </g:each>
              <!--  <li class="add">
                <g:link controller="kanban" action="create" params="['phase.id': phaseInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'kanban.label', default: 'Kanban')])}</g:link>
                </li> -->
            </ul>
        </div>

        <div class="fieldcontain ${hasErrors(bean: phaseInstance, field: 'competence', 'error')} ">
                <label for="competence">
                        <g:message code="phase.competence.label" default="Competence" />

                </label>
                <g:select id="competence" name="competence.id" from="${application.RH.Competence.list()}" optionKey="id" value="${phaseInstance?.competence?.id}" class="many-to-one" noSelection="['null': '']"/>

        </div>
        

        <div class="fieldcontain ${hasErrors(bean: phaseInstance, field: 'monOrdo', 'error')} ">
                <label for="monOrdo">
                        <g:message code="phase.monOrdo.label" default="Mon Ordo" />

                </label>
                <g:select id="monOrdo" name="monOrdo.id" from="${application.PP.Ordonnancement.list()}" optionKey="id" value="${phaseInstance?.monOrdo?.id}" class="many-to-one" noSelection="['null': '']"/>

        </div>

        <div class="fieldcontain ${hasErrors(bean: phaseInstance, field: 'cleRepartition', 'error')} required">
                <label for="cleRepartition">
                        <g:message code="phase.cleRepartition.label" default="Cle Repartition" />
                        <span class="required-indicator">*</span>
                </label>
                <g:field name="cleRepartition" value="${fieldValue(bean: phaseInstance, field: 'cleRepartition')}" required=""/>

        </div>
        
        

        <div class="fieldcontain ${hasErrors(bean: phaseInstance, field: 'nom', 'error')} ">
                <label for="nom">
                        <g:message code="phase.nom.label" default="Nom" />

                </label>
                <g:textField name="nom" value="${phaseInstance?.nom}"/>

        </div>

        <div class="fieldcontain ${hasErrors(bean: phaseInstance, field: 'ordre', 'error')}required">
                <label for="ordre">
                        <g:message code="phase.ordre.label" default="Ordre" />
                        <span class="required-indicator">*</span>
                </label>
                <g:field name="ordre" type="number" value="${phaseInstance?.ordre}" required=""/>

        </div>
        
        <fieldset class="aside-buttons">
            </br>
            <div class="btn-group">
              <center>
              <g:link  action="index" controller="famille"  class="btn  btn-small">Annuler</g:link> 
              <g:submitButton  class="btn btn-primary btn-small" name="create" value="Mettre à jour Phase" />
              </center>
            </div>

        </fieldset> 

            
     </div>   
               
    <!-- -------------------end phase block---------------------------------------- -->
</div>