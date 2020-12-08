package co.grandcircus.FinalProject.services;

import java.util.List;

public class RawgGame {
	
	private String slug;
	private String name;
	private String playtime;
	private List<platformResults> platforms;
	private List<StoreResults> stores;
	private String released;
	private String background_image;
	private Double rating;
	private Double rating_top;
	private Integer ratings_count;
	private Integer metacritic;
	private Integer id;
	private List<tag> tags;
	private List<short_screenshot> short_screenshots;
	private List<Genre> genres;
	private String description_raw;
	private EsrbRating esrb_rating;
	
		
	
	public String getDescription_raw() {
		return description_raw;
	}

	public void setDescription_raw(String description_raw) {
		this.description_raw = description_raw;
	}

	public EsrbRating getEsrb_rating() {
		return esrb_rating;
	}

	public void setEsrb_rating(EsrbRating esrb_rating) {
		this.esrb_rating = esrb_rating;
	}

	public String getDescriptionRaw() {
		return description_raw;
	}

	public void setDescriptionRaw(String description_raw) {
		this.description_raw = description_raw;
	}

	public String getSlug() {
		return slug;
	}
	
	public void setSlug(String slug) {
		this.slug = slug;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPlaytime() {
		return playtime;
	}
	
	public void setPlaytime(String playtime) {
		this.playtime = playtime;
	}
	
	public List<platformResults> getPlatforms() {
		return platforms;
	}
	
	public void setPlatforms(List<platformResults> platforms) {
		this.platforms = platforms;
	}
	
	public List<StoreResults> getStores() {
		return stores;
	}
	
	public void setStores(List<StoreResults> stores) {
		this.stores = stores;
	}
	
	public String getReleased() {
		return released;
	}
	
	public void setReleased(String released) {
		this.released = released;
	}
	
	public String getBackground_image() {
		return background_image;
	}
	
	public void setBackground_image(String background_image) {
		this.background_image = background_image;
	}
	
	public Double getRating() {
		return rating;
	}
	
	public void setRating(Double rating) {
		this.rating = rating;
	}
	
	public Double getRating_top() {
		return rating_top;
	}
	
	public void setRating_top(Double rating_top) {
		this.rating_top = rating_top;
	}
	
	public Integer getRatings_count() {
		return ratings_count;
	}
	
	public void setRatings_count(Integer ratings_count) {
		this.ratings_count = ratings_count;
	}
	
	public Integer getMetacritic() {
		return metacritic;
	}
	
	public void setMetacritic(Integer metacritic) {
		this.metacritic = metacritic;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<tag> getTags() {
		return tags;
	}
	
	public void setTags(List<tag> tags) {
		this.tags = tags;
	}
	
	public List<short_screenshot> getShort_screenshots() {
		return short_screenshots;
	}
	
	public void setShort_screenshots(List<short_screenshot> short_screenshots) {
		this.short_screenshots = short_screenshots;
	}
	
	public List<Genre> getGenres() {
		return genres;
	}
	
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	
	public RawgGame(String slug, String name, String playtime, List<platformResults> platforms,
			List<StoreResults> stores, String released, String background_image, Double rating, Double rating_top,
			Integer ratings_count, Integer metacritic, Integer id, List<tag> tags,
			List<short_screenshot> short_screenshots, List<Genre> genres) {
		super();
		this.slug = slug;
		this.name = name;
		this.playtime = playtime;
		this.platforms = platforms;
		this.stores = stores;
		this.released = released;
		this.background_image = background_image;
		this.rating = rating;
		this.rating_top = rating_top;
		this.ratings_count = ratings_count;
		this.metacritic = metacritic;
		this.id = id;
		this.tags = tags;
		this.short_screenshots = short_screenshots;
		this.genres = genres;
	}
	
	public RawgGame() {
	}
	
}
