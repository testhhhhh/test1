package Dao;

/*
 * ����Dao��
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Adminmodel.Transaction;


public class TransactionDao {
	//������Ϣ��ѯ
		public ResultSet list(Connection conn,Transaction transaction)throws Exception{
			StringBuffer sb=new StringBuffer("select * from transaction t,novel n where t.novelid=n.novelid");
			//�����ѯС˵����
			if(transaction.getNovelid()!=null &&transaction.getNovelid()!=-1) {
				
				//�����������뵽������andǰ��û�пո�
				sb.append(" and t.novelid="+transaction.getNovelid());
			}
			PreparedStatement pstmt=conn.prepareStatement(sb.toString());//����֮ǰ���ִ�������Ϊ��and�滻��where������﷨����
			return pstmt.executeQuery();
		}
		
		 //������Ϣɾ��
		   public int delete(Connection conn,String id)throws Exception{
			   String sql="delete from transaction where transactionid=?";
			  PreparedStatement pstmt= conn.prepareStatement(sql);
			  pstmt.setString(1,id);
			  return pstmt.executeUpdate();
		   }	
}
