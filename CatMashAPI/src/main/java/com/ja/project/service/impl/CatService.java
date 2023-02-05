package com.ja.project.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ja.project.model.Cat;
import com.ja.project.repository.CatRepository;
import com.ja.project.service.ICatService;

@Service
public class CatService implements ICatService {

	@Autowired
	private CatRepository catRepository;

	@Override
	public List<Cat> getTop5() {
		return catRepository.findTop5ByOrderByPopularityDesc();
	}

	@Override
	public List<Cat> getAllOrderByPopularity() {
		return catRepository.findAllByOrderByPopularityDesc();
	}

	@Override
	public List<Cat> getTwoRandomCats() {
		
		Long catNumber = catRepository.count();
		int id1 = generateRandomCatId(catNumber);
		int id2 = generateRandomCatId(catNumber);
		while(id1 == id2) {
			id2 = generateRandomCatId(catNumber);
		}
		Cat cat1 = catRepository.findById(id1).get();
		Cat cat2 = catRepository.findById(id2).get();
		return Arrays.asList(new Cat[]{cat1, cat2});
	}

	private int generateRandomCatId(Long catNumber) {
		return (int) ((Math.random() * (catNumber - 1)) + 1);
	}

	@Override
	public ResponseEntity<Cat> voteForCatId(int id) {
		Optional<Cat> dbCat = catRepository.findById(id);
		if (dbCat.isPresent()) {
			Cat cat = dbCat.get();
			cat.vote();
			Cat updatedCat = catRepository.save(cat);
			return ResponseEntity.ok(updatedCat);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

}
