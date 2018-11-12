package com.mhp.coding.challenges.mapping.models.dto;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;

public class ArticleDto {

	private Long id;

	private String title;

	private String description;

	private String author;

	private Collection<ArticleBlockDto> blocks;

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Collection<ArticleBlockDto> getBlocks() {
		return this.blocks;
	}

	public void setBlocks(Collection<ArticleBlockDto> blocks) {
		// Die übergebenen Blöcke direkt sortieren
		SortedSet<ArticleBlockDto> sortierteCollecion = new TreeSet<ArticleBlockDto>();
		sortierteCollecion.addAll(blocks);
		// Die sortierte Collection als Field setzen
		this.blocks = sortierteCollecion;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
