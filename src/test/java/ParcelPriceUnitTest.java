package test.java;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.google.gson.Gson;

import main.java.Address;
import main.java.IAddressServiceAdapter;
import main.java.ISizeServiceAdapter;
import main.java.Parcel;
import main.java.ParcelPriceService;
import main.java.Parceladdresses;
import main.java.Parcelsize;
import main.java.PickupOption;

public class ParcelPriceUnitTest {
	
	@Test
	public void priceXStoDEwithoutOptTest(){
		ISizeServiceAdapter sizeService = new JUnitSizeServiceAdapter("XS");
		IAddressServiceAdapter addressService = new JUnitAddressServiceAdapter(3.89);
		ParcelPriceService priceService = new ParcelPriceService(sizeService, addressService);
		Gson g = new Gson();
		
		Parcel p = new Parcel();
		Parcelsize s = new Parcelsize(10,10,10,"");
		Address a1 = new Address("Lucas Greising", "Bahnhofstrasse","61", "87435", "Kempten", "Deutschland");
		Address a2 = new Address("Hochschule Kempten", "Bahnhofstrasse","61 ", "87435", "Kempten", "Deutschland");
		Parceladdresses add = new Parceladdresses(a1, a2);
		PickupOption options = new PickupOption("Abgabe im Paketshop", true, 0.00);

		p.setParceladdresses(add);
		p.setParcelsize(s);
		p.setParceloption(options);
		
		String json = g.toJson(p);
		
		Response resp = priceService.calculateParcelPrice(json);
		
		json = (String) resp.getEntity();
		p = g.fromJson(json, Parcel.class);
		
		assertEquals(3.89, p.getPrice(), 0.00);
	}
	
	@Test
	public void priceXStoDEwithOptTest(){
		ISizeServiceAdapter sizeService = new JUnitSizeServiceAdapter("XS");
		IAddressServiceAdapter addressService = new JUnitAddressServiceAdapter(3.89);
		ParcelPriceService priceService = new ParcelPriceService(sizeService, addressService);
		Gson g = new Gson();
		
		Parcel p = new Parcel();
		Parcelsize s = new Parcelsize(10,10,10,"");
		Address a1 = new Address("Lucas Greising", "Bahnhofstrasse","61", "87435", "Kempten", "Deutschland");
		Address a2 = new Address("Hochschule Kempten", "Bahnhofstrasse","61 ", "87435", "Kempten", "Deutschland");
		Parceladdresses add = new Parceladdresses(a1, a2);
		PickupOption options = new PickupOption("Abholung an der Haustüre", true, 4.00);

		p.setParceladdresses(add);
		p.setParcelsize(s);
		p.setParceloption(options);
		
		String json = g.toJson(p);
		
		Response resp = priceService.calculateParcelPrice(json);
		
		json = (String) resp.getEntity();
		p = g.fromJson(json, Parcel.class);
		
		assertEquals(7.89, p.getPrice(), 0.00001);
	}
}
