package co.grandcircus.FinalProject;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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
		
		
		
		RawgGame rawgGame = rawgapi.rawgGame(id); //get rawgGame object from api query using rawgId selected by previous api search
		model.addAttribute("rawgDetails",rawgGame); //add whole rawgGame object for details.jsp 
		System.out.println("here");
		Integer steamId = null; //initialize steam id variable for later cheapshark api query
		
		
		GameStoreResponse response = rawgapi.rawgStoreLink(id.toString());
		List<GameSpecificStore> stores = response.getResults(); //get list of StoreResults from rawg store call to find the steam Store and thereby the game id on it
		
		for(GameSpecificStore str : stores) { //loop through the StoreResults to find the steam Store
			if(str.getStore_id().compareTo("1") == 0) { //id is saaved as a String so use compareTo which returns an int, a return of 0 means true
				//if it is the Steam store, find the game Steam Id (there is no UPC (universal product code) listed on either api, the Steam Id for games on each api is used in lieu of this
				
				URI uri = null;
				try {
					uri = new URI(str.getUrl());
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
				String[] segments = uri.getPath().split("/");
				String idStr = segments[segments.length-1]; //the game-store id is listed on the StoreResults object
				
				steamId = Integer.parseInt(idStr); //get steam id
				System.out.println(steamId);
			}
		}
		
		
		CheapsharkGame sharkGame = csharkapi.getCheapsharkGameListViaSteamId(steamId); //using the steamId, find the corresponding game on Cheapshark api (contains pricing comparison information)
		
		CheapsharkGameDetails sharkDetails = csharkapi.cheapSharkGame(sharkGame.getGameId()); //using the game id from the CheapsharkGame object obtained by the steamId, get all Cheapshark game details (this will include all pricing comparison info)
		
		List<Deal> deals = sharkDetails.getDeals();//pricing from various stores
		
		model.addAttribute("deals",deals);
		model.addAttribute("sharkDetails",sharkDetails);
		
		return "details";
		
	}
	
	

	@GetMapping("/sessiontest")
	public String sessionTest(Model model) {
		User user = (User)session.getAttribute("user");
		if (user==null) {
			return "redirect:/";
		}
		model.addAttribute("user",user);
		return "sessiontest";
	}

	
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "sessiontest";
	}
}

