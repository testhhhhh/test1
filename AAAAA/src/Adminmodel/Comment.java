package Adminmodel;

import java.util.Date;

public class Comment {
private int commentid;//����id
private Integer novelid;//С˵id
private String novelname;//С˵����
private Integer userid;//�û�id
private String comments;//��������
private Date comtime;//����ʱ��
public Comment() {
	super();
	// TODO Auto-generated constructor stub
}

//��ѯ���۵Ĺ��췽��
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
