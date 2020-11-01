package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;

import entity.User;


public interface UserDao {
	public abstract int add(Connection conn,User user) throws SQLException;
	public abstract ResultSet list(Connection conn,User user) throws SQLException;
	public abstract int delete(Connection conn,int userid) throws SQLException;
	public abstract int update(Connection conn,User user) throws SQLException;
	public abstract int isRegisted(Connection conn,String username) throws SQLException;
	public abstract int isLogin(Connection conn, User user) throws SQLException;
	public abstract void JlabelSetText(JLabel jLabel, String longString);
	public abstract boolean userinteractive(Connection conn,int userid) throws SQLException;
	
	
}
