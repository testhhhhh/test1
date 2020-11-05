package Dao;

import java.sql.Connection;
import util.DLUtil;
/*
 * 创建数据库连接对象，整个项目与数据库打交道都用这个对象
 */
public class BaseDao {
public Connection conn=new DLUtil().getCon();
}
