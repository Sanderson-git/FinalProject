package co.grandcircus.FinalProject.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CheapsharkApiService {

	private RestTemplate restTemplate = new RestTemplate();
	
	public void cheapSharkTestApiCall() {
		
		String url = "https://www.cheapshark.com/api/1.0/games?id=612";
		
		String json = restTemplate.getForObject(url, String.class);
		
		System.out.println("JSON RESPONSE:");
		System.out.println(json);
	}
	
	public CheapsharkGame[] getCheapsharkGameListViaSteamId (Integer steamId) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://www.cheapshark.com/api/1.0/games&steamAppID=" + steamId;
		return restTemplate.getForObject(url, CheapsharkGame[].class);
	}
	
	public CheapsharkGameDetails cheapSharkGame(String id) {
		String url = "https://www.cheapshark.com/api/1.0/games?id=" + id;
		return restTemplate.getForObject(url, CheapsharkGameDetails.class);
	}
	
}
