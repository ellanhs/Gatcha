package project.gatcha.service;

import java.util.List;

import project.gatcha.model.MovieEvaluateCount;



/**
 * 영화 관련 파일 관련 기능을 제공하기 위한 Service 계층
 */
public interface MovieEvaluateCountService {
	

	/**
	 * 영화 관련 파일 목록 조회
	 * 
	 * @param movieFile - 카테고리 정보가 저장된 Beans
	 * @return List - 영화 관련 파일 목록
	 * @throws Exception
	 */
	public List<MovieEvaluateCount> selectMovieEvaluateCountList(MovieEvaluateCount movieEvaluateCount) throws Exception;

	/**
	 * 영화 관련 파일 목록 조회
	 * 
	 * @param movieFile - 카테고리 정보가 저장된 Beans
	 * @return List - 영화 관련 파일 목록
	 * @throws Exception
	 */
	public List<MovieEvaluateCount> selectMovieEvaluateCountList2(MovieEvaluateCount movieEvaluateCount) throws Exception;

}
