
		if ($('#uislider-demo').length) {
                    
                        var chartData2 = $.ajax({
                            type:'GET',
                            url: '/SysProd/kanban/avancement',
                            async: false,
                            global: false,
                            success: function(data) {
                                json = data;
                            }, 
                           error:function(){
                       alert("Error loading chart avancement kanban");
                   }
               });
                    
			$("#slider-range").slider({
			    range: true,
			    min: 100,
			    max: 500,
			    values: [176, 329],
			    slide: function(event, ui) {
			        $("#amount").val("Du : " + ui.values[0] + " au " + ui.values[1]);
			
			        $('#slider-range .ui-slider-handle:first').html('<div class="tooltip top slider-tip"><div class="tooltip-arrow"></div><div class="tooltip-inner">' + ui.values[0] + '</div></div>');
			        $('#slider-range .ui-slider-handle:last').html('<div class="tooltip top slider-tip"><div class="tooltip-arrow"></div><div class="tooltip-inner">' + ui.values[1] + '</div></div>');
			    }
			});
			$("#amount").val("Du " + $("#slider-range").slider("values", 0) + " au " + $("#slider-range").slider("values", 1));

				
			$( "#slider-range-min" ).slider({
		            range: "min",
		            value: 461,
		            min: 100,
		            max: 900,
		            slide: function( event, ui ) {
		                $( "#amount2" ).val( "$" + ui.value );
		                $('#slider-range-min .ui-slider-handle:first').html('<div class="tooltip top slider-tip"><div class="tooltip-arrow"></div><div class="tooltip-inner">' + ui.value + '</div></div>');
		            }
		        });
		    $("#amount2").val( "$" + $( "#slider-range-min" ).slider("value"));
			
			
			$( "#slider-range-max" ).slider({
		            range: "max",
		            min: 100,
		            max: 999,
		            value: 507,
		            slide: function( event, ui ) {
		                $( "#amount3" ).val( "$" + ui.value );
		                $('#slider-range-max .ui-slider-handle:first').html('<div class="tooltip top slider-tip"><div class="tooltip-arrow"></div><div class="tooltip-inner">' + ui.value + '</div></div>');
		            }
		        });
		    $("#amount3" ).val( "$" + $( "#slider-range-max" ).slider( "value" ));
		    
			$("#slider-range-step").slider({
			    range: true,
			    min: 100,
			    max: 999,
			    step:100,
			    values: [250, 850],
			    slide: function(event, ui) {
			        $("#amount4").val("$" + ui.values[0] + " - $" + ui.values[1]);
			
			        $('#slider-range-step .ui-slider-handle:first').html('<div class="tooltip top slider-tip"><div class="tooltip-arrow"></div><div class="tooltip-inner">' + ui.values[0] + '</div></div>');
			        $('#slider-range-step .ui-slider-handle:last').html('<div class="tooltip top slider-tip"><div class="tooltip-arrow"></div><div class="tooltip-inner">' + ui.values[1] + '</div></div>');
			    }
			});
			$("#amount4").val("$" + $("#slider-range-step").slider("values", 0) + " - $" + $("#slider-range-step").slider("values", 1));
			
		}