package com.mytek.savonline.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mytek.savonline.client.presenter.PrivilegesPresenter;

  public class PrivilegesView extends Composite implements PrivilegesPresenter.Display {
  private final Button addButton,cancelButton,editButton;
  private final TextBox txtPrivelege;
  private final Label lblAddPriv,lblResult;

  public PrivilegesView() {
    DecoratorPanel contentTableDecorator = new DecoratorPanel();
    initWidget(contentTableDecorator);
    lblAddPriv=new Label("Taper un privilege");
    lblResult=new Label("1");
    HorizontalPanel hPanel1=new HorizontalPanel();
    VerticalPanel vPanel1=new VerticalPanel();
    HorizontalPanel hPanel3=new HorizontalPanel();
    HorizontalPanel hPanel4=new HorizontalPanel();
    contentTableDecorator.setWidth("100%");
    contentTableDecorator.setWidth("18em");
    HorizontalPanel hPanel2 = new HorizontalPanel();
    hPanel2.setBorderWidth(0);
    hPanel2.setSpacing(0);
    hPanel2.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
    addButton = new Button("Ajouter");
    cancelButton=new Button("Annuler");
    editButton=new Button("Modifier");
    txtPrivelege=new TextBox();
    hPanel3.add(editButton);
    hPanel2.add(lblAddPriv);
    hPanel2.add(txtPrivelege);
    //hPanel2.add(lblResult);
    hPanel1.add(addButton);
    hPanel1.add(cancelButton);
    hPanel1.add(lblResult);
    vPanel1.add(hPanel2);
    vPanel1.add(hPanel1);
    hPanel4.add(vPanel1);
    hPanel4.add(hPanel3);
    contentTableDecorator.add(hPanel4);
    //contentTableDecorator.add(editButton);
    
  }

  public Widget asWidget() {
    return this;
  }
public HasValue<String> getTextPriv(){
	return txtPrivelege;
}
public HasClickHandlers getAddButton() {
	return addButton;
}

public HasClickHandlers getCancelButton() {
	return cancelButton;
}

public void setLblResult(String resultat){
	lblResult.setText(resultat);
}
public void setTextPriv(){
	txtPrivelege.setText("");
}
public HasClickHandlers geteditButton(){
	return editButton;
}
}
