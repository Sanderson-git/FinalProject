package co.grandcircus.FinalProject.services;

public class StoreResults {
	
	private Store store;
	private Integer id;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
