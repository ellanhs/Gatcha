<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>

		<div class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<!-- 상단 메뉴 좌우폭 XS사이즈 일때 세줄 메뉴 버튼 -->
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only">
							Toggle navigation
						</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<!-- 상단 메뉴 로고 -->
					<a class="navbar-brand" href="${pageContext.request.contextPath}/main.do">
						<img src="${pageContext.request.contextPath}/assets/img/logo.png" alt="로고">
					</a>
				</div>
				<!-- 상단 메뉴 현재 고객센터 active 상태 -->
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav"> 
						<li><a href="${pageContext.request.contextPath}/evaluate/evaluate_main.do?genre_id=0">평가매기기</a></li>
						<li><a href="${pageContext.request.contextPath}/mystory/mystory_favorite.do">나의이야기</a></li>
						<li><a href="${pageContext.request.contextPath}/bbs/document_list.do">고객센터</a></li>
						<li class="active disabled"><a href="${pageContext.request.contextPath}/member/edit.do">개인설정</a></li>
					</ul>
					<!-- 상단 메뉴 사용자 -->
					<ul class="nav navbar-nav navbar-right"> 
						<li><a href="${pageContext.request.contextPath}/mystory/mystory_statistics.do">${loginInfo.nickname}님</a></li>
						<li><a href="${pageContext.request.contextPath}/member/logout.do" class='btn btn-default navbar-btn' style='padding-top: 6px; padding-bottom: 6px;'>로그아웃</a></li>
					</ul>
					<!-- 상단 메뉴 검색창 -->
					<!-- 게시판 검색  -->
					<form class="navbar-form navbar-right hidden-sm hidden-xs form-inline text-center" role="search" method="get" action="${pageContext.request.contextPath}/evaluate/evaluate_search.do">
						<!-- 조건 드롭다운 -->
						<div class="dropdown form-group">
						  
						  
						 <select name="keywordcategory" id="keywordcategory" class="form-control" id="sel1" >
							 <c:if test ="${keywordCate ==null}">
							 	<option value='0'>제목</option>
							 	<option value='1'>감독</option>
							  	<option value='2'>배우</option>
						  	  </c:if>
							  
							 <c:if test ="${keywordCate =='0'}">
							  	<option value='0' selected>제목</option>
							 	<option value='1'>감독</option>
							  	<option value='2'>배우</option>
						  	 </c:if>
						  	 
						  	  <c:if test ="${keywordCate =='1'}">
							  	<option value='0'>제목</option>
							 	<option value='1' selected>감독</option>
							  	<option value='2'>배우</option>
						  	 </c:if>
						  	 
						  	  <c:if test ="${keywordCate =='2'}">
							  	<option value='0' >제목</option>
							 	<option value='1'>감독</option>
							  	<option value='2' selected>배우</option>
						  	 </c:if>
							  
							</select>
				
				
						  
						
						<!-- 게시판 검색창 -->
						
							
						<input type="text" name="searchKeyword" class="form-control" style="width: 200px;" placeholder="검색" value="${searchKeyword}">
						
						<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
						</div>
					</form>
				</div>
			</div>
		</div>