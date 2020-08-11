package project.gatcha.controller.evaluates;

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
import project.gatcha.model.Evaluate;
import project.gatcha.model.Member;
import project.gatcha.model.Movie;
import project.gatcha.service.EvaluateService;
import project.gatcha.service.MovieService;
import project.gatcha.service.impl.EvaluateServiceImpl;
import project.gatcha.service.impl.MovieServiceImpl;


@WebServlet("/evaluate/evaluate_diary.do")
public class EvaluateDiary extends BaseController {


	private static final long serialVersionUID = 4139137394041643847L;
	WebHelper web;
	SqlSession sqlSession;
	Logger logger;
	EvaluateService evaluateService;
	MovieService movieService;


	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		web = WebHelper.getInstance(request, response);
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		evaluateService= new EvaluateServiceImpl(sqlSession, logger);
		movieService = new MovieServiceImpl(sqlSession, logger);

		
		
		// 로그인 중이 아니라면 이 페이지를 동작시켜서는 안된다.
		if (web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}
		
		// 로그인 한 경우, 회원 아이디를 세션정보로 대체
		Member loginInfo = (Member) web.getSession("loginInfo");
		int memberId = loginInfo.getId();
		
		
		String kfaId = web.getString("kfa_id");
		if(kfaId == null){
			sqlSession.close();
			web.redirect(null, "영화코드가 전송되지 않았습니다.");
			return null;
		}
		
		//파라미터를 Beans로 묶기 
		Movie movie = new Movie();
		Evaluate eval = new Evaluate();
		
		
		// 불러오기 위한 정보의 기반이 되는 코드를 각각 세팅
		movie.setKfaId(kfaId);
		eval.setMovieKfaId(kfaId);
		eval.setMemberId(memberId);
		
		//결과값이 저장될 객체들

		Movie movieInfo = null;
		Evaluate evalInfo = null;
		
		try{
			movieInfo = movieService.selectMovieInfo(movie);
			evalInfo = evaluateService.selectEvaluateOneByMemberKFAId(eval);
		}catch(Exception e){
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}finally{
			sqlSession.close();
		}

		


		//받아낸값들을 호출한 View로 보낸다.

		//movieInfo (title: 영화 제목, context: 줄거리 , age: 연령가, country:국가 , year: 연도, runtime: 상영시간)
		request.setAttribute("movieInfo", movieInfo);
		//evalInfo Null 허용 (id, myStarpoint:내별점, view:봤어요, likes:좋아요, dislike:싫어요, diary: 다이어리, regDate, editDate, memberId: 회원 ID, movieKfaId: KFA ID )
		request.setAttribute("evalInfo", evalInfo);
		
		return "/evaluate/evaluate_diary";
	}
	

}
