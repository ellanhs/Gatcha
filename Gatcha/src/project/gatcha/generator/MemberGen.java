package project.gatcha.generator;

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
import project.gatcha.helper.MemberGeneratorHelper;
import project.gatcha.model.Evaluate;
import project.gatcha.model.Member;
import project.gatcha.model.Movie;
import project.gatcha.model.MovieHasGenre;
import project.gatcha.service.EvaluateService;
import project.gatcha.service.MemberService;
import project.gatcha.service.MovieHasGenreService;
import project.gatcha.service.MovieService;
import project.gatcha.service.impl.EvaluateServiceImpl;
import project.gatcha.service.impl.MemberServiceImpl;
import project.gatcha.service.impl.MovieHasGenreServiceImpl;
import project.gatcha.service.impl.MovieServiceImpl;

@WebServlet("/gen.do")
public class MemberGen extends BaseController {

	private static final long serialVersionUID = 5855414584424478189L;
	/** (1) 사용하고자 하는 Helper + Service 객체 선언 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger;
	// --> import org.apache.ibatis.session.SqlSession;
	SqlSession sqlSession;
	MemberGeneratorHelper mem;
	MovieService movieService;
	EvaluateService evaluateService;
	MovieHasGenreService movieHasGenreService;
	// --> import project.gatcha.mysite.service.MemberService;
	MemberService memberService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		// --> import org.apache.logging.log4j.LogManager;
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		// --> import project.gatcha.mysite.service.impl.MemberServiceImpl;
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		mem = MemberGeneratorHelper.getInstance();

		// 등록된 전체 영화 목록을 조회하기 위한 작업
		movieService = new MovieServiceImpl(sqlSession, logger);
		List<Movie> movieList;
		try {
			movieList = movieService.selectMovieList();
		} catch (Exception e) {
			sqlSession.close();

			return null;
		}
		// 조회된 영화 갯수
		int numofmovie = movieList.size();

		// 회원가입 처리를 위한 Service객체
		// --> import project.gatcha.mysite.service.impl.MemberServiceImpl;
		memberService = new MemberServiceImpl(sqlSession, logger);
		evaluateService = new EvaluateServiceImpl(sqlSession, logger);
		movieHasGenreService = new MovieHasGenreServiceImpl(sqlSession, logger);

		String gender = "";
		String age = "";
		int numberofMember = 1;// 생성회원수

		for (int i = 0; i < numberofMember; i++) {

			Member member = new Member();
			member.setNickname(mem.getNickname());
			member.setEmail(mem.getEmail());
			member.setUserPw("1234");
			gender = mem.getGender();
			member.setGender(gender);
			age = mem.getAge();
			member.setBirthdate(age);
			// 멤버 하나당 회원 가입
			try {
				memberService.insertMember(member);
			} catch (Exception e) {
				sqlSession.close();

				return null;
			}

			int id = member.getId();
			int[] genre = mem.getGenre(gender, age);
			for (int j = 0; j < genre.length; j++) {
				try {
					int genreInt = genre[j];
					member.setId(id);
					member.setGenre(genreInt);
					memberService.insertMemberHasGenre(member);
				} catch (Exception e) {
					sqlSession.close();

					return null;
				}
			}

			// 영화 평가 및 별점 매기기
			// 선호 장르면 4점 근처 평점 random 비선호 장르면 3점 근처
			// 인당 평가 영화 갯수 영화 리스트 전체 크기를 넘지 못한다.
			int numofEvalMovie = 10; // 회원 당 생성 영화 평가 수

			if (numofEvalMovie > numofmovie) {
				numofEvalMovie = numofmovie;
			}

			double mean = 3.0d; // 별점 3
			int movieIndex = 0;
			String movieID = "";
			MovieHasGenre input = new MovieHasGenre();
			List<MovieHasGenre> output = null;
			double mystarpoint = 0.0;
			Evaluate evaluate = new Evaluate();
			Evaluate evaluateNext = new Evaluate();
			String likes = "0";
			String dislike = "0";
			for (int k = 0; k < numofEvalMovie; k++) {
				movieIndex = mem.randomage(0, numofmovie - 1); // 임의의 영화를 선택해서
																// 평가
				movieID = movieList.get(movieIndex).getKfaId();
				input.setMovieKfaId(movieID);
				try {
					output = movieHasGenreService.selectMovieHasGenreListByKfaId(input);
				} catch (Exception e) {
					sqlSession.close();
				}

				for (int l = 0; l < output.size(); l++) {
					for (int j = 0; j < genre.length; j++) {
						if (genre[j] == output.get(l).getGenreId()) { // 선택된 영화와 회원의 선호 장르와비교
							mean = 4.0d; // 별점 4
						}
					}
				}

				mystarpoint = mem.getMystarpoint(mean);// 평균점 기준으로 표준편차 2의 별점 랜덤
				System.out.println("mystarpoint="+mystarpoint);										// 생성

				// evaluate table 에 생성된 값 확
				evaluate.setMovieKfaId(movieID);
				evaluate.setMemberId(id);
				int result = 0;
				
				try {
					result = evaluateService.selectEvaluateCount(evaluate);
				} catch (Exception e) {
					e.getLocalizedMessage();
					System.out.println("카운트오류");
				}

				if (mystarpoint >= 4.5) {
					likes = "1";
				}else{
					likes="0";// 평점에 따른 좋아요 체크
				}
				if (mystarpoint <= 0.5) {
					dislike = "1";
				}else{
					dislike ="0";
				}
				
				// 평점에 따른 관심없어요 체크
				String mystarpointStr = Double.toString(mystarpoint);
				evaluateNext.setLikes(likes);
				evaluateNext.setDislike(dislike);
				evaluateNext.setMyStarpoint(mystarpointStr);
				evaluateNext.setMovieKfaId(movieID);
				evaluateNext.setMemberId(id);
				System.out.println(evaluateNext);
				if (result < 1) {
					try {
						evaluateService.insertEvaluateMayNoOne(evaluateNext);

						/** Movie table에 추가될 총별점, 별점평균, 별점카운트(insert 사용시) **/
						// 조회 결과가 저장될 Beans 선언하기
						Evaluate item = null;

