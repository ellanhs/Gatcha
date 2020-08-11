package project.gatcha.controller.favorite;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import project.gatcha.dao.MyBatisConnectionFactory;
import project.gatcha.helper.BaseController;
import project.gatcha.helper.WebHelper;
import project.gatcha.model.Diary;
import project.gatcha.model.Evaluate;
import project.gatcha.model.Filmography;
import project.gatcha.model.Genre;
import project.gatcha.model.Member;
import project.gatcha.model.MovieEvaluateCount;
import project.gatcha.model.MovieEvaluateFile;
import project.gatcha.model.People;
import project.gatcha.model.PeopleImage;
import project.gatcha.service.DiaryService;
import project.gatcha.service.EvaluateService;
import project.gatcha.service.FilmographyService;
import project.gatcha.service.GenreService;
import project.gatcha.service.MovieEvaluateCountService;
import project.gatcha.service.MovieEvaluateFileService;
import project.gatcha.service.PeopleImageService;
import project.gatcha.service.PeopleService;
import project.gatcha.service.impl.DiaryServiceImpl;
import project.gatcha.service.impl.EvaluateServiceImpl;
import project.gatcha.service.impl.FilmographyServiceImpl;
import project.gatcha.service.impl.GenreServiceImpl;
import project.gatcha.service.impl.MovieEvaluateCountServiceImpl;
import project.gatcha.service.impl.MovieEvaluateFileServiceImpl;
import project.gatcha.service.impl.PeopleImageServiceImpl;
import project.gatcha.service.impl.PeopleServiceImpl;



@WebServlet("/mystory/mystory_statistics.do")
public class MystoryStatistics extends BaseController{

	private static final long serialVersionUID = -7357620905872874439L;
	
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	DiaryService diaryService;
	MovieEvaluateFile movieList;
	MovieEvaluateFileService movieEvaluateFileService;
	MovieEvaluateCount movieEvaluateCount;
	MovieEvaluateCountService movieEvaluateCountService;
	MovieEvaluateFile genreCountSetter;
	GenreService genreService;
	Genre genre;
	FilmographyService filmoService;
	PeopleImageService peopleimg;
	PeopleService peopleService;
	EvaluateService evaluateService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		movieList = new MovieEvaluateFile();
		diaryService = new DiaryServiceImpl(sqlSession, logger);
		movieEvaluateFileService = new MovieEvaluateFileServiceImpl(sqlSession, logger); 
		movieEvaluateCount = new MovieEvaluateCount();
		movieEvaluateCountService = new MovieEvaluateCountServiceImpl(sqlSession, logger); 
		genreCountSetter = new MovieEvaluateFile();
		genreService = new GenreServiceImpl(sqlSession, logger);
		genre = new Genre();
		filmoService = new FilmographyServiceImpl(sqlSession, logger);
		peopleimg = new PeopleImageServiceImpl(sqlSession, logger);
		peopleService = new PeopleServiceImpl(sqlSession, logger);
		evaluateService = new EvaluateServiceImpl(sqlSession, logger);
		// 로그인 중이 아니라면 이 페이지를 동작시켜서는 안된다.
		if (web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다.");
			return null;
		}
		Evaluate counter = new Evaluate();
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		counter.setMemberId(loginInfo.getId());
		int resultCOunt =0;
		try{
			//특정회원이 평가한 영화중 특정 연도에 해당하는 영화개수 
			resultCOunt = evaluateService.selectEvaluateCountLikes(counter);			
		}	catch(Exception e){
			web.redirect(null, "평가조회에 실패하였습니다.");
		}
		

		if(resultCOunt<10){
			web.redirect(null, "보고싶어요를 10개이상 평가해주세요");
			return null;
		}
		//결과값이 저장될 객체들

		List<MovieEvaluateFile> ev_list_like = null;
		List<MovieEvaluateFile> ev_list_hate = null;
		List<Diary> diarylist = null;

		//결과값이 저장될 객체들
		List<MovieEvaluateCount> ev_count = null;
		List<MovieEvaluateCount> ev_count2 = null;
		
		
		// 불러오기 위한 정보의 기반이 되는 코드를 각각 세팅

		int member_id = loginInfo.getId();
		int genreId = 0;
		movieList.setMemberId(member_id);
		movieList.setGenreId(genreId);
		movieEvaluateCount.setMemberId(member_id);
		Diary list = new Diary();
		list.setMember_id(member_id);
		//변수이름구별을위한 count변수
	
