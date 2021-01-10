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
import ServerPackage.Client;

public class clientManagement {

	// Pre-Project Exercise 

	// This program allows you to create and manage a store inventory database.
	// It creates a database and datatable, then populates that table with tools from
	// items.txt.
	
		public Connection jdbc_connection;
		public Statement statement;
     	public String databaseName = "InventoryDB", tableName = "Client", dataFile = "items.csv";
		
		// Students should configure these variables for their own MySQL environment
		// If you have not created your first database in mySQL yet, you can leave the 
		// "[DATABASE NAME]" blank to get a connection and create one with the createDB() method.
		public String connectionInfo = "jdbc:mysql://localhost:3306/inventorydb",  
					  login          = "root",
					  password       = "Cnnisthebest1@ng";

		public clientManagement()
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
		
	
		
		// Add a tool to the database table
		public void addClient(Client client)
		{
			String sql = "INSERT INTO " + tableName +
					" VALUES ( '"+ client.getClientId() + "', '" + 
					client.getLastName() + "', '" + 
					client.getFirstName() + "', '" + 
					client.getclientType() + "', '" + 
					client.getphoneNum() + "', '" +
					client.getAddress() + "', '" + 
					client.getPostalCode() + "');";
			
			System.out.println(sql);
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
		public ArrayList <Client> searchClient(String id)
		{
			ArrayList <Client> clients = new ArrayList <Client>();
			String sql = "SELECT * FROM " + tableName + " WHERE clientID=" + id ;
			ResultSet client;
			try {
				statement = jdbc_connection.createStatement();
				client = statement.executeQuery(sql);
				if(client.next())
				{
					clients.add( new Client(client.getInt("ClientID"),
									client.getString("last_name"), 
									client.getString("first_name"), 
									client.getString("client_type"), 
									client.getString("phone_num"), 
									client.getString("address"),
									client.getString("postalcode")));
				}
			
			} catch (SQLException e) { e.printStackTrace(); }
			
			return clients;
		}

		public ArrayList <Client> searchClientName( String lastName)
		{
			ArrayList <Client> clientnames = new ArrayList <Client>();
			String sql = "SELECT * FROM " + tableName + " WHERE last_name =" + lastName  ;
			ResultSet client;
			try {
				statement = jdbc_connection.createStatement();
				client = statement.executeQuery(sql);
				while(client.next())
				{
					System.out.println( new Client(client.getInt("ClientID"),
							client.getString("last_name"), 
							client.getString("first_name"), 
							client.getString("client_type"), 
							client.getString("phone_num"), 
							client.getString("address"),
							client.getString("postalcode")));
				}
			
			} catch (SQLException e) { e.printStackTrace(); 
				
		}
			return clientnames;
			
			
		}
		
		public ArrayList<Client> searchClientType(String type)
		{
			ArrayList <Client> clienttype = new ArrayList <Client>();
			String sql = "SELECT * FROM " + tableName + " WHERE client_type =" + type ;
			ResultSet client;
			try {
				statement = jdbc_connection.createStatement();
				client = statement.executeQuery(sql);
				while(client.next())
				{
					System.out.println( new Client(client.getInt("ClientID"),
							client.getString("last_name"), 
							client.getString("first_name"), 
							client.getString("client_type"), 
							client.getString("phone_num"), 
							client.getString("address"),
							client.getString("postalcode")));
				}
			
			} catch (SQLException e) { e.printStackTrace(); 
			
			}
			return clienttype;
			
			
		}

		
		public void removeClient(String clientId)
		{
			String sql = "DELETE FROM "  + tableName + " WHERE clientId =" + clientId;
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
		
		public void modifyClient(String ClientID,String last_name, String first_name, String client_type, String phone_num, String address, String postalcode )
		{
			String sql = "UPDATE " + tableName + " SET ClientID ="+ ClientID + ", " +"last_name="+ last_name + "," +" first_name =" + first_name+ ", " + "client_type=" + client_type + "," + "phone_num =" +phone_num  + " WHERE address =" + address ;
			
			try {
				statement = jdbc_connection.createStatement();
				 statement.executeUpdate(sql);
				
			} catch (SQLException e) { e.printStackTrace(); 
			
			}
			
			
		}

		
		public static void main(String args[])
		{
			clientManagement client = new clientManagement();
		
			System.out.println("\nSearching table for client 2517: should return 'Dana	Emily	C	4165550110	15 Bermuda Rd NW Calgary\r\n"
					+ "'");
			String clientId = "'2517'";
		   System.out.println(client.searchClient(clientId).toString()); 

			System.out.println("\nSearching table for client 2522: should fail to find a client");
			clientId = "'2522'";
			System.out.println(client.searchClient(clientId).toString());
			
			
			System.out.println("\nSearching table for client type R: should return client");
			String clientType = "'R'";
			  System.out.println(client.searchClientType(clientType).toString());
			
		
			System.out.println("\nSearching table for client Remy Obi: should return client");
			String lastName = "'Remy'";
			String firstName = "'Obi'";
			 System.out.println(client.searchClientName( lastName).toString());
			
	
			 
		}

		
	































}
