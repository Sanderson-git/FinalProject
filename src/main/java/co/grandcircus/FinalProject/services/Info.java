package co.grandcircus.FinalProject.services;

public class Info {
	
	private String title;
	
	private String steamAppID;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSteamAppId() {
		return steamAppID;
	}

	public void setSteamAppId(String steamAppID) {
		this.steamAppID = steamAppID;
	}

	public Info(String title, String steamAppID) {
		super();
		this.title = title;
		this.steamAppID = steamAppID;
	}
	
	public Info() {
	}

}
