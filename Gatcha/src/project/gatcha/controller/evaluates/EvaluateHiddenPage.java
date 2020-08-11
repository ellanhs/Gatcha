package project.gatcha.controller.evaluates;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
import project.gatcha.model.GenreTemp;
import project.gatcha.model.Member;
import project.gatcha.model.MovieEvaluateFile;
import project.gatcha.model.MovieRadioactiveTea;
import project.gatcha.service.MovieEvaluateFileService;
import project.gatcha.service.impl.MovieEvaluateFileServiceImpl;

/**
 * Servlet implementation class EvaluateHiddenPage
 */
@WebServlet("/evaluate/evaluateHidden.do")
public class EvaluateHiddenPage extends BaseController implements Comparator<String> {


	Map<String, Integer> base;
//    public EvaluateHiddenPage(Map<String, Integer> base) {
//        this.base = base;
//    }
    @Override
    public int compare(String arg0, String arg1) {
		 if (base.get(arg0) >= base.get(arg1)) {
	            return -1;
	        } else {
	            return 1;
	        }
	    }
    
    
	private static final long serialVersionUID = -6440776077476236135L;

	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	
	MovieEvaluateFile genreCountSetter;
	MovieEvaluateFileService movieEvaluateFileService;
	
	
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		genreCountSetter = new MovieEvaluateFile();
		
		movieEvaluateFileService = new MovieEvaluateFileServiceImpl(sqlSession, logger); 
		
//		if (web.getSession("loginInfo") == null) {
//			sqlSession.close();
//			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
//			return null;
//		}
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		Map<String, Integer> mapp = new HashMap<>();
		
		
		int genreCount = 0;
//		int member_id = 9;
		int member_id = loginInfo.getId();
		// member id 받고 반복문 실시..
		System.out.println("--------------member_id--------------"+member_id+"--------------------------------------");
		genreCountSetter.setMemberId(member_id); // 멤버아이디 세팅은 반복문 바깥에서 미리 해주겠다.
		
		
		
		
		//장르값 1부터 16까지 반복 추출
		for(int i=0; i<16;i++){
			
			System.out.println("장르값 "+(i+1)+"에 대한 계산절차 시작");
			genreCountSetter.setGenreId(i+1);
			try{
				genreCount = movieEvaluateFileService.selectEvaluateGenreCount(genreCountSetter);
				
			}catch(Exception e){
				web.redirect(null, "영화 조회에 실패하였습니다.");
				
			}
		
			String keyofmapp =""+(i+1);
			mapp.put(keyofmapp, genreCount); // 배열에 대한 백업플랜
		
		}// end of for
		MovieRadioactiveTea test1 = new MovieRadioactiveTea(); // MovieRadioactiveTea 생성자 처리를 하기위해서 임의로 추가한 모델
        TreeMap<String,Integer> sortedMap = new TreeMap<String,Integer>(new MovieRadioactiveTea(mapp));
	        sortedMap.putAll(mapp);
	        
				int jj = 1;
	        for (String key : sortedMap.keySet()){
					
	        	GenreTemp temp = new GenreTemp();
				temp.setCounter(mapp.get(key));
				temp.setGenreId(key);
				
//				System.out.println("장르 아이디 : "+ temp.getGenreId());
//				System.out.println("장르 카운터  : "+ temp.getCounter());
//				request.setAttribute("ev_list"+jj, temp);
				 System.out.println(temp.getGenreId() + "=" + temp.getCounter());
				request.setAttribute("GenreRank"+jj,temp );
				jj++;
		}
		
		sqlSession.close();
		return "/evaluate/evaluateHidden";
	}
       

}
