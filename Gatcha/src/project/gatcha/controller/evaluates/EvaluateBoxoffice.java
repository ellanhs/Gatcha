package project.gatcha.controller.evaluates;

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
import project.gatcha.model.MovieEvaluateFile;
import project.gatcha.service.MovieEvaluateFileService;
import project.gatcha.service.impl.MovieEvaluateFileServiceImpl;

/**
 * Servlet implementation class EvaluateBoxoffice
 */
@WebServlet("/evaluate/evaluate_boxoffice.do")
public class EvaluateBoxoffice extends BaseController {

	
	private static final long serialVersionUID = -6779819855494358456L;

	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	
	MovieEvaluateFile movieList;
	MovieEvaluateFileService movieEvaluateFileService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		movieList = new MovieEvaluateFile();
		
		movieEvaluateFileService = new MovieEvaluateFileServiceImpl(sqlSession, logger); 
		
		if (web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		
		
		List<MovieEvaluateFile> ev_list = null;
		int member_id = loginInfo.getId();
		System.out.println("--------------member_id--------------"+member_id+"--------------------------------------");
		movieList.setMemberId(member_id);
		try{
			ev_list = movieEvaluateFileService.boxofficeList(movieList);
			if(ev_list ==null){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			e.getLocalizedMessage();
		}catch(Exception e){
			web.redirect(null, "영화 조회에 실패하였습니다.");
			
		}finally{
			sqlSession.close();
		}
		
		request.setAttribute("ev_list", ev_list);
		
		
		
		return "evaluate/evaluate_boxoffice";
	}
       
    

}
