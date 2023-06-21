package com.mj.board.dto;

public class BoardDTO extends CategoryDTO {
	private int boardId;
	private String title;
	private String description;
	private String writer;
	private String createdAt;
	private int view;
	private int categoryId;

	public BoardDTO() {
	}

	public BoardDTO(String title, String description, int categoryId) {
		super();
		this.title = title;
		this.description = description;
		this.categoryId = categoryId;
	}

	public BoardDTO(int boardId, String title, String description, int categoryId) {
		super();
		this.boardId = boardId;
		this.title = title;
		this.description = description;
		this.categoryId = categoryId;
	}

	public BoardDTO(String title, String description, String writer, int categoryId) {
		super();
		this.title = title;
		this.description = description;
		this.writer = writer;
		this.categoryId = categoryId;
	}

	public BoardDTO(String title, String description, String writer, String createdAt, int view, int categoryId) {
		super();
		this.title = title;
		this.description = description;
		this.writer = writer;
		this.createdAt = createdAt;
		this.view = view;
		this.categoryId = categoryId;
	}

	public BoardDTO(String title, String description, String writer, String createdAt, int view) {
		super();
		this.title = title;
		this.description = description;
		this.writer = writer;
		this.createdAt = createdAt;
		this.view = view;
	}

	public BoardDTO(int boardId, String title, String description, String writer, String createdAt, int view) {
		super();
		this.boardId = boardId;
		this.title = title;
		this.description = description;
		this.writer = writer;
		this.createdAt = createdAt;
		this.view = view;
	}

	public BoardDTO(int boardId, String title, String writer, String createdAt, int view) {
		super();
		this.boardId = boardId;
		this.title = title;
		this.writer = writer;
		this.createdAt = createdAt;
		this.view = view;
	}

	public BoardDTO(int boardId, String title, String description, String writer, String createdAt, int view,
			int categoryId) {
		super();
		this.boardId = boardId;
		this.title = title;
		this.description = description;
		this.writer = writer;
		this.createdAt = createdAt;
		this.view = view;
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "NoticeBoardDTO [boardId=" + boardId + ", title=" + title + ", description=" + description + ", writer="
				+ writer + ", createdAt=" + createdAt + ", view=" + view + ", categoryId=" + categoryId + "]";
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
