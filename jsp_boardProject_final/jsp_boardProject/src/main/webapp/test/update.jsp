<%@page import="com.mj.board.service.CategoryService"%>
<%@page import="com.mj.board.repository.BoardDAO"%>
<%@page import="java.util.function.Function"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mj.board.dto.*"%>
<%@ page import="com.mj.board.repository.CategoryDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String bId = request.getParameter("bId");
%>

<%
CategoryService categoryService = new CategoryService();
ArrayList<CategoryDTO> categoryList = categoryService.selectAllCategory();

request.setAttribute("categoryList", categoryList);
%>

<jsp:include page="/layout/header.jsp" />
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

form div, form h2 {
	padding: 20px;
}

.boardId {
	padding-bottom: 0;
}

.boardId input {
	width: 50px;
	padding: 10px;
	border: 1px solid lightGray;
	border-radius: 10px;
	margin-left: 20px;
}

.categoryId {
	padding-bottom: 0;
}

select {
	width: 200px;
	padding: 10px;
	border: 1px solid lightGray;
	border-radius: 10px;
	margin-left: 20px;
}

.title {
	padding-bottom: 0;
}

.title input {
	width: 690px;
	padding: 10px;
	border: 1px solid lightGray;
	border-radius: 10px;
	margin-left: 20px;
}

.description {
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

button {
	margin-top: 20px;
	margin-bottom: 20px;
	padding: 10px;
	border-radius: 20px;
	border: 1px solid dimGray;
	width: 100px;
	padding: 10px;
}

.confirm-btn, .reset-btn {
	color: dimGray;
	box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
	border: none;
}
</style>

<main>
	<div class="update-wrap">
		<%--		<form action="update.jsp" --%>
		<form
			action="/jsp_boardProject/boardDetail?action=update&bId=<%=bId%>"
			method="post">
			<h2>Update</h2>
			<div class="boardId">
				<%-- 게시글 id는 수정할 때 바뀌면 안되니까 value로 bId 불러와서 readonly로 수정 못하게 한다.--%>
				<label class="boardId">boardId</label> <input type="text"
					class="categoryId-input" id="boardId" name="boardId"
					value="<%=bId%>" readonly="readonly">
			</div>
			<%-- option태그를 쓰기 위해 categoryTitle만 select에서 갖고 옴 --%>
			<div class="categoryId">
				category Title <select id="categoryIdSelect" name="categoryTitle"
					required="required">
					<c:forEach var="category" items="${categoryList}">
						<option value="${category.categoryTitle}"
							<c:if test="${category.categoryTitle}">selected</c:if>>
							${category.categoryTitle}</option>
					</c:forEach>
				</select>
			</div>

			<div class="title">
				<label class="title">Title</label> <input type="text"
					class="title-input" id="title" name="title" required="required">
			</div>

			<div class="description">
				<label class="description">Description</label>
				<p>
					<textarea cols="50" rows="10" name="description"
						required="required"></textarea>
				</p>
				<button type="submit" class="confirm-btn">confirm</button>
				<button type="reset" class="reset-btn">reset</button>
			</div>
		</form>
	</div>
</main>
<jsp:include page="/layout/footer.jsp" />