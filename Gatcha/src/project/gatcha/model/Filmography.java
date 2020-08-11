package project.gatcha.model;

public class Filmography {
	private int id;
	private String kfaActorIdSum;
	private String directorKfaId;
	private String movieKfaId;
	private int memberId;
	private String likes;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKfaActorIdSum() {
		return kfaActorIdSum;
	}
	public void setKfaActorIdSum(String kfaActorIdSum) {
		this.kfaActorIdSum = kfaActorIdSum;
	}
	public String getDirectorKfaId() {
		return directorKfaId;
	}
	public void setDirectorKfaId(String directorKfaId) {
		this.directorKfaId = directorKfaId;
	}
	public String getMovieKfaId() {
		return movieKfaId;
	}
	public void setMovieKfaId(String movieKfaId) {
		this.movieKfaId = movieKfaId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getLikes() {
		return likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	
	@Override
	public String toString() {
		return "Filmography [id=" + id + ", kfaActorIdSum=" + kfaActorIdSum + ", directorKfaId=" + directorKfaId
				+ ", movieKfaId=" + movieKfaId + ", memberId=" + memberId + ", likes=" + likes + "]";
	}
	
}
