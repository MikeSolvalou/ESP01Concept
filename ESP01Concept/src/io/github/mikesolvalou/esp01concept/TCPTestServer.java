package io.github.mikesolvalou.esp01concept;

//derived from https://docs.oracle.com/javase/tutorial/networking/sockets/examples/EchoServer.java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTestServer {
	
	/**Starts a TCP server that prints chars it receives to console.
	 * Makes, at most, one TCP connection.*/
	public static void main(String[] args) throws IOException {

		int portNumber = 8005;
		System.out.println("Listening on port "+portNumber);
		
		try (ServerSocket serverSocket = new ServerSocket(portNumber);
				Socket clientSocket = serverSocket.accept();
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println("Rx: "+inputLine);
				System.out.println("Tx: okay");
				out.println("okay");
			}
		}
		catch (IOException e) {
			System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
			System.out.println(e.getMessage());
		}
	}
}
