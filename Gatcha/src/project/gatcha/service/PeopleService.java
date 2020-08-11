package project.gatcha.service;

import java.util.List;

import project.gatcha.model.People;

/**
 * 인물 관련 기능을 제공하기 위한 Service 계층
 */
public interface PeopleService {
	/**
	 * 인물을 저장한다.
	 * 
	 * @param people
	 *            - 인물 데이터
	 * @throws Exception
	 */
	public void insertPeople(People people) throws Exception;

	/**
	 * 하나의 인물을 읽어들인다.
	 * 
	 * @param people
	 *            - 읽어들일 인물 일련번호가 저장된 Beans
	 * @return PeoplePeople - 읽어들인 인물 내용
	 * @throws Exception
	 */
	public People selectPeople(People people) throws Exception;


	/**
	 * 인물 목록 조회
	 * 
	 * @param people
	 *            - 카테고리 정보가 저장된 Beans
	 * @return List - 인물 목록
	 * @throws Exception
	 */
	public List<People> selectPeopleList(People people) throws Exception;


	/**
	 * 인물을 삭제한다.
	 * 
	 * @param people
	 * @throws Exception
	 */
	public void deletePeople(People people) throws Exception;
	
	/**
	 * 인물을 수정한다.
	 * @param people - 인물 데이터
	 * @throws Exception
	 */
	public void updatePeople(People people) throws Exception;
	
	public People selectPeopleImg(People people) throws Exception;;

}
