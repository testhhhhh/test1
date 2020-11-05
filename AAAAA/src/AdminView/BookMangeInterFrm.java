package AdminView;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import Adminmodel.Book;
import Adminmodel.BookType;
import Dao.BookDao;
import Dao.BookTypeDao;
import Dao.ChapterDao;
import util.DLUtil;
import util.StringUtil;

public class BookMangeInterFrm extends JFrame {
	private JTable bookTable;
	private JTextField s_booknametxt;
	private JTextField s_bookwritertxt;
	private DLUtil dlutil=new DLUtil();
	private BookTypeDao booktypedao=new BookTypeDao();
	private BookDao bookdao=new BookDao();
    private JComboBox s_booktypejcb;
    private JTextField idtextfield;
    private JTextField booknametextfield;
    private JTextField writertextfield;
    private JTextField pricetextfield;
    private JComboBox booktypeboxjcb;
    private ChapterDao chapterdao=new ChapterDao();
    private static JTextField picturetextField;
    private static JLabel pictureview;
    private JTextArea booktextArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookMangeInterFrm frame = new BookMangeInterFrm();
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
	public BookMangeInterFrm() {
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
//		setClosable(true);
//		setIconifiable(true);
		setTitle("\u5C0F\u8BF4\u7BA1\u7406");
		setBounds(300, 80, 1229, 812);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(111, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1004, GroupLayout.PREFERRED_SIZE)
					.addGap(100))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1103, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1163, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		
		JLabel lblNewLabel_3 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_3.setBounds(49, 27, 84, 32);
		lblNewLabel_3.setIcon(new ImageIcon(BookMangeInterFrm.class.getResource("/images/\u7F16\u53F7.png")));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		idtextfield = new JTextField();
		idtextfield.setBackground(SystemColor.control);
		idtextfield.setBounds(151, 27, 100, 32);
		idtextfield.setEditable(false);
		idtextfield.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u5C0F\u8BF4\u540D\u79F0\uFF1A");
		lblNewLabel_4.setBounds(382, 27, 116, 32);
		lblNewLabel_4.setIcon(new ImageIcon(BookMangeInterFrm.class.getResource("/images/\u56FE\u4E66.png")));
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		booknametextfield = new JTextField();
		booknametextfield.setBounds(498, 30, 189, 32);
		booknametextfield.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u5C0F\u8BF4\u4F5C\u8005\uFF1A");
		lblNewLabel_5.setBounds(16, 77, 120, 32);
		lblNewLabel_5.setIcon(new ImageIcon(BookMangeInterFrm.class.getResource("/images/\u4E2A\u4EBA\u4FE1\u606F_\u5B9D\u8D1D\u59D3\u540D.png")));
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		writertextfield = new JTextField();
		writertextfield.setBounds(146, 79, 141, 33);
		writertextfield.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u70B9\u5238\u6570\uFF1A");
		lblNewLabel_6.setBounds(398, 77, 100, 32);
		lblNewLabel_6.setIcon(new ImageIcon(BookMangeInterFrm.class.getResource("/images/\u94B1\u888B.png")));
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		pricetextfield = new JTextField();
		pricetextfield.setBounds(498, 80, 189, 32);
		pricetextfield.setColumns(10);
		panel_1.setLayout(null);
		panel_1.add(lblNewLabel_3);
		panel_1.add(idtextfield);
		panel_1.add(lblNewLabel_4);
		panel_1.add(lblNewLabel_5);
		panel_1.add(writertextfield);
		panel_1.add(lblNewLabel_6);
		panel_1.add(pricetextfield);
		panel_1.add(booknametextfield);
		
		JLabel lblNewLabel_7 = new JLabel("\u5C0F\u8BF4\u7C7B\u578B:");
		lblNewLabel_7.setIcon(new ImageIcon(BookMangeInterFrm.class.getResource("/images/\u5206\u7C7B_.png")));
		lblNewLabel_7.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(785, 27, 109, 32);
		panel_1.add(lblNewLabel_7);
		
		booktypeboxjcb = new JComboBox();
		booktypeboxjcb.setBackground(SystemColor.control);
		booktypeboxjcb.setBounds(904, 30, 202, 30);
		panel_1.add(booktypeboxjcb);
		
