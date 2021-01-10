package ClientPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ServerPackage.Client;

public class ClientController {
	
	private ClientMgtGui view;
	private clientManagement model;
	
	
	
	public ClientController(ClientMgtGui view, clientManagement model) {
		this.view = view;
		this.model = model;
		
		this.view.addClientListener(new AddClientListener());
		this.view.searchListener(new SearchListener());
	}
	
	
	class AddClientListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			String lname, fname, type, phoneNum, address, postalCode;

			lname = view.getLName();
			fname = view.getFName();
			type = view.getType();
			phoneNum = view.getPhoneNumber();
			address = view.getAddress();
			postalCode = view.getPostalCode();
			
			
			Client theClient = new Client(0, lname, fname, type, phoneNum, address, postalCode);
			model.addClient(theClient);

			
			
		}
		
	}
	
	class SearchListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (view.getButtonGroup().equals("ID")) {
				
				String id = view.getSearch();
				view.ScrollPane(model.searchClient(id));
				
			}
			
			else if (view.getButtonGroup().equals("Name")) {
				String lname = view.getSearch();
				view.ScrollPane(model.searchClientName(lname));
			}
				
			else if (view.getButtonGroup().equals("Type")) {
				String ctype = view.getSearch();
				view.ScrollPane(model.searchClientType(ctype));
				
			}
			
		}
		
	}

}
