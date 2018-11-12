package com.mhp.coding.challenges.mapping.models.db.blocks;

public abstract class ArticleBlock implements Comparable<ArticleBlock> {

	private int sortIndex;

	public int getSortIndex() {
		return this.sortIndex;
	}

	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}

	@Override
	public int compareTo(ArticleBlock articleBlockToCompare) {
		if (this.sortIndex == articleBlockToCompare.getSortIndex()) {
			return 0;
		}
		return this.sortIndex > articleBlockToCompare.getSortIndex() ? 1 : -1;
	}
}
