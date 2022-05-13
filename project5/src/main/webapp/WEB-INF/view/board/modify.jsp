<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="../include/header.jsp" />
<%-- #{bno}, #{title}, #{content}, #{writer} --%>
<body class="bg-gradient-primary">

	<div class="container-fluid">
		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body">
				<h1 class="card-title mb-4 text-gray-800">Register New Content
				</h1>
				<form action="/board/modify" method="post" role="form">
					<div class="form-group">
						<div class="row mb-4">
							<div class="col">
								<label for="title">Title</label> <input type="text"
									class="form-control" name="title" id="title"
									value='<c:out value="${board.title}"></c:out>'>
							</div>
							<div class="col">
								<label for="writer">Writer</label> <input type="text"
									class="form-control" name="writer" id="writer"
									value='<c:out value="${board.writer}"></c:out>'>
							</div>
						</div>
						<input type="hidden" value='<c:out value="${board.bno}"></c:out>'
							name="bno"> <label for="content"
							class="font-weight-bold text-primary">Content</label>
						<textarea rows="20" cols="40" class="form-control" name="content"
							id="content"><c:out value="${board.content}"></c:out></textarea>
					</div>
					<button type="submit" data-oper="list"
						class="btn btn-outline-primary btn-lg btn-block">
						Submit Form <i class="fas fa-laugh-wink"></i>
					</button>
					<button type="submit" data-oper="remove"
						class="btn btn-outline-danger btn-lg btn-block">
						Delete This <i class="fas fa-laugh-wink"></i>
					</button>
				</form>
				<jsp:include page="../include/footer.jsp" />
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			let formObj = $("form");
			
			$('button').on("click", function(e) {
				e.preventDefault();
				const oper = $(this).data("oper");
				console.log(oper);
				
				if (oper === "remove") {
					formObj.attr("action", "/board/remove");
				} else if (oper === "list") {
					self.location = "/board/list";
					return;
				}
				
				formObj.submit();
			});
		});
	</script>
</body>

</html>