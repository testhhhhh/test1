package UserPackage.src.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Adminmodel.Book;
import Adminmodel.BookType;
import Adminmodel.User;
import UserPackage.src.Entity.Money;
import util.DLUtil;
import util.StringUtil;

/*
 * 金额Dao类
 */
public class MoneyDao {
	public static int userid;
	public static Object money;
	//金额添加
public int add(Connection conn,Money money)throws Exception{
	String sql="insert into money values(null,?,?)";
	PreparedStatement pstmt=conn.prepareStatement(sql);
	pstmt.setInt(1,money.getUserid());
	pstmt.setDouble(2, money.getMoney());
	return pstmt.executeUpdate();}
	
//查询金额
	public ResultSet list(Connection conn,Money money)throws Exception{
		StringBuffer sb=new StringBuffer("select money from money m,user u where m.userid=u.userid");
		if(money.getUserid()!=null &&money.getUserid()!=-1) {
			sb.append(" and m.userid="+money.getUserid());
		}
		PreparedStatement pstmt=conn.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}

	//信息修改
	   public int update(Connection conn,Money money)throws Exception{
		   String sql="update money set userid=?,money=? where moneyid=?";
		   PreparedStatement pstmt=conn.prepareStatement(sql);
		   pstmt.setInt(1, money.getUserid());
		   pstmt.setDouble(2, money.getMoney());
		   pstmt.setInt(3,money.getMoneyid());
		   return pstmt.executeUpdate();}
	
	
}
