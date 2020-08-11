package project.gatcha.model;

public class Movie {
	private String kfaId;
	private String koficId;
	private String title;
	private String year;
	private String country;
	private String age;
	private String runtime;
	private String context;
	private String regDate;
	private String editDate;
	private String starpointMean;
	private String starpointTotal;
	private String starpointHit;
	
	
	public String getKfaId() {
		return kfaId;
	}
	public void setKfaId(String kfaId) {
		this.kfaId = kfaId;
	}
	public String getKoficId() {
		return koficId;
	}
	public void setKoficId(String koficId) {
		this.koficId = koficId;
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getEditDate() {
		return editDate;
	}
	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
	public String getStarpointMean() {
		return starpointMean;
	}
	public void setStarpointMean(String starpointMean) {
		this.starpointMean = starpointMean;
	}
	public String getStarpointTotal() {
		return starpointTotal;
	}
	public void setStarpointTotal(String starpointTotal) {
		this.starpointTotal = starpointTotal;
	}
	public String getStarpointHit() {
		return starpointHit;
	}
	public void setStarpointHit(String starpointHit) {
		this.starpointHit = starpointHit;
	}
	@Override
	public String toString() {
		return "Movie [kfaId=" + kfaId + ", koficId=" + koficId + ", title=" + title + ", year=" + year + ", country="
				+ country + ", age=" + age + ", runtime=" + runtime + ", context=" + context + ", regDate=" + regDate
				+ ", editDate=" + editDate + ", starpointMean=" + starpointMean + ", starpointTotal=" + starpointTotal
				+ ", starpointHit=" + starpointHit + "]";
	}

}
