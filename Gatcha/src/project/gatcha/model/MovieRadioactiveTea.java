package project.gatcha.model;

import java.util.Comparator;
import java.util.Map;

public class MovieRadioactiveTea implements Comparator<String> {

	
	private String kfaId;
	private String title;
	private String year;
	private String country;
	private String age;
	private String runtime;
	private String context;
	private String rank;
	
	
	public MovieRadioactiveTea(){
		
	}
	
	Map<String, Integer> base;
    public MovieRadioactiveTea(Map<String, Integer> base) {
        this.base = base;
    }
	
	
	
	public MovieRadioactiveTea(String kfaId, String title) {
		super();
		this.kfaId = kfaId;
		this.title = title;
	}



	public MovieRadioactiveTea(String kfaId, String title, String context) {
		super();
		this.kfaId = kfaId;
		this.title = title;
		this.context = context;
	}
	
	
	
	
	public String getRank() {
		return rank;
	}



	public void setRank(String rank) {
		this.rank = rank;
	}



	public String getKfaId() {
		return kfaId;
	}
	public void setKfaId(String kfaId) {
		this.kfaId = kfaId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	
	
	public String getContext() {
		return context;
	}



	public void setContext(String context) {
		this.context = context;
	}

	@Override
	public int compare(String arg0, String arg1) {
		 if (base.get(arg0) >= base.get(arg1)) {
	            return -1;
	        } else {
	            return 1;
	        }
	    }

	@Override
	public String toString() {
		return "MovieRadioactiveTea [kfaId=" + kfaId + ", title=" + title + ", year=" + year + ", country=" + country
				+ ", age=" + age + ", runtime=" + runtime + ", context=" + context + ", rank=" + rank + "]";
	}



	
	
	
	


	



	
	
	
}
