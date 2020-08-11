<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true"%>


<!-- 페이지네이션 -->
<form class="form-inline text-center">
	<div class="form-group">
		<ul class="pagination">
			<!-- 이전 그룹으로 이동 -->
			<c:choose>
				<c:when test="${pageHelper.prevPage > 0}">
					<!-- 이전 그룹에 대한 페이지 번호가 존재한다면? -->
					<!-- 이전 그룹으로 이동하기 위한 URL을 생성해서 "prevUrl"에 저장 -->
					<c:url var="prevUrl" value="/bbs/document_list.do">
						<c:param name="category" value="${category}"></c:param>
						<c:param name="keyword" value="${keyword}"></c:param>
						<c:param name="page" value="${pageHelper.prevPage}"></c:param>
					</c:url>
	
					<li><a href="${prevUrl}">&laquo;</a></li>
				</c:when>
	
				<c:otherwise>
					<!-- 이전 그룹에 대한 페이지 번호가 존재하지 않는다면? -->
					<li class='disabled'><a href="#">&laquo;</a></li>
				</c:otherwise>
			</c:choose>
				
			<!-- 페이지 번호 -->
			<!-- 현재 그룹의 시작페이지~끝페이지 사이를 1씩 증가하면서 반복 -->
			<c:forEach var="i" begin="${pageHelper.startPage}" end="${pageHelper.endPage}" step="1">
	
				<!-- 각 페이지 번호로 이동할 수 있는 URL을 생성하여 page_url에 저장 -->
				<c:url var="pageUrl" value="/bbs/document_list.do" >
					<c:param name="category" value="${category}"></c:param>
					<c:param name="keyword" value="${keyword}"></c:param>
					<c:param name="page" value="${i}"></c:param>
				</c:url>
					
				<!-- 반복중의 페이지 번호와 현재 위치한 페이지 번호가 같은 경우에 대한 분기 -->
				<c:choose>
					<c:when test="${pageHelper.page == i}">
						<li class='active'><a href="#">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${pageUrl}">${i}</a></li>
					</c:otherwise>
				</c:choose>	
	
			</c:forEach>
				
			<!-- 다음 그룹으로 이동 -->
			<c:choose>
				<c:when test="${pageHelper.nextPage > 0}">
					<!-- 다음 그룹에 대한 페이지 번호가 존재한다면? -->
					<!-- 다음 그룹으로 이동하기 위한 URL을 생성해서 "nextUrl"에 저장 -->
					<c:url var="nextUrl" value="/bbs/document_list.do">
						<c:param name="category" value="${category}"></c:param>
						<c:param name="keyword" value="${keyword}"></c:param>
						<c:param name="page" value="${pageHelper.nextPage}"></c:param>
					</c:url>
	
					<li><a href="${nextUrl}">&raquo;</a></li>
				</c:when>
	
				<c:otherwise>
					<!-- 이전 그룹에 대한 페이지 번호가 존재하지 않는다면? -->
					<li class='disabled'><a href="#">&raquo;</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	<!-- 글 쓰기 버튼 -->
    <div class="pull-right">
        <a href="${pageContext.request.contextPath}/bbs/document_write.do" class="btn btn-primary">
        	<i class="glyphicon glyphicon-pencil"></i> 글쓰기
        </a>
	</div>
</form>
<!--// 페이지 번호 끝 -->
<!-- 검색폼 시작 -->
<form  method="get" action="${pageContext.request.contextPath}/bbs/document_list.do" class="form-inline text-center" role="search">
	<!-- 조건 드롭다운 -->
	<div class="form-group">
		<select name="category" id="category" class="form-control" >
		  	<option value='0'>제목/본문</option>
			<option value='1'>작성자</option>

		</select>
	</div>
	<!-- 게시판 검색창 -->
	<div class="form-group">
		<input type="text" name="keyword" class="form-control" placeholder="게시판 조회"  value="${keyword}" />
	</div>
	<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
</form>	
<!--// 검색폼 끝 -->
	
	