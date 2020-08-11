<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>

<!doctype html>
<html lang="ko">
<head>
<!-- 관련 css-->
<%@ include file="/WEB-INF/inc/head.jsp"%>

<style type="text/css">
/*상단 메뉴바 설정에 의한 띄어진 공간 비우기*/  

			.modal{
            	overflow: auto;
        	}
        	
		

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
			        height: 151px;
			    }
			}
			@media (min-width: 401px)and (max-width: 490px) {
			    .img {
			        height: 162px;
			    }
			}
			@media (min-width: 490px)and (max-width: 580px) {
			    .img {
			        height: 194px;
			    }
			}
			@media (min-width: 580px)and (max-width: 670px) {
			    .img {
			        height: 238px;
			    }
			}
			@media (min-width: 670px)and (max-width: 768px) {
			    .img {
			        height: 285px;
			    }
			}
			@media (min-width: 768px) and (max-width: 880px){
			    .img {
			        height: 160px;
			    }
			}
			@media (min-width: 880px) and (max-width: 992px){
			    .img {
			        height: 195px;
			    }
			}

			@media (min-width: 992px) and (max-width: 1095px){
			    .img {
			        height: 157px;
			    }
			}
			@media (min-width: 1095px) and (max-width: 1200px){
			    .img {
			        height: 174px;
			    }
			}
			@media (min-width: 1200px) and (max-width: 1350px){
			    .img {
			        height: 192px;
			    }
			}
			@media (min-width: 1350px) and (max-width: 1500px){
			    .img {
			        height: 212px;
			    }
			}
			@media (min-width: 1500px) and (max-width: 1600px) {
			    .img {
			        height: 233px; 0.5813953488372093
			 	}
			}
			@media (min-width: 1600px) {
			    .img {
			        height: 250px;
			    }
			}
			/**********************/

			
			 .cation-wrapper1{
				width:100%;
				height:300px;
				left:0;
				bottom:0;
				right:0;
				z-index: 4;
				background-color: transparent;
				text-align: center;
				vertical-align: center;
			}



			/******************/
			

			.navbar > ul > li{
				width :100%;
			}
			
			.spacearea{
				min-height: 100px;
			}
			
			
			/**  우리를 엿먹인 원흉 **/
			.modal-backdrop{
				z-index:0;
			}
			
			.hide{
                display: none;
            }
            
            .row{
            	margin-left: -60px;
            	margin-right: 60px;
            }
            
            .pull-left{
            	color: grey;
            }
            
            .col-xs-6,col-sm-4,col-md-3,col-lg-3{
            	margin-top:-25px;
            }
            
            .ellipsis {
			  text-overflow:ellipsis;
			  white-space:nowrap;
			  word-wrap:normal;
			  width:320px;
			  padding-left:30px;
			  overflow:hidden;
			}
</style>

</head>
<body>

	<%@ include file="/WEB-INF/inc/top/top_mystory.jsp"%>
	<%@ include file="/WEB-INF/inc/sidebar/sidebar_category.jsp"%>
		<!-- 오른 쪽 메인 내용 문의게시판 시작 12중 10 -->
		<div class="container col-sm-10 col-md-10">
			<div class="spacearea">
			</div>
			<div class="row">
			<c:choose>
			<c:when test="${fn:length(diaryList) > 0 }">
				<c:forEach var="diaryList" items="${diaryList}">
				<div id="wrapper${diaryList.movie_kfd_id}" class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
				
					<div class="img" style="background-image: url('${diaryList.poster}')"> 
	
					</div>
					<div class="cation-wrapper1">
								<h4>${diaryList.title}</h4>
								<div style="text-align"><i class='glyphicon glyphicon-book'></i>&nbsp;&nbsp;${diaryList.edit_date}</div>
								<hr/>
								<br/>
								<p class="ellipsis" id="diary${diaryList.movie_kfd_id}">${diaryList.diary}</p>
								<br/>
								<a class="btn btn-link" href='${pageContext.request.contextPath}/evaluate/evaluate_diary.do?kfa_id=${diaryList.movie_kfd_id}' data-toggle="modal" data-target="#diary_edit_modal">
 									<button class='btn btn-active'><i class='glyphicon glyphicon-edit'></i>다이어리 쓰기</button>
                   				</a>
                   				<form id="diary_delete_form" method="post" action="${pageContext.request.contextPath}/evaluate/evaluate_diary_null.do"> 
                   				<input type="hidden" name="KfaId" value="${diaryList.movie_kfd_id}" /> 
                   				<button type="submit" class="btn btn-delete" style="color:#d84780; background-color:#FF5588;"><i class='glyphicon glyphicon-edit'></i>다이어리 삭제</button>
                   				</form>
					</div>
				</div>
				</c:forEach>
				</c:when>
				<c:otherwise>
					<h4>작성된 다이어리가 없습니다.</h4>
				</c:otherwise>
				
			
		</c:choose>
			
			</div>
		</div>
		<!--섬네일 끝-->
		

	

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
			$("#diary"+json.evalresult.movieKfaId).replaceWith('<p>'+json.evalresult.diary+'</p>');
			// 덧글 수정 모달 강제로 닫기
			$("#diary_edit_modal").modal('hide');
			location.reload();
		});  
	
	});  
	  /* 동적으로 삭제된 로드된 폼 안에서의 submit 이벤트 */
	  $(document).on("submit","#diary_delete_form", function(e) {
		e.preventDefault(); 
		 // AjaxForm 플러그인의 강제 호출
		$(this).ajaxSubmit(function(json) {
			if (json.rt != "OK") {
				alert(json.rt);
				return false;
			}
			
			alert("삭제되었습니다.");
 			$("#wrapper"+json.evaldelete.movieKfaId).replaceWith(''); 
		});  
	
	});  


	
	
});

</script>

</html>