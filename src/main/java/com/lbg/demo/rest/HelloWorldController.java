package com.lbg.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/hello")
	public String greeting() {
		return "Hello, World!";
	}

	@GetMapping("/home")
	public String home() {
		return "Home Page";
	}

	@GetMapping("/goodbye")
	public String goodbye() {
		return "Goodbye, World!";
	}

}
