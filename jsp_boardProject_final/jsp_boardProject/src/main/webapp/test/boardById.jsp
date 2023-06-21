<%@page import="com.mj.board.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- /tBoard/detail 서블릿 상세글 페이지--%>
<%
String title = (String) request.getAttribute("title");
BoardDTO board = (BoardDTO) request.getAttribute("boardByIdList");
%>
<jsp:include page="/layout/header.jsp" />
<style type="text/css">
main {
	display: flex;
	justify-content: center;
	align-items: center;
}

table {
	border: 1px solid lightGray;
	border-radius: 20px;
	width: 800px;
	padding-bottom: 20px;
}

table tr td {
	display: flex;
	justify-content: center;
	padding-left: 20px;
	padding-right: 20px;
	padding-top: 20px;
	font-size: 20px;
}

.title {
	font-size: 28px;
}

.writer_createdAt_view {
	padding-bottom: 15px;
	border-bottom: 1px solid lightGray;
}

.descriptionTitle {
	border-top: 2px solid lightGray;
	padding-top: 15px;
}

.description {
	padding-top: 10px;
}

button {
	margin-top: 20px;
	width: 100px;
	padding: 10px;
	border-radius: 20px;
	border: 1px solid dimGray;
}

.update-btn, .delete-btn {
	color: dimGray;
	box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
	border: none;
}
</style>
<main>
	<div class="boardById-wraper">
		<table>
			<tr>
				<td class="categoryId">Category Title <%=title%></td>
			</tr>
			<tr>
				<td class="title"><%=board.getTitle()%></td>
			</tr>
			<tr>
				<td class="writer_createdAt_view">Writer <%=board.getWriter()%>
					| <%=board.getCreatedAt()%> | view <%=board.getView()%></td>
			</tr>
			<tr>
				<td class="description"><%=board.getDescription()%></td>
			</tr>

			<c:set var="boardId" value="<%=board.getBoardId()%>" />
		</table>
		<button type="button"
			onclick="location.href='/jsp_boardProject/test/update.jsp?bId=<%=board.getBoardId()%>'"
			class="update-btn">update</button>
		<a
			href="/jsp_boardProject/tBoard?action=delete&bId=<%=board.getBoardId()%>"><button
				class="delete-btn">delete</button></a>
	</div>
</main>
<jsp:include page="/layout/footer.jsp" />