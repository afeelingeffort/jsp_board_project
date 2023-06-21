package com.mj.board.service;

import java.util.ArrayList;

import com.mj.board.dto.BoardDTO;
import com.mj.board.repository.BoardDAO;

public class BoardService {

	private BoardDAO boardDAO;

	public BoardService() {
		boardDAO = new BoardDAO();
	}

	// 전체 게시물 조회
	public ArrayList<BoardDTO> selectAllBoard() {
		ArrayList<BoardDTO> boardList = boardDAO.selectBoardMain();
		return boardList;
	}

	public BoardDTO selectByBoardId(int boardId) {
		BoardDTO boardDto = boardDAO.selectByBoardId(boardId);
		return boardDto;
	}

	// 카테고리별 게시물 조회
	public ArrayList<BoardDTO> selectByCategoryBoard(String categoryTitle) {
		ArrayList<BoardDTO> boardList = boardDAO.selectByCategoryTitle(categoryTitle);
		return boardList;
	}

	public ArrayList<BoardDTO> selectByTitle(String keyword) {
		ArrayList<BoardDTO> boardList = boardDAO.selectByTitle(keyword);
		System.out.println(boardList);
		return boardList;
	}

	public int insertByBoardDto(BoardDTO boardDTO) {
		int result = 0;
		result = boardDAO.insert(boardDTO);
		return result;
	}

	public int deleteByBoardId(int boardId) {
		int result = 0;
		result = boardDAO.delete(boardId);
		return result;
	}

	public int update(String title, String description, int categoryId, int boardId) {
		int result = boardDAO.update(title, description, categoryId, boardId);
		return result;
	}

	public int update(int view, int boardId) {
		int result = boardDAO.update(view, boardId);
		return result;
	}
}
