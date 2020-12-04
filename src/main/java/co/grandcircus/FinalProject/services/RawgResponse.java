package co.grandcircus.FinalProject.services;

import java.util.List;

public class RawgResponse {
	
	private String next;
	private String previous;
	private List<RawgGame> results;
	
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	public List<RawgGame> getResults() {
		return results;
	}
	public void setResults(List<RawgGame> results) {
		this.results = results;
	}
	
	public RawgResponse(String next, String previous, List<RawgGame> results) {
		super();
		this.next = next;
		this.previous = previous;
		this.results = results;
	}
	
	public RawgResponse() {		
	}

}