						try {
							// EvaluateMapper.selectEvaluateStar 기능을 호출한다.
							// 두 번째 파라미터는 조회 조건시에 사용될 파라미터 --> Beans객체
							// 조회 결과가 단일행을 리턴하기 때문에 Beans객체 형태로 리턴된다
							item = evaluateService.selectEvaluateStar(evaluate);

							String starpointHit = item.getMemberIdCount();
							String starpointMean = item.getMyStarpointMean();
							String starpointTotal = item.getMyStarpointTotal();
							String kfaId = item.getMovieKfaId();

							try {

								Movie movie = new Movie();
								movie.setStarpointHit(starpointHit);
								movie.setStarpointTotal(starpointTotal);
								movie.setStarpointMean(starpointMean);
								movie.setKfaId(kfaId);

								movieService.updateEvaluateStar(movie);

							} catch (Exception e) {
								System.out.println(e.getLocalizedMessage());
								System.out.println("movie 별점 데이터 조회에 실패했습니다.");
							}
						} catch (Exception e) {
							System.out.println(e.getLocalizedMessage());
							System.out.println("movie 데이터 조회에 실패했습니다.");
						}

						/**
						 * ----------Movie table에 추가될 총별점, 별점평균, 별점카운트
						 * fin----------
						 **/

					} catch (Exception e) {
						e.getLocalizedMessage();
						System.out.println("인서트 오류");
					}

				} else {
					try {
						evaluateService.updateEvaluateMyStarPoint(evaluateNext);

						/** Movie table에 추가될 총별점, 별점평균, 별점카운트(update 사용시) **/
						// 조회 결과가 저장될 Beans 선언하기
						Evaluate item = null;

						try {
							// EvaluateMapper.selectEvaluateStar 기능을 호출한다.
							// 두 번째 파라미터는 조회 조건시에 사용될 파라미터 --> Beans객체
							// 조회 결과가 단일행을 리턴하기 때문에 Beans객체 형태로 리턴된다
							item = evaluateService.selectEvaluateStar(evaluate);
							System.out.println(item.toString());

							String starpointHit = item.getMemberIdCount();
							String starpointMean = item.getMyStarpointMean();
							String starpointTotal = item.getMyStarpointTotal();
							String kfaId = item.getMovieKfaId();

							try {

								Movie movie = new Movie();
								movie.setStarpointHit(starpointHit);
								movie.setStarpointTotal(starpointTotal);
								movie.setStarpointMean(starpointMean);
								movie.setKfaId(kfaId);

								movieService.updateEvaluateStar(movie);

							} catch (Exception e) {
								System.out.println(e.getLocalizedMessage());
								System.out.println("movie 별점 데이터 조회에 실패했습니다.");
							}
						} catch (Exception e) {
							System.out.println(e.getLocalizedMessage());
							System.out.println("movie 데이터 조회에 실패했습니다.");
						}

						/**
						 * ----------Movie table에 추가될 총별점, 별점평균, 별점카운트
						 * fin----------
						 **/

					} catch (Exception e) {
						e.getLocalizedMessage();
						System.out.println("업데이트 오류");
					}
				}
			}

		}

		sqlSession.close();

		return null;
	}

}
