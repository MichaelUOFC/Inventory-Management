package ClientPackage;



import java.awt.EventQueue;

import ServerPackage.Client;
import ServerPackage.Inventory;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.util.ArrayList;
import ServerPackage.Tool;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class InventoryGui {

	private JList result_list;
	
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton;
	
	private JScrollPane scrollPane;
	public JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//		
//				try {
//					InventoryGui window = new InventoryGui();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public InventoryGui() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryGui window = new InventoryGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 787, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnNewButton = new JButton("List All Tools");
	
		btnNewButton.setBounds(34, 81, 185, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Inventory Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(34, 16, 209, 14);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton_1 = new JButton("Check Item Quantity");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton_1.setBounds(34, 282, 185, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Decrease Item Quantity");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton_2.setBounds(34, 361, 180, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Search for Tool by Name");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton_3.setBounds(34, 209, 185, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Search For Tool By ID");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnNewButton_4.setBounds(34, 145, 185, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(384, 12, 377, 449);
		frame.getContentPane().add(textArea);
		 
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(384, 12, 377, 450);
		frame.getContentPane().add(scrollPane);
	}
	

	public void setScrollPane(ArrayList<Tool> invent) {
		
		//to view what is in invent 
		for( Tool m: invent) { 
			System.out.println(m); 	
		}
		
		result_list = new JList(invent.toArray());
		
		result_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		result_list.addListSelectionListener(new ListSelectionListener() {
			
				@Override
				public void valueChanged(ListSelectionEvent e) {
					
					if (!e.getValueIsAdjusting()) {
						JList source = (JList) e.getSource();
						String selected = source.getSelectedValue().toString();
						String[] selected_arr = selected.split(" ");
						
						//searchTool.setText(selected_arr[0]);
						
						
						 
					}
				}
//
//				@Override
//				public void valueChanged(ListSelectionEvent e) {
//					// TODO Auto-generated method stub
//					
		}
	);
		
		result_list.setSelectedIndex(0);
		result_list.setVisibleRowCount(10);

		frame.remove(scrollPane);
		scrollPane = new JScrollPane(result_list);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(384, 12, 377, 450);

		frame.getContentPane().add(scrollPane);

		frame.invalidate();
		frame.validate();
		frame.repaint();
		
	}
	
	public void listenForAllItems (ActionListener listenForItems){
	
		btnNewButton.addActionListener(listenForItems);
	}
	
//	public void addInventory1Listener(ActionListener listenForDecreaseItemQuantity){
//		btnNewButton_2.addActionListener(listenForDecreaseItemQuantity);
//	}
//	
//	public void addInventory2Listener(ActionListener listenForListAllTools){
//		btnNewButton.addActionListener(listenForListAllTools);
//	}
//	
//	public int getID()
//	{
//		return Integer.parseInt(textArea.getText());
//	}
//	public String getCheckItemQuantity() {
//		return textArea.getText();
//	}
//
//	public String getToolByName() 
//	{
//		return textArea.getText();
//	}

}
