package authentication;

public class purchase {
	int purchaseAmount;
	String webSite;
	public purchase(int purchaseAmount, String webSite) {
		super();
		this.purchaseAmount = purchaseAmount;
		this.webSite = webSite;
	}
	public int getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(int purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	
}
