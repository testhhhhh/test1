package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Adminmodel.Book;
import Adminmodel.User;
import util.StringUtil;

/*
 * �û�dao��
 */
public class UserMangeDao {
	//�����û���Ϣ
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

//��ѯ�û���Ϣ
public ResultSet list(Connection conn,User user)throws Exception{
	StringBuffer sb=new StringBuffer("select * from user");
	//��ѯ�û���
	if(StringUtil.isEmpty(user.getUsername())==false) {
		sb.append(" and username like '%"+user.getUsername()+"%'");
	}
	//��ѯ�û�����
	if(StringUtil.isEmpty(user.getName())==false) {
		sb.append(" and name like '%"+user.getName()+"%'");
	}
	//��ѯ�û��Ա�
	if(StringUtil.isEmpty(user.getSex())==false) {
		sb.append(" and sex like '%"+user.getSex()+"%'");
	}
	//��ѯ�û�״̬
	if(StringUtil.isEmpty(user.getState())==false) {
		sb.append(" and state like '%"+user.getState()+"%'");
	}
	PreparedStatement pstmt=conn.prepareStatement(sb.toString().replaceFirst("and","where"));
	return pstmt.executeQuery();
}

//ɾ���û�
public int delete(Connection conn,String user)throws Exception{
	String sql="delete from user where userid=?";
	PreparedStatement pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, user);
	return pstmt.executeUpdate();
}


//�û���Ϣ�޸�
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
