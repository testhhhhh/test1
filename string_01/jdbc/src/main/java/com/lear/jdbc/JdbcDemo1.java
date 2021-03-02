package com.lear.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 程序的耦合
 *      耦合，程序间的依赖关系
 *          包括：类之间的依赖，方法间的依赖
 *      解耦：降低程序间的依赖关系
 *      实际开发中应该做到编译器不依赖，运行时依赖，
 *      解耦的思路：1，使用反射来创建对象，而避免使用new关键字
 *                 2，通过读取配置文件来获取要创建的对象全限定类名
 *      */
public class JdbcDemo1{
    public static void main(String[] args) throws  Exception{
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());//这里如果mysql加载不了看看有无添加maven项目
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/stringone","root","935538244");
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        rs.close();
        pstm.close();
        conn.close();
    }
}
