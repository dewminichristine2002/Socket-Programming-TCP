package clientserver;

import java.io.*;
import java.net.*;

public class TCPClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//✅ Reads user input from the keyboard.
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		//✅ Connects to the server running on the same computer (localhost) at port 6789.
		Socket clientSocket = new Socket("localhost", 6789);
		
		//✅ Allows the client to send data to the server.
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		
		//✅ Allows the client to read the server's response.
		BufferedReader inFromServer = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
		
		//✅ Asks the user to enter their name and reads it as a string.
		System.out.println("Enter your name : ");
		String name = inFromUser.readLine();
		
		//✅ Sends the name to the server.
		outToServer.writeBytes(name + "\n");
		
		//✅ Reads the greeting message from the server.
		String greeting = inFromServer.readLine();
		
		System.out.println("SERVER SAYS : "+ greeting);
		
		clientSocket.close();
		 
		
	}

}
