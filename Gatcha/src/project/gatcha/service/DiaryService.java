package project.gatcha.service;

import java.util.List;

import project.gatcha.model.Diary;
import project.gatcha.model.Evaluate;


public interface DiaryService {
	
	
	public List<Diary> selectDiarylist(Diary diary)throws Exception;
	
	public Diary selectDiaryOne(Diary diary)throws Exception;
	
	public Diary updateDiary(Diary diary)throws Exception;
}
