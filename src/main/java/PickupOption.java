package main.java;

import java.util.Date;

public class PickupOption {
	private String name;
	private boolean checked;
	private double price;
	
	public PickupOption() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PickupOption(String name, boolean checked, double price) {
		super();
		this.name = name;
		this.checked = checked;
		this.price = price;
	}


	@Override
	public String toString() {
		return "PickupOption [name=" + name + ", checked=" + checked + ", price=" + price + "]";
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	
	
	
	
}
