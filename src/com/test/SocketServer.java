package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			serverSocket = new ServerSocket(9000);
			while(true) {
				socket = serverSocket.accept();
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String line = br.readLine();
				System.out.println("socket read => " + line);
				
				pw = new PrintWriter(socket.getOutputStream(), true);
				pw.append("HELLO");
				pw.flush();
				
				br.close();
				pw.close();
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
