if ($('#tabKanban').length) {
    
    var tabKanban_data;
                                
    var chartData =  $.ajax({
        type:'GET',
        url: '/SysProd/kanban/listeKanbans',
        async: false,
        global: false,
        
        success: function(data) {
            tabKanban_data = data;
        }, 
                error:function(){
            alert("Erreur chargemetn liste kanban");
        }
    });         
    jQuery("#tabKanban").jqGrid({
					data : tabKanban_data,
					datatype : "local",
					height : 'auto',
					colNames : ['Actions','Nom du projet', 'Description', 'Charge associée', 'Date de fin', 'encours', 'ordo'],
					colModel : [{
						name : 'act',
						index : 'act',
						sortable : false
					}, {
						name : 'nom',
						index : 'nom',
						editable : true
					}, {
						name : 'description',
						index : 'description',
						editable : true
					}, {
						name : 'charge',
						index : 'charge',
						align : "right",
						editable : true
					}, {
						name : 'datedefin',
						index : 'datedefin',
						align : "right",
						editable : true
					}, {
						name : 'encours',
						index : 'encours',
						align : "right",
						editable : true
					}, {
						name : 'ordo',
						index : 'ordo',
						sortable : false,
						editable : true
					}],
					rowNum : 10,
					rowList : [10, 20, 30],
					pager : '#ptabKanban',
					sortname : 'id',
					toolbarfilter : true,
					viewrecords : true,
					sortorder : "asc",
					gridComplete : function() {
						var ids = jQuery("#tabKanban").jqGrid('getDataIDs');
						for (var i = 0; i < ids.length; i++) {
							var cl = ids[i];
							ca1 = "<button class='btn btn-xs btn-default' data-original-title='Show' onclick=\"voir("+cl+");\"><i class='fa fa-search'></i></button>";
							be = "<button class='btn btn-xs btn-default' data-original-title='Edit' onclick=\"editer("+cl+");\"><i class='fa fa-pencil'></i></button>";
							se = "<button class='btn btn-xs btn-default' data-original-title='Save' onclick=\"gererOf("+cl+");\"><i class='fa fa-calendar'></i></button>";
							ca = "<button class='btn btn-xs btn-default' data-original-title='Cancel' onclick=\"voir("+cl+");\"><i class='fa fa-times'></i></button>";
							//ce = "<button class='btn btn-xs btn-default' onclick=\"jQuery('#tabKanban').restoreRow('"+cl+"');\"><i class='fa fa-times'></i></button>";
							//jQuery("#tabKanban").jqGrid('setRowData',ids[i],{act:be+se+ce});
							jQuery("#tabKanban").jqGrid('setRowData', ids[i], {
								act : ca1 + be + se + ca
							});
						}
					},
					editurl : "dummy.html",
					caption : "Liste des projets",
					multiselect : true,
					autowidth : true,

				});
				jQuery("#tabKanban").jqGrid('navGrid', "#ptabKanban", {
					edit : false,
					add : false,
					del : true
				});
				jQuery("#tabKanban").jqGrid('inlineNav', "#ptabKanban");
				/* Add tooltips */
				$('.navtable .ui-pg-button').tooltip({
					container : 'body'
				});

				jQuery("#m1").click(function() {
					var s;
					s = jQuery("#tabKanban").jqGrid('getGridParam', 'selarrrow');
					alert(s);
				});
				jQuery("#m1s").click(function() {
					jQuery("#tabKanban").jqGrid('setSelection', "13");
				});

				// remove classes
				$(".ui-jqgrid").removeClass("ui-widget ui-widget-content");
				$(".ui-jqgrid-view").children().removeClass("ui-widget-header ui-state-default");
				$(".ui-jqgrid-labels, .ui-search-toolbar").children().removeClass("ui-state-default ui-th-column ui-th-ltr");
				$(".ui-jqgrid-pager").removeClass("ui-state-default");
				$(".ui-jqgrid").removeClass("ui-widget-content");

				// add classes
				$(".ui-jqgrid-htable").addClass("table table-bordered table-hover");
				$(".ui-jqgrid-btable").addClass("table table-bordered table-striped");

				$(".ui-pg-div").removeClass().addClass("btn btn-sm btn-primary");
				$(".ui-icon.ui-icon-plus").removeClass().addClass("fa fa-plus");
				$(".ui-icon.ui-icon-pencil").removeClass().addClass("fa fa-pencil");
				$(".ui-icon.ui-icon-trash").removeClass().addClass("fa fa-trash-o");
				$(".ui-icon.ui-icon-search").removeClass().addClass("fa fa-search");
				$(".ui-icon.ui-icon-refresh").removeClass().addClass("fa fa-refresh");
				$(".ui-icon.ui-icon-disk").removeClass().addClass("fa fa-save").parent(".btn-primary").removeClass("btn-primary").addClass("btn-success");
				$(".ui-icon.ui-icon-cancel").removeClass().addClass("fa fa-times").parent(".btn-primary").removeClass("btn-primary").addClass("btn-danger");

				$(".ui-icon.ui-icon-seek-prev").wrap("<div class='btn btn-sm btn-default'></div>");
				$(".ui-icon.ui-icon-seek-prev").removeClass().addClass("fa fa-backward");

				$(".ui-icon.ui-icon-seek-first").wrap("<div class='btn btn-sm btn-default'></div>");
				$(".ui-icon.ui-icon-seek-first").removeClass().addClass("fa fa-fast-backward");

				$(".ui-icon.ui-icon-seek-next").wrap("<div class='btn btn-sm btn-default'></div>");
				$(".ui-icon.ui-icon-seek-next").removeClass().addClass("fa fa-forward");

				$(".ui-icon.ui-icon-seek-end").wrap("<div class='btn btn-sm btn-default'></div>");
				$(".ui-icon.ui-icon-seek-end").removeClass().addClass("fa fa-fast-forward");

			
}


                                                          function voir(monId) {
                                                                    window.location = "show/"+monId;
                                                          }        
                                                          function editer(monId) {
                                                                    window.location = "edit/"+monId;
                                                          }       
                                                          function gererOf(monId) {
                                                                    window.location = "gestionOf/"+monId;
                                                          }       
                                                          function supprimer(monId) {
                                                                    bootbox.confirm("'Voulez vous confirmer la suppression du projet?" , function(result) {
					 //console.log("Confirm result: "+result);
                                        
                                                                                   // <g:remoteFunction controller = "kanban" action="delete"   params ="\'kanban=\' + monId" />
                                         					  // toastr.info("Confirm result: "+result);
                                                                                });
                                                          }