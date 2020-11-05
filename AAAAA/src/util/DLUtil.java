package util;
/*
 * 数据库工具类
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DLUtil {
	//驱动名称
	 private String driver = "com.mysql.cj.jdbc.Driver";
	 // 获取mysql连接地址
	String url = "jdbc:mysql://localhost:3306/novelsite?&useSSL=false&serverTimezone=UTC&";
	String dbusername = "root";
	String dbpassword = "935538244";
      
    //连接数据库 
     public Connection getCon() {
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
     public void CloseCon(Connection conn) throws Exception {
    	 if(conn!=null) {
    		 conn.close();
    	 }
     }
     
     public static void main(String[] args) {
    	 DLUtil dlu=new DLUtil();
    	try { dlu.getCon();
    	System.out.println("数据库连接成功"); 
     }
    	catch(Exception e2){
    		System.out.println("数据库连接失败");
            e2.printStackTrace();
            }
    }
     }

