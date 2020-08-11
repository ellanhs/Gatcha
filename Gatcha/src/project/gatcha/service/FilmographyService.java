package project.gatcha.service;

import java.util.List;

import project.gatcha.model.Filmography;

/**
 * 필모그래피 관련 파일 관련 기능을 제공하기 위한 Service 계층
 */
public interface FilmographyService {
	/**
	 * 필모그래피 관련 파일을 저장한다.
	 * 
	 * @param filmography
	 *            - 필모그래피 관련 파일 데이터
	 * @throws Exception
	 */
	public void insertFilmography(Filmography filmography) throws Exception;

	/**
	 * 하나의 필모그래피 관련 파일을 읽어들인다.
	 * 
	 * @param filmography
	 *            - 읽어들일 필모그래피 관련 파일 일련번호가 저장된 Beans
	 * @return FilmographyFilmography - 읽어들인 필모그래피 관련 파일 내용
	 * @throws Exception
	 */
	public Filmography selectFilmography(Filmography filmography) throws Exception;

	/**
	 * 게시글 목록 조회
	 * 
	 * @param filmography
	 *            - 카테고리 정보가 저장된 Beans
	 * @return List - 필모그래피 관련 파일 목록
	 * @throws Exception
	 */
	public List<Filmography> selectFilmographyList(Filmography filmography) throws Exception;

	
	/**
	 * 필모그래피 관련 파일을 삭제한다.
	 * 
	 * @param filmography
	 * @throws Exception
	 */
	public void deleteFilmography(Filmography filmography) throws Exception;
	
	/**
	 * 필모그래피 관련 파일을 수정한다.
	 * @param filmography - 필모그래피 관련 파일 데이터
	 * @throws Exception
	 */
	public void updateFilmography(Filmography filmography) throws Exception;
	
	/**
	 * 
	 * @param filmography 영화 코드가 셋된 Beans
	 * @return Filmography - 배우 코드 합친거 + 감독 코드 
	 * @throws Exception
	 */
	public Filmography selectFilmographyPeople(Filmography filmography) throws Exception;
	
	/**
	 * 
	 * @param filmography 영화 코드가 셋된 Beans
	 * @return Filmography - 감독 코드 
	 * @throws Exception
	 */
	public List<Filmography> selectStatEvaluate(Filmography filmography) throws Exception;
	
	/**
	 * 
	 * @param filmography 영화 코드가 셋된 Beans
	 * @return Filmography - 배우 코드 합친거
	 * @throws Exception
	 */
	public List<Filmography> selectStatFilmoActor(Filmography filmography) throws Exception;
}
