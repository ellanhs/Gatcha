<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page trimDirectiveWhitespaces="true"%>

		<!-- 왼쪽 하위 메뉴 시작 12중 2 -->
		<div class="col-sm-2 col-md-2 space1">
			<div class="navbar navbar-default" role="navigation">
				<ul class="nav navbar-nav"> 
					<li><a href="${pageContext.request.contextPath}/bbs/document_list.do">문의게시판</a></li>
					<li class="active disabled"><a href="${pageContext.request.contextPath}/bbs/qna.do">자주 묻는 질문 답변</a></li>
				</ul>
			</div>
		</div>
		<!-- 왼쪽 하위 메뉴 끝 -->