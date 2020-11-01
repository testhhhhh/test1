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
		//�����������

		JButton returnbutton = new JButton("\u8FD4\u56DE\u9996\u9875");		
		returnbutton.setIcon(new ImageIcon(UploadNovelView.class.getResource("/images/\u9000\u51FA.png")));
		returnbutton.setBackground(new Color(255, 182, 193));
		returnbutton.setBounds(843, 24, 245, 51);
		returnbutton.setFont(new Font("��������", Font.BOLD, 35));
		contentPane.add(returnbutton);
		//�������ذ�ť
		returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomepageView.homepageInit();//�����ť,��ת����ҳ����
			}
		});
		//Ϊ���ذ�ť���ü���

		JLabel titlelabel = new JLabel("\u535A\u5BA2\u6807\u9898\uFF1A");
		titlelabel.setForeground(new Color(139, 0, 0));
		titlelabel.setBounds(10, 80, 177, 40);
		titlelabel.setFont(new Font("��������", Font.BOLD, 30));
		contentPane.add(titlelabel);
		//����С˵���ֱ�ǩ

		novelwritertext = new JTextField();
		novelwritertext.setBounds(229, 148, 345, 33);
		contentPane.add(novelwritertext);
		novelwritertext.setColumns(10);
		//����С˵�����ı���

		JLabel writerlabel = new JLabel("\u4F5C\u8005\uFF1A");
		writerlabel.setForeground(new Color(139, 0, 0));
		writerlabel.setBounds(10, 140, 167, 33);
		writerlabel.setFont(new Font("��������", Font.BOLD, 30));
		contentPane.add(writerlabel);
		//����С˵���߱�ǩ

		novelpicturetext = new JTextField();
		novelpicturetext.setBounds(227, 209, 413, 40);
		contentPane.add(novelpicturetext);
		novelpicturetext.setColumns(10);
		//����С˵ͼƬ·���ı���
		

		JLabel contentlabel = new JLabel("\u535A\u5BA2\u5185\u5BB9\uFF1A");
		contentlabel.setForeground(new Color(139, 0, 0));
		contentlabel.setBounds(10, 417, 167, 47);
		contentlabel.setFont(new Font("��������", Font.BOLD, 30));
		contentPane.add(contentlabel);
		//����С˵���ű�ǩ

		JButton okbutton = new JButton("\u786E\u8BA4\u4E0A\u4F20");
		okbutton.setIcon(new ImageIcon(UploadNovelView.class.getResource("/images/\u6DFB\u52A0(3).png")));
		okbutton.setBackground(new Color(255, 182, 193));
		okbutton.setBounds(861, 659, 214, 47);
		okbutton.setFont(new Font("��������", Font.BOLD, 30));
		contentPane.add(okbutton);
		//����ȷ���ϴ�С˵��Ϣ��ť

		novelnametext = new JTextField();
		novelnametext.setBounds(229, 92, 345, 33);
		contentPane.add(novelnametext);
		novelnametext.setColumns(10);
		//����С˵�����ı���

		JLabel piclabel = new JLabel("\u56FE\u7247\u8DEF\u5F84\uFF1A");
		piclabel.setForeground(new Color(139, 0, 0));
		piclabel.setFont(new Font("��������", Font.BOLD, 30));
		piclabel.setBounds(10, 200, 235, 40);
		contentPane.add(piclabel);
		//����С˵�������ɿƻõĵ�ѡ��ť

		JLabel titlewarnlabel = new JLabel("");
		titlewarnlabel.setForeground(new Color(255, 0, 0));
		titlewarnlabel.setBounds(229, 124, 504, 19);
		contentPane.add(titlewarnlabel);
		//����С˵��Ŀ���뾯���ǩ

		JLabel writerwarnlabel = new JLabel("");
		writerwarnlabel.setForeground(Color.RED);
		writerwarnlabel.setBounds(229, 180, 504, 19);
		contentPane.add(writerwarnlabel);
		//����С˵�������뾯���ǩ

		JLabel picturewarnlabel = new JLabel("");
		picturewarnlabel.setForeground(Color.RED);
		picturewarnlabel.setBounds(229, 255, 504, 19);
		contentPane.add(picturewarnlabel);
		//����С˵���ྯ���ǩ

		JLabel contentwarnlabel = new JLabel("");
		contentwarnlabel.setForeground(Color.RED);
		contentwarnlabel.setBounds(82, 739, 676, 19);
		contentPane.add(contentwarnlabel);
		//����С˵�������뾯���ǩ

		ButtonGroup bg = new ButtonGroup();
		//����������,���ĸ�����ѡ��ť����������

		contenttext = new JTextField();
		contenttext.setBounds(82, 470, 756, 259);
		contentPane.add(contenttext);
		contenttext.setColumns(10);
		//����С˵��Ҫ�ı���
		
		JLabel uploadpicturelabel = new JLabel("\u9884\u89C8\u56FE\u7247\uFF1A");
		uploadpicturelabel.setFont(new Font("��������", Font.BOLD, 27));
		uploadpicturelabel.setForeground(new Color(139, 0, 0));
		uploadpicturelabel.setBounds(13, 282, 142, 40);
		contentPane.add(uploadpicturelabel);
		//Ԥ��ͼƬ��ǩ
		
		JLabel uploadpiclabel = new JLabel("");
		uploadpiclabel.setBounds(229, 284, 423, 151);
		contentPane.add(uploadpiclabel);
		//ͼƬչʾ��ǩ	
		
		JButton uploadpicbutton = new JButton("\u4E0A\u4F20\u56FE\u7247");
		uploadpicbutton.setIcon(new ImageIcon(UploadNovelView.class.getResource("/images/\u6DFB\u52A0(4).png")));
		uploadpicbutton.setBackground(new Color(255, 182, 193));
		uploadpicbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ndi.addPicture(uploadpicbutton, uploadpiclabel,novelpicturetext);
			}
		});
		uploadpicbutton.setFont(new Font("��������", Font.PLAIN, 26));
		uploadpicbutton.setBounds(671, 209, 207, 40);
		contentPane.add(uploadpicbutton);
		//�ϴ�ͼƬ��ť
		

		
		JLabel backgroundpidlabel = new JLabel("");
		backgroundpidlabel.setFont(new Font("��������", Font.PLAIN, 30));
		backgroundpidlabel.setIcon(new ImageIcon(UploadNovelView.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710224105.png")));
		backgroundpidlabel.setBounds(0, 0, 1098, 781);
		contentPane.add(backgroundpidlabel);
		//�����ϴ�С˵����ı���ͼƬ��ǩ

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
			    conn = DLUtil.getCon();// ��ȡ���ݿ�����
				ndi.article.setTitle((novelnametext.getText()));
				ndi.article.setContent(contenttext.getText());
				ndi.article.setWriter((novelwritertext.getText()));
				ndi.article.setPicture((novelpicturetext.getText()));//��Ҫ�ϴ���С˵��Ϣ����nnovel������
				if ("".equals(titlewarnlabel.getText()) && "".equals(writerwarnlabel.getText())
						&& "".equals(picturewarnlabel.getText())
						&& "".equals(contentwarnlabel.getText()) && !("".equals(novelnametext.getText()))
						&& !("".equals(contenttext.getText())) && !("".equals(novelwritertext.getText()))
						&& !("".equals(novelpicturetext.getText()))) {//���ж������ı������Ϊ�������о����ǩ��Ϊ��,��������������ݷ��Ϲ涨
					try {
						if (ndi.add(conn, ndi.article)!=0)//����С˵�ϴ�����
							JOptionPane.showMessageDialog(null, "�ϴ��ɹ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
					} catch (HeadlessException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "�ϴ�ʧ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		//���л�С˵��ť���ü���
	}
}
