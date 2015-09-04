package com.savonline.client.view;

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
import com.savonline.client.presenter.*;

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
		for (int i = 0 ; i < data.size() ; i++){

			jsonObject =  data.get(i).isObject();
			Resources resources = GWT.create(Resources.class);
			Image imgBtnEdit = new Image(resources.EditIcon());
			imgBtnEdit.setTitle("Editer");
			
			Image imgEyes = new Image(resources.viewBtn());
			
			imgEyes.setTitle("Consulter");
			if(jsonObject != null){
				flexData.setHTML(0, 0, "<center><b>Id</b></center>");
				flexData.setHTML(0, 1, "<center><b>Nom</b></center>");
				flexData.setHTML(0, 2, "<center><b>Prenom</b></center>");
				flexData.setHTML(0, 3, "<center><b>Adresse</b></center>");
				flexData.setHTML(0, 4, "<center><b>N Tel-Portable</b></center>");
				flexData.setHTML(0, 5, "<center><b>N Tel-Fix</b></center>");
				flexData.setHTML(0, 6, "<center><b>Email</b></center>");
				flexData.setHTML(0, 7, "<center><b>Mot de passe</b></center>");
				flexData.setHTML(0, 8, "<center><b>Modifier</b></center>");
			
				flexData.setWidget(i+1, 0, new Label(jsonObject.get("id_employe").isString().stringValue()));
				flexData.setWidget(i+1, 1, new Label(jsonObject.get("nom_Emp").isString().stringValue()));
				flexData.setWidget(i+1, 2, new Label(jsonObject.get("prenom_Emp").isString().stringValue()));
				flexData.setWidget(i+1, 3, new Label(jsonObject.get("adresse_Emp").isString().stringValue()));
				flexData.setWidget(i+1, 4, new Label(jsonObject.get("numTelMobil").isString().stringValue()));
				flexData.setWidget(i+1, 5, new Label(jsonObject.get("numTelFix").isString().stringValue()));
				flexData.setWidget(i+1, 6, new Label(jsonObject.get("emailEmp").isString().stringValue()));
				flexData.setWidget(i+1, 7, new Label(jsonObject.get("passwordEmp").isString().stringValue()));
				
				flexData.setWidget(i+1, 8, imgBtnEdit);

				if(!colored){
					for(int k=0;k<=8;k++){
						cellFormatterallflexData.setStyleName(i+1, k, "flexRow");
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
