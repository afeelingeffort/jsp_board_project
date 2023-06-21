package com.mj.board.dto;

public class CategoryDTO {
	private int categoryId;
	private String categoryTitle;

	public CategoryDTO() {
	}

	public CategoryDTO(int categoryId, String categoryTitle) {
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
	}

	public CategoryDTO(int categoryId) {
		super();
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "CategoryDTO [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + "]";
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

}
