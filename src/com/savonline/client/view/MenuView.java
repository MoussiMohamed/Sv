package com.savonline.client.view;



import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;
import com.savonline.client.event.TreeItemMenuEvent;
import com.savonline.client.presenter.MenuPresenter;

public class MenuView extends Composite implements MenuPresenter.Display{
	private TreeItem fichePanelRoot,mailPanelRootTechnicien,PanelRootStatistique,PanelRootMessage,PanelRootRolePriv;
	private Tree fichePanel,PanelTechnicien,PanelStatistique,PanelMessage,RolePrivPanel;
	private Widget StatistiqueHeader,TechnicienHeader;
private Label AjoutFiche,AssignerFiche;

	public interface Images extends Tree.Resources {
		@Source("img/contactsgroup.gif")
		ImageResource contactsgroup();

		@Source("img/defaultContact.jpg")
		ImageResource defaultContact();

		@Source("img/drafts.gif")
		ImageResource drafts();

		@Source("img/filtersgroup.gif")
		ImageResource filtersgroup();

		@Source("img/inbox.gif")
		ImageResource inbox();

		@Source("img/mailgroup.gif")
		ImageResource mailgroup();

		@Source("img/sent.gif")
		ImageResource sent();

		@Source("img/templates.gif")
		ImageResource templates();

		@Source("img/trash.gif")
		ImageResource trash();

		/**
		 * Use noimage.png, which is a blank 1x1 image.
		 */
		@Source("img/noimage.png")
		ImageResource treeLeaf();
	}

	private HandlerManager eventBus;


	public MenuView(){
AjoutFiche = new Label("Ajout Fiche");
AssignerFiche=new Label("Assigner Fiche");
//DecoratorPanel decP=new DecoratorPanel();

//decP.add(onInitialize());
		initWidget(onInitialize());

	}

	

	public Widget onInitialize() {

		Images images = (Images) GWT.create(Images.class);

		// Create a new stack layout panel.
		StackLayoutPanel stackPanel = new StackLayoutPanel(Unit.EM);
		stackPanel.setPixelSize(200, 400);
		Resources resources = GWT.create(Resources.class);


		
		// Add the Mail folders.
		Widget mailHeader = createHeaderWidget("<b> Relation Client</b>"/*, imgBtnEdit*/);
		stackPanel.add(createFicheItem(images), mailHeader, 4);
		
		TechnicienHeader = createHeaderWidgetTechnicien("<b> Relation Technicien</b>"/*, imgBtnEdit*/);
		stackPanel.add(createItemTechnicien(images), TechnicienHeader, 4);

		StatistiqueHeader = createHeaderStatistique("<b> Statistique</b>"/*, imgBtnEdit*/);
		stackPanel.add(createItemStatistique(images), StatistiqueHeader, 4);
		
//		Widget MessageHeader = createHeaderMessage("<b> Message SAV</b>"/*, imgBtnEdit*/);
//		stackPanel.add(createItemMessage(images), MessageHeader, 4);
		
		Widget RolePrivHeader= createHeaderWidgetRolePrivilege("<b> Parametre</b>");
		stackPanel.add(createItemRolePrivilege(images), RolePrivHeader, 4);
		
		fichePanel.addSelectionHandler(new SelectionHandler<TreeItem>() {

			@Override
			public void onSelection(SelectionEvent<TreeItem> event) {
//				Window.alert(event.getSelectedItem().getText());
				eventBus.fireEvent(new TreeItemMenuEvent(getItemSelected()));
				

			}
		});
		
		PanelTechnicien.addSelectionHandler(new SelectionHandler<TreeItem>() {

			@Override
			public void onSelection(SelectionEvent<TreeItem> event) {
//				Window.alert(event.getSelectedItem().getText());
				eventBus.fireEvent(new TreeItemMenuEvent(getItemSelectedTechnicien()));
				

			}
		});
		
		
		PanelStatistique.addSelectionHandler(new SelectionHandler<TreeItem>() {

			@Override
			public void onSelection(SelectionEvent<TreeItem> event) {
//				Window.alert(event.getSelectedItem().getText());
				eventBus.fireEvent(new TreeItemMenuEvent(getItemSelectedStatistique()));
				

			}
		});
		
//		PanelMessage.addSelectionHandler(new SelectionHandler<TreeItem>() {
//
//			@Override
//			public void onSelection(SelectionEvent<TreeItem> event) {
////				Window.alert(event.getSelectedItem().getText());
//				eventBus.fireEvent(new TreeItemMenuEvent(getItemSelectedMessage()));
//				
//
//			}
//		});
		
		RolePrivPanel.addSelectionHandler(new SelectionHandler<TreeItem>() {

			@Override
			public void onSelection(SelectionEvent<TreeItem> event) {
//				Window.alert(event.getSelectedItem().getText());
				eventBus.fireEvent(new TreeItemMenuEvent(getItemSelectedParametre()));
				

			}
		});
		
		
		
		
		//		  
		return stackPanel;

	}
	
	
	//creation de Header widget Fiche
	private Widget createHeaderWidget(String text/*, Image image*/) {
		// Add the image and text to a horizontal panel
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.setHeight("100%");
		hPanel.setSpacing(0);
		hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
//		hPanel.add(image);
		HTML headerText = new HTML(text);
		headerText.setStyleName("cw-StackPanelHeader");
		hPanel.add(headerText);
		return new SimplePanel(hPanel);
	}


//	creation de methode Item Fiche
	private void addItem(TreeItem root, /*ImageResource image, */String label) {
		SafeHtmlBuilder sb = new SafeHtmlBuilder();
//		sb.append(SafeHtmlUtils.fromTrustedString(AbstractImagePrototype.create(
//				image).getHTML()));
		sb.appendEscaped(" ").appendEscaped(label);
		root.addItem(sb.toSafeHtml());
		
	}



