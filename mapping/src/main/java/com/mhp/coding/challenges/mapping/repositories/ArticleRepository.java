package com.mhp.coding.challenges.mapping.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.db.ImageSize;
import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.GalleryBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.ImageBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.TextBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.VideoBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.VideoBlockType;

@Component
public class ArticleRepository {
	// Die Liste an Articles dieses Repositories
	final List<Article> result = new ArrayList<>();

	public List<Article> all() {
		this.result.add(this.createDummyArticle(1001L));
		this.result.add(this.createDummyArticle(2002L));
		this.result.add(this.createDummyArticle(3003L));
		this.result.add(this.createDummyArticle(4004L));
		this.result.add(this.createDummyArticle(5005L));
		return this.result;
	}

	/**
	 * Sucht anhand der ID im vorhanden Repository nach einem Article.
	 * 
	 * @param id Die ID des Articles, nach dem gesucht wird.
	 * 
	 * @return Der gefundene Article oder <i>null</i>, wenn dieser nicht gefunden
	 *         wurde.
	 */
	public Article findBy(Long id) {
		// Ohne ID kann auch nichts gefunden werden
		if (id == null) {
			return null;
		}
		// Die Liste an IDs durchiterieren
		for (Article article : this.result) {
			// IDs vergleichen
			if (id.equals(article.getId())) {
				// ID gefunden - prima
				return article;
			}
		}
		// Leider nichts gefunden
		return null;
	}

	public void create(Article article) {
		// Ignore
	}

	private Article createDummyArticle(Long id) {
		final Article result = new Article();
		result.setId(id);
		result.setAuthor("Max Mustermann");
		result.setDescription("Article Description " + id);
		result.setTitle("Article Nr.: " + id);
		result.setLastModifiedBy("Hans Müller");
		result.setLastModified(new Date());
		result.setBlocks(this.createBlocks(id));
		return result;
	}

	private Set<ArticleBlock> createBlocks(Long articleId) {
		final Set<ArticleBlock> result = new HashSet<>();

		final TextBlock textBlock = new TextBlock();
		textBlock.setText("Some Text for " + articleId);
		textBlock.setSortIndex(0);
		result.add(textBlock);

		final ImageBlock imageBlock = new ImageBlock();
		imageBlock.setImage(this.createImage(1L));
		imageBlock.setSortIndex(1); // bugfix
		result.add(imageBlock);

		final TextBlock secondTextBlock = new TextBlock();
		secondTextBlock.setText("Second Text for " + articleId);
		secondTextBlock.setSortIndex(2);
		result.add(secondTextBlock);

		final GalleryBlock galleryBlock = new GalleryBlock();
		galleryBlock.setSortIndex(3); // bugfix

		final List<Image> galleryImages = new ArrayList<>();
		galleryImages.add(this.createImage(2L));
		galleryImages.add(this.createImage(3L));
		galleryBlock.setImages(galleryImages);

		result.add(galleryBlock);

		final TextBlock thirdTextBlock = new TextBlock();
		thirdTextBlock.setText("Third Text for " + articleId);
		thirdTextBlock.setSortIndex(4);
		result.add(thirdTextBlock);

		final VideoBlock videoBlock = new VideoBlock();
		videoBlock.setType(VideoBlockType.YOUTUBE);
		videoBlock.setUrl("https://youtu.be/myvideo");
		videoBlock.setSortIndex(5);

		result.add(videoBlock);

		return result;
	}

	private Image createImage(Long imageId) {
		final Image result = new Image();
		result.setId(imageId);
		result.setLastModified(new Date());
		result.setLastModifiedBy("Max Mustermann");
		result.setImageSize(ImageSize.LARGE);
		result.setUrl("https://someurl.com/image/" + imageId);
		return null;
	}
}
