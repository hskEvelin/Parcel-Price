package main.java;

import java.util.List;

public class Parcel {
	private Parcelsize parcelsize;
	private Parceladdresses parceladdresses;
	private PickupOption parceloptions;
	private double price;
	
	public Parcel(){}



	public Parcelsize getParcelsize() {
		return parcelsize;
	}



	public void setParcelsize(Parcelsize parcelsize) {
		this.parcelsize = parcelsize;
	}




	



	public Parceladdresses getParceladdresses() {
		return parceladdresses;
	}



	public void setParceladdresses(Parceladdresses parceladdresses) {
		this.parceladdresses = parceladdresses;
	}





	public PickupOption getParceloption() {
		return parceloptions;
	}



	public void setParceloption(PickupOption parceloption) {
		this.parceloptions = parceloption;
	}



	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "Parcel [parcelsize=" + parcelsize + ", parceladresses=" + parceladdresses + ", parceloptions="
				+ parceloptions + ", price=" + price + "]";
	}

	
	
	
	
}
