package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Adminmodel.Book;
import util.StringUtil;

/*
 * 图书Dao类
 */
public class BookDao {
	
	//小说添加
public int add(Connection conn,Book book)throws Exception{
	String sql="insert into novel values(null,?,?,?,?,?,?)";
	PreparedStatement pstmt=conn.prepareStatement(sql);
	pstmt.setInt(1, book.getClassifyid());
	pstmt.setString(2, book.getNovelname());
	pstmt.setString(3, book.getNovelmain());
	pstmt.setString(4, book.getNovelwriter());
	pstmt.setString(5,book.getNovelpicture());
	pstmt.setFloat(6, book.getNovelmoney());
	return pstmt.executeUpdate();
}


//小说信息查询
   public ResultSet list(Connection conn,Book book)throws Exception{
	   StringBuffer sb=new StringBuffer("select * from novel b,classify bt where b.classifyid=bt.classifyid");
	   //如果小说名称不为空
	   if(StringUtil.isEmpty(book.getNovelname())==false) {
		   sb.append(" and b.novelname like '%"+book.getNovelname()+"%'");
	   }
	   //如果作者不为空
	   if(StringUtil.isEmpty(book.getNovelwriter())==false) {
		   sb.append(" and b.novelwriter like '%"+book.getNovelwriter()+"%'");
	   }
	   //用户已经选择了小说类型
	   if(book.getClassifyid()!=null && book.getClassifyid()!=-1) {
		 sb.append(" and b.classifyid="+book.getClassifyid());  
	   }
		PreparedStatement pstmt=conn.prepareStatement(sb.toString());//这里之前出现错误，是因为把and替换成where，造成语法错误
		return pstmt.executeQuery();
   }
   
   //小说信息删除
   public int delete(Connection conn,String id)throws Exception{
	   String sql="delete from novel where novelid=?";
	  PreparedStatement pstmt= conn.prepareStatement(sql);
	  pstmt.setString(1,id);
	  return pstmt.executeUpdate();
   }
   
   //小说信息修改
   public int update(Connection conn,Book book)throws Exception{
	   
	   //sql这里出错过，原因是加了个小说分类名称，因为novel没有classifyname这个属性，所以会报错
	   String sql="update novel set classifyid=?,novelname=?,novelmain=?,novelwriter=?,novelpicture=?,novelmoney=? where novelid=?";
	   PreparedStatement pstmt=conn.prepareStatement(sql);
	   pstmt.setInt(1, book.getClassifyid());
	   pstmt.setString(2, book.getNovelname());
	   pstmt.setString(3,book.getNovelmain());
	   pstmt.setString(4, book.getNovelwriter());
	   pstmt.setString(5,book.getNovelpicture());
	   pstmt.setFloat(6, book.getNovelmoney());
//	   pstmt.setString(6, book.getClassifyname());
	
	   pstmt.setInt(7, book.getNovelid());
	   return pstmt.executeUpdate();
   }
   
   //指定小说类别下是否有小说
   public boolean existBookByBookTypeId(Connection conn,String booktypeid)throws Exception{
	   String sql="select * from novel where classifyid=?";
	   PreparedStatement pstmt=conn.prepareStatement(sql);
	   pstmt.setString(1,booktypeid);
	   ResultSet rs=pstmt.executeQuery();
	   return rs.next();
   }
   
 
}
