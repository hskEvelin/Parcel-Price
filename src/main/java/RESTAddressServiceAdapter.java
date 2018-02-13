package main.java;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class RESTAddressServiceAdapter implements IAddressServiceAdapter {
	private WebResource service;
	
	public RESTAddressServiceAdapter() {
		// TODO Auto-generated constructor stub
		service = Client.create().resource("http://localhost:"+ 1200);
	}
	@Override
	public double getPriceForAddress(Parceladdresses parceladdress) {
		Gson g = new Gson();
		String req = g.toJson(parceladdress);
		String response = service.path("parcel").path("sent").path("address").accept(MediaType.TEXT_PLAIN).type(MediaType.TEXT_PLAIN).post(String.class, req);
		JsonObject jsonObject = g.fromJson( response, JsonObject.class);
		double price = jsonObject.get("price").getAsDouble();
		return price;
	}

}
