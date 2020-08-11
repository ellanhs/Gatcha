package project.gatcha.service;

import java.util.List;

import project.gatcha.model.MemberHasGenre;

/**
 * 게시물 관련 기능을 제공하기 위한 Service 계층
 */
public interface MemberHasGenreService {
	/**
	 * 선호장르를 저장한다.
	 * 
	 * @param memberHasGenre - 영화의 장르 데이터
	 * @throws Exception
	 */
	public void insertMemberHasGenre(MemberHasGenre memberHasGenre) throws Exception;

	/**
	 * 선호장르를 읽어들인다.
	 * 
	 * @param memberHasGenre - 읽어들일 영화의 장르 일련번호가 저장된 Beans
	 * @return MemberHasGenrememberHasGenre - 읽어들인 영화의 장르 내용
	 * @throws Exception
	 */
	public MemberHasGenre selectMemberHasGenre(MemberHasGenre memberHasGenre) throws Exception;

	
	/**
	 * 선호장르 목록 조회
	 * 
	 * @param memberHasGenre - 카테고리 정보가 저장된 Beans
	 * @return List - 영화의 장르 목록
	 * @throws Exception
	 */
	public List<MemberHasGenre> selectMemberHasGenreList(MemberHasGenre memberHasGenre) throws Exception;

	/**
	 * 선호장르를 삭제한다.
	 * 
	 * @param memberHasGenre
	 * @throws Exception
	 */
	public void deleteMemberHasGenre(MemberHasGenre memberHasGenre) throws Exception;
	
	/**
	 * 선호장르를 수정한다.
	 * @param memberHasGenre - 영화의 장르 데이터
	 * @throws Exception
	 */
	public void updateMemberHasGenre(MemberHasGenre memberHasGenre) throws Exception;

}
