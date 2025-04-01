package clientserver;

import java.io.*;
import java.net.*;

public class TCPServer {
	
	public static void main(String[] args) throws IOException {
		
		//✅ Creates a server socket that listens on port 6789.
		ServerSocket serverSocket = new ServerSocket(6789);
		System.out.println("Server is running and waiting for a client...");
		
		//✅ Waits for a client to connect. When one connects, it returns a Socket for communication.
		Socket connectionSocket = serverSocket.accept();
		System.out.println("Client connected!");
		
		//✅ Sets up a BufferedReader to receive text from the client.
		BufferedReader inFromClient = new BufferedReader( new InputStreamReader(connectionSocket.getInputStream()));
		
		//✅ Sets up a DataOutputStream to send data back to the client.
		DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
		
		//✅ Reads a single line sent by the client (in this case, a name).
		String name = inFromClient.readLine();
		String greeting = "Hello, " + name + "\n";
		
		//✅ Sends the greeting string to the client over the socket.
		outToClient.writeBytes(greeting);
		
		connectionSocket.close();
		serverSocket.close();
		
	
		
		
		
				
		
	}

}
