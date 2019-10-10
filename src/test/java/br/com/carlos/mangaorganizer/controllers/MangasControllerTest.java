package br.com.carlos.mangaorganizer.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.carlos.mangaorganizer.configurations.AppWebConfiguration;
import br.com.carlos.mangaorganizer.configurations.DataSourceConfigurationTest;
import br.com.carlos.mangaorganizer.configurations.JpaConfiguration;
import br.com.carlos.mangaorganizer.models.daos.MangaDAO;

@RunWith(value = SpringJUnit4ClassRunner.class)
@WebAppConfiguration()
@ContextConfiguration(classes = {AppWebConfiguration.class, JpaConfiguration.class, DataSourceConfigurationTest.class })
@ActiveProfiles(value = "test")
public class MangasControllerTest {
	
	@Autowired
	private MangaDAO mangaDAO;
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before 
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	//Testa se o request realmente esta sendo direcionado para o arquivo jsp informado e 
	//se o objeto mangas esta foi adicionado à resposta(para ficar disponivel para listagem).  
	@Test
	@Transactional
	public void shouldListMangasInUrlMangas() throws Exception {
		this.mockMvc.perform(get("/mangas"))
		.andExpect(MockMvcResultMatchers
				.model().attributeExists("mangas"))
		.andExpect(MockMvcResultMatchers
				.forwardedUrl("/WEB-INF/views/mangas/list.jsp"));
	}
	
	

}
