package project.gatcha.service;

import java.util.List;

import project.gatcha.model.Genre;



/**
 * 영화 장르 관련 파일 관련 기능을 제공하기 위한 Service 계층
 */
public interface GenreService {
	
	/**
	 * 영화 장르 관련 파일을 저장한다.
	 * 
	 * @param genre - 영화 장르 관련 파일 데이터
	 * @throws Exception
	 */
	public void insertGenre(Genre genre) throws Exception;

	/**
	 * 하나의 영화 장르 관련 파일을 읽어들인다.
	 * 
	 * @param genre - 읽어들일 영화 장르 관련 파일 일련번호가 저장된 Beans
	 * @return Genregenre - 읽어들인 영화 장르 관련 파일 내용
	 * @throws Exception
	 */
	public Genre selectGenre(Genre genre) throws Exception;

	
	/**
	 * 영화 장르 관련 파일 목록 조회
	 * 
	 * @param genre - 카테고리 정보가 저장된 Beans
	 * @return List - 영화 장르 관련 파일 목록
	 * @throws Exception
	 */
	public List<Genre> selectGenreList(Genre genre) throws Exception;

	/**
	 * 영화 장르 관련 파일을 삭제한다.
	 * 
	 * @param genre
	 * @throws Exception
	 */
	public void deleteGenre(Genre genre) throws Exception;
	
	/**
	 * 영화 장르 관련 파일을 수정한다.
	 * @param genre - 영화 장르 관련 파일 데이터
	 * @throws Exception
	 */
	public void updateGenre(Genre genre) throws Exception;

}
