package co.grandcircus.FinalProject.services;

public class tag {

	private Integer id;
	private String name;
	private String slug;
	private String image_background;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSlug() {
		return slug;
	}
	
	public void setSlug(String slug) {
		this.slug = slug;
	}
	
	public String getImage_background() {
		return image_background;
	}
	
	public void setImage_background(String image_background) {
		this.image_background = image_background;
	}

	public tag(Integer id, String name, String slug, String image_background) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.image_background = image_background;
	}
	
	public tag() {
	}
	
}
