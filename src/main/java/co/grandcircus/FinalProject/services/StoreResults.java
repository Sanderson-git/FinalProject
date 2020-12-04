package co.grandcircus.FinalProject.services;

public class StoreResults {
	
	private Store store;

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public StoreResults(Store store) {
		super();
		this.store = store;
	}
	
	public StoreResults() {
	}

}
