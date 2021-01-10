package ClientPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import ServerPackage.Tool;
import ServerPackage.order;

// Pre-Project Exercise 

// This program allows you to create and manage a store inventory database.
// It creates a database and datatable, then populates that table with tools from
// items.txt.
public class InventoryManager {
	
	public Connection jdbc_connection;
	public Statement statement;
	public String databaseName = "InventoryDB", tableName = "ToolTable", dataFile = "items.txt";
	
	// Students should configure these variables for their own MySQL environment
	// If you have not created your first database in mySQL yet, you can leave the 
	// "[DATABASE NAME]" blank to get a connection and create one with the createDB() method.
	public String connectionInfo = "jdbc:mysql://localhost:3306/inventorydb",  
				  login          = "root",
				  password       = "Cnnisthebest1@ng";

	public InventoryManager()
	{
		try{
			// If this throws an error, make sure you have added the mySQL connector JAR to the project
			Class.forName("com.mysql.jdbc.Driver");
			
			// If this fails make sure your connectionInfo and login/password are correct
			jdbc_connection = DriverManager.getConnection(connectionInfo, login, password);
			System.out.println("Connected to: " + connectionInfo + "\n");
		}
		catch(SQLException e) { e.printStackTrace(); }
		catch(Exception e) { e.printStackTrace(); }
	}
	
	
	public void createTable()
	{
		
		String sql = "CREATE TABLE " + tableName + "(" +
				     "ID INT(4) NOT NULL, " +
				     "TOOLNAME VARCHAR(20) NOT NULL, " + 
				     "QUANTITY INT(4) NOT NULL, " + 
				     "PRICE DOUBLE(5,2) NOT NULL, " + 
				     "SUPPLIERID INT(4) NOT NULL, " + 
				     "PRIMARY KEY ( id ))";
		try{
			statement = jdbc_connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Created Table " + tableName);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	// Removes the data table from the database (and all the data held within it!)
	public void removeTable()
	{
		String sql = "DROP TABLE "  + tableName;
		try{
			statement = jdbc_connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Removed Table " + tableName);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	// Fills the data table with all the tools from the text file 'items.txt' if found
	public void fillTable()
	{
		try{
			Scanner sc = new Scanner(new FileReader(dataFile));
			while(sc.hasNext())
			{
				String toolInfo[] = sc.nextLine().split(";");
				addItem( new Tool( Integer.parseInt(toolInfo[0]),
						                            toolInfo[1],
						           Integer.parseInt(toolInfo[2]),
						         Double.parseDouble(toolInfo[3]),
						           Integer.parseInt(toolInfo[4])) );
			}
			sc.close();
		}
		catch(FileNotFoundException e)
		{
			System.err.println("File " + dataFile + " Not Found!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	// Add a tool to the database table
	public void addItem(Tool tool)
	{
		String sql = "INSERT INTO " + tableName +
				" VALUES ( " + tool.getToolId() + ", '" + 
				tool.getToolName() + "', " + 
				tool.getToolQuantity() + ", " + 
				tool.getToolPrice() + ", " + 
				tool.getSupplierID() + ");";
		try{
			statement = jdbc_connection.createStatement();
			statement.executeUpdate(sql);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	// This method should search the database table for a tool matching the toolID parameter and return that tool.
	// It should return null if no tools matching that ID are found.
	public ArrayList<Tool> searchTool(int toolID)
	{
		String sql = "SELECT * FROM " + tableName + " WHERE ID like" +"'%"+ toolID +"%'" ;
		ResultSet tool;
		
		ArrayList <Tool> searchTool = new ArrayList<Tool>();
		try {
			statement = jdbc_connection.createStatement();
			tool = statement.executeQuery(sql);
			if(tool.next())
			{
				searchTool.add(new Tool(tool.getInt("ID"),
								tool.getString("TOOLNAME"), 
								tool.getInt("QUANTITY"), 
								tool.getDouble("PRICE"), 
								tool.getInt("SUPPLIERID")));
			}
		
		} catch (SQLException e) { e.printStackTrace(); }
		
		return searchTool ;
	}

	
	public ArrayList<Tool> searchToolName(Tool tool_name)
	{
		String sql = "SELECT * FROM " + tableName + " WHERE ID like" +"'%"+ tool_name +"%'" ;
		ResultSet tools;
		ArrayList <Tool> searchToolName = new ArrayList<Tool>();
		try {
			statement = jdbc_connection.createStatement();
			tools = statement.executeQuery(sql);
			if(tools.next())
			{
				searchToolName.add(new Tool(tools.getInt("ID"),
								tools.getString("TOOLNAME"), 
								tools.getInt("QUANTITY"), 
								tools.getDouble("PRICE"), 
								tools.getInt("SUPPLIERID")));
			
		
		}
			tools.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return searchToolName;
}
	
     
	
	public Tool searchForTool(int toolID)
	{
		String sql = "SELECT * FROM " + tableName + " WHERE ID like" +"'%"+ toolID +"%'" ;
		ResultSet tool;
		
		
		try {
			statement = jdbc_connection.createStatement();
			tool = statement.executeQuery(sql);
			if(tool.next())
			{
				return new Tool(tool.getInt("ID"),
								tool.getString("TOOLNAME"), 
								tool.getInt("QUANTITY"), 
								tool.getDouble("PRICE"), 
								tool.getInt("SUPPLIERID"));
			}
		
		} catch (SQLException e) { e.printStackTrace(); }
		
		return null ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Prints all the items in the database to console
	public void updateTable()
	{
		try {
			String sql = "SELECT * FROM " + tableName;
			statement = jdbc_connection.createStatement();
			ResultSet tools = statement.executeQuery(sql);
			System.out.println("Tools:");
			while(tools.next())
			{
				System.out.println(tools.getInt("ID") + " " + 
								   tools.getString("TOOLNAME") + " " + 
								   tools.getInt("QUANTITY") + " " + 
								   tools.getDouble("PRICE") + " " + 
								   tools.getInt("SUPPLIERID"));
			}
			tools.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// list all the items in the database - to be used for GUI
	public ArrayList<Tool> listTools()
	{
		ArrayList<Tool> toolList = new ArrayList<Tool>();
		try {
			String sql = "SELECT * FROM " + tableName;
			statement = jdbc_connection.createStatement();
			ResultSet tools = statement.executeQuery(sql);
			System.out.println("Tools:");
			while(tools.next())
			{
				toolList.add(new Tool(tools.getInt("ToolID"), 
									tools.getString("TName"),
									tools.getInt("Quantity"),
									tools.getDouble("Price"),
									tools.getInt("SupplierID")));
			}
			tools.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return toolList;
	}
	// Prints all the items in the database to console
		public void printTable()
		{
			try {
				String sql = "SELECT * FROM " + tableName;
				statement = jdbc_connection.createStatement();
				ResultSet tools = statement.executeQuery(sql);
				System.out.println("Tools:");
				while(tools.next())
				{
					System.out.println(tools.getInt("ID") + " " + 
									   tools.getString("TOOLNAME") + " " + 
									   tools.getInt("QUANTITY") + " " + 
									   tools.getDouble("PRICE") + " " + 
									   tools.getInt("SUPPLIERID"));
				}
				tools.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		private void decreaseQuantity(int toolID) {
			order order = new order();
			Tool item = searchForTool(toolID);
			int orderQuantity = 40 - (item.getToolQuantity()-1);
			
			String sql = "UPDATE" + tableName + "SET Quantity= '" + (item.getToolQuantity());
			
			try {
				statement = jdbc_connection.createStatement();
				statement.executeUpdate(sql);
				System.out.println("Tool reduced by 1");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
	
			int MINQUANTITY= 40;
			
			
			if (item.getToolQuantity() <= MINQUANTITY)
		    {
			order.addOrderLine(item.generateOrderLine());
			sql = "INSERT INTO ORDERLINE" +
				  " VALUES ( '"+ order.getOrderId() + "', '" +
				   item.getSupplierID() + "', '" +
				   orderQuantity + "');";
			try {
				statement = jdbc_connection.createStatement();
				statement.executeUpdate(sql);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		    
		    }
		}
		
		
	public static void main(String args[])
	{
		InventoryManager inventory = new InventoryManager();
		
		// You should comment this line out once the first database is created (either here or in MySQL workbench)
		//inventory.createDB();

		inventory.createTable();
		
		System.out.println("\nFilling the table with tools");
		inventory.fillTable();

		System.out.println("Reading all tools from the table:");
		inventory.printTable();

		System.out.println("\nSearching table for tool 1002: should return 'Grommets'");
		int toolID = 1002;
		Tool searchResult = inventory.searchForTool(toolID);
		if(searchResult == null)
			System.out.println("Search Failed to find a tool matching ID: " + toolID);
		else
			System.out.println("Search Result: " + searchResult.toString());

		System.out.println("\nSearching table for tool 9000: should fail to find a tool");
		toolID = 9000;
		searchResult = inventory.searchForTool(toolID);
		if(searchResult == null)
			System.out.println("Search Failed to find a tool matching ID: " + toolID);
		else
			System.out.println("Search Result: " + searchResult.toString());
		
		System.out.println("\nTrying to remove the table");
		inventory.removeTable();
		
		try {
			inventory.statement.close();
			inventory.jdbc_connection.close();
		} 
		catch (SQLException e) { e.printStackTrace(); }
		finally
		{
			System.out.println("\nThe program is finished running");
		}
	}

	
}