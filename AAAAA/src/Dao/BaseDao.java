package Dao;

import java.sql.Connection;
import util.DLUtil;
/*
 * �������ݿ����Ӷ���������Ŀ�����ݿ�򽻵������������
 */
public class BaseDao {
public Connection conn=new DLUtil().getCon();
}
