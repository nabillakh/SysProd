if ($('#chartdiv').length) {
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
		chart.pathToImages = "img/amchart/";
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

		// BAR
		/* var chartScrollbar = new AmCharts.ChartScrollbar();
		chartScrollbar.scrollbarHeight = 25;
		chartScrollbar.graph = salesGraph; // as we want graph to be displayed in the scrollbar, we set graph here
		chartScrollbar.graphType = "line"; // we don't want candlesticks to be displayed in the scrollbar
		chartScrollbar.gridCount = 5;
		chartScrollbar.color = "#FFFFFF";
		chart.addChartScrollbar(chartScrollbar);*/

		// WRITE
		chart.write("chartdiv");
	});
}