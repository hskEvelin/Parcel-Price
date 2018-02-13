package main.java;

import java.io.IOException;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

public class ParcelPriceServiceMain {

	public static void main(String[] args) {
		HttpServer server;
		
		
		try {
			server = HttpServerFactory.create("http://localhost:1300/parcel");
			server.start();
			
			//while(true){}
			//JOptionPane.showMessageDialog(null, "ParcelSize-Service started!\nClick to end");
			//server.stop(0);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
