<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp" />
<%
request.setCharacterEncoding("UTF-8");

String id = request.getParameter("id");
String pw = request.getParameter("pw");
String address = request.getParameter("address");
String email = request.getParameter("email");
String tel = request.getParameter("tel");

if (id != null && pw != null && address != null && email != null && tel != null) {
	out.println("<script> alert('회원가입에 성공하셨습니다.'); location.href='/jsp_boardProject/test/home.jsp'</script>");
}
%>
<style type="text/css">
form {
	display: flex;
	height: 700px;
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
	box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
	border: none;
	display: inline-block;
	padding: 15px 30px;
	border-radius: 15px;
	font-family: "paybooc-Light", sans-serif;
	text-decoration: none;
	font-weight: 600;
	transition: 0.25s;
	position: relative;
}

.w-btn-outline {
	position: relative;
	border-radius: 15px;
	font-family: "paybooc-Light", sans-serif;
	box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
	text-decoration: none;
	font-weight: 600;
	transition: 0.25s;
}

.w-btn w-btn-indigo {
	border: none;
	text-decoration: none;
}

button {
	margin-top: 20px;
}

.form1 input {
	height: 35px;
}

.idClass, .pwClass, .nicknameClass, .addressClass, .emailClass,
	.telClass {
	height: 20px;
	width: 450px;
	margin-top: 10px;
	border-radius: 10px;
	border: 1px solid silver;
	padding: 10px;
}
</style>
<main>
	<form action="/jsp_boardProject/userController?action=insert"
		method="post">

		<h1 style="font-size: 30px;">Sign up for membership</h1>

		<div class="form1">
			<h3>
				<label for="id">id* </label>
			</h3>
			<input type="text" class="idClass" name="id" id="id"
				required="required">
		</div>

		<div class="form1">
			<h3>
				<label for="pw">pw* </label>
			</h3>
			<input type="password" class="pwClass" name="pw" id="pw"
				required="required">
		</div>
		<div class="form1">
			<h3>
				<label for="address">address* </label>
			</h3>
			<input type="text" class="addressClass" name="address" id="address"
				required="required"> <input type="text" class="addressClass"
				name="address" id="address">
		</div>
		<div class="form1">
			<h3>
				<label for="email">email* </label>
			</h3>
			<input type="text" class="emailClass" name="email" id="email"
				required="required">
		</div>
		<div class="form1">
			<h3>
				<label for="tel">tel* </label>
			</h3>
			<input type="text" class="telClass" name="tel" id="tel"
				required="required">
		</div>

		<button class="w-btn w-btn-indigo" type="submit">confirm</button>
	</form>
</main>
<jsp:include page="/layout/footer.jsp" />