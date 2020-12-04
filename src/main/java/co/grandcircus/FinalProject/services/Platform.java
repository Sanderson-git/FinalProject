package co.grandcircus.FinalProject.services;

public class Platform {

	private Integer id;
	private String name;
	private String slug;
	
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

	public Platform(Integer id, String name, String slug) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
	}
	
	public Platform() {
	}
	
}
