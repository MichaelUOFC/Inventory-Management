package ServerPackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 
import java.util.Random; 
import java.util.Calendar;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

/**
 * This class records  information regarding  daily orders. 
 *
 * @author Kenechukwu Nwabueze
 */
public class order {
	
	// This stores daily orders
	private ArrayList <orderLine> orderOfDay;
	
	// stores identification number
	private int orderId; 
	
	// Stores the order record date
	private String orderDate; 
	
	public Statement statement;
	public Connection jdbc_connection;
	
public String databaseName = "InventoryDB", tableName = "ToolTable", dataFile = "items.txt";
	

	

	//this creates an instance of order with a random id
	public order() { 
		orderOfDay = new ArrayList <orderLine>(); 
		
		Random random = new Random();
		setOrderId(random.nextInt(100000));
		
		Calendar c = Calendar.getInstance();
		setOrderDate(String.format("%tB %te, %tY%n", c, c, c));
	
		
	
	}

	//This adds an order line to the daily order
	public void addOrderLine(orderLine order) {
		orderOfDay.add(order); 
	}

	// This gets the order Id number
	public int getOrderId() {
		
		String sql = "SELECT orderId From tool_order WHERE orderid = (SELECT MAX(orderId) from tool_order )";
		
		ResultSet tool;
		int id = 0;
		
		try {
			statement = jdbc_connection.createStatement();
			tool = statement.executeQuery(sql);
			
			while (tool.next()) {
				id = tool.getInt("OrderID");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return orderId;
	}
	
	//This sets the order ID number
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	//This gets the order date
	public String getOrderDate() {
		return orderDate;
	}

	// This sets the order date
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

}
