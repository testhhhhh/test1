package UserPackage.src.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UserPackage.src.DaoImple.ChapterDaoilplement;
import UserPackage.src.DaoImple.NovelDaoImplement;

import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextArea;

public class ChapterView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void ChapterViewInit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChapterView frame = new ChapterView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//创建章节阅读页面窗口
	}

	/**
	 * Create the frame.
	 */
	public ChapterView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1217, 797);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//创建内容面板

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("华文新魏", Font.PLAIN, 27));
		textArea.setLineWrap(true);// 自动换行
		textArea.setBackground(new Color(250, 235, 215));
		//创建章节阅读文本域

		JScrollPane scrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				                                  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(36, 44, 1143, 693);
		scrollPane.setViewportView(textArea);
		contentPane.add(scrollPane);
		contentPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		//创建滚动面板

		ChapterDaoilplement cdi = new ChapterDaoilplement();//创建章节Dao实现类对象
		cdi.chaptercontentshow();//调用里面的章节内容显示方法(chaptercontentshow)
		textArea.setText(cdi.chapter.getChaptercontent());//文本域中设置chapter实体中的章节内容为问文本内容
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ChapterView.class.getResource("/png/331accfedfa32255b471222cd480e1e.png")));
		lblNewLabel.setBounds(0, 0, 1218, 782);
		contentPane.add(lblNewLabel);
	}
}
