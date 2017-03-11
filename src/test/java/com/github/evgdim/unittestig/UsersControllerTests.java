package com.github.evgdim.unittestig;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.github.evgdim.unittestig.controller.UserController;
import com.github.evgdim.unittestig.domain.User;
import com.github.evgdim.unittestig.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UsersControllerTests {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UserService userService;

    @Before
    public void setup() {       
        given(this.userService.findAllUsers())
        		.willReturn(Arrays.asList(
        				new User(1L,"first",(short)15),
        				new User(2L,"second",(short)17)
        		));
    }
	
	@Test
	public void homeControllerTest() throws Exception {
		mockMvc
			.perform(get("/users"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", Matchers.hasSize(2)))
			.andExpect(jsonPath("$[1].name", Matchers.is("second")));
	}
}
