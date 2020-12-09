package co.grandcircus.FinalProject;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import co.grandcircus.FinalProject.SQL.*;
import co.grandcircus.FinalProject.services.*;

@Controller
public class FinalController {

	@Autowired
	RawgApiService rawgapi;

	@Autowired
	CheapsharkApiService csharkapi;

	@Autowired
	UserRepository userrep;

	@Autowired
	WishListRepository wishrep;

	@Autowired
	GenresRepository genresrep;

	@Autowired
	HttpSession session;

	@Autowired
	CheapSharkStoreNameRepository csstorerep;

//	@GetMapping("/")
//	private String index () {
//		System.out.println("RAWG API: ");
//		rawgapi.rawgTestApiCall();
//		System.out.println("CHEAP SHARK API: ");
//		csharkapi.cheapSharkTestApiCall();
//		return "index";
//	}

//	@GetMapping("/")
//	private String index (String titleName, Model model) {
//		CheapsharkGame csharkGame = csharkapi.getCheapsharkGameListViaSteamId("35140");
//		model.addAttribute("cheapsharkGame", csharkGame);
//		System.out.println(csharkGame.getExternal());
//		return "index";
//	}

//	@GetMapping("/")
//	private String index () {
//		RawgResponse rResp = rawgapi.rawgSearch("Batman");
//		System.out.println(rResp.getNext());
//		return "index";
//	}

//	@GetMapping("/")
//	private String index () {
//		RawgGame rGame = rawgapi.rawgGame(2235);
//		System.out.println(rGame.getName());
//		return "index";
//	}

//	@GetMapping("/")
//	private String index () {
//		CheapsharkGameDetails cSharkGameDetails = csharkapi.cheapSharkGame(612);
//		System.out.println(cSharkGameDetails.getInfo().getTitle());
//		return "index";
//	}

	@GetMapping("/")
	private String index(Model model) {
		RawgResponse rResp = rawgapi.rawgHomeList();
		model.addAttribute("rawglist", rResp);
		return "index";
	}

	@GetMapping("/login")
	private String login() {
		return "login";
	}

	@PostMapping("/sessiontest")
	public String login(String username, String password, Model model) {
		User user = userrep.findFirstByUsername(username).orElse(null);
		if (user == null) {
			return "fail";
		} else {
			if (user.getPassword().compareTo(password) == 0) {

				session.setAttribute("user", user);
				model.addAttribute("user", user);
				return "sessiontest";
			} else {
				return "fail";

			}

		}
	}

