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
		//�����ϴ��½ڽ��洰��
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
		//�����������

		JButton returnbutton = new JButton("\u8FD4\u56DE\u5C0F\u8BF4\u754C\u9762");		
		returnbutton.setBackground(new Color(224, 255, 255));
		returnbutton.setBounds(626, 34, 235, 41);
		returnbutton.setFont(new Font("��������", Font.BOLD, 30));
		contentPane.add(returnbutton);
		//�������ذ�ť
		
        returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UploadNovelView.UploadNovelViewInit();//������ذ�ť,��ת���ϴ�С˵����
			}
		});
        //�Է��ذ�ť���ü���
        
		JLabel novelidlabel = new JLabel("\u5C0F\u8BF4ID\uFF1A");
		novelidlabel.setForeground(new Color(255, 255, 0));
		novelidlabel.setBounds(83, 112, 122, 33);
		novelidlabel.setFont(new Font("��������", Font.BOLD, 30));
		contentPane.add(novelidlabel);
		//����С˵id��ǩ

		JLabel novelidshowlabel = new JLabel("New label");
		novelidshowlabel.setForeground(new Color(255, 255, 0));
		novelidshowlabel.setBounds(204, 111, 137, 41);
		novelidshowlabel.setFont(new Font("����", Font.PLAIN, 30));
		contentPane.add(novelidshowlabel);
		//����С˵id��ʾ��ǩ

		JLabel chaptername = new JLabel("\u7AE0\u8282\u540D\uFF1A");
		chaptername.setForeground(new Color(255, 255, 0));
		chaptername.setBounds(85, 168, 154, 47);
		chaptername.setFont(new Font("��������", Font.BOLD, 30));
		contentPane.add(chaptername);
		//�����½�����ǩ

		JLabel chaptercontentlabel = new JLabel("\u7AE0\u8282\u5185\u5BB9\uFF1A");
		chaptercontentlabel.setForeground(new Color(255, 255, 0));
		chaptercontentlabel.setBounds(62, 225, 161, 50);
		chaptercontentlabel.setFont(new Font("��������", Font.BOLD, 30));
		contentPane.add(chaptercontentlabel);
		//�����½����ݱ�ǩ

		chaptercontenttext = new JTextField();
		chaptercontenttext.setBounds(81, 285, 802, 233);
		contentPane.add(chaptercontenttext);
		chaptercontenttext.setColumns(10);
		//�����½������ı���

		ChapterDaoilplement cdi = new ChapterDaoilplement();//�����½�Daoʵ�������
		JButton okbutton = new JButton("\u786E\u8BA4\u4E0A\u4F20");
		okbutton.setBackground(new Color(224, 255, 255));
		//����ȷ�ϰ�ť

		NovelDaoImplement ndi = new NovelDaoImplement();//����С˵Daoʵ�������
		
		novelidshowlabel.setText(String.valueOf(ndi.nnovelid));
		okbutton.setFont(new Font("��������", Font.PLAIN, 30));
		okbutton.setBounds(626, 142, 235, 47);
		contentPane.add(okbutton);
		//����С˵id��ʾ��ǩ

		chapternametext = new JTextField();
		chapternametext.setBounds(199, 183, 345, 33);
		contentPane.add(chapternametext);
		chapternametext.setColumns(10);
		//�����½������ı���

		JLabel chapternamewarnlabel = new JLabel("");
		chapternamewarnlabel.setForeground(new Color(255, 0, 0));
		chapternamewarnlabel.setBounds(204, 225, 461, 23);
		contentPane.add(chapternamewarnlabel);
		//�����½ڱ������뾯���ǩ

		JLabel chaptercontentwarnlabel = new JLabel("");
		chaptercontentwarnlabel.setForeground(Color.RED);
		chaptercontentwarnlabel.setBounds(83, 528, 789, 23);
		contentPane.add(chaptercontentwarnlabel);
		//�����½��������뾯���ǩ

		JLabel backgroundpiclabel = new JLabel("");
		backgroundpiclabel.setIcon(new ImageIcon(UploadchapterView.class.getResource("/UserPackage/src/newimages/e53d30373cde0cd4e20c4dcb56640f9.png")));
		backgroundpiclabel.setBounds(0, 0, 912, 553);
		contentPane.add(backgroundpiclabel);
		//�����ϴ��½ڽ��汳��ͼƬ��ǩ

		ChapternameTextKeyListener cntkl = new ChapternameTextKeyListener(chapternamewarnlabel, chapternametext);
		chapternametext.addKeyListener(cntkl);
		//�������½ڱ�������ļ��̼���
		ChapterContentTextKeyListener nwtkl = new ChapterContentTextKeyListener(chaptercontentwarnlabel,chaptercontenttext);
		chaptercontenttext.addKeyListener(nwtkl);
		//�������½���������ļ��̼���

		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cdi.chapter.setChaptername(chapternametext.getText());
				cdi.chapter.setChaptercontent(chaptercontenttext.getText());//���û����������������½�ʵ����
				if ("".equals(chapternamewarnlabel.getText()) && "".equals(chaptercontentwarnlabel.getText())
						&& !("".equals(chapternametext.getText())) && !("".equals(chaptercontenttext.getText()))) {//�������ı���Ϊ�������о����ǩ����ʾ����ʱ
					if (cdi.chapterupload())//�����ϴ��½ڷ���
						JOptionPane.showMessageDialog(null, "�ϴ��ɹ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);//�ɹ�,��������

				} else {
					JOptionPane.showMessageDialog(null, "�ϴ�ʧ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		//������ȷ���ϴ���ť�ļ���
	}
}
