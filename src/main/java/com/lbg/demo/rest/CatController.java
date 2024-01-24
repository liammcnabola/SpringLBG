package com.lbg.demo.rest;

import java.util.ArrayList;
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

@RestController
public class CatController {

	private List<Cat> cats = new ArrayList<>();

	@PostMapping("/create")
	public String createCat(@RequestBody Cat newCat) {
		this.cats.add(newCat);
		return cats.toString();
	}


	@GetMapping("/get")
	public List<Cat> getCats() {
		return cats;
	}
	
	@GetMapping("/get/{id}")
	public Cat getCat(@PathVariable int id) {
		return this.cats.get(id);
	}

	@DeleteMapping("/delete/{id}")
	public Cat deleteCat(@PathVariable int id) {
		return this.cats.remove(id);
	}

	@PutMapping("/update/{id}")
	public Cat update(@PathVariable int id, @RequestBody Cat newCat) {
		return this.cats.set(id, newCat);

	}

	@PatchMapping("/patch/{id}")
	public Cat updateCat(@PathVariable int id, @RequestBody Cat catInfo) {
		Cat cat = this.cats.get(id);
		cat.setName(catInfo.getName());
		cat.setBreed(catInfo.getBreed());
		return cat;
	}

}


