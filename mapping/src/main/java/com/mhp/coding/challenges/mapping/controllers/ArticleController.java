package com.mhp.coding.challenges.mapping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.services.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {

	private final ArticleService articleService;

	@Autowired
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@GetMapping()
	public List<ArticleDto> list() {
		return this.articleService.list();
	}

	@GetMapping("/{id}")
	public ArticleDto details(@PathVariable Long id) {
		ArticleDto articleDto = this.articleService.articleForId(id);
		if (articleDto == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Artikel nicht gefunden");
		}
		return articleDto;
	}

	@PostMapping()
	public ArticleDto create(@RequestBody ArticleDto articleDto) {
		return this.articleService.create(articleDto);
	}
}
