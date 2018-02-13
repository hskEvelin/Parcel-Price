package test.java;

import main.java.ISizeServiceAdapter;
import main.java.Parcelsize;

public class JUnitSizeServiceAdapter implements ISizeServiceAdapter{
	private String returnValue;
	
	public JUnitSizeServiceAdapter(String value) {
		// TODO Auto-generated constructor stub
		returnValue = value;
	}
	
	@Override
	public String getParcelSize(Parcelsize parcel) {
		
		return returnValue;
	}

}
