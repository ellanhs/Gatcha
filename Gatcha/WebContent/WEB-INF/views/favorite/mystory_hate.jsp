<!-- 이호 180307 
	부트스트랩에서 기본 nav 세팅을 커스텀해서 최소한의 CSS 작업을 함. 
	다른 부분의 부트스트랩 세팅은 안건드려서 추후 부트스트랩을 쓰는 파트의 바디 부분만 모아서 안꺼번에 적용하고자 함.
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<%@ include file="/WEB-INF/inc/head.jsp" %>


		<style type="text/css">
		
		
			.modal{
            	overflow: auto;
        	}
        	.embed-responsive{
             	top:200px;
            }
        	
		
			/*상단 메뉴바 설정에 의한 띄어진 공간 비우기*/  
			body{
				padding-top: 50.5px;
			}
			/*로고 이미지 관련 꾸밈*/
			.navbar-brand>img{
				width:30px;
				height:30px;
			}
			/*로고 이미지 관련 꾸밈*/
			.navbar-brand{
				padding:10px 20px;
				width:60px;
				height:40px;
			}
			/*상단, 좌측 메뉴바 제목 글씨 크기*/
			ul > li > a{
				font-size:18px;
			}
			/*상단, 좌측 메뉴바 랭킹 글씨 크기*/
			ol > li > a{
				font-size:14px;
			}
			/*상단 사용자 글씨 크기*/
			.navbar-right > li > a{
				font-size:16px;
			}
			/*상단 메뉴바 선 색깔 (기본은 투명 지금은 회색,)*/
			.navbar-fixed-top {
				border-bottom-color: #EEEEEE; 
			}
			/*좌측 메뉴바 뱃치 활성화시 색깔*/
			.active  .badge {
			background-color:#ff4444;
			}

			/** 태블릿 이상 해상도에서 캐러셀 내용영역의 높이, 하단 여백, 글자 크기 재설정 (반응형 웹) */
			@media (min-width: 768px) {
			    .carousel {
			        height: 500px;
			    }
			    
			    .carousel-inner > .item {
			        height: 500px;
			    }

			    .left >.icon-prev{
			        top: 200px;
			    }

			    .right >.icon-next {
			        top: 200px;
			    }
			}
			/***************************/
			.img{
				background-repeat: no-repeat;
    			background-position: center center;
   				background-size: cover;
   				border-radius: 4px;
   				margin-bottom: 20px;
   				position:relative;
			}
			@media (max-width: 401px){
			    .img {
			        height: 260px;
			    }
			}
			@media (min-width: 401px)and (max-width: 490px) {
			    .img {
			        height: 280px;
			    }
			}
			@media (min-width: 490px)and (max-width: 580px) {
			    .img {
			        height: 335px;
			    }
			}
			@media (min-width: 580px)and (max-width: 670px) {
			    .img {
			        height: 410px;
			    }
			}
			@media (min-width: 670px)and (max-width: 768px) {
			    .img {
			        height: 490px;
			    }
			}
			@media (min-width: 768px) and (max-width: 880px){
			    .img {
			        height: 275px;
			    }
			}
			@media (min-width: 880px) and (max-width: 992px){
			    .img {
			        height: 330px;
			    }
			}

			@media (min-width: 992px) and (max-width: 1095px){
			    .img {
			        height: 270px;
			    }
			}
			@media (min-width: 1095px) and (max-width: 1200px){
			    .img {
			        height: 300px;
			    }
			}
			@media (min-width: 1200px) and (max-width: 1350px){
			    .img {
			        height: 330px;
			    }
			}
			@media (min-width: 1350px) and (max-width: 1500px){
			    .img {
			        height: 365px;
			    }
			}
			@media (min-width: 1500px) and (max-width: 1600px) {
			    .img {
			        height: 400px;
			 	}
			}
			@media (min-width: 1600px) {
			    .img {
			        height: 430px;
			    }
			}
			/**********************/
			.wrapper > .image-wrapper{
				width:100%;
				height:100%;
				border-radius: 4px;
				position:absolute;
				top:0;
				left:0;
				bottom:0;
				right:0;
				z-index: 3;
				background-color: rgba(0,0,0,0.7);
			}
			

			.wrapper > .cation-wrapper1{
				width:100%;
				height:50%;
				position:absolute;
				top:50%;
				left:0;
				bottom:0;
				right:0;
				z-index: 4;
				background-color: #fff;
				border: 1px solid #ccc; 
				border-radius: 0 0 4px 4px;
				text-align: center;
				vertical-align: center;
			}
			.wrapper{
				opacity: 0;
				-webkit transition: opacity 0.7s;
				-moz transition: opacity 0.7s;
				transition: opacity 0.7s;
			}

			.wrapper:hover{
				opacity: 1;
			}
			.image-wrapper > a {
				position:relative;
				top:7px;
				left:85%;
				right:0;
				bottom:0;
				font-size: 24px;
				z-index: 10;
			}
			div.wrapper .hatetosee{
				color: #ffffff;
			}
			div.wrapper .hatetosee:hover{
				color: #dddddd;
			}
			div.wrapper .wannasee{
				color: #ff4444;
			}
			div.wrapper .wannasee:hover{
				color: #dd2222;
			}

			/******************/
			.wrapper2 > .image-wrapper2{
				width:100%;
				height:100%;
				border-radius: 4px;
				position:absolute;
				top:0;
				left:0;
				bottom:0;
				right:0;
				z-index: 1;
				background-color: rgba(0,0,0,0.7);
			}
			

			.wrapper2 > .cation-wrapper2{
				width:100%;
				height:50%;
				position:absolute;
				top:50%;
				left:0;
				bottom:0;
				right:0;
				z-index: 2;
				background-color: #fff;
				border: 1px solid #ccc; 
				border-radius: 0 0 4px 4px;
				text-align: center;
				vertical-align: center;
			}
			.wrapper2{
				opacity: 0;
				-webkit transition: opacity 0.7s;
				-moz transition: opacity 0.7s;
				transition: opacity 0.7s;
				height:0;
			}

			.wrapper2:target{
				opacity: 1;
			}
			.image-wrapper2 > a {
				position:relative;
				top:7px;
				left:85%;
				right:0;
				bottom:0;
				font-size: 24px;
			}
			
			/**관심없어요 */
			
			div.wrapper .hatetosee{
				color: #ffffff;
			}
			div.wrapper .hatetosee:hover{
				color: #dddddd;
			}
			/**관심없어요 취소 선택 시*/
			div.wrapper .alreadyhatetosee {
				    color: #f40d24;
			}
			/**관심없어요 취소 선택 시*/
			div.wrapper .alreadyhatetosee:hover {
				    color: #d20b02;
			}
			
			/**보고싶어요 선택 시*/
			div.wrapper .wannasee{
				color: #ff4444;
			}
			div.wrapper .wannasee:hover{
				color: #dd2222;
			}
			/**보고싶어요 취소 선택 시*/
			div.wrapper .seen{
				color: #ff9944;
			}
			div.wrapper .seen:hover{
				color: #dd7722;
			}

			/******************/
			

			.navbar > ul > li{
				width :100%;
			}
			
			.spacearea{
				min-height: 100px;
			}
			
			.clickable {
                 height: 215px;
   				 width: 366.45px;
    			/* cursor: default; */
    			left: -311.45px;
    			top: -8px;
    			position: absolute;
   				z-index: 6;
   				 /* background-color: red; */
			}
			
			/**  우리를 엿먹인 원흉 **/
			.modal-backdrop{
				z-index:0;
			}
			
			.hide{
                display: none;
            }
            
            .space1{
			top:75px
			}
			
		</style>

	</head>

	<body>

