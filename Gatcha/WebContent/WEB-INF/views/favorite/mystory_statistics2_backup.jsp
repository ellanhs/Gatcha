<!-- 이호 180307 
	부트스트랩에서 기본 nav 세팅을 커스텀해서 최소한의 CSS 작업을 함. 
	다른 부분의 부트스트랩 세팅은 안건드려서 추후 부트스트랩을 쓰는 파트의 바디 부분만 모아서 안꺼번에 적용하고자 함.
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/head.jsp"%>


<style type="text/css">
.modal {
	overflow: auto;
}

.embed-responsive {
	top: 200px;
}

/*상단 메뉴바 설정에 의한 띄어진 공간 비우기*/
body {
	padding-top: 50.5px;
}
/*로고 이미지 관련 꾸밈*/
.navbar-brand>img {
	width: 30px;
	height: 30px;
}
/*로고 이미지 관련 꾸밈*/
.navbar-brand {
	padding: 10px 20px;
	width: 60px;
	height: 40px;
}
/*상단, 좌측 메뉴바 제목 글씨 크기*/
ul>li>a {
	font-size: 18px;
}
/*상단, 좌측 메뉴바 랭킹 글씨 크기*/
ol>li>a {
	font-size: 14px;
}
/*상단 사용자 글씨 크기*/
.navbar-right>li>a {
	font-size: 16px;
}
/*상단 메뉴바 선 색깔 (기본은 투명 지금은 회색,)*/
.navbar-fixed-top {
	border-bottom-color: #EEEEEE;
}

/*좌측 메뉴바 뱃치 활성화시 색깔*/
.active  .badge {
	background-color: #ff4444;
}
/** 태블릿 이상 해상도에서 캐러셀 내용영역의 높이, 하단 여백, 글자 크기 재설정 (반응형 웹) */
@media ( min-width : 768px) {
	.carousel {
		height: 500px;
	}
	.carousel-inner>.item {
		height: 500px;
	}
	.left>.icon-prev {
		top: 200px;
	}
	.right>.icon-next {
		top: 200px;
	}
}
/***************************/
.img {
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	border-radius: 4px;
	margin-bottom: 20px;
	position: relative;
}

@media ( max-width : 401px) {
	.img {
		height: 260px;
	}
}

@media ( min-width : 401px)and (max-width: 490px) {
	.img {
		height: 280px;
	}
}

@media ( min-width : 490px)and (max-width: 580px) {
	.img {
		height: 335px;
	}
}

@media ( min-width : 580px)and (max-width: 670px) {
	.img {
		height: 410px;
	}
}

@media ( min-width : 670px)and (max-width: 768px) {
	.img {
		height: 490px;
	}
}

@media ( min-width : 768px) and (max-width: 880px) {
	.img {
		height: 275px;
	}
}

@media ( min-width : 880px) and (max-width: 992px) {
	.img {
		height: 330px;
	}
}

@media ( min-width : 992px) and (max-width: 1095px) {
	.img {
		height: 270px;
	}
}

@media ( min-width : 1095px) and (max-width: 1200px) {
	.img {
		height: 300px;
	}
}

@media ( min-width : 1200px) and (max-width: 1350px) {
	.img {
		height: 330px;
	}
}

@media ( min-width : 1350px) and (max-width: 1500px) {
	.img {
		height: 365px;
	}
}

@media ( min-width : 1500px) and (max-width: 1600px) {
	.img {
		height: 400px;
	}
}

@media ( min-width : 1600px) {
	.img {
		height: 430px;
	}
}
/**********************/
.wrapper>.image-wrapper {
	width: 100%;
	height: 100%;
	border-radius: 4px;
	position: absolute;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	z-index: 3;
	background-color: rgba(0, 0, 0, 0.7);
}

.wrapper>.cation-wrapper1 {
	width: 100%;
	height: 50%;
	position: absolute;
	top: 50%;
	left: 0;
	bottom: 0;
	right: 0;
	z-index: 4;
	background-color: #fff;
	border: 1px solid #ccc;
	border-radius: 0 0 4px 4px;
	text-align: center;
	vertical-align: center;
}

.wrapper {
	opacity: 0;
	-webkit transition: opacity 0.7s;
	-moz transition: opacity 0.7s;
	transition: opacity 0.7s;
}

.wrapper:hover {
	opacity: 1;
}

.image-wrapper>a {
	position: relative;
	top: 7px;
	left: 85%;
	right: 0;
	bottom: 0;
	font-size: 24px;
	z-index: 10;
}

div.wrapper .hatetosee {
	color: #ffffff;
}

div.wrapper .hatetosee:hover {
	color: #dddddd;
}

div.wrapper .wannasee {
	color: #ff4444;
}

div.wrapper .wannasee:hover {
	color: #dd2222;
}

/******************/
.wrapper2>.image-wrapper2 {
	width: 100%;
	height: 100%;
	border-radius: 4px;
	position: absolute;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	z-index: 1;
	background-color: rgba(0, 0, 0, 0.7);
}

