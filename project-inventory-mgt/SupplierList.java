package ServerPackage;

import java.util.ArrayList;

/** 
 * This class stores the list of all available suppliers
 * 
 * @author Kenechukwu Nwabueze
 */

public class SupplierList {
	
	//this variable stores all available suppliers in an array list
	private ArrayList <Supplier> suppliers; 
	
	//This lists all the available suppliers
	public String listSuppliers() {
		
		String line = ""; 
		
		for(Supplier supply: suppliers) { 
			line += supply.getSupplierName() + "\n"; 
		}
		
		return line; 
	}

	//creating a constructor to initialise the supplier list
	public SupplierList(ArrayList <Supplier> supplyList) { 
		suppliers = supplyList; 
	}

	

	
}
