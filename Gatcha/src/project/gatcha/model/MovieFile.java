package project.gatcha.model;

public class MovieFile {

	 private int id;
	 private String movieKfaId;
	 private String originName;
	 private String fileUrl;
	 private String fileName;
	 private String contentType;
	 private int fileSize;
	 private String fileCategory;
	 private String regDate;
	 private String editDate;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieKfaId() {
		return movieKfaId;
	}
	public void setMovieKfaId(String movieKfaId) {
		this.movieKfaId = movieKfaId;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileCategory() {
		return fileCategory;
	}
	public void setFileCategory(String fileCategory) {
		this.fileCategory = fileCategory;
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
		return "MovieFile [id=" + id + ", movieKfaId=" + movieKfaId + ", originName=" + originName + ", fileUrl="
				+ fileUrl + ", fileName=" + fileName + ", contentType=" + contentType + ", fileSize=" + fileSize
				+ ", fileCategory=" + fileCategory + ", regDate=" + regDate + ", editDate=" + editDate + "]";
	}
	 
	
}
