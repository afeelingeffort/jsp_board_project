package com.mj.board.service;

import java.util.ArrayList;

import com.mj.board.dto.CategoryDTO;
import com.mj.board.repository.CategoryDAO;

public class CategoryService {

	private CategoryDAO categoryDAO;

	public CategoryService() {
		categoryDAO = new CategoryDAO();
	}

	public ArrayList<CategoryDTO> selectAllCategory() {
		ArrayList<CategoryDTO> categoryDTO = new ArrayList<>();
		categoryDTO = categoryDAO.selectCategoryAll();
		return categoryDTO;
	}

	public CategoryDTO selectByCategoryId(int categoryId) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO = categoryDAO.selectByCategoryId(categoryId);
		return categoryDTO;
	}

	// int select(String categoryTitle);
	public int selectCategoryTitle(String categoryTitle) {
		int resultCnt = categoryDAO.select(categoryTitle);
		return resultCnt;
	}

}
