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
import project.gatcha.model.Member;
import project.gatcha.model.MovieEvaluateCount;
import project.gatcha.service.MovieEvaluateCountService;
import project.gatcha.service.impl.MovieEvaluateCountServiceImpl;



@WebServlet("/mystory/mystory_count.do")
public class MystoryCount extends BaseController{


	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7187065439624798588L;
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	MovieEvaluateCount movieEvaluateCount;
	MovieEvaluateCountService movieEvaluateCountService;
	

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		movieEvaluateCount = new MovieEvaluateCount();
		movieEvaluateCountService = new MovieEvaluateCountServiceImpl(sqlSession, logger); 
		
		// 로그인 중이 아니라면 이 페이지를 동작시켜서는 안된다.
		if (web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}
		
		Member loginInfo = (Member) web.getSession("loginInfo");

		//결과값이 저장될 객체들
		List<MovieEvaluateCount> ev_count = null;
		List<MovieEvaluateCount> ev_count2 = null;

		//멤버 세팅
		int member_id = loginInfo.getId();
		movieEvaluateCount.setMemberId(member_id);
		//변수이름구별을위한 count변수
		int count=1;
		//년 별, 월별  정보를 구해보자
		//y는 2009년부터라는 의미
		for(int y=2009;y<2019;y++){
		//년 별   int값을 string 으로 바꿔줘야 됨
		movieEvaluateCount.setYear(Integer.toString(y));
		//월 별
		movieEvaluateCount.setMonth(Integer.toString(count));
		//멤버가 평가한 영화 총 개수 연 별 ,월별
		try{
			//특정회원이 평가한 영화중 특정 연도에 해당하는 영화개수 
			ev_count = movieEvaluateCountService.selectMovieEvaluateCountList(movieEvaluateCount);
			//특정회원이 평가한 영화 중 특정 월에 해당하는 영화개수
			ev_count2 = movieEvaluateCountService.selectMovieEvaluateCountList2(movieEvaluateCount);
			//아래에서 확인해보자
			System.out.println("특정 년도에 해당하는 평가된 영화"+ev_count.toString());
			System.out.println("특정 월 에 해당하는 평가된영화"+ev_count2.toString());
		}catch(Exception e){
			web.redirect(null, "영화 조회에 실패하였습니다.");
		}
		//해당 년도에 평가한 목록 list 이 길이를 구하면 년도별 평가한 개수가 된다.
		request.setAttribute("ev_y_count"+count, ev_count);
		request.setAttribute("ev_m_count"+count, ev_count2);
		//년도   예를 들어 count0=2009 이런식!
		request.setAttribute("count"+count,y);
		request.setAttribute("Month"+count,count);
		count++;
		}
		
		
		return "favorite/mystory_count";
	}
}