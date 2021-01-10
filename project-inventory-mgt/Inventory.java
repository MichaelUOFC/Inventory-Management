package ServerPackage;

import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList; 

/**
 * This stores all the retailshop items and orders. 
 * 
 * @author Kenechukwu Nwabueze
 */

public class Inventory {
	
	//This stores the order
	private order myOrder; 
	

	//This stores the tool in an array list
	private ArrayList <Tool> ItemList;
	
	//This gets a list of all the items
	public ArrayList <Tool> getItemList() { 
		return ItemList; 
	}

	// This initializes tool list and order
	public Inventory(ArrayList <Tool> tools) {
		ItemList = tools; 
		myOrder = new order(); 
		System.out.println("I am not an empty inventory");
	} 	
	public Inventory(){
		ItemList = null;
		System.out.println("I like pepper soup");
	}
	
	
	//This sets a list of all the items
	public void setItemList(ArrayList <Tool> tools) {
		ItemList = tools; 
	}
	
	// This method manages all the items and places an
	// order when it falls below a certain quantity
	public Tool manageItem ( String name) { 
				
		Tool myItems = decreaseItem(name, myOrder); 
		
		if ( myItems != null ) { 
			placeOrder(myItems); 
		} 
		return myItems; 
	}

	
	
	//This creates an orderline to represent to generate orders
	public void placeOrder (Tool theItem) { 
		
		orderLine order = theItem.generateOrderLine(); 
		
		if(order != null) { 

			myOrder.addOrderLine(order); 
			
		}
	}
	
	//This gets the items quantity as requested by the user
	public int getItemQuantity (String name) { 
		
		Tool myItem = searchForItem(name); 
		
		if(myItem == null) { 
			return -1; 
		}else { 
			return myItem.getToolQuantity(); 
		}
	}
	
	// This searches for an tool within the tool list by using the name
	public Tool searchForItem (String name) { 
	
		for (Tool i: ItemList) { 
			
			if( i.getToolName().contentEquals(name)) {
				return i;	
			}			
		}
		return null; 	
	}




	// this decerases the quantity of the tool and places an order
	private Tool decreaseItem (String name, order myOrder) { 
		
		Tool myItem = searchForItem(name); 
		
		if ( myItem == null) { 
			return null; 
		}
		
		if ( myItem.decreaseToolQuantity(myOrder) == true ) { 
			return myItem; 
		}
		return null; 
	}
	
	

	
//This searches for an tool using the tool ID
	public Tool searchForItem (int Id) { 
		
		for (Tool i: ItemList) { 
			
			if( i.getToolId() == Id) {
				return i;	
			}			
		}
		return null; 	
	}
// This prints out the list of items
	public String printOrder() {
		
		String list = ""; 
		
		for(Tool i: ItemList) { 
			
			System.out.println( i.getToolName());
	
			list += i.getToolName() + "\n"; 
		}
		
		return list;
	}

	public static void main(String[] arg){
		Inventory emptyInventory = new Inventory();
		//Inventory notempInventory = new Inventory(new ArrayList<Tool>());
	}
	
	

}
