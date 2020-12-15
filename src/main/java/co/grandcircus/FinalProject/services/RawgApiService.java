package co.grandcircus.FinalProject.services;

import java.util.Random;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;



@Service
public class RawgApiService {
	
private RestTemplate restTemplate = new RestTemplate();
	
	public void rawgTestApiCall() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "Crypt");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		String url = "https://api.rawg.io/api/games?key=e0efad9eb53c4cc093062888db16e142&dates=2019-09-01,2019-09-30&platforms=18,1,7";
		ResponseEntity<String> json = restTemplate.exchange(url, HttpMethod.GET , entity, String.class);
		System.out.println("JSON RESPONSE:");
		System.out.println(json.getBody());
	}
	
	
	public RawgResponse rawgSearch (String search) {
		String url = "https://api.rawg.io/api/games?key=e0efad9eb53c4cc093062888db16e142&search=" + search + "&stores=1";
		HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "Crypt");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		System.out.println(url);
		try {
			return restTemplate.exchange(url, HttpMethod.GET , entity,RawgResponse.class).getBody();
		}
		catch(HttpStatusCodeException e) {
			System.out.println("************************!!!!Error 502 sleeping 2.5sec !!!!!!!************************");
			try
				{
				Thread.sleep(2500);
			}
			catch(InterruptedException e2) {}
			return restTemplate.exchange(url, HttpMethod.GET , entity,RawgResponse.class).getBody();
		}
	}
	
	public RawgGame rawgGame (Integer gameId) {
		String url = "https://api.rawg.io/api/games/" + gameId + "?key=e0efad9eb53c4cc093062888db16e142";
		HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "Crypt");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		System.out.println(url);
		try {
			return restTemplate.exchange(url, HttpMethod.GET , entity,RawgGame.class).getBody();
		}
		catch(HttpStatusCodeException e) {
			System.out.println("************************!!!!Error 502 sleeping 2.5sec !!!!!!!************************");
			try
				{
				Thread.sleep(2500);
			}
			catch(InterruptedException e2) {}
		return restTemplate.exchange(url, HttpMethod.GET , entity,RawgGame.class).getBody();
		}
	}
	

	public GameStoreResponse rawgStoreLink(String gamepk) {
		String url = "https://api.rawg.io/api/games/" + gamepk + "/stores?key=e0efad9eb53c4cc093062888db16e142";
		HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "Crypt");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		System.out.println(url);
		try {
			return restTemplate.exchange(url, HttpMethod.GET , entity,GameStoreResponse.class).getBody();
		}
		catch(HttpStatusCodeException e) {
			System.out.println("************************!!!!Error 502 sleeping 2.5sec !!!!!!!************************");
			try
				{
				Thread.sleep(2500);
			}
			catch(InterruptedException e2) {}
		return restTemplate.exchange(url, HttpMethod.GET , entity,GameStoreResponse.class).getBody();
		}
	}
	

	public RawgResponse rawgHomeList() {	
		// create instance of Random class 
        Random rand = new Random(); 
        // Generate random integers in range 0 to 498
        int pageNumber = (rand.nextInt(498)+1);
		String url = "https://api.rawg.io/api/games?page=" + pageNumber + "&stores=1&key=e0efad9eb53c4cc093062888db16e142";
		HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "Crypt");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		System.out.println(url);
		try {
			return restTemplate.exchange(url, HttpMethod.GET , entity,RawgResponse.class).getBody();
		}
		catch(HttpStatusCodeException e) {
			System.out.println("************************!!!!Error 502 sleeping 2.5sec !!!!!!!************************");
			try
				{
				Thread.sleep(2500);
			}
			catch(InterruptedException e2) {}
		return restTemplate.exchange(url, HttpMethod.GET , entity,RawgResponse.class).getBody();
		}
	}
	
	public RawgResponse popular2019() {	
		String url = "https://api.rawg.io/api/games?dates=2019-01-01,2019-12-31&ordering=-added&store=1&key=e0efad9eb53c4cc093062888db16e142";
		HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "Crypt");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		System.out.println(url);
		try {
			return restTemplate.exchange(url, HttpMethod.GET , entity,RawgResponse.class).getBody();
		}
		catch(HttpStatusCodeException e) {
			System.out.println("************************!!!!Error 502 sleeping 2.5sec !!!!!!!************************");
			try
				{
				Thread.sleep(2500);
			}
			catch(InterruptedException e2) {}
		return restTemplate.exchange(url, HttpMethod.GET , entity,RawgResponse.class).getBody();
		}
	}
	
	public RawgResponse rawgGenreList (String genreid) {
		String url = "https://api.rawg.io/api/games?genres=" + genreid + "&key=e0efad9eb53c4cc093062888db16e142";
		HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "Crypt");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		System.out.println(url);
		try {
			return restTemplate.exchange(url, HttpMethod.GET , entity,RawgResponse.class).getBody();
		}
		catch(HttpStatusCodeException e) {
			System.out.println("************************!!!!Error 502 sleeping 2.5sec !!!!!!!************************");
			try
				{
				Thread.sleep(2500);
			}
			catch(InterruptedException e2) {}
		return restTemplate.exchange(url, HttpMethod.GET , entity,RawgResponse.class).getBody();
		}
	}
	
	public ScreenshotResponse rawgScreenshotList (Integer gameId) {
		String url = "https://api.rawg.io/api/games/" + gameId + "/screenshots?key=e0efad9eb53c4cc093062888db16e142";
		HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "Crypt");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		System.out.println(url);
		try {
			return restTemplate.exchange(url, HttpMethod.GET , entity, ScreenshotResponse.class).getBody();
		}
		catch(HttpStatusCodeException e) {
			System.out.println("************************!!!!Error 502 sleeping 2.5sec !!!!!!!************************");
			try
				{
				Thread.sleep(2500);
			}
			catch(InterruptedException e2) {}
		return restTemplate.exchange(url, HttpMethod.GET , entity,ScreenshotResponse.class).getBody();
		}
	}
}

