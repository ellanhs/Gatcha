<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>

<!-- 왼쪽 하위 메뉴 시작 12중 2 -->
<div class="col-sm-2 col-md-2 space1">
	<div class="navbar navbar-default" role="navigation">
		<ul class="nav navbar-nav">
			<li><a href="#">박스오피스</a></li>
		</ul>

		<ol class="nav navbar-nav">
			<c:choose>
				<c:when test="${fn:length(list) > 0 }">
					<c:forEach var="list" items="${list}" begin="0" end="9" varStatus="status">
						<li><a data-toggle="modal"
							href='${pageContext.request.contextPath}/evaluate/evaluate_sub.do?kfa_id=${list.kfaId}'
							data-toggle="modal" data-target="#movie_info_modal">${status.count}<span>. </span>${list.title}</a></li>
					</c:forEach>
				</c:when>
			</c:choose>
		</ol>

	</div>
</div>
<!-- 왼쪽 하위 메뉴 끝 -->