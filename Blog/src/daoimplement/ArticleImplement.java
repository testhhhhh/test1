package daoimplement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.ArticleDao;
import entity.Ariticle;
import entity.User;
import inputcheck.InputOrNot;

public class ArticleImplement implements ArticleDao {
	public DefaultListModel<String> d5 = new DefaultListModel<String>();
	public DefaultListModel<String> d = new DefaultListModel<String>();
	UserDaoImplement udi=new UserDaoImplement();
	public static String title;
	public Ariticle article = new Ariticle();
	@Override
	public int add(Connection conn, Ariticle article) throws SQLException {
		String sql="insert into article values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		pstmt.setInt(1,article.getArticleid());
		pstmt.setString(2, article.getTitle());
		pstmt.setString(3, article.getContent());
		pstmt.setString(4,article.getWriter());
		pstmt.setString(5, article.getPicture());
		pstmt.setInt(6,0);
		pstmt.setString(7, df.format(date));
		return pstmt.executeUpdate();
	}

	@Override
	public ResultSet list(Connection conn, Ariticle article) throws SQLException {
		StringBuffer sb=new StringBuffer("select * from article");
		//如果名称不为空
		if(InputOrNot.isEmpty(article.getTitle())==false) {
		    sb.append(" where article.title like '%"+article.getTitle()+"%'"); }
		//如果作者不为空
	    if(InputOrNot.isEmpty(article.getWriter())==false) {
			sb.append(" where article.writer like '%"+article.getWriter()+"%'");}
        PreparedStatement pstmt=conn.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}

	@Override
	public int delete(Connection conn, int articleid) throws SQLException {
		String sql="delete from article where articleid=?";
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setInt(1,articleid);
		return pstmt.executeUpdate();
	}

	@Override
	public int update(Connection conn, Ariticle article) throws SQLException {
		String sql="update article set articleid=?,title=?,content=?,writer=?,picture=? where articleid=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, article.getArticleid());
		pstmt.setString(2,article.getTitle());
		pstmt.setString(3, article.getContent());
	    pstmt.setString(4,article.getWriter());
	    pstmt.setString(5, article.getPicture());
		pstmt.setInt(6, article.getArticleid());
		return pstmt.executeUpdate();
	}

	@Override
	public boolean articlelist(Connection conn, DefaultListModel<String> d,String way) throws Exception {
		StringBuffer  sql =new StringBuffer("select title from article"); 
		udi.userinteractive(conn, udi.userid);
		Statement Statement = conn.createStatement();
		if(way.equals("发表的博文")) {
			System.out.println(udi.user.getUsername());
			sql.append("  where writer like "+"'"+udi.user.getUsername()+"'"+";"); 
			}
		if(way.equals("首页热门博文")) {
			sql.append("  order by hot desc"); }
		if(way.equals("首页最新博文")) {
			sql.append("  order by data desc"); }
		ResultSet rs = Statement.executeQuery(sql.toString());
		if(rs!=null) {
		while (rs.next()) {
			String title = rs.getString("title");
			d.addElement(title);
		    }
		return true;
		}
		return false;
	}
	
