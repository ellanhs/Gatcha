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


@WebServlet("/bbs/document_comment_ok.do")
public class DocumentCommentOk extends BaseController {

	private static final long serialVersionUID = -5869824828324582332L;
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
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}
		
		/** (4) Post 방식으로 전달받은 변수 받기 */
		int id = web.getInt("id");
		String comment = web.getString("comment");


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

		// 전달된 파라미터는 로그로 확인한다.
		logger.debug("id=" + id);
		logger.debug("comment=" + comment);
		logger.debug("memberLevel=" + memberLevel);




		
		/** (6) 입력 받은 파라미터를 Beans로 묶기 */
		Bbs bbs = new Bbs();
		bbs.setId(id);

		//코멘트 빈칸(공백) 데이터 처리
		if (!regex.isValue(comment)) {
			bbs.setComment(null); 
		}else{
		bbs.setComment(comment);
		}
		
		logger.debug("document >> " + bbs.toString());

		
		
		/** (7) Service를 통한 게시물 수정 후 DB접속 해제  */
		try {
				bbsService.updateBbsComment(bbs);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally{
			sqlSession.close();
		}

		
		/** (8) 모든 절차가 종료되었으므로 페이지 이동 */

		String url = "%s/bbs/document_read.do?id=%d";
		url = String.format(url, web.getRootPath(), bbs.getId());
		web.redirect(url, null);

		return null;
	}

}
