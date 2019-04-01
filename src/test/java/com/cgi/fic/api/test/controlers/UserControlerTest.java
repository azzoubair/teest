package com.cgi.fic.api.test.controlers;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControlerTest {

	
	@Autowired
	private WebApplicationContext ctx;

	private MockMvc restUserMockMvc;

	@Before
	public void setup() {
		this.restUserMockMvc = 
				MockMvcBuilders
						.webAppContextSetup(ctx)
						.defaultRequest(get("/*"))
						.defaultRequest(post("/*"))
						.defaultRequest(put("/*"))
						.defaultRequest(delete("/*"))
						.build();
	}
	
    @Test
	public void testGetAllUsers() throws Exception {
    	MvcResult res = restUserMockMvc
			.perform(get("/users"))
			.andDo(print())
			.andExpect(jsonPath("$", notNullValue()))
			.andReturn();	
    	assertThat(res.getResponse().getStatus()).isEqualTo(200);
    	assertThat(res.getResponse().getContentAsString()).contains("Vador");
	}
    /*Test de la méthode getUserByLastName*/
    @Test
   	public void testGetUserName() throws Exception {
       	MvcResult res = restUserMockMvc
   			.perform(get("/users/vador"))
   			.andDo(print())
   			.andExpect(jsonPath("$", notNullValue()))
   			.andReturn();	
       	assertThat(res.getResponse().getStatus()).isEqualTo(200);
       	assertThat(res.getResponse().getContentAsString()).contains("Vador");
   	}
    
}
