package project.gatcha.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import project.gatcha.dao.MyBatisConnectionFactory;
import project.gatcha.helper.BaseController;
import project.gatcha.helper.UploadHelper;
import project.gatcha.helper.WebHelper;
import project.gatcha.model.Member;
import project.gatcha.service.MemberService;
import project.gatcha.service.impl.MemberServiceImpl;

@WebServlet("/member/login_ok.do")
public class LoginOk extends BaseController {
	
	private static final long serialVersionUID = 7934865144290814858L;
	/** (1) 사용하고자 하는 Helper + Service 객체 선언 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;
	// --> import org.apache.ibatis.session.SqlSession;
	SqlSession sqlSession;
	// --> import project.gatcha.helper.WebHelper;
	WebHelper web;
	// --> import project.gatcha.helper.UploadHelper;
	UploadHelper upload;
	// --> import project.gatcha.mysite.service.MemberService;
	MemberService memberService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		// --> import org.apache.logging.log4j.LogManager;
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		// --> import project.gatcha.mysite.service.impl.MemberServiceImpl;
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		upload = UploadHelper.getInstance();
		// 회원가입 처리를 위한 Service객체
		// --> import project.gatcha.mysite.service.impl.MemberServiceImpl;
		memberService = new MemberServiceImpl(sqlSession, logger);
		
		
		/** (3) 로그인 여부 검사 */
		// 로그인 중이라면 이 페이지를 동작시켜서는 안된다.
		if (web.getSession("loginInfo") != null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/main.do", "이미 로그인 하셨습니다.");
			return null;
		}

		/** (4) 파라미터 처리 */
		// --> topbar.jsp에 배치된 폼으로부터 전송되는 입력값.
		String email = web.getString("email");
		String userPw = web.getString("userPw");
		System.out.println("값 받음");
		logger.debug("email=" + email);
		logger.debug("userPw=" + userPw);
		
		if (email == null || userPw == null) {
			sqlSession.close();
			web.redirect(null, "아이디나 비밀번호가 없습니다.");
			return null;
		}

		/** (5) 전달받은 파라미터를 Beans에 설정한다. */
		Member member = new Member();
		member.setEmail(email);
		member.setUserPw(userPw);
		
		/** (6) Service를 통한 회원 인증 */
		Member loginInfo = null;
		
		try {
			// 아이디와 비밀번호가 일치하는 회원 정보를 조회하여 리턴한다.
			
			loginInfo = memberService.selectLoginInfo(member);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		/** (8) 조회된 회원 정보를 세션에 저장 */
		// 로그인 처리는 아이디와 비밀번호를 기반으로 조회된 정보를
		// 세션에 보관하는 과정을 말한다.
		// 로그인에 대한 판별은 저장된 세션정보의 존재 여부로 판별한다.
		web.setSession("loginInfo", loginInfo);
		
//		/** (9) 페이지 이동 */
//		// 이전 페이지 구하기 (javascript로 이동된 경우 조회 안됨)
//		String movePage =mull;
//		System.out.println("-----------ㅝ냐ㅁ"+movePage);
//		if (movePage == null) {
//			movePage = web.getRootPath() + ;
//		}
		
		sqlSession.close();
		web.redirect(web.getRootPath()+"/main.do", null);
		return null;
	}

}
