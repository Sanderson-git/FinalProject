package co.grandcircus.FinalProject.services;

import java.util.List;

public class GameStoreResponse {
	
	private List<GameSpecificStore> results;

	public GameStoreResponse(List<GameSpecificStore> results) {
		super();
		this.results = results;
	}
	
	public GameStoreResponse() {}

	public List<GameSpecificStore> getResults() {
		return results;
	}

	public void setResults(List<GameSpecificStore> results) {
		this.results = results;
	}
	
	

}
