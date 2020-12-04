package co.grandcircus.FinalProject.services;

public class Info {
	
	private String title;
	
	private String steamAppId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSteamAppId() {
		return steamAppId;
	}

	public void setSteamAppId(String steamAppId) {
		this.steamAppId = steamAppId;
	}

	public Info(String title, String steamAppId) {
		super();
		this.title = title;
		this.steamAppId = steamAppId;
	}
	
	public Info() {
	}

}
