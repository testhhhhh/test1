package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DLUtil {
	//��������
		 private static String driver = "com.mysql.jdbc.Driver";
		 // ��ȡmysql���ӵ�ַ
		static String url = "jdbc:mysql://localhost:3307/blog";
		static String dbusername = "root";
		static String dbpassword = "935538244";
	      
	    //�������ݿ� 
	     public static Connection getCon() {
	              try {
					Class.forName(driver);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					  System.out.println("���ݿ���������ʧ�ܣ�");
					e.printStackTrace();
				}
	             
	    	  Connection conn = null;
	    	  try {
	              //getConnection()����������MySQL���ݿ⣡ 
	              
	              conn=DriverManager.getConnection(url,dbusername,dbpassword);
	      }
	              catch(SQLException e1){
	                  //���ݿ�����ʧ���쳣����
	                   e1.printStackTrace();
	                  }
	    return conn;  }
	     
	     //�ر����ݿ�����
	     public static void CloseCon(Connection conn) throws Exception {
	    	 if(conn!=null) {
	    		 conn.close();
	    	 }
	     }
	     
}
