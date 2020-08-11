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
import project.gatcha.service.EvaluateService;
import project.gatcha.service.impl.EvaluateServiceImpl;
import project.gatcha.model.Evaluate;
import project.gatcha.model.Member;

/**
 * Servlet implementation class EvaluateOk
 */
//좋아요 기능 
@WebServlet("/evaluate/evaluate_likes.do")
public class EvaluateLikes extends BaseController {

	private static final long serialVersionUID = -2623989167362163645L;
/** 버튼 이벤트를 처리하기 위해 만들었던 서블릿으로서, 이벤트 실행시 항목이 있는지 selectEvaluateCount로 찾아내어 1이면 updateEvaluateChoice로 들어가게 하였습니다. 0인경우에는 
   * insertEvaluateMayNoOne가 실행되어 평가를 추가할것입니다.  */

	/** 1)사용하고자 하는 객체들 선언 */
	WebHelper web;
	Logger logger;
	SqlSession sqlSession;
	EvaluateService evaluateService;
	Evaluate evaluate;
	Evaluate evaluateNext;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//포맷 인코딩
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		web = WebHelper.getInstance(request, response);
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		evaluateService = new EvaluateServiceImpl(sqlSession, logger);
		Member loginInfo = (Member) web.getSession("loginInfo");
		
		evaluate =new Evaluate();
		evaluateNext = new Evaluate();
		
		
		String movieKfaId = web.getString("movie_kfa_id");
		int memberId = loginInfo.getId();
		

		
		
		evaluate.setMovieKfaId(movieKfaId);
		evaluate.setMemberId(memberId);
		
		System.out.println(evaluate.toString());
		
		
		
		int result = 0;
		
		try{
			result =evaluateService.selectEvaluateCount(evaluate);
		}catch(Exception e){
			e.getLocalizedMessage();
			System.out.println("카운트오류");
		}
		
		
		String likes = web.getString("likes");
		String dislike = web.getString("dislike");
		String myStarpoint = web.getString("my_starpoint");
		
		evaluateNext.setLikes(likes);
		evaluateNext.setDislike(dislike);
		evaluateNext.setMyStarpoint(myStarpoint);
		evaluateNext.setMovieKfaId(evaluate.getMovieKfaId());
		evaluateNext.setMemberId(evaluate.getMemberId());
		
		
		if(result < 1){
			try{
				evaluateService.insertEvaluateMayNoOne(evaluateNext);
			}catch(Exception e){
				e.getLocalizedMessage();
				System.out.println("인서트 오류");
			}finally{
				sqlSession.close();
			}
		}else{
			try{
				evaluateService.updateEvaluateLikes(evaluateNext);
			}catch(Exception e){
				e.getLocalizedMessage();
				System.out.println("업데이트 오류");
			}finally{
				sqlSession.close();
			}
		}
		
//		try{
//			evaluateService.choiceExcuete(evaluate);
//		}catch(Exception e){
//			System.out.println("아무튼 에러!!");
//			e.getLocalizedMessage();
//		}finally{
//			sqlSession.close();
//		}
		
//		web.redirect("evaluate_main.do?genre_id=0", null);
		
		return null;
	}
       
   

}
