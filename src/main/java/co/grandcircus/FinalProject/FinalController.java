package co.grandcircus.FinalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.grandcircus.FinalProject.services.*;

@Controller
public class FinalController {
	
	@Autowired
	RawgApiService rawgapi;
	
	@Autowired
	CheapsharkApiService csharkapi;
	
	@GetMapping("/")
	private String index () {
//		System.out.println("RAWG API: ");
//		rawgapi.rawgTestApiCall();
		System.out.println("CHEAP SHARK API: ");
		csharkapi.cheapSharkTestApiCall();
		return "index";
	}

}
