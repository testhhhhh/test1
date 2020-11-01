package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DLUtil {
	//驱动名称
		 private static String driver = "com.mysql.jdbc.Driver";
		 // 获取mysql连接地址
		static String url = "jdbc:mysql://localhost:3307/blog";
		static String dbusername = "root";
		static String dbpassword = "935538244";
	      
	    //连接数据库 
	     public static Connection getCon() {
	              try {
					Class.forName(driver);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					  System.out.println("数据库驱动加载失败！");
					e.printStackTrace();
				}
	             
	    	  Connection conn = null;
	    	  try {
	              //getConnection()方法，连接MySQL数据库！ 
	              
	              conn=DriverManager.getConnection(url,dbusername,dbpassword);
	      }
	              catch(SQLException e1){
	                  //数据库连接失败异常处理
	                   e1.printStackTrace();
	                  }
	    return conn;  }
	     
	     //关闭数据库连接
	     public static void CloseCon(Connection conn) throws Exception {
	    	 if(conn!=null) {
	    		 conn.close();
	    	 }
	     }
	     
}
