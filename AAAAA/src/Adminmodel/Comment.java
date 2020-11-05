package Adminmodel;

import java.util.Date;

public class Comment {
private int commentid;//评论id
private Integer novelid;//小说id
private String novelname;//小说名称
private Integer userid;//用户id
private String comments;//评论内容
private Date comtime;//评论时间
public Comment() {
	super();
	// TODO Auto-generated constructor stub
}

//查询评论的构造方法
public Comment(Integer novelid) {
	super();
	this.novelid = novelid;
}




public Comment(Integer novelid, Integer userid, String comments, Date comtime) {
	super();
	this.novelid = novelid;
	this.userid = userid;
	this.comments = comments;
	this.comtime = comtime;
}

public int getCommentid() {
	return commentid;
}


public Integer getNovelid() {
	return novelid;
}
public void setCommentid(int commentid) {
	this.commentid = commentid;
}
public void setNovelid(Integer novelid) {
	this.novelid = novelid;
}
public String getNovelname() {
	return novelname;
}
public void setNovelname(String novelname) {
	this.novelname = novelname;
}
public Integer getUserid() {
	return userid;
}
public void setUserid(Integer userid) {
	this.userid = userid;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}


public Date getComtime() {
	return comtime;
}

public void setComtime(Date comtime) {
	this.comtime = comtime;
}



public String toString() {
	return "Comment [commentid=" + commentid + ", userid=" + userid + ", novelid=" +novelid + ", comments=" + comments + ", comtime="
			+ comtime + "]";
}
}
