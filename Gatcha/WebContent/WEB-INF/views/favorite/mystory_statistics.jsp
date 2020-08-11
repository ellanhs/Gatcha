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

.bar {
  fill: skyblue;
}

.bar:hover {
  fill: royalblue;
}

 .axis--x path {
  display: none;
} 
.bar text {
  fill: black;
  font: 12px sans-serif;
  text-anchor: middle;
}

.arc text {
  font: 10px sans-serif;
  text-anchor: middle;
}

.arc path {
  stroke: #fff;
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
		<div class="col-sm-6 col-md-6">
		<h4>회원평가영화 년도별 분포도</h4>
			<svg id="g1" width="480" height="250"></svg>
		<h4>회원평가영화 월별 분포도</h4>
			<svg id="g2" width="480" height="250"></svg>
		<h4>회원평가영화 장르별 분포도</h4>
			<svg id="g3" width="480" height="250"></svg>
		</div>
		<div class="col-sm-6 col-md-6">
				<h4>선호감독</h4>
			<ol>
				
					<li>
						<h5>${dirName1}</h5>
						<img src="${dirUrl1}" width="80" height="100">
					</li>
					<li>
						<h5>${dirName2}</h5>
						<img src="${dirUrl2}" width="80" height="100">
					</li>
					<li>
						<h5>${dirName3}</h5>
						<img src="${dirUrl3}" width="80" height="100">
					</li>
				
			</ol>
			<br/>
			    <h4>선호배우</h4>
			<ol>
				
					<li>
						<h5>${actName1}</h5>
						<img src="${actUrl1}" width="80" height="100">
					</li>
					<li>
						<h5>${actName2}</h5>
						<img src="${actUrl2}" width="80" height="100">
					</li>
					<li>
						<h5>${actName3}</h5>
						<img src="${actUrl3}" width="80" height="100">
					</li>
					
				
			</ol>
		</div>
		
				
	</div>
	<!--섬네일 끝-->





</body>
<script src="https://d3js.org/d3.v4.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/Donut3D.js"></script>
<script type="text/javascript">

var data=${data};
var svg1 = d3.select("#g1"),
margin = {top: 20, right: 20, bottom: 30, left: 40},
width = +svg1.attr("width") - margin.left - margin.right,
height = +svg1.attr("height") - margin.top - margin.bottom;

var x = d3.scaleBand().rangeRound([0, width]).padding(0.1),
y = d3.scaleLinear().rangeRound([height, 0]);

var g = svg1.append("g")
.attr("transform", "translate(" + margin.left + "," + margin.top + ")");



x.domain(data.map(function(d) { return d.letter; }));
y.domain([0, d3.max(data, function(d) { return d.frequency; })]);

g.append("g")
  .attr("class", "axis axis--x")
  .attr("transform", "translate(0," + height + ")")
  .call(d3.axisBottom(x));

g.append("g")
  .attr("class", "axis axis--y")
  .call(d3.axisLeft(y).ticks(10))
.append("text")
  .attr("transform", "rotate(-90)")
  .attr("y", 6)
  .attr("dy", "0.71em")
  .attr("text-anchor", "end")
  .text("Frequency");

g.selectAll(".bar")
.data(data)
.enter().append("rect")
  .attr("class", "bar")
  .attr("x", function(d) { return x(d.letter); })
  .attr("y", function(d) { return y(d.frequency); })
  .attr("width", x.bandwidth())
  .attr("height", function(d) { return height - y(d.frequency); });

/* ******************* */
var datam=${data2};
var svg2 = d3.select("#g2"),
marginm = {top: 20, right: 20, bottom: 30, left: 40},
widthm = +svg2.attr("width") - marginm.left - marginm.right,
heightm = +svg2.attr("height") - marginm.top - marginm.bottom;

var xm = d3.scaleBand().rangeRound([0, widthm]).padding(0.1),
ym = d3.scaleLinear().rangeRound([heightm, 0]);

var gm = svg2.append("g")
.attr("transform", "translate(" + marginm.left + "," + marginm.top + ")");



xm.domain(datam.map(function(d) { return d.month; }));
ym.domain([0, d3.max(datam, function(d) { return d.numofmoviemonth; })]);

gm.append("g")
  .attr("class", "axis axis--x")
  .attr("transform", "translate(0," + heightm + ")")
  .call(d3.axisBottom(xm));

gm.append("g")
  .attr("class", "axis axis--y")
  .call(d3.axisLeft(ym).ticks(10))
.append("text")
  .attr("transform", "rotate(-90)")
  .attr("y", 6)
  .attr("dy", "0.71em")
  .attr("text-anchor", "end")
  .text("Numofmoviemonth");

gm.selectAll(".bar")
.data(datam)
.enter().append("rect")
  .attr("class", "bar")
  .attr("x", function(d) { return xm(d.month); })
  .attr("y", function(d) { return ym(d.numofmoviemonth); })
  .attr("width", xm.bandwidth())
  .attr("height", function(d) { return heightm - ym(d.numofmoviemonth); });

gm.selectAll(".bar")
.data(datam)
.enter().append("text")
  .attr("class", "text")
  .attr("x", function(d) { return xm(d.month); })
  .attr("y",  function(d) { return heightm - ym(d.numofmoviemonth); })
  .attr("dy", "0.35em")
  .text(function(d) { return d.numofmoviemonth; });
  

  
  /************************/
 var datad = ${data3};
 
var svgd = d3.select("#g3"),
    widthd = +svgd.attr("width"),
    heightd = +svgd.attr("height"),
    radiusd = Math.min(widthd, heightd) / 2,
    gd = svgd.append("g").attr("transform", "translate(" + (widthd / 2) + "," + (heightd / 2) + ")");

var color = d3.scaleOrdinal(["#ff9696", "#ffd5a1", "#d4ffb2", "#d8edff", "#ecc9ff", "#db8070", "#ffa263", "#1a9c99", "#b5c5a9"]); 

var pie = d3.pie()
    .sort(null)
    .value(function(d) { return d.population; });

var path = d3.arc()
    .outerRadius(radiusd - 10)
    .innerRadius(0);

var label = d3.arc()
    .outerRadius(radiusd - 40)
    .innerRadius(radiusd - 40);

var arc = gd.selectAll(".arc")
.data(pie(datad))
.enter().append("g")
  .attr("class", "arc");

arc.append("path")
  .attr("d", path)
  .attr("fill", function(d) { return color(d.data.genre); });

arc.append("text")
  .attr("transform", function(d) { return "translate(" + label.centroid(d) + ")"; })
  .attr("dy", "0.35em")
  .text(function(d) { return d.data.genre; });

</script>


</html>