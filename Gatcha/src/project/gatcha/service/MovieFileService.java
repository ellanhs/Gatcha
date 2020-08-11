package project.gatcha.service;

import java.util.List;

import project.gatcha.model.MovieFile;



/**
 * 영화 관련 파일 관련 기능을 제공하기 위한 Service 계층
 */
public interface MovieFileService {
	
	/**
	 * 영화 관련 파일을 저장한다.
	 * 
	 * @param movieFile - 영화 관련 파일 데이터
	 * @throws Exception
	 */
	public void insertMovieFile(MovieFile movieFile) throws Exception;

	/**
	 * 하나의 영화 관련 파일을 읽어들인다.
	 * 
	 * @param movieFile - 읽어들일 영화 관련 파일 일련번호가 저장된 Beans
	 * @return MovieFilemovieFile - 읽어들인 영화 관련 파일 내용
	 * @throws Exception
	 */
	public MovieFile selectMovieFile(MovieFile movieFile) throws Exception;

	
	/**
	 * 영화 관련 파일 목록 조회
	 * 
	 * @param movieFile - 카테고리 정보가 저장된 Beans
	 * @return List - 영화 관련 파일 목록
	 * @throws Exception
	 */
	public List<MovieFile> selectMovieFileList(MovieFile movieFile) throws Exception;

	/**
	 * 영화 관련 파일을 삭제한다.
	 * 
	 * @param movieFile
	 * @throws Exception
	 */
	public void deleteMovieFile(MovieFile movieFile) throws Exception;
	
	/**
	 * 영화 관련 파일을 수정한다.
	 * @param movieFile - 영화 관련 파일 데이터
	 * @throws Exception
	 */
	public void updateMovieFile(MovieFile movieFile) throws Exception;

}