		//년 별, 월별  정보를 구해보자
		JSONArray jarray1= new JSONArray();
		//y는 2009년부터라는 의미
		int initialYear=2009;
		for(int y=initialYear;y<(initialYear+10);y++){
		//년 별   int값을 string 으로 바꿔줘야 됨
		movieEvaluateCount.setYear(Integer.toString(y));

		//멤버가 평가한 영화 총 개수 연 별 ,월별
		try{
			//특정회원이 평가한 영화중 특정 연도에 해당하는 영화개수 
			ev_count = movieEvaluateCountService.selectMovieEvaluateCountList(movieEvaluateCount);			
		}	catch(Exception e){
			web.redirect(null, "영화 조회에 실패하였습니다.");
		}
			JSONObject jobject1= new JSONObject();
			jobject1.put("letter", y);
			jobject1.put("frequency", ev_count.size());
			jarray1.put(jobject1);
		}
		request.setAttribute("data", jarray1);
		
		String[] month={"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
		JSONArray jarray2= new JSONArray();
		//년 별, 월별  정보를 구해보자
		//m=1,12
		for(int m=1;m<13;m++){
		//년 별   int값을 string 으로 바꿔줘야 됨
		//월 별
		if(m>=10){	
		    movieEvaluateCount.setMonth(Integer.toString(m));
		}else{
			movieEvaluateCount.setMonth("0"+m);	
		}
		//멤버가 평가한 영화 총 개수 연 별 ,월별
		try{
			//특정회원이 평가한 영화 중 특정 월에 해당하는 영화개수
			ev_count2 = movieEvaluateCountService.selectMovieEvaluateCountList2(movieEvaluateCount);			
		}	catch(Exception e){
			web.redirect(null, "영화 조회에 실패하였습니다.");
		}
		//해당 년도에 평가한 목록 list 이 길이를 구하면 년도별 평가한 개수가 된다.
		JSONObject jobject2= new JSONObject();
		jobject2.put("month", month[m-1]);
		jobject2.put("numofmoviemonth", ev_count2.size());
		jarray2.put(jobject2);

		}
		request.setAttribute("data2", jarray2);
		
		
		try{
			ev_list_like = movieEvaluateFileService.selectMovieListByLike(movieList);
			ev_list_hate = movieEvaluateFileService.selectMovieListByDislike(movieList);
			diarylist = diaryService.selectDiarylist(list);
		}catch(Exception e){
			web.redirect(null, "영화 조회에 실패하였습니다.");
		}
		
		request.setAttribute("ev_list_like", ev_list_like);
		request.setAttribute("ev_list_hate", ev_list_hate);
		request.setAttribute("diaryList", diarylist);
		

		///////
		int genreCount = 0;
		int genreCountSumEtc=0;
		String genreEtc="기타";
		genreCountSetter.setMemberId(member_id); // 멤버아이디 세팅은 반복문 바깥에서 미리 해주겠다.
		Genre resultGenre =new Genre();
		JSONArray jarray3= new JSONArray();
		for(int i=0; i<17;i++){

			genreCountSetter.setGenreId(i+1);
			genre.setId(i+1);
			try{
				genreCount = movieEvaluateFileService.selectEvaluateGenreCount(genreCountSetter);
				resultGenre = genreService.selectGenre(genre);
				
			}catch(Exception e){
				web.redirect(null, "영화 조회에 실패하였습니다.");
				
			}
			if(i<=7){
			JSONObject jobject3= new JSONObject();
			jobject3.put("genre", resultGenre.getGenreName());
			jobject3.put("population", genreCount);
			jarray3.put(jobject3);
			}else{
				genreCountSumEtc+=genreCount;
			}
		}// end of for
		
		JSONObject jobject3= new JSONObject();
		jobject3.put("genre", genreEtc);
		jobject3.put("population", genreCountSumEtc);
//		jarray3.put(jobject3);
		
		request.setAttribute("data3", jarray3);
		
		/*************************************/
		Filmography filmo = new Filmography();
		filmo.setMemberId(member_id); // 회원 번호

		/** 데이터 처리에 필요한 값 세팅하기 */
		// 조회 결과가 저장될 Beans 객체
		List<Filmography> Statlist = null;
		List<Filmography> StatlistAct = null;
		
		try {
			Statlist = filmoService.selectStatEvaluate(filmo);
			StatlistAct = filmoService.selectStatFilmoActor(filmo);
		} catch (Exception e) {
			web.redirect(null, "배우, 감독 조회에 실패하였습니다.");
		}
		
		//감독
		TreeMap<String, Integer> stat = new TreeMap<String, Integer>();
		for (int i = 0; i < Statlist.size(); i++) {

			String StatlistDir = Statlist.get(i).getDirectorKfaId();

				String key = StatlistDir;
				Integer count = (Integer) stat.get(StatlistDir);

				if (stat.containsKey(key)) {
					stat.put(key, new Integer(count.intValue() + 1));
				} else {
					stat.put(key, new Integer(1));
				}

		}
		
		/** TreeMap을 Value값으로 정렬하기 **/
		List<Map.Entry<String, Integer>> listDir = new ArrayList<Map.Entry<String, Integer>>(stat.entrySet());

		Collections.sort(listDir, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
				if (e1.getValue() == e2.getValue()) {
					return e1.getKey().compareTo(e2.getKey());
				} else {
					return e2.getValue().compareTo(e1.getValue());
				}
			}
		});
		
		/** 정렬된 내용 중 3개만 뽑아오기 **/
		String result1Dir = listDir.get(1).toString();
		String result2Dir = listDir.get(2).toString();
		String result3Dir = listDir.get(3).toString();
		
		//key, value로 [1차][2차] 배열에 값을 저장
		String[][] resultDir = new String[3][2];
		
		resultDir[0] = result1Dir.split("=");
		resultDir[1] = result2Dir.split("=");
		resultDir[2] = result3Dir.split("=");
		
		
		
		
		
		//배우
		TreeMap<String, Integer> statAct = new TreeMap<String, Integer>();
		for (int i = 0; i < StatlistAct.size(); i++) {

			String StatlistAct2 = StatlistAct.get(i).getKfaActorIdSum();

			String[] tmp = StatlistAct2.split("\\+");

			// split("\\+") 출력 내용 확인하기
			

			for (int k = 0; k < tmp.length; k++) {
				String key = tmp[k];
				Integer count = (Integer) statAct.get(tmp[k]);

				if (statAct.containsKey(key)) {
					statAct.put(key, new Integer(count.intValue() + 1));
				} else {
					statAct.put(key, new Integer(1));
				}

			}

		}
		
		/** TreeMap을 Value값으로 정렬하기 **/
		List<Map.Entry<String, Integer>> listActor = new ArrayList<Map.Entry<String, Integer>>(statAct.entrySet());

		Collections.sort(listActor, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
				if (e1.getValue() == e2.getValue()) {
					return e1.getKey().compareTo(e2.getKey());
				} else {
					return e2.getValue().compareTo(e1.getValue());
				}
			}
		});
		
		/** 정렬된 내용 중 3개만 뽑아오기 **/
		String result1 = listActor.get(1).toString();
		String result2 = listActor.get(2).toString();
		String result3 = listActor.get(3).toString();
		
		//key, value로 [1차][2차] 배열에 값을 저장
		String[][] result = new String[3][2];
		
		result[0] = result1.split("=");
		result[1] = result2.split("=");
		result[2] = result3.split("=");
	
		String[] dirName = new String[3];
		String[] actName = new String[3];
		String[] dirUrl = new String[3];
		String[] actUrl = new String[3];
		PeopleImage inputAct = new PeopleImage();
		PeopleImage outputAct = new PeopleImage();
		PeopleImage inputDir = new PeopleImage();
		PeopleImage outputDir = new PeopleImage();
		People inputActName= new People();
		People inputDirName= new People();
		People outputActName= new People();
		People outputDirName= new People();
		

		
	    for(int k=0;k<3;k++){
	    	inputAct.setPeopleKfaId(result[k][0]);
	    	inputDir.setPeopleKfaId(resultDir[k][0]);
	    	inputActName.setKfaId(result[k][0]);
	    	inputDirName.setKfaId(resultDir[k][0]);
			try {
				outputAct = peopleimg.selectPeopleImageAct(inputAct);
				outputDir = peopleimg.selectPeopleImageAct(inputDir);
				outputActName = peopleService.selectPeople(inputActName);
				outputDirName = peopleService.selectPeople(inputDirName);
			} catch (Exception e) {
				web.redirect(null, "배우, 감독 사진 이름 조회에 실패하였습니다.");
			}
			actUrl[k]=outputAct.getProfileUrl();
			dirUrl[k]=outputDir.getProfileUrl();
			actName[k]=outputActName.getName();
			dirName[k]=outputDirName.getName();
	    }
	    
	    
		request.setAttribute("dirName1", dirName[0]);
		request.setAttribute("actName1", actName[0]);
		request.setAttribute("dirUrl1", dirUrl[0]);
		request.setAttribute("actUrl1", actUrl[0]);
		request.setAttribute("dirName2", dirName[1]);
		request.setAttribute("actName2", actName[1]);
		request.setAttribute("dirUrl2", dirUrl[1]);
		request.setAttribute("actUrl2", actUrl[1]);
		request.setAttribute("dirName3", dirName[2]);
		request.setAttribute("actName3", actName[2]);
		request.setAttribute("dirUrl3", dirUrl[2]);
		request.setAttribute("actUrl3", actUrl[2]);
		
		sqlSession.close();
		
		return "favorite/mystory_statistics";
		
	}
	
	
	
	
	
	
	
	
	

}