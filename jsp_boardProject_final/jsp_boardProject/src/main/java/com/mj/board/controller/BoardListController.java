package com.mj.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.board.dto.BoardDTO;
import com.mj.board.dto.CategoryDTO;
import com.mj.board.service.BoardService;
import com.mj.board.service.CategoryService;

@WebServlet("/tBoard")
@MultipartConfig
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		CategoryService categoryService = new CategoryService();
		BoardService boardService = new BoardService();

		String action = request.getParameter("action");
		String categoryId = request.getParameter("categoryId");
		if ("selectAll".equals(action)) {
			// 메인 창 board를 클릭하면 그리는 기능 boardMain 출력 기능
			ArrayList<CategoryDTO> categoryList = categoryService.selectAllCategory();
			ArrayList<BoardDTO> boardList = boardService.selectAllBoard();

			request.setAttribute("categoryList", categoryList);
			request.setAttribute("boardList", boardList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/test/board.jsp");
			dispatcher.forward(request, response);

			// 삭제 기능 bId를 이용해서 삭제
		} else if ("delete".equals(action)) {
			String bId = request.getParameter("bId");
			boardService.deleteByBoardId(Integer.parseInt(bId));
			ArrayList<CategoryDTO> categoryList = categoryService.selectAllCategory();
			ArrayList<BoardDTO> boardList = boardService.selectAllBoard();
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("boardList", boardList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/test/board.jsp");
			dispatcher.forward(request, response);
		} else if ("select".equals(action)) {
			// id기반으로 조회 후
			CategoryDTO dto = categoryService.selectByCategoryId(Integer.parseInt(categoryId));

			String categoryTitle = dto.getCategoryTitle();

			// 각 카테고리에 맞는 각 게시물 출력하는 기능
			ArrayList<BoardDTO> boardList = boardService.selectByCategoryBoard(categoryTitle);
			ArrayList<CategoryDTO> categoryList = categoryService.selectAllCategory();

			request.setAttribute("boardList", boardList);
			request.setAttribute("categoryList", categoryList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/test/board.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CategoryService categoryService = new CategoryService();
		BoardService boardService = new BoardService();

		String action = request.getParameter("action");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String writer = (String) request.getSession().getAttribute("id");
		String categoryId = request.getParameter("categoryId");

		if (action.equals("insert")) {
			// 쿼리문에 writer가 있기 때문에 writer가 무조건 있어야 함.
			BoardDTO boardDto = new BoardDTO(title, description, writer, Integer.parseInt(categoryId));
			boardService.insertByBoardDto(boardDto);

			// 데이터 삽입 후 전체 내용 출력용
			ArrayList<CategoryDTO> categoryList = categoryService.selectAllCategory();
			ArrayList<BoardDTO> boardList = boardService.selectAllBoard();

			request.setAttribute("categoryList", categoryList);
			request.setAttribute("boardList", boardList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/test/board.jsp");
			dispatcher.forward(request, response);

		} else if ("search".equals(action)) {
			// 검색 기능
			String keyword = request.getParameter("keyword");
			ArrayList<BoardDTO> boardSearchList = boardService.selectByTitle(keyword);
			request.setAttribute("boardList", boardSearchList);

			ArrayList<CategoryDTO> categoryList = categoryService.selectAllCategory();
			request.setAttribute("categoryList", categoryList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/test/board.jsp");
			dispatcher.forward(request, response);

		}

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");

	}
}
