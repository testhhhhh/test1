package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import entity.Ariticle;

public interface ArticleDao {
	public abstract int add(Connection conn,Ariticle article) throws SQLException;
	public abstract ResultSet list(Connection conn,Ariticle article) throws SQLException;
	public abstract int delete(Connection conn,int articleid) throws SQLException;
	public abstract int update(Connection conn,Ariticle article) throws SQLException;
	public abstract boolean articlelist(Connection conn,DefaultListModel<String> d,String way) throws SQLException, Exception;
	public abstract void addPicture(JButton developer, JLabel articlepicturelabel, JTextField articlepicturetext);
	public abstract boolean articleinteractive(Connection conn,String title) throws SQLException;
	public abstract int good(Connection conn,String title) throws SQLException;
	public abstract String contentshow(Connection conn,Ariticle article) throws SQLException;
}
