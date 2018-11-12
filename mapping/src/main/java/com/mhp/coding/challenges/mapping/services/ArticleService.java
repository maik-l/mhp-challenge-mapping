package com.mhp.coding.challenges.mapping.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhp.coding.challenges.mapping.mappers.ArticleMapper;
import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.repositories.ArticleRepository;

@Service
public class ArticleService {

	private final ArticleRepository repository;

	private final ArticleMapper mapper;

	@Autowired
	public ArticleService(ArticleRepository repository, ArticleMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	/**
	 * Erzeugt aus dem Repository dieser Instanz eine Liste an ArticleDtos und gibt
	 * diese zurück.
	 * 
	 * @return Die Liste mit ArticleDtos, kann leer sein. Es wird nie <i>null</i>
	 *         zurück gegeben.
	 */
	public List<ArticleDto> list() {
		// Liste, die zurück gegeben wird, erzeugen
		ArrayList<ArticleDto> articleDtoList = new ArrayList<>();
		// ein leeres Repository bringt nichts
		if (this.repository == null || this.repository.all().size() == 0) {
			return articleDtoList;
		}
		// Liste der Articles aus dem Repository ziehen
		final List<Article> articles = this.repository.all();
		// Alle Article in ArticleDtos mappen
		for (Article article : articles) {
			articleDtoList.add(ArticleMapper.map(article));
		}
		return articleDtoList;
	}

	/**
	 * Nimmt eine übergebene ID und sucht im Repository des Services nach dem
	 * dazugehörigen Article. Wenn der Article gefunden wurde, wird der Article in
	 * ein ArticleDto umgewandelt und zurück gegeben.
	 * 
	 * @param id Die ID des Articles, der gewünscht ist.
	 * 
	 * @return Der gefundene Article als ArticleDto oder <i>null</i>, wenn zu er ID
	 *         nichts gefunden wurde.
	 */
	public ArticleDto articleForId(Long id) {
		// ein leeres Repository bringt nichts
		if (this.repository == null || this.repository.all().size() == 0) {
			return null;
		}
		// Rückgabeobjekt definieren
		ArticleDto articleDto = null;
		// Article über die ID suchen
		final Article article = this.repository.findBy(id);
		// Article wurde gefunden
		if (article != null) {
			// Article in ein ArticleDto mappen
			articleDto = ArticleMapper.map(article);
		}
		return articleDto;
	}

	public ArticleDto create(ArticleDto articleDto) {
		final Article create = this.mapper.map(articleDto);
		this.repository.create(create);
		return this.mapper.map(create);
	}
}
