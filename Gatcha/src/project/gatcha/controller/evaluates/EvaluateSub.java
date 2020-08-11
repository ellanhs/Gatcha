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
import project.gatcha.model.Filmography;
import project.gatcha.model.Movie;
import project.gatcha.model.MovieEvaluateFile;
import project.gatcha.model.MovieHasGenre;
import project.gatcha.model.People;
import project.gatcha.service.FilmographyService;
import project.gatcha.service.MovieEvaluateFileService;
import project.gatcha.service.MovieHasGenreService;
import project.gatcha.service.MovieService;
import project.gatcha.service.PeopleService;
import project.gatcha.service.impl.FilmographyServiceImpl;
import project.gatcha.service.impl.MovieEvaluateFileServiceImpl;
import project.gatcha.service.impl.MovieHasGenreServiceImpl;
import project.gatcha.service.impl.MovieServiceImpl;
import project.gatcha.service.impl.PeopleServiceImpl;


@WebServlet("/evaluate/evaluate_sub.do")
public class EvaluateSub extends BaseController {

	private static final long serialVersionUID = 4026620985037954216L;
	
	WebHelper web;
	SqlSession sqlSession;
	Logger logger;
	MovieEvaluateFileService movieEvaluateFileService;
	MovieService movieService;
	MovieHasGenreService movieHasGenreService;
	FilmographyService filmographyService;
	PeopleService peopleService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		web = WebHelper.getInstance(request, response);
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		movieEvaluateFileService = new MovieEvaluateFileServiceImpl(sqlSession, logger);
		movieService = new MovieServiceImpl(sqlSession, logger);
		movieHasGenreService = new MovieHasGenreServiceImpl(sqlSession, logger);
		filmographyService = new FilmographyServiceImpl(sqlSession, logger);
		peopleService = new PeopleServiceImpl(sqlSession, logger);
		
		String kfaId = web.getString("kfa_id");
		if(kfaId == null){
			sqlSession.close();
			web.redirect(null, "영화코드가 전송되지 않았습니다.");
			return null;
		}
		
		//파라미터를 Beans로 묶기 
		Movie movie = new Movie();
		MovieEvaluateFile movieEvaluateFile = new MovieEvaluateFile();
		MovieHasGenre movieHasGenre = new MovieHasGenre();
		Filmography filmography = new Filmography();
		
		
		
		// 불러오기 위한 정보의 기반이 되는 코드를 각각 세팅
		movie.setKfaId(kfaId);
		movieEvaluateFile.setKfaId(kfaId); //포스터, 스틸컷 등등의 url을 찾아오기 위해서.
		movieHasGenre.setMovieKfaId(kfaId); // 영화의 장르값들을 받아오기 위해서.
		filmography.setMovieKfaId(kfaId); // 배우코드(합쳐진형태), 감독 코드 (분리된 형태)
		
		//결과값이 저장될 객체들
		MovieEvaluateFile photo = null;
		Movie movieInfo = null;
		List<MovieHasGenre> genres = null;
		Filmography filmoResult = null;
		//장르값 리스트를 하나로 묶을때 쓸 문자열
		String genreSum = "";
		
		
		
		
		
		
		
		
		
		try{
			movieInfo = movieService.selectMovieInfo(movie);
			photo = movieEvaluateFileService.selectPosterStilcut(movieEvaluateFile);
			genres = movieHasGenreService.selectMovieHasGenreListByKfaId(movieHasGenre);
			filmoResult = filmographyService.selectFilmographyPeople(filmography);
			
		}catch(Exception e){
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		//필모리스트에서 받아온 감독코드와 합쳐진 배우코드를 각각 문자열에 임시저장해준다.
		People directorPeople = new People();
		People directorPeopleRes = new People();
		People actor1 = new People();
		People actor2 = new People();

		
		
		if(filmoResult!=null){
		String directorTemp = filmoResult.getDirectorKfaId();
		String actorSum = filmoResult.getKfaActorIdSum();
		System.out.println("-------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\"+directorTemp+"////////////////////////////");
		System.out.println("-------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\"+actorSum+"////////////////////////////");
		directorPeople.setKfaId(directorTemp);
		
		
		String actorArr[] = actorSum.split("\\+");
		
		for(int i=0; i<actorArr.length;i++){
			System.out.println("----------------actorArr--------"+actorArr[i]+"--------------------////////");
		}
		
			for(int i=0; i<actorArr.length;i++){
			actor1.setKfaId(actorArr[i]);
			
			
			System.out.println("----------------------------//////"+actorArr[i]+"/////----------------------------------");
			try{
				actor2 = null;
				actor2 = peopleService.selectPeopleImg(actor1);
				System.out.println("----------------------------//////"+actor2.getName()+"/////----------------------------------");
			}catch(Exception e){
				e.getLocalizedMessage();
				System.out.println("사람 조회 실패");
			}
			if(actor2 !=null){
			System.out.println("sssss"+i+"번째---------------------------------"+actor2.getPeopleP()+"------------------------");
			if(actor2.getPeopleP()==null){
				actor2.setPeopleP("");
			}
			}
			request.setAttribute("actor"+i,actor2 );
			}
		
			
			try{
				directorPeopleRes = peopleService.selectPeopleImg(directorPeople);
			}catch(Exception e){
				e.getLocalizedMessage();
			}
			
		}
		
			if(directorPeopleRes !=null){
				System.out.println("++++++++++++++++++++++++++"+directorPeopleRes.getPeopleP()+"---------------------------------");
				if(directorPeopleRes.getPeopleP()==null){
					directorPeopleRes.setPeopleP("");
					System.out.println("++++++++++++++++++++++++++"+directorPeopleRes.getPeopleP()+"---------------------------------");
													}
				}
				
				
		
			request.setAttribute("directorAA",directorPeopleRes );
		
		


		
		
		// 받아온 장르목록을 하나의 문자열로 묶어낸다. ex) 액션, 드라마  
		for(int i=0; i<genres.size();i++){
			
			if((i+1)<genres.size()){
				genreSum+= genres.get(i).getGenreList() +", ";
			}else{
				genreSum+= genres.get(i).getGenreList();
			}
		}
		
//		movieInfo.setContext(web.convertHtmlTag(movieInfo.getContext()));
		//장르목록값에 있는 /가 Html태그와 충돌하지 않게하기 위하여 처리해준다.
		genreSum= web.convertHtmlTag(genreSum);
		
		System.out.println("---------------------------------"+genreSum+"-----------------------------------------");
		//받아낸값들을 호출한 View로 보낸다.
		//photo (poster: 영화 포스터, stilcut: 영화 장면 하나 
		request.setAttribute("photo", photo);
		//movieInfo (title: 영화 제목, context: 줄거리 , age: 연령가, country:국가 , year: 연도, runtime: 상영시간)
		request.setAttribute("movieInfo", movieInfo);
		//합쳐진 장르값들이므로 그냥 genres만 써주세요, genres.???? 존재하지 않습니다. 그냥 genres로 쓰세요
		request.setAttribute("genres", genreSum);
		sqlSession.close();
		
		return "/evaluate/evaluate_sub";
	}
	

}
