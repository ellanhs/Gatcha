package project.gatcha.model;

public class Genre {
	
	private int id;
	private String genreName;
	private String regDate;
	private String editDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
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
		return "Genre [id=" + id + ", genreName=" + genreName + ", regDate=" + regDate + ", editDate=" + editDate + "]";
	}
	
	

}
