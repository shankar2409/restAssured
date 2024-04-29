package authentication;

public class Title {
	String title;
	int price;
	int copies;

	public Title(String title, int price, int copies) {
		this.title = title;
		this.price = price;
		this.copies = copies;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

}
