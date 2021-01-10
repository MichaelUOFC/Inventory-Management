package ServerPackage;

import java.util.ArrayList;

/**
 * This class stores all the supplier information
 * @author Kenechukwu Nwabueze 
 */

public class Supplier {
	
	// Stores the name of the supplier
	private String supplierName; 

	// This stores all the items the supplier deals in
	private ArrayList<Tool> supplierItems; 
	
	// Stores the suppliers address
	private String supplierAddress; 
	
	// This stores the suppliers ID number
	private int supplierId; 
	
	// This stores the name of the sales contact personnel
	private String salesContact; 
	
	

	public Supplier(int id, String name, String address, String sales) { 
	
		supplierId = id;
		supplierName = name; 
		supplierAddress = address; 
		salesContact = sales; 
		supplierItems = new ArrayList<Tool>(); 
	}

	//This sets the sales contact personnel
	public void setSalesContact( String contact) { 
		salesContact = contact; 
	}
	
	//This sets the supplier identification number
	public void setSupplierId( int id) { 
		supplierId = id; 
	}


	// This sets the supplier name
	public void setSupplierName( String name) { 
		supplierName = name; 
	}
	
	// This sets the supplier address
	public void setSupplierAddress( String address) {
		supplierAddress = address; 
	}
	
	// this gets the supplier ID
	public int getSupId() { 
		return supplierId; 
	}
	
	// This gets the supplier name
	public String getSupplierName() { 
		return supplierName; 
	}
	
	//This gets the supplier address
	public String getSupplierAddress() { 
		return supplierAddress; 
	}
	
	// This gets the sales contact personnel
	public String getSalesContact() { 
		return salesContact; 
	}
	

	// This gets all the suppliers items in a list
	public ArrayList<Tool> getItemList() {
		return supplierItems; 
	}


	// this adds an tool to the supplier
	public void addSupplierItem (Tool tool) { 
		supplierItems.add(tool); 
	}
	
	

}
