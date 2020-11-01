package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;

import entity.Comment;

public interface CommentDao {
	public abstract ResultSet list(Connection conn,Comment comment) throws SQLException;
	public abstract int delete(Connection conn,String commentid) throws SQLException;
	public boolean commentlist(Connection conn,String title, int userid,DefaultListModel<String> d) throws SQLException, Exception;
	public int add(Connection conn,Comment comment) throws SQLException ;
}
