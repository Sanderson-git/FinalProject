package co.grandcircus.FinalProject.services;

public class short_screenshot {

	private Integer id;
	private String image;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}

	public short_screenshot(Integer id, String image) {
		super();
		this.id = id;
		this.image = image;
	}
	
	public short_screenshot() {
	}
	
}
