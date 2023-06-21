<%@page import="com.mj.board.dto.CategoryDTO"%>
<%@page import="com.mj.board.service.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp" />
<%@ page import="java.util.*"%>
<%@ page import="com.mj.board.repository.CategoryDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String userId = (String) session.getAttribute("userId");

CategoryService categoryService = new CategoryService();
ArrayList<CategoryDTO> categoryList = categoryService.selectAllCategory();

request.setAttribute("categoryList", categoryList);
%>

<%
request.setCharacterEncoding("UTF-8");

String id = (String) session.getAttribute("id");

if (id == null) {
	out.println("<script> alert('로그인 후 글 작성해주세요.'); location.href='login.jsp'</script>");
} else {

}
%>
<style type="text/css">
main {
	display: flex;
	justify-content: center;
}

form {
	display: flex;
	flex-direction: column;
	font-size: 20px;
	border: 1px solid lightGray;
	border-radius: 20px;
	width: 800px;
}

form div {
	padding: 20px;
}

select {
	padding: 10px;
	width: 200px;
	border: 1px solid lightGray;
	border-radius: 10px;
	margin-left: 20px;
}

.categoryId {
	padding-bottom: 0;
}

.title {
	border-bottom: 1px solid lightGray;
}

.title input {
	width: 680px;
	padding: 10px;
	border: 1px solid lightGray;
	border-radius: 10px;
	margin-left: 20px;
}

.description {
	padding-top: 0;
	padding-bottom: 0;
}

.description textarea {
	display: flex;
	flex-direction: row;
	width: 760px;
	height: 400px;
	padding: 10px;
	border: 1px solid lightGray;
	border-radius: 10px;
	margin-top: 10px;
}

.insert_btn {
	width: 100px;
	margin: 20px;
	padding: 10px;
	border-radius: 20px;
	color: dimGray;
	box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
	border: none;
}
</style>
<main>
	<form action="/jsp_boardProject/tBoard?action=insert" method="post"
		enctype="multilpart/form-data">
		<div class="categoryId">
			category Title <select id="categoryIdSelect" name="categoryId"
				required="required">
				<c:forEach var="category" items="${categoryList}">
					<option value="${category.categoryId}"
						<c:if test="${category.categoryTitle}"> selected</c:if>>
						${category.categoryTitle}</option>
				</c:forEach>
			</select>
		</div>
		<div class="title">
			title<input type="text" name="title" placeholder="제목을 입력해주세요.">
		</div>
		<div class="fileupload">
			<label for="file">파일 업로드 <input type="file" name="file"
				id="file">
			</label>
		</div>
		<div class="description">
			description
			<textarea cols="50" rows="10" name="description"
				placeholder="내용을 입력하세요."></textarea>
		</div>
		<button type="submit" class="insert_btn">insert</button>
	</form>

</main>
<jsp:include page="/layout/footer.jsp" />