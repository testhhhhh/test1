package AdminView;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Adminmodel.Book;
import Adminmodel.BookType;
import Dao.BookDao;
import Dao.BookTypeDao;
import util.DLUtil;
import util.StringUtil;

public class BookAddInterFrm extends JFrame {
	private JTextField booknametxt;
	private JTextField bookwritertxt;
	private JTextField pricetxt;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextArea bookmaintextArea;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private DLUtil dlutil=new DLUtil();
	private BookTypeDao booktypedao=new BookTypeDao();
	private BookDao bookdao=new BookDao();
	private JComboBox booktypejcb;
	private JLabel lblNewLabel_5;
	private JScrollPane scrollPane;
	private static JTextField picturetxt;
	private ImageIcon img;
	private static JLabel pictureview;
	private JButton shangchuang;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
			
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookAddInterFrm() {
//		setTitle("\u5C0F\u8BF4\u6DFB\u52A0\u754C\u9762");
//		setIconifiable(true);
		setTitle("\u5C0F\u8BF4\u6DFB\u52A0\u754C\u9762");
//		setFrameIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/\u5199\u4F5C.png")));
		setBounds(100, 100, 854, 780);
		getContentPane().setLayout(null);	
		
		
		JLabel lblNewLabel = new JLabel("\u5C0F\u8BF4\u540D\u79F0\uFF1A");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(104, 19, 168, 48);
		lblNewLabel.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/\u56FE\u4E66(1).png")));
		lblNewLabel.setFont(new Font("΢���ź�", Font.BOLD, 23));
		
		booknametxt = new JTextField();
		booknametxt.setBounds(290, 32, 221, 36);
		booknametxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5C0F\u8BF4\u4F5C\u8005\uFF1A");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBounds(120, 91, 152, 32);
		lblNewLabel_1.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC,\u7B11\u8138.png")));
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.BOLD, 23));
		
		bookwritertxt = new JTextField();
		bookwritertxt.setBounds(290, 96, 221, 36);
		bookwritertxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u70B9\u5238\u6570\uFF1A");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setBounds(143, 155, 129, 40);
		lblNewLabel_2.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/\u94B1\u888B.png")));
		lblNewLabel_2.setFont(new Font("΢���ź�", Font.BOLD, 23));
		
		pricetxt = new JTextField();
		pricetxt.setBounds(290, 161, 221, 34);
		pricetxt.setColumns(10);
		
		lblNewLabel_3 = new JLabel("\u5C0F\u8BF4\u7C7B\u522B\uFF1A");
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setBounds(114, 229, 158, 32);
		lblNewLabel_3.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/\u56FE\u4E66(3).png")));
		lblNewLabel_3.setFont(new Font("΢���ź�", Font.BOLD, 23));
		
		lblNewLabel_4 = new JLabel("\u5C0F\u8BF4\u7B80\u4ECB\uFF1A");
		lblNewLabel_4.setForeground(SystemColor.text);
		lblNewLabel_4.setBounds(120, 357, 152, 32);
		lblNewLabel_4.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/\u521B\u4F5C(1).png")));
		lblNewLabel_4.setFont(new Font("΢���ź�", Font.BOLD, 23));
	    booktypejcb = new JComboBox();
	    booktypejcb.setBounds(290, 229, 221, 31);
	    booktypejcb.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		booktypejcb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setBackground(new Color(153, 204, 255));
		btnNewButton.setBounds(194, 669, 141, 41);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ea) {
				bookAdd(ea);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/\u56FE\u4E66\u5F55\u5165(1).png")));
		btnNewButton.setFont(new Font("΢���ź�", Font.PLAIN, 22));
		
		btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setBackground(new Color(153, 204, 255));
		btnNewButton_1.setBounds(467, 669, 133, 41);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				reSetValue(evt);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		btnNewButton_1.setFont(new Font("΢���ź�", Font.PLAIN, 22));
		getContentPane().setLayout(null);
		getContentPane().add(lblNewLabel);
		getContentPane().add(booknametxt);
		getContentPane().add(lblNewLabel_1);
		getContentPane().add(bookwritertxt);
		getContentPane().add(lblNewLabel_2);
		getContentPane().add(pricetxt);
		getContentPane().add(lblNewLabel_3);
		getContentPane().add(booktypejcb);
		getContentPane().add(lblNewLabel_4);
		getContentPane().add(btnNewButton);
		getContentPane().add(btnNewButton_1);
		
		lblNewLabel_5 = new JLabel("\u56FE\u7247\u4E0A\u4F20\uFF1A");
		lblNewLabel_5.setForeground(SystemColor.text);
		lblNewLabel_5.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/\u4E0A\u4F20.png")));
		lblNewLabel_5.setFont(new Font("΢���ź�", Font.BOLD, 23));
		lblNewLabel_5.setBounds(120, 290, 158, 36);
		getContentPane().add(lblNewLabel_5);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 420, 654, 217);
		getContentPane().add(scrollPane);
		
		bookmaintextArea = new JTextArea();
		bookmaintextArea.setLineWrap(true);
		scrollPane.setViewportView(bookmaintextArea);
		
		//�����ı���ı߿�����
		bookmaintextArea.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		
		picturetxt = new JTextField();
		picturetxt.setBounds(574, 77, 221, 21);
		getContentPane().add(picturetxt);
		picturetxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u56FE\u7247\u6548\u679C\u9884\u89C8\uFF1A");
		lblNewLabel_6.setForeground(SystemColor.text);
		lblNewLabel_6.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/\u82B1.png")));
		lblNewLabel_6.setFont(new Font("΢���ź�", Font.BOLD, 23));
		lblNewLabel_6.setBounds(574, 32, 208, 35);
		getContentPane().add(lblNewLabel_6);
		
		pictureview = new JLabel("");
		pictureview.setBounds(566, 136, 250, 250);
		getContentPane().add(pictureview);
		
	    shangchuang = new JButton("\u70B9\u51FB\u4E0A\u4F20");
		shangchuang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                  addPicture(shangchuang);	
			}
		});
		shangchuang.setFont(new Font("΢���ź�", Font.BOLD, 18));
		shangchuang.setBounds(314, 293, 184, 36);
		getContentPane().add(shangchuang);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/png/26.jpg")));
		lblNewLabel_7.setBounds(0, 0, 854, 780);
		getContentPane().add(lblNewLabel_7);

		fillBookType();
	}

	//�����¼�����
	private void reSetValue(ActionEvent evt) {
		// TODO Auto-generated method stub
		booknametxt.setText("");
		bookwritertxt.setText("");
		pricetxt.setText("");
		bookmaintextArea.setText("");
		booknametxt.requestFocus();
		this.picturetxt.setText("");
		this.pictureview.setIcon(new ImageIcon());
		//С˵����ѡ���������ûѡ�Ͳ���������ѡ�Ͳ���
		if(this.booktypejcb.getItemCount()>0) {
			this.booktypejcb.setSelectedIndex(0);//Ĭ��ѡ���һ��
		}
	}

	
	public static void addPicture(JButton developer) {
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
		   String path = "C:\\Users\\admin\\eclipse-workspace\\MySQLTest\\src\\png";
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
		     pictureview.setIcon(imageIcon);
		     pictureview.getIcon();
		     picturetxt.setText(path+pathh+f.getName());
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
	//С˵��ӹ���
	private void bookAdd(ActionEvent ea) {
		// TODO Auto-generated method stub
		String bookname=this.booknametxt.getText();//С˵����
		String bookmain=this.bookmaintextArea.getText();//С˵���
		String bookwriter=this.bookwritertxt.getText();//С˵����
		String bookmoney=this.pricetxt.getText();//�۸�
		String picture=this.picturetxt.getText();//ͼƬ·��
		
		if(StringUtil.isEmpty(bookname)) {
			JOptionPane.showMessageDialog(null,"С˵���Ʋ���Ϊ��");
			return;
		}
		if(StringUtil.isEmpty(bookwriter)) {
			JOptionPane.showMessageDialog(null,"С˵���߲���Ϊ��");
			return;
		}
		if(StringUtil.isEmpty(bookmoney)) {
			JOptionPane.showMessageDialog(null,"С˵�۸���Ϊ��");
			return;
		}
		BookType booktype=(BookType) booktypejcb.getSelectedItem();
		int booktypeId=booktype.getClassifyid();
		
		Book book=new Book(bookname, bookmain, bookwriter,Float.parseFloat(bookmoney),booktypeId,picture);
		
		Connection conn=null;
		try {
			conn=dlutil.getCon();
			int addNum=bookdao.add(conn, book);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, "С˵��ӳɹ�");
				reSetValue(ea);
			}else {
				JOptionPane.showMessageDialog(null, "С˵���ʧ��");
				return;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dlutil.CloseCon(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//��ʼ��ͼ�����������
	private void fillBookType() {
		Connection conn=null;
		BookType booktype=null;
		try {
			conn=dlutil.getCon();//���ݿ�����
		ResultSet rs=booktypedao.list(conn, new BookType());
		//������ϱ���
			while(rs.next()) {
				booktype=new BookType();
				booktype.setClassifyid(rs.getInt("classifyid"));
				booktype.setClassifyname(rs.getString("classifyname"));
				this.booktypejcb.addItem(booktype);//�����
				
			}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		
	}
}
}