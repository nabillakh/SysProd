
if ($('#chargeCapaEffectif').length) {
    var fam;
    var capa;
    
        var monId = $('#monId').val();
        
	var chartData =  $.ajax({
                   type:'GET',
                   url: '/SysProd/activite/chargeCapaFamilleEffectif',
                   async: false,
                   global: false,
                   data : {
                     monId : monId, 
                   },
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
		chart.write("chargeCapaEffectif");
	});
}