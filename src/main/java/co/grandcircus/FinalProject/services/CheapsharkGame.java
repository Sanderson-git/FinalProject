package co.grandcircus.FinalProject.services;

public class CheapsharkGame {

	private String gameId;
	private String steamAppId;
	private String cheapest;
	private String cheapestDealId;
	private String external;
	private String internalName;
	private String thumb;
	
	public String getGameId() {
		return gameId;
	}
	
	public void setGameId(String gameId) {
		this.gameId = gameId;
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
	
	public CheapsharkGame(String gameId, String steamAppId, String cheapest, String cheapestDealId, String external,
			String internalName, String thumb) {
		super();
		this.gameId = gameId;
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
