package com.ja.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja.project.service.ICatService;

@RestController
@RequestMapping("/cat")
public class CatController {

	@Autowired
	private ICatService catService;
	
	
}
