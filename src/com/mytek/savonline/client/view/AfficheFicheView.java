package com.mytek.savonline.client.view;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.thirdparty.streamhtmlparser.HtmlParser.Mode;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.mytek.savonline.client.presenter.AffichFichePresenter;
public class AfficheFicheView extends Composite implements AffichFichePresenter.Display{
	private  final Button btnAffiche;
	private FlexTable fiches;
	private FlexTable layout;
	private FlexTable FlexContainerAll,FlexImgAffiche;
	private Label resultLabel;
	private TextBox txtIdFiche,txtNomClient;
	private Image imgBtnDelete,imgBtnEdit,imgEyes;
	JSONValue jsonValue1;
	public AfficheFicheView() {
		btnAffiche=new Button("Afficher");
		resultLabel=new Label("");
		txtIdFiche=new TextBox();
		txtNomClient=new TextBox();
		FlexContainerAll=new FlexTable();

		//creation de flex fiches
//		FlexImgAffiche=new FlexTable();
		fiches = new FlexTable();

		//fiches.setStyleName("flexRow");


		//		FlexRadioButton=new FlexTable();
		//		FlexRadioButton.setPixelSize(30, 600);
		//		FlexRadioButton.setBorderWidth(1);
		fiches.setPixelSize(800, 20);
		
		FlexCellFormatter cellFormatterall = FlexContainerAll.getFlexCellFormatter();
		cellFormatterall.setHorizontalAlignment(
				2, 1, HasHorizontalAlignment.ALIGN_CENTER);
		//FlexContainerAll.setWidget(0, 0, FlexRadioButton);
		FlexContainerAll.setWidget(0, 0, fiches);
//		FlexContainerAll.setWidget(0, 1, FlexImgAffiche);

		//		FlexContainerAll.setWidget(1,0,btnAffiche);
		DecoratorPanel decPanel=new DecoratorPanel();
		decPanel.setPixelSize(1023, 10);
		decPanel.add(FlexContainerAll);
		initWidget(decPanel);

	}

	public Widget createFlexFiche(){

		// Create a table to layout the form options

		layout = new FlexTable();


		FlexCellFormatter cellFormatter=layout.getFlexCellFormatter();
		// Add a title to the form
		layout.setHTML(0, 0, "<b>Liste de fiche de reception de materiel</b>");
		cellFormatter.setColSpan(0, 0, 9);
		cellFormatter.setHorizontalAlignment(
				0, 0, HasHorizontalAlignment.ALIGN_CENTER);

		//		layout.setWidget(1, 1, btnAfficher);


		return layout;

	}

	public Widget asWidget() {
		return this;
	}

	public void setDataFiche(JSONArray data) {
		FlexCellFormatter cellFormatterallFiches = fiches.getFlexCellFormatter();
		fiches.setBorderWidth(0);

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
				Label lblID=new Label("Id");
				lblID.setStyleName("LabelBold");
				Label Nom=new Label("Nom");
				Label Prenom=new Label("Prenom");
				Label Marque=new Label("Marque");
				Label Modele=new Label("Modele");
				Label Panne=new Label("Panne");
				Label Etat=new Label("Etat");
				Label DateInsertion=new Label("Date d insertion");
				fiches.setCellPadding(2);
				fiches.setHTML(0, 0, lblID.getText());
				fiches.setHTML(0, 1, Nom.getText());
				fiches.setHTML(0, 2, Prenom.getText());
				fiches.setHTML(0, 3, Marque.getText());
				fiches.setHTML(0, 4, Modele.getText());
				fiches.setHTML(0, 5, Panne.getText());
				fiches.setHTML(0, 6, Etat.getText());
				fiches.setHTML(0, 7, DateInsertion.getText());
				//				fiches.setWidget(0,8,btnDelete);
//				FlexImgAffiche.setHTML(0, 0, "Afficher");
//				FlexImgAffiche.setWidget(i+1, 0, imgEyes);
//for (int j=1; j<data.size(); j++){
			
				fiches.setWidget(i, 0, new Label(jsonObject.get("id_fiche").isString().stringValue()));
				fiches.setWidget(i, 1, new Label(jsonObject.get("nom_Client").isString().stringValue()));
				fiches.setWidget(i, 2, new Label(jsonObject.get("prenom_client").isString().stringValue()));
				fiches.setWidget(i, 3, new Label(jsonObject.get("marque").isString().stringValue()));
				fiches.setWidget(i, 4, new Label(jsonObject.get("modele").isString().stringValue()));
				fiches.setWidget(i, 5, new Label(jsonObject.get("description_panne").isString().stringValue()));
				fiches.setWidget(i, 6, new Label(jsonObject.get("nom_etat").isString().stringValue()));
				fiches.setWidget(i, 7, new Label(jsonObject.get("date_creation_fiche").isString().stringValue()));
				
				fiches.setWidget(i, 8, imgBtnEdit);

				if(!colored){
					for(int k=0;k<8;k++){
						cellFormatterallFiches.setStyleName(i, k, "flexRow");
					}
					colored = true;
				}else{
					colored = false;
				}


			}
		}
//		}
	}
	public void setLblResultInsert(String resultat){
		resultLabel.setText(resultat);
	}

	public HasClickHandlers getBtnAffiche() {
		return btnAffiche;
	}

	public JSONArray getSelectedRows() {		
		JSONArray array = new JSONArray();
		String idFiche;
		for (int i = 1; i < fiches.getRowCount(); ++i) {
			CheckBox checkBox = (CheckBox)fiches.getWidget(i, 0);

			if (checkBox.getValue()) {
				idFiche=fiches.getWidget(i, 0).getElement().getFirstChild().getNodeValue();
				if(idFiche != null){
					array.set(i, new JSONString(idFiche));
				}
			}
		}

		return array;
	}


	public HasClickHandlers getList() {
		return fiches;
	}

	public HasClickHandlers getListView() {
		return FlexImgAffiche;
	}

	String selectedItem;
	
	public String getClickedRow(ClickEvent event) {
		int selectedRow = -1;
//		Element selectedElement = null;
		HTMLTable.Cell cell = fiches.getCellForEvent(event);

		if (cell != null) {
			// Suppress clicks if the user is actually selecting the 
			//  check box
			//
			if (cell.getCellIndex() > 0) {
				selectedRow = cell.getRowIndex();
				
				selectedItem=fiches.getWidget(selectedRow, 0).getElement().getFirstChild().getNodeValue();
			}
		}

		return selectedItem;
	}
	
	
	
	
	
	String TypeElement;
	public String getTypeElement(ClickEvent event) {
		int selectedRow = -1;
//		Element selectedElement = null;
		HTMLTable.Cell cell = fiches.getCellForEvent(event);

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