package com.mytek.savonline.client.view;

import org.apache.xalan.templates.AbsPathChecker;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.mytek.savonline.client.presenter.*;

public class DisplayEmployeView extends Composite implements DisplayEmployePresenter.Display{
private final FlexTable flexData;
	public DisplayEmployeView() {
		flexData= new FlexTable();
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		
		
		Label lblListeDesTechniciens = new Label("Liste des techniciens");
		lblListeDesTechniciens.setStyleName("LabelTitreListeEmploye");
		absolutePanel.add(lblListeDesTechniciens, 58, 10);
		lblListeDesTechniciens.setSize("139px", "18px");
		DecoratorPanel decp=new DecoratorPanel();
		decp.add(flexData);
		absolutePanel.add(decp, 10, 39);
				initWidget(decp);

	}
	public Widget asWidget() {
		return this;
	}
	public void setDataEmpoye(JSONArray data) {
		FlexCellFormatter cellFormatterallflexData = flexData.getFlexCellFormatter();
		flexData.setBorderWidth(0);
		flexData.setCellPadding(4);

		JSONObject jsonObject = new JSONObject();
		boolean colored = false;
		for (int i = 1 ; i < data.size() ; i++){

			jsonObject =  data.get(i).isObject();
			Resources resources = GWT.create(Resources.class);
			Image imgBtnEdit = new Image(resources.EditIcon());
			imgBtnEdit.setTitle("Editer");
			
			Image imgEyes = new Image(resources.viewBtn());
			
			imgEyes.setTitle("Consulter");
			if(jsonObject != null){
				flexData.setHTML(0, 0, "Id");
				flexData.setHTML(0, 1, "Nom");
				flexData.setHTML(0, 2, "Prenom");
				flexData.setHTML(0, 3, "Adresse");
				flexData.setHTML(0, 4, "N Tel-Portable");
				flexData.setHTML(0, 5, "N Tel-Fix");
				flexData.setHTML(0, 6, "Email");
				flexData.setHTML(0, 7, "Mot de passe");
			
				flexData.setWidget(i, 0, new Label(jsonObject.get("id_employe").isString().stringValue()));
				flexData.setWidget(i, 1, new Label(jsonObject.get("nom_Emp").isString().stringValue()));
				flexData.setWidget(i, 2, new Label(jsonObject.get("prenom_Emp").isString().stringValue()));
				flexData.setWidget(i, 3, new Label(jsonObject.get("adresse_Emp").isString().stringValue()));
				flexData.setWidget(i, 4, new Label(jsonObject.get("numTelMobil").isString().stringValue()));
				flexData.setWidget(i, 5, new Label(jsonObject.get("numTelFix").isString().stringValue()));
				flexData.setWidget(i, 6, new Label(jsonObject.get("emailEmp").isString().stringValue()));
				flexData.setWidget(i, 7, new Label(jsonObject.get("passwordEmp").isString().stringValue()));
				
				flexData.setWidget(i, 8, imgBtnEdit);

				if(!colored){
					for(int k=0;k<8;k++){
						cellFormatterallflexData.setStyleName(i, k, "flexRow");
					}
					colored = true;
				}else{
					colored = false;
				}


			}
		}
//		}
	}
}
