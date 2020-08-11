package project.gatcha.controller.bbs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import project.gatcha.dao.MyBatisConnectionFactory;
import project.gatcha.helper.BaseController;
import project.gatcha.helper.PageHelper;
import project.gatcha.helper.UploadHelper;
import project.gatcha.helper.WebHelper;
import project.gatcha.model.Bbs;
import project.gatcha.service.BbsService;
import project.gatcha.service.impl.BbsServiceImpl;


/**
 * Servlet implementation class DocumentList
 */
@WebServlet("/bbs/document_list.do")
public class DocumentList extends BaseController {

	private static final long serialVersionUID = -1544774233253283989L;
	
	/** (1) 사용하고자 하는 Helper 객체 선언 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;
	// --> import org.apache.ibatis.session.SqlSession;
	SqlSession sqlSession;
	// --> import project.gatcha.helper.WebHelper;
	WebHelper web;
	// --> import project.gatcha.service.BbsService;
	BbsService bbsService;
	// --> import project.gatcha.helper.PageHelper;
	PageHelper pageHelper;
	// --> import project.gatcha.helper.UploadHelper;
	UploadHelper upload;


	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		// --> import org.apache.logging.log4j.LogManager;
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		// --> import project.gatcha.dao.MyBatisConnectionFactory;
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		// --> import project.gatcha.service.impl.BbsServiceImpl;
		bbsService = new BbsServiceImpl(sqlSession, logger);
		pageHelper = PageHelper.getInstance();
		upload = UploadHelper.getInstance();
		
		/**  로그인 여부 검사 */
		// 로그인 중이 아니라면 이 페이지를 동작시켜서는 안된다.
		if (web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}
		
		/** (3) 조회할 정보에 대한 Beans 생성 */
		//검색조건
		int category =web.getInt("category");
		// 검색어
		String keyword = web.getString("keyword");
		
		Bbs bbs = new Bbs();

		// 현재 페이지 수 --> 기본값은 1페이지로 설정함
		int page = web.getInt("page",1);
		

		// 제목과 내용과 닉네임에 대한 검색으로 활용하기 위해서 입력값을 설정한다.
		//category 값을 받아서 keyword로 보낼 조건 분기 category 1 사용자명(닉네임) 검색 else 제목 또는 게시글 검색
		if(category == 1){
			bbs.setNickname(keyword);
		} else {
			bbs.setSubject(keyword);
			bbs.setContent(keyword);
		}


		/** (4) 게시글 목록 조회 */
		int totalCount = 0;
		List<Bbs> bbsList = null;
		

		try {
			// 전체 게시물 수
			totalCount = bbsService.selectBbsJoinCount(bbs);
			
			// 나머지 페이지 번호 계산하기
			// --> 현재 페이지, 전체 게시물 수, 한 페이지의 목록 수, 그룹갯수
			pageHelper.pageProcess(page, totalCount, 9, 5);

			// 페이지 번호 계산 결과에서 Limit절에 필요한 값을 Beans에 추가
			bbs.setLimitStart(pageHelper.getLimitStart());
			bbs.setListCount(pageHelper.getListCount());
			
			bbsList = bbsService.selectBbsJoinList(bbs);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		/** (5) 조회 결과를 View에 전달 */
		request.setAttribute("bbsList", bbsList);
		// 사용자가 입력한 검색조건을 View에 되돌려준다. --> 자동완성 구현을 위함
		request.setAttribute("category", category);
		// 사용자가 입력한 검색어를 View에 되돌려준다. --> 자동완성 구현을 위함
		request.setAttribute("keyword", keyword);
		// 페이지 번호 계산 결과를 View에 전달
		request.setAttribute("pageHelper", pageHelper);
		
		return "bbs/list";
	}

}
