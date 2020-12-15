package co.grandcircus.FinalProject.services;

public class screenshotResults {
	
	private Integer id;
	private String image;
	private Integer width;
	private Integer height;
	private boolean is_deleted;
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
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public boolean isIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	public screenshotResults(Integer id, String image, Integer width, Integer height, boolean is_deleted) {
		super();
		this.id = id;
		this.image = image;
		this.width = width;
		this.height = height;
		this.is_deleted = is_deleted;
	}
	
	public screenshotResults() {
	}

}
