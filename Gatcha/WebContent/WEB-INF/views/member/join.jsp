<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/head.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/datepicker/datepicker.min.css" />
<style type="text/css">
		
        html, body { width: 100%; height: 100%;  }

        body {
            width: 100%;
            height: 100%;
            background-image: url('${pageContext.request.contextPath}/assets/img/movie.jpg');
            background-size: cover;
            display: table;     
            /* 자식요소를 세로 중앙에 놓기 위한 처리 */
        }

        #modal-dialog {
         width: 400px;
         height: 800px;
         position: absolute;
         top:0px;
         bottom: 0;
         left: 0;
         right: 0;
         margin: auto;
         }

        #modal-dialog input[type=text], input[type=password] {
        margin-top: 10px;
         }

        #div-login-msg,
        #div-lost-msg,
        #div-register-msg {
        border: 1px solid #dadfe1;
        height: 30px;
        line-height: 28px;
        transition: all ease-in-out 500ms;
        }
        
           #icon-login-msg,
       #icon-lost-msg,
       #icon-register-msg {
           width: 30px;
           float: left;
           line-height: 28px;
           text-align: center;
           background-color: #dadfe1;
           margin-right: 5px;
           transition: all ease-in-out 500ms;
       }
       #icon-register-msg {
           width: 30px;
           float: left;
           line-height: 28px;
           text-align: center;
           background-color: #dadfe1;
           margin-right: 5px;
           transition: all ease-in-out 500ms;
       }
       
       #icon-login-msg.success,
       #icon-lost-msg.success,
       #icon-register-msg.success {
           background-color: #68c3a3 !important;
       }
       
   
        #img_logo {
            max-height: 100px;
            max-width: 100px;
        }  


       .modal-backdrop.in {
         filter: alpha(opacity=50);
         opacity: .8;
       }

      .modal-content {
        background-color: #ececec;
        border: 1px solid #bdc3c7;
        border-radius: 0px;
        outline: 0;
       }
    
      .modal-header {
        min-height: 16.43px;
        padding: 15px 15px 15px 15px;
        border-bottom: 0px;
       }

      .modal-body {
        position: relative;
        padding: 5px 15px 5px 15px;
      }
    
      .modal-footer {
        padding: 15px 15px 15px 15px;
        text-align: left;
        border-top: 0px;
      }
    
      .checkbox {
         margin-bottom: 0px;
       }
     
      .btn {
         border-radius: 0px;
      }
     
     .btn:focus,
     .btn:active:focus,
     .btn.active:focus,
     .btn.focus,
     .btn:active.focus,
     .btn.active.focus {
         outline: none;
     }
     
     .btn-lg, .btn-group-lg>.btn {
         border-radius: 0px;
     }
     
     .btn-link {
         padding: 5px 10px 0px 0px;
         color: #95a5a6;
     }

     .btn-link:hover, .btn-link:focus {
         color: #2c3e50;
         text-decoration: none;
     }     
  
     .bottom-button{
     padding :0px 0px 15px 120px;
     }
     .form-control {
      position: absolute;
      left: 10px;
      width:250px;
     }
      .form-horizontal{
      padding:5px 0  5px 0;
      }
     .col-md-3{
        padding: 2px 2px 2px 23px;
        width :80px;
        font-size: 13px;
        
     }
     

</style>
</head>
<body>
<!-- 로그인 -->
 
