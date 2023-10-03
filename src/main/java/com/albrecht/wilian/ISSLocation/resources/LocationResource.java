package com.albrecht.wilian.ISSLocation.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LocationResource {
	
	@GetMapping("iss-location")
	public ResponseEntity issLocation() {
		
		
		
		return ResponseEntity.ok("");
	}
	
}
