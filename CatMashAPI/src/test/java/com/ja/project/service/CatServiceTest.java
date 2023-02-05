package com.ja.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.server.ResponseStatusException;

import com.ja.project.model.Cat;

@Sql(scripts = "/test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@SpringBootTest
public class CatServiceTest {
	
	@Autowired
	ICatService catService; 
	
	@Test
	public void getTwoRandomCats_ShouldReturnTwoCats() {
		List<Cat> catPair = catService.getTwoRandomCats();
		assertEquals(2, catPair.size());
	}
	@Test
	public void getTwoRandomCats_ShouldReturnTwoDifferentCats() {
		for (int i = 0; i < 50; i++) {
			List<Cat> catPair = catService.getTwoRandomCats();
			assertFalse(catPair.get(0).getId() == catPair.get(1).getId());
		}
	}
	@Test
	public void voteForCatId_WhenHas3votes_ShouldReturn4Popularity() {
		ResponseEntity<Cat> responseEntity = catService.voteForCatId(1);
		assertEquals(4, responseEntity.getBody().getPopularity());
	}
	@Test
	public void voteForCatId_WhenHas0votes_ShouldReturn1Popularity() {
		ResponseEntity<Cat> responseEntity = catService.voteForCatId(5);
		assertEquals(1, responseEntity.getBody().getPopularity());
	}
	@Test
	public void voteForCatIde_WhenWrongId_ShouldThrowResponseStatusException() {
		try {
			catService.voteForCatId(105);
			assert false;
	    } catch (ResponseStatusException e) {
	    	assertEquals(new ResponseStatusException(HttpStatus.NOT_FOUND).getRawStatusCode(), e.getRawStatusCode());
	    }
	}
	@Test
	public void getAllOrderByPopularity_ShouldReturn6Cats() {
		List<Cat> results = catService.getAllOrderByPopularity();
		assertEquals(6, results.size());
	}
	@Test
	public void getAllOrderByPopularity_ShouldReturnInCorrectOrder() {
		List<Cat> results = catService.getAllOrderByPopularity();
		assertEquals("MTgwODA3MA", results.get(0).getJsonId());
		assertEquals("tt", results.get(1).getJsonId());
		assertEquals("bmp", results.get(2).getJsonId());
		assertEquals("c8a", results.get(3).getJsonId());
		assertEquals("3kj", results.get(4).getJsonId());
		assertEquals("9pu", results.get(5).getJsonId());
		
		assertTrue(results.get(0).getPopularity() > results.get(1).getPopularity());
		assertTrue(results.get(1).getPopularity() > results.get(2).getPopularity());
		assertTrue(results.get(2).getPopularity() > results.get(3).getPopularity());
		assertTrue(results.get(3).getPopularity() > results.get(4).getPopularity());
		assertTrue(results.get(4).getPopularity() > results.get(5).getPopularity());
	}
	@Test
	public void getTop5_ShouldReturn5Cats() {
		List<Cat> results = catService.getTop5();
		assertEquals(5, results.size());
	}
	@Test
	public void getTop5_ShouldReturnFirst5MostPopulars() {
		List<Cat> results = catService.getTop5();
		
		assertEquals("MTgwODA3MA", results.get(0).getJsonId());
		assertEquals("tt", results.get(1).getJsonId());
		assertEquals("bmp", results.get(2).getJsonId());
		assertEquals("c8a", results.get(3).getJsonId());
		assertEquals("3kj", results.get(4).getJsonId());
		
		assertTrue(results.get(0).getPopularity() > results.get(1).getPopularity());
		assertTrue(results.get(1).getPopularity() > results.get(2).getPopularity());
		assertTrue(results.get(2).getPopularity() > results.get(3).getPopularity());
		assertTrue(results.get(3).getPopularity() > results.get(4).getPopularity());
	}

}
