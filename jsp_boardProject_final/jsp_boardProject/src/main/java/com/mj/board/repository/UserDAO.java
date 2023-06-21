package com.mj.board.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mj.board.dto.UserDTO;
import com.mj.board.utils.DBHelper;

public class UserDAO implements IUserDAO {

	private Connection conn;

	public UserDAO() {
		DBHelper dbHelper = new DBHelper();
		conn = dbHelper.getConnection();
	}

	@Override
	public int insert(UserDTO userDTO) {
		int resultCnt = 0;
		String sql = " INSERT INTO user(id, pw, address, email, tel) " + " VALUES(?, ?, ?, ?, ?) ";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDTO.getId());
			pstmt.setString(2, userDTO.getPw());
			pstmt.setString(3, userDTO.getAddress());
			pstmt.setString(4, userDTO.getEmail());
			pstmt.setString(5, userDTO.getTel());

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("UserDAO insert에서 오류났어");
			e.printStackTrace();
		}

		return resultCnt;
	}

	@Override
	public UserDTO select(String id, String pw) {
		UserDTO dto = null;
		String query = " SELECT * FROM user WHERE id=? AND pw=? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto = new UserDTO();

				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
			}

		} catch (SQLException e) {
			System.out.println("user select(id, pw) 오류 발생");
			e.printStackTrace();
		}

		return dto;
	}
}