	//create des items Fiche
	private Widget createFicheItem(Images images) {
		fichePanel = new Tree(images);
		fichePanelRoot = fichePanel.addTextItem("Gerer Fiche");
		String[] mailFolders = {AjoutFiche.getText(),"Modifier Fiche","Consulter Fiche", "Rechercher Fiche",AssignerFiche.getText()};
		addItem(fichePanelRoot,/* images.inbox(),*/ mailFolders[0]);
		addItem(fichePanelRoot,/* images.drafts(),*/ mailFolders[1]);
		addItem(fichePanelRoot,/* images.templates(),*/ mailFolders[2]);
		addItem(fichePanelRoot,/* images.sent(), */mailFolders[3]);
		addItem(fichePanelRoot,/* images.trash(), */mailFolders[4]);
		fichePanelRoot.setState(true);

		return fichePanel;
	}

	//creation des Items Technicien
		  private Widget createItemTechnicien(Images images) {
			    PanelTechnicien = new Tree(images);
			    
			    mailPanelRootTechnicien = PanelTechnicien.addTextItem("Gerer Technicien");
			    String[] mailFolders = {"Ajout Technicien","Modifier Technicien","Supprimer Technicien", "Consulter Technicien"};
			    addItemTechnicien(mailPanelRootTechnicien,/* images.inbox(), */mailFolders[0]);
			    addItemTechnicien(mailPanelRootTechnicien,/* images.drafts(), */mailFolders[1]);
			    addItemTechnicien(mailPanelRootTechnicien,/* images.templates(),*/ mailFolders[2]);
			    addItemTechnicien(mailPanelRootTechnicien, /*images.sent(), */mailFolders[3]);
			    mailPanelRootTechnicien.setState(true);
			    
			    return PanelTechnicien;
			  }
		  
		  //creation de Methode de Items Technicien
		  private void addItemTechnicien(TreeItem root,/* ImageResource image, */String label) {
			    SafeHtmlBuilder sb1 = new SafeHtmlBuilder();
//			    sb1.append(SafeHtmlUtils.fromTrustedString(AbstractImagePrototype.create(
//			        image).getHTML()));
			    sb1.appendEscaped(" ").appendEscaped(label);
			    root.addItem(sb1.toSafeHtml());
			  }

		  //creation de Header Widget Technicien
		  private Widget createHeaderWidgetTechnicien(String text/*, Image image*/) {
			    // Add the image and text to a horizontal panel
			    HorizontalPanel hPanel1 = new HorizontalPanel();
			    hPanel1.setHeight("100%");
			    hPanel1.setSpacing(0);
			    hPanel1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
//			    hPanel1.add(image);
			    HTML headerText1 = new HTML(text);
			    headerText1.setStyleName("cw-StackPanelHeader");
			    hPanel1.add(headerText1);
			    return new SimplePanel(hPanel1);
			  }
		  
		//creation de Header widget Statistique
			private Widget createHeaderStatistique(String text/*, Image image*/) {
				// Add the image and text to a horizontal panel
				HorizontalPanel hPanel = new HorizontalPanel();
				hPanel.setHeight("100%");
				hPanel.setSpacing(0);
				hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
//				hPanel.add(image);
				HTML headerText = new HTML(text);
				headerText.setStyleName("cw-StackPanelHeader");
				hPanel.add(headerText);
				return new SimplePanel(hPanel);
			}
			
			
//			creation de methode Item Statistique
			private void addItemStatistique(TreeItem root, /*ImageResource image,*/ String label) {
				SafeHtmlBuilder sb = new SafeHtmlBuilder();
//				sb.append(SafeHtmlUtils.fromTrustedString(AbstractImagePrototype.create(
//						image).getHTML()));
				sb.appendEscaped(" ").appendEscaped(label);
				root.addItem(sb.toSafeHtml());
				
			}



