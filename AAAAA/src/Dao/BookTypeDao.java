package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Adminmodel.BookType;
import util.StringUtil;

/*
 * 小说类别Dao类
 */
public class BookTypeDao {
public int addBookType(Connection conn,BookType booktype)throws Exception{
	String sql="insert into classify values(null,?)";
	PreparedStatement pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, booktype.getClassifyname());
	return pstmt.executeUpdate();
}

/*
 * 查询小说类别集合
 */
public ResultSet list(Connection conn,BookType bookType)throws Exception{
	StringBuffer sb=new StringBuffer("select * from classify");
	if((StringUtil.isEmpty(bookType.getClassifyname()))==false) {
		sb.append(" and classifyname like '%"+bookType.getClassifyname()+"%'");	
	}
	PreparedStatement pstmt=conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
	return pstmt.executeQuery();
}

//删除小说类别
public int delete(Connection conn,String classify)throws Exception{
	String sql="delete from classify where classifyid=?";
	PreparedStatement pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, classify);
	return pstmt.executeUpdate();
}
//修改图书类别
public int update(Connection conn,BookType bookType)throws Exception{
	String sql="update classify set classifyname=? where classifyid=?";
	PreparedStatement pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, bookType.getClassifyname());
	pstmt.setInt(2, bookType.getClassifyid());
	return pstmt.executeUpdate();
}
}
