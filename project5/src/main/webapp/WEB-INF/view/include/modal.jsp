<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog"
	aria-labelledby="confirmModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="confirmModalLabel">확인</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">처리가 완료되었습니다.</div>
			<div class="modal-footer">
				<button class="btn btn-outline-secondary" type="button"
					data-dismiss="modal">확인</button>
				<a class="btn btn-outline-primary" type="button">버튼</a>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	//$(document).ready() <-콜백함수(핸들러)임: 도큐먼트가 준비(</html>까지 뜨면) ready()<-이건 제이쿼리에 정의된 함수고 안에 들어가는 함수는 여기서 작성한 함수
	//$()은 내부에 있는 요소를 변수화 한다
	// 아래는 그 모든 걸 생략한... 축약한 버전..
	$(function() {
		const result = '<c:out value="${result}"></c:out>';

		checkModal(result);

		history.replaceState({}, null, null);

		function checkModal(result) {
			
			if (result === '' || history.state) {
				return;
			}
			
			if (parseInt(result) > 0) {
				$(".modal-body").html("게시글 " + parseInt(result) + "번이 등록되었습니다.");
			}
			
			$("#confirmModal").modal("show");
			
		}
	});
</script>