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
}
