package entity;

import java.util.Date;

public class Ariticle {
      private int articleid;
      private String title;
      private String content;
      private String writer;
      private String picture;
      private int hot;
      private Date datee;
	public Ariticle() {
		super();
		// TODO 自动生成的构造函数存根
	}
	

	public Ariticle(int articleid, String title, String content, String writer, String picture) {
		super();
		this.articleid = articleid;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.picture = picture;
	}

	public Ariticle(String title, String writer) {
		super();
		this.title = title;
		this.writer = writer;
	}


	public Ariticle(String title) {
		super();
		this.title = title;
	}


	public Ariticle(int articleid, String title, String content, String writer, String picture, int hot, Date datee) {
		super();
		this.articleid = articleid;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.picture = picture;
		this.hot = hot;
		this.datee = datee;
	}


	public int getArticleid() {
		return articleid;
	}
	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public int getHot() {
		return hot;
	}


	public void setHot(int hot) {
		this.hot = hot;
	}


	public Date getDatee() {
		return datee;
	}


	public void setDatee(Date datee) {
		this.datee = datee;
	}


}
