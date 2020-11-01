package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.DefaultListModel;

public interface CollectionDao {
	public boolean collectionlist(Connection conn, int userid,DefaultListModel<String> d) throws SQLException, Exception;
	public int add(Connection conn, int userid,int articleid) throws SQLException, Exception;
	public int delete(Connection conn, int userid,int articleid) throws SQLException, Exception;
	public boolean isadd(Connection conn, int userid,int articleid) throws SQLException, Exception;
}
