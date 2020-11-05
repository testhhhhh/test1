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
	public DefaultListModel<String> d5 = new DefaultListModel<String>();//�����ĸ������ģ��
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
	}//С˵�б�չʾ����

	
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
	}//С˵���ܷ���

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
	}//��ǩ�ı��Զ����з���

	
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
			System.out.println(pst.executeUpdate());// ��������
			rs = pst2.executeQuery();
			while (rs.next()) {
				nnovelid = rs.getInt("novelid");
			}
			flag = true;
		} catch (SQLException e) {// ִ�������ݿ⽨��������Ҫ�׳�SQL�쳣
			e.printStackTrace();
		}
		return flag;
	}//С˵�ϴ�����

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
	}//�ж�С˵�Ƿ��Ѿ��ϴ�����
	
	public static void addPicture(JButton developer,JLabel novelpicturelabel,JTextField novelpicturetext) {
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
		
}
