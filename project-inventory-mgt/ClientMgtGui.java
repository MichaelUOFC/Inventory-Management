package ClientPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ServerPackage.Client;

import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

public class ClientMgtGui {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1; //fname
	private JTextField textField_2; //lname
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private String LName;
	private String FName;
	private String Type;
	private String PhoneNumber;
	private String Address;
	private String PostalCode;
	public JButton btnNewButton_2;
	private JComboBox comboBox;
	private ButtonGroup button_group;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JButton btnNewButton;;
	private JScrollPane new_scrollPane;
	private JList result_list;
	JTextArea textArea;
	JEditorPane editorPane;
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClientMgtGui window = new ClientMgtGui();
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
	public ClientMgtGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 811, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Clients");
		lblNewLabel.setBounds(158, 11, 115, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Client Information");
		lblNewLabel_1.setBounds(594, 11, 132, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Select type of search to be performed:");
		lblNewLabel_2.setBounds(10, 43, 234, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Client ID:");
		lblNewLabel_3.setBounds(504, 43, 66, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(604, 40, 122, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		

		rdbtnNewRadioButton = new JRadioButton("Client ID");
		rdbtnNewRadioButton.setBounds(0, 61, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		
		rdbtnNewRadioButton_1 = new JRadioButton("Last Name");
		rdbtnNewRadioButton_1.setBounds(0, 87, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Client Type");
		rdbtnNewRadioButton_2.setBounds(0, 113, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		button_group = new ButtonGroup();
		button_group.add(rdbtnNewRadioButton);
		button_group.add(rdbtnNewRadioButton_1);
		button_group.add(rdbtnNewRadioButton_2);
		
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(44, 165, 346, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Enter the search paramater below:");
		lblNewLabel_5.setBounds(10, 165, 211, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 191, 235, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("Search"); //button to search by id, type or name.
		btnNewButton.setBounds(255, 190, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear Search");
		btnNewButton_1.setBounds(354, 190, 109, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("First Name:");
		lblNewLabel_6.setBounds(504, 91, 66, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(603, 88, 122, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Last Name:");
		lblNewLabel_7.setBounds(504, 145, 66, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_3 = new JTextField();
		textField_3.setBounds(604, 142, 122, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Address:");
		lblNewLabel_8.setBounds(504, 193, 89, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		textField_4 = new JTextField();
		textField_4.setBounds(603, 190, 123, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Postal Code:");
		lblNewLabel_9.setBounds(504, 248, 90, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		textField_5 = new JTextField();
		textField_5.setBounds(604, 245, 122, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Phone Number:");
		lblNewLabel_10.setBounds(504, 310, 95, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(603, 307, 123, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Client Type:");
		lblNewLabel_11.setBounds(504, 368, 66, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"R", "C"}));
		comboBox.setBounds(604, 364, 122, 22);
		frame.getContentPane().add(comboBox);
		
		btnNewButton_2 = new JButton("Save");
		btnNewButton_2.setBounds(504, 428, 66, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.setBounds(580, 428, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Clear");
		btnNewButton_4.setBounds(679, 428, 75, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel_12 = new JLabel("Search Results:");
		lblNewLabel_12.setBounds(10, 231, 99, 14);
		frame.getContentPane().add(lblNewLabel_12);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 248, 445, 203);
		frame.getContentPane().add(textArea);
		
		
//		editorPane = new JEditorPane();
//		editorPane.setBounds(10, 248, 445, 203);
//		frame.getContentPane().add(editorPane);
	
		
		new_scrollPane = new JScrollPane();
		new_scrollPane.setViewportBorder(null);
		new_scrollPane.setBounds(10, 248, 445, 203);
		frame.getContentPane().add(new_scrollPane);
		
		
	
	}
	
	public void ScrollPane(ArrayList<Client> clients) {

		result_list = new JList(clients.toArray());

		result_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		result_list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent event) {
				
				if (!event.getValueIsAdjusting()) {
					JList theSource = (JList) event.getSource();
					String result_string = theSource.getSelectedValue().toString();
					String[] results_arr = result_string.split(" ");
					String address = "";
					
					
					for (int i = 5; i <= results_arr.length -3; i++)
						address += (results_arr[i] + " ");
					

					address = address.trim();
					
					textField.setText(results_arr[0]); //id
					textField_2.setText(results_arr[1]); //first name
					textField_3.setText(results_arr[2]); //last name
					comboBox.setSelectedItem(results_arr[3]); //type
					textField_6.setText(results_arr[4]);
					textField_4.setText(address);
					textField_5.setText((results_arr[results_arr.length-2]) + " " + (results_arr[results_arr.length-1]));
					
				}
			}});
				
		
		result_list.setSelectedIndex(0);
		result_list.setVisibleRowCount(10);

		frame.remove(new_scrollPane);
		new_scrollPane = new JScrollPane(result_list);
		new_scrollPane.setViewportBorder(null);
		new_scrollPane.setBounds(10, 248, 445, 203);

		frame.getContentPane().add(new_scrollPane);
		frame.getContentPane().repaint();
		frame.invalidate();
		frame.validate();
		frame.repaint();
		
		editorPane.add(result_list);
		
	}
	
	public String getButtonGroup() {
		if (rdbtnNewRadioButton.isSelected())
			return "ID";
		else if (rdbtnNewRadioButton_1.isSelected())
			return "Name";
		else if (rdbtnNewRadioButton_2.isSelected())
			return "Type";
		
		return null;
	}
	
	public void addClientListener (ActionListener listenForSave) {
		btnNewButton_2.addActionListener(listenForSave);
	}
	
	public void searchListener(ActionListener listenForSearch){
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == rdbtnNewRadioButton ) {
					btnNewButton.addActionListener(listenForSearch);
				}
			}
	});
		
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == rdbtnNewRadioButton_1 ) {
					btnNewButton.addActionListener(listenForSearch);
				}
			}
	});
		
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == rdbtnNewRadioButton_2 ) {
					btnNewButton.addActionListener(listenForSearch);
				}
			}
	});
			
	}
	
	
	
	public int getID()
	{
		return Integer.parseInt(textField.getText());
	}
	public String getLName() {
		return textField_3.getText();
	}

	public String getFName() 
	{
		return textField_2.getText();
	}

	
	
	public String getType() {
		return comboBox.getSelectedItem().toString();
	}

	public String getPhoneNumber() {
		return textField_6.getText();
	}

	public String getAddress() {
		return textField_4.getText();
	}

	public String getPostalCode() {
		return textField_5.getText();
	}
	
	public String getSearch() {
		return textField_1.getText();
	}

}
