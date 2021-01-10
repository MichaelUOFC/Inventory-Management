package ServerPackage;

/**
 * This class calls all the classes at the back end. 
 * 
 * @author Kenechukwu Nwabueze 
 */
public class Shop {
	
	
	 // stores the suppliers 
	private SupplierList Supply; 

	 // stores the inventory 
	private Inventory Invent;

	/**
	 * Constructor that instantiates inventory and supplier list
	 * @param inventory
	 * @param Supply
	 */
	public Shop(Inventory inventory, SupplierList Suppliers) { 
		Invent = inventory; 
		Supply = Suppliers ; 
	}
	
	
	
	//printing the list of items within the inventory object
	public String printOrder() { 
		return Invent.printOrder(); 
	}
	
	
	 //listSuppliers() method lists all the suppliers within the supplier list 
	public void listSupply() { 
		Supply.listSuppliers(); 
	} 
	
	public Inventory getInventory() { 
		return Invent; 
	}
	
	
	 public void setInventory(Inventory inventory) { 
		Invent = inventory; 
	}
	

	// This decreases the amount of tools we have in the inventory
	public String decreaseTool(String name) { 
		
		if ( Invent.manageItem(name) == null ) { 
			return " Could not decrease the Quantity of the Tool. \n"; 
		} else { 
			return " Tool quantity was decreased by one unit. \n"; 
		}
		
	}
	
	// Gets the quantity of the tool within the inventory and returns a status message.
	public String getToolQuantity(String name) { 
		
		int quantity = Invent.getItemQuantity(name);
		
		if ( quantity < 0) { 
			return " Tool " + name + " not found. "; 
		} else { 
			return " tool quantity " + name + " is " + quantity + "\n";
		}		
	}
	
	
	// This searches for an tool and returns the status of its search
	public String getTool(String name) { 
		
		Tool tools = Invent.searchForItem( name ); 
		
		if (tools == null ) { 
			return " Tool " + name + " not found. " ; 
		} else { 
			return " Tool status: \n"
					+ "tool quantity: " + tools.getToolQuantity() + "\nprice of tool: " +  tools.getToolPrice() + "\n"; 
		}
	}
	
	// This searches for an tool within the inventory and returns a status message
	public String getTool(int Id) { 
		
		Tool tool = Invent.searchForItem( Id ); 
		
		if ( tool == null) { 
			return " Tool ID " + Id + " not found. "; 
		} else { 
			return " Tool status: \n"
					+ "tool quantity: " + tool.getToolQuantity() + "\ntool price: " +  tool.getToolPrice() + "\n"; 
		}
	}
	
	
	
}
