package project.gatcha.service;

import java.util.List;

import project.gatcha.model.MovieEvaluateFile;


public interface MovieEvaluateFileService {
	
	/**
	 *  영화 섬네일들을 조회하는 기능입니다. 영화 테이블의 아이디값과 영화 제목, 영화에 따른 섬네일(sql문 임의로 만들어서 수정이 필요하긴함), 평가 테이블의
	 *  봤어요, 보고싶어요, 관심없어요 값도 불러옵니다.
	 *  Limit도 곧 넣을것!
	 * @param movieEvaluateFile - Setter가 필요한 값은 memberId가 될것입니다.
	 * @return List<MovieEvaluateFile> 회원선택에 맞는 영화리스트를 가져옵니다.
	 */
	public List<MovieEvaluateFile> selectMovieList(MovieEvaluateFile movieEvaluateFile) throws Exception;
	
	/**
	 *  영화 섬네일들을 조회하는 기능입니다. 영화 테이블의 아이디값과 영화 제목, 영화에 따른 섬네일(sql문 임의로 만들어서 수정이 필요하긴함), 평가 테이블의
	 *  봤어요, 보고싶어요, 관심없어요 값도 불러옵니다.
	 *  Limit도 곧 넣을것!
	 * @param movieEvaluateFile - Setter가 필요한 값은 memberId가 될것입니다.
	 * @return List<MovieEvaluateFile> 회원선택에 맞는 영화리스트를 가져옵니다.
	 */
	public List<MovieEvaluateFile> selectMovieListByLike(MovieEvaluateFile movieEvaluateFile) throws Exception;
	
	/**
	 *  영화 섬네일들을 조회하는 기능입니다. 영화 테이블의 아이디값과 영화 제목, 영화에 따른 섬네일(sql문 임의로 만들어서 수정이 필요하긴함), 평가 테이블의
	 *  봤어요, 보고싶어요, 관심없어요 값도 불러옵니다.
	 *  Limit도 곧 넣을것!
	 * @param movieEvaluateFile - Setter가 필요한 값은 memberId가 될것입니다.
	 * @return List<MovieEvaluateFile> 회원선택에 맞는 영화리스트를 가져옵니다.
	 */
	public List<MovieEvaluateFile> selectMovieListByDislike(MovieEvaluateFile movieEvaluateFile) throws Exception;
	
	
	
	/**
	 * 
	 * @param movieEvaluateFile  - 영화코드가 셋팅된 Beans
	 * @return	MovieEvaluateFile - poster로 별칭된 file_url , stilcut로 별칭된  file_url 을 각각 포함한 Beans
	 * @throws Exception
	 */
	public MovieEvaluateFile selectPosterStilcut(MovieEvaluateFile movieEvaluateFile)throws Exception;
	
	
	/**
	 * 
	 * @param movieEvaluateFile 영화코드와 검색어가 세팅된 Beans
	 * @return	MovieEvaluateFile - 검색어에 대응되는 selectMovieList와 같은 결과.
	 * @throws Exception
	 */
	public List<MovieEvaluateFile> selectMovieListByKeyword(MovieEvaluateFile movieEvaluateFile)throws Exception;
	
	
	
	/**
	 * 
	 * @param movieEvaluateFile 감독 검색어가 세팅된 Beans
	 * @return	그 검색어에 맞는 결과.
	 * @throws Exception
	 */
	public List<MovieEvaluateFile> selectMovieListByDirectorKeyWord(MovieEvaluateFile movieEvaluateFile)throws Exception;
	
	
	/**
	 * 
	 * @param movieEvaluateFile 배우 검색어가 세팅된 Beans
	 * @return    				- 대응 되는 결과?
	 * @throws Exception
	 */
	public List<MovieEvaluateFile> selectMovieListByActorKeyWord(MovieEvaluateFile movieEvaluateFile)throws Exception;
	
	/**
	 * 
	 * @param movieEvaluateFile 박스 오피스 구현 카루셀편입니다.  아무 파라미터도 필요하지 않아요!
	 * @return					최상위 5개만 불러옵니다.
	 * @throws Exception
	 */
	public List<MovieEvaluateFile> boxofficeCarousel()throws Exception;
	
	
	/**
	 * 
	 * @param movieEvaluateFile 멤버아이디 세팅해주세요!
	 * @return					
	 * @throws Exception 		
	 */
	public List<MovieEvaluateFile> boxofficeList(MovieEvaluateFile movieEvaluateFile)throws Exception;
	
	
	
	/**
	 * 
	 * @param evaluate 멤버아이디, 장르값이 세팅된 객체
	 * @return	회원이 평가한 영화의 해당 장르 갯수 조회
	 * @throws Exception
	 */
	public int selectEvaluateGenreCount(MovieEvaluateFile movieEvaluateFile) throws Exception;
	

}
