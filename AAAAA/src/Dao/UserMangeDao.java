package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Adminmodel.Book;
import Adminmodel.User;
import util.StringUtil;

/*
 * 用户dao类
 */
public class UserMangeDao {
	//插入用户信息
public int add(Connection conn,User user)throws Exception{
	String sql="insert into user values(null,?,?,?,?,?,?,?)";
	PreparedStatement pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, user.getUsername());
	pstmt.setString(2,user.getPassword());
	pstmt.setString(3, user.getName());
	pstmt.setString(4,user.getSex());
	pstmt.setString(5, user.getTelephone());
	pstmt.setString(6, user.getState());
	pstmt.setString(7, user.getCode());
	return pstmt.executeUpdate();
}

//查询用户信息
public ResultSet list(Connection conn,User user)throws Exception{
	StringBuffer sb=new StringBuffer("select * from user");
	//查询用户名
	if(StringUtil.isEmpty(user.getUsername())==false) {
		sb.append(" and username like '%"+user.getUsername()+"%'");
	}
	//查询用户姓名
	if(StringUtil.isEmpty(user.getName())==false) {
		sb.append(" and name like '%"+user.getName()+"%'");
	}
	//查询用户性别
	if(StringUtil.isEmpty(user.getSex())==false) {
		sb.append(" and sex like '%"+user.getSex()+"%'");
	}
	//查询用户状态
	if(StringUtil.isEmpty(user.getState())==false) {
		sb.append(" and state like '%"+user.getState()+"%'");
	}
	PreparedStatement pstmt=conn.prepareStatement(sb.toString().replaceFirst("and","where"));
	return pstmt.executeQuery();
}

//删除用户
public int delete(Connection conn,String user)throws Exception{
	String sql="delete from user where userid=?";
	PreparedStatement pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, user);
	return pstmt.executeUpdate();
}


//用户信息修改
public int update(Connection conn,User user)throws Exception{
	   String sql="update user set username=?,password=?,name=?,sex=?,telephone=?,state=? where userid=?";
	   PreparedStatement pstmt=conn.prepareStatement(sql);
	   pstmt.setString(1, user.getUsername());
	   pstmt.setString(2, user.getPassword());
	   pstmt.setString(3,user.getName());
	   pstmt.setString(4, user.getSex());
	   pstmt.setString(5,user.getTelephone());
	   pstmt.setString(6,user.getState());
	   pstmt.setInt(7, user.getUserid());
	   return pstmt.executeUpdate();
}
}
