package com.github.evgdim.unittestig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.github.evgdim.unittestig.controller.HomeController;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(HomeController.class)
public class UnitTestingApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void homeControllerTest() throws Exception {
		mockMvc
			.perform(get("/home"))
			.andExpect(status().isOk())
			.andExpect(content().string("index"));
	}
}
