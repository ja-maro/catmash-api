package com.ja.project.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.ja.project.model.Cat;

@Sql(scripts = "/test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@SpringBootTest
public class CatRepositoryTest {

	@Autowired
	CatRepository catRepository;
	
	@Test
	public void count_ShouldReturn6() {
		Long result = catRepository.count();
		assertEquals(6, result);
	}
	@Test
	public void findAllOrderByPopularity_ShouldReturn6Cats() {
		List<Cat> results = catRepository.findAllByOrderByPopularityDesc();
		assertEquals(6, results.size());
	}
	@Test
	public void findById_When3_ShouldReturn_tt() {
		Optional<Cat> result = catRepository.findById(3);
		assertTrue(result.isPresent());
		assertEquals("tt", result.get().getJsonId());
	}
	@Test
	public void findAllOrderByPopularity_ShouldReturnInCorrectOrder() {
		List<Cat> results = catRepository.findAllByOrderByPopularityDesc();
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
	public void findTop5ByOrderByPopularityDesc_ShouldReturn5Cats() {
		List<Cat> results = catRepository.findTop5ByOrderByPopularityDesc();
		assertEquals(5, results.size());
	}
	@Test
	public void findTop5ByOrderByPopularityDesc_ShouldReturnFirst5MostPopulars() {
		List<Cat> results = catRepository.findTop5ByOrderByPopularityDesc();
		
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
