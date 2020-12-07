package co.grandcircus.FinalProject.SQL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "genres")
public class Genres {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long genreId;
	private String name;
	private String slug;
	private String image_background;
	@ManyToOne
	@JoinColumn(name = "wishlistid", nullable = true, updatable = true)
	private WishList wishlist;
	
	public Genres() {}
	
	public Genres(Long genreId, String name, String slug, String image_background, WishList wishlist) {
		super();
		this.genreId = genreId;
		this.name = name;
		this.slug = slug;
		this.image_background = image_background;
		this.wishlist = wishlist;
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

	public WishList getWishlist() {
		return wishlist;
	}

	public void setWishlist(WishList wishlist) {
		this.wishlist = wishlist;
	}
	
	
	
}
