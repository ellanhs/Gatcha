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
import project.gatcha.service.BbsService;
import project.gatcha.service.impl.BbsServiceImpl;




@WebServlet("/bbs/document_read.do")
public class DocumentRead extends BaseController {


	private static final long serialVersionUID = 4311322361338641335L;
	
	/** (1) 사용하고자 하는 Helper 객체 선언 */
	//import org.apache.logging.log4j.Logger;
	Logger logger;
	//import org.apache.ibatis.session.SqlSession;
	SqlSession sqlSession;
	// --> import study.jsp.helper.WebHelper;
	WebHelper web;
	// --> import study.jsp.helper.RegexHelper;
	RegexHelper regex;
	//import study.jsp.mysite.service.BbsService;
	BbsService bbsService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		//import org.apache.logging.log4j.LogManager;
		logger =LogManager.getFormatterLogger(request.getRequestURI());
		//import study.jsp.mysite.dao.MyBatisConnectionFactory;
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		regex = RegexHelper.getInstance();
		//import study.jsp.mysite.service.impl.BbsServiceImpl;
		bbsService=new BbsServiceImpl(sqlSession, logger);


		/**  로그인 여부 검사 */
		// 로그인 중이 아니라면 이 페이지를 동작시켜서는 안된다.
		if (web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}
		
		/**(3)글번호 파라미터 받기*/
		int id =web.getInt("id");
		logger.debug("id="+id);
		
		if(id == 0) {
			web.redirect(null, "글 번호가 지정되지 않았습니다.");
			sqlSession.close();
			return null;
		}
		//파라미터를 Beans로 묶기
		Bbs bbs=new Bbs();
		bbs.setId(id);

		
		/**(4) 게시물 일련번호를 사용한 데이터 조회*/
		// 지금 읽고 있는 게시물이 저장될 객체
		Bbs document = null;

		try {
			document = bbsService.selectJoinBbs(bbs);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		//코멘트 빈칸(공백) 데이터 처리
		if (!regex.isValue(document.getComment())) {
			document.setComment(null); 
		}
		
		/**(5) 읽은 데이터를 View에게 전달한다.*/
		request.setAttribute("document", document);

		
		return "bbs/read";
	}

}
