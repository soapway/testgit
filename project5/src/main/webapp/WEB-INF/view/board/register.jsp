<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<form action="/board/register" method="post">
					<div class="form-group">
						<div class="row mb-4">
							<div class="col">
								<label for="title">Title</label> <input type="text"
									class="form-control" name="title" id="title">
							</div>
							<div class="col">
								<label for="writer">Writer</label> <input type="text"
									class="form-control" name="writer" id="writer">
							</div>
						</div>
						<label for="content" class="font-weight-bold text-primary">Content</label>
						<textarea rows="20" cols="40" class="form-control" name="content"
							id="content"></textarea>
					</div>
					<button type="submit"
						class="btn btn-outline-primary btn-lg btn-block">
						Submit Form <i class="fas fa-laugh-wink"></i>
					</button>
				</form>
				<jsp:include page="../include/footer.jsp" />
			</div>
		</div>
	</div>

</body>

</html>