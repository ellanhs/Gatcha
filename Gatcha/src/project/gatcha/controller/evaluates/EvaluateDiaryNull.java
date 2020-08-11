package project.gatcha.controller.evaluates;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import project.gatcha.dao.MyBatisConnectionFactory;
import project.gatcha.helper.BaseController;
import project.gatcha.helper.RegexHelper;
import project.gatcha.helper.WebHelper;
import project.gatcha.model.Evaluate;
import project.gatcha.model.Member;

import project.gatcha.service.EvaluateService;

import project.gatcha.service.impl.EvaluateServiceImpl;



@WebServlet("/evaluate/evaluate_diary_null.do")
public class EvaluateDiaryNull extends BaseController {

	private static final long serialVersionUID = -4908704813267206297L;
	
	WebHelper web;
	SqlSession sqlSession;
	Logger logger;
	EvaluateService evaluateService;

	RegexHelper regex;

	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		web = WebHelper.getInstance(request, response);
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		regex = RegexHelper.getInstance();
		evaluateService= new EvaluateServiceImpl(sqlSession, logger);



		// 로그인 한 경우, 회원 아이디를 세션정보로 대체
		Member loginInfo = (Member) web.getSession("loginInfo");
		int memberId = loginInfo.getId();

		
		String kfaId = web.getString("KfaId");
		if(kfaId == null){
			sqlSession.close();
			web.printJsonRt("영화코드가 전송되지 않았습니다.");
			return null;
		}

		//파라미터를 Beans로 묶기 

		Evaluate eval = new Evaluate();
		
		
		// 불러오기 위한 정보의 기반이 되는 코드를 각각 세팅

		eval.setMovieKfaId(kfaId);
		eval.setMemberId(memberId);

		
		Evaluate evalresult = new Evaluate();
		
		try{
			
				evaluateService.updateEvaluateDiaryNull(eval);
			evalresult = evaluateService.selectEvaluateOneByMemberKFAId(eval);
		}catch(Exception e){
			web.printJsonRt(e.getLocalizedMessage());
			System.out.println("다이어리 등록 오류");
			return null;
		}finally{
			sqlSession.close();
		}

		// --> import java.util.HashMap;
		// --> import java.util.Map;
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rt", "OK");
		data.put("evaldelete", evalresult);
		
		// --> import com.fasterxml.jackson.databind.ObjectMapper;
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getWriter(), data);
	
		
		return null;
	}
	

}
