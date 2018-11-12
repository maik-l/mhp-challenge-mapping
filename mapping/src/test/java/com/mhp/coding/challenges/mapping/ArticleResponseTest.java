package com.mhp.coding.challenges.mapping;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mhp.coding.challenges.mapping.controllers.ArticleController;
import com.mhp.coding.challenges.mapping.services.ArticleService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ArticleController.class, secure = false)
public class ArticleResponseTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ArticleService articleService;

	@Test
	public void retrieveArticles() throws Exception {
		// TODO response des webservice prüfen, prüfen ob alle dummyartikel komme,
		// prüfen, ob response bei korrekter article-id kommt, prüfen, ob 404 kommt
		// this.articleService = new ArticleService(new ArticleRepository(), new
		// ArticleMapper());
		// Mockito.when(this.articleService.list()).thenReturn(this.articleService.list());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/article").accept(MediaType.APPLICATION_JSON);
		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		Assert.assertEquals("", HttpStatus.OK.value(), result.getResponse().getStatus());
	}

}
