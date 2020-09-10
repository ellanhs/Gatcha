<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<%@ include file="/WEB-INF/inc/head.jsp" %>
		<!-- 캐러셀 css-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/carousel.css" />
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
			div.wrapper2 .hatetosee{
				color: #ffffff;
			}
			div.wrapper2 .hatetosee:hover{
				color: #dddddd;
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
			
			.hide{
				display:none;
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
			.space1{
				top:10px;
			}
		</style>

	</head>
	<body>
		<!-- 상단 메뉴창 시작 -->
		<%@ include file="/WEB-INF/inc/top/top_main.jsp" %>
		<!-- 상단 메뉴창 끝 -->
		
		<!-- 캐러셀 영역 구성 -->
		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
			<!-- 현재 위치 표시 -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				<li data-target="#carousel-example-generic" data-slide-to="3"></li>
				<li data-target="#carousel-example-generic" data-slide-to="4"></li>
			</ol>

			<!-- 캐러셀내용 영역 -->
			<div class="carousel-inner">
				
				<!-- 항목 (1) -->
			<c:choose>
			<c:when test="${fn:length(clist) > 0 }">
				<c:forEach var="clist" items="${clist}" begin ="0" end="0">
				<div class="item active" style="background-image: url('${clist.stilcut}')">
					<div class="carousel-caption">
						<h1>${clist.title}</h1>
						<p class="visible-md visible-lg">
						<h5>평균 별점: 4.3,</h5>
							${clist.year},${clist.country},${clist.genreName},${clist.age},${clist.runtime}분<br/>
							감독:${clist.directorName}, 배우:${clist.actorName1},${clist.actorName2}
						</p>
					</div>
				</div>
				     </c:forEach>
			</c:when>	
		</c:choose>
		   <!-- 항목(2)~(5) -->
			<c:choose>
			<c:when test="${fn:length(clist) > 0 }">
				<c:forEach var="clist" items="${clist}" begin ="1" end="4">
				<div class="item" style="background-image: url('${clist.stilcut}')">
					<div class="carousel-caption">
						<h1>${clist.title}</h1>
						<p class="visible-md visible-lg">
						<h5>평균 별점: </h5>
							${clist.year},${clist.country},${clist.genreName},${clist.age},${clist.runtime}분<br/>
							감독:${clist.directorName}, 배우:${clist.actorName1},${clist.actorName2}
						</p>
					</div>
				</div>	
		     </c:forEach>
			</c:when>	
		</c:choose>

			</div>

			<!-- 캐러셀 내용영역 구성 -->

			<!-- 이동 버튼 -->
			<a class="left carousel-control" href="#carousel-example-generic" data-slide="prev"> <span class="icon-prev"></span> </a>
			<a class="right carousel-control" href="#carousel-example-generic" data-slide="next"> <span class="icon-next"></span> </a>
		</div>
		<!-- 캐러셀 영역 끝 -->
		
		<%@ include file="/WEB-INF/inc/sidebar/sidebar_main.jsp" %>
		
		<!--오른쪽 하위 메뉴 시작 12중 2 -->
			<div class="container col-sm-10 col-md-10">
			<div class="spacearea">
			</div>
			<div class="row">
			<!-- 박스오피스 10개 영화목록 -->
			<div><h3>BOXOFFICE</h3></div>
			<c:choose>
			<c:when test="${fn:length(list) > 0 }">
				<c:forEach var="list" items="${list}">
				<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
					<div class="img" style="background-image: url('${list.poster}')"> 
						<div class="wrapper">
							<div class="image-wrapper">
								<a data-toggle="modal" href='${pageContext.request.contextPath}/evaluate/evaluate_sub.do?kfa_id=${list.kfaId}' data-toggle="modal" data-target="#movie_info_modal" >
									<span class="clickable"></span>
								</a>
										<a id="hatetosee" class="hatetosee"><i class="glyphicon glyphicon-remove-circle"></i></a>
										<input type="hidden" id="hiddenvalue" value="${list.kfaId}"/>
										<a id="alreadyhatetosee" class="alreadyhatetosee hide"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>${list.title}</h4>
								<hr/>
								<br/>
								<div id="mystarpoint${list.kfaId}"></div>
								<input type="hidden" id="hiddenstarpoint" value="${list.myStarpoint}"/>
								<br/>
								<c:if test="${list.like==null or list.like=='0'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${list.kfaId}"/>
									<a id='seen' class="btn btn-link seen hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<c:if test="${list.like=='1'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${list.kfaId}"/>
									<a id='seen' class="btn btn-link seen" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<a class="btn btn-link" href='${pageContext.request.contextPath}/evaluate/evaluate_diary.do?kfa_id=${list.kfaId}' data-toggle="modal" data-target="#diary_edit_modal">
 									<i class='glyphicon glyphicon-edit'></i>다이어리 쓰기
                   				</a>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
				</c:when>
				<c:otherwise>
				</c:otherwise>
		</c:choose>
		<!-- 박스오피스 10개 영화목록 끝-->
		<!-- 빈칸 2개 -->
		<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
			<div class="img" style="background-image: url('#')"> 
			</div>
		</div>
		<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
			<div class="img" style="background-image: url('#')"> 
			</div>
		</div>
		<!-- 8개 장르 별 영화목록 -->
		
		<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
		<div><h3>${glist1.genreName}</h3></div>
					<div class="img" style="background-image: url('${glist1.poster}')"> 
						<div class="wrapper">
							<div class="image-wrapper">
								<a data-toggle="modal" href='${pageContext.request.contextPath}/evaluate/evaluate_sub.do?kfa_id=${glist1.kfaId}' data-toggle="modal" data-target="#movie_info_modal" >
									<span class="clickable"></span>
								</a>
										<a id="hatetosee" class="hatetosee"><i class="glyphicon glyphicon-remove-circle"></i></a>
										<input type="hidden" id="hiddenvalue" value="${glist1.kfaId}"/>
										<a id="alreadyhatetosee" class="alreadyhatetosee hide"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>${glist1.title}</h4>
								<hr/>
								<br/>								
								<div id="mystarpoint1${glist1.kfaId}"></div>
								<input type="hidden" id="hiddenstarpoint" value="${glist1.myStarpoint}"/>
								<br/>
								<c:if test="${glist1.like==null or glist1.like=='0'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${glist1.kfaId}"/>
									<a id='seen' class="btn btn-link seen hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<c:if test="${glist1.like=='1'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${glist1.kfaId}"/>
									<a id='seen' class="btn btn-link seen" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<a class="btn btn-link" href='${pageContext.request.contextPath}/evaluate/evaluate_diary.do?kfa_id=${glist1.kfaId}' data-toggle="modal" data-target="#diary_edit_modal">
 									<i class='glyphicon glyphicon-edit'></i>다이어리 쓰기
                   				</a>
							</div>
						</div>
					</div>
		   </div>
				<!-- ----------------- -->
			
			<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
			<div><h3>${glist2.genreName}</h3></div>
					<div class="img" style="background-image: url('${glist2.poster}')"> 
						<div class="wrapper">
							<div class="image-wrapper">
								<a data-toggle="modal" href='${pageContext.request.contextPath}/evaluate/evaluate_sub.do?kfa_id=${glist2.kfaId}' data-toggle="modal" data-target="#movie_info_modal" >
									<span class="clickable"></span>
								</a>
										<a id="hatetosee" class="hatetosee"><i class="glyphicon glyphicon-remove-circle"></i></a>
										<input type="hidden" id="hiddenvalue" value="${glist2.kfaId}"/>
										<a id="alreadyhatetosee" class="alreadyhatetosee hide"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>${glist2.title}</h4>
								<hr/>
								<br/>
								<div id="mystarpoint2${glist2.kfaId}"></div>
								<input type="hidden" id="hiddenstarpoint" value="${glist2.myStarpoint}"/>
								<br/>
								<c:if test="${glist2.like==null or glist2.like=='0'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${glist2.kfaId}"/>
									<a id='seen' class="btn btn-link seen hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<c:if test="${glist2.like=='1'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${glist2.kfaId}"/>
									<a id='seen' class="btn btn-link seen" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<a class="btn btn-link" href='${pageContext.request.contextPath}/evaluate/evaluate_diary.do?kfa_id=${glist2.kfaId}' data-toggle="modal" data-target="#diary_edit_modal">
 									<i class='glyphicon glyphicon-edit'></i>다이어리 쓰기
                   				</a>
							</div>
						</div>
					</div>
				</div>
							<!-- ----------------- -->
		
			<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
				<div><h3>${glist3.genreName}</h3></div>
					<div class="img" style="background-image: url('${glist3.poster}')"> 
						<div class="wrapper">
							<div class="image-wrapper">
								<a data-toggle="modal" href='${pageContext.request.contextPath}/evaluate/evaluate_sub.do?kfa_id=${glist3.kfaId}' data-toggle="modal" data-target="#movie_info_modal" >
									<span class="clickable"></span>
								</a>
										<a id="hatetosee" class="hatetosee"><i class="glyphicon glyphicon-remove-circle"></i></a>
										<input type="hidden" id="hiddenvalue" value="${glist3.kfaId}"/>
										<a id="alreadyhatetosee" class="alreadyhatetosee hide"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>${glist3.title}</h4>
								<hr/>
								<br/>
								<div id="mystarpoint3${glist3.kfaId}"></div>
								<input type="hidden" id="hiddenstarpoint" value="${glist3.myStarpoint}"/>
								<br/>
								<c:if test="${glist3.like==null or glist3.like=='0'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${glist3.kfaId}"/>
									<a id='seen' class="btn btn-link seen hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<c:if test="${glist3.like=='1'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${glist3.kfaId}"/>
									<a id='seen' class="btn btn-link seen" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<a class="btn btn-link" href='${pageContext.request.contextPath}/evaluate/evaluate_diary.do?kfa_id=${glist3.kfaId}' data-toggle="modal" data-target="#diary_edit_modal">
 									<i class='glyphicon glyphicon-edit'></i>다이어리 쓰기
                   				</a>
							</div>
						</div>
					</div>
				</div>
					<!-- ----------------- -->
		
			<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
				<div><h3>${glist4.genreName}</h3></div>
					<div class="img" style="background-image: url('${glist4.poster}')"> 
						<div class="wrapper">
							<div class="image-wrapper">
								<a data-toggle="modal" href='${pageContext.request.contextPath}/evaluate/evaluate_sub.do?kfa_id=${glist4.kfaId}' data-toggle="modal" data-target="#movie_info_modal" >
									<span class="clickable"></span>
								</a>
										<a id="hatetosee" class="hatetosee"><i class="glyphicon glyphicon-remove-circle"></i></a>
										<input type="hidden" id="hiddenvalue" value="${glist4.kfaId}"/>
										<a id="alreadyhatetosee" class="alreadyhatetosee hide"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>${glist4.title}</h4>
								<hr/>
								<br/>
								<div id="mystarpoint4${glist4.kfaId}"></div>
								<input type="hidden" id="hiddenstarpoint" value="${glist4.myStarpoint}"/>
								<br/>
								<c:if test="${glist4.like==null or glist4.like=='0'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${glist4.kfaId}"/>
									<a id='seen' class="btn btn-link seen hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<c:if test="${glist4.like=='1'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${glist4.kfaId}"/>
									<a id='seen' class="btn btn-link seen" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<a class="btn btn-link" href='${pageContext.request.contextPath}/evaluate/evaluate_diary.do?kfa_id=${glist4.kfaId}' data-toggle="modal" data-target="#diary_edit_modal">
 									<i class='glyphicon glyphicon-edit'></i>다이어리 쓰기
                   				</a>
							</div>
						</div>
					</div>
				</div>
				<!-- ---------------- -->
	
			<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
				<div><h3>${glist5.genreName}</h3></div>
					<div class="img" style="background-image: url('${glist5.poster}')"> 
						<div class="wrapper">
							<div class="image-wrapper">
								<a data-toggle="modal" href='${pageContext.request.contextPath}/evaluate/evaluate_sub.do?kfa_id=${glist5.kfaId}' data-toggle="modal" data-target="#movie_info_modal" >
									<span class="clickable"></span>
								</a>
										<a id="hatetosee" class="hatetosee"><i class="glyphicon glyphicon-remove-circle"></i></a>
										<input type="hidden" id="hiddenvalue" value="${glist5.kfaId}"/>
										<a id="alreadyhatetosee" class="alreadyhatetosee hide"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>${glist5.title}</h4>
								<hr/>
								<br/>
								<div id="mystarpoint5${glist5.kfaId}"></div>
								<input type="hidden" id="hiddenstarpoint" value="${glist5.myStarpoint}"/>
								<br/>
								<c:if test="${glist5.like==null or glist5.like=='0'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${glist5.kfaId}"/>
									<a id='seen' class="btn btn-link seen hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<c:if test="${glist5.like=='1'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${glist5.kfaId}"/>
									<a id='seen' class="btn btn-link seen" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<a class="btn btn-link" href='${pageContext.request.contextPath}/evaluate/evaluate_diary.do?kfa_id=${glist5.kfaId}' data-toggle="modal" data-target="#diary_edit_modal">
 									<i class='glyphicon glyphicon-edit'></i>다이어리 쓰기
                   				</a>
							</div>
						</div>
					</div>
				</div>
		<!-- --------------------------------------- -->
		<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
				<div><h3>${glist6.genreName}</h3></div>
					<div class="img" style="background-image: url('${glist6.poster}')"> 
						<div class="wrapper">
							<div class="image-wrapper">
								<a data-toggle="modal" href='${pageContext.request.contextPath}/evaluate/evaluate_sub.do?kfa_id=${glist6.kfaId}' data-toggle="modal" data-target="#movie_info_modal" >
									<span class="clickable"></span>
								</a>
										<a id="hatetosee" class="hatetosee"><i class="glyphicon glyphicon-remove-circle"></i></a>
										<input type="hidden" id="hiddenvalue" value="${glist6.kfaId}"/>
										<a id="alreadyhatetosee" class="alreadyhatetosee hide"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>${glist6.title}</h4>
								<hr/>
								<br/>
								<div id="mystarpoint6${glist6.kfaId}"></div>
								<input type="hidden" id="hiddenstarpoint" value="${glist6.myStarpoint}"/>
								<br/>
								<c:if test="${glist6.like==null or glist6.like=='0'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${glist6.kfaId}"/>
									<a id='seen' class="btn btn-link seen hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<c:if test="${glist6.like=='1'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${glist6.kfaId}"/>
									<a id='seen' class="btn btn-link seen" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<a class="btn btn-link" href='${pageContext.request.contextPath}/evaluate/evaluate_diary.do?kfa_id=${glist6.kfaId}' data-toggle="modal" data-target="#diary_edit_modal">
 									<i class='glyphicon glyphicon-edit'></i>다이어리 쓰기
                   				</a>
							</div>
						</div>
					</div>
				</div>
		<!-- --------------------------------------- -->
		<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
				<div><h3>${glist7.genreName}</h3></div>
					<div class="img" style="background-image: url('${glist7.poster}')"> 
						<div class="wrapper">
							<div class="image-wrapper">
								<a data-toggle="modal" href='${pageContext.request.contextPath}/evaluate/evaluate_sub.do?kfa_id=${glist7.kfaId}' data-toggle="modal" data-target="#movie_info_modal" >
									<span class="clickable"></span>
								</a>
										<a id="hatetosee" class="hatetosee"><i class="glyphicon glyphicon-remove-circle"></i></a>
										<input type="hidden" id="hiddenvalue" value="${glist7.kfaId}"/>
										<a id="alreadyhatetosee" class="alreadyhatetosee hide"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>${glist7.title}</h4>
								<hr/>
								<br/>
								<div id="mystarpoint7${glist7.kfaId}"></div>
								<input type="hidden" id="hiddenstarpoint" value="${glist7.myStarpoint}"/>
								<br/>
								<c:if test="${glist7.like==null or glist7.like=='0'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${glist7.kfaId}"/>
									<a id='seen' class="btn btn-link seen hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<c:if test="${glist7.like=='1'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${glist7.kfaId}"/>
									<a id='seen' class="btn btn-link seen" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<a class="btn btn-link" href='${pageContext.request.contextPath}/evaluate/evaluate_diary.do?kfa_id=${glist7.kfaId}' data-toggle="modal" data-target="#diary_edit_modal">
 									<i class='glyphicon glyphicon-edit'></i>다이어리 쓰기
                   				</a>
							</div>
						</div>
					</div>
				</div>
		<!-- --------------------------------------- -->
				<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
				<div><h3>${glist8.genreName}</h3></div>
					<div class="img" style="background-image: url('${glist8.poster}')"> 
						<div class="wrapper">
							<div class="image-wrapper">
								<a data-toggle="modal" href='${pageContext.request.contextPath}/evaluate/evaluate_sub.do?kfa_id=${glist8.kfaId}' data-toggle="modal" data-target="#movie_info_modal" >
									<span class="clickable"></span>
								</a>
										<a id="hatetosee" class="hatetosee"><i class="glyphicon glyphicon-remove-circle"></i></a>
										<input type="hidden" id="hiddenvalue" value="${glist8.kfaId}"/>
										<a id="alreadyhatetosee" class="alreadyhatetosee hide"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>${glist8.title}</h4>
								<hr/>
								<br/>
								<div id="mystarpoint8${glist8.kfaId}"></div>
								<input type="hidden" id="hiddenstarpoint" value="${glist8.myStarpoint}"/>
								<br/>
								<c:if test="${glist8.like==null or glist8.like=='0'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${glist8.kfaId}"/>
									<a id='seen' class="btn btn-link seen hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<c:if test="${glist8.like=='1'}">
								<span>
									<a id='wannasee' class="btn btn-link wannasee hide" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a>
									<input type="hidden" id="hiddenvalue" value="${glist8.kfaId}"/>
									<a id='seen' class="btn btn-link seen" ><i class="glyphicon glyphicon-heart"></i>보고 싶어요 취소 </a>
								</span>
								</c:if>
								
								<a class="btn btn-link" href='${pageContext.request.contextPath}/evaluate/evaluate_diary.do?kfa_id=${glist8.kfaId}' data-toggle="modal" data-target="#diary_edit_modal">
 									<i class='glyphicon glyphicon-edit'></i>다이어리 쓰기
                   				</a>
							</div>
						</div>
					</div>
				</div>
		<!-- 8개 장르 별 영화목록 끝-->
			
			</div>
		</div>
		<!-- 오른 쪽 메인 내용 문의게시판 끝 -->
	
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
	    alert("싫어요에 추가되었습니다.");
	    $(this).next().next().removeClass('hide');
	    location.reload();
	});
	    
	$('.alreadyhatetosee').on("click",function(e){
	 	e.preventDefault();
		$(this).addClass('hide');
	    var hidden_id3=$(this).prev().val();
	    $.post("${pageContext.request.contextPath}/evaluate/evaluate_dislike.do", {movie_kfa_id : hidden_id3 , likes : 0, dislike : 0 , my_starpoint : 0}, function(req){},"html");
	    alert("싫어요를 취소하였습니다.");
	    $(this).prev().prev().removeClass('hide');
	    location.reload();
	});
	
	
	$('.wannasee').on("click",function(e){
		e.preventDefault();
	    $(this).addClass('hide');
	    var hidden_id=$(this).next().val();
	    $.post("${pageContext.request.contextPath}/evaluate/evaluate_likes.do", {movie_kfa_id : hidden_id , likes : 1, dislike : 0 , my_starpoint : 0}, function(req){},"html");
	    alert("보고싶어요에 추가되었습니다.");
	    $(this).next().next().removeClass('hide');
	    location.reload();
	});
	
	$('.seen').on("click",function(e){
		e.preventDefault();
		$(this).addClass('hide');
		var hidden_id2=$(this).prev().val();
		$.post("${pageContext.request.contextPath}/evaluate/evaluate_likes.do", {movie_kfa_id : hidden_id2 , likes : 0, dislike : 0 , my_starpoint : 0}, function(req){},"html");
	    alert("보고싶어요를 취소하셨습니다.");
	    $(this).prev().prev().removeClass('hide');
	    location.reload();
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

	<c:forEach var="list" items="${list}">
	$('#mystarpoint${list.kfaId}').raty({
		cancel: false,
		half: true,
		score: $('#mystarpoint${list.kfaId}').next().val(),
		starHalf : '${pageContext.request.contextPath}/assets/img/stars/star-half.png',
        starOff  : '${pageContext.request.contextPath}/assets/img/stars/star-off.png',
        starOn   : '${pageContext.request.contextPath}/assets/img/stars/star-on.png',
        hints : [['최악이에요!', '싫어요'], ['재미없어요', '별로에요'], ['부족해요', '보통이에요'], ['볼만해요', '재미있어요'], ['훌륭해요', '최고에요!']],
        click : function(score){
        	var mykfaid = ${list.kfaId};
        	var myscore =''+score;
        	alert("별점이 등록되었습니다.");
        	$.post('${pageContext.request.contextPath}/evaluate/evaluate_starpoint.do', {movie_kfa_id : mykfaid, likes : 0, dislike : 0, my_starpoint : myscore}, function(req){},"html");
        	location.reload();
        }
	});

	</c:forEach>
	
	$('#mystarpoint1${glist1.kfaId}').raty({
		cancel: false,
		half: true,
		score: $('#mystarpoint1${glist1.kfaId}').next().val(),
		starHalf : '${pageContext.request.contextPath}/assets/img/stars/star-half.png',
        starOff  : '${pageContext.request.contextPath}/assets/img/stars/star-off.png',
        starOn   : '${pageContext.request.contextPath}/assets/img/stars/star-on.png',
        hints : [['최악이에요!', '싫어요'], ['재미없어요', '별로에요'], ['부족해요', '보통이에요'], ['볼만해요', '재미있어요'], ['훌륭해요', '최고에요!']],
        click : function(score){
        	var mykfaid1 = ${glist1.kfaId};
        	var myscore1 =''+score;
        	alert("별점이 등록되었습니다.");
        	$.post('${pageContext.request.contextPath}/evaluate/evaluate_starpoint.do', {movie_kfa_id : mykfaid1, likes : 0, dislike : 0, my_starpoint : myscore1}, function(req){},"html");
        	location.reload();
        }
	});
	
	$('#mystarpoint2${glist2.kfaId}').raty({
		cancel: false,
		half: true,
		score: $('#mystarpoint2${glist2.kfaId}').next().val(),
		starHalf : '${pageContext.request.contextPath}/assets/img/stars/star-half.png',
        starOff  : '${pageContext.request.contextPath}/assets/img/stars/star-off.png',
        starOn   : '${pageContext.request.contextPath}/assets/img/stars/star-on.png',
        hints : [['최악이에요!', '싫어요'], ['재미없어요', '별로에요'], ['부족해요', '보통이에요'], ['볼만해요', '재미있어요'], ['훌륭해요', '최고에요!']],
        click : function(score){
        	var mykfaid2 = ${glist2.kfaId};
        	var myscore2 =''+score;
        	alert("별점이 등록되었습니다.");
        	$.post('${pageContext.request.contextPath}/evaluate/evaluate_starpoint.do', {movie_kfa_id : mykfaid2, likes : 0, dislike : 0, my_starpoint : myscore2}, function(req){},"html");
        	location.reload();
        }
	});
	
	$('#mystarpoint3${glist3.kfaId}').raty({
		cancel: false,
		half: true,
		score: $('#mystarpoint3${glist3.kfaId}').next().val(),
		starHalf : '${pageContext.request.contextPath}/assets/img/stars/star-half.png',
        starOff  : '${pageContext.request.contextPath}/assets/img/stars/star-off.png',
        starOn   : '${pageContext.request.contextPath}/assets/img/stars/star-on.png',
        hints : [['최악이에요!', '싫어요'], ['재미없어요', '별로에요'], ['부족해요', '보통이에요'], ['볼만해요', '재미있어요'], ['훌륭해요', '최고에요!']],
        click : function(score){
        	var mykfaid3 = ${glist3.kfaId};
        	var myscore3 =''+score;
        	alert("별점이 등록되었습니다.");
        	$.post('${pageContext.request.contextPath}/evaluate/evaluate_starpoint.do', {movie_kfa_id : mykfaid3, likes : 0, dislike : 0, my_starpoint : myscore3}, function(req){},"html");
        	location.reload();
        }
	});
	
	$('#mystarpoint4${glist4.kfaId}').raty({
		cancel: false,
		half: true,
		score: $('#mystarpoint4${glist4.kfaId}').next().val(),
		starHalf : '${pageContext.request.contextPath}/assets/img/stars/star-half.png',
        starOff  : '${pageContext.request.contextPath}/assets/img/stars/star-off.png',
        starOn   : '${pageContext.request.contextPath}/assets/img/stars/star-on.png',
        hints : [['최악이에요!', '싫어요'], ['재미없어요', '별로에요'], ['부족해요', '보통이에요'], ['볼만해요', '재미있어요'], ['훌륭해요', '최고에요!']],
        click : function(score){
        	var mykfaid4 = ${glist4.kfaId};
        	var myscore4 =''+score;
        	alert("별점이 등록되었습니다.");
        	$.post('${pageContext.request.contextPath}/evaluate/evaluate_starpoint.do', {movie_kfa_id : mykfaid4, likes : 0, dislike : 0, my_starpoint : myscore4}, function(req){},"html");
        	location.reload();
        }
	});
	
	$('#mystarpoint5${glist5.kfaId}').raty({
		cancel: false,
		half: true,
		score: $('#mystarpoint5${glist5.kfaId}').next().val(),
		starHalf : '${pageContext.request.contextPath}/assets/img/stars/star-half.png',
        starOff  : '${pageContext.request.contextPath}/assets/img/stars/star-off.png',
        starOn   : '${pageContext.request.contextPath}/assets/img/stars/star-on.png',
        hints : [['최악이에요!', '싫어요'], ['재미없어요', '별로에요'], ['부족해요', '보통이에요'], ['볼만해요', '재미있어요'], ['훌륭해요', '최고에요!']],
        click : function(score){
        	var mykfaid5 = ${glist5.kfaId};
        	var myscore5 =''+score;
        	alert("별점이 등록되었습니다.");
        	$.post('${pageContext.request.contextPath}/evaluate/evaluate_starpoint.do', {movie_kfa_id : mykfaid5, likes : 0, dislike : 0, my_starpoint : myscore5}, function(req){},"html");
        	location.reload();
        }
	});
	
	$('#mystarpoint6${glist6.kfaId}').raty({
		cancel: false,
		half: true,
		score: $('#mystarpoint6${glist6.kfaId}').next().val(),
		starHalf : '${pageContext.request.contextPath}/assets/img/stars/star-half.png',
        starOff  : '${pageContext.request.contextPath}/assets/img/stars/star-off.png',
        starOn   : '${pageContext.request.contextPath}/assets/img/stars/star-on.png',
        hints : [['최악이에요!', '싫어요'], ['재미없어요', '별로에요'], ['부족해요', '보통이에요'], ['볼만해요', '재미있어요'], ['훌륭해요', '최고에요!']],
        click : function(score){
        	var mykfaid6 = ${glist6.kfaId};
        	var myscore6 =''+score;
        	alert("별점이 등록되었습니다.");
        	$.post('${pageContext.request.contextPath}/evaluate/evaluate_starpoint.do', {movie_kfa_id : mykfaid6, likes : 0, dislike : 0, my_starpoint : myscore6}, function(req){},"html");
        	location.reload();
        }
	});
	
	
	$('#mystarpoint7${glist7.kfaId}').raty({
		cancel: false,
		half: true,
		score: $('#mystarpoint7${glist7.kfaId}').next().val(),
		starHalf : '${pageContext.request.contextPath}/assets/img/stars/star-half.png',
        starOff  : '${pageContext.request.contextPath}/assets/img/stars/star-off.png',
        starOn   : '${pageContext.request.contextPath}/assets/img/stars/star-on.png',
        hints : [['최악이에요!', '싫어요'], ['재미없어요', '별로에요'], ['부족해요', '보통이에요'], ['볼만해요', '재미있어요'], ['훌륭해요', '최고에요!']],
        click : function(score){
        	var mykfaid7 = ${glist7.kfaId};
        	var myscore7 =''+score;
        	alert("별점이 등록되었습니다.");
        	$.post('${pageContext.request.contextPath}/evaluate/evaluate_starpoint.do', {movie_kfa_id : mykfaid7, likes : 0, dislike : 0, my_starpoint : myscore7}, function(req){},"html");
        	location.reload();
        }
	});
	
	$('#mystarpoint8${glist8.kfaId}').raty({
		cancel: false,
		half: true,
		score: $('#mystarpoint8${glist8.kfaId}').next().val(),
		starHalf : '${pageContext.request.contextPath}/assets/img/stars/star-half.png',
        starOff  : '${pageContext.request.contextPath}/assets/img/stars/star-off.png',
        starOn   : '${pageContext.request.contextPath}/assets/img/stars/star-on.png',
        hints : [['최악이에요!', '싫어요'], ['재미없어요', '별로에요'], ['부족해요', '보통이에요'], ['볼만해요', '재미있어요'], ['훌륭해요', '최고에요!']],
        click : function(score){
        	var mykfaid8 = ${glist8.kfaId};
        	var myscore8 =''+score;
        	alert("별점이 등록되었습니다.");
        	$.post('${pageContext.request.contextPath}/evaluate/evaluate_starpoint.do', {movie_kfa_id : mykfaid8, likes : 0, dislike : 0, my_starpoint : myscore8}, function(req){},"html");
        	location.reload();
        }
	});
	
});

</script>

</html>

		