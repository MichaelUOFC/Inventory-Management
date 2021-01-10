package ServerPackage;

/**
 * This class records the order information for each tool 
 * 
 * @author Kenechukwu Nwabueze
 */
public class orderLine {
	
	//This describes the tool to be ordered.
	private String description; 
	
	// This lloks at the quantity of items ordered
	private int orderedQ; 
	
	//This tracks the supplier name
	private String SupplierName; 
	

	//This sets the order of the description , ordered quantity and supplier name
	public orderLine( Tool it) { 
	//	setDescription(it.getToolName());
	//	setOrderedQ(50 - it.getItemQuantity()); // the amount to order 
	//	setSupplierName(it.getSupplier().getSupplierName()); 
	}

	// This gets the order description
	public String getDescription() {
		return description;
	}

	// This sets the order description
	public void setDescription(String description) {
		this.description = description;
	}

	//This gets the quantity of tool ordered
	public int getOrderedQ() {
		return orderedQ;
	}

	//This sets the quantity of tool ordered.
	public void setOrderedQ(int orderedQ) {
		this.orderedQ = orderedQ;
	}

	//This gets the supplier name
	public String getSupplierName() {
		return SupplierName;
	}
	
	// This sets the supplier name
	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}

}
