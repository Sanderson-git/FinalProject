package co.grandcircus.FinalProject.SQL;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name = "genres")
public class Genres {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long genreId;
	private String name;
	private String slug;
	private String image_background;
	
	
	@ManyToMany(mappedBy = "genres")
    private Set<WishList> wishlists;

	public Genres() {}
	
	public Genres(Long genreId, String name, String slug, String image_background) {
		super();
		this.genreId = genreId;
		this.name = name;
		this.slug = slug;
		this.image_background = image_background;
	}

	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
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

	public Set<WishList> getWishlists() {
		return wishlists;
	}

	public void setWishlists(Set<WishList> wishlists) {
		this.wishlists = wishlists;
	}


	
	
	
}
