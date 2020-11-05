package UserPackage.src.Entity;

public class Comment {
	private int commentid;
    private String comments;
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Comment(int commentid, String comments) {
		super();
		this.commentid = commentid;
		this.comments = comments;
	}
	public Comment() {
		super();
		// TODO 自动生成的构造函数存根
	}
    
}
