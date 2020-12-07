package co.grandcircus.FinalProject.services;

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
	
}
