package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Adminmodel.Book;
import util.StringUtil;

/*
 * ͼ��Dao��
 */
public class BookDao {
	
	//С˵���
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


//С˵��Ϣ��ѯ
   public ResultSet list(Connection conn,Book book)throws Exception{
	   StringBuffer sb=new StringBuffer("select * from novel b,classify bt where b.classifyid=bt.classifyid");
	   //���С˵���Ʋ�Ϊ��
	   if(StringUtil.isEmpty(book.getNovelname())==false) {
		   sb.append(" and b.novelname like '%"+book.getNovelname()+"%'");
	   }
	   //������߲�Ϊ��
	   if(StringUtil.isEmpty(book.getNovelwriter())==false) {
		   sb.append(" and b.novelwriter like '%"+book.getNovelwriter()+"%'");
	   }
	   //�û��Ѿ�ѡ����С˵����
	   if(book.getClassifyid()!=null && book.getClassifyid()!=-1) {
		 sb.append(" and b.classifyid="+book.getClassifyid());  
	   }
		PreparedStatement pstmt=conn.prepareStatement(sb.toString());//����֮ǰ���ִ�������Ϊ��and�滻��where������﷨����
		return pstmt.executeQuery();
   }
   
   //С˵��Ϣɾ��
   public int delete(Connection conn,String id)throws Exception{
	   String sql="delete from novel where novelid=?";
	  PreparedStatement pstmt= conn.prepareStatement(sql);
	  pstmt.setString(1,id);
	  return pstmt.executeUpdate();
   }
   
   //С˵��Ϣ�޸�
   public int update(Connection conn,Book book)throws Exception{
	   
	   //sql����������ԭ���Ǽ��˸�С˵�������ƣ���Ϊnovelû��classifyname������ԣ����Իᱨ��
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
   
   //ָ��С˵������Ƿ���С˵
   public boolean existBookByBookTypeId(Connection conn,String booktypeid)throws Exception{
	   String sql="select * from novel where classifyid=?";
	   PreparedStatement pstmt=conn.prepareStatement(sql);
	   pstmt.setString(1,booktypeid);
	   ResultSet rs=pstmt.executeQuery();
	   return rs.next();
   }
   
 
}
