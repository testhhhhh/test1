package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Adminmodel.Comment;

/*
 * ����Dao��
 */
public class CommentDao {
//������Ϣ��ѯ
	public ResultSet list(Connection conn,Comment comment)throws Exception{
		StringBuffer sb=new StringBuffer("select * from comment c,novel n where c.novelid=n.novelid");
		//�����ѯС˵����
		if(comment.getNovelid()!=null &&comment.getNovelid()!=-1) {
			
			//�����������뵽������andǰ��û�пո�
			sb.append(" and c.novelid="+comment.getNovelid());
		}
		PreparedStatement pstmt=conn.prepareStatement(sb.toString());//����֮ǰ���ִ�������Ϊ��and�滻��where������﷨����
		return pstmt.executeQuery();
	}
	
	
	   //������Ϣɾ��
	   public int delete(Connection conn,String id)throws Exception{
		   String sql="delete from comment where commentid=?";
		  PreparedStatement pstmt= conn.prepareStatement(sql);
		  pstmt.setString(1,id);
		  return pstmt.executeUpdate();
	   }
}
