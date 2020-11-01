package entity;

public class Comment {
	 private int userid;
	 private int articleid;
     private int commentid;
     private String commentcontent;
	public Comment() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public Comment(int userid, int articleid, int commentid, String commentcontent) {
		super();
		this.userid = userid;
		this.articleid = articleid;
		this.commentid = commentid;
		this.commentcontent = commentcontent;
	}
	

	public Comment(int userid, int articleid, String commentcontent) {
		super();
		this.userid = userid;
		this.articleid = articleid;
		this.commentcontent = commentcontent;
	}

	public Comment(int articleid) {
		super();
		this.articleid = articleid;
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

	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public String getCommentcontent() {
		return commentcontent;
	}
	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}
     
}