<%@ include file="/WEB-INF/inc/top/top_mystory.jsp" %>
<%@ include file="/WEB-INF/inc/sidebar/sidebar_favorite_hate.jsp" %>	

		<!-- 오른 쪽 메인 내용 문의게시판 시작 12중 10 -->
		<div class="container col-sm-10 col-md-10">
			<div class="spacearea">
			<h1>관심없어요</h1>
			<hr />
			</div>
			<div class="row">
			<c:choose>
			<c:when test="${fn:length(ev_list_hate) > 0 }">
				<c:forEach var="ev_list_hate" items="${ev_list_hate}">
				<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
					<div class="img" style="background-image: url('${ev_list_hate.poster}')"> 
						<div class="wrapper">
							<div class="image-wrapper">
								<a data-toggle="modal" href='${pageContext.request.contextPath}/evaluate/evaluate_sub.do?kfa_id=${ev_list_hate.kfaId}' data-toggle="modal" data-target="#movie_info_modal" >
									<span class="clickable"></span>
								</a>
										<a id="hatetosee" class="hatetosee hide"><i class="glyphicon glyphicon-remove-circle"></i></a>
										<input type="hidden" id="hiddenvalue" value="${ev_list_hate.kfaId}"/>
										<a id="alreadyhatetosee" class="alreadyhatetosee"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>${ev_list_hate.title}</h4>
								<hr/>
								<br/>
								<div id="mystarpoint${ev_list_hate.kfaId}"></div>
								<input type="hidden" id="hiddenstarpoint" value="${ev_list_hate.myStarpoint}"/>
								<br/>
								<c:if test="${ev_list_hate.like==null or ev_list_hate.like=='0'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${ev_list_hate.kfaId}"/>
									<a id='seen' class="btn btn-link seen hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<c:if test="${ev_list_hate.like=='1'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${ev_list_hate.kfaId}"/>
									<a id='seen' class="btn btn-link seen" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<a class="btn btn-link" href='${pageContext.request.contextPath}/evaluate/evaluate_diary.do?kfa_id=${ev_list_hate.kfaId}' data-toggle="modal" data-target="#diary_edit_modal">
 									<i class='glyphicon glyphicon-edit'></i>다이어리 쓰기
                   				</a>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
				</c:when>
				<c:otherwise>
					<h4>해당 영화가 없습니다.</h4>
				</c:otherwise>
				
			
		</c:choose>
			
			</div>
		</div>
		<!--섬네일 끝-->
		
	<form id="diary_result_form">
	<!-- 삭제 대상에 대한 상태유지 -->
		<input type="hidden"  />
	</form>
	
		<!-- 영화정보를 출력시 사용될  Modal -->
	<div class="modal fade" id="movie_info_modal">
    		<div class="modal-content" style="margin: 20px auto; width : 900px;">
		
    		</div>
	</div>
	<!-- 다이어리 수정시 사용될 Modal -->
	<div class="modal fade" id="diary_edit_modal">
 	  <div class="modal-dialog"> 
	    <div class="modal-content">
	
	    </div>
 	  </div> 
	</div>
	

		
</body>
<script type="text/javascript">


$(function() {
	
	
// 	$(document).trigger('reset'); 
	
	/** 모든 모달창의 캐시 방지 처리 */
	$('.modal').on('hidden.bs.modal', function (e) {
		// 모달창 내의 내용을 강제로 지움.
		$(this).removeData('bs.modal');
	});
	
	
	
	$('.hatetosee').on("click",function(e){
		e.preventDefault();
		$(this).addClass('hide');
		var hidden_id4=$(this).next().val();
		$.post("${pageContext.request.contextPath}/evaluate/evaluate_dislike.do", {movie_kfa_id : hidden_id4 , likes : 0, dislike : 1 , my_starpoint : 0}, function(req){},"html");
	    alert("관심없어요에 추가되었습니다.");
	    $(this).next().next().removeClass('hide');
	});
	    
	$('.alreadyhatetosee').on("click",function(e){
	 	e.preventDefault();
		$(this).addClass('hide');
	    var hidden_id3=$(this).prev().val();
	    $.post("${pageContext.request.contextPath}/evaluate/evaluate_dislike.do", {movie_kfa_id : hidden_id3 , likes : 0, dislike : 0 , my_starpoint : 0}, function(req){},"html");
	    alert("관심없어요를 취소하였습니다.");
	    $(this).prev().prev().removeClass('hide');
	});
	
	
	$('.wannasee').on("click",function(e){
		e.preventDefault();
	    $(this).addClass('hide');
	    var hidden_id=$(this).next().val();
	    $.post("${pageContext.request.contextPath}/evaluate/evaluate_likes.do", {movie_kfa_id : hidden_id , likes : 1, dislike : 0 , my_starpoint : 0}, function(req){},"html");
	    alert("보고싶어요에 추가되었습니다.");
	    $(this).next().next().removeClass('hide');
	});
	
	$('.seen').on("click",function(e){
		e.preventDefault();
		$(this).addClass('hide');
		var hidden_id2=$(this).prev().val();
		$.post("${pageContext.request.contextPath}/evaluate/evaluate_likes.do", {movie_kfa_id : hidden_id2 , likes : 0, dislike : 0 , my_starpoint : 0}, function(req){},"html");
	    alert("보고싶어요를 취소하셨습니다.");
	    $(this).prev().prev().removeClass('hide');
	});
	

	/* 동적으로 로드된 폼 안에서의 submit 이벤트 */
	  $(document).on("submit","#diary_edit_form", function(e) {
		e.preventDefault(); 
		 // AjaxForm 플러그인의 강제 호출
		$(this).ajaxSubmit(function(json) {
			if (json.rt != "OK") {
				alert(json.rt);
				return false;
			}
			
			// 줄 바꿈에 대한 처리
			// --> 정규표현식 /~~~/g는 문자열 전체의 의미.
			// --> JSON에 포함된 '&lt;br/&gt;'을 검색에서 <br/>로 변경함.
			json.evalresult.diary = json.evalresult.diary.replace(/&lt;br\/&gt;/g, "<br/>");
			
			// 덧글 수정 모달 강제로 닫기
			$("#diary_edit_modal").modal('hide');
		});  
	
	});  

	
	/* 별점 */

	<c:forEach var="ev_list_hate" items="${ev_list_hate}">
	$('#mystarpoint${ev_list_hate.kfaId}').raty({
		cancel: false,
		half: true,
		score: $('#mystarpoint${ev_list_hate.kfaId}').next().val(),
		starHalf : '${pageContext.request.contextPath}/assets/img/stars/star-half.png',
        starOff  : '${pageContext.request.contextPath}/assets/img/stars/star-off.png',
        starOn   : '${pageContext.request.contextPath}/assets/img/stars/star-on.png',
        hints : [['최악이에요!', '싫어요'], ['재미없어요', '별로에요'], ['부족해요', '보통이에요'], ['볼만해요', '재미있어요'], ['훌륭해요', '최고에요!']],
        click : function(score){
        	var mykfaid = ${ev_list_hate.kfaId};
        	var myscore =''+score;
        	alert("별점이 등록되었습니다.");
        	$.post('${pageContext.request.contextPath}/evaluate/evaluate_starpoint.do', {movie_kfa_id : mykfaid, likes : 0, dislike : 0, my_starpoint : myscore}, function(req){},"html");
        }
	});

	</c:forEach>
});

</script>

</html>