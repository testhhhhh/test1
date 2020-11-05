package UserPackage.src.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UserPackage.src.DaoImple.ChapterDaoilplement;
import UserPackage.src.DaoImple.NovelDaoImplement;
import UserPackage.src.InputCheck.ChapterContentTextKeyListener;
import UserPackage.src.InputCheck.ChapternameTextKeyListener;
import UserPackage.src.InputCheck.NovelTitleTextKeyListener;
import UserPackage.src.InputCheck.NovelWriterTextKeyListener;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class UploadchapterView extends JFrame {

	private JPanel contentPane;
	private JTextField chaptercontenttext;
	private JTextField chapternametext;

	/**
	 * Launch the application.
	 */
	public static void UploadchapterViewInit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploadchapterView frame = new UploadchapterView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//创建上传章节界面窗口
	}

	/**
	 * Create the frame.
	 */
	public UploadchapterView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 926, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//创建内容面板

		JButton returnbutton = new JButton("\u8FD4\u56DE\u5C0F\u8BF4\u754C\u9762");		
		returnbutton.setBackground(new Color(224, 255, 255));
		returnbutton.setBounds(626, 34, 235, 41);
		returnbutton.setFont(new Font("方正舒体", Font.BOLD, 30));
		contentPane.add(returnbutton);
		//创建返回按钮
		
        returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UploadNovelView.UploadNovelViewInit();//点击返回按钮,跳转至上传小说界面
			}
		});
        //对返回按钮设置监听
        
		JLabel novelidlabel = new JLabel("\u5C0F\u8BF4ID\uFF1A");
		novelidlabel.setForeground(new Color(255, 255, 0));
		novelidlabel.setBounds(83, 112, 122, 33);
		novelidlabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		contentPane.add(novelidlabel);
		//创建小说id标签

		JLabel novelidshowlabel = new JLabel("New label");
		novelidshowlabel.setForeground(new Color(255, 255, 0));
		novelidshowlabel.setBounds(204, 111, 137, 41);
		novelidshowlabel.setFont(new Font("宋体", Font.PLAIN, 30));
		contentPane.add(novelidshowlabel);
		//创建小说id显示标签

		JLabel chaptername = new JLabel("\u7AE0\u8282\u540D\uFF1A");
		chaptername.setForeground(new Color(255, 255, 0));
		chaptername.setBounds(85, 168, 154, 47);
		chaptername.setFont(new Font("方正舒体", Font.BOLD, 30));
		contentPane.add(chaptername);
		//创建章节名标签

		JLabel chaptercontentlabel = new JLabel("\u7AE0\u8282\u5185\u5BB9\uFF1A");
		chaptercontentlabel.setForeground(new Color(255, 255, 0));
		chaptercontentlabel.setBounds(62, 225, 161, 50);
		chaptercontentlabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		contentPane.add(chaptercontentlabel);
		//创建章节内容标签

		chaptercontenttext = new JTextField();
		chaptercontenttext.setBounds(81, 285, 802, 233);
		contentPane.add(chaptercontenttext);
		chaptercontenttext.setColumns(10);
		//创建章节内容文本框

		ChapterDaoilplement cdi = new ChapterDaoilplement();//创建章节Dao实现类对象
		JButton okbutton = new JButton("\u786E\u8BA4\u4E0A\u4F20");
		okbutton.setBackground(new Color(224, 255, 255));
		//创建确认按钮

		NovelDaoImplement ndi = new NovelDaoImplement();//创建小说Dao实现类对象
		
		novelidshowlabel.setText(String.valueOf(ndi.nnovelid));
		okbutton.setFont(new Font("方正舒体", Font.PLAIN, 30));
		okbutton.setBounds(626, 142, 235, 47);
		contentPane.add(okbutton);
		//创建小说id显示标签

		chapternametext = new JTextField();
		chapternametext.setBounds(199, 183, 345, 33);
		contentPane.add(chapternametext);
		chapternametext.setColumns(10);
		//创建章节内容文本框

		JLabel chapternamewarnlabel = new JLabel("");
		chapternamewarnlabel.setForeground(new Color(255, 0, 0));
		chapternamewarnlabel.setBounds(204, 225, 461, 23);
		contentPane.add(chapternamewarnlabel);
		//创建章节标题输入警告标签

		JLabel chaptercontentwarnlabel = new JLabel("");
		chaptercontentwarnlabel.setForeground(Color.RED);
		chaptercontentwarnlabel.setBounds(83, 528, 789, 23);
		contentPane.add(chaptercontentwarnlabel);
		//串接章节内容输入警告标签

		JLabel backgroundpiclabel = new JLabel("");
		backgroundpiclabel.setIcon(new ImageIcon(UploadchapterView.class.getResource("/UserPackage/src/newimages/e53d30373cde0cd4e20c4dcb56640f9.png")));
		backgroundpiclabel.setBounds(0, 0, 912, 553);
		contentPane.add(backgroundpiclabel);
		//创建上传章节界面背景图片标签

		ChapternameTextKeyListener cntkl = new ChapternameTextKeyListener(chapternamewarnlabel, chapternametext);
		chapternametext.addKeyListener(cntkl);
		//创建对章节标题输入的键盘监听
		ChapterContentTextKeyListener nwtkl = new ChapterContentTextKeyListener(chaptercontentwarnlabel,chaptercontenttext);
		chaptercontenttext.addKeyListener(nwtkl);
		//创建对章节内容输入的键盘监听

		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cdi.chapter.setChaptername(chapternametext.getText());
				cdi.chapter.setChaptercontent(chaptercontenttext.getText());//将用户输入的内容添加至章节实体中
				if ("".equals(chapternamewarnlabel.getText()) && "".equals(chaptercontentwarnlabel.getText())
						&& !("".equals(chapternametext.getText())) && !("".equals(chaptercontenttext.getText()))) {//当所有文本框不为空且所有警告标签无显示内容时
					if (cdi.chapterupload())//调用上传章节方法
						JOptionPane.showMessageDialog(null, "上传成功", "提示", JOptionPane.PLAIN_MESSAGE);//成功,弹出窗口

				} else {
					JOptionPane.showMessageDialog(null, "上传失败", "提示", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		//创建对确认上传按钮的监听
	}
}
