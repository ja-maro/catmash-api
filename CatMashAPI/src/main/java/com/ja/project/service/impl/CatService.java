package com.ja.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.project.repository.CatRepository;
import com.ja.project.service.ICatService;

@Service
public class CatService implements ICatService {

	@Autowired
	private CatRepository catRepository;
}
