package com.mj.board.repository;

import java.util.ArrayList;

import com.mj.board.dto.BoardDTO;

public interface IBoardDAO {
	// 전체 게시물 조회 기능
	ArrayList<BoardDTO> selectBoardMain();

	// 게시물 상세글 조회 기능
	BoardDTO selectByBoardId(int boardId);

	// 게시물 카테고리별 조회 기능
	ArrayList<BoardDTO> select(String categoryTitle);

	// 카테고리별 게시물 조회 기능
	ArrayList<BoardDTO> selectByCategoryTitle(String categoryTitle);

	// 게시물 검색 기능
	ArrayList<BoardDTO> selectByTitle(String title);

	// 게시물 작성 기능
	int insert(BoardDTO boardDTO);

	// 게시물 아이디 기반 삭제 기능
	int delete(int boardId);

	// 게시물 아이디 기반 수정 기능
	int update(String title, String description, int categoryId, int boardId);

	// 조회수 증가 기능
	int update(int view, int boardId);

}
