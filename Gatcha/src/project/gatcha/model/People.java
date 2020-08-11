package project.gatcha.model;

public class People {
	private String kfaId;
	private String koficId;
	private String name;
	private String role;
	private String regDate;
	private String editDate;
	private String peopleP;
	private String keyword;
	
	
	public String getPeopleP() {
		return peopleP;
	}
	public void setPeopleP(String peopleP) {
		this.peopleP = peopleP;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "People [kfaId=" + kfaId + ", koficId=" + koficId + ", name=" + name + ", role=" + role + ", regDate="
				+ regDate + ", editDate=" + editDate + ", peopleP=" + peopleP + ", keyword=" + keyword + "]";
	}

	
	
	
	
}
