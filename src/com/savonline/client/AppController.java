package com.savonline.client;


import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.savonline.client.event.*;
import com.savonline.client.presenter.AddEmployePresenter;
import com.savonline.client.presenter.AddFichePresenter;
import com.savonline.client.presenter.AddPrivilegePresenter;
import com.savonline.client.presenter.AffichFichePresenter;
import com.savonline.client.presenter.AffichPrivilegePresenter;
import com.savonline.client.presenter.AuthentificationPresenter;
import com.savonline.client.presenter.DisplayEmployePresenter;
import com.savonline.client.presenter.EditFichePresenter;
import com.savonline.client.presenter.MenuPresenter;
import com.savonline.client.presenter.Presenter;
import com.savonline.client.presenter.RolesPresenter;
import com.savonline.client.presenter.TopMenuPresenter;
import com.savonline.client.view.AddEmployeView;
import com.savonline.client.view.AddFicheView;
import com.savonline.client.view.AddPrivilegeView;
import com.savonline.client.view.AffichPrivilegeView;
import com.savonline.client.view.AfficheFicheView;
import com.savonline.client.view.AuthentificationView;
import com.savonline.client.view.DisplayEmployeView;
import com.savonline.client.view.EditFicheView;
import com.savonline.client.view.MenuView;
import com.savonline.client.view.RolesView;
import com.savonline.client.view.TopMenuView;
public class AppController implements Presenter, ValueChangeHandler<String> {
	private final HandlerManager eventBus;
	private final RequestBuilder requestBuilder;

	private HasWidgets top;
	private HasWidgets left;
	private HasWidgets container;

	public AppController( HandlerManager eventBus, RequestBuilder requestBuilder) {
		this.eventBus = eventBus;
		this.requestBuilder = requestBuilder;
		
		bind();
	}

	private void doEditFiche(String id,String typeElement) {
if (typeElement.equalsIgnoreCase("Editer")){
	History.newItem("editFiche", false);
}
else{
	History.newItem("detailFiche", false);
}
		Presenter presenter = new EditFichePresenter(eventBus,requestBuilder, new EditFicheView(), id, typeElement);
		presenter.go(top,left,container);
	}
	
	private void bind() {
		History.addValueChangeHandler(this);

		/*eventBus.addHandler(AddContactEvent.TYPE,
        new AddContactEventHandler() {
          public void onAddContact(AddContactEvent event) {
         // doAddNewContact();
          }
        });  */
		eventBus.addHandler(AddContactEvent.TYPE,
				new AddContactEventHandler() {
			public void onAddContact(AddContactEvent event) {
				// doAddNewContact();
			}
		}); 
		eventBus.addHandler(VerifGarantieFicheEvent.TYPE,
				new VerifGarantieFicheEventHandler() {
			public void onVerifGarantieMateriel(VerifGarantieFicheEvent event) {
				
			}
		}); 
		
		eventBus.addHandler(EditFicheEvent.TYPE,
				new EditFicheEventHandler() {
			public void onEditFiche(EditFicheEvent event) {

				doEditFiche(event.getId(),event.getTypeElement());
			}
		});
		
		
		eventBus.addHandler(EditePrivilegeEvent.TYPE,
				new EditePrivilegeEventHandler() {
			public void oneditPriv(EditePrivilegeEvent event) {
				History.newItem("delete");
			}
		}); 

		eventBus.addHandler(AddEmployeEvent.TYPE,
			new AddEmployeEventHandler() {
				public void onAddEmploye(AddEmployeEvent event) {
				History.newItem("displayEmploye");	
			}
		});
		
		eventBus.addHandler(TreeItemMenuEvent.TYPE,
				new TreeItemMenuEventHandler() {
			public void onClickItem(TreeItemMenuEvent event) {
				String a=event.getId().getTree().getSelectedItem().getText().trim();
				if (a.equalsIgnoreCase("Ajout Fiche")){
					History.newItem("AddNewFiche");
				}
				else if (a.equalsIgnoreCase("Ajout Technicien")){
					History.newItem("newTechnicien");
				}
				else if (a.equalsIgnoreCase("Consulter Technicien")){
					History.newItem("displayEmploye");
				}
				else if (a.equalsIgnoreCase("Modifier Technicien")){
					History.newItem("displayEmploye");
				}
				else if (a.equalsIgnoreCase("Supprimer Technicien")){
					History.newItem("displayEmploye");
				}
				else if (a.equalsIgnoreCase("Modifier Fiche")){
					History.newItem("list");
				}
				else if (a.equalsIgnoreCase("Consulter Fiche")){
					History.newItem("list");
				}
				else if (a.equalsIgnoreCase("Rechercher Fiche")){
					History.newItem("list");
				}
				else if (a.equalsIgnoreCase("Fournisseur")){
					
					History.newItem("list");
				}
				else if (a.equalsIgnoreCase("Ajouter Privilege")){
					
					History.newItem("addPriv");
				}
				
				else if (a.equalsIgnoreCase("Assigner Fiche")){
					
					History.newItem("list");
				}
			}
		});

		eventBus.addHandler(AddFicheEvent.TYPE,
				new AddFicheEventHandler() {
			public void onAddNewRecepMateriel(AddFicheEvent event) {
				History.newItem("list");
			}
		});

		eventBus.addHandler(AuthentifEvent.TYPE,
				new AuthentifEventHandler() {
			public void onAuthentif(AuthentifEvent event) {

					History.newItem("list");

			}
		});
		
		eventBus.addHandler(AddPrivilegeEvent.TYPE,
				new AddPrivilegeEventHandler() {
			public void onAddPrivilege(AddPrivilegeEvent event) {

					History.newItem("ViewPrivilege");

			}
		});

		eventBus.addHandler(DetailFicheEvent.TYPE,
				new DetailFicheEventHandler() {
			public void onDetailFiche(DetailFicheEvent event) {
//				Window.alert(event.getId());
			//	doDetailFiche(event.getId());
			}
		});
	}

