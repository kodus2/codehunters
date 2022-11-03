package hu.codehunters.helloapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String welcome() {
		return "Welcome my single site";
	}
}