			//create des items Statistique
			private Widget createItemStatistique(Images images) {
				PanelStatistique = new Tree(images);

				PanelRootStatistique = PanelStatistique.addTextItem("Statistique");
				String[] mailFolders = {"Client","Technicien","Intervention", "Materiel","Fournisseur"};
				addItemStatistique(PanelRootStatistique, /*images.inbox(), */mailFolders[0]);
				addItemStatistique(PanelRootStatistique, /*images.drafts(), */mailFolders[1]);
				addItemStatistique(PanelRootStatistique, /*images.templates(),*/ mailFolders[2]);
				addItemStatistique(PanelRootStatistique, /*images.sent(), */mailFolders[3]);
				addItemStatistique(PanelRootStatistique, /*images.trash(),*/ mailFolders[4]);
				PanelRootStatistique.setState(true);

				return PanelStatistique;
			}
			
			
			//creation de Header widget Message
			private Widget createHeaderMessage(String text/*, Image image*/) {
				// Add the image and text to a horizontal panel
				HorizontalPanel hPanel = new HorizontalPanel();
				hPanel.setHeight("100%");
				hPanel.setSpacing(0);
				hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
//				hPanel.add(image);
				HTML headerText = new HTML(text);
				headerText.setStyleName("cw-StackPanelHeader");
				hPanel.add(headerText);
				return new SimplePanel(hPanel);
			}
			
			
//			creation de methode Item Statistique
			private void addItemMessage(TreeItem root,/* ImageResource image, */String label) {
				SafeHtmlBuilder sb = new SafeHtmlBuilder();
//				sb.append(SafeHtmlUtils.fromTrustedString(AbstractImagePrototype.create(
//						image).getHTML()));
				sb.appendEscaped(" ").appendEscaped(label);
				root.addItem(sb.toSafeHtml());
				
			}



			//create des items Statistique
			private Widget createItemMessage(Images images) {
				PanelMessage = new Tree(images);

				PanelRootMessage = PanelMessage.addTextItem("Statistique");
				String[] mailFolders = {"Nouveau Message","Boite de reception","Messages envoyes","Brouillons"};
				addItemMessage(PanelRootMessage,/* images.inbox(),*/ mailFolders[0]);
				addItemMessage(PanelRootMessage, /*images.drafts(), */mailFolders[1]);
				addItemMessage(PanelRootMessage, /*images.templates(),*/ mailFolders[2]);
				addItemMessage(PanelRootMessage,/* images.templates(), */mailFolders[3]);
				PanelRootMessage.setState(true);

				return PanelMessage;
			}
			
			//creation de Header widget Role&Privilege
			private Widget createHeaderWidgetRolePrivilege(String text/*, Image image*/) {
				// Add the image and text to a horizontal panel
				HorizontalPanel hPanel = new HorizontalPanel();
				hPanel.setHeight("100%");
				hPanel.setSpacing(0);
				hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
//				hPanel.add(image);
				HTML headerText = new HTML(text);
				headerText.setStyleName("cw-StackPanelHeader");
				hPanel.add(headerText);
				return new SimplePanel(hPanel);
			}


//			creation de methode Item Role&Privilege
			private void addItemRolePrivilege(TreeItem root, /*ImageResource image, */String label) {
				SafeHtmlBuilder sb = new SafeHtmlBuilder();
//				sb.append(SafeHtmlUtils.fromTrustedString(AbstractImagePrototype.create(
//						image).getHTML()));
				sb.appendEscaped(" ").appendEscaped(label);
				root.addItem(sb.toSafeHtml());
				
			}



			//create des items Role&Privilege
			private Widget createItemRolePrivilege(Images images) {
				RolePrivPanel = new Tree(images);
				PanelRootRolePriv = RolePrivPanel.addTextItem("Parametre");
				String[] mailFolders = {"Ajouter Privilege","Consulter Privilege","Supprimer Privilege"};
				addItemRolePrivilege(PanelRootRolePriv,/* images.inbox(),*/ mailFolders[0]);
				addItemRolePrivilege(PanelRootRolePriv,/* images.drafts(),*/ mailFolders[1]);
				addItemRolePrivilege(PanelRootRolePriv,/* images.templates(),*/ mailFolders[2]);
				PanelRootRolePriv.setState(true);

				return RolePrivPanel;
			}
			

	public TreeItem getItemSelected(){
		return fichePanel.getSelectedItem();
	}
	
	public TreeItem getItemSelectedTechnicien(){
		return PanelTechnicien.getSelectedItem();
	}
	
	public TreeItem getItemSelectedStatistique(){
		return PanelStatistique.getSelectedItem();
	}
	
	public TreeItem getItemSelectedMessage(){
		return PanelMessage.getSelectedItem();
	}
	
	public TreeItem getItemSelectedParametre(){
		return RolePrivPanel.getSelectedItem();
	}

	public Widget asWidget() {
		return this;
	}


	@Override
	public void setEventBus(HandlerManager eventBus) {
		this.eventBus = eventBus;
		
		
	}



	public Widget getStatistiqueHeader() {
		return StatistiqueHeader;
	}



	public Widget getTechnicienHeader() {
		return TechnicienHeader;
	}
	public Label getLblAjoutFiche(){
		return AjoutFiche;
	}

	public Label getLblAssignerFiche(){
		return AssignerFiche;
	}
}