<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%--<jsp:include page="/layout/logoutHeader.jsp"/> --%>
<jsp:include page="/layout/header.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String id = (String)session.getAttribute("id");
%>
<style type="text/css">
main {
	display: flex;
	justify-content: center;
}

main h3{
	display: flex;
	flex-direction: row;
	justify-content: center;
	padding-bottom: 20px;
}

.article-img {
	width: 800px;
	display: flex;
	justify-content: center;
	flex-direction: row;
}
</style>
<main>
	<div class="welcom-context">
		<h3>	
		<%
		if(id == null){ %>
					Please Sign in to your account
		<%}else {%>
			Welcome <%= id%> !		
		<%}%>
		</h3>
		<img alt="" class="article-img" src="/jsp_boardProject/images/image1.jpg">
	</div>
</main>

<jsp:include page="/layout/footer.jsp" />