package project.gatcha.generator;


import java.util.Random;

import project.gatcha.helper.MemberGeneratorHelper;

public class Test {

	public static void main(String[] args) {
		String gender = "";
		String age = "";
		MemberGeneratorHelper mem = MemberGeneratorHelper.getInstance();
		for (int i = 0; i < 1000; i++) {
			System.out.println(i+1+"명째 데이터:");
			System.out.println(mem.getEmail());
			System.out.println(mem.getNickname());
			gender = mem.getGender();
			System.out.println(gender);
			age = mem.getAge();
			System.out.println(age);
			int[] genre = mem.getGenre(gender,age);
			for (int j = 0; j < genre.length; j++) {
				System.out.println("genre["+j+"]="+genre[j]);
			}
			// System.out.println(mem.getGenre(gender,age));
		}
		
	}

}
