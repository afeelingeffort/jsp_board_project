<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.mj.board.repository.*"%>
<%@ page import="com.mj.board.dto.*"%>
<%@ page import="com.mj.board.service.*"%>
<%@ page import="java.util.*"%>
<%
request.setCharacterEncoding("UTF-8");

String id = request.getParameter("id");
String pw = request.getParameter("pw");

UserService userService = new UserService();
UserDTO dto = userService.select(id, pw);

if (id != null && pw != null) {
	// 데이터베이스에서 아이디, 비밀번호 정보를 갖고 와야 함.
	if (dto != null) {
		session.setAttribute("id", id);
		response.sendRedirect("home.jsp");
	} else {
		out.println("<script> alert('로그인에 실패하셨습니다.'); location.href='login.jsp'</script>");
	}
}


%>
<jsp:include page="/layout/header.jsp" />
<style type="text/css">
form {
	display: flex;
	height: 550px;
	padding: 30px;
	padding-bottom: 100px;
	border-radius: 20px;
	border: 2px solid #808080;
	width: 500px;
	justify-content: center;
	flex-direction: column;
	margin-top: 50px;
}

form h1 {
	margin-right: 0;
}

main {
	display: flex;
	justify-content: center;
	align-items: center;
}

.pwdClass, .emailClass {
	height: 20px;
	width: 450px;
	margin-top: 10px;
	border-radius: 10px;
	border: 1px solid silver;
	padding: 10px;
}

.w-btn {
	color: dimGray;
	border: none;
	display: inline-block;
	padding: 15px 30px;
	border-radius: 15px;
	border: 1px solid black;
	font-family: "paybooc-Light", sans-serif;
	box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
	text-decoration: none;
	font-weight: 600;
	transition: 0.25s;
	position: relative;
	border:none;
}

/* .w-btn-outline {
	position: relative;
	border-radius: 15px;
	font-family: "paybooc-Light", sans-serif;
	box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
	text-decoration: none;
	font-weight: 600;
	transition: 0.25s;
} */

.w-btn w-btn-indigo {
	border: none;
	text-decoration: none;
}

button {
	margin-top: 50px;
	margin-left: 10px;
}

.form1 input {
	height: 35px;
}
</style>
<main>
	<form action="login.jsp" method="post">
		<h1 style="font-size: 30px;">Sign in to your account</h1>

		<div class="form1">
			<h3>
				<label class="labelMargin">id*</label>
			</h3>
			<input type="text" class="emailClass" id="id" name="id"
				placeholder="Enter your email" required="required">
		</div>

		<div class="form1">
			<h3>
				<label class="labelMargin">Password*</label>
			</h3>
			<input type="password" class="pwdClass" id="pw" name="pw"
				placeholder="Enter your password" required="required">
		</div>

		<button class="w-btn w-btn-indigo" type="submit">Login</button>
	</form>
</main>
<jsp:include page="/layout/footer.jsp" />