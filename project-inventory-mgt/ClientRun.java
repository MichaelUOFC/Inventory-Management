package ClientPackage;

import java.awt.EventQueue;

public class ClientRun {
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {

					ClientMgtGui view = new ClientMgtGui();

					clientManagement model = new clientManagement();

					ClientController controller = new ClientController(view, model);

					view.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});

	}

}
