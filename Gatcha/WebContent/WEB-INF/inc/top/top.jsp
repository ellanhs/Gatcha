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
						<li><a href="#">평가매기기</a></li>
						<li><a href="#">나의이야기</a></li>
						<li><a href="#">고객센터</a></li>
						<li><a href="#">개인설정</a></li>
					</ul>
					<!-- 상단 메뉴 사용자 -->
					<ul class="nav navbar-nav navbar-right"> 
					<li><a href="#">사용자님</a></li>
					<li><button type="button" class="btn btn-default navbar-btn">로그아웃</button></li>
					</ul>
					<!-- 상단 메뉴 검색창 -->
					<form class="navbar-form navbar-right hidden-sm hidden-xs" role="search">
						 <div class="input-group">
               				<div class="input-group-btn">
                    			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">검색조건
                        	 <span class="caret"></span>
                   				</button>
			                   	 <ul class="dropdown-menu" role="menu">
			                        <li><a href="#">제목</a></li>
			                        <li><a href="#">감독</a></li>
			                        <li><a href="#">배우</a></li>
                        
                    				</ul>
                			</div>
		                	<input type="text" class="form-control" style="width: 200px;" placeholder="상세검색">
		                	<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
		                 </div>
					</form>
					
				</div>
			</div>
		</div>