var json_ordo = (function() {
    
               var json;
               // var monId = $('#monId').val();
               // alert(monId);
               $.ajax({
                   type:'GET',
                   url: '/SysProd/famille/gantFamille',
                   async: false,
                   global: false,
                   data : {
                    // monId : monId, 
                   },
                   success: function(data) {
                      // alert("ajax ok");
                       json = data;
                   }, 
                       error:function(){
                       alert("Error loading chart chargePic");
                   }
               });
               return json;
           });
           
           
           
function recupOrdo() {
  // alert("ok dans recupOrdo");
  // var data = jQuery.parseJSON(json_ordo())
  var monJson = JSON.stringify(json_ordo())
  $('#at').val(monJson)
  
  
}



function saveGantt() {   
           if (confirm("confirmez-vous ?")) {
          
                    $.ajax({
                        url: '/SysProd/famille/saveGantt',
                        type: 'POST',
                        format: 'json',
                        data: {
                            json : $("#ta").val(),
                        },
                        error: function () {
                            
                        },
                            });}
                   

    }