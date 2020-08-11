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
import project.gatcha.helper.UploadHelper;
import project.gatcha.helper.WebHelper;
import project.gatcha.model.Bbs;
import project.gatcha.model.Member;
import project.gatcha.service.BbsService;
import project.gatcha.service.impl.BbsServiceImpl;



@WebServlet("/bbs/document_delete.do")
public class DocumentDelete extends BaseController {

	private static final long serialVersionUID = 4907875225108888666L;
	/** (1) 사용하고자 하는 Helper 객체 선언 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;
	// --> import org.apache.ibatis.session.SqlSession;
	SqlSession sqlSession;
	// --> import study.jsp.helper.WebHelper;
	WebHelper web;
	// --> import study.jsp.mysite.service.BbsService;
	BbsService bbsService;
	// --> import study.jsp.helper.UploadHelper;
	UploadHelper upload;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		// --> import org.apache.logging.log4j.LogManager;
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		// --> import study.jsp.mysite.service.impl.MemberServiceImpl;
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);

		// --> import study.jsp.mysite.service.impl.BbsServiceImpl;
		bbsService = new BbsServiceImpl(sqlSession, logger);
		
		/**  로그인 여부 검사 */
		// 로그인 중이 아니라면 이 페이지를 동작시켜서는 안된다.
		if (web.getSession("loginInfo") == null) {
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}
		
		/** (3) 게시글 번호 받기 */
		int id = web.getInt("id");
		if (id == 0) {
			sqlSession.close();
			web.redirect(null, "글 번호가 없습니다.");
			return null;
		}
		
		// 파라미터를 Beans로 묶기
		Bbs bbs = new Bbs();
		bbs.setId(id);
		
		
		// 로그인 한 경우 현재 회원의 일련번호를 추가한다. (비로그인 시 로그인화면으로 이동됨)
		Member loginInfo = (Member) web.getSession("loginInfo");
		if (loginInfo != null) {
			bbs.setMemberId(loginInfo.getId());
		}
		
		/** (4) 게시물 일련번호를 사용한 데이터 조회 */	
		// 회원번호가 일치하는 게시물 수 조회하기
		int documentCount = 0; 
		try {
			documentCount = bbsService.selectBbsCountByMemberId(bbs);
			if((documentCount <= 0) && (loginInfo.getLevel() != 1)){
				throw new NullPointerException("회원님의 게시글이 아니어서 삭제하실 수 없습니다.");
			}
		}	catch (NullPointerException e){
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}	catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} 
		
		/** (5) 데이터 삭제 처리 */
		try {		
			bbsService.deleteBbs(bbs);	// 게시글 삭제
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		

		
		/** (6) 페이지 이동 */
		String url = "%s/bbs/document_list.do";
		url = String.format(url, web.getRootPath());
		
		web.redirect(url, "삭제되었습니다.");
		return null;

	}
}
