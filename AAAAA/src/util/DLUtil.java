package util;
/*
 * ���ݿ⹤����
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DLUtil {
	//��������
	 private String driver = "com.mysql.cj.jdbc.Driver";
	 // ��ȡmysql���ӵ�ַ
	String url = "jdbc:mysql://localhost:3306/novelsite?&useSSL=false&serverTimezone=UTC&";
	String dbusername = "root";
	String dbpassword = "935538244";
      
    //�������ݿ� 
     public Connection getCon() {
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
     public void CloseCon(Connection conn) throws Exception {
    	 if(conn!=null) {
    		 conn.close();
    	 }
     }
     
     public static void main(String[] args) {
    	 DLUtil dlu=new DLUtil();
    	try { dlu.getCon();
    	System.out.println("���ݿ����ӳɹ�"); 
     }
    	catch(Exception e2){
    		System.out.println("���ݿ�����ʧ��");
            e2.printStackTrace();
            }
    }
     }

