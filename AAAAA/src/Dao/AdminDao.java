package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Adminmodel.Admin;
import model.Azmin;
/*
 * ����Ա��¼����������¼��֤
 */
public class AdminDao extends BaseDao {

	//�������ݿ⣬��������
	public Admin Login(Connection conn,Admin admin)throws Exception {
		String sql="select * from user where username=? and password=?";
		Admin am=null;
			PreparedStatement prst =conn.prepareStatement(sql);//��sql��䴫�����ݿ��������
			prst.setString(1,admin.getUsername());//���洫��ȥ������
			prst.setString(2,admin.getPassword());
			ResultSet rs=prst.executeQuery();//ResultSet��ʾ���ݿ����������ݱ�ͨ��ͨ��ִ�в�ѯ���ݿ��������ɡ�
			if(rs.next()) {
				//�鵽�ͽ���ʵ����
				am=new Admin();
				am.setUserid(rs.getInt("userid"));
				am.setUsername(rs.getString("username"));
				am.setPassword(rs.getString("password"));	
			}	
		return am;
}
	
	//�ж��Ƿ�Ϊ����Ա
	//�������ݿ⣬��������
	public String Panduan(Connection conn,Admin admin)throws Exception {
		String sql="select state from user where username=? and password=?";
		Admin am=null;
			PreparedStatement prst =conn.prepareStatement(sql);//��sql��䴫�����ݿ��������
			prst.setString(1,admin.getUsername());//���洫��ȥ������
			prst.setString(2,admin.getPassword());
			ResultSet rs=prst.executeQuery();//ResultSet��ʾ���ݿ����������ݱ�ͨ��ͨ��ִ�в�ѯ���ݿ��������ɡ�
			if(rs.next()) {
				//�鵽�ͽ���ʵ����
				am=new Admin();
				am.setState(rs.getString("state"));
			}	
			String a=am.getState();
		return a;
}
			}

