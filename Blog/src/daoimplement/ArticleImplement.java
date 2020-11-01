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
		//������Ʋ�Ϊ��
		if(InputOrNot.isEmpty(article.getTitle())==false) {
		    sb.append(" where article.title like '%"+article.getTitle()+"%'"); }
		//������߲�Ϊ��
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
		if(way.equals("����Ĳ���")) {
			System.out.println(udi.user.getUsername());
			sql.append("  where writer like "+"'"+udi.user.getUsername()+"'"+";"); 
			}
		if(way.equals("��ҳ���Ų���")) {
			sql.append("  order by hot desc"); }
		if(way.equals("��ҳ���²���")) {
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
		return "��";
	}

	@Override
	public void addPicture(JButton developer, JLabel articlepicturelabel, JTextField articlepicturetext) {
		  JFileChooser chooser = new JFileChooser();
		  chooser.setMultiSelectionEnabled(true);
		  /** �����ļ����� * */
		  FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg","png");
		  chooser.setFileFilter(filter);
		  int returnVal = chooser.showOpenDialog(developer);
		  if (returnVal == JFileChooser.APPROVE_OPTION) { ////
		   /** �õ�ѡ����ļ�* */
		  File[] arrfiles = chooser.getSelectedFiles();
		  if (arrfiles == null || arrfiles.length == 0) {
		    return;
		  }
		  //�ж��Ƿ����ļ�Ϊjpg����png
		  File  ff = chooser.getSelectedFile();
		  //����һ��fileName�õ�ѡ���ļ�������
		  String fileName =ff.getName();
		  //lastIndexOf(".") ����"."���ļ��������һ�γ��ֵ��±�
		  //substring(int index)��ָ����index��ʼ��ȡ������ַ���
		  //���磺 a.txt ���һ�γ��ֵ�.�±��� 1 substring(1)���Ǵ��±�1��λ�ÿ�ʼ��ȡ ��ȡ������ַ���Ϊ .txt
		  //����������Ҫ+1 ����ֻ��ȡ�ļ����� txt
		  String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
		  //�ж�ѡ����ļ��Ƿ���ͼƬ�ļ� �����ų����ǵ���� ��Ȼ���������ᱨ��
		  if(!(prefix.equals("jpg") || prefix.equals("png"))){
		  JOptionPane.showMessageDialog(new JDialog(),":��ѡ��.jpg �� .png��ʽ��ͼƬ");
		  return;
		  }
		  FileInputStream input = null;
		  FileOutputStream out = null;
		  String path = "E:\\С˵��վeclipse\\AAA\\AAAAA\\src\\ShangchuangPackage";
		  String pathh="\\";
		  try {
		  for (File f : arrfiles) {
		     File dir = new File(path);
		     /** Ŀ���ļ��� * */
		     File[] fs = dir.listFiles();
		     HashSet<String> set = new HashSet<String>();
		     for (File file : fs) {
		     set.add(file.getName());
		     }
		     /** �ж��Ƿ����и��ļ�* */
		     if (set.contains(f.getName())) {
		     JOptionPane.showMessageDialog(new JDialog(),
		     f.getName() + ":���ļ��Ѵ��ڣ�");
		     return;
		     } 
		  //ͨ���ļ�ѡ���������õ�ѡ����ļ�.�õ����ļ��ľ���·��
		  String absolutePath = chooser.getSelectedFile().getAbsolutePath();
		  //����һ��ImageIcon���� ����ͼƬ�ļ��ľ���·�� ͨ���������õ�ͼƬ�� �� ��
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
		  JOptionPane.showMessageDialog(null, "�ϴ��ɹ���", "��ʾ",
		  JOptionPane.INFORMATION_MESSAGE);
		  } catch (FileNotFoundException e1) {
		  JOptionPane.showMessageDialog(null, "�ϴ�ʧ�ܣ�", "��ʾ",
		  JOptionPane.ERROR_MESSAGE);
		  e1.printStackTrace();
		  } catch (IOException e1) {
		  JOptionPane.showMessageDialog(null, "�ϴ�ʧ�ܣ�", "��ʾ",
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
