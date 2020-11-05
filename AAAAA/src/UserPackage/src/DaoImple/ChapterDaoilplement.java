package UserPackage.src.DaoImple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;

import UserPackage.src.Dao.ChapterDao;
import UserPackage.src.Entity.Chapter;
import UserPackage.src.Entity.Novel;

public class ChapterDaoilplement implements ChapterDao {
	NovelDaoImplement ndi = new NovelDaoImplement();//����С˵Daoʵ�������
	public Chapter chapter = new Chapter();//�����½�ʵ��
	public DefaultListModel<String> aaa = new DefaultListModel<String>();//�����б�����ģ��
	public static String cchaptername;//������̬�½���
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/novelsite?&useSSL=false&serverTimezone=UTC";
	String dbusername = "root";
	String dbpassword = "935538244";
	Connection conn = null;
	{
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbusername, dbpassword);
			if (!conn.isClosed())
				System.out.println("���ݿ����ӳɹ���");
		} catch (ClassNotFoundException e) {
			System.out.println("���ݿ���������ʧ�ܣ�");
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}//�������ݿ�

	public boolean chapterlist() {
		String sql = "select chaptername from chapter,novel where novel.novelid=chapter.novelid and novelname=?;";

		String chaptername;
		ResultSet rs = null;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, (String) NovelDaoImplement.nnovelname);//����Ԥ��ѯ�ĵ�һ��?ΪNovelDaoImplement��С˵��
			rs = pst.executeQuery();//����һ��
			while (rs.next()) {
				chaptername = rs.getString("chaptername");
				aaa.addElement(chaptername);
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	public boolean chaptercontentshow() {
		String sql = "select chaptercontent from chapter,novel where novel.novelid=chapter.novelid and chaptername=?;";

		String chaptercontent;
		ResultSet rs = null;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, (String) cchaptername);
			rs = pst.executeQuery();
			while (rs.next()) {
				chapter.setChaptercontent(rs.getString("chaptercontent"));
				chapter.setChaptername(cchaptername);
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}//�½�����չʾ����

	public boolean chapterupload() {
		boolean flag = false;
		String sql = "insert into chapter values(?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, 0);
			pst.setInt(2, ndi.nnovelid);
			pst.setString(3, chapter.getChaptername());
			pst.setString(4, chapter.getChaptercontent());
			int result = pst.executeUpdate();// ����ֵ�����յ�Ӱ�������
			System.out.println(result);
			if (result > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}//�½������ϴ�����

}
