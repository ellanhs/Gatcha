<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/head.jsp" %>
<style type="text/css">

        html, body { padding: 0; margin: 0; width: 100%; height: 100%;  }

        body {
            width: 100%;
            height: 100%;
            background-image: url('assets/img/movie.jpg');
            background-size: cover;
            display: table;     
            /* 자식요소를 세로 중앙에 놓기 위한 처리 */
        }

        #modal-dialog {
         width: 400px;
         height: 500px;
         position: absolute;
         top:0;
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
        
        #div-login-msg.success,
        #div-lost-msg.success,
        #div-register-msg.success {
            border: 1px solid #68c3a3;
            background-color: #c8f7c5;
        }

        #div-login-msg.error,
        #div-lost-msg.error,
        #div-register-msg.error {
            border: 1px solid #eb575b;
            background-color: #ffcad1;
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
       
       #icon-login-msg.success,
       #icon-lost-msg.success,
       #icon-register-msg.success {
           background-color: #68c3a3 !important;
       }
       
       #icon-login-msg.error,
       #icon-lost-msg.error,
       #icon-register-msg.error {
           background-color: #eb575b !important;
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
     
     .glyphicon {
         top: 0px;
     }
     
     .form-control {
       border-radius: 0px;
     }
</style>
</head>

<body> 
<!-- 로그인 -->

<!-- 로그인이 안 된 경우 -->
  <div id="modal-dialog">
      <div class="modal-content">
      <!-- 로고  -->
       <div class="modal-header" align="center">
           <img class="img-circle" id="img_logo" src="assets/img/logo.png">
       </div>        
     <!-- 로그인 폼 -->
 
      <form class="login-form" method="post" action="${pageContext.request.contextPath}/member/login_ok.do" >
     <!-- 로그인폼 상단시작 -->
           <div class="modal-body">
               <div id="div-login-msg">
                    <div id="icon-login-msg" class="glyphicon glyphicon-chevron-right"></div>
                         <span id="text-login-msg">이메일과 비밀번호를 입력하세요.</span>
               </div>
               <input id="login_username" class="form-control" type="email" name="email" autofocus="autofocus" placeholder="이메일을 입력하세요." autocorect="off" autocpmplete="off" autocapitaize="off" required>
               <input id="login_password" class="form-control" type="password" name="userPw" placeholder="비밀번호를 입력하세요." autocorect="off" autocpmplete="off" autocapitaize="off" required>
         
            </div>
   <!-- 로그인폼 상단 끝 -->
   <!--로그인 폼 하단-->
      <div class="modal-footer">
          <div>
            <button type="submit" class="btn btn-primary btn-lg btn-block" >Login</button>
           </div>
           <div>
            <button id="login_lost_btn" type="button" class="btn btn-link"><a href="${pageContext.request.contextPath}/member/find_pw.do">비밀번호 찾기</a></button>
            <button id="login_register_btn" type="button" class="btn btn-link"><a href="${pageContext.request.contextPath}/member/join.do">가입하기</a></button>
           </div>
       </div>
  <!-- 로그인 폼 하단 끝 -->
      </form>
                    
     </div>
   </div>

</body>

</html>