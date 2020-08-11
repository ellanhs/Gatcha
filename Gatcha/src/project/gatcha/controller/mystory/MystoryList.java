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

/*import com.fasterxml.jackson.databind.ObjectMapper;*/

import project.gatcha.dao.MyBatisConnectionFactory;
import project.gatcha.helper.BaseController;

import project.gatcha.helper.WebHelper;
import project.gatcha.model.Diary;
import project.gatcha.model.Member;
import project.gatcha.model.MovieEvaluateFile;
import project.gatcha.service.DiaryService;
import project.gatcha.service.MovieEvaluateFileService;
import project.gatcha.service.impl.DiaryServiceImpl;
import project.gatcha.service.impl.MovieEvaluateFileServiceImpl;

@WebServlet("/mystory/mystory_diarylist.do")
public class MystoryList extends BaseController {

	private static final long serialVersionUID = 7751123967676095416L;
	
	/** 사용하고자 하는 helper 객체 선언 **/
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	DiaryService diaryService;
	MovieEvaluateFileService movieEvaluateFileService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		diaryService = new DiaryServiceImpl(sqlSession, logger);
		movieEvaluateFileService = new MovieEvaluateFileServiceImpl(sqlSession, logger); 
		
		
		if (web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}		

		Member loginInfo = (Member) web.getSession("loginInfo");
		
		/** 파라미터 받기 **/
		int member_id = loginInfo.getId();
	/*	String movie_kfd_id = web.getString("movie_kfd_id");*/
		
		logger.debug("member_id="+ member_id);
	/*	logger.debug("movie_kfd_id="+ movie_kfd_id);*/
		
		System.out.println("==member_id=="+member_id);
	/*	System.out.println("==movie_kfd_id=="+movie_kfd_id);*/
		
		/** 입력 받은 파라미터에 대한 유효성 검사 */
		if(member_id == 0){
			sqlSession.close();
			web.redirect(null, "회원 정보가 조회되지 않습니다.");
			return null;
		}
		
		List<Diary> diarylist = null;
		List<MovieEvaluateFile> ev_list_like = null;
		List<MovieEvaluateFile> ev_list_hate = null;
		
		/** 입력 받은 파라미터를 Beans로 묶기 **/
	
		Diary list = new Diary();
		list.setMember_id(member_id);
		/*list.setMovie_kfd_id(movie_kfd_id);*/
		MovieEvaluateFile movieList = new MovieEvaluateFile();
		
		int genreId = 0;
		movieList.setMemberId(member_id);
		movieList.setGenreId(genreId);

		

		
		
		try{
			diarylist = diaryService.selectDiarylist(list);
			ev_list_like = movieEvaluateFileService.selectMovieListByLike(movieList);
			ev_list_hate = movieEvaluateFileService.selectMovieListByDislike(movieList);
		}catch(Exception e){
			web.redirect(null, "다이어리 조회에 실패하였습니다.");
		}finally{
			sqlSession.close();
		}
		
		/** 처리 결과를 view로 출력하기 **/
		request.setAttribute("diaryList", diarylist);
		request.setAttribute("ev_list_like", ev_list_like);
		request.setAttribute("ev_list_hate", ev_list_hate);
		
		return "mystory/diary_list";
	}


}