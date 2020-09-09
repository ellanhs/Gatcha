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


@WebServlet("/bbs/document_comment.do")
public class DocumentComment extends BaseController {

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
		

		// 파라미터를 Beans로 묶기
		Bbs bbs = new Bbs();
		bbs.setId(id);

		
		/** (5) 회원 등급을 사용해서 관리자 확인 */	
		// 관리자가 아니면 댓글을 달 수 없다.
		// 회원 레벨을 세션정보로 대체
		Member loginInfo = (Member) web.getSession("loginInfo");
		int memberLevel = loginInfo.getLevel();
		if( memberLevel !=1){
			sqlSession.close();
			web.redirect(null, "관리자가 아니면 사용할 수 없습니다.");
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


		return "bbs/comment";
	}

}
