<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 기능 다 구현하고 login hover하면 LOGOUT 드롭다운 되어 나오도록 구현하기. --%>
<%
session.invalidate();
response.sendRedirect("home.jsp");
%>
