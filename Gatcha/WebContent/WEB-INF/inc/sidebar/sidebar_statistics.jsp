<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page trimDirectiveWhitespaces="true"%>

<!-- 사이드바 영역 디자인 -->
<style type="text/css">

	ul#side{
		padding-top: 75px;
	}

</style>

		<!-- 왼쪽 하위 메뉴 시작 12중 2 -->
		<div class="col-sm-2 col-md-2 space1">
			<div class="navbar navbar-default" role="navigation">
				<ul class="nav navbar-nav"> 					
					<li><a href="${pageContext.request.contextPath}/mystory/mystory_favorite.do">보고싶어요  <span class="badge">${fn:length(ev_list_like)}</span></a></li>
					<li><a href="${pageContext.request.contextPath}/mystory/mystory_favorite_hate.do">관심없어요  <span class="badge">${fn:length(ev_list_hate)}</span></a></li>
					<li><a href="${pageContext.request.contextPath}/mystory/mystory_diarylist.do">다이어리  <span class="badge">${fn:length(diaryList)}</span></a></li>
					<li class="active disabled"><a href="${pageContext.request.contextPath}/mystory/mystory_statistics.do">취향통계분석</a></li>
				</ul>
			</div>
		</div>
		<!-- 왼쪽 하위 메뉴 끝 -->