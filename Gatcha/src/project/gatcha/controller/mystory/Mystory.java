package project.gatcha.controller.mystory;



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
import project.gatcha.helper.RegexHelper;
import project.gatcha.helper.WebHelper;
import project.gatcha.model.Diary;
import project.gatcha.model.Member;
import project.gatcha.service.DiaryService;
import project.gatcha.service.impl.DiaryServiceImpl;

@WebServlet("/mystory/mystory_main.do")
public class Mystory extends BaseController{

	private static final long serialVersionUID = 4031543977080565605L;
	
	/** 사용하고자 하는 helper 객체 선언 **/
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	DiaryService diaryService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		diaryService = new DiaryServiceImpl(sqlSession, logger);
		
		if (web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}		

		Member loginInfo = (Member) web.getSession("loginInfo");
		
		
		/** 파라미터 받기 **/
		int member_id = loginInfo.getId();
		int id = web.getInt("id");
				
		/** 로그 검사 **/
		logger.debug("member_id="+ member_id);
		logger.debug("id="+ id);
		
		/** 전달받은 WebHelper 파라미터 확인 **/
		System.out.println("==member_id=="+ member_id);
		System.out.println("==id=="+ id);
		
		/** 입력 받은 파라미터에 대한 유효성 검사 */
		if(member_id == 0){
			sqlSession.close();
			web.redirect(null, "회원 정보가 조회되지 않습니다.");
			return null;
		}

		if(id == 0){
			sqlSession.close();
			web.redirect(null, "회원 정보가 조회되지 않습니다.");
			return null;
		}
		
		//파라미터를 Beans로 묶기 
		Diary diarylist = new Diary();
		
		// 불러오기 위한 정보의 기반이 되는 코드를 각각 세팅
		diarylist.setMember_id(member_id);
		diarylist.setId(id);
		
		List<Diary> diaryInfo =null;
		
		try{
			diaryInfo = diaryService.selectDiarylist(diarylist);
		}catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
		}finally {
			sqlSession.close();
		}
		
		//받아낸값들을 호출한 View로 보낸다.
		request.setAttribute("diaryInfo", diaryInfo);

		
		return "mystory/diary_read";
		
	}

}