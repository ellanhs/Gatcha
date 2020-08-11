package project.gatcha.service;

import java.util.List;

import project.gatcha.model.MovieHasGenre;



/**
 * 영화장르 관련 기능을 제공하기 위한 Service 계층
 */
public interface MovieHasGenreService {
	/**
	 * 영화의 장르를 저장한다.
	 * 
	 * @param movieHasGenre - 영화의 장르 데이터
	 * @throws Exception
	 */
	public void insertMovieHasGenre(MovieHasGenre movieHasGenre) throws Exception;

	/**
	 * 하나의 영화의 장르를 읽어들인다.
	 * 
	 * @param movieHasGenre - 읽어들일 영화의 장르 일련번호가 저장된 Beans
	 * @return MovieHasGenremovieHasGenre - 읽어들인 영화의 장르 내용
	 * @throws Exception
	 */
	public MovieHasGenre selectMovieHasGenre(MovieHasGenre movieHasGenre) throws Exception;

	
	/**
	 * 영화의 장르 목록 조회
	 * 
	 * @param movieHasGenre - 카테고리 정보가 저장된 Beans
	 * @return List - 영화의 장르 목록
	 * @throws Exception
	 */
	public List<MovieHasGenre> selectMovieHasGenreList(MovieHasGenre movieHasGenre) throws Exception;
	
	/**
	 * 영화의 코드값(kfa_id)값을 받아와서 그 영화가 가진 모든 장르를 조회해 온다. 즉, 가져온 리스트를 하나의 값으로 처리하는 과정이 요구된다.
	 * 
	 * @param movieHasGenre kfa_id값을 movie_kfa_id값으로 세팅한 Beans
	 * @return List - 조회하고자 하는 영화의 장르들이 리턴됨
	 * @throws Exception
	 */
	public List<MovieHasGenre> selectMovieHasGenreListByKfaId(MovieHasGenre movieHasGenre) throws Exception;

	/**
	 * 영화의 장르를 삭제한다.
	 * 
	 * @param movieHasGenre
	 * @throws Exception
	 */
	public void deleteMovieHasGenre(MovieHasGenre movieHasGenre) throws Exception;
	
	/**
	 * 영화의 장르를 수정한다.
	 * @param movieHasGenre - 영화의 장르 데이터
	 * @throws Exception
	 */
	public void updateMovieHasGenre(MovieHasGenre movieHasGenre) throws Exception;

}
