package project.gatcha.service;

import java.util.List;

import project.gatcha.model.Bbs;


/**
 * 게시물 관련 기능을 제공하기 위한 Service 계층
 */
public interface BbsService {
	/**
	 * 게시물을 저장한다.
	 * 
	 * @param bbs
	 *            - 게시물 데이터
	 * @throws Exception
	 */
	public void insertBbs(Bbs bbs) throws Exception;

	/**
	 * 하나의 게시물을 읽어들인다.
	 * 
	 * @param bbs
	 *            - 읽어들일 게시물 일련번호가 저장된 Beans
	 * @return BbsBbs - 읽어들인 게시물 내용
	 * @throws Exception
	 */
	public Bbs selectBbs(Bbs bbs) throws Exception;

	/**
	 * 게시물을 수정한다.
	 * @param bbs
	 * @throws Exception
	 */
	public void updateBbsHit(Bbs bbs) throws Exception;

	/**
	 * 게시글 목록 조회
	 * 
	 * @param bbs
	 *            - 카테고리 정보가 저장된 Beans
	 * @return List - 게시물 목록
	 * @throws Exception
	 */
	public List<Bbs> selectBbsList(Bbs bbs) throws Exception;


	/**
	 * 게시물을 삭제한다.
	 * 
	 * @param bbs
	 * @throws Exception
	 */
	public void deleteBbs(Bbs bbs) throws Exception;
	
	/**
	 * 게시물을 수정한다.
	 * @param bbs - 게시물 데이터
	 * @throws Exception
	 */
	public void updateBbs(Bbs bbs) throws Exception;

	/**
	 * 게시물의 덧글을 수정한다.
	 * @param bbs - 게시물 데이터
	 * @throws Exception
	 */
	public void updateBbsComment(Bbs bbs) throws Exception;

	/**
	 * 이전 글 조회
	 * @param bbs
	 * @return Bbs 
	 * @throws Exception
	 */
	public Bbs selectPrevBbs(Bbs bbs) throws Exception;
	
	/**
	 * 다음 글 조회
	 * @param bbs
	 * @return Bbs
	 * @throws Exception
	 */
	public Bbs selectNextBbs(Bbs bbs) throws Exception;
	
	/**
	 * 게시글 목록 조회(nickname 추가 조인)
	 * @param bbs
	 * @return List<Bbs>
	 * @throws Exception
	 */
	public List<Bbs> selectBbsJoinList(Bbs bbs) throws Exception;
	
	/**
	 * 게시글 조회(nickname 추가 조인)
	 * @param bbs
	 * @return Bbs
	 * @throws Exception
	 */
	public Bbs selectJoinBbs(Bbs bbs) throws Exception;
	
	/**
	 * 전체 게시물 수 조회(nickname 추가 조인)
	 * @param bbs
	 * @return
	 * @throws Exception
	 */
	public int selectBbsJoinCount(Bbs bbs) throws Exception; 
	
	/**
	 * 자신의 게시물인지 검사한다.
	 * @param bbs
	 * @return int
	 * @throws Exception
	 */
	public int selectBbsCountByMemberId(Bbs bbs) throws Exception;
	
	/**
	 * 회원과 게시물의 참조관계를 해제한다. 특정 지정된 회원 아이디로 입력하던지 Null을 입력한다.
	 * @param bbs - 게시물 데이터
	 * @throws Exception
	 */
	public void updateBbsMemberOut(Bbs bbs) throws Exception;

	/**
	 * 회원과 게시물의 참조관계를 해제한다. 비권장사항이지만 관련 글을 전부 삭제한다. 참조용
	 * @param bbs - 게시물 데이터
	 * @throws Exception
	 */
	public void deleteBbsMemberOut(Bbs bbs) throws Exception;
}
