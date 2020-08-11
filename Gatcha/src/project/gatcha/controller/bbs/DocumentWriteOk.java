package project.gatcha.controller.bbs;

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
import project.gatcha.helper.RegexHelper;
import project.gatcha.helper.WebHelper;
import project.gatcha.model.Bbs;
import project.gatcha.model.Member;
import project.gatcha.service.BbsService;
import project.gatcha.service.impl.BbsServiceImpl;


@WebServlet("/bbs/document_write_ok.do")
public class DocumentWriteOk extends BaseController {

	private static final long serialVersionUID = 4002784508242139625L;
	
	/** (1) 사용하고자 하는 Helper 객체 선언 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;
	// --> import org.apache.ibatis.session.SqlSession;
	SqlSession sqlSession;
	// --> import study.jsp.helper.WebHelper;
	WebHelper web;

	// --> import study.jsp.helper.RegexHelper;
	RegexHelper regex;
	// --> import study.jsp.mysite.service.BbsService;
	BbsService bbsService;


	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		// --> import org.apache.logging.log4j.LogManager;
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		// --> import study.jsp.mysite.service.impl.MemberServiceImpl;
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);

		regex = RegexHelper.getInstance();
		// --> import study.jsp.mysite.service.impl.BbsServiceImpl;
		bbsService = new BbsServiceImpl(sqlSession, logger);

		/** (3) 로그인 여부 검사 */
		// 로그인 중이 아니라면 이 페이지를 동작시켜서는 안된다.
		if (web.getSession("loginInfo") == null) {
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}


		/** (4) Post 방식으로 전달받은 변수 받기 */
		String subject = web.getString("subject");
		String content = web.getString("content");

		// 로그인 한 경우, 회원 아이디를 세션정보로 대체
		Member loginInfo = (Member) web.getSession("loginInfo");
		int memberId = loginInfo.getId();

		// 전달된 파라미터는 로그로 확인한다.
		logger.debug("subject=" + subject);
		logger.debug("content=" + content);
		logger.debug("memberId=" + memberId);


		/** (5) 입력 받은 파라미터에 대한 유효성 검사 */

		// 제목 및 내용 검사
		if (!regex.isValue(subject)) {
			sqlSession.close();
			web.redirect(null, "글 제목을 입력하세요.");
			return null;
		}

		if (!regex.isValue(content)) {
			sqlSession.close();
			web.redirect(null, "내용을 입력하세요.");
			return null;
		}

		/** (6) 입력 받은 파라미터를 Beans로 묶기 */
		Bbs bbs = new Bbs();
		bbs.setSubject(subject);
		bbs.setContent(content);
		bbs.setMemberId(memberId);
		
		logger.debug("document >> " + bbs.toString());

	
		/** (7) Service를 통한 게시물 저장 */
		try {
				bbsService.insertBbs(bbs);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally{
			sqlSession.close();
		}

		
		/** (8) 저장 완료 후 읽기 페이지로 이동하기 */
		// 읽어들일 게시물을 식별하기 위한 게시물 일련번호값을 전달해야 한다.
		String url = "%s/bbs/document_read.do?id=%d";
		url = String.format(url, web.getRootPath(), bbs.getId());
		web.redirect(url, null);
		return null;
	}

}
