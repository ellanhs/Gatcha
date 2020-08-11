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
            background-image: url('${pageContext.request.contextPath}/assets/img/movie.jpg');
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
  
    
</style>
</head>

<body> 
<!-- 로그인 -->

  <div id="modal-dialog">
      <div class="modal-content">
      <!-- 로고  -->
      <div class="modal-header" align="center">
           <img class="img-circle" id="img_logo" src="${pageContext.request.contextPath}/assets/img/logo.png">
      </div>        
     <!-- 비밀번호 변경 폼 -->
	  <div class="modal-body" >
	  	   <div id="div-login-msg">
                    <div id="icon-login-msg" class="glyphicon glyphicon-chevron-right"></div>
                         <span id="text-login-msg">비밀번호 찾기</span>
        </div>
			<p style="padding-top:10px;">
				가입시 입력한 이메일 주소를 입력하세요.
				임시 비밀번호를 이메일로 보내드립니다.
			</p>
			<form name="myform" method="post" action="${pageContext.request.contextPath}/member/find_pw_ok.do">
				<div class="form-group">
				   <input id="login_username" class="form-control" type="email" name="email" autofocus="autofocus" placeholder="이메일을 입력하세요." autocorect="off" autocpmplete="off" autocapitaize="off" required>
				</div>
			
	<!-- 모달 아래 하단 -->
	     <div class="modal-footer" style="padding-left:0px; padding-right:0px;">
		   <div>
					<button type="submit" class="btn btn-primary btn-block" style="height:38px;">
						비밀번호 재설정 하기</button>
			</div>	
			 <div>
                   <button id="login_register_btn" type="button" class="btn btn-link" style="position:relative; right:259px;"><a href="${pageContext.request.contextPath}/index.do">로그인하러 가기</a></button>
                 </div>
    </div>
	<!-- 모달 아래 하단 끝 -->
			</form>
			   <!-- modal-body 끝 -->
		</div>
		  <!-- modal-content끝 -->
	</div>
	<!-- modal-dialog 끝 -->
   </div> 
</body>

</html>