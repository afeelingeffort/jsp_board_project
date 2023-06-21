package com.mj.board.dto;

public class UserDTO {

	private String id;
	private String pw;
	private String nickname;
	private String address;
	private String email;
	private String tel;

	public UserDTO() {
	}

	public UserDTO(String id, String pw, String nickname) {
		super();
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
	}

	public UserDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public UserDTO(String nickname) {
		super();
		this.nickname = nickname;
	}

	public UserDTO(String id, String pw, String nickname, String address, String email, String tel) {
		super();
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
		this.address = address;
		this.email = email;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", pw=" + pw + ", nickname=" + nickname + ", address=" + address + ", email="
				+ email + ", tel=" + tel + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
