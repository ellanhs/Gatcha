package project.gatcha.service;

import java.util.List;

import project.gatcha.model.Boxoffice;


public interface BoxofficeService {
	
	/**
	 *  영화 섬네일들을 조회하는 기능입니다. 영화 테이블의 아이디값과 영화 제목, 영화에 따른 섬네일(sql문 임의로 만들어서 수정이 필요하긴함), 평가 테이블의
	 *  봤어요, 보고싶어요, 관심없어요 값도 불러옵니다.
	 *  Limit도 곧 넣을것!
	 * @param boxoffice - Setter가 필요한 값은 memberId가 될것입니다.
	 * @return List<Boxoffice> 회원선택에 맞는 영화리스트를 가져옵니다.
	 */
	public Boxoffice  selectMovieList(Boxoffice boxoffice) throws Exception;
	
	/**
	 *  영화 섬네일들을 조회하는 기능입니다. 영화 테이블의 아이디값과 영화 제목, 영화에 따른 섬네일(sql문 임의로 만들어서 수정이 필요하긴함), 평가 테이블의
	 *  봤어요, 보고싶어요, 관심없어요 값도 불러옵니다.
	 *  Limit도 곧 넣을것!
	 * @param boxoffice - Setter가 필요한 값은 memberId가 될것입니다.
	 * @return List<Boxoffice> 회원선택에 맞는 영화리스트를 가져옵니다.
	 */
	public List<Boxoffice> selectMovieListByLike(Boxoffice boxoffice) throws Exception;
	
	/**
	 *  영화 섬네일들을 조회하는 기능입니다. 영화 테이블의 아이디값과 영화 제목, 영화에 따른 섬네일(sql문 임의로 만들어서 수정이 필요하긴함), 평가 테이블의
	 *  봤어요, 보고싶어요, 관심없어요 값도 불러옵니다.
	 *  Limit도 곧 넣을것!
	 * @param boxoffice - Setter가 필요한 값은 memberId가 될것입니다.
	 * @return List<Boxoffice> 회원선택에 맞는 영화리스트를 가져옵니다.
	 */
	public List<Boxoffice> selectMovieListByDislike(Boxoffice boxoffice) throws Exception;
	
	
	
	/**
	 * 
	 * @param boxoffice  - 영화코드가 셋팅된 Beans
	 * @return	Boxoffice - poster로 별칭된 file_url , stilcut로 별칭된  file_url 을 각각 포함한 Beans
	 * @throws Exception
	 */
	public Boxoffice selectPosterStilcut(Boxoffice boxoffice)throws Exception;
	
	
	/**
	 * 
	 * @param boxoffice 영화코드와 검색어가 세팅된 Beans
	 * @return	Boxoffice - 검색어에 대응되는 selectMovieList와 같은 결과.
	 * @throws Exception
	 */
	public List<Boxoffice> selectMovieListByKeyword(Boxoffice boxoffice)throws Exception;
	
	
	
	/**
	 * 
	 * @param boxoffice 영화 코드와 배우 검색어가 세팅된 Beans
	 * @return    				- 대응 되는 결과?
	 * @throws Exception
	 */
	public List<Boxoffice> selectMovieListByActorKeyWord(Boxoffice boxoffice)throws Exception;
	
	/**
	 * 
	 * @param boxoffice 박스 오피스 구현 카루셀편입니다.  아무 파라미터도 필요하지 않아요!
	 * @return					최상위 5개만 불러옵니다.
	 * @throws Exception
	 */
	public List<Boxoffice> boxofficeCarousel()throws Exception;
	
	
	/**
	 * 
	 * @param boxoffice 멤버아이디 세팅해주세요!
	 * @return					
	 * @throws Exception 		
	 */
	public List<Boxoffice> boxofficeList(Boxoffice boxoffice)throws Exception;
	
	
	

}
