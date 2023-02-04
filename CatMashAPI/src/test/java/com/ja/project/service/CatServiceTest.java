package com.ja.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

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
		for (int i = 0; i < 100; i++) {
			List<Cat> catPair = catService.getTwoRandomCats();
			assertFalse(catPair.get(0).getId() == catPair.get(1).getId());
		}
	}

}
