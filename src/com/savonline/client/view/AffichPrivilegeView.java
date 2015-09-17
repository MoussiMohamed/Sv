package com.savonline.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.savonline.client.presenter.*;
import com.google.gwt.user.client.ui.DockPanel;

public class AffichPrivilegeView extends Composite implements AffichPrivilegePresenter.Display{
public final FlexTable flexData;
public AbsolutePanel absolutePanel;
	public AffichPrivilegeView() {
		flexData=new FlexTable();
		 absolutePanel = new AbsolutePanel();
		
//		Label lblListePrivileges = new Label("Liste de privileges");
//		lblListePrivileges.setStyleName("LblListPriv");
//		absolutePanel.add(lblListePrivileges, 130, 10);
//		flexData.setWidget(0, 0, lblListePrivileges);
		initWidget(flexData);
		
	}
	public Widget asWidget(){
		return this;
	}
	public void setDataPrivilege(JSONArray data) {
		FlexCellFormatter cellFormatterallflexData = flexData.getFlexCellFormatter();
		flexData.setBorderWidth(0);
		flexData.setCellPadding(4);

		JSONObject jsonObject = new JSONObject();
		boolean colored = false;
		flexData.setHTML(0, 0, "ID");
		flexData.setHTML(0, 1, "Privilege");
		for (int i = 0 ; i < data.size() ; i++){

			jsonObject =  data.get(i).isObject();
			Resources resources = GWT.create(Resources.class);
			Image imgBtnDelete = new Image(resources.DeleteIcon());
			imgBtnDelete.setTitle("Delete");
			
			if(jsonObject != null){
//				flexData.setHTML(i, 0, "Id");
//				flexData.setHTML(i, 1, "Privilege");
			
				flexData.setWidget(i+1, 0, new Label(jsonObject.get("id_privilege").isString().stringValue()));
				flexData.setWidget(i+1, 1, new Label(jsonObject.get("privilege").isString().stringValue()));
				flexData.setWidget(i+1, 2, imgBtnDelete);

				if(!colored){
					for(int k=0;k<2;k++){
						cellFormatterallflexData.setStyleName(i+1, k, "flexRow");
					}
					colored = true;
				}else{
					colored = false;
				}


			}
		}

	}
	
	String selectedItem;
	
	public String getClickedRow(ClickEvent event) {
		int selectedRow = -1;
//		Element selectedElement = null;
		HTMLTable.Cell cell = flexData.getCellForEvent(event);

		if (cell != null) {
			// Suppress clicks if the user is actually selecting the 
			//  check box
			//
			if (cell.getCellIndex() > 0) {
				selectedRow = cell.getRowIndex();
				
				selectedItem=flexData.getWidget(selectedRow, 0).getElement().getFirstChild().getNodeValue();
			}
		}

		return selectedItem;
	}
	public HasClickHandlers getList() {
		return flexData;
	}
	
	String TypeElement;
	public String getTypeElement(ClickEvent event) {
		int selectedRow = -1;
//		Element selectedElement = null;
		HTMLTable.Cell cell = flexData.getCellForEvent(event);

		if (cell != null) {
			// Suppress clicks if the user is actually selecting the 
			//  check box
			//
			if (cell.getCellIndex() > 0) {
				selectedRow = cell.getRowIndex();
				TypeElement=cell.getElement().getFirstChildElement().getTitle();
			}
		}

		return TypeElement;
	}
	
}
