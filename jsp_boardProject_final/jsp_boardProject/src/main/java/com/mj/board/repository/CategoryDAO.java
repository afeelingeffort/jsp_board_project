package com.mj.board.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mj.board.dto.CategoryDTO;
import com.mj.board.utils.DBHelper;

public class CategoryDAO implements ICategoryDAO {

	private Connection conn;

	public CategoryDAO() {
		DBHelper dbHelper = new DBHelper();
		conn = dbHelper.getConnection();
	}

	@Override
	public ArrayList<CategoryDTO> selectCategoryAll() {
		ArrayList<CategoryDTO> list = new ArrayList<>();
		String query = " SELECT * FROM category ORDER BY categoryId ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int categoryId = rs.getInt("categoryId");
				String categoryTitle = rs.getString("categoryTitle");

				CategoryDTO dto = new CategoryDTO(categoryId, categoryTitle);
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("select 오류 발생");
			e.printStackTrace();
		} finally {
			try {
				// 혹시 순서가 달라서 오류가 날 수도 있음.
				pstmt.close();
				rs.close();
				pstmt = null;
			} catch (SQLException e) {
				System.out.println("categoryDao select 오류");
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public CategoryDTO selectByCategoryId(int categoryId) {
		
		CategoryDTO dto = new CategoryDTO();
		String query = " SELECT * FROM category WHERE categoryId=? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, categoryId);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			while (rs.next()) {
				//이거 나중에 바꿔야될 수도
				int id = rs.getInt("categoryId");
				String categoryTitle = rs.getString("categoryTitle");
				
				dto.setCategoryId(id);
				dto.setCategoryTitle(categoryTitle);
			}
		} catch (SQLException e) {
			System.out.println("select(int id) 오류 발생");
			e.printStackTrace();
		} finally {
			try {
				// 혹시 순서가 달라서 오류가 날 수도 있음.
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

		return dto;
	}

	@Override
	public int select(String categoryTitle) {
		int resultCategoryId = 0;
		String query = " SELECT categoryId FROM category WHERE categoryTitle = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, categoryTitle);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			while (rs.next()) {
				//이거 나중에 바꿔야될 수도
				resultCategoryId = rs.getInt("categoryId");
			}
		} catch (SQLException e) {
			System.out.println("select(int id) 오류 발생");
			e.printStackTrace();
		} finally {
			try {
				// 혹시 순서가 달라서 오류가 날 수도 있음.
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultCategoryId;
	}

}
