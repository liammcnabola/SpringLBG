package com.lbg.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Cat;
import com.lbg.demo.services.CatService;

@RestController
public class CatController {


	private CatService service;

	public CatController(CatService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public String createCat(@RequestBody Cat newCat) {
		return this.service.createCat(newCat);
	}


	@GetMapping("/get")
	public List<Cat> getCats() {
		return this.service.getCats();
	}
	
	@GetMapping("/get/{id}")
	public Cat getCat(@PathVariable int id) {
		return this.service.getCat(id);
	}

	@DeleteMapping("/delete/{id}")
	public Cat deleteCat(@PathVariable int id) {
		return this.service.deleteCat(id);
	}

	@PutMapping("/update/{id}")
	public Cat update(@PathVariable int id, @RequestBody Cat newCat) {
		return this.service.update(id, newCat);

	}

	@PatchMapping("/patch/{id}")
	public Cat updateCat(@PathVariable int id, @RequestBody Cat catInfo) {
		return this.service.updateCat(id, catInfo);

	}

}


