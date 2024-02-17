package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
	public static void main(String[] args) {
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		
		try {
			socket = new Socket("localhost", 9000);
			os = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(os, true);
            writer.println("test");
            is = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(os != null)
					os.close();
				if(is != null)
					is.close();
				if(socket != null) 
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
