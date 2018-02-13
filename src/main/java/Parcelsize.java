package main.java;

public class Parcelsize {
	private int length;
	private int height;
	private int depth;
	private String size;
	
	public Parcelsize() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Parcelsize(int length, int height, int depth, String size) {
		super();
		this.length = length;
		this.height = height;
		this.depth = depth;
		this.size = size;
	}



	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Parcelsize [length=" + length + ", height=" + height + ", depth=" + depth + ", size=" + size + "]";
	}
	
	
}
