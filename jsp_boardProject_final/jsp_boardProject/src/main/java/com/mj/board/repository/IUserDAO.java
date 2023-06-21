package com.mj.board.repository;

import com.mj.board.dto.UserDTO;

public interface IUserDAO {
	
	// 회원가입 기능
	int insert(UserDTO userDTO);

	// 로그인 기능
	UserDTO select(String id, String pw);
}
