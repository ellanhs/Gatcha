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
import project.gatcha.helper.WebHelper;
import project.gatcha.model.Bbs;
import project.gatcha.model.Member;
import project.gatcha.service.BbsService;
import project.gatcha.service.impl.BbsServiceImpl;


@WebServlet("/bbs/document_edit.do")
public class DocumentEdit extends BaseController {

	private static final long serialVersionUID = 5419537029568505698L;
	/** (1) 사용하고자 하는 Helper 객체 선언 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;
	// --> import org.apache.ibatis.session.SqlSession;
	SqlSession sqlSession;
	// --> import study.jsp.helper.WebHelper;
	WebHelper web;

	// --> import study.jsp.mysite.service.BbsDocumentService;
	BbsService bbsService;


	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		// --> import org.apache.logging.log4j.LogManager;
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		// --> import study.jsp.mysite.service.impl.MemberServiceImpl;
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);


		// --> import study.jsp.mysite.service.impl.BbsDocumentServiceImpl;
		bbsService = new BbsServiceImpl(sqlSession, logger);

		/** (3) 로그인 여부 검사 */
		// 로그인 중이 아니라면 이 페이지를 동작시켜서는 안된다.
		if (web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}
		
		/** (4) 글 번호 파라미터 받기 */
		int id = web.getInt("id");
		if (id == 0) {
			sqlSession.close();
			web.redirect(null, "글 번호가 지정되지 않았습니다.");
			return null;
		}
		
		// 로그인 한 경우, 회원 아이디를 세션정보로 대체
		Member loginInfo = (Member) web.getSession("loginInfo");
		int memberId = loginInfo.getId();

		// 파라미터를 Beans로 묶기
		Bbs bbs = new Bbs();
		bbs.setId(id);
		bbs.setMemberId(memberId);

		
		/** (5) 게시물 일련번호를 사용한 데이터 조회 */	
		// 회원번호가 일치하는 게시물 수 조회하기
		// 자신의 글이 아니면 수정할 수 없다.
		int documentCount = 0; 
		try {
			documentCount = bbsService.selectBbsCountByMemberId(bbs);
			if((documentCount <= 0) && (loginInfo.getLevel() != 1)){
				throw new NullPointerException("회원님의 게시글이 아니어서 수정하실 수 없습니다.");
			}
		}	catch (NullPointerException e){
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}	catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} 
		
		/** (6) 게시물 일련번호를 사용한 데이터 조회 */
		// 지금 읽고 있는 게시물이 저장될 객체
		Bbs document = null;

		try {
			document = bbsService.selectBbs(bbs);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}

		/** (7) 읽은 데이터를 View에게 전달한다. */
		request.setAttribute("document", document);


		return "bbs/edit";
	}

}