		JLabel lblNewLabel_8 = new JLabel("\u5C0F\u8BF4\u7B80\u4ECB\uFF1A");
		lblNewLabel_8.setIcon(new ImageIcon(BookMangeInterFrm.class.getResource("/images/\u56FE\u4E66(2).png")));
		lblNewLabel_8.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(389, 130, 109, 32);
		panel_1.add(lblNewLabel_8);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.setBackground(SystemColor.control);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtt) {
				bookUpdate(evtt);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookMangeInterFrm.class.getResource("/images/\u4FEE\u6539.png")));
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton_1.setBounds(995, 232, 110, 37);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.setBackground(SystemColor.control);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ee) {
				bookDelete(ee);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(BookMangeInterFrm.class.getResource("/images/\u5220\u9664(1).png")));
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton_2.setBounds(995, 350, 109, 38);
		panel_1.add(btnNewButton_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(382, 172, 568, 240);
		panel_1.add(scrollPane_1);
		
	    booktextArea = new JTextArea();
	    booktextArea.setLineWrap(true);
		scrollPane_1.setViewportView(booktextArea);
				
				JLabel lblNewLabel_9 = new JLabel("\u56FE\u7247\u4E0A\u4F20\uFF1A");
				lblNewLabel_9.setFont(new Font("微软雅黑", Font.PLAIN, 16));
				lblNewLabel_9.setIcon(new ImageIcon(BookMangeInterFrm.class.getResource("/images/\u4E0A\u4F20.png")));
				lblNewLabel_9.setBounds(778, 77, 116, 32);
				panel_1.add(lblNewLabel_9);
				
				picturetextField = new JTextField();
				picturetextField.setBounds(166, 133, 202, 21);
				panel_1.add(picturetextField);
				picturetextField.setColumns(10);
				
				JLabel lblNewLabel_10 = new JLabel("\u56FE\u7247\u6548\u679C\u9884\u89C8\uFF1A");
				lblNewLabel_10.setFont(new Font("微软雅黑", Font.PLAIN, 16));
				lblNewLabel_10.setIcon(new ImageIcon(BookMangeInterFrm.class.getResource("/images/\u82B1.png")));
				lblNewLabel_10.setBounds(16, 130, 155, 32);
				panel_1.add(lblNewLabel_10);
				
				pictureview = new JLabel("");
				pictureview.setFont(new Font("微软雅黑", Font.BOLD, 12));
				pictureview.setBounds(80, 199, 250, 250);
				panel_1.add(pictureview);
				
				JButton btnNewButton_4 = new JButton("\u70B9\u51FB\u4E0A\u4F20");
				btnNewButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addPicture(btnNewButton_4);
					}
				});
				btnNewButton_4.setFont(new Font("微软雅黑", Font.BOLD, 16));
				btnNewButton_4.setBounds(927, 79, 155, 32);
				panel_1.add(btnNewButton_4);
				
				JButton btnNewButton_3 = new JButton("\u70B9\u51FB\u67E5\u770B\u539F\u56FE");
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ep) {
						PitcureClick(ep);
					}
				});
				btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 14));
				btnNewButton_3.setBounds(41, 164, 130, 23);
				panel_1.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("\u5C0F\u8BF4\u540D\u79F0\uFF1A");
		lblNewLabel.setBounds(6, 31, 116, 32);
		lblNewLabel.setIcon(new ImageIcon(BookMangeInterFrm.class.getResource("/images/\u56FE\u4E66.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		s_booknametxt = new JTextField();
		s_booknametxt.setBounds(126, 33, 148, 33);
		s_booknametxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F5C\u8005\uFF1A");
		lblNewLabel_1.setBounds(329, 31, 96, 32);
		lblNewLabel_1.setIcon(new ImageIcon(BookMangeInterFrm.class.getResource("/images/\u4E2A\u4EBA\u4FE1\u606F_\u5B9D\u8D1D\u59D3\u540D.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		s_bookwritertxt = new JTextField();
		s_bookwritertxt.setBounds(427, 34, 127, 32);
		s_bookwritertxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5C0F\u8BF4\u7C7B\u578B\uFF1A");
		lblNewLabel_2.setBounds(600, 27, 116, 40);
		lblNewLabel_2.setIcon(new ImageIcon(BookMangeInterFrm.class.getResource("/images/\u5206\u7C7B_.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		 s_booktypejcb = new JComboBox();
		 s_booktypejcb.setBounds(726, 32, 148, 35);
		 s_booktypejcb.setBackground(SystemColor.control);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setBounds(938, 32, 112, 36);
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearch(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookMangeInterFrm.class.getResource("/images/\u67E5\u8BE2(2).png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(s_booknametxt);
		panel.add(lblNewLabel_1);
		panel.add(s_bookwritertxt);
		panel.add(lblNewLabel_2);
		panel.add(s_booktypejcb);
		panel.add(btnNewButton);
		
		bookTable = new JTable();
		bookTable.setForeground(new Color(0, 0, 0));
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			
			//鼠标点击表格操作
			public void mousePressed(MouseEvent me) {
				booktableMousePressed(me);
			}
		});
		bookTable.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5C0F\u8BF4\u540D\u79F0", "\u5C0F\u8BF4\u7B80\u4ECB", "\u4F5C\u8005", "\u56FE\u7247\u8DEF\u5F84", "\u70B9\u5238\u6570", "\u5C0F\u8BF4\u7C7B\u578B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(2).setPreferredWidth(178);
		scrollPane.setViewportView(bookTable);
		getContentPane().setLayout(groupLayout);
 
		this.fillBookType("search");//下拉框
		this.fillBookType("modify");//下拉框数据选择识别
		this.filltable(new Book());//将数据库数据进行导入到表格
	}
	//查看原图按钮事件
	private void PitcureClick(ActionEvent ep) {
		String picture=this.picturetextField.getText();
		this.pictureview.setIcon(new ImageIcon(picture));
		this.pictureview.getIcon();
	}
	
	//图片上传
	public static void addPicture(JButton developer) {
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
		   String path = "C:\\Users\\admin\\eclipse-workspace\\MySQLTest\\src\\png";
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
//		     pictureview.setIcon(imageIcon);
//		     pictureview.getIcon();
		     picturetextField.setText(path+pathh+f.getName());
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
	
	
	//小说删除事件处理
	private void bookDelete(ActionEvent ee) {
		// TODO Auto-generated method stub
		String id=idtextfield.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;	
		}
		int n=JOptionPane.showConfirmDialog(null,"确定要删除这条记录吗");
		if(n==0) {
			Connection conn=null;
			try {
				conn=dlutil.getCon();	
				int deleteNum=bookdao.delete(conn, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功");	
					reSetValue(ee);//重置数据
					this.filltable(new Book());//更新表格数据
				}else {
					JOptionPane.showMessageDialog(null, "删除失败");		
				}
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");	
			}finally {
				try {
					dlutil.CloseCon(conn);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	
	
	//修改小说事件处理
	private void bookUpdate(ActionEvent evtt) {
		// TODO Auto-generated method stub
		String id=this.idtextfield.getText();//如果用户没选，这个id为空
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null,"请选择要修改的记录");
			return;
		}
		String bookname=this.booknametextfield.getText();//小说名称
		String bookmain=this.booktextArea.getText();//小说简介
		String bookwriter=this.writertextfield.getText();//小说作者
		String bookmoney=this.pricetextfield.getText();//价格
		String picture=this.picturetextField.getText();//图片路径
		this.pictureview.setIcon(new ImageIcon(picture));
		this.pictureview.getIcon();
		if(StringUtil.isEmpty(bookname)) {
			JOptionPane.showMessageDialog(null,"小说名称不能为空");
			return;
		}
		if(StringUtil.isEmpty(bookwriter)) {
			JOptionPane.showMessageDialog(null,"小说作者不能为空");
			return;
		}
		if(StringUtil.isEmpty(bookmoney)) {
			JOptionPane.showMessageDialog(null,"小说价格不能为空");
			return;
		}
		//获取小说类型的id
		BookType booktype=(BookType) booktypeboxjcb.getSelectedItem();	
		int booktypeId=booktype.getClassifyid();
		
		Book book=new Book(Integer.parseInt(id), bookname, bookmain, bookwriter, Float.parseFloat(bookmoney),booktypeId,picture);
		Connection conn=null;
		try {
			conn=dlutil.getCon();
			int addNum=bookdao.update(conn, book);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, "小说修改成功");
				reSetValue(evtt);
				this.filltable(new Book());//更新表格数据
			}else {
				JOptionPane.showMessageDialog(null, "小说修改失败");
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

	
	//重置
	private void reSetValue(ActionEvent eaa) {
		// TODO Auto-generated method stub
		this.idtextfield.setText("");
		this.booknametextfield.setText("");
		this.booktextArea.setText("");
		this.pricetextfield.setText("");
		this.writertextfield.setText("");
		this.booknametextfield.requestFocus();
		this.picturetextField.setText("");
		this.pictureview.setIcon(new ImageIcon());
		
	}

	
	//表格行点击事件处理
	private void booktableMousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		int row=this.bookTable.getSelectedRow();//获取行数
		//获取列的数据
		this.idtextfield.setText((String)bookTable.getValueAt(row, 0));//编号
		this.booknametextfield.setText((String)bookTable.getValueAt(row, 1));//小说名称
		this.booktextArea.setText((String)bookTable.getValueAt(row, 2));//小说简介
		this.writertextfield.setText((String)bookTable.getValueAt(row, 3));//小说作者
		this.pricetextfield.setText((String)bookTable.getValueAt(row, 5));//价格  //价格这里出错过，因为价格为float类型，所以我把它转成float，结果出错
		this.picturetextField.setText((String) bookTable.getValueAt(row, 4));//图片路径
		String booktypename=(String)this.bookTable.getValueAt(row, 6);//获取下拉框的类型名称
	
		int n=this.booktypeboxjcb.getItemCount();//下拉框有多少行
		//遍历下拉框
		for(int i=0;i<n;i++) {
			BookType item=(BookType) this.booktypeboxjcb.getItemAt(i);//索引
			if(item.getClassifyname().equals(booktypename)) {
				this.booktypeboxjcb.setSelectedIndex(i);
			}
		}
	}

	
	//小说查询处理
	private void bookSearch(ActionEvent evt) {
		// TODO Auto-generated method stub
		String bookname=this.s_booknametxt.getText().toString();
		String bookwriter=this.s_bookwritertxt.getText();
	BookType booktype=(BookType) this.s_booktypejcb.getSelectedItem();//获取下拉框的选择对象
	int booktypeid=booktype.getClassifyid();
	Book book=new Book(bookname,bookwriter,booktypeid);//封装数据
	this.filltable(book);//调用表格数据
	s_booknametxt.setText("");
	s_bookwritertxt.setText("");
	}

	
	//初始化下拉框
	//下拉框类型
	private void fillBookType(String type) {
		Connection conn=null;
		//小说类型
		BookType booktype=null;
		try {
			//连接数据库
			conn=dlutil.getCon();
			ResultSet rs=booktypedao.list(conn, new BookType());
			if("search".equals(type)) {
				booktype=new BookType();
				booktype.setClassifyname("请选择.....");
				booktype.setClassifyid(-1);
				this.s_booktypejcb.addItem(booktype);
			}
			//把小说类型数据导入到下拉框
			while(rs.next()) {
				booktype=new BookType();
				booktype.setClassifyname(rs.getString("classifyname"));
				booktype.setClassifyid(rs.getInt("classifyid"));
				if("search".equals(type)) {
					this.s_booktypejcb.addItem(booktype);
				}else if("modify".equals(type)){
                      this.booktypeboxjcb.addItem(booktype);
				}
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
	

	
	
	//初始化表格数据
	private void filltable(Book book) {
		DefaultTableModel dtm=(DefaultTableModel) bookTable.getModel();//获得model，进行初始化
		dtm.setRowCount(0);//设置成0行，清空表格
		Connection conn=null;
		try {
			conn=dlutil.getCon();//获取数据库连接
			ResultSet rs=bookdao.list(conn, book);
			
			//用集合进行遍历
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("novelid"));
				v.add(rs.getString("novelname"));
				v.add(rs.getString("novelmain"));
				v.add(rs.getString("novelwriter"));
				v.add(rs.getString("novelpicture"));
				v.add(rs.getString("novelmoney"));
				v.add(rs.getString("classifyname"));
				dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dlutil.CloseCon(conn);//关闭数据库连接
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
