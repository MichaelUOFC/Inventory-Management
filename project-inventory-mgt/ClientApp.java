package ClientPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientApp {
	private PrintWriter socketOut;
	private Socket palinSocket;
	private BufferedReader stdIn;
	private BufferedReader socketIn;

	/**
	 * 
	 * constructor initializing server name and port number.
	 * 
	 * @param serverName
	 * @param portNumber
	 */
	public ClientApp(String serverName, int portNumber) {
		try {
			palinSocket = new Socket(serverName, portNumber);
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			socketIn = new BufferedReader(new InputStreamReader(palinSocket.getInputStream()));
			socketOut = new PrintWriter((palinSocket.getOutputStream()), true);
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}

	/**
	 * communicating with the server.
	 */
	public void communicate() {

		String line = "";
		String response = "";
		boolean running = true;
		while (running) {
			try {
				System.out.println("please select an option (CLIENT/INVENTORY): ");
				line = stdIn.readLine();
				if (!line.equals("QUIT")) {
					socketOut.println(line);
					response = socketIn.readLine();
					System.out.println(response);
				} else {
					running = false;
				}

			} catch (IOException e) {
				System.out.println("Sending error: " + e.getMessage());
			}
		}
		try {
			stdIn.close();
			socketIn.close();
			socketOut.close();
		} catch (IOException e) {
			System.out.println("Closing error: " + e.getMessage());
		}

	}

	/**
	 * Run the client.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ClientApp aClient = new ClientApp("localhost", 9090);

		aClient.communicate();
	}
}