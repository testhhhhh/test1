package Dao;
/*
 * �½�dao��
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Adminmodel.Book;
import Adminmodel.Chapter;
import util.StringUtil;

public class ChapterDao {
	//�½���Ϣ���
public int add(Connection conn,Chapter chapter)throws Exception{
	String sql="insert into chapter values(null,?,?,?)";
	PreparedStatement pstmt=conn.prepareStatement(sql);
	pstmt.setInt(1,chapter.getNovelid());
	pstmt.setString(2, chapter.getChaptername());
	pstmt.setString(3, chapter.getChaptercontent());
	return pstmt.executeUpdate();
}

//�½���Ϣ��ѯ
public ResultSet list(Connection conn,Chapter chapter)throws Exception{
	   StringBuffer sb=new StringBuffer("select * from novel b,chapter bt where b.novelid=bt.novelid");
	   //����½����Ʋ�Ϊ��
	   if(StringUtil.isEmpty(chapter.getChaptername())==false) {
		   sb.append(" and bt.chaptername like '%"+chapter.getChaptername()+"%'");
	   }
	   //������ݲ�Ϊ��
	   if(StringUtil.isEmpty(chapter.getChaptercontent())==false) {
		   sb.append(" and bt.chaptercontent like '%"+chapter.getChaptercontent()+"%'");
	   }
	   //�û��Ѿ�ѡ����С˵����
	   if(chapter.getNovelid()!=null&&chapter.getNovelid()!=-1) {
		 sb.append(" and bt.novelid="+chapter.getNovelid());  
	   }
		PreparedStatement pstmt=conn.prepareStatement(sb.toString());//����֮ǰ���ִ�������Ϊ��and�滻��where������﷨����
		return pstmt.executeQuery();
}

//�½���Ϣ�޸�
public int update(Connection conn,Chapter chapter)throws Exception{
	   
	   //sql����������ԭ���Ǽ��˸�С˵�������ƣ���Ϊnovelû��classifyname������ԣ����Իᱨ��
	   String sql="update chapter set novelid=?,chaptername=?,chaptercontent=? where chapterid=?";
	   PreparedStatement pstmt=conn.prepareStatement(sql);
	   pstmt.setInt(1, chapter.getNovelid());
	   pstmt.setString(2, chapter.getChaptername());
	   pstmt.setString(3,chapter.getChaptercontent());
	   pstmt.setInt(4, chapter.getChapterid());
	   return pstmt.executeUpdate();
}

//�½���Ϣɾ��
public int delete(Connection conn,String id)throws Exception{
	   String sql="delete from chapter where chapterid=?";
	  PreparedStatement pstmt= conn.prepareStatement(sql);
	  pstmt.setString(1,id);
	  return pstmt.executeUpdate();
}

//ָ��С˵���Ƿ����½�
public boolean existBook(Connection conn,String bookid)throws Exception{
	   String sql="select * from chapter where novelid=?";
	   PreparedStatement pstmt=conn.prepareStatement(sql);
	   pstmt.setString(1,bookid);
	   ResultSet rs=pstmt.executeQuery();
	   return rs.next();
}
}
