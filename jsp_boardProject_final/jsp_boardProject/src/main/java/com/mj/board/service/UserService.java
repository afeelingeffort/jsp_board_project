package com.mj.board.service;

import com.mj.board.dto.UserDTO;
import com.mj.board.repository.UserDAO;

public class UserService {

	private UserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}

	public int insertByUser(UserDTO userDTO) {
		int result = 0;
		result = userDAO.insert(userDTO);
		return result;
	}

	public UserDTO select(String id, String pw) {
		UserDTO dto = userDAO.select(id, pw);
		return dto;
	}
}
