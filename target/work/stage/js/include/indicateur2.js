          

if ($('#vadMensuelle').length) {
    var capa3;
	var chartData =  $.ajax({
                   type:'GET',
                   url: '/SysProd/activite/vadMensuelle',
                   async: false,
                   global: false,
                   success: function(data) {
                       capa3 = data;
                   }, 
                           error:function(){
                       alert("Error loading chart3 avancement charge capa3");
                   }
               });
               
               
	var chart3;

	AmCharts.ready(function() {
		// SERIAL CHART
                
		chart3 = new AmCharts.AmSerialChart();
		chart3.pathToImages = "http://www.amcharts.com/lib/3/images/";
		chart3.marginTop = 0;
                chart3.dataProvider = capa3;
		chart3.categoryField = 'mois';
		chart3.autoMarginOffset = 5;

		// AXES
		// category axis
		var categoryAxis = chart3.categoryAxis;
                
		categoryAxis.autoGridCount = false;
                
		categoryAxis.gridAlpha = 0;
		categoryAxis.gridColor = "#000000";
		categoryAxis.axisColor = "#000";
                

		// charge value axis
		var salesAxis = new AmCharts.ValueAxis();
		salesAxis.title = "VAD mensuelle planifiée (%)";
		salesAxis.gridAlpha = 0;
		salesAxis.inside = true;
		salesAxis.mininimum = 0;
		salesAxis.unit = " %";
                salesAxis.stackType ="regular";
		salesAxis.axisAlpha = 0;
		chart3.addValueAxis(salesAxis);
                
                
		var durationGraph = new AmCharts.AmGraph();
		durationGraph.title = "VAD planifiée";
		durationGraph.valueField = "vadPlan";
		durationGraph.type = "line";
		durationGraph.valueAxis = salesAxis;
		// indicate which axis should be used
		durationGraph.lineColor = "#CC0000";
		durationGraph.balloonText = "[[title]] : [[value]] %";
		durationGraph.lineThickness = 1;
		durationGraph.legendValueText = "[[value]] %";
		chart3.addGraph(durationGraph);
		
		// CURSOR
		var chartCursor = new AmCharts.ChartCursor();
		chartCursor.zoomable = false;
		chartCursor.categoryBalloonDateFormat = "DD";
		chartCursor.cursorAlpha = 0;
		chart3.addChartCursor(chartCursor);

		// LEGEND
		var legend = new AmCharts.AmLegend();
		legend.bulletType = "round";
		legend.equalWidths = true;
		legend.valueWidth = 30;
		legend.color = "#000000";
		chart3.addLegend(legend);
                
                

		// BAR
		/* var chartScrollbar = new AmCharts.ChartScrollbar();
		chartScrollbar.scrollbarHeight = 25;
		chartScrollbar.graph = salesGraph; // as we want graph to be displayed in the scrollbar, we set graph here
		chartScrollbar.graphType = "line"; // we don't want candlesticks to be displayed in the scrollbar
		chartScrollbar.gridCount = 5;
		chartScrollbar.color = "#FFFFFF";
		chart3.addChartScrollbar(chartScrollbar);*/

		// WRITE
		chart3.write("vadMensuelle");
	});
}