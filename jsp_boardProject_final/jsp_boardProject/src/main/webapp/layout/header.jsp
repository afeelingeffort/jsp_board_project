<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String id = (String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="/jsp_boardProject/css/common.css">
</head>

<body>
	<header>
		<nav>
			<h1>
				<a href="/jsp_boardProject/test/home.jsp">A feeling effort</a>
			</h1>
			<ul>
				<li><a href="/jsp_boardProject/test/home.jsp">HOME</a></li>
				<li><a href="/jsp_boardProject/boardDetail?action=select">BOARD</a></li>
				<%-- jstl 사용법 --%>
				<c:choose>
					<c:when test="${id==null}">
						<li><a href="/jsp_boardProject/test/login.jsp">LOGIN</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/jsp_boardProject/test/logout.jsp">LOGOUT</a></li>	
					</c:otherwise>
				</c:choose>
				
				<%--
				스크립트릿 사용법 
				<%if(id == null) { %>
					<li><a href="/jsp_boardProject/test/login.jsp">LOGIN</a></li>
				<% } else { %>
				<li><a href="/jsp_boardProject/test/logout.jsp">LOGOUT</a></li>
				<% } %>
				 --%>
				<li><a href="/jsp_boardProject/test/join.jsp">JOIN</a></li>
			</ul>
		</nav>
					
	</header>