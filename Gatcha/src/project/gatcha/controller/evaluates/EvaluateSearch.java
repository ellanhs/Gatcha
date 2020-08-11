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
 * Servlet implementation class EvaluateSearch
 */
@WebServlet("/evaluate/evaluate_search.do")
public class EvaluateSearch extends BaseController {
	

	private static final long serialVersionUID = 9126881325324188999L;
	
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
		String keyword = web.getString("searchKeyword");
		String keywordNo = "";
		int keywordCategory = (int)web.getInt("keywordcategory");
		System.out.println("-------------------------"+ keyword +"-----------------------------------");
		System.out.println("-----------------------" + keywordCategory + "--------------------------");
		
		
	if(keyword ==null || keyword==" "){
			keyword = "";
			keywordNo = "[]][][][[][[[[[]]]]]]";
		
			System.out.println("--------------member_id--------------"+member_id+"--------------------------------------");
			System.out.println("--------------검색어--------------"+keyword+"--------------------------------------");
			movieList.setMemberId(member_id);
			movieList.setTitle(keywordNo);
			try{
				ev_list = movieEvaluateFileService.selectMovieListByKeyword(movieList);
				//없을수도 있으므로 NullPointerException
			}catch(Exception e){
				web.redirect(null, "영화 조회에 실패하였습니다.");
			}
			
			
			
	}else if (keywordCategory ==0){
	
		System.out.println("--------------member_id--------------"+member_id+"--------------------------------------");
		System.out.println("--------------검색어--------------"+keyword+"--------------------------------------");
		
		movieList.setTitle(keyword);
		movieList.setMemberId(member_id);
		try{
			ev_list = movieEvaluateFileService.selectMovieListByKeyword(movieList);
			//없을수도 있으므로 NullPointerException
		}catch(Exception e){
			web.redirect(null, "영화 조회에 실패하였습니다.");
		}
		
	}else if(keywordCategory ==1) {
		
			System.out.println("--------------member_id--------------"+member_id+"--------------------------------------");
			System.out.println("--------------검색어--------------"+keyword+"--------------------------------------");
			
			movieList.setMemberId(member_id);
			movieList.setKeyword(keyword);
			try{
				ev_list = movieEvaluateFileService.selectMovieListByDirectorKeyWord(movieList);
				//없을수도 있으므로 NullPointerException
			}catch(Exception e){
				web.redirect(null, "영화 조회에 실패하였습니다.");
			}
		
		
	}else if(keywordCategory ==2){
			
			System.out.println("--------------member_id--------------"+member_id+"--------------------------------------");
			System.out.println("--------------검색어--------------"+keyword+"--------------------------------------");
			
			movieList.setMemberId(member_id);
			
			movieList.setKeyword(keyword);
			try{
				ev_list = movieEvaluateFileService.selectMovieListByActorKeyWord(movieList);
				//없을수도 있으므로 NullPointerException
			}catch(Exception e){
				web.redirect(null, "영화 조회에 실패하였습니다.");
			}	
			
			
		}
		String keywordCate =""+keywordCategory;
		
		request.setAttribute("keywordCate", keywordCate);
		request.setAttribute("ev_list", ev_list);
		request.setAttribute("searchKeyword", keyword);
		
		return "evaluate/evaluate_search";
	}
  

}









