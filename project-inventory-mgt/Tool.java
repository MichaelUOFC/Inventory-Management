package ServerPackage;

import java.sql.SQLException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.util.ArrayList; 
import java.util.Random; 
import java.util.Calendar;
import java.io.FileNotFoundException;

/**
 * This class  stores items as  Tool price,id,  current quantity and name and manages the quantity.  
 * @author Kenechukwu Nwabueze
 */
public class Tool {
	
	//This stores the tool name
	private String toolName; 
	

	//This stores the identification number
	private int toolId; 
	
	
	//This stores the tool price
	private double toolprice; 
	
	// this stores the tool quantity
	private int toolQuantity; 
	
	// This stores sthe suppliers info
	private Supplier Thesupplier; 
	
	private int supplierId;

	public Statement statement;
	public Connection jdbc_connection;


	//This stores the default order quantity
	private static final int ORDERQUANTITY = 40; 
	public String databaseName = "InventoryDB", tableName = "ToolTable", dataFile = "items.txt";
	
	
	// this stores all the information about the tool and takes in 5 arguments
	public Tool(int Id, String name, int quantity, double price, int supId) {
		
		toolId = Id; 
		toolName = name; 
		toolQuantity = quantity; 
		toolprice = price; 
		supplierId = supId; 
		
	}
	
//	public Tool(int Id, String name, int quantity, double price, Supplier supplier) {
//		
//		toolId = Id; 
//		toolName = name; 
//		toolQuantity = quantity; 
//		toolprice = price; 
//		Thesupplier = supplier; 
//		
//	}

	//This decreases the quantity of the tool and checks if the quantity falls below the default quantity
	public boolean decreaseToolQuantity(order O) { 
		
		if (toolQuantity > 0) { 
			
			toolQuantity--; 
			
			if (toolQuantity < ORDERQUANTITY) { 
				
				// generates an order when the quantity is below  40 units
				O.addOrderLine( generateOrderLine() ); 
				toolQuantity += (50 - toolQuantity);
			}
			
			return true; 
	
		} else { 
			return false; 
		}
	}
	
	// This holds information regarding how many items were ordered
	public orderLine generateOrderLine() { 
		orderLine ol; 
		
		if( getToolQuantity() < ORDERQUANTITY ) { 
			
			ol = new orderLine(this); 
			return ol;
			
		} else { 
			return null;
		}
	}
	
	// This gets the identification number of the tool
	public int getToolId() { 
		return toolId;
	}
	
	//This gets the name of the tool
	public String getToolName() { 
		return toolName; 
	}
	
	//This gets the quantity of the tool
	public int getToolQuantity() { 
		return toolQuantity; 
	}
	
	//This gets the price of the tool
	public double getToolPrice() { 
		return toolprice; 
	}
	
	//This gets the supplier info
	public  Supplier getSupplier() { 
		return Thesupplier; 
	}
	
	//This sets the name of the tool
	public void setToolName(String name) { 
		toolName = name; 
	}
	
	//This sets the identification number of the tool
	public void setToolId( int Id) { 
		toolId = Id; 
	}

	public int getSupplierID() {
		// TODO Auto-generated method stub
		return supplierId;
	}

	public String toString() {
		
		return (toolId + " "+ toolName+" "+ toolQuantity+" "+ toolprice+" "+supplierId);
	}

	public void setToolQuantity(int itemQuantity) {
		this.toolQuantity = toolQuantity;
	

	String sql = "UPDATE " + tableName +
			" SET Quantity = " + toolQuantity + " " +
			" WHERE ToolID = '" + toolId + "'";
	
	try {
		statement = jdbc_connection.createStatement();

		statement.executeUpdate(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
}
