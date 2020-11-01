package daoimplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;

import dao.CollectionDao;
import entity.Ariticle;

public class CollectionImplement implements CollectionDao {
	public DefaultListModel<String> d = new DefaultListModel<String>();

	@Override
	public boolean collectionlist(Connection conn, int userid, DefaultListModel<String> d)throws SQLException, Exception {
		String  sql ="select title from collection,article,user where collection.articleid=article.articleid and collection.userid=user.userid"; 
		Statement Statement = conn.createStatement();
		ResultSet rs = Statement.executeQuery(sql);
		if(rs!=null) {
		while (rs.next()) {
			String title = rs.getString("title");
			d.addElement(title);
			System.out.println(title);
		    }
		return true;
		}
		return false;
	}

	@Override
	public int add(Connection conn, int userid, int articleid) throws SQLException, Exception {
		String sql="insert into collection values(?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql); 
		pstmt.setInt(1,userid);
		pstmt.setInt(2, articleid);
		return pstmt.executeUpdate();
	}

	@Override
	public int delete(Connection conn, int userid, int articleid) throws SQLException, Exception {
		String sql="delete from collection where articleid=? and userid=?";
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setInt(1,articleid);
		pstmt.setInt(2,userid);
		return pstmt.executeUpdate();
	}

	@Override
	public boolean isadd(Connection conn, int userid, int articleid) throws SQLException, Exception {
		String sql = "select * from collection where userid=? and articleid=?";
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setInt(2,articleid);
		pstmt.setInt(1,userid);
		ResultSet rs= pstmt.executeQuery();
		if(rs.next()) {
		return true;
		}
		return false;	
	}
}
