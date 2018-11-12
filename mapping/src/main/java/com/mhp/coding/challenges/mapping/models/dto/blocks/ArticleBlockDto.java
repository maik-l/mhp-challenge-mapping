package com.mhp.coding.challenges.mapping.models.dto.blocks;

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;

public class ArticleBlockDto extends ArticleBlock {
	private int sortIndex;

	@Override
	public int getSortIndex() {
		return this.sortIndex;
	}

	@Override
	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}
}
