package co.grandcircus.FinalProject.services;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CheapsharkGame {
	
	@JsonProperty("gameID")
	private String gameID;
	private String steamAppId;
	private String cheapest;
	private String cheapestDealId;
	private String external;
	private String internalName;
	private String thumb;
	
	public String getGameId() {
		return gameID;
	}
	
	public void setGameId(String gameID) {
		this.gameID = gameID;
	}
	
	public String getSteamAppId() {
		return steamAppId;
	}
	
	public void setSteamAppId(String steamAppId) {
		this.steamAppId = steamAppId;
	}
	
	public String getCheapest() {
		return cheapest;
	}
	
	public void setCheapest(String cheapest) {
		this.cheapest = cheapest;
	}
	
	public String getCheapestDealId() {
		return cheapestDealId;
	}
	
	public void setCheapestDealId(String cheapestDealId) {
		this.cheapestDealId = cheapestDealId;
	}
	
	public String getExternal() {
		return external;
	}
	
	public void setExternal(String external) {
		this.external = external;
	}
	
	public String getInternalName() {
		return internalName;
	}
	
	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}
	
	public String getThumb() {
		return thumb;
	}
	
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	
	public CheapsharkGame(String gameID, String steamAppId, String cheapest, String cheapestDealId, String external,
			String internalName, String thumb) {
		super();
		this.gameID = gameID;
		this.steamAppId = steamAppId;
		this.cheapest = cheapest;
		this.cheapestDealId = cheapestDealId;
		this.external = external;
		this.internalName = internalName;
		this.thumb = thumb;
	}
	
	public CheapsharkGame() {
	}
}
