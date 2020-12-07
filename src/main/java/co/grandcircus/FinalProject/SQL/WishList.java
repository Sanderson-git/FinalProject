package co.grandcircus.FinalProject.SQL;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="wishlist")
public class WishList {

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
	
	@ManyToMany(mappedBy = "wishlists")
    private Set<Genres> genres;

	
	
	
	
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
