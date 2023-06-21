package com.mj.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.board.dto.BoardDTO;
import com.mj.board.dto.CategoryDTO;
import com.mj.board.service.BoardService;
import com.mj.board.service.CategoryService;

@WebServlet("/boardDetail")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardDetailController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		CategoryService categoryService = new CategoryService();
		BoardService boardService = new BoardService();

		String action = request.getParameter("action");

		// 상세글, 조회수, 카테고리 타이틀
		if ("detail".equals(action)) {
			// 상세글
			// board.jsp의 a태그에 쿼리 파라미터의 boardId를 갖고 옴
			String boardId = request.getParameter("boardId");
			// boardId 기반으로 검색 select 실행
			BoardDTO boardByIdList = boardService.selectByBoardId(Integer.parseInt(boardId));
			request.setAttribute("boardByIdList", boardByIdList);

			// 조회수 board.jsp까지 update되도록
			boardService.update(boardByIdList.getView(), Integer.parseInt(boardId));

			// 카테고리 타이틀 상세글 페이지로 보내기 ! (option태그)
			// CategoryId를 가져와서 select를 하고
			// categoryId로 제목 하나씩 가져옴
			CategoryDTO categoryList = categoryService.selectByCategoryId(boardByIdList.getCategoryId());
			// categoryList의 CategoryTitle만 보냄.
			String title = categoryList.getCategoryTitle();
			request.setAttribute("title", title);

			RequestDispatcher dispatcher2 = request.getRequestDispatcher("test/boardById.jsp");
			dispatcher2.forward(request, response);

		} else if ("select".equals(action)) {
			ArrayList<CategoryDTO> categoryList = categoryService.selectAllCategory();
			ArrayList<BoardDTO> boardList = boardService.selectAllBoard();

			request.setAttribute("categoryList", categoryList);
			request.setAttribute("boardList", boardList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/test/board.jsp");
			dispatcher.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		
		CategoryService categoryService = new CategoryService();
		BoardService boardService = new BoardService();

		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String boardId = request.getParameter("boardId");
		String categoryTitle = request.getParameter("categoryTitle");
		// dao를 통해 title → categoryID추출
		int resultCategoryId = categoryService.selectCategoryTitle(categoryTitle);

		String action = request.getParameter("action");
		if ("update".equals(action)) {
			
			int responseUpdate = boardService.update(title, description, resultCategoryId, Integer.parseInt(boardId));

			request.setAttribute("responseUpdate", responseUpdate);

			ArrayList<CategoryDTO> categoryList = categoryService.selectAllCategory();
			ArrayList<BoardDTO> boardList = boardService.selectAllBoard();

			request.setAttribute("categoryList", categoryList);
			request.setAttribute("boardList", boardList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/test/board.jsp");
			dispatcher.forward(request, response);
		}

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
	}

}
