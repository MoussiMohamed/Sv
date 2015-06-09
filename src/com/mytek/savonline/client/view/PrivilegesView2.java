package com.mytek.savonline.client.view;

import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mytek.savonline.client.presenter.PrivilegesPresenter2;

  public class PrivilegesView2 extends Composite implements PrivilegesPresenter2.Display {
  private final Button deleteButton,editButton;
  private final Label lblnotification;
  private final FlexTable FTable;
  public PrivilegesView2() {
    DecoratorPanel contentTableDecorator = new DecoratorPanel();
    initWidget(contentTableDecorator);
    lblnotification=new Label("");
    HorizontalPanel hPanel=new HorizontalPanel();
    deleteButton=new Button("Supprimer");
    editButton=new Button("Modifier");
    hPanel.add(deleteButton);
    hPanel.add(editButton);
    
    VerticalPanel vPanel = new VerticalPanel();
    vPanel.add(hPanel);
    FTable=new FlexTable();
    vPanel.add(FTable);
    contentTableDecorator.add(vPanel);
    /*
    HorizontalPanel hPanel1=new HorizontalPanel();
    VerticalPanel vPanel1=new VerticalPanel();
    contentTableDecorator.setWidth("100%");
    contentTableDecorator.setWidth("18em");
    HorizontalPanel hPanel2 = new HorizontalPanel();
    hPanel2.setBorderWidth(0);
    hPanel2.setSpacing(0);
    hPanel2.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
    addButton = new Button("Ajouter");
    cancelButton=new Button("Annuler");
    txtPrivelege=new TextBox();
    
    hPanel2.add(lblAddPriv);
    hPanel2.add(txtPrivelege);
    //hPanel2.add(lblResult);
    hPanel1.add(addButton);
    hPanel1.add(cancelButton);
    hPanel1.add(lblResult);
    vPanel1.add(hPanel2);
    vPanel1.add(hPanel1);*/
    contentTableDecorator.add(vPanel);
  }
  public void setFTable(String[] data) {
	  //  FTable.removeAllRows();
	    
	    for (int i = 0; i < data.length; ++i) {
	    	FTable.setWidget(i, 0, new CheckBox());
	    	//FTable.setText(i, 1, data.length);
	    }
	  }
  public Widget asWidget() {
    return this;
  }
public HasClickHandlers geteditButton(){
	return editButton;
}
public HasClickHandlers getdeleteButton(){
	return deleteButton;
}


}
