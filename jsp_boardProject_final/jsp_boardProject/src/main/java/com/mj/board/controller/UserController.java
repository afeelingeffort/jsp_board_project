package com.mj.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.board.dto.UserDTO;
import com.mj.board.service.UserService;

@WebServlet("/userController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserService userService = new UserService();
		UserDTO userDTO = new UserDTO();

		String action = request.getParameter("action");
		// 회원가입 정보 입력
		if ("insert".equals(action)) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String nickname = request.getParameter("nickname");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String tel = request.getParameter("tel");
			
			userDTO = new UserDTO(id, pw, nickname, address, email, tel);
			userService.insertByUser(userDTO);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/test/join.jsp");
			dispatcher.forward(request, response);
		}

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
	}

}
