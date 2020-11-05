package UserPackage.src.DaoImple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;

import UserPackage.src.Dao.CommentDao;
import UserPackage.src.Dao.NovelDao;
import UserPackage.src.Entity.Novel;

public class CommentDaoImplement implements CommentDao{
	public DefaultListModel<String> d = new DefaultListModel<String>();
	public Novel nnovel = new Novel();
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/novelsite?&useSSL=false&serverTimezone=UTC";
	String dbusername = "root";
	String dbpassword = "935538244";
	Connection conn = null;
	{
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbusername, dbpassword);
			if (!conn.isClosed())
				System.out.println("数据库连接成功！");
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动加载失败！");
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}//连接数据库
	public boolean commentlist(Object nnovelname, int userid, DefaultListModel<String> d) {
		String sql = "select comments ,username from comment,user ,novel where novel.novelid=comment.novelid and novelname like ? and user.userid=comment.userid;";
		String comments=null;
		String username;
		ResultSet rs = null;
		try {
			Date date=new Date();
		    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, (String)nnovelname);
			rs = pst.executeQuery();
			while (rs.next()) {
				comments = rs.getString("comments");
				username=rs.getString("username");
				d.addElement("["+df.format(date)+"]"+username+":"+"   "+comments);
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	public boolean commentupload(int novelid, int userid, String comments) {
		String sql = "insert into comment values(?,?,?,?);";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1,0);
			pst.setInt(2, novelid);
			pst.setInt(3, userid);
			pst.setString(4, comments);
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}



	
}
