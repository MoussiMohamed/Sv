package com.savonline.client.view;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.*;
import com.savonline.client.presenter.PrivilegesPresenter;
import com.savonline.client.presenter.RolesPresenter;

public class RolesView extends Composite implements RolesPresenter.Display{
	private final Button addButton;
	  private final Button cancelButton;
	  private TextBox txtRole;
	  final Label lblresultat,lblText;
	  private final FlexTable FlexData;
	  private String[] data;
	  //private final FlexTable contentTable;
	public RolesView(){
		FlexData=new FlexTable();
		VerticalPanel vPanel1 = new VerticalPanel();
		VerticalPanel vPanel2 =new VerticalPanel();
		DecoratorPanel dPanel =new DecoratorPanel();
	    initWidget(dPanel);
	    dPanel.setWidth("100%");
	    dPanel.setWidth("18em");
	    txtRole=new TextBox();
	    lblresultat=new Label("...");
	    lblText=new Label("Taper un role ");
	    // Create the menu
	    //
	    
	    HorizontalPanel hPanel = new HorizontalPanel();
	    hPanel.setBorderWidth(0);
	    hPanel.setSpacing(0);
	    hPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
	    addButton = new Button("Ajouter");
	    vPanel1.add(lblText);
	    vPanel1.add(addButton);
	    vPanel2.add(txtRole);
	    cancelButton = new Button("Annuler");
	    vPanel2.add(cancelButton);
	    hPanel.add(vPanel1);
	    hPanel.add(vPanel2);
	    hPanel.add(lblresultat);
	    dPanel.add(hPanel);
	    
	    
	    // Create the contacts list
	    //
	    
	    
	    //contentTable.setWidget(1, 0, data);
	    
	    //contentTableDecorator.add(contentTable);
	  }

	  public Widget asWidget() {
	    return this;
	  }
	public HasValue<String> getTextRole(){
		return txtRole;
	}
	public HasClickHandlers getAddButton() {
		return addButton;
	}

	public HasClickHandlers getCancelButton() {
		return cancelButton;
	}

	public void setLblResult(String resultat){
		lblresultat.setText(resultat);
	}
	public void setFlexData(String[] data){
		for( int i =0; i<data.length;i++){
			
		
		FlexData.setText(i, 1, data.toString());
	}
		}
	/*public HasClickHandlers getList() {
	    return data;
	  }*/
	 /*public void setData(List<String> data) {
		    PrivilegeTable.removeAllRows();
		    
		    for (int i = 0; i < data.size(); ++i) {
		    	PrivilegeTable.setWidget(i, 0, new CheckBox());
		    	PrivilegeTable.setText(i, 1, data.get(i));
		    }
		  }*/

	@Override
	public List<Integer> getSelectedRows() {
		// TODO Auto-generated method stub
		return null;
	}
		  public void setText(String data){
			  txtRole.setText(data);
		  }
		  /*public int getClickedRow(ClickEvent event) {
		    int selectedRow = -1;
		    HTMLTable.Cell cell = PrivilegeTable.getCellForEvent(event);
		    
		    if (cell != null) {
		      // Suppress clicks if the user is actually selecting the 
		      //  check box
		      //
		      if (cell.getCellIndex() > 0) {
		        selectedRow = cell.getRowIndex();
		      }
		    }
		    
		    return selectedRow;
		  }*/
		  
		/*  public List<Integer> getSelectedRows() {
		    List<Integer> selectedRows = new ArrayList<Integer>();
		    
		    for (int i = 0; i < PrivilegeTable.getRowCount(); ++i) {
		      CheckBox checkBox = (CheckBox)PrivilegeTable.getWidget(i, 0);
		      if (checkBox.getValue()) {
		        selectedRows.add(i);
		      }
		    }
		    
		    return selectedRows;
		  }*/

}


