<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html lang="ko">

<style type="text/css">
	.space1{
		top:75px
	}
</style>
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>

</head>
<body>

	<%@ include file="/WEB-INF/inc/top/top_bbs.jsp"%>
	<%@ include file="/WEB-INF/inc/sidebar/sidebar_qna.jsp"%>


	<!-- 오른 쪽 메인 내용 문의게시판 시작 12중 10 -->
	<div class="container col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-1">

		<div class="page-header">
			<h1>
				FAQ <small>자주 묻는 질문 답변</small>
			</h1>
		</div>

		<div class="row">

			<div class="panel-group" id="accordion">
				<div class="panel panel-default">
					<!--항목1-->
					<div class="panel-heading">
						<h4 class="panel-title">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#collapse-1"> 로그인 어떻게하나요?? </a>
						</h4>
					</div>
					<div id="collapse-1" class="panel-collapse collapse">
						<div class="panel-body">로그인페이지로 가세요.
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#collapse-2"> 평가매기기란? </a>
						</h4>
					</div>
					<div id="collapse-2" class="panel-collapse collapse">
						<div class="panel-body">본인이 상영 한 영화에대한 평가입니다.이를통해 자신의 영화취향을
							알수있습니다.</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#collapse-3"> 회원가입은 어떻게 하나요?
							</a>
						</h4>
					</div>
					<div id="collapse-3" class="panel-collapse collapse">
						<div class="panel-body">로그인페이지에서 회원가입을 클릭하세요.</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#collapse-4"> 예고편은 어디서 볼수있나요?
							</a>
						</h4>
					</div>
					<div id="collapse-4" class="panel-collapse collapse">
						<div class="panel-body">영화 썸네일을 누르시면 새로 생기는 창에서 가능하십니다.</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#collapse-5"> 영화다이어리란?? </a>
						</h4>
					</div>
					<div id="collapse-5" class="panel-collapse collapse">
						<div class="panel-body">내가 본 영화목록입니다.</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#collapse-6"> 질문은 어디서 하나요? </a>
						</h4>
					</div>
					<div id="collapse-6" class="panel-collapse collapse">
						<div class="panel-body">질문하기로 가십시오</div>
					</div>
				</div>

			</div>

		</div>
	</div>
	<!-- 오른 쪽 메인 내용 문의게시판 끝 -->
</body>
</html>
