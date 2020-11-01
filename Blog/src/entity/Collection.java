package entity;

public class Collection {
	private int userid;
	 private int articleid;
	public Collection(int userid, int articleid) {
		super();
		this.userid = userid;
		this.articleid = articleid;
	}
	public Collection() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getArticleid() {
		return articleid;
	}
	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}
	
}
