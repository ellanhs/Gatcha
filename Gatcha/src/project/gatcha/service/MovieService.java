package project.gatcha.service;

import java.util.List;

import project.gatcha.model.Movie;

public interface MovieService {
	
	
	/**
	 * 영화 목록을 불러온다.
	 * @param movie 조건에 맞는 영화
	 * @return List<Moive> 파라미터 조건을 만족하는 영화 목록을 30개씩.
	 * @throws Exception 
	 */
	public List<Movie> selectMovieList()throws Exception;
	
	
	
	/**
	 * 영화 목록 수를 조회합니다. 1이상의 값이 리턴되면 selectMovieList가 실행될수 있도록 합니다. 
	 * @param movie
	 * @return int - 영화 목록의 수 
	 * @throws Exception
	 */
	public int selectMovieListCount(Movie movie)throws Exception;
	
	
	/**
	 * 
	 * @param movie  kfa_id가 세팅된 Beans
	 * @return	Movie 	영화 코드, 제목 , 연도, 제작국가, 연령제한, 상영시간, 줄거리 , 별점 , 별점 총점, 별점 수 가 저장된 Beans
	 * @throws Exception
	 */
	public Movie selectMovieInfo(Movie movie)throws Exception;

	/**
	 * 
	 * @param movie_kfa_id가 세팅된 Beans
	 * @return 별점총합, 별점평균, 별점카운트가 저장된 Beans
	 * @throws Exception
	 */
	public void updateEvaluateStar(Movie movie)throws Exception;

}
