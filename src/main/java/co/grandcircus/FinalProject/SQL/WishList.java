package co.grandcircus.FinalProject.SQL;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import co.grandcircus.FinalProject.services.EsrbRating;


@Entity
@Table(name="wishlist")
public class WishList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long wishlistid;
	@ManyToOne
	@JoinColumn(name = "id", nullable = true, updatable = true)
	private User user;
	private String name;
	private Integer rawgId;
	private Integer csharkId;
	private Integer steamId;
	private String dealId;
	private String storeId;
	private Double price;
	private String background_image;
	private Double rating;
	private Integer desiredprice;
	
	
	
	
	public Integer getDesiredprice() {
		return desiredprice;
	}

	public void setDesiredprice(Integer desiredprice) {
		this.desiredprice = desiredprice;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getBackground_image() {
		return background_image;
	}

	public void setBackground_image(String background_image) {
		this.background_image = background_image;
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(joinColumns = @JoinColumn(name = "wishlistid"), inverseJoinColumns = @JoinColumn(name = "genre_id")) //each relationship has an owning side --in this case wishlist.  usually you will assign one side, you will be adding genres to wishlist therefore wishlist is owning side
    private Set<Genres> genres;

	
	
	
	
	public Set<Genres> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genres> genres) {
		this.genres = genres;
	}

	public WishList() {}
	
	public WishList(Long wishlistid, User user, String name, Integer rawgId, Integer csharkId, Integer steamId) {
		super();
		this.wishlistid = wishlistid;
		this.user = user;
		this.name = name;
		this.rawgId = rawgId;
		this.csharkId = csharkId;
		this.steamId = steamId;
	}

	public Long getWishlistid() {
		return wishlistid;
	}

	public void setWishlistid(Long wishlistid) {
		this.wishlistid = wishlistid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRawgId() {
		return rawgId;
	}

	public void setRawgId(Integer rawgId) {
		this.rawgId = rawgId;
	}

	public Integer getCsharkId() {
		return csharkId;
	}

	public void setCsharkId(Integer csharkId) {
		this.csharkId = csharkId;
	}

	public Integer getSteamId() {
		return steamId;
	}

	public void setSteamId(Integer steamId) {
		this.steamId = steamId;
	}
	
	
}
