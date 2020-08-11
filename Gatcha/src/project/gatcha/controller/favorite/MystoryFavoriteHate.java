package project.gatcha.controller.favorite;



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
import project.gatcha.helper.WebHelper;
import project.gatcha.model.Diary;
import project.gatcha.model.Member;

import project.gatcha.model.MovieEvaluateFile;
import project.gatcha.service.DiaryService;
import project.gatcha.service.MovieEvaluateFileService;
import project.gatcha.service.impl.DiaryServiceImpl;
import project.gatcha.service.impl.MovieEvaluateFileServiceImpl;



@WebServlet("/mystory/mystory_favorite_hate.do")
public class MystoryFavoriteHate extends BaseController{


	private static final long serialVersionUID = -8069627990412576157L;
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	DiaryService diaryService;
	MovieEvaluateFile movieList;
	MovieEvaluateFileService movieEvaluateFileService;
	
	
	
	
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		movieList = new MovieEvaluateFile();
		diaryService = new DiaryServiceImpl(sqlSession, logger);
		movieEvaluateFileService = new MovieEvaluateFileServiceImpl(sqlSession, logger); 
		
		
		// 로그인 중이 아니라면 이 페이지를 동작시켜서는 안된다.
		if (web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}
		
		Member loginInfo = (Member) web.getSession("loginInfo");

		
		//결과값이 저장될 객체들

		List<MovieEvaluateFile> ev_list_hate = null;
		List<MovieEvaluateFile> ev_list_like = null;
		List<Diary> diarylist = null;
		
		// 불러오기 위한 정보의 기반이 되는 코드를 각각 세팅

		int member_id = loginInfo.getId();
		int genreId = 0;
		movieList.setMemberId(member_id);
		movieList.setGenreId(genreId);
		
		Diary list = new Diary();
		list.setMember_id(member_id);
		
		try{
			ev_list_hate = movieEvaluateFileService.selectMovieListByDislike(movieList);
			ev_list_like = movieEvaluateFileService.selectMovieListByLike(movieList);
			diarylist = diaryService.selectDiarylist(list);
		}catch(Exception e){
			web.redirect(null, "영화 조회에 실패하였습니다.");
			
		}finally{
			sqlSession.close();
		}
		
		request.setAttribute("ev_list_hate", ev_list_hate);
		request.setAttribute("ev_list_like", ev_list_like);
		request.setAttribute("diaryList", diarylist);
				
		
		return "favorite/mystory_hate";
		
	}
	
	
	
	
	
	
	
	
	

}