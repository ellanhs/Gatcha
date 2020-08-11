package project.gatcha.controller;

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
import project.gatcha.model.Boxoffice;
import project.gatcha.service.BoxofficeService;
import project.gatcha.service.impl.BoxofficeServiceImpl;

/**
 * Servlet implementation class EvaluateBoxoffice
 */
@WebServlet("/main.do")
public class Main extends BaseController {

	
	private static final long serialVersionUID = -6779819855494358456L;

	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	
	Boxoffice movieList;
	BoxofficeService boxofficeService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		movieList = new Boxoffice();
		
		boxofficeService = new BoxofficeServiceImpl(sqlSession, logger); 
		
		if (web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		
		
		List<Boxoffice> list = null;
		int member_id = loginInfo.getId();
		movieList.setMemberId(member_id);
		try{
			list = boxofficeService.boxofficeList(movieList);
			if(list ==null){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			e.getLocalizedMessage();
		}catch(Exception e){
			web.redirect(null, "영화 조회에 실패하였습니다.");
		}
		request.setAttribute("list", list);
		
		List<Boxoffice> clist = null;
		try{
			clist = boxofficeService.boxofficeCarousel();
			if(clist ==null){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			e.getLocalizedMessage();
		}catch(Exception e){
			web.redirect(null, "영화 조회에 실패하였습니다.");
		}
		request.setAttribute("clist", clist);
		
		
		int genreId ;
		int i;
		for(i=1;i<9;i++){
			genreId=i;
			movieList.setGenreId(genreId);
			System.out.println("----------------------------//////"+movieList.getGenreId()+"/////----------------------------------");
			
			Boxoffice glist = null;
			try{
				glist = boxofficeService. selectMovieList(movieList);
				if(glist ==null){
				}
			}catch(NullPointerException e){
				e.getLocalizedMessage();
			}catch(Exception e){
				web.redirect(null, "영화 조회에 실패하였습니다.");
			}
			request.setAttribute("glist"+i, glist);
		}
		
		
		
		
		
		
		return "/main";
	}
       
    

}
