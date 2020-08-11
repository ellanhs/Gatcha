<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true"%>
<form id="diary_edit_form" method="post" action="${pageContext.request.contextPath}/evaluate/evaluate_diary_ok.do">  
	<!-- 삭제 대상에 대한 상태유지 -->
	<input type="hidden" name="KfaId" value="${movieInfo.kfaId}" />

	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" 
			aria-label="Close"><span aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title" style="color: #FF5588;">${movieInfo.title}</h4>
	</div>
	<div class="modal-body">
		<!-- 덧글 내용 -->
		<div class="form-group">
			<textarea class="form-control" name="diary" style="min-height: 300px;" 
				>${evalInfo.diary}</textarea>
		</div>
	</div>
	<div class="modal-footer">
		<button type="submit" class="btn btn-diary" style="color:#F0F0F0; background-color:#FF5588;">다이어리 등록</button>

		<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>

	</div>
</form>