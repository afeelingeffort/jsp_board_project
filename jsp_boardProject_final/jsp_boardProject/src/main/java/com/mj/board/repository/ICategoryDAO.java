package com.mj.board.repository;

import java.util.ArrayList;

import com.mj.board.dto.CategoryDTO;

public interface ICategoryDAO {

	// 전체 카테고리 출력
	ArrayList<CategoryDTO> selectCategoryAll();

	// 카테고리 아이디 기반 조회 기능
	CategoryDTO selectByCategoryId(int categoryId);

	int select(String categoryTitle);

}
