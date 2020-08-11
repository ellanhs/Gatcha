package project.gatcha.model;

public class PeopleImage {

	private int id;
	private String peopleKfaId;
	private String profileUrl;
	private String regDate;
	private String editDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPeopleKfaId() {
		return peopleKfaId;
	}
	public void setPeopleKfaId(String peopleKfaId) {
		this.peopleKfaId = peopleKfaId;
	}
	public String getProfileUrl() {
		return profileUrl;
	}
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
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
	@Override
	public String toString() {
		return "PeopleImage [id=" + id + ", peopleKfaId=" + peopleKfaId + ", profileUrl=" + profileUrl + ", regDate="
				+ regDate + ", editDate=" + editDate + "]";
	}
	
	
}
