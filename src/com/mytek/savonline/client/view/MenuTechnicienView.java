package com.mytek.savonline.client.view;


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
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;
import com.mytek.savonline.client.event.TreeItemMenuEvent;
import com.mytek.savonline.client.presenter.MenuTechnicienPresenter;

public class MenuTechnicienView extends Composite implements MenuTechnicienPresenter.Display{
	private TreeItem fichePanelRoot,PanelRootMessage;
	private Tree fichePanel,PanelMessage;
	
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


	public MenuTechnicienView(){


		initWidget(onInitialize());

	}

	public Widget onInitialize() {

		Images images = (Images) GWT.create(Images.class);

		// Create a new stack layout panel.
		StackLayoutPanel stackPanel = new StackLayoutPanel(Unit.EM);

		stackPanel.setPixelSize(200, 400);
		Resources resources = GWT.create(Resources.class);

		
		// Add the Mail folders.
		Widget clientHeader = createHeaderWidget("<b> Relation Client</b>"/*, imgBtnEdit*/);
		stackPanel.add(createFicheItem(images), clientHeader, 4);
		
		Widget MessageHeader = createHeaderMessage("<b> Message SAV</b>"/*, imgBtnEdit*/);
		stackPanel.add(createItemMessage(images), MessageHeader, 4);
		
		fichePanel.addSelectionHandler(new SelectionHandler<TreeItem>() {

			@Override
			public void onSelection(SelectionEvent<TreeItem> event) {

				eventBus.fireEvent(new TreeItemMenuEvent(getItemSelected()));
				

			}
		});
		

		PanelMessage.addSelectionHandler(new SelectionHandler<TreeItem>() {

			@Override
			public void onSelection(SelectionEvent<TreeItem> event) {

				eventBus.fireEvent(new TreeItemMenuEvent(getItemSelectedMessage()));
				

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

		fichePanelRoot = fichePanel.addItem("Gerer Fiche");
		String[] mailFolders = {"Ajout Fiche","Modifier Fiche","Consulter Fiche", "Rechercher Fiche","Assigner Fiche"};
		addItem(fichePanelRoot,/* images.inbox(),*/ mailFolders[0]);
		addItem(fichePanelRoot,/* images.drafts(),*/ mailFolders[1]);
		addItem(fichePanelRoot,/* images.templates(),*/ mailFolders[2]);
		addItem(fichePanelRoot,/* images.sent(), */mailFolders[3]);
		addItem(fichePanelRoot,/* images.trash(), */mailFolders[4]);
		fichePanelRoot.setState(true);

		return fichePanel;
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

			//create des items Message
			private Widget createItemMessage(Images images) {
				PanelMessage = new Tree(images);

				PanelRootMessage = PanelMessage.addItem("Statistique");
				String[] mailFolders = {"Nouveau Message","Boite de reception","Messages envoyes","Brouillons"};
				addItemMessage(PanelRootMessage,/* images.inbox(),*/ mailFolders[0]);
				addItemMessage(PanelRootMessage, /*images.drafts(), */mailFolders[1]);
				addItemMessage(PanelRootMessage, /*images.templates(),*/ mailFolders[2]);
				addItemMessage(PanelRootMessage,/* images.templates(), */mailFolders[3]);
				PanelRootMessage.setState(true);

				return PanelMessage;
			}
			

	public TreeItem getItemSelected(){
		return fichePanel.getSelectedItem();
	}
	
	
	public TreeItem getItemSelectedMessage(){
		return PanelMessage.getSelectedItem();
	}
	

	public Widget asWidget() {
		return this;
	}


	@Override
	public void setEventBus(HandlerManager eventBus) {
		this.eventBus = eventBus;
		
		
	}


}