.wrapper2>.cation-wrapper2 {
	width: 100%;
	height: 50%;
	position: absolute;
	top: 50%;
	left: 0;
	bottom: 0;
	right: 0;
	z-index: 2;
	background-color: #fff;
	border: 1px solid #ccc;
	border-radius: 0 0 4px 4px;
	text-align: center;
	vertical-align: center;
}

.wrapper2 {
	opacity: 0;
	-webkit transition: opacity 0.7s;
	-moz transition: opacity 0.7s;
	transition: opacity 0.7s;
	height: 0;
}

.wrapper2:target {
	opacity: 1;
}

.image-wrapper2>a {
	position: relative;
	top: 7px;
	left: 85%;
	right: 0;
	bottom: 0;
	font-size: 24px;
}

/**관심없어요 */
div.wrapper .hatetosee {
	color: #ffffff;
}

div.wrapper .hatetosee:hover {
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
div.wrapper .wannasee {
	color: #ff4444;
}

div.wrapper .wannasee:hover {
	color: #dd2222;
}
/**보고싶어요 취소 선택 시*/
div.wrapper .seen {
	color: #ff9944;
}

div.wrapper .seen:hover {
	color: #dd7722;
}

/******************/
.navbar>ul>li {
	width: 100%;
}

.spacearea {
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
.modal-backdrop {
	z-index: 0;
}

.hide {
	display: none;
}

.space1 {
	top: 75px
}
 /**d3 **/
.barcol {
  fill: skyblue;
/*     fill-opacity: 0.3;
    stroke: skyblue; */
    stroke: blue;

}
.barcol:hover {
/*     fill-opacity: 1; */
    fill: blue;
}
.textcol {
    fill: white;
    font-weight:bold;
}


</style>

</head>

<body>

	<%@ include file="/WEB-INF/inc/top/top_mystory.jsp"%>
	<%@ include file="/WEB-INF/inc/sidebar/sidebar_statistics.jsp"%>

	<!-- 오른 쪽 메인 내용 문의게시판 시작 12중 10 -->
	<div class="container col-sm-10 col-md-10">
		<div class="spacearea">
			<h1>취향통계분석</h1>
			<hr/>

		</div>
		<div class="col-sm-5 col-md-5">
		<svg id="g1"></svg>
		<svg id="g2"></svg>
		</div>
		<div class="col-sm-5 col-md-5">
		<svg id="g3" height=500></svg>
		</div>

		
				
	</div>
	<!--섬네일 끝-->





</body>
<script src="https://d3js.org/d3.v4.min.js"></script>

<script type="text/javascript">
var dataset = [9, 19, 29, 39, 29, 19, 9];
var dataset2 =[];

<c:forEach items="${nummovie}" varStatus="k">
	dataset2[${k.index}] = ${nummovie[k.index]};
</c:forEach>

var svg1 = d3.select("#g1");
svg1.selectAll("bar") 
	.data(dataset)
	.enter().append("rect")
		.attr("class", "barcol")
		.attr("height", function(d, i) {return d})
		.attr("width", 20)
		.attr("x", function(d, i) {return (20 * i)})
		.attr("y", function(d, i) {return (100 - dataset[i])}); 
	
svg1.selectAll("text") 
	.data(dataset)
	.enter().append("text")
	.text(function(d) {return d})
		.attr("class", "textcol")
		.attr("x", function(d, i) {return (20 * i+3)})
		.attr("y", function(d, i) {return (100 - dataset[i]+15)}); 
	
var svg2 = d3.select("#g2");

svg2.selectAll("bar") 
	.data(dataset2)
	.enter().append("rect")
	.attr("class", "barcol")
	.attr("height", function(d, i) {return d})
	.attr("width", 20)
	.attr("x", function(d, i) {return (20 * i)})
	.attr("y", function(d, i) {return (100 - dataset2[i])}); 

svg2.selectAll("text") 
	.data(dataset2)
	.enter().append("text")
	.text(function(d) {return d})
		.attr("class", "textcol")
		.attr("x", function(d, i) {return (20 * i+3)})
		.attr("y", function(d, i) {return (100 - dataset2[i]+15)}); 

/* var dataset3 = [{x:'A', y:9}, {x:'B', y:19}, {x:'C', y:29}, {x:'D', y:39}, {x:'E', y:29}, {x:'F', y:19}, {x:'G', y:9}]; 
 */
 var dataset3 =[];
<c:forEach items="${nummovie}" varStatus="k">
	dataset3[${k.index}] =  ${ {month[k.index], nummovie[k.index]} };
</c:forEach>
var svg3 = d3.select("#g3");
svg3.selectAll("rect")
	.data(dataset3)
	.enter().append("rect")
		.attr("class", "barcol") 
		.attr("height", function(d, i) {return (d.y*5)})
		.attr("width", 20) 
		.attr("x", function(d, i) {return (20 * i)}) 
		.attr("y", function(d, i) {return (250-d.y*5)}); 
svg3.selectAll("text")
	.data(dataset3) 
	.enter().append("text") 
	.text(function(d) {return d.y}) 
		.attr("class", "textcol") 
		.attr("x", function(d, i) {return 20 * i+3}) 
		.attr("y", function(d, i) {return 250-d.y*5 + 15});



</script>

</html>