package com.cgi.fic.api.test.controlers;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cgi.fic.api.resources.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {

	
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
	
    
    /*Test de la méthode getUserByLastName*/
    @Test
   	public void testLogin() throws Exception {
    	/*User user = new User();
    	user.setUserId("dvador");
    	user.setPassword("motdepasse");*/
    	String user = "{\n" +
    			 " \"userId\": \"dvador\", \n" +
    			" \"password\": \"motdepasse\" \n" +
    			"}";
    	MvcResult res = restUserMockMvc
   			.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(user) )
   			.andExpect(status().isOk())
   			/*.andExpect(jsonPath("$.userId", Matchers.is("dvador")))
   			.andExpect(jsonPath("$.password", Matchers.is("motdepasse")))
   			.andExpect(jsonPath("$.*", Matchers.hasSize(2)))*/
   			.andReturn();
    	assertThat(res.getResponse().getStatus()).isEqualTo(200);
       	assertThat(res.getResponse().getContentAsString()).contains("Vador");
	
       	
   	}
    
   
    
}


