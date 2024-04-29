package pojoClass;

public class MobileWithArray {
	private String brandName;
	private String capacity;
	private String color;
	private int[] price;
	private int ram;
	public MobileWithArray(String brandName, String capacity, String color, int[] price, int ram) {
		this.brandName = brandName;
		this.capacity = capacity;
		this.color = color;
		this.price = price;
		this.ram = ram;
	}
	
	public MobileWithArray() {
	}

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
	public int[] getPrice() {
		return price;
	}
	public void setPrice(int[] price) {
		this.price = price;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
}
