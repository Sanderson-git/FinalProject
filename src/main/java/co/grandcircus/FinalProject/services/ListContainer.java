package co.grandcircus.FinalProject.services;

import java.util.Set;

import co.grandcircus.FinalProject.SQL.WishList;

public class ListContainer {
	
	private Set<WishList> wishlists;
	private Integer length;

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Set<WishList> getWishlists() {
		return wishlists;
	}

	public void setWishlists(Set<WishList> wishlists) {
		this.wishlists = wishlists;
	}
	
	public ListContainer() {}

}
