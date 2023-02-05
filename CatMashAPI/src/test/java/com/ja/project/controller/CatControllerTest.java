package com.ja.project.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@Sql(scripts = "/test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@SpringBootTest
@AutoConfigureMockMvc
public class CatControllerTest {

	 @Autowired
	    protected MockMvc mockMvc;

	    private final String CONTROLLER_PATH = "/cats";
	    
	    @Test
	    public void testGetTop5() throws Exception {
	    	mockMvc.perform(MockMvcRequestBuilders.get(CONTROLLER_PATH + "/top"))
	    	.andExpect(status().isOk())
	    	.andExpect(jsonPath("$").isArray())
	    	.andExpect(jsonPath("$", hasSize(5)))
 			.andExpect(jsonPath("$[0].jsonId", is("MTgwODA3MA")))
 			.andExpect(jsonPath("$[0].popularity", is(10)))
 			.andExpect(jsonPath("$[1].jsonId", is("tt")))
 			.andExpect(jsonPath("$[1].popularity", is(4)))
 			.andExpect(jsonPath("$[2].jsonId", is("bmp")))
 			.andExpect(jsonPath("$[2].popularity", is(3)))
 			.andExpect(jsonPath("$[3].jsonId", is("c8a")))
 			.andExpect(jsonPath("$[3].popularity", is(2)))
 			.andExpect(jsonPath("$[4].jsonId", is("3kj")))
 			.andExpect(jsonPath("$[4].popularity", is(1)));
	    }
	    
	    @Test
	    public void testGetAll() throws Exception {
	    	mockMvc.perform(MockMvcRequestBuilders.get(CONTROLLER_PATH + "/all"))
	         	.andExpect(status().isOk())
		    	.andExpect(jsonPath("$").isArray())
		    	.andExpect(jsonPath("$", hasSize(6)))
	 			.andExpect(jsonPath("$[0].jsonId", is("MTgwODA3MA")))
	 			.andExpect(jsonPath("$[0].popularity", is(10)))
	 			.andExpect(jsonPath("$[1].jsonId", is("tt")))
	 			.andExpect(jsonPath("$[1].popularity", is(4)))
	 			.andExpect(jsonPath("$[2].jsonId", is("bmp")))
	 			.andExpect(jsonPath("$[2].popularity", is(3)))
	 			.andExpect(jsonPath("$[3].jsonId", is("c8a")))
	 			.andExpect(jsonPath("$[3].popularity", is(2)))
	 			.andExpect(jsonPath("$[4].jsonId", is("3kj")))
	 			.andExpect(jsonPath("$[4].popularity", is(1)))
		    	.andExpect(jsonPath("$[5].jsonId", is("9pu")))
		    	.andExpect(jsonPath("$[5].popularity", is(0)));
	    }

	    @Test
	    public void testGetContestants() throws Exception {
	    	 mockMvc.perform(MockMvcRequestBuilders.get(CONTROLLER_PATH))
             	.andExpect(status().isOk())
             	.andExpect(jsonPath("$").isArray())
     			.andExpect(jsonPath("$", hasSize(2)))
     			.andExpect(jsonPath("$[0].id", not(is(jsonPath("$[1].id")))));
	    }

	    @Test
	    public void testUpdate() throws Exception {
	    	mockMvc.perform(MockMvcRequestBuilders.put(CONTROLLER_PATH + "/1"))
	    	.andExpect(status().isOk())
	    	.andExpect(jsonPath("popularity", is(4)));
	    	
	    	mockMvc.perform(MockMvcRequestBuilders.put(CONTROLLER_PATH + "/1"))
	    	.andExpect(status().isOk())
	    	.andExpect(jsonPath("popularity", is(5)));
	    	
	    	mockMvc.perform(MockMvcRequestBuilders.get(CONTROLLER_PATH + "/top"))
	    	.andExpect(status().isOk())
	    	.andExpect(jsonPath("$").isArray())
	    	.andExpect(jsonPath("$", hasSize(5)))
 			.andExpect(jsonPath("$[0].jsonId", is("MTgwODA3MA")))
 			.andExpect(jsonPath("$[0].popularity", is(10)))
 			.andExpect(jsonPath("$[1].jsonId", is("bmp")))
 			.andExpect(jsonPath("$[1].popularity", is(5)))
 			.andExpect(jsonPath("$[2].jsonId", is("tt")))
 			.andExpect(jsonPath("$[2].popularity", is(4)))
 			.andExpect(jsonPath("$[3].jsonId", is("c8a")))
 			.andExpect(jsonPath("$[3].popularity", is(2)))
 			.andExpect(jsonPath("$[4].jsonId", is("3kj")))
 			.andExpect(jsonPath("$[4].popularity", is(1)));
	    }
	    
}
