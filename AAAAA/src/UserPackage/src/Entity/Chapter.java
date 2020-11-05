package UserPackage.src.Entity;

public class Chapter {
      private String chaptername;
      private String chaptercontent;
	public Chapter(String chaptername, String chaptercontent) {
		super();
		this.chaptername = chaptername;
		this.chaptercontent = chaptercontent;
	}
	public Chapter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getChaptername() {
		return chaptername;
	}
	public void setChaptername(String chaptername) {
		this.chaptername = chaptername;
	}
	public String getChaptercontent() {
		return chaptercontent;
	}
	public void setChaptercontent(String chaptercontent) {
		this.chaptercontent = chaptercontent;
	}
      
}