	public boolean articleinteractive(Connection conn,String title) throws SQLException {
		String sql = "select * from article where title=?";
		ResultSet rs = null;
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1,title);
			rs = pst.executeQuery();
			while (rs.next()) {
				article.setArticleid(rs.getInt("articleid"));
				article.setTitle(rs.getString("title"));
				article.setContent(rs.getString("content"));
				article.setWriter(rs.getString("writer"));
				article.setPicture(rs.getString("picture"));
				article.setHot(rs.getInt("hot"));
				article.setDatee(rs.getDate("data"));
				return true;
			}
		return false;
	}
	
	@Override
	public String contentshow(Connection conn, Ariticle article) throws SQLException {
		String sql = "select content from article where title=?";
		ResultSet rs = null;
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1,title);
		rs = pst.executeQuery();
		while (rs.next()) {
			return rs.getString("content");
		}
		return "无";
	}

	@Override
	public void addPicture(JButton developer, JLabel articlepicturelabel, JTextField articlepicturetext) {
		  JFileChooser chooser = new JFileChooser();
		  chooser.setMultiSelectionEnabled(true);
		  /** 过滤文件类型 * */
		  FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg","png");
		  chooser.setFileFilter(filter);
		  int returnVal = chooser.showOpenDialog(developer);
		  if (returnVal == JFileChooser.APPROVE_OPTION) { ////
		   /** 得到选择的文件* */
		  File[] arrfiles = chooser.getSelectedFiles();
		  if (arrfiles == null || arrfiles.length == 0) {
		    return;
		  }
		  //判断是否有文件为jpg或者png
		  File  ff = chooser.getSelectedFile();
		  //创建一个fileName得到选择文件的名字
		  String fileName =ff.getName();
		  //lastIndexOf(".") 返回"."在文件名中最后一次出现的下标
		  //substring(int index)从指定的index开始截取后面的字符串
		  //比如： a.txt 最后一次出现的.下标是 1 substring(1)就是从下标1的位置开始截取 截取后的新字符串为 .txt
		  //所以这里需要+1 才能只截取文件类型 txt
		  String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
		  //判断选择的文件是否是图片文件 必须排除不是的情况 不然后续操作会报错
		  if(!(prefix.equals("jpg") || prefix.equals("png"))){
		  JOptionPane.showMessageDialog(new JDialog(),":请选择.jpg 或 .png格式的图片");
		  return;
		  }
		  FileInputStream input = null;
		  FileOutputStream out = null;
		  String path = "E:\\小说网站eclipse\\AAA\\AAAAA\\src\\ShangchuangPackage";
		  String pathh="\\";
		  try {
		  for (File f : arrfiles) {
		     File dir = new File(path);
		     /** 目标文件夹 * */
		     File[] fs = dir.listFiles();
		     HashSet<String> set = new HashSet<String>();
		     for (File file : fs) {
		     set.add(file.getName());
		     }
		     /** 判断是否已有该文件* */
		     if (set.contains(f.getName())) {
		     JOptionPane.showMessageDialog(new JDialog(),
		     f.getName() + ":该文件已存在！");
		     return;
		     } 
		  //通过文件选择器对象拿到选择的文件.拿到该文件的绝对路径
		  String absolutePath = chooser.getSelectedFile().getAbsolutePath();
		  //创建一个ImageIcon对象 传入图片文件的绝对路径 通过这个对象得到图片的 长 宽
		  ImageIcon imageIcon = new ImageIcon(absolutePath);
		  articlepicturelabel.setIcon(imageIcon);
		  articlepicturelabel.getIcon();
		  articlepicturetext.setText(path+pathh+f.getName());
		  input = new FileInputStream(f);
		  byte[] buffer = new byte[1024];
		  File des = new File(path, f.getName());
		  out = new FileOutputStream(des);
		  int len = 0;
		  while (-1 != (len = input.read(buffer))) {
		  out.write(buffer, 0, len);
		  }
		  out.close();
		  input.close();
		  }
		  JOptionPane.showMessageDialog(null, "上传成功！", "提示",
		  JOptionPane.INFORMATION_MESSAGE);
		  } catch (FileNotFoundException e1) {
		  JOptionPane.showMessageDialog(null, "上传失败！", "提示",
		  JOptionPane.ERROR_MESSAGE);
		  e1.printStackTrace();
		  } catch (IOException e1) {
		  JOptionPane.showMessageDialog(null, "上传失败！", "提示",
		  JOptionPane.ERROR_MESSAGE);
		  e1.printStackTrace();
		  }
		  }

	}

	@Override
	public int good(Connection conn, String title) throws SQLException {
		String sql = "update article set hot=hot+1 where title=?;";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1,title);
		return pst.executeUpdate();
	}

	

}
