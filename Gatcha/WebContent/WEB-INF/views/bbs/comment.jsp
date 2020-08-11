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
			.form-horizontal textarea{
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
		<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/bbs/document_comment_ok.do">
			<!-- 수정 대상에 대한 상태유지 -->
			<input type="hidden" id="id" name="id" value="${document.id}" />
			<div class="form-group">
			   <div class="well"> <span>글번호&nbsp;:&nbsp;${document.id}</span><span class="pull-right">글쓴이&nbsp;:&nbsp;${document.nickname}</span><br/><span><b>제목&nbsp;:&nbsp;${document.subject}</b></span>  <span class="pull-right">날짜&nbsp;:&nbsp;${document.regDate}</span>
			   </div>
			</div>		
			<div class="form-group">
		    	<section class="jumbotron"> ${document.content}</section> 
		  	</div>
		  	<div class="form-group text-center">
		  		<button type="submit" class="btn btn-default">등 록</button>
		  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  		<button type="button" class="btn btn-warning" onclick="history.back();">취 소</button> 
			</div>
			<div class="col-sm-2 col-md-2 well"><span class="text-center"><b>관리자</b></span></div>
			<div class="col-sm-9 col-sm-offset-1 col-md-9 col-md-offset-1">
				<c:choose>
					<c:when test="${document.comment != null}">
		    			<div class="form-group">
				    		<textarea id="comment" name="comment" class="form-control" >${document.comment}</textarea> 
		  				</div>
		    		</c:when>
		    		<c:otherwise>
		    			<div class="form-group">
				    		<textarea id="comment" name="comment" class="form-control" ></textarea> 
		  				</div>
		    		</c:otherwise>
		    	</c:choose> 
		  	</div>
		</form>
	</div>
	<!-- 오른 쪽 메인 내용 문의게시판 끝 -->

</body>
</html>
