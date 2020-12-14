package co.grandcircus.FinalProject.services;

import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class RawgApiService {
	
private RestTemplate restTemplate = new RestTemplate();
	
	public void rawgTestApiCall() {
		
		String url = "https://api.rawg.io/api/games?key=e0efad9eb53c4cc093062888db16e142&dates=2019-09-01,2019-09-30&platforms=18,1,7";
		String json = restTemplate.getForObject(url, String.class);
		System.out.println("JSON RESPONSE:");
		System.out.println(json);
	}

	public RawgResponse rawgSearch (String search) {
		String url = "https://api.rawg.io/api/games?key=e0efad9eb53c4cc093062888db16e142&search=" + search + "&stores=1";
		return restTemplate.getForObject(url, RawgResponse.class);
	}
	
	public RawgGame rawgGame (Integer gameId) {
		String url = "https://api.rawg.io/api/games/" + gameId + "?key=e0efad9eb53c4cc093062888db16e142";
		return restTemplate.getForObject(url, RawgGame.class);
	}
	

	public GameStoreResponse rawgStoreLink(String gamepk) {
		String url = "https://api.rawg.io/api/games/" + gamepk + "/stores?key=e0efad9eb53c4cc093062888db16e142";
		return restTemplate.getForObject(url,GameStoreResponse.class);
	}
	

	public RawgResponse rawgHomeList() {	
		// create instance of Random class 
        Random rand = new Random(); 
        // Generate random integers in range 0 to 498
        int pageNumber = (rand.nextInt(498)+1);
		String url = "https://api.rawg.io/api/games?page=" + pageNumber + "&stores=1";
		return restTemplate.getForObject(url, RawgResponse.class);
	}
	
	public RawgResponse popular2019() {	
		String url = "https://api.rawg.io/api/games?dates=2019-01-01,2019-12-31&ordering=-added&store=1";
		return restTemplate.getForObject(url, RawgResponse.class);
	}
	
	public RawgResponse rawgGenreList (String genreid) {
		String url = "https://api.rawg.io/api/games?genres=" + genreid;
		return restTemplate.getForObject(url, RawgResponse.class);
	}
}

