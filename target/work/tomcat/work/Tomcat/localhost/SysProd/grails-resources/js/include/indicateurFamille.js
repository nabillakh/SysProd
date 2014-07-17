
        // chargement data pour PIC
        var json_client = (function() {
               var json;
               var monId = $('#monId').val();
               alert(monId);
               $.ajax({
                   type:'GET',
                   url: '/SysProd/famille/volumesClient',
                   async: false,
                   global: false,
                   data : {
                     monId : monId, 
                   },
                   success: function(data) {
                       bootbox.alert("ok");
                       json = data;
                   }, 
                       error:function(){
                       bootbox.alert("Error loading chart chargePic");
                   }
               });
               return json;
           });
           
       if ($('#volumeClients').length){
           
           var clients;
           var monId = $('#monId').val();
           var json_client =  $.ajax({
                   type:'GET',
                   url: '/SysProd/famille/volumesClient',
                   async: false,
                   global: false,
                   data : {
                     monId : monId
                   },
                   success: function(data) {
                       clients = data;
                   }, 
                           error:function(){
                       alert("Error loading chart avancement charge capa");
                   }
               });
           
               Morris.Bar({
		  element: 'volumeClients',
		  axes: true,
		  grid: false,
		  data: clients,
		  xkey: 'client',
		  ykeys: ['volume total','volume'],
		  labels: ['Total','Cloturés'],
                  
	});
        
       }
       
       if ($('#prodClients').length){
           
           var clients;
           var monId = $('#monId').val();
           var json_client =  $.ajax({
                   type:'GET',
                   url: '/SysProd/famille/prodClient',
                   async: false,
                   global: false,
                   data : {
                     monId : monId
                   },
                   success: function(data) {
                       clients = data;
                   }, 
                           error:function(){
                       alert("Error loading chart avancement charge capa");
                   }
               });
           
               Morris.Bar({
		  element: 'prodClients',
		  axes: true,
		  grid: false,
		  data: clients,
		  xkey: 'client',
		  ykeys: ['charge facturee','charge realisee'],
		  labels: ['Facturée','Réalisée'],
                  
	});
        
       }
       
       
       if ($('#productiviteFamille').length){
           
		Morris.Bar({
		  element: 'productiviteFamille',
		  data: [
		    {x: '', y: $('#chargeFacturee').val(), z: $('#chargeRealisee').val()},
		  ],
		  xkey: 'x',
		  ykeys: ['y', 'z'],
		  labels: ['Facturée', 'Réalisée']
		});
        
       }
       
       
       

            
       if ($('#projetFamille').length){
           var z = $('#projetTotal').val();
           
		Morris.Donut({
		  element: 'projetFamille',
		  data: [
		    {value: $('#projetRealise').val()/z, label: 'Réalisés : '},
		    {value: $('#projetEnCours').val()/z, label: 'En cours : '},
		  ],
		  formatter: function (x) { return parseInt(x * z) + " projets"}
		});
            }