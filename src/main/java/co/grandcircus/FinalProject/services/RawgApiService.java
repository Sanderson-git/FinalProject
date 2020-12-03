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

	
}
