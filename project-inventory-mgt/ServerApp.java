package ServerPackage;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import ClientPackage.ClientController;
import ClientPackage.ClientMgtGui;
import ClientPackage.InventoryController;
import ClientPackage.InventoryGui;
import ClientPackage.InventoryManager;
import ClientPackage.clientManagement;

public class ServerApp {
	
	private BufferedReader socketInput;
	private PrintWriter socketOutput;
	private ServerSocket serverSocket;
	private Socket aSocket;

	/**
	 * Construct a Server with Port 9090
	 */
	public ServerApp() {
		try {
			serverSocket = new ServerSocket(9090);
			System.out.println("DB Server is now running.");
			aSocket = serverSocket.accept();
			socketInput = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOutput = new PrintWriter(aSocket.getOutputStream(), true);
		} catch (IOException e) {
		}
	}

	/**
	 * Get input from Client.
	 * 
	 * @throws IOException
	 */
	public void getUserInput() throws IOException {
		StringBuffer line = null;

		while (true) {
			line = new StringBuffer(socketInput.readLine());

			if (line != null) {
				if (line.toString().equals("QUIT")) {
					break;
				}

				if (line.toString().equals("CLIENT")) {

					EventQueue.invokeLater(new Runnable() {

						public void run() {
							try {

								ClientMgtGui theView = new ClientMgtGui();

								clientManagement theModel = new clientManagement();

								ClientController theController = new ClientController(theView, theModel);

								theView.frame.setVisible(true);

							} catch (Exception e) {
								e.printStackTrace();
							}
						}

					});
				} else if (line.toString().equals("INVENTORY")) {

					EventQueue.invokeLater(new Runnable() {

						public void run() {
							try {

								InventoryGui theView = new InventoryGui();

								InventoryManager theModel = new InventoryManager();

								InventoryController theController = new InventoryController(theView, theModel);

								theView.frame.setVisible(true);

							} catch (Exception e) {
								e.printStackTrace();
							}
						}

					});
				} else {
					socketOutput.println("Wrong input, please try again");
				}
			}

		}

		socketInput.close();
		socketOutput.close();
		serverSocket.close();
	}

	/**
	 * Run the Server.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ServerApp ds = new ServerApp();
		ds.getUserInput();
	}
}
