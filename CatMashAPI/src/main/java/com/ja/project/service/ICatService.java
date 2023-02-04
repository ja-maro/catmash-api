package com.ja.project.service;

import java.util.List;

import com.ja.project.model.Cat;

public interface ICatService {
	public List<Cat> getTop5();
	public List<Cat> getAllOrderByPopularity();
	public List<Cat> getTwoRandomCats();
	
}
