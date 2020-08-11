package project.gatcha.service;

import java.util.List;


import project.gatcha.model.PeopleImage;

/**
 * 인물 사진 관련 기능을 제공하기 위한 Service 계층
 */
public interface PeopleImageService {
	/**
	 * 인물 사진을 저장한다.
	 * 
	 * @param peopleImage
	 *            - 인물 사진 데이터
	 * @throws Exception
	 */
	public void insertPeopleImage(PeopleImage peopleImage) throws Exception;

	/**
	 * 하나의 인물 사진을 읽어들인다.
	 * 
	 * @param peopleImage
	 *            - 읽어들일 인물 사진 일련번호가 저장된 Beans
	 * @return PeopleImagePeopleImage - 읽어들인 인물 사진 내용
	 * @throws Exception
	 */
	public PeopleImage selectPeopleImage(PeopleImage peopleImage) throws Exception;


	/**
	 * 인물사진 목록 조회
	 * 
	 * @param peopleImage
	 *            - 카테고리 정보가 저장된 Beans
	 * @return List - 인물 사진 목록
	 * @throws Exception
	 */
	public List<PeopleImage> selectPeopleImageList(PeopleImage peopleImage) throws Exception;


	/**
	 * 인물 사진을 삭제한다.
	 * 
	 * @param peopleImage
	 * @throws Exception
	 */
	public void deletePeopleImage(PeopleImage peopleImage) throws Exception;
	
	/**
	 * 인물 사진을 수정한다.
	 * @param peopleImage - 인물 사진 데이터
	 * @throws Exception
	 */
	public void updatePeopleImage(PeopleImage peopleImage) throws Exception;

	/**
	 * 상위 3명의 배우 사진을 출력해온다.
	 * @param peopleImage - 인물 사진 데이터
	 * @throws Exception
	 */
	public PeopleImage selectPeopleImageAct(PeopleImage peopleImage) throws Exception;
}
