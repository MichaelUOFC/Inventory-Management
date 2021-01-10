package ServerPackage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.InputStream.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class InventoryServer {
	private BufferedReader socketInput;
	private PrintWriter socketOutput;
	private ServerSocket serverSocket;
	private Socket aSocket;

	public Connection jdbc_connection;
	public Statement statement;
	public String databaseName = "InventoryDB", tableName = "Client", dataFile = "items.csv";
	
	// Students should configure these variables for their own MySQL environment
	// If you have not created your first database in mySQL yet, you can leave the 
	// "[DATABASE NAME]" blank to get a connection and create one with the createDB() method.
	public String connectionInfo = "jdbc:mysql://localhost:3306/inventorydb",  
				  login          = "root",
				  password       = "Cnnisthebest1@ng";


	
	public InventoryServer() {
		try {
			serverSocket = new ServerSocket(9090);
			System.out.println("Inventory Server is now running.");
			aSocket = serverSocket.accept();
			socketInput = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOutput = new PrintWriter(aSocket.getOutputStream(), true);
		} catch (IOException e) {
		}
	}


public void getUserInput() throws IOException {
	StringBuffer line = null;
	
	while (true) {
		line = new StringBuffer(socketInput.readLine());
		int idFromClient = Integer.parseInt(line.toString());
		
		Tool searchResult = searchTool(idFromClient);
		if (searchResult == null) 
			
			//System.out.println("This line works");
			socketOutput.println( "Search Failed to find a tool matching ID: " + idFromClient);
		else
			socketOutput.println("Search Result: " + searchResult.toString());
//		if (line.toString().equals("Search by tool ID")) {
//			InventoryServer inventory = inventory.searchTool(line);
//			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
//			socketOutput.println( sdf.format(cal.getTime()));
//		} else if (line.toString().equals("TIME")) {
//			Calendar cal = Calendar.getInstance();
//			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//			socketOutput.println( sdf.format(cal.getTime()));		
			
	socketInput.close();
	socketOutput.close();
	serverSocket.close();
}
}
/**
 * Run the Server.
 * 
 * @param args
 * @throws IOException
 */


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
public Tool searchTool(int toolID)
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
	
	return null;
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
			Tool item = searchTool(toolID);
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

	public static void main(String[] args) throws IOException {

		InventoryServer myServe = new InventoryServer();

		// Establishing the connection
		myServe.getUserInput();
	}












}