<!-- 로그인이 안 된 경우 -->
  <div id="modal-dialog">
      <div class="modal-content" style="top:140px;">
      <!-- 로고  -->
      <div class="modal-header" align="center">
           <img class="img-circle" id="img_logo" src="${pageContext.request.contextPath}/assets/img/logo.png">
      </div>       
     
     <!-- 조인 폼 --> 
     <div class="modal-body">
      <div id="div-login-msg">
                    <div id="icon-login-msg" class="glyphicon glyphicon-chevron-right"></div>
                         <span id="text-login-msg">회원가입하기</span>
      </div>
      <form class="form-horizontal" name="myform" method="post"  enctype="form-data"
        action="${pageContext.request.contextPath}/member/join_ok.do">
		<div class="form-group">
            <label for='nickname' class="col-md-3">닉네임*</label>
            <div class="col-md-9">
                <input type="text" name="nickname" id="nickname" class="form-control" placeholder="닉네임을 입력하세요."/>
            </div>
        </div>
        
        <div class="form-group">
            <label for='email' class="col-md-3">이메일*</label>
            <div class="col-md-9">
                <input type="text" name="email" id="email" class="form-control"placeholder="이메일을 입력하세요."/>
            </div>
        </div>

        <div class="form-group">
            <label for='"password"' class="col-md-3">비밀번호*</label>
            <div class="col-md-9">
                <input type="password" name="userPw" id="userPw" class="form-control"placeholder="비밀번호를 입력하세요."/>
            </div>
        </div>


        <div class="form-group">
            <label for='birthdate' class="col-md-3">생년월일*</label>
            <div class="col-md-9">
                <input type="text" name="birthdate" id="datepicker" class="form-control" placeholder="오른쪽 달력을 클릭해주세요." readonly />
                <a href="#" id="show-cal" style="position: relative;  left:252px;  top:13px;"><img  src="${pageContext.request.contextPath}/assets/img/calendar.png" height="20"></a>
            </div>
        </div>

        <div class="form-group">
            <label for='gender1' class="col-md-3">성별*</label>
            <div class="col-md-9">
            	<label class="radio-inline">
                	<input type="radio" name="gender" id="gender1" value="M"  /> 남자
                </label>
                <label class="radio-inline">
                	<input type="radio" name="gender" id="gender2" value="F" /> 여자
                </label>
            </div>
        </div>


        <div class="form-group">
            <label for='genre' class="col-md-3">선호장르*<p>
            1개이상 3개이하로 골라주세요</p> </label>    
            <div class="col-md-9">
            	<td>액션<input name="genre" id="genre1" type="checkbox" value="1"></td>
                <td>드라마 <input name="genre" type="checkbox" value="2"></td>
                <td>공포<input name="genre" type="checkbox" value="3"></td>
                <td>코미디<input name="genre" type="checkbox" value="4"></td>
                <td>스릴러<input name="genre" type="checkbox" value="5"></td>
                <td>로맨스<input name="genre" type="checkbox" value="6"></td>
                <td>판타지<input name="genre" type="checkbox" value="7"></td>
                <td>애니메이션<input name="genre" type="checkbox" value="8"></td>
            </div>
        </div>
        
                <!--로그인 폼 하단-->
                        <div class="modal-footer">
                            <div>
                                <button type="submit" class="btn btn-primary btn-lg btn-block">가입하기</button>
                            </div>
                            <div>
                                <button id="login_register_btn" type="button" class="btn btn-link"><a href="${pageContext.request.contextPath}/index.do">로그인하러 가기</a></button>
                            </div>
                        </div>
                    <!-- 로그인 폼 하단 끝 -->
       </form>
       </div>
      </div>
      </div>
      <script src="${pageContext.request.contextPath}/assets/plugins/datepicker/datepicker.min.js"></script>
      <script src="${pageContext.request.contextPath}/assets/plugins/datepicker/i8n/datepicker.ko-KR.js"></script>
<script>
     $(function(){
    	  $("#datepicker").datepicker({
    		  autoHide:true,            //날짜 선택 후 자동 숨김 (true/false)
    		  format:'yyyy-mm-dd', //날짜형식
    		  language:'ko-KR',       //언어
    		  weekStart:0,              //시작요일(0=일요일~6=토요일)
    		  trigger: '#show-cal'     //클릭시 달력을 표시할 요소의 id
    	  });
     });
</script>
</body>

</html>