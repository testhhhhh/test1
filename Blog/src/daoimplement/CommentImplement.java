package daoimplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;

import dao.CommentDao;
import entity.Comment;

public class CommentImplement implements CommentDao {
	public DefaultListModel<String> d = new DefaultListModel<String>();

	@Override
	public ResultSet list(Connection conn, Comment comment) throws SQLException {
		StringBuffer sb=new StringBuffer("select * from comment,article,user where comment.articleid=article.articleid and comment.userid=user.userid");
		//如果查询小说名称
		if(comment.getArticleid()!=0 &&comment.getArticleid()!=-1) {
			sb.append(" and comment.articleid="+comment.getArticleid());
		}
		PreparedStatement pstmt=conn.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}

	@Override
	public int delete(Connection conn, String commentid) throws SQLException {
	    String sql="delete from comment where commentid=?";
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setString(1,commentid);
		return pstmt.executeUpdate();
	}

	@Override
	public boolean commentlist(Connection conn, String title, int userid, DefaultListModel<String> d) throws Exception {
		String sql = "select commentcontent,username from comment,user,article where article.articleid=comment.articleid and title like ? and user.userid=comment.userid;";
		ResultSet rs = null;
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, title);
		rs = pst.executeQuery();
		if (rs != null) { 
		while (rs.next()) {
			String commentcontent = rs.getString("commentcontent");
			String username=rs.getString("username");
			d.addElement(username+":"+"   "+commentcontent);
			
		   }	
		return true;
		}
		return false;
	}

	@Override
	public int add(Connection conn, Comment comment) throws SQLException {
		String sql = "insert into comment values(?,?,?,?);";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1,comment.getUserid());
		pst.setInt(2, comment.getArticleid());
		pst.setInt(3, comment.getCommentid());
		pst.setString(4, comment.getCommentcontent());	
		return pst.executeUpdate();
		
	}

}
