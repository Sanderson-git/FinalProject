package co.grandcircus.FinalProject.services;

public class Deal {
	
	private String storeID;
	
	private String price;
	
	private String retailPrice;
	
	private String savings;

	public String getStoreID() {
		return storeID;
	}

	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(String retailPrice) {
		this.retailPrice = retailPrice;
	}

	public String getSavings() {
		return savings;
	}

	public void setSavings(String savings) {
		this.savings = savings;
	}

	public Deal(String storeID, String price, String retailPrice, String savings) {
		super();
		this.storeID = storeID;
		this.price = price;
		this.retailPrice = retailPrice;
		this.savings = savings;
	}
	
	public Deal() {
	}

}
