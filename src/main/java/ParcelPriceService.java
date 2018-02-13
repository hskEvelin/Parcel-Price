package main.java;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Path("/sent")
public class ParcelPriceService {
	private ISizeServiceAdapter sizeService;
	private IAddressServiceAdapter addressService;
	
	public ParcelPriceService() {
		/*Gson g = new Gson();
		Parcel p = new Parcel();
		Parcelsize s = new Parcelsize(20,20,20,"");
		Address a1 = new Address("asdfg asf", "asdf sa f","asdf saf ", "asdf as", " asdfsafe wf sea", "asfsa fs");
		Address a2 = new Address("asdfg asf", "asdf sa f","asdf saf ", "asdf as", " asdfsafe wf sea", "asfsa fs");
		Parceladdresses add = new Parceladdresses(a1, a2);
		List<PickupOption> options = new ArrayList<PickupOption>();
		options.add(new PickupOption(true, new Date(), new Address()));
		options.add(new PickupOption(false, new Date(), null));
		
		p.setParceladdresses(add);
		p.setParcelsize(s);
		p.setParceloptions(options);
		
		String j = g.toJson(p);
		System.out.println(j);*/
		sizeService = new RESTSizeServiceAdapter();
		addressService = new RESTAddressServiceAdapter();
	}
	
	public ParcelPriceService(ISizeServiceAdapter size, IAddressServiceAdapter addr){
		sizeService = size;
		addressService = addr;
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("price")
	public Response calculateParcelPrice(String json){
		
		Gson g = new Gson();
		Parcel p = g.fromJson(json, Parcel.class);
		System.out.println(p.toString());
		
		//Calculate parcelsize
		String size = sizeService.getParcelSize(p.getParcelsize());
		p.getParceladdresses().setSize(size);
		System.out.println(size);
		
		//Request price for given address
		double price = addressService.getPriceForAddress(p.getParceladdresses());
		
		//Add price from selected option
		price = price + p.getParceloption().getPrice();
		System.out.println(price);
		p.setPrice(price);
		
		String resp = g.toJson(p);
		
		return Response
			      .status(200)
			      .header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Credentials", "true")
			      .header("Access-Control-Allow-Headers",
			        "origin, content-type, accept, authorization")
			      .header("Access-Control-Allow-Methods", 
			        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
			      .entity(resp)
			      .build();
	}

	
	
		
}
