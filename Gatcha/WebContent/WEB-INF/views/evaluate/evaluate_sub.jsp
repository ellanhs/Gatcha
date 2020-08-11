<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>

<form id="evaluate_info_form">
	<c:choose>
		<c:when test="${photo.stilcut!=null}">
			<div class="modal-header" align="center"
				style="background-image: url('${photo.stilcut}'); background-position: center center; background-repeat: no-repeat; background-size: cover; padding-left: 0px;  padding-right: 0px; padding-top: 0px; padding-bottom: 0px; height:250px; border: transparent;"></div>
		</c:when>
		<c:otherwise>
			<div class="modal-header" align="center"
				style="background-color: #ff4444; padding-left: 0px; padding-right: 0px; padding-top: 0px; padding-bottom: 0px; margin-bottom: 100px; height: 50px; border: transparent;"></div>
		</c:otherwise>
	</c:choose>
	<div class="row height">
		<div class="col-sm-12">
			<div class="col-sm-3" style="margin-top: 15px;">
				<img src="${photo.poster}" width="200" height="300">
			</div>

			<div class="col-sm-9 desc" style="margin-top: 30px;">
				<div>
					<span> <b style="font-size: 20px;">${movieInfo.title}</b>
					</span> <span>${movieInfo.year}</span> <span>${movieInfo.country}</span> <span>${genres}</span>
					<c:if test="${movieInfo.age}==null">
						<span>전체이용가, ${movieInfo.runtime}</span>
					</c:if>

					<c:if test="${movieInfo.age}!=null">
						<span>${movieInfo.age},${movieInfo.runtime}</span>
					</c:if>
				</div>
				<hr>
				<div class="col-sm-3" style="min-height: 200px;">
					<h6>예고편</h6>
					<c:if test="${photo.tralier!=null}">
						<a data-toggle="modal" href='#evaluate_info_preview_form'><img
							src="${pageContext.request.contextPath}/assets/img/movie/preview.png"
							style="width: 100px; height: 100px;"></a>
					</c:if>
					<c:if test="${photo.tralier==null}">
						<a data-toggle="modal" href='#'><img
							src="${pageContext.request.contextPath}/assets/img/movie/preview.png"
							style="width: 100px; height: 100px;"></a>
					</c:if>
				</div>

				<c:if test="${directorAA.name != null}">
					<div class="col-sm-3">
						<h5>감독 : ${directorAA.name}</h5>
						<c:if test="${directorAA.peopleP !=''}">
							<img src="${directorAA.peopleP}" width="80" height="100">
						</c:if>


						<c:if test="${directorAA.peopleP ==''}">
							<img
								src="${pageContext.request.contextPath}/assets/img/movie/nobody.jpg"
								width="80" height="100" />
						</c:if>

					</div>
				</c:if>
				<c:if test="${actor0.name != null}">
					<div class="col-sm-3">
						<h5>배우 : ${actor0.name}</h5>
						<c:if test="${actor0.peopleP !=''}">
							<img src="${actor0.peopleP}" width="80" height="100">
						</c:if>


						<c:if test="${actor0.peopleP ==''}">
							<img
								src="${pageContext.request.contextPath}/assets/img/movie/nobody.jpg"
								width="80" height="100" />
						</c:if>
					</div>
				</c:if>

				<c:if test="${actor1.name != null}">
					<div class="col-sm-3">
						<h5>배우 : ${actor1.name}</h5>
						<c:if test="${actor1.peopleP !=''}">
							<img src="${actor1.peopleP}" width="80" height="100">
						</c:if>


						<c:if test="${actor1.peopleP ==''}">
							<img
								src="${pageContext.request.contextPath}/assets/img/movie/nobody.jpg"
								width="80" height="100" />
						</c:if>
					</div>
				</c:if>

				<c:if test="${actor2.name != null}">
					<div class="col-sm-3">
						<h5>배우 : ${actor2.name}</h5>
						<c:if test="${actor2.peopleP !=''}">
							<img src="${actor2.peopleP}" width="80" height="100">
						</c:if>


						<c:if test="${actor2.peopleP ==''}">
							<img
								src="${pageContext.request.contextPath}/assets/img/movie/nobody.jpg"
								width="80" height="100" />
						</c:if>

					</div>
				</c:if>

				<c:if test="${actor3.name != null and actor3.name != actor2.name}">
					<div class="col-sm-3">
						<h5>배우 : ${actor3.name}</h5>
						<c:if test="${actor3.peopleP !=''}">
							<img src="${actor3.peopleP}" width="80" height="100" />
						</c:if>
						<c:if test="${actor3.peopleP ==''}">
							<img
								src="${pageContext.request.contextPath}/assets/img/movie/nobody.jpg"
								width="80" height="100" />
						</c:if>
					</div>
				</c:if>

			</div>
			<div class="col-sm-offset-3 col-sm-9">
				<br>
				<hr />
			</div>
		</div>
		<c:if test="${photo.tralier!=null}">
			<div class="modal" id="evaluate_info_preview_form" aria-hidden='true'
				style='display: none; z-index: 1500;'>
				<div class="container">
					<div class='embed-responsive embed-responsive-16by9 height300'>
						<iframe class='embed-responsive-item'
							src='https://www.youtube.com/embed/${photo.tralier}'
							allowfullscreen></iframe>
					</div>
				</div>
			</div>
		</c:if>
		<div class="col-sm-12">

			<br> <br>
		</div>
		<div class="col-sm-12" id="etc"
			style="left: 0px; right: 0px; margin-left: 10px; min-height: 200px;">
			<div>
				<p style="padding-right: 50px; padding-left: 50px; padding-bottom: 30px;">
					<b>줄거리</b><br /> ${movieInfo.context}
				</p>
			</div>


		</div>
	</div>


</form>