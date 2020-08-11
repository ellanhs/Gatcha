<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/head.jsp" %>
		<style type="text/css">
			.spacearea{
				min-height: 100px;
			}
			.form-horizontal section{
				min-height: 200px;
			}
			.form-horizontal p{
				min-height: 100px;
			}
			.jumbotron{
				background-color:transparent;
				border: solid 1px;
				border-color: #CCC;
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
		<form class="form-horizontal">
			<div class="form-group">
			   <div class="well"> <span>글번호&nbsp;:&nbsp;${document.id}</span><span class="pull-right">글쓴이&nbsp;:&nbsp;${document.nickname}</span><br/><span><b>제목&nbsp;:&nbsp;${document.subject}</b></span>  <span class="pull-right">날짜&nbsp;:&nbsp;${document.regDate}</span>
			   </div>
			</div>		
			<div class="form-group">
		    	<section class="jumbotron"> ${document.content}</section> 
		  	</div>
		  	<div class="form-group text-center">
		  		<a href="${pageContext.request.contextPath}/bbs/document_list.do" 
				class="btn btn-primary">목 록</a>
		  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  		<a href="${pageContext.request.contextPath}/bbs/document_write.do" 
				class="btn btn-info">글쓰기</a>
				<!-- 수정,삭제 대상을 지정하기 위해서 글 번호가 전달되어야 한다. -->
		  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  		<a href="${pageContext.request.contextPath}/bbs/document_edit.do?id=${document.id}" class="btn btn-warning">수 정</a>
		  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  		<a href="${pageContext.request.contextPath}/bbs/document_delete.do?id=${document.id}" class="btn btn-danger">삭 제</a>
		  		<!-- 관리자 모드 댓글 달기 -->
		  		<c:choose>
					<c:when test="${loginInfo.level == 1}">
		    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  				<a href="${pageContext.request.contextPath}/bbs/document_comment.do?id=${document.id}" class="btn btn-default">답 변</a>
		    		</c:when>
		    	</c:choose> 
			</div>
			<div class="col-sm-2 col-md-2 well"><span class="text-center"><b>관리자</b></span></div>
			<div class="col-sm-10 col-md-10">
				<c:choose>
					<c:when test="${document.comment != null}">
		    			<p class="form-control">${document.comment}</p>
		    		</c:when>
		    		<c:otherwise>
		    			<p class="form-control">조속히 답변드리겠습니다.</p>
		    		</c:otherwise>
		    	</c:choose> 
		  	</div>
		</form>
	</div>
	<!-- 오른 쪽 메인 내용 문의게시판 끝 -->

</body>
</html>
