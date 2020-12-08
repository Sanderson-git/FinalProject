package co.grandcircus.FinalProject.services;

public class PrettyDeal {
	
	private String storeName;
	private String storeID;
	private String price;
	private String retailPrice;
	private String savings;
	private String dealID;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getDealID() {
		return dealID;
	}

	public void setDealID(String dealID) {
		this.dealID = dealID;
	}

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

	public PrettyDeal(String storeID, String price, String retailPrice, String savings, String storeName) {
		super();
		this.storeName = storeName;
		this.storeID = storeID;
		this.price = price;
		this.retailPrice = retailPrice;
		this.savings = savings;
	}
	
	public PrettyDeal() {
	}
}
