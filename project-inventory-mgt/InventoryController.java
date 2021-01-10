package ClientPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import ClientPackage.InventoryController.AddInventoryListener;
import ServerPackage.Inventory;

public class InventoryController {

	private InventoryGui view;
	private InventoryManager model;

	
	public InventoryController(InventoryGui view2, InventoryManager model) {
		this.view = view2;
		//this.view.frame.setVisible(true);
		
		this.model = model;
		
		this.view.listenForAllItems(new listingItems() );
	}

	
	class listingItems implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			view.setScrollPane(model.listTools()); 
		}
		
	}

}
