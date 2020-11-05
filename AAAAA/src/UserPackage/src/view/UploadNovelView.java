package UserPackage.src.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UserPackage.src.DaoImple.NovelDaoImplement;
import UserPackage.src.DaoImple.UserDaoImplement;
import UserPackage.src.Entity.User;
import UserPackage.src.InputCheck.IsPasswordTextKeyListener;
import UserPackage.src.InputCheck.NovelMainTextKeyListener;
import UserPackage.src.InputCheck.NovelPictureTextKeyListener;
import UserPackage.src.InputCheck.NovelTitleTextKeyListener;
import UserPackage.src.InputCheck.NovelWriterTextKeyListener;
import UserPackage.src.InputCheck.PasswordTextKeyListener;
import UserPackage.src.InputCheck.UserTextKeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

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
	private JTextField searchnovelnametext;
	private JTextField novelmaintext;

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
		NovelDaoImplement ndi = new NovelDaoImplement();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1112, 818);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//创建内容面板

		JButton returnbutton = new JButton("\u8FD4\u56DE\u9996\u9875");		
		returnbutton.setBounds(904, 24, 184, 51);
		returnbutton.setFont(new Font("方正舒体", Font.BOLD, 35));
		contentPane.add(returnbutton);
		//创建返回按钮
		returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomepageView.homepageInit();//点击按钮,跳转至首页界面
			}
		});
		//为返回按钮设置监听

		JLabel novelnamelabel = new JLabel("\u5C0F\u8BF4\u6807\u9898\uFF1A");
		novelnamelabel.setForeground(new Color(255, 255, 0));
		novelnamelabel.setBounds(10, 80, 177, 40);
		novelnamelabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		contentPane.add(novelnamelabel);
		//创建小说名字标签

		novelwritertext = new JTextField();
		novelwritertext.setBounds(229, 148, 345, 33);
		contentPane.add(novelwritertext);
		novelwritertext.setColumns(10);
		//创建小说作者文本框

		JLabel novelwriterlabel = new JLabel("\u5C0F\u8BF4\u4F5C\u8005\uFF1A");
		novelwriterlabel.setForeground(new Color(255, 255, 0));
		novelwriterlabel.setBounds(10, 140, 167, 33);
		novelwriterlabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		contentPane.add(novelwriterlabel);
		//创建小说作者标签

		novelpicturetext = new JTextField();
		novelpicturetext.setBounds(407, 222, 345, 33);
		contentPane.add(novelpicturetext);
		novelpicturetext.setColumns(10);
		//创建小说图片路径文本框
		

		JLabel novelmainlabel = new JLabel("\u5C0F\u8BF4\u6897\u6982\uFF1A");
		novelmainlabel.setForeground(new Color(255, 255, 0));
		novelmainlabel.setBounds(10, 417, 167, 47);
		novelmainlabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		contentPane.add(novelmainlabel);
		//创建小说梗概标签

		JButton okbutton = new JButton("\u786E\u8BA4\u4E0A\u4F20");
		okbutton.setBounds(407, 567, 167, 47);
		okbutton.setFont(new Font("方正舒体", Font.BOLD, 30));
		contentPane.add(okbutton);
		//创建确认上传小说信息按钮

		novelnametext = new JTextField();
		novelnametext.setBounds(229, 92, 345, 33);
		contentPane.add(novelnametext);
		novelnametext.setColumns(10);
		//创建小说名字文本框

		JLabel novelpiclabel = new JLabel("\u5C0F\u8BF4\u56FE\u7247\u8DEF\u5F84\uFF1A");
		novelpiclabel.setForeground(new Color(255, 255, 0));
		novelpiclabel.setFont(new Font("方正舒体", Font.PLAIN, 30));
		novelpiclabel.setBounds(10, 200, 235, 40);
		contentPane.add(novelpiclabel);
		//创建小说图片路径标签

		JLabel novelidlabel = new JLabel("\u5C0F\u8BF4id\uFF1A");
		novelidlabel.setForeground(new Color(255, 255, 0));
		novelidlabel.setFont(new Font("方正舒体", Font.PLAIN, 30));
		novelidlabel.setBounds(32, 18, 123, 49);
		contentPane.add(novelidlabel);
		//创建小说id标签

		JLabel novelidshowlabel = new JLabel("0");
		novelidshowlabel.setForeground(new Color(255, 255, 0));
		novelidshowlabel.setFont(new Font("方正舒体", Font.PLAIN, 30));
		novelidshowlabel.setBounds(248, 35, 102, 27);
		contentPane.add(novelidshowlabel);
		//创建小说id显示标签

		JButton uploadbutton = new JButton("\u4E0A\u4F20\u7AE0\u8282");
		uploadbutton.setFont(new Font("方正舒体", Font.PLAIN, 30));
		uploadbutton.setBounds(674, 21, 184, 54);
		contentPane.add(uploadbutton);
		//创建上传章节按钮

		JLabel searchnovelnamelabel = new JLabel("\u8F93\u5165\u5DF2\u4E0A\u4F20\u7684\u5C0F\u8BF4\u540D\uFF1A");
		searchnovelnamelabel.setForeground(new Color(255, 255, 0));
		searchnovelnamelabel.setFont(new Font("方正舒体", Font.PLAIN, 30));
		searchnovelnamelabel.setBounds(659, 358, 304, 49);
		contentPane.add(searchnovelnamelabel);
		//创建切换小说输入警告标签

		searchnovelnametext = new JTextField();
		searchnovelnametext.setBounds(659, 472, 378, 47);
		contentPane.add(searchnovelnametext);
		searchnovelnametext.setColumns(10);
		//创建切换小说文本框

		JButton turnbutton = new JButton("\u5207\u6362\u5C0F\u8BF4");
		turnbutton.setFont(new Font("方正舒体", Font.PLAIN, 30));
		turnbutton.setBounds(843, 567, 194, 47);
		contentPane.add(turnbutton);
		//创建切换小说按钮

		JLabel novelclassifylabel = new JLabel("\u5C0F\u8BF4\u5206\u7C7B\uFF1A");
		novelclassifylabel.setFont(new Font("方正舒体", Font.PLAIN, 30));
		novelclassifylabel.setForeground(new Color(255, 255, 0));
		novelclassifylabel.setBounds(10, 289, 157, 31);
		contentPane.add(novelclassifylabel);
		//创建小说分类标签

		JRadioButton schoollovebutton = new JRadioButton("\u9752\u6625\u6821\u56ED");
		schoollovebutton.setFont(new Font("方正舒体", Font.PLAIN, 30));
		schoollovebutton.setBackground(new Color(255, 250, 250));
		schoollovebutton.setForeground(new Color(0, 0, 0));
		schoollovebutton.setBounds(173, 287, 157, 33);
		contentPane.add(schoollovebutton);
		//创建小说分类青春校园的单选按钮

		JRadioButton classicbutton = new JRadioButton("\u7ECF\u5178\u8457\u4F5C");
		classicbutton.setFont(new Font("方正舒体", Font.PLAIN, 30));
		classicbutton.setBounds(356, 288, 157, 32);
		contentPane.add(classicbutton);
		//创建小说分类经典名著的单选按钮

		JRadioButton fantasybutton = new JRadioButton("\u7384\u5E7B\u4ED9\u4FA0");
		fantasybutton.setFont(new Font("方正舒体", Font.PLAIN, 30));
		fantasybutton.setBounds(173, 366, 157, 33);
		contentPane.add(fantasybutton);
		//创建小说分类玄幻仙侠的单选按钮

		JRadioButton sciencebutton = new JRadioButton("\u60AC\u7591\u79D1\u5E7B");
		sciencebutton.setFont(new Font("方正舒体", Font.PLAIN, 30));
		sciencebutton.setBounds(356, 366, 157, 33);
		contentPane.add(sciencebutton);
		//创建小说分类悬疑科幻的单选按钮

		JLabel noveltitlewarnlabel = new JLabel("");
		noveltitlewarnlabel.setForeground(new Color(255, 0, 0));
		noveltitlewarnlabel.setBounds(82, 130, 504, 19);
		contentPane.add(noveltitlewarnlabel);
		//创建小说题目输入警告标签

		JLabel novelwriterwarnlabel = new JLabel("");
		novelwriterwarnlabel.setForeground(Color.RED);
		novelwriterwarnlabel.setBounds(95, 183, 504, 19);
		contentPane.add(novelwriterwarnlabel);
		//创建小说作者输入警告标签

		JLabel novelpicturewarnlabel = new JLabel("");
		novelpicturewarnlabel.setForeground(Color.RED);
		novelpicturewarnlabel.setBounds(82, 253, 504, 19);
		contentPane.add(novelpicturewarnlabel);
		//创建小说图片路径输入警告标签

		JLabel novelclassifywarnlabel = new JLabel("");
		novelclassifywarnlabel.setForeground(Color.RED);
		novelclassifywarnlabel.setBounds(528, 327, 504, 19);
		contentPane.add(novelclassifywarnlabel);
		//创建小说分类警告标签

		JLabel novelmainwarnlabel = new JLabel("");
		novelmainwarnlabel.setForeground(Color.RED);
		novelmainwarnlabel.setBounds(70, 531, 504, 19);
		contentPane.add(novelmainwarnlabel);
		//黄健小说梗概输入警告标签

		JLabel noveltitlechangewarnlabel = new JLabel("");
		noveltitlechangewarnlabel.setForeground(Color.RED);
		noveltitlechangewarnlabel.setBounds(648, 529, 413, 19);
		contentPane.add(noveltitlechangewarnlabel);
		//创建小说标题输入警告标签

		ButtonGroup bg = new ButtonGroup();
		bg.add(sciencebutton);
		bg.add(fantasybutton);
		bg.add(classicbutton);
		bg.add(schoollovebutton);
		//创建分类组,将四个单项选择按钮添加入分类组

		novelmaintext = new JTextField();
		novelmaintext.setBounds(82, 470, 492, 51);
		contentPane.add(novelmaintext);
		novelmaintext.setColumns(10);
		//创建小说概要文本框
		
		JLabel uploadpicturelabel = new JLabel("\u9884\u89C8\u56FE\u7247\uFF1A");
		uploadpicturelabel.setFont(new Font("方正舒体", Font.PLAIN, 27));
		uploadpicturelabel.setForeground(Color.YELLOW);
		uploadpicturelabel.setBounds(794, 85, 142, 40);
		contentPane.add(uploadpicturelabel);
		//预览图片标签
		
		JLabel uploadpiclabel = new JLabel("");
		uploadpiclabel.setBounds(768, 134, 320, 231);
		contentPane.add(uploadpiclabel);
		//图片展示标签	
		
		JButton uploadpicbutton = new JButton("\u4E0A\u4F20\u56FE\u7247");
		uploadpicbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ndi.addPicture(uploadpicbutton, uploadpiclabel,novelpicturetext);
			}
		});
		uploadpicbutton.setFont(new Font("方正舒体", Font.PLAIN, 26));
		uploadpicbutton.setBounds(222, 212, 167, 40);
		contentPane.add(uploadpicbutton);
		//上传图片按钮
		

		
		JLabel backgroundpidlabel = new JLabel("");
		backgroundpidlabel.setFont(new Font("方正舒体", Font.PLAIN, 30));
		backgroundpidlabel.setIcon(new ImageIcon(UploadNovelView.class.getResource("/png/26.jpg")));
		backgroundpidlabel.setBounds(0, 0, 1098, 781);
		contentPane.add(backgroundpidlabel);
		//创建上传小说界面的背景图片标签

		NovelTitleTextKeyListener nttkl = new NovelTitleTextKeyListener(noveltitlewarnlabel, novelnametext, "upload");
		novelnametext.addKeyListener(nttkl);
		//创建小说标题文本框输入的键盘监听
		NovelWriterTextKeyListener nwtkl = new NovelWriterTextKeyListener(novelwriterwarnlabel, novelwritertext);
		novelwritertext.addKeyListener(nwtkl);
		//创建小说作者文本框输入的键盘监听
		NovelMainTextKeyListener nmtkl = new NovelMainTextKeyListener(novelmainwarnlabel, novelmaintext);
		novelmaintext.addKeyListener(nmtkl);
		//创建小说概要文本框输入的键盘监听
		NovelPictureTextKeyListener nptkl = new NovelPictureTextKeyListener(novelpicturewarnlabel, novelpicturetext);
		novelpicturetext.addKeyListener(nptkl);
		//创建小说图片文本框输入的键盘监听
		NovelTitleTextKeyListener ntttkl = new NovelTitleTextKeyListener(noveltitlechangewarnlabel, searchnovelnametext,"change");
		novelnametext.addKeyListener(ntttkl);
		//创建切换的小说标题文本框输入的键盘监听

		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ndi.nnovel.setNovelname(novelnametext.getText());
				ndi.nnovel.setNovelmain(novelmaintext.getText());
				ndi.nnovel.setNovelwriter(novelwritertext.getText());
				ndi.nnovel.setNovelpicture(novelpicturetext.getText());//将要上传的小说信息存入nnovel对象中
				if (schoollovebutton.isSelected()) {
					novelclassifywarnlabel.setText("");//设置警告标签为空
					ndi.nnovel.setClassifyid(2);//分别判断选择的单选按钮是哪个,选择的对应的分类id存入nnovel对象classifyid中
				} else if (classicbutton.isSelected()) {
					novelclassifywarnlabel.setText("");
					ndi.nnovel.setClassifyid(3);
				} else if (fantasybutton.isSelected()) {
					novelclassifywarnlabel.setText("");
					ndi.nnovel.setClassifyid(1);
				} else if (sciencebutton.isSelected()) {
					novelclassifywarnlabel.setText("");
					ndi.nnovel.setClassifyid(4);
				} else {
					novelclassifywarnlabel.setText("分类选项不能为空");//四个选择项均为空,则设置警告标签显示错误
				}
				if ("".equals(noveltitlewarnlabel.getText()) && "".equals(novelwriterwarnlabel.getText())
						&& "".equals(novelpicturewarnlabel.getText()) && "".equals(novelclassifywarnlabel.getText())
						&& "".equals(novelmainwarnlabel.getText()) && !("".equals(novelnametext.getText()))
						&& !("".equals(novelmaintext.getText())) && !("".equals(novelwritertext.getText()))
						&& !("".equals(novelpicturetext.getText()))) {//先判断所有文本框均不为空且所有警告标签均为空,即输入的所有数据符合规定
					if (ndi.novelupload())//调用小说上传方法
						JOptionPane.showMessageDialog(null, "上传成功", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "上传失败", "提示", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		//确认按钮设置监听

		uploadbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UploadchapterView.UploadchapterViewInit();//点击按钮跳转至上传章节页面
			}
		});
		//对上传章节按钮设置监听
		
		turnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ndi.isUpload(searchnovelnametext.getText()) && "".equals(noveltitlechangewarnlabel.getText())
						&& !("".equals(searchnovelnametext.getText()))) {//先调用isUpload查看是否已存在要切换 的小说名,判断输入格式标签无报错,且有输入内容
					JOptionPane.showMessageDialog(null, "切换成功", "提示", JOptionPane.PLAIN_MESSAGE);
					novelidshowlabel.setText(String.valueOf(ndi.nnovelid));//将切换的小说id赋予xiaoshuoid显示标签

				} else {
					JOptionPane.showMessageDialog(null, "切换失败", "提示", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		//对切换小说按钮设置监听
	}
}
