package com.lbg.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Cat;

@Service
public class CatService {


	private List<Cat> cats = new ArrayList<>();

	public String createCat(Cat newCat) {
		this.cats.add(newCat);
		return cats.toString();
	}

	public List<Cat> getCats() {
		return cats;
	}

	public Cat getCat(int id) {
		return this.cats.get(id);
	}

	public Cat deleteCat(int id) {
		return this.cats.remove(id);
	}

	public Cat update(int id, Cat newCat) {
		return this.cats.set(id, newCat);

	}

	public Cat updateCat(int id, Cat catInfo) {
		Cat cat = this.cats.get(id);
		cat.setName(catInfo.getName());
		cat.setBreed(catInfo.getBreed());
		return cat;
	}

}
