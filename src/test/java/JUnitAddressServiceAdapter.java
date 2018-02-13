package test.java;

import main.java.IAddressServiceAdapter;
import main.java.Parceladdresses;

public class JUnitAddressServiceAdapter implements IAddressServiceAdapter{
	private double returnValue;
	
	public JUnitAddressServiceAdapter(double value) {
		// TODO Auto-generated constructor stub
		returnValue = value;
	}
	
	@Override
	public double getPriceForAddress(Parceladdresses parceladdress) {
		// TODO Auto-generated method stub
		return returnValue;
	}
	
	
}
