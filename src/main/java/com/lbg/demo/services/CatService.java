package com.lbg.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Cat;
import com.lbg.demo.repos.CatRepo;

@Service
public class CatService {

	private CatRepo repo;

	public CatService(CatRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Cat> createCat(Cat newCat) {
		Cat created = this.repo.save(newCat);
		return new ResponseEntity<Cat>(created, HttpStatus.CREATED);
	}

	public List<Cat> getCats() {
		return this.repo.findAll();
	}

	public ResponseEntity<Cat> getCat(int id) {
		Optional<Cat> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<Cat>(HttpStatus.NOT_FOUND);
		}
		Cat body = found.get();
		return ResponseEntity.ok(body);
	}
		
	public ResponseEntity<Cat> updateCat(int id, Cat newCat) {
		Optional<Cat> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Cat>(HttpStatus.NOT_FOUND);
		}

		Cat existing = found.get();

		if (newCat.getName() != null) {
			existing.setName(newCat.getName());
		}
		if (newCat.getBreed() != null) {
			existing.setBreed(newCat.getBreed());
		}
		Cat updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);

	}

	public boolean delete(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
}


	}


