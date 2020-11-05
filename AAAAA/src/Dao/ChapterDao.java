package Dao;
/*
 * 章节dao类
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Adminmodel.Book;
import Adminmodel.Chapter;
import util.StringUtil;

public class ChapterDao {
	//章节信息添加
public int add(Connection conn,Chapter chapter)throws Exception{
	String sql="insert into chapter values(null,?,?,?)";
	PreparedStatement pstmt=conn.prepareStatement(sql);
	pstmt.setInt(1,chapter.getNovelid());
	pstmt.setString(2, chapter.getChaptername());
	pstmt.setString(3, chapter.getChaptercontent());
	return pstmt.executeUpdate();
}

//章节信息查询
public ResultSet list(Connection conn,Chapter chapter)throws Exception{
	   StringBuffer sb=new StringBuffer("select * from novel b,chapter bt where b.novelid=bt.novelid");
	   //如果章节名称不为空
	   if(StringUtil.isEmpty(chapter.getChaptername())==false) {
		   sb.append(" and bt.chaptername like '%"+chapter.getChaptername()+"%'");
	   }
	   //如果内容不为空
	   if(StringUtil.isEmpty(chapter.getChaptercontent())==false) {
		   sb.append(" and bt.chaptercontent like '%"+chapter.getChaptercontent()+"%'");
	   }
	   //用户已经选择了小说名称
	   if(chapter.getNovelid()!=null&&chapter.getNovelid()!=-1) {
		 sb.append(" and bt.novelid="+chapter.getNovelid());  
	   }
		PreparedStatement pstmt=conn.prepareStatement(sb.toString());//这里之前出现错误，是因为把and替换成where，造成语法错误
		return pstmt.executeQuery();
}

//章节信息修改
public int update(Connection conn,Chapter chapter)throws Exception{
	   
	   //sql这里出错过，原因是加了个小说分类名称，因为novel没有classifyname这个属性，所以会报错
	   String sql="update chapter set novelid=?,chaptername=?,chaptercontent=? where chapterid=?";
	   PreparedStatement pstmt=conn.prepareStatement(sql);
	   pstmt.setInt(1, chapter.getNovelid());
	   pstmt.setString(2, chapter.getChaptername());
	   pstmt.setString(3,chapter.getChaptercontent());
	   pstmt.setInt(4, chapter.getChapterid());
	   return pstmt.executeUpdate();
}

//章节信息删除
public int delete(Connection conn,String id)throws Exception{
	   String sql="delete from chapter where chapterid=?";
	  PreparedStatement pstmt= conn.prepareStatement(sql);
	  pstmt.setString(1,id);
	  return pstmt.executeUpdate();
}

//指定小说下是否有章节
public boolean existBook(Connection conn,String bookid)throws Exception{
	   String sql="select * from chapter where novelid=?";
	   PreparedStatement pstmt=conn.prepareStatement(sql);
	   pstmt.setString(1,bookid);
	   ResultSet rs=pstmt.executeQuery();
	   return rs.next();
}
}
