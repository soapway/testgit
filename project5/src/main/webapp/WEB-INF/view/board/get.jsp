<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<jsp:include page="../include/header.jsp" />
<body>
	<div id="wrapper">
		<jsp:include page="../include/sidebar.jsp" />
		<div id="content-wrapper" class="d-flex flex-column">
			<jsp:include page="../include/tabbar.jsp" />
			<div class="card">
				<div class="card-body">
					<h1 class="h3 mb-2 text-gray-800">
						<c:out value="${board.title}" />
					</h1>
					<p class="lead">
						<small class="text-muted font-weight-light"><c:out
								value="${board.writer}" /> | <fmt:formatDate
								value="${board.regdate}" pattern="yyyy-MM-dd" /> | <fmt:formatDate
								value="${board.updateDate}" pattern="yyyy-MM-dd" /></small>
					</p>
					<hr class="my-4">
					<p class="card-text text-gray-800">
						<c:out value="${board.content}" />
					</p>
					<form action="/board/remove" id="someform">
						<input type="hidden" name="bno"
							value='<c:out value="${board.bno }"></c:out>'>
					</form>
					<div align="right">
						<a href="list" class="btn btn-outline-info">Go Back</a> 
						<a role="button" class="btn btn-secondary"
							href='modify?bno=<c:out value="${board.bno}"></c:out>'>Update</a>
						<button type="submit" formmethod="post"
							class="btn btn-outline-secondary" form="someform">Delete</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../include/footer.jsp" />
</body>
</html>