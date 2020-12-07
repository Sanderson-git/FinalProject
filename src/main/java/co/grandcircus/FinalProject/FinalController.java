package co.grandcircus.FinalProject;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/details")
	private String details(Model model) {
		
		return "details";
	}
	
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

