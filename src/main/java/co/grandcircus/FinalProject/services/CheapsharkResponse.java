package co.grandcircus.FinalProject.services;

import java.util.List;

public class CheapsharkResponse {

	private List<CheapsharkGame> results;

	public List<CheapsharkGame> getResults() {
		return results;
	}

	public void setResults(List<CheapsharkGame> results) {
		this.results = results;
	}

	public CheapsharkResponse(List<CheapsharkGame> results) {
		super();
		this.results = results;
	}
	
	public CheapsharkResponse() {
	}
}
