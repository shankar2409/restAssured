package pojoClass;

public class MobileBrand {
	//declasre the variables in globally
	private String brandName;
	private String capacity;
	private String color;
	private int price;
	private int ram;
	//create constructor using fields
	public MobileBrand(String brandName, String capacity, String color, int price, int ram) {
		this.brandName = brandName;
		this.capacity = capacity;
		this.color = color;
		this.price = price;
		this.ram = ram;
	}
	//in order to deserilization
	public MobileBrand() {
	}
	
	
	//provide the getters and setters for members
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	
	
	
}
