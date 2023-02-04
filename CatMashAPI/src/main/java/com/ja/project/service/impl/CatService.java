package com.ja.project.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
}
