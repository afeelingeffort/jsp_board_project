<%@ page import="com.mj.board.dto.CategoryDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<jsp:include page="/layout/header.jsp" />
<%--  왼쪽에 테이블로 카테고리 구현 후 jstl 사용해서 카테고리 가져오기 category이름은 th, 내부 내용은 td 세로로 구현하기 카테고리는 왼쪽 적당한 위치에 두기.--%>
<link rel="stylesheet" href="/jsp_boardProject/css/common.css">
<style type="text/css">
main a:hover {
	text-decoration: underline;
}

.all-wraper {
	display: flex;
	justify-content: center;
	width: 100%;
}

.category-wraper {
	display: flex;
	flex: 1;
	justify-content: center;
	align-items: flex-start;
	margin-top: 100px;
}

.board-wraper {
	flex: 5;
	flex-direction: column;
	margin-top: 50px;
	flex-shrink: 0;
}

.board-wraper table {
	flex: 1;
	margin-bottom: 20px;
	border-bottom: 2px solid lightgray;
	width: 90%;
}

th {
	font-size: 25px;
	border-bottom: 2px solid lightgray;
	padding: 5px;
}

a {
	text-decoration: none;
	color: black;
}

h3 {
	display: flex;
	flex-direction: column;
	border: 2px solid lightgray;
	padding: 20px;
	margin-right: 200px;
	margin-bottom: 20px;
	border-radius: 10px;
	width: 90%;
}

.writeBtn, .searchBtn {
	width: 100px;
	padding: 10px;
	border-radius: 20px;
	border: none;
	box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
	color: dimGray;
}

.searchBtn-wrap {
	display: flex;
	justify-content: flex-end;
	width: 90%;
	margin-right: 120px;
}

.button-wrap {
	display: flex;
	justify-content: flex-end;
	margin-right: 130px;
}

.search {
	flex-direction: column;
	justify-content: center;
	width: 400px;
	padding: 8px;
	border-radius: 20px;
	border: 1px solid dimGray;
	margin-right: 20px;
}

table tr th, table tr td {
	margin-bottom: 10px;
}

.searchBtn-wrap{
	margin-bottom: 20px;
}
</style>

<main>
	<div class="all-wraper">
		<div class="category-wraper">
			<table>
				<tr class="category-tr">
					<th>Category</th>
				</tr>
				<tr>
					<td><a href="/jsp_boardProject/tBoard?action=selectAll">전체</a></td>
				</tr>
				<c:forEach var="category" items="${categoryList}">
					<c:if test="${category.categoryTitle != '전체'}">
						<tr>
							<td><a
								href="/jsp_boardProject/tBoard?action=select&categoryId=${category.categoryId}">
									${category.categoryTitle} </a></td>
						</tr>
					</c:if>
				</c:forEach>

			</table>
		</div>

		<div class="board-wraper">
			<form action="/jsp_boardProject/tBoard?action=search" method="post">
				<div class="searchBtn-wrap">
					<input type="text" class="search" name="keyword"
						placeholder="Please Enter a search terms">
					<button type="submit" class="searchBtn">Search</button>
				</div>
			</form>
			<h3>board</h3>
			<table class="border-table-wraper">
				<tr>
					<td>No</td>
					<td>title</td>
					<td>writer</td>
					<td>createdAt</td>
					<td>view</td>
				</tr>

				<c:forEach var="board" items="${boardList}">
					<tr>
						<td><a
							href="/jsp_boardProject/boardDetail?action=detail&boardId=${board.boardId}">${board.boardId}</a></td>
						<td><a
							href="/jsp_boardProject/boardDetail?action=detail&boardId=${board.boardId}">${board.title}</a></td>
						<td>${board.writer}</td>
						<td><a
							href="/jsp_boardProject/boardDetail?action=detail&boardId=${board.boardId}">${board.createdAt}</a></td>
						<td><a
							href="/jsp_boardProject/boardDetail?action=detail&boardId=${board.boardId}">${board.view}</a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="button-wrap">
				<button type="button" class="writeBtn"
					onclick="location.href='/jsp_boardProject/test/insert.jsp'">Write</button>
			</div>
		</div>
	</div>
</main>
<jsp:include page="/layout/footer.jsp" />