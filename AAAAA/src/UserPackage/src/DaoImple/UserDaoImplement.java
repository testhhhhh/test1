package UserPackage.src.DaoImple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import UserPackage.src.Dao.UserDao;
import UserPackage.src.Entity.Money;
import UserPackage.src.Entity.User;

public class UserDaoImplement implements UserDao {
	public static int userid;
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
				System.out.println("���ݿ����ӳɹ���");
		} catch (ClassNotFoundException e) {
			System.out.println("���ݿ���������ʧ�ܣ�");
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}//�������ݿ�

	public boolean isLogin(String uusername, String upassword) {
		Statement Statement = null;
		try {
			Statement = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "select username,password from user;";
		String sql2 = "select userid from user where username =?; ";
		String username, password;
		ResultSet rs = null;
		ResultSet rs2 = null;
		try {
			rs = Statement.executeQuery(sql);
			while (rs.next()) {
				username = rs.getString("username");
				password = rs.getString("password");
				if (uusername.equals(username) && upassword.equals(password)) {
					PreparedStatement pst = conn.prepareStatement(sql2);
					pst.setString(1, username);
					rs2 = pst.executeQuery();
					while (rs2.next()) {
						userid = rs2.getInt("userid");
						System.out.println(userid);
					}
					return true;

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}//�û���¼����

	public boolean regist(User user) {
		boolean flag = false;
		if (isRegisted(user.getUsername())) {
			return flag;
		}
		String sql = "insert into user values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, 0);
			pst.setString(2, user.getUsername());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getName());
			pst.setString(5, user.getSex());
			pst.setString(6, user.getTelephone());
			pst.setInt(7, 1);
			pst.setInt(8, user.getCode());
			pst.executeUpdate();// ��������
			flag = true;
		} catch (SQLException e) {// ִ�������ݿ⽨��������Ҫ�׳�SQL�쳣
			e.printStackTrace();
		}
		return flag;
	}//�û�ע�᷽��

	
	public boolean isRegisted(String uusername) {
		Statement Statement = null;
		try {
			Statement = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "select username from user;";
		String username;
		ResultSet rs = null;
		try {
			rs = Statement.executeQuery(sql);
			while (rs.next()) {
				username = rs.getString("username");
				if (uusername.equals(username)) {
					return true;
				}
			}
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
	}//�ж��û��Ƿ��Ѿ�ע�᷽��


	public boolean personalchange(String username, String password, String name, String sex, String telephone) {
		boolean flag = false;
		if (isRegisted(username)) {
			return flag;
		}
		String sql = "update user set username = ?,password=?,name =?,sex=?,telephone=? where userid = ?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, name);
			pst.setString(4, sex);
			pst.setString(5, telephone);
			pst.setInt(6, userid);
			int result = pst.executeUpdate();// ����ֵ�����յ�Ӱ�������
			if (result > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	//����������Ϣ�ı䷽��


	public boolean upDateMoney(double money) {
		boolean flag = false;
		String sql = "update money set moeny=? where userid = ?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setDouble(1, money);
			pst.setInt(2,userid);
			int result = pst.executeUpdate();// ����ֵ�����յ�Ӱ�������
			if (result > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}


	
	

}
