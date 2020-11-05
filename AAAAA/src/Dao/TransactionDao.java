package Dao;

/*
 * 交易Dao类
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Adminmodel.Transaction;


public class TransactionDao {
	//交易信息查询
		public ResultSet list(Connection conn,Transaction transaction)throws Exception{
			StringBuffer sb=new StringBuffer("select * from transaction t,novel n where t.novelid=n.novelid");
			//如果查询小说名称
			if(transaction.getNovelid()!=null &&transaction.getNovelid()!=-1) {
				
				//打死都不会想到出错是and前面没有空格
				sb.append(" and t.novelid="+transaction.getNovelid());
			}
			PreparedStatement pstmt=conn.prepareStatement(sb.toString());//这里之前出现错误，是因为把and替换成where，造成语法错误
			return pstmt.executeQuery();
		}
		
		 //交易信息删除
		   public int delete(Connection conn,String id)throws Exception{
			   String sql="delete from transaction where transactionid=?";
			  PreparedStatement pstmt= conn.prepareStatement(sql);
			  pstmt.setString(1,id);
			  return pstmt.executeUpdate();
		   }	
}
