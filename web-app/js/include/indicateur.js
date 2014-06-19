
        // chargement data pour PIC
        var json_data = (function() {
               var json;
               $.ajax({
                   type:'GET',
                   url: '/SysProd/activite/chargePIC',
                   async: false,
                   global: false,
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
           
           
           
        var absPIC = (function() {
               var json;
               $.ajax({
                   type:'GET',
                   url: '/SysProd/activite/listeFamille',
                   async: false,
                   global: false,
                   success: function(data) {
                       bootbox.alert("ok");
                       json = data;
                   }, 
                           error:function(){
                       bootbox.alert("Error loading chart liste des familles");
                   }
               });
               return json;
           });
        
        
        // charge issue du pic
        
       if ($('#chargePIC').length){
           $.getJSON( "/SysProd/activite/chargePIC", function( data ) {
               $.getJSON( "/SysProd/activite/listeFamille", function( fam ) {
               Morris.Bar({
		  element: 'chargePIC',
		  axes: false,
		  grid: false,
		  data: data,
		  xkey: 'famille',
		  ykeys: fam,
		  labels: fam,
		  stacked: true
		});
	});
	});
        
       }
       
       
         // chargement data pour PIC
        var ordoOF = (function() {
               var json;
               $.ajax({
                   type:'GET',
                   url: '/SysProd/kanban/chargeOF',
                   async: false,
                   global: false,
                   success: function(data) {
                       bootbox.alert("ok");
                       json = data;
                   }, 
                       error:function(){
                       bootbox.alert("Error loading chart charge par OF");
                   }
               });
               return json;
           });
           
        var absOF = (function() {
               var json;
               $.ajax({
                   type:'GET',
                   url: '/SysProd/kanban/listeOF',
                   async: false,
                   global: false,
                   success: function(data) {
                       bootbox.alert("ok");
                       json = data;
                   }, 
                           error:function(){
                       bootbox.alert("Error loading chart liste des OF");
                   }
               });
               return json;
           });
        
        
        
        // charge issue du pic
        
       if ($('#avancementOf').length){
           
           $.getJSON( "/SysProd/kanban/chargeOF", function( data ) {
               $.getJSON( "/SysProd/kanban/listeOF", function( fam ) {
               Morris.Bar({
		  element: 'avancementOf',
		  axes: false,
		  grid: false,
		  data: data,
		  xkey: 'annee',
		  ykeys: fam,
		  labels: fam,
		  stacked: true
		});
	});
	});
        
       }
       
             
       
       
       if ($('#indicateurKanban').length){
           
           var nomKanban = $('#monKanban').val();
               Morris.Bar({
		  element: 'indicateurKanban',
		  axes: true,
		  grid: true,
		  data: [
		    {x: '2011 Q1', y: $('#chargePlanifiee').val(), z: 2, a: 3},
		    {x: '2011 Q2', y: $('#chargePlanifiee').val(), z: null, a: 1},
		    {x: '2011 Q3', y: 0, z: 2, a: $('#chargePlanifiee').val()},
		    {x: '2011 Q4', y: 2, z: 4, a: 3}
		  ],
		  xkey: 'x',
		  ykeys: ['y', 'z', 'a'],
		  labels: [nomKanban, 'Z', 'A'],
		  stacked: true
		});
            }
            
            
       
       if ($('#deltaChargeCapa').length){
           
           var nomKanban = $('#monKanban').val();
           $.getJSON( "/SysProd/activite/deltaCharge", function(data) {
               $.getJSON( "/SysProd/activite/listeFamille", function(fam) {
               Morris.Bar({
		  element: 'deltaChargeCapa',
		  axes: true,
		  grid: true,
		  data: data,
		  xkey: 'mois',
		  ykeys: ['charge'],
		  labels: ['charge'],
		  stacked: true
		});
            });});}
            
       
       
        var json_data2 = (function() {
               var json;
               $.ajax({
                   type:'GET',
                   url: '/SysProd/activite/barPIC',
                   async: false,
                   global: false,
                   success: function(data) {
                       json = data;
                   }, 
                           error:function(){
                       alert("Error loading chart barPIC");
                   }
               });
               return json;
           })
        
        
        
	// bar graph color
	if ($('#1barPIC').length){ 
		    
                
                
		Morris.Bar({
		  element: '1barPIC',
		  data: json_data2,
		  xkey: 'annee',
		  ykeys: ['charge'],
		  labels: ['Charge'],
		  barColors: function (row, series, type) {
		    if (type === 'bar') {
		      var red = Math.ceil(255 * row.y / this.ymax);
		      return 'rgb(' + red + ',0,0)';
		    }
		    else {
		      return '#000';
		    }
		  }
		});
	
	}
        
        
	

if ($('#chargeCapa').length) {
    var fam;
    var capa;
	var chartData =  $.ajax({
                   type:'GET',
                   url: '/SysProd/activite/chargeCapaFamille',
                   async: false,
                   global: false,
                   success: function(data) {
                       capa = data;
                   }, 
                           error:function(){
                       alert("Error loading chart avancement charge capa");
                   }
               });
	var chartFam =  $.ajax({
                   type:'GET',
                   url: '/SysProd/activite/listeFamille',
                   async: false,
                   global: false,
                   success: function(data) {
                       fam = data;
                   }, 
                           error:function(){
                       alert("Error loading chart liste famille");
                   }
               });
               
	var chart;

	AmCharts.ready(function() {
		// SERIAL CHART
                
		chart = new AmCharts.AmSerialChart();
		chart.pathToImages = "http://www.amcharts.com/lib/3/images/";
		chart.marginTop = 0;
                chart.dataProvider = capa;
		chart.categoryField = 'mois';
		chart.autoMarginOffset = 5;

		// AXES
		// category axis
		var categoryAxis = chart.categoryAxis;
                
		categoryAxis.autoGridCount = false;
                
		categoryAxis.gridAlpha = 0;
		categoryAxis.gridColor = "#000000";
		categoryAxis.axisColor = "#000";
                

		// charge value axis
		var salesAxis = new AmCharts.ValueAxis();
		salesAxis.title = "Charge planifiée (jour)";
		salesAxis.gridAlpha = 0;
		salesAxis.inside = true;
		salesAxis.mininimum = 0;
		salesAxis.unit = " j";
                salesAxis.stackType ="regular";
		salesAxis.axisAlpha = 0;
		chart.addValueAxis(salesAxis);
                
                
		var durationGraph = new AmCharts.AmGraph();
		durationGraph.title = "Capacité planifiée";
		durationGraph.valueField = "capacite";
		durationGraph.type = "line";
		durationGraph.valueAxis = salesAxis;
		// indicate which axis should be used
		durationGraph.lineColor = "#CC0000";
		durationGraph.balloonText = "[[title]] : [[value]] j";
		durationGraph.lineThickness = 1;
		durationGraph.legendValueText = "[[value]] j";
		chart.addGraph(durationGraph);
		
                for(var i=0;i<fam.length;i++){
                     var obj = fam[i];
                     for(var key in obj){
                
		// developpement graph
		var salesGraph = new AmCharts.AmGraph();
		salesGraph.valueField = obj[key];
		salesGraph.title = obj[key];
		salesGraph.type = "column";
		salesGraph.fillAlphas = 0.3;
		salesGraph.valueAxis = salesAxis;
		// indicate which axis should be used
		salesGraph.balloonText = "[[title]] : [[value]] j";
		salesGraph.legendValueText = "[[value]] j";
		salesGraph.lineAlpha = .7;
		chart.addGraph(salesGraph);

                     }
                 }
		// CURSOR
		var chartCursor = new AmCharts.ChartCursor();
		chartCursor.zoomable = false;
		chartCursor.categoryBalloonDateFormat = "DD";
		chartCursor.cursorAlpha = 0;
		chart.addChartCursor(chartCursor);

		// LEGEND
		var legend = new AmCharts.AmLegend();
		legend.bulletType = "round";
		legend.equalWidths = true;
		legend.valueWidth = 30;
		legend.color = "#000000";
		chart.addLegend(legend);
                
                

		// BAR
		/* var chartScrollbar = new AmCharts.ChartScrollbar();
		chartScrollbar.scrollbarHeight = 25;
		chartScrollbar.graph = salesGraph; // as we want graph to be displayed in the scrollbar, we set graph here
		chartScrollbar.graphType = "line"; // we don't want candlesticks to be displayed in the scrollbar
		chartScrollbar.gridCount = 5;
		chartScrollbar.color = "#FFFFFF";
		chart.addChartScrollbar(chartScrollbar);*/

		// WRITE
		chart.write("chargeCapa");
	});
}
	

if ($('#chargeCapa2').length) {
	var chartData = [{
		date : new Date(2012, 0, 1),
		developpement : 108,
                commercial : 54,
                management : 54,
                veille : 27,
		capacite : 270
	}, {
		date : new Date(2012, 0, 2),
		developpement : 110,
                commercial : 60,
                management : 51,
                veille : 27,
		capacite : 255
	}, {
		date : new Date(2012, 0, 3),
		developpement : 150,
                commercial : 83,
                management : 63,
                veille : 45,
		capacite : 315
	}, {
		date : new Date(2012, 0, 4),
		developpement : 105,
                commercial : 45,
                management : 50,
                veille : 27,
		capacite : 255
	}, {
		date : new Date(2012, 0, 5),
		developpement : 146,
                commercial : 51,
                management : 50,
                veille : 47,
		capacite : 315
	}, {
		date : new Date(2012, 0, 6),
		developpement : 150,
                commercial : 63,
                management : 70,
                veille : 57,
		capacite : 300
	}, {
		date : new Date(2012, 0, 7),
		developpement : 61,
                commercial : 44,
                management : 45,
                veille : 43,
		capacite : 180
	}, {
		date : new Date(2012, 0, 8),
		developpement : 59,
                commercial : 39,
                management : 22,
                veille : 18,
		capacite : 150
	}, {
		date : new Date(2012, 0, 9),
		developpement : 112,
                commercial : 45,
                management : 50,
                veille : 27,
		capacite : 285
	}, {
		date : new Date(2012, 0, 10),
		developpement : 149,
                commercial : 49,
                management : 58,
                veille : 23,
		capacite : 300
	}, {
		date : new Date(2012, 0, 11),
		developpement : 175,
                commercial : 69,
                management : 39,
                veille : 27,
		capacite : 270
	}, {
		date : new Date(2012, 0, 12),
		developpement : 125,
                commercial : 43,
                management : 38,
                veille : 27,
		capacite : 225
	}];

	var chart;

	AmCharts.ready(function() {
		// SERIAL CHART
		chart = new AmCharts.AmSerialChart();
		chart.pathToImages = "http://www.amcharts.com/lib/3/images/";
		chart.dataProvider = chartData;
		chart.categoryField = "date";
		chart.marginTop = 0;
		chart.autoMarginOffset = 5;

		// AXES
		// category axis
		var categoryAxis = chart.categoryAxis;
		categoryAxis.parseDates = true;
		// as our data is date-based, we set parseDates to true
		categoryAxis.minPeriod = "DD";
		// our data is daily, so we set minPeriod to DD
		categoryAxis.autoGridCount = false;
		categoryAxis.min = 0;
		categoryAxis.max = 300;
		categoryAxis.gridAlpha = 0;
		categoryAxis.gridColor = "#000000";
		categoryAxis.axisColor = "#000";
		// we want custom date formatting, so we change it in next line
		categoryAxis.dateFormats = [{
			period : 'DD',
			format : 'DD'
		}, {
			period : 'WW',
			format : 'MMM DD'
		}, {
			period : 'MM',
			format : 'MMM'
		}, {
			period : 'YYYY',
			format : 'YYYY'
		}];

		

		// charge value axis
		var salesAxis = new AmCharts.ValueAxis();
		salesAxis.title = "Charge planifiée (jour)";
		salesAxis.gridAlpha = 0;
		salesAxis.inside = true;
		salesAxis.mininimum = 0;
		salesAxis.maximum = 400;
		salesAxis.unit = " j";
                salesAxis.stackType ="regular";
		salesAxis.axisAlpha = 0;
		chart.addValueAxis(salesAxis);

		// GRAPHS
		// duration graph
		var durationGraph = new AmCharts.AmGraph();
		durationGraph.title = "Capacité planifiée";
		durationGraph.valueField = "capacite";
		durationGraph.type = "line";
		durationGraph.valueAxis = salesAxis;
		// indicate which axis should be used
		durationGraph.lineColor = "#CC0000";
		durationGraph.balloonText = "[[title]] : [[value]] j";
		durationGraph.lineThickness = 1;
		durationGraph.legendValueText = "[[value]] j";
		durationGraph.bullet = "square";
		chart.addGraph(durationGraph);

		// developpement graph
		var salesGraph = new AmCharts.AmGraph();
		salesGraph.valueField = "developpement";
		salesGraph.title = "developpement";
		salesGraph.type = "column";
		salesGraph.fillAlphas = 0.3;
		salesGraph.fillColors = ["#0000FF", "#0000FF"];
		salesGraph.valueAxis = salesAxis;
		// indicate which axis should be used
		salesGraph.balloonText = "[[title]] : [[value]] j";
		salesGraph.legendValueText = "[[value]] j";
		salesGraph.lineColor = "#0000FF";
		salesGraph.lineAlpha = .7;
		chart.addGraph(salesGraph);
                
                
		// management graph
		var salesGraph = new AmCharts.AmGraph();
		salesGraph.valueField = "management";
		salesGraph.title = "management";
		salesGraph.type = "column";
		salesGraph.fillAlphas = 0.3;
		salesGraph.fillColors = ["#F08080", "#F08080"];
		salesGraph.valueAxis = salesAxis;
		// indicate which axis should be used
		salesGraph.balloonText = "[[title]] : [[value]] j";
		salesGraph.legendValueText = "[[value]] j";
		salesGraph.lineColor = "#F08080";
		salesGraph.lineAlpha = .7;
		chart.addGraph(salesGraph);
                
                // veille graph
		var salesGraph = new AmCharts.AmGraph();
		salesGraph.valueField = "veille";
		salesGraph.title = "veille";
		salesGraph.type = "column";
		salesGraph.fillAlphas = 0.3;
		salesGraph.fillColors = ["#32CD32", "#32CD32"];
		salesGraph.valueAxis = salesAxis;
		// indicate which axis should be used
		salesGraph.balloonText = "[[title]] : [[value]] j";
		salesGraph.legendValueText = "[[value]] j";
		salesGraph.lineColor = "#32CD32";
		salesGraph.lineAlpha = .7;
		chart.addGraph(salesGraph);
                

                // commercial graph
		var salesGraph = new AmCharts.AmGraph();
		salesGraph.valueField = "commercial";
		salesGraph.title = "commercial";
		salesGraph.type = "column";
		salesGraph.fillAlphas = 0.3;
		salesGraph.fillColors = ["#FF00FF", "#FF00FF"];
		salesGraph.valueAxis = salesAxis;
		// indicate which axis should be used
		salesGraph.balloonText = "[[title]] : [[value]] j";
		salesGraph.legendValueText = "[[value]] j";
		salesGraph.lineColor = "#FF00FF";
		salesGraph.lineAlpha = .7;
		chart.addGraph(salesGraph);
                

		// CURSOR
		var chartCursor = new AmCharts.ChartCursor();
		chartCursor.zoomable = false;
		chartCursor.categoryBalloonDateFormat = "DD";
		chartCursor.cursorAlpha = 0;
		chart.addChartCursor(chartCursor);

		// LEGEND
		var legend = new AmCharts.AmLegend();
		legend.bulletType = "round";
		legend.equalWidths = true;
		legend.valueWidth = 30;
		legend.color = "#000000";
		chart.addLegend(legend);
                
                
		var chartScrollbar = new AmCharts.ChartScrollbar();
		chartScrollbar.scrollbarHeight = 30;
		chartScrollbar.graph = salesGraph;
		chartScrollbar.color = "#FFFFFF";
		chart.addChartScrollbar(chartScrollbar);

		// BAR
		/* var chartScrollbar = new AmCharts.ChartScrollbar();
		chartScrollbar.scrollbarHeight = 25;
		chartScrollbar.graph = salesGraph; // as we want graph to be displayed in the scrollbar, we set graph here
		chartScrollbar.graphType = "line"; // we don't want candlesticks to be displayed in the scrollbar
		chartScrollbar.gridCount = 5;
		chartScrollbar.color = "#FFFFFF";
		chart.addChartScrollbar(chartScrollbar);*/

		// WRITE
		chart.write("chargeCapa2");
	});
}






if ($('#avancementKanban').length) {
        var monId = $('#monId').val();
        var json;
    
    var chartData2 = $.ajax({
                   type:'GET',
                   url: '/SysProd/kanban/avancement',
                   data : {
                     monId : monId, 
                   },
                   async: false,
                   global: false,
                   success: function(data) {
                       json = data;
                   }, 
                           error:function(){
                       alert("Error loading chart avancement kanban");
                   }
               });
               
                       var chart2;

	AmCharts.ready(function() {
		// SERIAL CHART
		chart2 = new AmCharts.AmSerialChart();
// mettre lien interne
		chart2.pathToImages = "http://www.amcharts.com/lib/3/images/";
		chart2.type = "serial";
		chart2.dataProvider = json;
		chart2.categoryField = "date";
		chart2.dataDateFormat = "YYYY-MM-DD";      
                chart2.addListener("rendered", zoomChart);

		// AXES
		// category axis
		var categoryAxis = chart2.categoryAxis;
		categoryAxis.parseDates = true;
                categoryAxis.dashLenght = 1;
		categoryAxis.minorGridEnabled = true;
                //categoryAxis.position = top;
		

		// charge value axis
		var salesAxis = new AmCharts.ValueAxis();
		salesAxis.title = "Avancement (%)";
		salesAxis.gridAlpha = 0;
		salesAxis.inside = true;
		salesAxis.mininimum = 0;
		salesAxis.maximum = 120;
		salesAxis.unit = " %";
                // Permet d'emplier les donnees
                // salesAxis.stackType ="regular";
		salesAxis.axisAlpha = 0;
		chart2.addValueAxis(salesAxis);

		// GRAPHS
		// duration graph
                // developpement graph
                
                var planifie = new AmCharts.AmGraph();
		planifie.id = "g2";
		planifie.title = "planifie";
		planifie.type = "line";                
		planifie.valueField = "planifie";
                planifie.bulletBorderAlpha = 1;
                planifie.bulletColor = "#FFFFFF";
                planifie.bulletSize = 5;
                planifie.hideBulletsCount = 50;
                planifie.lineThickness = 2;
                planifie.useLineColorForBulletBorder = true;
                planifie.connect = true;
		planifie.balloonText = "[[title]] : [[value]] %";
		planifie.legendValueText = "[[value]] %";
                
		chart2.addGraph(planifie);
                
                
                
		var monGraphe = new AmCharts.AmGraph();
		monGraphe.id = "g1";
		monGraphe.title = "Theorique";
		monGraphe.type = "line";
                
		monGraphe.valueField = "theorique";
                monGraphe.bulletBorderAlpha = 1;
                monGraphe.bulletColor = "#FFFFFF";
                monGraphe.bulletSize = 5;
                monGraphe.hideBulletsCount = 50;
                monGraphe.lineThickness = 2;
                monGraphe.useLineColorForBulletBorder = true;
		monGraphe.balloonText = "[[title]] : [[value]] %";
		monGraphe.legendValueText = "[[value]] %";
                
		chart2.addGraph(monGraphe);
	



                var realise = new AmCharts.AmGraph();
		realise.id = "g3";
		realise.title = "realise";
		realise.type = "line";
                
		realise.valueField = "realise";
                realise.bulletBorderAlpha = 1;
                realise.bulletColor = "#FFFFFF";
                realise.bulletSize = 5;
                realise.hideBulletsCount = 50;
                realise.lineThickness = 2;
                realise.useLineColorForBulletBorder = true;
                realise.connect = true;
		realise.balloonText = "[[title]] : [[value]] %";
		realise.legendValueText = "[[value]] %";
                
		chart2.addGraph(realise);


		// CURSOR
		var chartCursor = new AmCharts.ChartCursor();
		chartCursor.zoomable = false;
		chartCursor.categoryBalloonDateFormat = "DD";
		chartCursor.cursorAlpha = 0;
                
		chart2.addChartCursor(chartCursor);

		// LEGEND
                
		var legend = new AmCharts.AmLegend();
		legend.bulletType = "round";
		legend.equalWidths = true;
		legend.valueWidth = 50;
		legend.color = "#000000";
		chart2.addLegend(legend);

		var chartScrollbar = new AmCharts.ChartScrollbar();
		chartScrollbar.scrollbarHeight = 30;
		chartScrollbar.graph = monGraphe;
		chartScrollbar.color = "#FFFFFF";
		chart2.addChartScrollbar(chartScrollbar);

		chart2.write("avancementKanban");
	});
        
        

function zoomChart(){
    chart2.zoomToIndexes(0, chart2.dataProvider.length);
}
}





            
       if ($('#indicateurSocial').length){
               Morris.Bar({
		  element: 'indicateurSocial',
		  axes: true,
		  grid: true,
		  data: [
		    {x: 'Nombre de messages', y: $('#messagesKanban').val(), z: $('#messagesAutre').val()},
		    {x: 'Moyenne', y: $('#messagesKanbanMoyen').val(), z: $('#messagesAutreMoyen').val()}
		  ],
		  xkey: 'x',
		  ykeys: ['y', 'z'],
		  labels: ['Sur Projets', 'Autres'],
		  stacked: true
		});
            }
            