	/*private void doAddNewContact() {
	    History.newItem("hello");
	  }*/

	public void go(final HasWidgets top, final HasWidgets left, final HasWidgets container ) {
		this.top = top;
		this.left = left;
		this.container = container;

		if ("".equals(History.getToken())) {
			
			History.newItem("authentif");
		}
		
		
		else {
			History.fireCurrentHistoryState();
		}
	}

	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();

		if (token != null) {
			
			Presenter presenter = null;
			Presenter presenterLeft = null;
			Presenter presenterTop = null;
			presenterLeft = new MenuPresenter( eventBus, requestBuilder, new MenuView());
			presenterTop = new TopMenuPresenter(eventBus, requestBuilder, new TopMenuView());
			if (token.equals("authentif")) {				
				presenter = new AuthentificationPresenter(eventBus, requestBuilder, new AuthentificationView());

			}
			
			else if (token.equals("list")) {
				presenter = new AffichFichePresenter(eventBus, requestBuilder, new AfficheFicheView());

			}

			else if (token.equals("ViewPrivilege")) {
				presenter = new AffichPrivilegePresenter(eventBus, requestBuilder, new AffichPrivilegeView());

			}

			else if (token.equals("displayEmploye")){
				presenter = new DisplayEmployePresenter(eventBus, requestBuilder, new DisplayEmployeView());
			}
			
			else if (token.equals("addPriv")){
				presenter = new AddPrivilegePresenter(eventBus, requestBuilder, new AddPrivilegeView());
			} 
			
			/*if (token.equals("list")) {
          presenter = new PrivilegesPresenter( eventBus, new PrivilegesView());
        }*/
			/*if (token.equals("list")) {
          presenter = new RolesPresenter( eventBus, new RolesView());
        }
			 */
			else if (token.equals("delete")) {

				presenter = new RolesPresenter(eventBus,requestBuilder, new RolesView());
			}
			
			else if (token.equals("newTechnicien")) {

				presenter = new AddEmployePresenter(eventBus,requestBuilder, new AddEmployeView());
			}

			else if (token.equals("AddNewFiche")) {

				presenter = new AddFichePresenter(eventBus,requestBuilder, new AddFicheView());
			}


			if (presenter != null) {
				presenterTop.go(top,left,container);
				presenterLeft.go(top,left,container);
				presenter.go(top,left,container);

			}
		}
	} 
}
