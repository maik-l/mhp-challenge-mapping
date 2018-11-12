package com.mhp.coding.challenges.mapping.mappers;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;

@Component
public class ArticleMapper {

	/**
	 * Wandelt ein Objekt vom Typ Article in Datentransferobjekt vom Typ ArticleDto
	 * um.
	 * 
	 * @param article Das Objekt, welches umgewandelt werden soll.
	 * 
	 * @return Das umgewandelte Objekt oder ein leeres ArticleDto-Objekt, wenn der
	 *         article <i>null</i> ist. Gibt nie <i>null</i> zurück..
	 */
	@SuppressWarnings("unchecked")
	public static ArticleDto map(Article article) {
		// Rückgabeobjekt
		ArticleDto articleDto = new ArticleDto();
		// Übergebenes Objekt ist leer - dann haben wir Trauer
		if (article == null) {
			return articleDto;
		}
		// Werte übergeben
		articleDto.setAuthor(article.getAuthor());
		if (article.getBlocks() != null) {
			// Kleine Schweinerei am Rande
			articleDto.setBlocks((Collection<ArticleBlockDto>) (Collection<?>) article.getBlocks());
		}
		articleDto.setDescription(article.getDescription());
		articleDto.setId(article.getId());
		articleDto.setTitle(article.getTitle());
		// Umgewandeltes Objekt zurück geben
		return articleDto;
	}

	public Article map(ArticleDto articleDto) {
		// Nicht Teil dieser Challenge.
		return new Article();
	}
}
