package blogview;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import daoimplement.ArticleImplement;
import inputcheck.NovelMainTextKeyListener;
import inputcheck.NovelPictureTextKeyListener;
import inputcheck.NovelWriterTextKeyListener;
import inputcheck.TitleTextKeyListener;
import jdbc.DLUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JScrollBar;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JRadioButton;

public class UploadNovelView extends JFrame {

	private JPanel contentPane;
	private JTextField novelwritertext;
	private JTextField novelpicturetext;
	private JTextField novelnametext;
	private JTextField contenttext;

	/**
	 * Launch the application.
	 */
	public static void UploadNovelViewInit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploadNovelView frame = new UploadNovelView();
					frame.setLocationRelativeTo(null);
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
	public UploadNovelView() {
		ArticleImplement ndi = new ArticleImplement();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1112, 818);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//创建内容面板

		JButton returnbutton = new JButton("\u8FD4\u56DE\u9996\u9875");		
		returnbutton.setIcon(new ImageIcon(UploadNovelView.class.getResource("/images/\u9000\u51FA.png")));
		returnbutton.setBackground(new Color(255, 182, 193));
		returnbutton.setBounds(843, 24, 245, 51);
		returnbutton.setFont(new Font("方正舒体", Font.BOLD, 35));
		contentPane.add(returnbutton);
		//创建返回按钮
		returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomepageView.homepageInit();//点击按钮,跳转至首页界面
			}
		});
		//为返回按钮设置监听

		JLabel titlelabel = new JLabel("\u535A\u5BA2\u6807\u9898\uFF1A");
		titlelabel.setForeground(new Color(139, 0, 0));
		titlelabel.setBounds(10, 80, 177, 40);
		titlelabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		contentPane.add(titlelabel);
		//创建小说名字标签

		novelwritertext = new JTextField();
		novelwritertext.setBounds(229, 148, 345, 33);
		contentPane.add(novelwritertext);
		novelwritertext.setColumns(10);
		//创建小说作者文本框

		JLabel writerlabel = new JLabel("\u4F5C\u8005\uFF1A");
		writerlabel.setForeground(new Color(139, 0, 0));
		writerlabel.setBounds(10, 140, 167, 33);
		writerlabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		contentPane.add(writerlabel);
		//创建小说作者标签

		novelpicturetext = new JTextField();
		novelpicturetext.setBounds(227, 209, 413, 40);
		contentPane.add(novelpicturetext);
		novelpicturetext.setColumns(10);
		//创建小说图片路径文本框
		

		JLabel contentlabel = new JLabel("\u535A\u5BA2\u5185\u5BB9\uFF1A");
		contentlabel.setForeground(new Color(139, 0, 0));
		contentlabel.setBounds(10, 417, 167, 47);
		contentlabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		contentPane.add(contentlabel);
		//创建小说梗概标签

		JButton okbutton = new JButton("\u786E\u8BA4\u4E0A\u4F20");
		okbutton.setIcon(new ImageIcon(UploadNovelView.class.getResource("/images/\u6DFB\u52A0(3).png")));
		okbutton.setBackground(new Color(255, 182, 193));
		okbutton.setBounds(861, 659, 214, 47);
		okbutton.setFont(new Font("方正舒体", Font.BOLD, 30));
		contentPane.add(okbutton);
		//创建确认上传小说信息按钮

		novelnametext = new JTextField();
		novelnametext.setBounds(229, 92, 345, 33);
		contentPane.add(novelnametext);
		novelnametext.setColumns(10);
		//创建小说名字文本框

		JLabel piclabel = new JLabel("\u56FE\u7247\u8DEF\u5F84\uFF1A");
		piclabel.setForeground(new Color(139, 0, 0));
		piclabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		piclabel.setBounds(10, 200, 235, 40);
		contentPane.add(piclabel);
		//创建小说分类悬疑科幻的单选按钮

		JLabel titlewarnlabel = new JLabel("");
		titlewarnlabel.setForeground(new Color(255, 0, 0));
		titlewarnlabel.setBounds(229, 124, 504, 19);
		contentPane.add(titlewarnlabel);
		//创建小说题目输入警告标签

		JLabel writerwarnlabel = new JLabel("");
		writerwarnlabel.setForeground(Color.RED);
		writerwarnlabel.setBounds(229, 180, 504, 19);
		contentPane.add(writerwarnlabel);
		//创建小说作者输入警告标签

		JLabel picturewarnlabel = new JLabel("");
		picturewarnlabel.setForeground(Color.RED);
		picturewarnlabel.setBounds(229, 255, 504, 19);
		contentPane.add(picturewarnlabel);
		//创建小说分类警告标签

		JLabel contentwarnlabel = new JLabel("");
		contentwarnlabel.setForeground(Color.RED);
		contentwarnlabel.setBounds(82, 739, 676, 19);
		contentPane.add(contentwarnlabel);
		//创建小说标题输入警告标签

		ButtonGroup bg = new ButtonGroup();
		//创建分类组,将四个单项选择按钮添加入分类组

		contenttext = new JTextField();
		contenttext.setBounds(82, 470, 756, 259);
		contentPane.add(contenttext);
		contenttext.setColumns(10);
		//创建小说概要文本框
		
		JLabel uploadpicturelabel = new JLabel("\u9884\u89C8\u56FE\u7247\uFF1A");
		uploadpicturelabel.setFont(new Font("方正舒体", Font.BOLD, 27));
		uploadpicturelabel.setForeground(new Color(139, 0, 0));
		uploadpicturelabel.setBounds(13, 282, 142, 40);
		contentPane.add(uploadpicturelabel);
		//预览图片标签
		
		JLabel uploadpiclabel = new JLabel("");
		uploadpiclabel.setBounds(229, 284, 423, 151);
		contentPane.add(uploadpiclabel);
		//图片展示标签	
		
		JButton uploadpicbutton = new JButton("\u4E0A\u4F20\u56FE\u7247");
		uploadpicbutton.setIcon(new ImageIcon(UploadNovelView.class.getResource("/images/\u6DFB\u52A0(4).png")));
		uploadpicbutton.setBackground(new Color(255, 182, 193));
		uploadpicbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ndi.addPicture(uploadpicbutton, uploadpiclabel,novelpicturetext);
			}
		});
		uploadpicbutton.setFont(new Font("方正舒体", Font.PLAIN, 26));
		uploadpicbutton.setBounds(671, 209, 207, 40);
		contentPane.add(uploadpicbutton);
		//上传图片按钮
		

		
		JLabel backgroundpidlabel = new JLabel("");
		backgroundpidlabel.setFont(new Font("方正舒体", Font.PLAIN, 30));
		backgroundpidlabel.setIcon(new ImageIcon(UploadNovelView.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710224105.png")));
		backgroundpidlabel.setBounds(0, 0, 1098, 781);
		contentPane.add(backgroundpidlabel);
		//创建上传小说界面的背景图片标签

		TitleTextKeyListener nttkl = new TitleTextKeyListener(titlewarnlabel, novelnametext);
		novelnametext.addKeyListener(nttkl);	
		NovelWriterTextKeyListener nwtkl = new NovelWriterTextKeyListener(writerwarnlabel, novelwritertext);
		novelwritertext.addKeyListener(nwtkl);	
		NovelMainTextKeyListener nmtkl = new NovelMainTextKeyListener(contentwarnlabel, contenttext);
		contenttext.addKeyListener(nmtkl);
		NovelPictureTextKeyListener nptkl = new NovelPictureTextKeyListener(picturewarnlabel, novelpicturetext);
		novelpicturetext.addKeyListener(nptkl);
	

		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
			    conn = DLUtil.getCon();// 获取数据库连接
				ndi.article.setTitle((novelnametext.getText()));
				ndi.article.setContent(contenttext.getText());
				ndi.article.setWriter((novelwritertext.getText()));
				ndi.article.setPicture((novelpicturetext.getText()));//将要上传的小说信息存入nnovel对象中
				if ("".equals(titlewarnlabel.getText()) && "".equals(writerwarnlabel.getText())
						&& "".equals(picturewarnlabel.getText())
						&& "".equals(contentwarnlabel.getText()) && !("".equals(novelnametext.getText()))
						&& !("".equals(contenttext.getText())) && !("".equals(novelwritertext.getText()))
						&& !("".equals(novelpicturetext.getText()))) {//先判断所有文本框均不为空且所有警告标签均为空,即输入的所有数据符合规定
					try {
						if (ndi.add(conn, ndi.article)!=0)//调用小说上传方法
							JOptionPane.showMessageDialog(null, "上传成功", "提示", JOptionPane.PLAIN_MESSAGE);
					} catch (HeadlessException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "上传失败", "提示", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		//对切换小说按钮设置监听
	}
}
