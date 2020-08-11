<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page trimDirectiveWhitespaces="true"%>

		<!-- 왼쪽 하위 메뉴 시작 12중 2 -->
		<div class="col-sm-2 col-md-2 space1">
			<div class="navbar navbar-default" role="navigation">
				<ul class="nav navbar-nav"> 
				
					
					
					
					
					<c:if test="${genreId ==0 or genreId == null}">
					<li  class="active "><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=0">전&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;체</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=1">액&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;션</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=7">드&nbsp;&nbsp;라&nbsp;&nbsp;마</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=5">공&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;포</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=2">코&nbsp;&nbsp;미&nbsp;&nbsp;디</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=4">스&nbsp;&nbsp;릴&nbsp;&nbsp;러</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=3">로&nbsp;&nbsp;맨&nbsp;&nbsp;스</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=6">판&nbsp;&nbsp;타&nbsp;&nbsp;지</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=8">애니메이션</a></li>
					</c:if>
					
					<c:if test="${genreId eq 1 }">
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=0">전&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;체</a></li>
					<li  class="active "><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=1">액&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;션</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=7">드&nbsp;&nbsp;라&nbsp;&nbsp;마</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=5">공&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;포</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=2">코&nbsp;&nbsp;미&nbsp;&nbsp;디</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=4">스&nbsp;&nbsp;릴&nbsp;&nbsp;러</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=3">로&nbsp;&nbsp;맨&nbsp;&nbsp;스</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=6">판&nbsp;&nbsp;타&nbsp;&nbsp;지</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=8">애니메이션</a></li>
					</c:if>
					
					<c:if test="${genreId eq 7 }">
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=0">전&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;체</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=1">액&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;션</a></li>
					<li  class="active "><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=7">드&nbsp;&nbsp;라&nbsp;&nbsp;마</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=5">공&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;포</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=2">코&nbsp;&nbsp;미&nbsp;&nbsp;디</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=4">스&nbsp;&nbsp;릴&nbsp;&nbsp;러</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=3">로&nbsp;&nbsp;맨&nbsp;&nbsp;스</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=6">판&nbsp;&nbsp;타&nbsp;&nbsp;지</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=8">애니메이션</a></li>
					</c:if>
					
					<c:if test="${genreId ==5 }">
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=0">전&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;체</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=1">액&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;션</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=7">드&nbsp;&nbsp;라&nbsp;&nbsp;마</a></li>
					<li  class="active "><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=5">공&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;포</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=2">코&nbsp;&nbsp;미&nbsp;&nbsp;디</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=4">스&nbsp;&nbsp;릴&nbsp;&nbsp;러</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=3">로&nbsp;&nbsp;맨&nbsp;&nbsp;스</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=6">판&nbsp;&nbsp;타&nbsp;&nbsp;지</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=8">애니메이션</a></li>
					</c:if>
					
					<c:if test="${genreId ==2 }">
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=0">전&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;체</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=1">액&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;션</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=7">드&nbsp;&nbsp;라&nbsp;&nbsp;마</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=5">공&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;포</a></li>
					<li   class="active "><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=2">코&nbsp;&nbsp;미&nbsp;&nbsp;디</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=4">스&nbsp;&nbsp;릴&nbsp;&nbsp;러</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=3">로&nbsp;&nbsp;맨&nbsp;&nbsp;스</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=6">판&nbsp;&nbsp;타&nbsp;&nbsp;지</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=8">애니메이션</a></li>
					</c:if>
					
					<c:if test="${genreId ==4 }">
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=0">전&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;체</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=1">액&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;션</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=7">드&nbsp;&nbsp;라&nbsp;&nbsp;마</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=5">공&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;포</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=2">코&nbsp;&nbsp;미&nbsp;&nbsp;디</a></li>
					<li   class="active "><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=4">스&nbsp;&nbsp;릴&nbsp;&nbsp;러</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=3">로&nbsp;&nbsp;맨&nbsp;&nbsp;스</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=6">판&nbsp;&nbsp;타&nbsp;&nbsp;지</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=8">애니메이션</a></li>
					</c:if>
					
					<c:if test="${genreId ==3 }">
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=0">전&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;체</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=1">액&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;션</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=7">드&nbsp;&nbsp;라&nbsp;&nbsp;마</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=5">공&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;포</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=2">코&nbsp;&nbsp;미&nbsp;&nbsp;디</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=4">스&nbsp;&nbsp;릴&nbsp;&nbsp;러</a></li>
					<li  class="active "><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=3">로&nbsp;&nbsp;맨&nbsp;&nbsp;스</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=6">판&nbsp;&nbsp;타&nbsp;&nbsp;지</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=8">애니메이션</a></li>
					</c:if>
					
					<c:if test="${genreId ==6 }">
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=0">전&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;체</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=1">액&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;션</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=7">드&nbsp;&nbsp;라&nbsp;&nbsp;마</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=5">공&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;포</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=2">코&nbsp;&nbsp;미&nbsp;&nbsp;디</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=4">스&nbsp;&nbsp;릴&nbsp;&nbsp;러</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=3">로&nbsp;&nbsp;맨&nbsp;&nbsp;스</a></li>
					<li  class="active "><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=6">판&nbsp;&nbsp;타&nbsp;&nbsp;지</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=8">애니메이션</a></li>
					</c:if>
					
					<c:if test="${genreId ==8 }">
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=0">전&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;체</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=1">액&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;션</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=7">드&nbsp;&nbsp;라&nbsp;&nbsp;마</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=5">공&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;포</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=2">코&nbsp;&nbsp;미&nbsp;&nbsp;디</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=4">스&nbsp;&nbsp;릴&nbsp;&nbsp;러</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=3">로&nbsp;&nbsp;맨&nbsp;&nbsp;스</a></li>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=6">판&nbsp;&nbsp;타&nbsp;&nbsp;지</a></li>
					<li  class="active "><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=8">애니메이션</a></li>
					</c:if>
					<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_boxoffice.do">박스오피스</a></li>
				</ul>
			</div>
		</div>
		<!-- 왼쪽 하위 메뉴 끝 -->
