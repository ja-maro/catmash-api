package com.ja.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja.project.model.Cat;
import com.ja.project.service.ICatService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cats")
public class CatController {

	@Autowired
	private ICatService catService;
	
	@GetMapping
	public ResponseEntity<List<Cat>> getContestants() {
		List<Cat> results = catService.getTwoRandomCats();
		return ResponseEntity.ok(results);
	}

	@GetMapping("/top")
	public ResponseEntity<List<Cat>> getTop5() {
		List<Cat> results = catService.getTop5();
		return ResponseEntity.ok(results);
	}
	
	@GetMapping("/all")
    public ResponseEntity<List<Cat>> getAll() {
        List<Cat> results = catService.getAllOrderByPopularity();
        return ResponseEntity.ok(results);
    }
	
    @PutMapping("/{id}")
    public ResponseEntity<Cat> update(@PathVariable int id) {
        return catService.voteForCatId(id);
    }
	
}
