package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Adminmodel.Admin;
import model.Azmin;
/*
 * 管理员登录————登录验证
 */
public class AdminDao extends BaseDao {

	//连接数据库，操作对象
	public Admin Login(Connection conn,Admin admin)throws Exception {
		String sql="select * from user where username=? and password=?";
		Admin am=null;
			PreparedStatement prst =conn.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1,admin.getUsername());//界面传过去的数据
			prst.setString(2,admin.getPassword());
			ResultSet rs=prst.executeQuery();//ResultSet表示数据库结果集的数据表，通常通过执行查询数据库的语句生成。
			if(rs.next()) {
				//查到就进行实例化
				am=new Admin();
				am.setUserid(rs.getInt("userid"));
				am.setUsername(rs.getString("username"));
				am.setPassword(rs.getString("password"));	
			}	
		return am;
}
	
	//判断是否为管理员
	//连接数据库，操作对象
	public String Panduan(Connection conn,Admin admin)throws Exception {
		String sql="select state from user where username=? and password=?";
		Admin am=null;
			PreparedStatement prst =conn.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1,admin.getUsername());//界面传过去的数据
			prst.setString(2,admin.getPassword());
			ResultSet rs=prst.executeQuery();//ResultSet表示数据库结果集的数据表，通常通过执行查询数据库的语句生成。
			if(rs.next()) {
				//查到就进行实例化
				am=new Admin();
				am.setState(rs.getString("state"));
			}	
			String a=am.getState();
		return a;
}
			}

