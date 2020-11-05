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
		//�����������

		JButton returnbutton = new JButton("\u8FD4\u56DE\u9996\u9875");		
		returnbutton.setBounds(904, 24, 184, 51);
		returnbutton.setFont(new Font("��������", Font.BOLD, 35));
		contentPane.add(returnbutton);
		//�������ذ�ť
		returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomepageView.homepageInit();//�����ť,��ת����ҳ����
			}
		});
		//Ϊ���ذ�ť���ü���

		JLabel novelnamelabel = new JLabel("\u5C0F\u8BF4\u6807\u9898\uFF1A");
		novelnamelabel.setForeground(new Color(255, 255, 0));
		novelnamelabel.setBounds(10, 80, 177, 40);
		novelnamelabel.setFont(new Font("��������", Font.BOLD, 30));
		contentPane.add(novelnamelabel);
		//����С˵���ֱ�ǩ

		novelwritertext = new JTextField();
		novelwritertext.setBounds(229, 148, 345, 33);
		contentPane.add(novelwritertext);
		novelwritertext.setColumns(10);
		//����С˵�����ı���

		JLabel novelwriterlabel = new JLabel("\u5C0F\u8BF4\u4F5C\u8005\uFF1A");
		novelwriterlabel.setForeground(new Color(255, 255, 0));
		novelwriterlabel.setBounds(10, 140, 167, 33);
		novelwriterlabel.setFont(new Font("��������", Font.BOLD, 30));
		contentPane.add(novelwriterlabel);
		//����С˵���߱�ǩ

		novelpicturetext = new JTextField();
		novelpicturetext.setBounds(407, 222, 345, 33);
		contentPane.add(novelpicturetext);
		novelpicturetext.setColumns(10);
		//����С˵ͼƬ·���ı���
		

		JLabel novelmainlabel = new JLabel("\u5C0F\u8BF4\u6897\u6982\uFF1A");
		novelmainlabel.setForeground(new Color(255, 255, 0));
		novelmainlabel.setBounds(10, 417, 167, 47);
		novelmainlabel.setFont(new Font("��������", Font.BOLD, 30));
		contentPane.add(novelmainlabel);
		//����С˵���ű�ǩ

		JButton okbutton = new JButton("\u786E\u8BA4\u4E0A\u4F20");
		okbutton.setBounds(407, 567, 167, 47);
		okbutton.setFont(new Font("��������", Font.BOLD, 30));
		contentPane.add(okbutton);
		//����ȷ���ϴ�С˵��Ϣ��ť

		novelnametext = new JTextField();
		novelnametext.setBounds(229, 92, 345, 33);
		contentPane.add(novelnametext);
		novelnametext.setColumns(10);
		//����С˵�����ı���

		JLabel novelpiclabel = new JLabel("\u5C0F\u8BF4\u56FE\u7247\u8DEF\u5F84\uFF1A");
		novelpiclabel.setForeground(new Color(255, 255, 0));
		novelpiclabel.setFont(new Font("��������", Font.PLAIN, 30));
		novelpiclabel.setBounds(10, 200, 235, 40);
		contentPane.add(novelpiclabel);
		//����С˵ͼƬ·����ǩ

		JLabel novelidlabel = new JLabel("\u5C0F\u8BF4id\uFF1A");
		novelidlabel.setForeground(new Color(255, 255, 0));
		novelidlabel.setFont(new Font("��������", Font.PLAIN, 30));
		novelidlabel.setBounds(32, 18, 123, 49);
		contentPane.add(novelidlabel);
		//����С˵id��ǩ

		JLabel novelidshowlabel = new JLabel("0");
		novelidshowlabel.setForeground(new Color(255, 255, 0));
		novelidshowlabel.setFont(new Font("��������", Font.PLAIN, 30));
		novelidshowlabel.setBounds(248, 35, 102, 27);
		contentPane.add(novelidshowlabel);
		//����С˵id��ʾ��ǩ

		JButton uploadbutton = new JButton("\u4E0A\u4F20\u7AE0\u8282");
		uploadbutton.setFont(new Font("��������", Font.PLAIN, 30));
		uploadbutton.setBounds(674, 21, 184, 54);
		contentPane.add(uploadbutton);
		//�����ϴ��½ڰ�ť

		JLabel searchnovelnamelabel = new JLabel("\u8F93\u5165\u5DF2\u4E0A\u4F20\u7684\u5C0F\u8BF4\u540D\uFF1A");
		searchnovelnamelabel.setForeground(new Color(255, 255, 0));
		searchnovelnamelabel.setFont(new Font("��������", Font.PLAIN, 30));
		searchnovelnamelabel.setBounds(659, 358, 304, 49);
		contentPane.add(searchnovelnamelabel);
		//�����л�С˵���뾯���ǩ

		searchnovelnametext = new JTextField();
		searchnovelnametext.setBounds(659, 472, 378, 47);
		contentPane.add(searchnovelnametext);
		searchnovelnametext.setColumns(10);
		//�����л�С˵�ı���

		JButton turnbutton = new JButton("\u5207\u6362\u5C0F\u8BF4");
		turnbutton.setFont(new Font("��������", Font.PLAIN, 30));
		turnbutton.setBounds(843, 567, 194, 47);
		contentPane.add(turnbutton);
		//�����л�С˵��ť

		JLabel novelclassifylabel = new JLabel("\u5C0F\u8BF4\u5206\u7C7B\uFF1A");
		novelclassifylabel.setFont(new Font("��������", Font.PLAIN, 30));
		novelclassifylabel.setForeground(new Color(255, 255, 0));
		novelclassifylabel.setBounds(10, 289, 157, 31);
		contentPane.add(novelclassifylabel);
		//����С˵�����ǩ

		JRadioButton schoollovebutton = new JRadioButton("\u9752\u6625\u6821\u56ED");
		schoollovebutton.setFont(new Font("��������", Font.PLAIN, 30));
		schoollovebutton.setBackground(new Color(255, 250, 250));
		schoollovebutton.setForeground(new Color(0, 0, 0));
		schoollovebutton.setBounds(173, 287, 157, 33);
		contentPane.add(schoollovebutton);
		//����С˵�����ഺУ԰�ĵ�ѡ��ť

		JRadioButton classicbutton = new JRadioButton("\u7ECF\u5178\u8457\u4F5C");
		classicbutton.setFont(new Font("��������", Font.PLAIN, 30));
		classicbutton.setBounds(356, 288, 157, 32);
		contentPane.add(classicbutton);
		//����С˵���ྭ�������ĵ�ѡ��ť

		JRadioButton fantasybutton = new JRadioButton("\u7384\u5E7B\u4ED9\u4FA0");
		fantasybutton.setFont(new Font("��������", Font.PLAIN, 30));
		fantasybutton.setBounds(173, 366, 157, 33);
		contentPane.add(fantasybutton);
		//����С˵�������������ĵ�ѡ��ť

		JRadioButton sciencebutton = new JRadioButton("\u60AC\u7591\u79D1\u5E7B");
		sciencebutton.setFont(new Font("��������", Font.PLAIN, 30));
		sciencebutton.setBounds(356, 366, 157, 33);
		contentPane.add(sciencebutton);
		//����С˵�������ɿƻõĵ�ѡ��ť

		JLabel noveltitlewarnlabel = new JLabel("");
		noveltitlewarnlabel.setForeground(new Color(255, 0, 0));
		noveltitlewarnlabel.setBounds(82, 130, 504, 19);
		contentPane.add(noveltitlewarnlabel);
		//����С˵��Ŀ���뾯���ǩ

		JLabel novelwriterwarnlabel = new JLabel("");
		novelwriterwarnlabel.setForeground(Color.RED);
		novelwriterwarnlabel.setBounds(95, 183, 504, 19);
		contentPane.add(novelwriterwarnlabel);
		//����С˵�������뾯���ǩ

		JLabel novelpicturewarnlabel = new JLabel("");
		novelpicturewarnlabel.setForeground(Color.RED);
		novelpicturewarnlabel.setBounds(82, 253, 504, 19);
		contentPane.add(novelpicturewarnlabel);
		//����С˵ͼƬ·�����뾯���ǩ

		JLabel novelclassifywarnlabel = new JLabel("");
		novelclassifywarnlabel.setForeground(Color.RED);
		novelclassifywarnlabel.setBounds(528, 327, 504, 19);
		contentPane.add(novelclassifywarnlabel);
		//����С˵���ྯ���ǩ

		JLabel novelmainwarnlabel = new JLabel("");
		novelmainwarnlabel.setForeground(Color.RED);
		novelmainwarnlabel.setBounds(70, 531, 504, 19);
		contentPane.add(novelmainwarnlabel);
		//�ƽ�С˵�������뾯���ǩ

		JLabel noveltitlechangewarnlabel = new JLabel("");
		noveltitlechangewarnlabel.setForeground(Color.RED);
		noveltitlechangewarnlabel.setBounds(648, 529, 413, 19);
		contentPane.add(noveltitlechangewarnlabel);
		//����С˵�������뾯���ǩ

		ButtonGroup bg = new ButtonGroup();
		bg.add(sciencebutton);
		bg.add(fantasybutton);
		bg.add(classicbutton);
		bg.add(schoollovebutton);
		//����������,���ĸ�����ѡ��ť����������

		novelmaintext = new JTextField();
		novelmaintext.setBounds(82, 470, 492, 51);
		contentPane.add(novelmaintext);
		novelmaintext.setColumns(10);
		//����С˵��Ҫ�ı���
		
		JLabel uploadpicturelabel = new JLabel("\u9884\u89C8\u56FE\u7247\uFF1A");
		uploadpicturelabel.setFont(new Font("��������", Font.PLAIN, 27));
		uploadpicturelabel.setForeground(Color.YELLOW);
		uploadpicturelabel.setBounds(794, 85, 142, 40);
		contentPane.add(uploadpicturelabel);
		//Ԥ��ͼƬ��ǩ
		
		JLabel uploadpiclabel = new JLabel("");
		uploadpiclabel.setBounds(768, 134, 320, 231);
		contentPane.add(uploadpiclabel);
		//ͼƬչʾ��ǩ	
		
		JButton uploadpicbutton = new JButton("\u4E0A\u4F20\u56FE\u7247");
		uploadpicbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ndi.addPicture(uploadpicbutton, uploadpiclabel,novelpicturetext);
			}
		});
		uploadpicbutton.setFont(new Font("��������", Font.PLAIN, 26));
		uploadpicbutton.setBounds(222, 212, 167, 40);
		contentPane.add(uploadpicbutton);
		//�ϴ�ͼƬ��ť
		

		
		JLabel backgroundpidlabel = new JLabel("");
		backgroundpidlabel.setFont(new Font("��������", Font.PLAIN, 30));
		backgroundpidlabel.setIcon(new ImageIcon(UploadNovelView.class.getResource("/png/26.jpg")));
		backgroundpidlabel.setBounds(0, 0, 1098, 781);
		contentPane.add(backgroundpidlabel);
		//�����ϴ�С˵����ı���ͼƬ��ǩ

		NovelTitleTextKeyListener nttkl = new NovelTitleTextKeyListener(noveltitlewarnlabel, novelnametext, "upload");
		novelnametext.addKeyListener(nttkl);
		//����С˵�����ı�������ļ��̼���
		NovelWriterTextKeyListener nwtkl = new NovelWriterTextKeyListener(novelwriterwarnlabel, novelwritertext);
		novelwritertext.addKeyListener(nwtkl);
		//����С˵�����ı�������ļ��̼���
		NovelMainTextKeyListener nmtkl = new NovelMainTextKeyListener(novelmainwarnlabel, novelmaintext);
		novelmaintext.addKeyListener(nmtkl);
		//����С˵��Ҫ�ı�������ļ��̼���
		NovelPictureTextKeyListener nptkl = new NovelPictureTextKeyListener(novelpicturewarnlabel, novelpicturetext);
		novelpicturetext.addKeyListener(nptkl);
		//����С˵ͼƬ�ı�������ļ��̼���
		NovelTitleTextKeyListener ntttkl = new NovelTitleTextKeyListener(noveltitlechangewarnlabel, searchnovelnametext,"change");
		novelnametext.addKeyListener(ntttkl);
		//�����л���С˵�����ı�������ļ��̼���

		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ndi.nnovel.setNovelname(novelnametext.getText());
				ndi.nnovel.setNovelmain(novelmaintext.getText());
				ndi.nnovel.setNovelwriter(novelwritertext.getText());
				ndi.nnovel.setNovelpicture(novelpicturetext.getText());//��Ҫ�ϴ���С˵��Ϣ����nnovel������
				if (schoollovebutton.isSelected()) {
					novelclassifywarnlabel.setText("");//���þ����ǩΪ��
					ndi.nnovel.setClassifyid(2);//�ֱ��ж�ѡ��ĵ�ѡ��ť���ĸ�,ѡ��Ķ�Ӧ�ķ���id����nnovel����classifyid��
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
					novelclassifywarnlabel.setText("����ѡ���Ϊ��");//�ĸ�ѡ�����Ϊ��,�����þ����ǩ��ʾ����
				}
				if ("".equals(noveltitlewarnlabel.getText()) && "".equals(novelwriterwarnlabel.getText())
						&& "".equals(novelpicturewarnlabel.getText()) && "".equals(novelclassifywarnlabel.getText())
						&& "".equals(novelmainwarnlabel.getText()) && !("".equals(novelnametext.getText()))
						&& !("".equals(novelmaintext.getText())) && !("".equals(novelwritertext.getText()))
						&& !("".equals(novelpicturetext.getText()))) {//���ж������ı������Ϊ�������о����ǩ��Ϊ��,��������������ݷ��Ϲ涨
					if (ndi.novelupload())//����С˵�ϴ�����
						JOptionPane.showMessageDialog(null, "�ϴ��ɹ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "�ϴ�ʧ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		//ȷ�ϰ�ť���ü���

		uploadbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UploadchapterView.UploadchapterViewInit();//�����ť��ת���ϴ��½�ҳ��
			}
		});
		//���ϴ��½ڰ�ť���ü���
		
		turnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ndi.isUpload(searchnovelnametext.getText()) && "".equals(noveltitlechangewarnlabel.getText())
						&& !("".equals(searchnovelnametext.getText()))) {//�ȵ���isUpload�鿴�Ƿ��Ѵ���Ҫ�л� ��С˵��,�ж������ʽ��ǩ�ޱ���,������������
					JOptionPane.showMessageDialog(null, "�л��ɹ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
					novelidshowlabel.setText(String.valueOf(ndi.nnovelid));//���л���С˵id����xiaoshuoid��ʾ��ǩ

				} else {
					JOptionPane.showMessageDialog(null, "�л�ʧ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		//���л�С˵��ť���ü���
	}
}
