package com.albrecht.wilian.ISSLocation.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.albrecht.wilian.ISSLocation.models.Location;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
@RequestMapping("/api")
public class LocationResource {
	
	private RestTemplate restTemplate;
	
	@GetMapping("iss-location")
	public ResponseEntity issLocation() {
		
		restTemplate = new RestTemplate();
		
		
		JsonObject jsonObject = JsonParser.parseString(restTemplate.getForObject("http://api.open-notify.org/iss-now.json", String.class)).getAsJsonObject();
		
		JsonObject issPosition = jsonObject.getAsJsonObject("iss_position");
		
		Location location = new Location(issPosition.get("latitude").getAsString(), issPosition.get("longitude").getAsString());
		
		return ResponseEntity.ok(location);
	}
	
}
