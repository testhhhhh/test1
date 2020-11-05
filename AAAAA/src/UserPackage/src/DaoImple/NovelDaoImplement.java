package UserPackage.src.DaoImple;

import java.awt.FontMetrics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

import UserPackage.src.Dao.NovelDao;
import UserPackage.src.Entity.Novel;

public class NovelDaoImplement implements NovelDao {
	public DefaultListModel<String> d5 = new DefaultListModel<String>();//创建四个分类的模型
	public DefaultListModel<String> d2 = new DefaultListModel<String>();
	public DefaultListModel<String> d3 = new DefaultListModel<String>();
	public DefaultListModel<String> d4 = new DefaultListModel<String>();
	public Novel nnovel = new Novel();
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/novelsite?&useSSL=false&serverTimezone=UTC";
	String dbusername = "root";
	String dbpassword = "935538244";
	public static Object nnovelname;
	public static int nnovelid;
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

	public boolean novellist(int classifyid, DefaultListModel<String> d) {
		String sql = "select novelname from novel where classifyid=?;";
		String novelname;
		ResultSet rs = null;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, classifyid);
			rs = pst.executeQuery();
			while (rs.next()) {
				novelname = rs.getString("novelname");
				d.addElement(novelname);

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
	}//小说列表展示方法

	
	public boolean novelinteractive() {
		String sql = "select * from novel where novelname=?";
		ResultSet rs = null;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, (String) nnovelname);
			rs = pst.executeQuery();
			while (rs.next()) {
				nnovel.setNovelid(rs.getInt("novelid"));
				nnovel.setClassifyid(rs.getInt("classifyid"));
				nnovel.setNovelname(rs.getString("novelname"));
				nnovel.setNovelmain(rs.getString("novelmain"));
				nnovel.setNovelwriter(rs.getString("novelwriter"));
				nnovel.setNovelpicture(rs.getString("novelpicture"));
				nnovel.setNovelmony(rs.getFloat("novelmoney"));
				return true;
			}
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
	}//小说介绍方法

	public void JlabelSetText(JLabel jLabel, String longString) throws InterruptedException {
		StringBuilder builder = new StringBuilder("<html>");
		char[] chars = longString.toCharArray();
		FontMetrics fontMetrics = jLabel.getFontMetrics(jLabel.getFont());
		int start = 0;
		int len = 0;
		while (start + len < longString.length()) {
			while (true) {
				len++;
				if (start + len > longString.length())
					break;
				if (fontMetrics.charsWidth(chars, start, len) > jLabel.getWidth()) {
					break;
				}
			}
			builder.append(chars, start, len - 1).append("<br/>");
			start = start + len - 1;
			len = 0;
		}
		builder.append(chars, start, longString.length() - start);
		builder.append("</html>");
		jLabel.setText(builder.toString());
	}//标签文本自动换行方法

	
	public boolean novelupload() {
		boolean flag = false;
		String sql = "insert into novel values(?,?,?,?,?,?,?)";
		String sql2 = "select novelid from novel where novelname =?; ";
		ResultSet rs = null;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			PreparedStatement pst2 = conn.prepareStatement(sql2);

			pst.setInt(1, 0);
			pst.setInt(2, nnovel.getClassifyid());
			pst.setString(3, nnovel.getNovelname());
			pst.setString(4, nnovel.getNovelmain());
			pst.setString(5, nnovel.getNovelwriter());
			pst.setString(6, nnovel.getNovelpicture());
			pst.setFloat(7, 0);
			pst2.setString(1, nnovel.getNovelname());
			System.out.println(pst.executeUpdate());// 解释在下
			rs = pst2.executeQuery();
			while (rs.next()) {
				nnovelid = rs.getInt("novelid");
			}
			flag = true;
		} catch (SQLException e) {// 执行与数据库建立连接需要抛出SQL异常
			e.printStackTrace();
		}
		return flag;
	}//小说上传方法

	public boolean isUpload(String nnovelname) {
		Statement Statement = null;
		try {
			Statement = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "select novelid,novelname from novel;";
		String novelname;
		int novelid;
		ResultSet rs = null;
		try {
			rs = Statement.executeQuery(sql);
			while (rs.next()) {
				novelid = rs.getInt("novelid");
				novelname = rs.getString("novelname");
				if (nnovelname.equals(novelname)) {
					nnovelid = novelid;
					return true;
				}
			}
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
	}//判断小说是否已经上传方法
	
	public static void addPicture(JButton developer,JLabel novelpicturelabel,JTextField novelpicturetext) {
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
		     novelpicturelabel.setIcon(imageIcon);
		     novelpicturelabel.getIcon();
		     novelpicturetext.setText(path+pathh+f.getName());
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
		
}
