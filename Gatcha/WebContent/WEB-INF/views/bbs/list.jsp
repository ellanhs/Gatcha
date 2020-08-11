<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html lang="ko">
<style type="text/css">
	.space1{
		top:75px
	}
</style>
<head>
<%@ include file="/WEB-INF/inc/head.jsp" %>
</head>
<body>
	
<%@ include file="/WEB-INF/inc/top/top_bbs.jsp" %>
<%@ include file="/WEB-INF/inc/sidebar/sidebar_bbs.jsp" %>		


<!-- 오른 쪽 메인 내용 문의게시판 시작 12중 10 -->
<div class="container col-sm-8 col-md-8 col-sm-offset-1 col-md-offset-1">
	
	<div class="page-header">
		<h1>문의게시판</h1>
	</div>
	<!-- Table -->
	<table class="table table-striped">
		<!-- 테이블 헤더 -->
		<thead>
			<tr>
				<th class="text-center">No</th>
				<th class="text-center">제목</th>
				<th class="text-center">작성자</th>
				<th class="text-center">작성된 날짜</th>
			</tr>
		</thead>
		<!-- 테이블 바디 밑의 자바스크립트로 완성 -->
		<tbody>
	    	<c:choose>
	    		<c:when test="${fn:length(bbsList) > 0}">
	    			<c:forEach var="bbs" items="${bbsList}">
	    				<tr>
				            <td class="text-center" style="width: 100px">${bbs.id}</td>
				            <td class="text-center">
				            	<c:url var="readUrl" value="/bbs/document_read.do">
				            		<c:param name="id" value="${bbs.id}" />
				            	</c:url>
				            	<a href="${readUrl}">${bbs.subject}</a>
				            </td>
				            <td class="text-center" style="width: 120px">${bbs.nickname}</td>
				            <td class="text-center" style="width: 200px">${bbs.regDate }</td>
			        	</tr>
	    			</c:forEach>
	    		</c:when>
	    		<c:otherwise>
	    			<tr>
			            <td colspan="4" class="text-center" style="line-height: 100px;">
			                조회된 글이 없습니다.</td>
			        </tr>
	    		</c:otherwise>
	    	</c:choose>
	    </tbody>
	</table>
	
	<!-- 목록 페이지 하단부의 쓰기버튼+검색폼+페이지 번호 공통 영역 include -->
  	<%@ include file="/WEB-INF/inc/bbs_list_bottom.jsp" %>	 
	
</div>

</body>
</html>
