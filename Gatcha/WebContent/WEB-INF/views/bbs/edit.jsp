<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/head.jsp" %>
		<style type="text/css">
			/*게시판 위쪽 여백 공간*/
			.spacearea{
				min-height: 100px;
			}
			/*게시글 최소 높이 공간 */
			textarea{
				min-height: 300px;
			}
		</style>
</head>
<body>
	
<%@ include file="/WEB-INF/inc/top/top_bbs.jsp" %>
<%@ include file="/WEB-INF/inc/sidebar/sidebar_bbs.jsp" %>		


	<!-- 오른 쪽 메인 내용 문의게시판 시작 12중 10 -->
	<div class="container col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-1">
		<div class="spacearea">
		</div>
		<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/bbs/document_edit_ok.do">
				<!-- 수정 대상에 대한 상태유지 -->
			<input type="hidden" id="id" name="id" value="${document.id}" />
			<div class="form-group">
			    <label>제 목</label>
			    <input type="text" class="form-control"  id="subject" name="subject"  value="${document.subject}">
			</div>		
			<div class="form-group">
				<label>내 용</label>
		    	<textarea id="content" name="content" class="form-control ckeditor" >${document.content}</textarea> 
		  	</div>
		  	<div class="form-group text-center">
		  		<button type="submit" class="btn btn-primary">수 정</button>
		  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  		<button type="button" class="btn btn-warning" onclick="history.back();">취 소</button>
			</div>
		</form>
	</div>


		  	
</body>
</html>