	@GetMapping("/details/{id}")
	private String gameDetails(@PathVariable Integer id, Model model) {

		// System.out.println("1");

		RawgGame rawgGame = rawgapi.rawgGame(id); // get rawgGame object from api query using rawgId selected by
													// previous api search
		model.addAttribute("rawgDetails", rawgGame); // add whole rawgGame object for details.jsp
		// System.out.println("2");
		Integer steamId = null; // initialize steam id variable for later cheapshark api query

		GameStoreResponse response = rawgapi.rawgStoreLink(id.toString());
		// System.out.println("3");
		List<GameSpecificStore> stores = response.getResults(); // get list of StoreResults from rawg store call to find
																// the steam Store and thereby the game id on it

		for (GameSpecificStore str : stores) { // loop through the StoreResults to find the steam Store
			if (str.getStore_id().compareTo("1") == 0) { // id is saaved as a String so use compareTo which returns an
															// int, a return of 0 means true
				// if it is the Steam store, find the game Steam Id (there is no UPC (universal
				// product code) listed on either api, the Steam Id for games on each api is
				// used in lieu of this
				// System.out.println("4");
				URI uri = null;
				try {
					uri = new URI(str.getUrl());
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
				String[] segments = uri.getPath().split("/");
				System.out.println(segments.length);
				String idStr = segments[2]; // the game-store id is listed on the StoreResults object
				System.out.println(idStr);
				steamId = Integer.parseInt(idStr); // get steam id
				// System.out.println(steamId);
			}
		}

		CheapsharkGame[] sharkGames = csharkapi.getCheapsharkGameListViaSteamId(steamId); // using the steamId, find the
																							// corresponding game on
																							// Cheapshark api (contains
																							// pricing comparison
																							// information)

		CheapsharkGame sharkGame;

		if (sharkGames.length == 0) {
			return "redirect:/";
		} else {
			sharkGame = sharkGames[0];
		}

		CheapsharkGameDetails sharkDetails = csharkapi.cheapSharkGame(sharkGame.getGameId()); // using the game id from
																								// the CheapsharkGame
																								// object obtained by
																								// the steamId, get all
																								// Cheapshark game
																								// details (this will
																								// include all pricing
																								// comparison info)

		// System.out.println("6");
		List<Deal> deals = sharkDetails.getDeals();// pricing from various stores

		List<PrettyDeal> realdeals = new ArrayList<>();
		// link to deal through cheapshark
		// https://www.cheapshark.com/redirect?dealID={id}
		for (Deal d : deals) {
			PrettyDeal prettydeal = new PrettyDeal();
			prettydeal.setStoreID(d.getStoreID());
			prettydeal.setPrice(d.getPrice());
			prettydeal.setDealID(d.getDealID());
			// System.out.println(prettydeal.getStoreID());
			prettydeal.setStoreName(csstorerep.findById(d.getStoreID()).orElse(null).getStorename()); // setting
																										// Prettydeal
																										// store name
																										// equal to
																										// cheapsharkstore
																										// repo
																										// storename,
																										// finding by
																										// STRING id.

			realdeals.add(prettydeal);
		}

		String retail = deals.get(0).getRetailPrice(); // pulling retail price
		Double retaildouble = Double.parseDouble(retail); // changing retail price to double
		String playtime = rawgGame.getPlaytime(); // pulling average playtime from RAWG
		Double playtimedouble = Double.parseDouble(playtime); // changing playtime to double
		Double pricephour = retaildouble / playtimedouble; // price per hour calculation based on average playtime and
															// retail price
		DecimalFormat twoPlaces = new DecimalFormat("0.00"); // formatting to 2 decimal places
		String finalpricephour = twoPlaces.format(pricephour); // assigning string the price per hour with 2 decimal
																// place formatting

		model.addAttribute("pricephour", finalpricephour);
		model.addAttribute("steamid", steamId);
		model.addAttribute("sharkgame", sharkGame);
		model.addAttribute("deals", realdeals);
		model.addAttribute("sharkDetails", sharkDetails);

		return "details";

	}

	@GetMapping("/sessiontest")
	public String sessionTest(Model model) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "sessiontest";
		}
		model.addAttribute("user", user);
		return "sessiontest";
	}

	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "sessiontest";
	}

	@PostMapping("/searchresults")
	private String searchResults(@RequestParam String search, Model model) {
		RawgResponse results = rawgapi.rawgSearch(search); // calls function rawgSearch using html search text box
															// parameter "search"
		List<RawgGame> games = results.getResults();
		model.addAttribute("games", games);
		return "searchresults";
	}

	@GetMapping("/recommendations")
	private String userRecom(Model model) {

		User user = (User) session.getAttribute("user"); // get user by session
		model.addAttribute("user", user); // add user to session

		if (user == null) {
			return "redirect:/login";
		}

		List<WishList> wishGames = wishrep.findByUserId(user.getId()); // get wishlist games by user id

		List<Genres> wishGenres = new ArrayList<>(); // start list for wishlist genres

		wishGenres.addAll(genresrep.findByWishlistsIn(wishGames)); // adds all of each game's genres to genres list

		Set<Genres> uniqueGenres = new HashSet<Genres>(wishGenres); // only want to loop through genres that the user
																	// has within their wishlist

		int topG = 0; // initializing variables for genre recommendations
		Long topGid = null;
		int secondG = 0;
		Long secondGid = null;
		int thirdG = 0;
		Long thirdGid = null;
		int total = 0;

		Map<Long, Integer> genreCount = new HashMap<>();

		for (Genres g : uniqueGenres) { // looping through genres from wishlist

			int match = 0;

			for (int i = 0; i < wishGenres.size(); i++) { // adding counts for genres via wishlist

				if (wishGenres.get(i) == g) {

					match++;
					total++;

				} else {
				}

			}
			genreCount.put(g.getGenreId(), match);

		}

		for (Map.Entry<Long, Integer> entry : genreCount.entrySet()) { // establishing genre ranks and adding to map

			if (entry.getValue() > topG) {
				topGid = entry.getKey();
				topG = entry.getValue();
			}
		}
		for (Map.Entry<Long, Integer> entry : genreCount.entrySet()) { // establishing genre ranks and adding to map

			if (entry.getValue() > secondG && entry.getValue() < topG) {
				secondGid = entry.getKey();
				secondG = entry.getValue();
			}
		}
		for (Map.Entry<Long, Integer> entry : genreCount.entrySet()) { // establishing genre ranks and adding to map

			if (entry.getValue() > thirdG && entry.getValue() < secondG) {
				thirdGid = entry.getKey();
				thirdG = entry.getValue();
			}

		}

		Set<RawgGame> resultSet = new HashSet<>(); // switch to set collection to avoid duplicate game results

		if (topGid != null) {
			RawgResponse resultsOne = rawgapi.rawgGenreList(topGid.toString()); // calling API for top ranked genres
			if (resultsOne != null) {
				resultSet.addAll(resultsOne.getResults());
			}
		}

		if (secondGid != null) {
			RawgResponse resultsTwo = rawgapi.rawgGenreList(secondGid.toString()); // calling API for top ranked genres
			if (resultsTwo != null) {
				resultSet.addAll(resultsTwo.getResults());
			}
		}

		if (thirdGid != null) {
			RawgResponse resultsThree = rawgapi.rawgGenreList(thirdGid.toString()); // calling API for top ranked genres
			if (resultsThree != null) {
				resultSet.addAll(resultsThree.getResults());
			}
		}
		
		model.addAttribute("games", resultSet); // adding Set collection with 3 RAWG api game lists to model
		return "recommendations";
	}

	@GetMapping("/add/{rawgid}/{steamid}/{csharkid}")
	public String addToWishlist(@PathVariable Integer rawgid, @PathVariable Integer steamid,
			@PathVariable Integer csharkid, Model model) {

		RawgGame rawgGame = rawgapi.rawgGame(rawgid); // api call to get rawgGame object and genre list

		model.addAttribute("rawgGame", rawgGame);

		User user = (User) session.getAttribute("user"); // get user from session
		if (user == null) {
			return "redirect:/login";
		}	
		
		WishList wishes = new WishList(); // initial wishlist

		wishes.setUser(user); // save user object to wishlist for repo mapping
		System.out.println(user.getId());

		wishes.setName(rawgGame.getName());
		wishes.setRawgId(rawgid);
		wishes.setSteamId(steamid);
		wishes.setCsharkId(csharkid);
		wishes.setBackground_image(rawgGame.getBackground_image());
		wishes.setRating(rawgGame.getRating());

		List<Genre> gameGenres = rawgGame.getGenres();

		Set<Genres> wishlistGenres = new HashSet<>();

		for (Genre genre : gameGenres) {

			Genres genres = genresrep.getOne(genre.getId());
			// System.out.println(genres.getName());

			wishlistGenres.add(genres);
		}

		wishes.setGenres(wishlistGenres);
		

		wishrep.save(wishes);

		return "redirect:/wishlist";
	}

	@GetMapping("/wishlist")
	public String viewWishlist(Model model) {

		User user = (User) session.getAttribute("user"); // get user from session

		if (user == null) {
			return "redirect:/login";
		}

		System.out.println(user.getId());

		List<WishList> wishes = wishrep.findByUserId(user.getId()); // find all wishlist games for a specific user
		System.out.println(wishes);

		for (WishList wish : wishes) {

			CheapsharkGameDetails gameDetails = csharkapi.cheapSharkGame(wish.getCsharkId().toString());
			List<Deal> gameDeals = gameDetails.getDeals();
			System.out.println(gameDeals);
			wish.setPrice(Double.parseDouble((gameDeals.get(0).getPrice())));

			for (Deal g : gameDeals) {

				Double price = Double.parseDouble(g.getPrice());
				Double wishPrice = wish.getPrice();

				// System.out.println(price);
				// System.out.println(wishPrice);

				if (wishPrice >= price) {
					wish.setPrice(Double.parseDouble(g.getPrice()));

					wish.setStoreId(g.getStoreID());
					wish.setDealId(g.getDealID());

					System.out.println(wish.getPrice());
					System.out.println(wish.getName());

				}
			}
		}
		model.addAttribute("games", wishes);

		return "wishlist";
	}

	@PostMapping("/wishlist/setalert/{wishlistid}")
	public String setAlert(@PathVariable Long wishlistid, @RequestParam Integer setalert) {
		WishList cheapscate = wishrep.findById(wishlistid).orElse(null);
		cheapscate.setDesiredprice(setalert);
		wishrep.save(cheapscate);
		return "redirect:/wishlist";
	}

	@GetMapping("/wishlist/{id}")
	public String deleteFromWishlist(@PathVariable Long id) {
		wishrep.deleteById(id);
		return "redirect:/wishlist";
	}
	
	@GetMapping("/searchresults/{genreid}")
	public String searchByGenre(@PathVariable Long genreid, Model model) {
		
		RawgResponse results = rawgapi.rawgGenreList(genreid.toString()); 
		
		List<RawgGame> games = results.getResults();
		
		model.addAttribute("games", games);
		
		return "searchresults";
	}

}
