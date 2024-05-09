<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Naver News Headlines</title>
</head>
<body>
	<h1>Naver News Headlines</h1>
	<table width="100%"
		class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>제목</th>
			</tr>
		</thead>
		<c:forEach items="${headLines}" var="myHLN">

			<tr>
				<td><c:out value="${myHLN}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>