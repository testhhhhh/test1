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
	NovelDaoImplement ndi = new NovelDaoImplement();//创建小说Dao实现类对象
	public Chapter chapter = new Chapter();//创建章节实体
	public DefaultListModel<String> aaa = new DefaultListModel<String>();//创建列表数据模型
	public static String cchaptername;//创建静态章节名
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
				System.out.println("数据库连接成功！");
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动加载失败！");
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}//连接数据库

	public boolean chapterlist() {
		String sql = "select chaptername from chapter,novel where novel.novelid=chapter.novelid and novelname=?;";

		String chaptername;
		ResultSet rs = null;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, (String) NovelDaoImplement.nnovelname);//设置预查询的第一个?为NovelDaoImplement的小说名
			rs = pst.executeQuery();//解析一下
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
	}//章节内容展示方法

	public boolean chapterupload() {
		boolean flag = false;
		String sql = "insert into chapter values(?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, 0);
			pst.setInt(2, ndi.nnovelid);
			pst.setString(3, chapter.getChaptername());
			pst.setString(4, chapter.getChaptercontent());
			int result = pst.executeUpdate();// 返回值代表收到影响的行数
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
	}//章节内容上传方法

}
