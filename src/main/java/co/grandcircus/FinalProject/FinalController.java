package co.grandcircus.FinalProject;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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
	private String index (Model model) {
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
		
		//System.out.println("1");
		
		RawgGame rawgGame = rawgapi.rawgGame(id); //get rawgGame object from api query using rawgId selected by previous api search
		model.addAttribute("rawgDetails",rawgGame); //add whole rawgGame object for details.jsp 
		//System.out.println("2");
		Integer steamId = null; //initialize steam id variable for later cheapshark api query
		
		
		GameStoreResponse response = rawgapi.rawgStoreLink(id.toString());
		//System.out.println("3");
		List<GameSpecificStore> stores = response.getResults(); //get list of StoreResults from rawg store call to find the steam Store and thereby the game id on it
		
		for(GameSpecificStore str : stores) { //loop through the StoreResults to find the steam Store
			if(str.getStore_id().compareTo("1") == 0) { //id is saaved as a String so use compareTo which returns an int, a return of 0 means true
				//if it is the Steam store, find the game Steam Id (there is no UPC (universal product code) listed on either api, the Steam Id for games on each api is used in lieu of this
				//System.out.println("4");
				URI uri = null;
				try {
					uri = new URI(str.getUrl());
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
				String[] segments = uri.getPath().split("/");
				String idStr = segments[segments.length-1]; //the game-store id is listed on the StoreResults object
				
				steamId = Integer.parseInt(idStr); //get steam id
				//System.out.println(steamId);
			}
		}
		
		
		CheapsharkGame sharkGame = csharkapi.getCheapsharkGameListViaSteamId(steamId); //using the steamId, find the corresponding game on Cheapshark api (contains pricing comparison information)
		//System.out.println(sharkGame.getGameId());
		
		CheapsharkGameDetails sharkDetails = csharkapi.cheapSharkGame(sharkGame.getGameId()); //using the game id from the CheapsharkGame object obtained by the steamId, get all Cheapshark game details (this will include all pricing comparison info)
		
		//System.out.println("6");
		List<Deal> deals = sharkDetails.getDeals();//pricing from various stores
		
		List<PrettyDeal> realdeals = new ArrayList<>();
				// link to deal through cheapshark https://www.cheapshark.com/redirect?dealID={id}
		for (Deal d : deals) {
			PrettyDeal prettydeal = new PrettyDeal();
			prettydeal.setStoreID(d.getStoreID());
			prettydeal.setPrice(d.getPrice());
			prettydeal.setDealID(d.getDealID());
			//System.out.println(prettydeal.getStoreID());
			prettydeal.setStoreName(csstorerep.findById(d.getStoreID()).orElse(null).getStorename()); // setting Prettydeal store name equal to cheapsharkstore repo storename, finding by STRING id.
			
			realdeals.add(prettydeal);
		}
		
		model.addAttribute("steamid", steamId);
		model.addAttribute("sharkgame", sharkGame);		
		model.addAttribute("deals", realdeals);
		model.addAttribute("sharkDetails",sharkDetails);
		
		return "details";
		
	}
	
	

	@GetMapping("/sessiontest")
	public String sessionTest(Model model) {
		User user = (User)session.getAttribute("user");
		if (user==null) {
			return "sessiontest";
		}
		model.addAttribute("user",user);
		return "sessiontest";
	}

	
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "sessiontest";
	}
	
	@PostMapping("/searchresults")
	private String searchResults(@RequestParam String search, Model model) {
		RawgResponse results = rawgapi.rawgSearch(search); //calls function rawgSearch using html search text box parameter "search"
	    List<RawgGame> games = results.getResults();
		model.addAttribute("games", games);
		return "searchresults";
	}
	
	@GetMapping("/recommendations")
	private String userRecom(Model model) {
		
		User user = (User)session.getAttribute("user");  // get user by session
		
		List<WishList> wishGames = wishrep.findByUserId(user.getId()); // get wishlist games by user id
		
		List<Genres> wishGenres = new ArrayList<>(); //start list for wishlist genres
		
		for(WishList game : wishGames) { // loops through wishlist games to get each game's genres
			
			wishGenres.addAll(genresrep.findByWishlistId(game.getWishlistid())); //adds all of each game's genres to genres list
			
		}
		
		Set<Genres> uniqueGenres = new HashSet<Genres>(wishGenres); //only want to loop through genres that the user has within their wishlist
		
		int topG = 0;
		String topGname = "";
		int secondG = 0;
		String secondGname = "";
		int thirdG = 0;
		String thirdGname = "";	
		int total = 0;
		
		for(Genres g : uniqueGenres) {

			
			for(int i=0; i < wishGenres.size(); i++ ) {
				
				int match = 0;
				
				if(wishGenres.get(i) == g) {
					
					match++;
					total++;
					
				} else {}
				
				if(match > topG) {
					topGname = g.getName();
					topG = match;
				} else if (match > secondG) {
					secondGname = g.getName();
					secondG = match;
				} else if (match > thirdG) {
					thirdGname = g.getName();
					thirdG = match;
				} else {}
									
			}
			
		}
		
		
		
		
		//top game for genre: search by genre & store & (ordering query rating - may default to this)
		
		return "recommendations";
	}
	
	@GetMapping("/add/{rawgid}/{steamid}/{csharkid}")
	public String addToWishlist(@PathVariable Integer rawgid,@PathVariable Integer steamid,@PathVariable Integer csharkid, Model model) {
		
		RawgGame rawgGame = rawgapi.rawgGame(rawgid); //api call to get rawgGame object and genre list
		
		model.addAttribute("rawgGame",rawgGame);
		
		User user = (User)session.getAttribute("user"); //get user from session
		if (user == null) {
			return "redirect:/login";
		}
		WishList wishes = new WishList(); //initial wishlist
		
		wishes.setUser(user); //save user object to wishlist for repo mapping
		System.out.println(user.getId());
		
		wishes.setName(rawgGame.getName());
		wishes.setRawgId(rawgid);
		wishes.setSteamId(steamid);
		wishes.setCsharkId(csharkid);
		
		List<Genre> gameGenres = rawgGame.getGenres();
		
		Set<Genres> wishlistGenres = new HashSet<>();
		
		for(Genre genre : gameGenres) {
			
			Genres genres = genresrep.getOne(genre.getId());
			//System.out.println(genres.getName());
						
			wishlistGenres.add(genres);
			
		}
		
		wishes.setGenres(wishlistGenres);
				
		wishrep.save(wishes);
				
		return "redirect:/wishlist";
	}
	
	@GetMapping("/wishlist")
	public String viewWishlist(Model model) {
		
		User user = (User)session.getAttribute("user"); //get user from session
		System.out.println(user.getId());
		
		List<WishList> wishes = wishrep.findByUserId(user.getId()); //find all wishlist games for a specific user
		System.out.println(wishes);
		
		for(WishList wish : wishes) {
			
			CheapsharkGameDetails gameDetails = csharkapi.cheapSharkGame(wish.getCsharkId().toString());
			List<Deal> gameDeals = gameDetails.getDeals();
			System.out.println(gameDeals);
			wish.setPrice(Double.parseDouble((gameDeals.get(0).getPrice())));
			
						
			for (Deal g : gameDeals) {
			
				Double price = Double.parseDouble(g.getPrice());
				Double wishPrice = wish.getPrice();
				
				//System.out.println(price);
				//System.out.println(wishPrice);
				
				if (wishPrice >= price) {
					wish.setPrice(Double.parseDouble(g.getPrice()));
				
					
					
					wish.setStoreId(g.getStoreID());
					wish.setDealId(g.getDealID());
					
					System.out.println(wish.getPrice());
					System.out.println(wish.getName());
				
				}
			}	
			
			model.addAttribute("wish", wish);
			
		}
		
		
		
		return "wishlist";
	}
	
	
	@GetMapping("/wishlist/{id}")
	public String deleteFromWishlist(@PathVariable Long id) {
		wishrep.deleteById(id);
		return "redirect:/wishlist";
	}
	
	
	
	
}

