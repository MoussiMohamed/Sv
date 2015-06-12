package com.savonline.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.ListBox;

public class Testo extends Composite {

	public Testo() {
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		
		DockPanel dockPanel = new DockPanel();
		absolutePanel.add(dockPanel, 169, 10);
		dockPanel.setSize("100px", "100px");
		
		ListBox listBox = new ListBox();
		dockPanel.add(listBox, DockPanel.WEST);
		listBox.setVisibleItemCount(5);
	}
}
