package com.ja.project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ja.project.model.Cat;

public interface ICatService {
	public List<Cat> getTop5();
	public List<Cat> getAllOrderByPopularity();
	public List<Cat> getTwoRandomCats();
	public ResponseEntity<Cat> voteForCatId(int id);
	
}
