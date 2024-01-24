package com.lbg.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Hero;

@RestController
public class HeroController {

	@GetMapping("/hero")
	public String greeting() {
		return "Superhero!";
	}

	@PostMapping("/createhero")
	public String createHero(@RequestBody Hero newHero) {
		return newHero.toString();
	}
}
