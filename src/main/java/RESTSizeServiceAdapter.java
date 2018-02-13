package main.java;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class RESTSizeServiceAdapter implements ISizeServiceAdapter {
	private WebResource service;
	
	public RESTSizeServiceAdapter() {
		service = Client.create().resource("http://localhost:"+ 1100);
		
		// TODO Auto-generated constructor stub
	}


	@Override
	public String getParcelSize(Parcelsize parcel) {
		Gson g = new Gson();
		String req = g.toJson(parcel);
		String response = service.path("parcel").path("sent").path("size").accept(MediaType.TEXT_PLAIN).type(MediaType.TEXT_PLAIN).post(String.class, req);
		parcel= g.fromJson(response, Parcelsize.class);
		return parcel.getSize();
	}

}
