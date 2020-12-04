package co.grandcircus.FinalProject.services;

import java.util.List;

public class CheapsharkGameDetails {
	
	private Info info;
	private CheapestPriceEver cheapestPriceEver;
	private List<Deal> deals;
	
	public Info getInfo() {
		return info;
	}
	
	public void setInfo(Info info) {
		this.info = info;
	}
	
	public CheapestPriceEver getCheapestPriceEver() {
		return cheapestPriceEver;
	}
	
	public void setCheapestPriceEver(CheapestPriceEver cheapestPriceEver) {
		this.cheapestPriceEver = cheapestPriceEver;
	}
	
	public List<Deal> getDeals() {
		return deals;
	}
	
	public void setDeals(List<Deal> deals) {
		this.deals = deals;
	}
	
	public CheapsharkGameDetails(Info info, CheapestPriceEver cheapestPriceEver, List<Deal> deals) {
		super();
		this.info = info;
		this.cheapestPriceEver = cheapestPriceEver;
		this.deals = deals;
	}
	
	public CheapsharkGameDetails() {
	}
}
