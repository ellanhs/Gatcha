package project.gatcha.generator;

import project.gatcha.helper.naverSearchHelper;

public class TestNaver {

	public static void main(String[] args) {
		naverSearchHelper na = naverSearchHelper.getInstance();
		String keyword="당갈";
		int yearfrom=2018;
		int yearto=2018;
		na.movieSearch(keyword,yearfrom,yearto);
		
	}

}
