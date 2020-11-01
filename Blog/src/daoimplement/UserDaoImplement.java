package daoimplement;

import java.awt.FontMetrics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;

import dao.UserDao;
import entity.User;
import inputcheck.InputOrNot;

public class UserDaoImplement implements UserDao {
	public static int userid;
	public User user = new User();

	@Override
	public int add(Connection conn, User user) throws SQLException {
		String sql="insert into user values(0,?,?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2,user.getPassword());
		pstmt.setString(3, user.getPhone());
		pstmt.setInt(4,user.getRights());
		pstmt.setString(5, user.getCode());
		pstmt.setString(6, user.getUserintroduce());
		return pstmt.executeUpdate();
	}

	@Override
	public ResultSet list(Connection conn, User user) throws SQLException {
		StringBuffer sb=new StringBuffer("select * from user");
		//查询用户状态
		if(user.getRights()!=0) {
			sb.append(" and rights ="+user.getRights());
		}		
		//查询用户名
		if(InputOrNot.isEmpty(user.getUsername())==false) {
			sb.append(" and username like '%"+user.getUsername()+"%'");
		}
	    PreparedStatement pstmt=conn.prepareStatement(sb.toString().replaceFirst("and","where"));
		return pstmt.executeQuery();
	}

	@Override
	public int delete(Connection conn, int userid) throws SQLException {
		String sql="delete from user where userid=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, userid);
		return pstmt.executeUpdate();
	}

	@Override
	public int update(Connection conn, User user) throws SQLException {
		String sql="update user set username=?,password=?,phone=?,rights=?,code=?,userintroduce=? where userid=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3,user.getPhone());
		pstmt.setInt(4, user.getRights());
		pstmt.setString(5,user.getCode());
		pstmt.setString(6,user.getUserintroduce());
		pstmt.setInt(7, user.getUserid());
		return pstmt.executeUpdate();
	}

	@Override
	public int isRegisted(Connection conn, String username) throws SQLException {	
		String sql = "select userid from user where username=?;";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		if (rs != null) { 
		while (rs.next()) {
			userid=rs.getInt("userid");
			System.out.println(userid);
			return rs.getInt("userid");}
		 
		}
		return 0;
	}

	@Override
	public int isLogin(Connection conn, User user) throws SQLException {
		String sql = "select userid from user where username=? and password=? and rights=? ;";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.setInt(3,user.getRights());
		ResultSet rs = pstmt.executeQuery();
		if (rs != null) { 
		while (rs.next()) {
			return rs.getInt("userid"); 
			}
		
		}
		return 0;
	}
	
	public boolean userinteractive(Connection conn,int userid) throws SQLException {
		String sql = "select userid,username,phone,userintroduce from user where userid=? and rights=1;";
		ResultSet rs = null;
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1,userid);
			rs = pst.executeQuery();
			while (rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setPhone(rs.getString("phone"));
				user.setUserintroduce(rs.getString("userintroduce"));
				return true;
			}
		return false;
	}

	@Override
	public void JlabelSetText(JLabel jLabel, String longString) {
		StringBuilder builder = new StringBuilder("<html>");
		char[] chars = longString.toCharArray();
		FontMetrics fontMetrics = jLabel.getFontMetrics(jLabel.getFont());
		int start = 0;
		int len = 0;
		while (start + len < longString.length()) {
			while (true) {
				len++;
				if (start + len > longString.length())
					break;
				if (fontMetrics.charsWidth(chars, start, len) > jLabel.getWidth()) {
					break;
				}
			}
			builder.append(chars, start, len - 1).append("<br/>");
			start = start + len - 1;
			len = 0;
		}
		builder.append(chars, start, longString.length() - start);
		builder.append("</html>");
		jLabel.setText(builder.toString());
	}
}
