package com.mj.board.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mj.board.dto.BoardDTO;
import com.mj.board.dto.CategoryDTO;
import com.mj.board.utils.DBHelper;

public class BoardDAO implements IBoardDAO {

	private Connection conn;

	public BoardDAO() {
		DBHelper dbHelper = new DBHelper();
		conn = dbHelper.getConnection();
	}

	@Override
	public ArrayList<BoardDTO> selectBoardMain() {
		ArrayList<BoardDTO> list = new ArrayList<>();
		String query = " SELECT boardId, title, writer, createdAt, view FROM board ORDER BY boardId DESC ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int boardId = rs.getInt("boardId");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String createdAt = rs.getString("createdAt");
				int view = rs.getInt("view");

				BoardDTO dto = new BoardDTO(boardId, title, writer, createdAt, view);
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("BoardDAO select 오류 발생");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return list;
	}

	@Override
	public ArrayList<BoardDTO> select(String categoryTitle) {
		ArrayList<BoardDTO> list = new ArrayList<>();
		String sql = " SELECT b.boardId as id, b.title as title, b.writer as writer, b.createdAt as createdAt, b.view as `view` "
				+ " FROM board as b " + " INNER JOIN category as c " + " ON b.categoryId = c.categoryId "
				+ " WHERE c.categoryTitle = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, categoryTitle);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoardId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setCreatedAt(rs.getString("createdAt"));
				dto.setView(rs.getInt("view"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public BoardDTO selectByBoardId(int boardId) {
		BoardDTO dto = new BoardDTO();
		String query = " SELECT * FROM board WHERE boardId = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("boardId");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String writer = rs.getString("writer");
				String createdAt = rs.getString("createdAt");
				int view = rs.getInt("view");
				int categoryId = rs.getInt("categoryId");

				view++;

				dto.setBoardId(id);
				dto.setTitle(title);
				dto.setDescription(description);
				dto.setWriter(writer);
				dto.setCreatedAt(createdAt);
				dto.setView(view);
				dto.setCategoryId(categoryId);

			}
		} catch (SQLException e) {
			System.out.println("BoardDAO select(int boardId) 오류 발생");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return dto;
	}

	@Override
	public ArrayList<BoardDTO> selectByCategoryTitle(String categoryTitle) {
		ArrayList<BoardDTO> list = new ArrayList<>();
		String sql = " SELECT b.boardId as id, b.title as title, b.writer as writer, b.createdAt as createdAt, b.view as `view` "
				+ " FROM board as b " + " INNER JOIN category as c " + " ON b.categoryId = c.categoryId "
				+ " WHERE c.categoryTitle = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, categoryTitle);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoardId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setCreatedAt(rs.getString("createdAt"));
				dto.setView(rs.getInt("view"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public int insert(BoardDTO boardDTO) {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		String sql = " INSERT INTO board (title, description, writer, view, categoryId) " + " VALUES(?, ?, ?, ?, ?) ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getTitle());
			pstmt.setString(2, boardDTO.getDescription());
			pstmt.setString(3, boardDTO.getWriter());
			pstmt.setInt(4, boardDTO.getView());
			pstmt.setInt(5, boardDTO.getCategoryId());

			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert에서 오류났어");
			e.printStackTrace();
		}

		return resultCnt;
	}

	@Override
	public int delete(int boardId) {
		int resultCnt = 0;
		String sql = " DELETE FROM board WHERE boardId=? ";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete 오류");
			e.printStackTrace();
		}

		return resultCnt;
	}

	@Override
	public int update(String title, String description, int categoryId, int boardId) {
		int resultCnt = 0;
		String sql = " UPDATE board " + " SET title=?, description=?, categoryId=? " + " WHERE boardId=? ";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, description);
			pstmt.setInt(3, categoryId);
			pstmt.setInt(4, boardId);
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update 오류발생");
			e.printStackTrace();
		}

		return resultCnt;
	}

	@Override
	public int update(int view, int boardId) {
		int resultCnt = 0;
		String sql = " UPDATE board SET view =? WHERE boardId=? ";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, view);
			pstmt.setInt(2, boardId);
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return resultCnt;
	}

	@Override
	public ArrayList<BoardDTO> selectByTitle(String keyword) {
		ArrayList<BoardDTO> list = new ArrayList<>();
		String sql = " SELECT * " + " FROM board " + " WHERE title LIKE ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDTO boardDto = new BoardDTO();

				boardDto.setBoardId(rs.getInt("boardId"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setWriter(rs.getString("writer"));
				boardDto.setCreatedAt(rs.getString("createdAt"));
				boardDto.setView(rs.getInt("view"));

				list.add(boardDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
