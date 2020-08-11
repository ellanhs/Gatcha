<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page trimDirectiveWhitespaces="true"%>

<!doctype html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/head.jsp" %>
		
	<style type="text/css">
			.modal{
            	overflow: auto;
        	}
        	
	
	
		/*상단 메뉴바 설정에 의한 띄어진 공간 비우기*/
		  
			
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
			@media (min-width: 1600px) and (max-width: 1750px) {
			    .img {
			        height: 435px;
			 	}
			}
			@media (min-width: 1750px) and (max-width: 1900px) {
			    .img {
			        height: 480px;
			 	}
			}
			@media (min-width: 1900px) {
			    .img {
			        height: 520px;
			    }
			}
			
			/*썸네일 영역 이미지 간격 및 크기 조정*/
			
			#diary{
			padding-top: 100px;
			}
			
			.img{
				background-repeat: no-repeat;
    			background-position: center center;
   				background-size: cover;
   				border-radius: 4px;
   				margin-bottom: 20px;
   				position:relative;
			}
			
			.img-thumbnail{
				widows: 200px;
				height: 350px;
				margin: 10px 0px 20px 0px;
			}
			
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

			<!-- 버튼 및 영화 썸네일 이미지 하단 내용 -->
			
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
			
			.navbar-nav >li >a{
				padding: 10px 20px 10px;
			}
	
		</style>
	
</head>
<body>
<%@ include file="/WEB-INF/inc/top/top_main.jsp" %>
<%@ include file="/WEB-INF/inc/sidebar/sidebar_category.jsp" %>	

	<!-- 오른 쪽 메인 내용 문의게시판 시작 12중 10 -->
		<div class="container col-sm-10 col-md-10" id="diary">
			<div class="row">
				<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
					<div class="img" style="background-image: url('${pageContext.request.contextPath}/assets/img/m1.jpg')"> 
						<div class="wrapper2">
							<div class="image-wrapper2">
								<a class="hatetosee" href="#" alter="싫어요"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper2">
								<h4>궁합</h4>
								<hr/>
								<br>
								<br>
								<a class="seen" href="#"><i class="glyphicon glyphicon-book"></i>다이어리 작성</a>
							</div>
						</div>
						<div class="wrapper">
							<div class="image-wrapper">
								<a class="hatetosee" href="#" alter="싫어요"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>궁합</h4>
								<hr/>
								<a class="wannasee" href="#"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a><br>
								<a class="seen" href="#wrapper2"><i class="glyphicon glyphicon-tag"></i>봤어요</a>
							</div>
						</div>
						
					</div>
				</div>
				<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
					<div class="img" style="background-image: url('${pageContext.request.contextPath}/assets/img/m2.jpg')"> 
						<div class="wrapper">
							<div class="image-wrapper">
								<a class="hatetosee"  href="#" alter="싫어요"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>블랙 팬서</h4>
								<hr/>
								<a class="wannasee"  href="#"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a><br>
								<a class="seen"  href="#wrapper2"><i class="glyphicon glyphicon-tag"></i>봤어요</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
					<div class="img" style="background-image: url('${pageContext.request.contextPath}/assets/img/m3.jpg')"> 
						<div class="wrapper">
							<div class="image-wrapper">
								<a class="hatetosee"  href="#" alter="싫어요"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>리틀 포레스트</h4>
								<hr/>
								<a class="wannasee"  href="#"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a><br>
								<a class="seen"  href="#wrapper2"><i class="glyphicon glyphicon-tag"></i>봤어요</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
					<div class="img" style="background-image: url('${pageContext.request.contextPath}/assets/img/m4.jpg')"> 
						<div class="wrapper">
							<div class="image-wrapper">
								<a class="hatetosee"  href="#" alter="싫어요"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>월요일이 사라졌다.</h4>
								<hr/>
								<a class="wannasee"  href="#"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a><br>
								<a class="seen"  href="#wrapper2"><i class="glyphicon glyphicon-tag"></i>봤어요</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
					<div class="img" style="background-image: url('${pageContext.request.contextPath}/assets/img/m5.jpg')"> 
						<div class="wrapper">
							<div class="image-wrapper">
								<a class="hatetosee"  href="#" alter="싫어요"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>셰이프 오브 워터:<br>사랑의 모양</h4>
								<hr/>
								<a class="wannasee"  href="#"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a><br>
								<a class="seen"  href="#wrapper2"><i class="glyphicon glyphicon-tag"></i>봤어요</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
					<div class="img" style="background-image: url('${pageContext.request.contextPath}/assets/img/m6.jpg')"> 
						<div class="wrapper">
							<div class="image-wrapper">
								<a class="hatetosee"  href="#" alter="싫어요"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>나미야 잡화점의 기적</h4>
								<hr/>
								<a class="wannasee"  href="#"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a><br>
								<a class="seen"  href="#wrapper2"><i class="glyphicon glyphicon-tag"></i>봤어요</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
					<div class="img" style="background-image: url('${pageContext.request.contextPath}/assets/img/m7.jpg')"> 
						<div class="wrapper">
							<div class="image-wrapper">
								<a class="hatetosee"  href="#" alter="싫어요"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>레드 스패로</h4>
								<hr/>
								<a class="wannasee"  href="#"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a><br>
								<a class="seen"  href="#wrapper2"><i class="glyphicon glyphicon-tag"></i>봤어요</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
					<div class="img" style="background-image: url('${pageContext.request.contextPath}/assets/img/m8.jpg')"> 
						<div class="wrapper">
							<div class="image-wrapper">
								<a class="hatetosee"  href="#" alter="싫어요"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>50가지 그림자:<br>해방</h4>
								<hr/>
								<a class="wannasee"  href="#"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a><br>
								<a class="seen"  href="#wrapper2"><i class="glyphicon glyphicon-tag"></i>봤어요</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
					<div class="img" style="background-image: url('${pageContext.request.contextPath}/assets/img/m9.jpg')"> 
						<div class="wrapper">
							<div class="image-wrapper">
								<a class="hatetosee"  href="#" alter="싫어요"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>게이트</h4>
								<hr/>
								<a class="wannasee"  href="#"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a><br>
								<a class="seen"  href="#wrapper2"><i class="glyphicon glyphicon-tag"></i>봤어요</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
					<div class="img" style="background-image: url('${pageContext.request.contextPath}/assets/img/m10.jpg')"> 
						<div class="wrapper">
							<div class="image-wrapper">
								<a class="hatetosee"  href="#" alter="싫어요"><i class="glyphicon glyphicon-remove-circle"></i></a>
							</div>
							<div class="cation-wrapper1">
								<h4>더 포스트</h4>
								<hr/>
								<a class="wannasee"  href="#"><i class="glyphicon glyphicon-heart"></i>보고 싶어요</a><br>
								<a class="seen"  href="#wrapper2"><i class="glyphicon glyphicon-tag"></i>봤어요</a>
							</div>
						</div>
					</div>
				</div>
			
			</div>
		</div>
		<!-- 오른 쪽 메인 내용 문의게시판 끝 -->			
	</body>
</html>
