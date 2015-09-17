package com.savonline.client.view;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.Selection;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.events.SelectHandler;
import com.google.gwt.visualization.client.visualizations.PieChart;
import com.google.gwt.visualization.client.visualizations.PieChart.Options;
import com.google.gwt.visualization.client.visualizations.Table;
import com.savonline.client.presenter.StatisticFichePresenter;

public class StatisticFicheView extends Composite implements StatisticFichePresenter.Display{

	private final Label lbl1;
	private final VerticalPanel vPanel;
	private JSONArray data ;



	public StatisticFicheView() {

		lbl1=new Label("salut");
		vPanel = new VerticalPanel();
		//initWidget(lbl1);

		// Create a callback to be called when the visualization API
		// has been loaded.
		Runnable onLoadCallback = new Runnable() {
			public void run() {
				//Panel panel = new VerticalPanel();

				// Create a pie chart visualization.
				PieChart pie = new PieChart(createTable(), createOptions());

				//pie.addSelectHandler(createSelectHandler(pie));
				vPanel.add(pie);

			}
		};

//		Runnable onLoadCallback2 = new Runnable() {
//			public void run() {
//
//				Table table = new Table();
//				//com.google.gwt.visualization.client.visualizations.Table..
//				table.draw(createTable(),createOptionsTable());
//				vPanel.add(table);
//
//			}
//		};



		// Load the visualization api, passing the onLoadCallback to be called
		// when loading is done.
		VisualizationUtils.loadVisualizationApi(onLoadCallback, PieChart.PACKAGE);
		//VisualizationUtils.loadVisualizationApi(onLoadCallback2, Table.PACKAGE);








		initWidget(vPanel);





	}



	private Options createOptions() {
		Options options = Options.create();
		options.setWidth(500);
		options.setHeight(340);
		options.set3D(true);
		options.setTitle("Etat de Fiche");
		return options;
	}
	
	private com.google.gwt.visualization.client.visualizations.Table.Options createOptionsTable() {
		com.google.gwt.visualization.client.visualizations.Table.Options options = com.google.gwt.visualization.client.visualizations.Table.Options.create();
		options.setPageSize(2);
		return options;
	}


	private SelectHandler createSelectHandler(final PieChart chart) {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				String message = "";

				// May be multiple selections.
				JsArray<Selection> selections = chart.getSelections();

				for (int i = 0; i < selections.length(); i++) {
					// add a new line for each selection
					message += i == 0 ? "" : "\n";

					Selection selection = selections.get(i);

					if (selection.isCell()) {
						// isCell() returns true if a cell has been selected.

						// getRow() returns the row number of the selected cell.
						int row = selection.getRow();
						// getColumn() returns the column number of the selected cell.
						int column = selection.getColumn();
						message += "cell " + row + ":" + column + " selected";
					} else if (selection.isRow()) {
						// isRow() returns true if an entire row has been selected.

						// getRow() returns the row number of the selected row.
						int row = selection.getRow();
						message += "row " + row + " selected";
					} else {
						// unreachable
						message += "Pie chart selections should be either row selections or cell selections.";
						message += "  Other visualizations support column selections as well.";
					}
				}

				Window.alert(message);
			}
		};
	}


	private AbstractDataTable createTable() {

		//		DataTable dataTable = DataTable.create();
		//		dataTable.addColumn(ColumnType.STRING, "En cours de preparation");
		//		dataTable.addColumn(ColumnType.STRING, "En cours de preparation");
		//		dataTable.addColumn(ColumnType.STRING, "En attente de confirmation");
		//
		//		dataTable.addRows(3);
		//		dataTable.setValue(0, 0, "En cours de preparation");
		//		dataTable.setValue(0, 1, 14);
		//		dataTable.setValue(1, 0, "En cours de preparation");
		//		dataTable.setValue(1, 1, 10);
		//		dataTable.setValue(2, 0, "En attente de confirmation");
		//		dataTable.setValue(2, 1, 25);



		JSONObject jsonObject = new JSONObject();
		String nom_etat;
		String count_fiches;

		DataTable dataTable = DataTable.create();
		dataTable.addRows(data.size()-1);
		
		dataTable.addColumn(ColumnType.STRING, "Etat Fiche");
		dataTable.addColumn(ColumnType.NUMBER, "Total");
		for (int i = 0 ; i < data.size() ; i++){

			jsonObject =  data.get(i).isObject();
			if(jsonObject != null){
				
				dataTable.setValue(i, 0, jsonObject.get("nom_etat").isString().stringValue());
				//dataTable.setValue(i, 1, Integer.parseInt(jsonObject.get("count_fiches").isString().stringValue()));
				dataTable.setValue(i, 1, Integer.parseInt(jsonObject.get("count_fiches").isString().stringValue()));
			}
		}
		return dataTable;
	}


	public void setData(JSONArray data){		
		this.data = data;
	}




	public Widget asWidget() {
		return this;
	}





}