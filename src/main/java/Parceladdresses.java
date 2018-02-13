package main.java;

public class Parceladdresses {
	private Address recipient;
	private Address sender;
	private String size;
	private double price;
	
	public String toString() {
		return "Parceladdresses [recipient=" + recipient + ", sender=" + sender + ", size=" + size + ", price=" + price
				+ "]";
	}
	
	public Parceladdresses() {
		// TODO Auto-generated constructor stub
	}
	public Parceladdresses(Address recipient, Address sender) {
		this.recipient = recipient;
		this.sender = sender;
	}

	public Address getRecipient() {
		return recipient;
	}

	public void setRecipient(Address recipient) {
		this.recipient = recipient;
	}

	public Address getSender() {
		return sender;
	}

	public void setSender(Address sender) {
		this.sender = sender;
	}

	

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
	
}
