<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/head.jsp" %>
<style type="text/css">
.deactive{
    margin-left: 15px;
    line-height: 52px;
    color: #555;
    cursor: pointer;
    vertical-align: baseline;
   font-size: 17px;
    position: relative;
    left: 860px;
    position: relative;
    bottom: 50px;

}
    
</style>
</head>
<body>
<%@ include file="/WEB-INF/inc/top/top_member.jsp" %>
<div class='container'>
    <div class='page-header'>
        <h1>회원정보 수정</h1>
    </div>
    <!-- 가입폼 시작 -->
    <form class="form-horizontal" name="myform" method="post" action="${pageContext.request.contextPath}/member/edit_ok.do" enctype="multipart/form-data">

        <div class="form-group">
            <label for='email' class="col-md-2">이메일*</label>
            <div class="col-md-10">
                <!-- 이메일은 변경할 수 없기 때문에 출력만 한다. -->
                <p class="form-control-static">${loginInfo.email}</p>
            </div>

       </div>
        <div class="form-group">
            <label for='nickname' class="col-md-2">닉네임*</label>
            <div class="col-md-10">
                <input type="text" name="nickname" id="nickname" class="form-control" 
                    value="${loginInfo.nickname}"/>
            </div>
        </div>


        <div class="form-group">
            <label for='"user_pw"' class="col-md-2">현재 비밀번호*</label>
            <div class="col-md-10">
                <input type="password" name="userPw" id="userPw" class="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label for='new_user_pw' class="col-md-2">변경할 비밀번호</label>
            <div class="col-md-10">
                <input type="password" name="newUserPw" id="newUserPw" 
                    class="form-control" placeholder="변경을 원하실 경우만 입력하세요."/>
            </div>
        </div>

		<div class="form-group">
            <label for='new_user_pw_re' class="col-md-2">변경할 비밀번호 확인</label>
            <div class="col-md-10">
                <input type="password" name="newUserPwRe" id="newUserPwRe" 
                    class="form-control" placeholder="변경할 비밀번호 확인"/>
            </div>
        </div>
        

        <div class="form-group">
            <label for='gender1' class="col-md-2">성별</label>
            <div class="col-md-10">
            	<label class="radio-inline">
                	<input type="radio" name="gender" id="gender1" value="M"  
                		<c:if test="${loginInfo.gender == 'M'}">checked</c:if>/> 남자
                </label>
                <label class="radio-inline">
                	<input type="radio" name="gender" id="gender2" value="F"
                		<c:if test="${loginInfo.gender == 'F'}">checked</c:if> /> 여자
                </label>
            </div>
        </div>
        
        
         <div class="form-group">
            <label for='birthdate' class="col-md-2">생년월일</label>
            <div class="col-md-10">
            <p class="form-control-static">${loginInfo.birthdate}</p>
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <button type="submit" class="btn btn-primary">수정하기</button>
                <button type="reset" class="btn btn-danger">다시작성</button>
            </div>
        </div>
    </form>
       <a href="${pageContext.request.contextPath}/member/out.do"  class="deactive"   type="submit" >탈퇴하기</a>    
    <!-- 가입폼 끝 -->
</div>

</body>
</html>