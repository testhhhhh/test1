package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Adminmodel.Comment;

/*
 * 评论Dao类
 */
public class CommentDao {
//评论信息查询
	public ResultSet list(Connection conn,Comment comment)throws Exception{
		StringBuffer sb=new StringBuffer("select * from comment c,novel n where c.novelid=n.novelid");
		//如果查询小说名称
		if(comment.getNovelid()!=null &&comment.getNovelid()!=-1) {
			
			//打死都不会想到出错是and前面没有空格
			sb.append(" and c.novelid="+comment.getNovelid());
		}
		PreparedStatement pstmt=conn.prepareStatement(sb.toString());//这里之前出现错误，是因为把and替换成where，造成语法错误
		return pstmt.executeQuery();
	}
	
	
	   //评论信息删除
	   public int delete(Connection conn,String id)throws Exception{
		   String sql="delete from comment where commentid=?";
		  PreparedStatement pstmt= conn.prepareStatement(sql);
		  pstmt.setString(1,id);
		  return pstmt.executeUpdate();
	   }
}
