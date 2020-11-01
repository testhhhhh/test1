package blogview;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import daoimplement.ArticleImplement;
import daoimplement.UserDaoImplement;
import jdbc.DLUtil;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class UserInteractiveView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void UserInteractiveViewInit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInteractiveView frame = new UserInteractiveView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//����С˵���ܽ��洰��
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public UserInteractiveView() throws Exception {
		ArticleImplement ndi = new ArticleImplement();//����Daoʵ�������
		UserDaoImplement udi = new UserDaoImplement();//�����û�Daoʵ�������
		ArticleImplement adi = new ArticleImplement();//����Daoʵ�������		
		Connection conn = DLUtil.getCon();// ��ȡ���ݿ�����
		udi.userinteractive(conn, udi.userid);

		setTitle("\u6211\u7684\u4E3B\u9875");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 997, 870);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//�����������

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1578, 833);
		contentPane.add(panel);
		panel.setLayout(null);
		//����С˵ͼƬ��ǩ

		JLabel usernamelabel = new JLabel("\u7528\u6237\u540D\u79F0\uFF1A");
		usernamelabel.setIcon(new ImageIcon(UserInteractiveView.class.getResource("/images/\u4E2A\u4EBA\u4FE1\u606F_\u5B9D\u8D1D\u59D3\u540D.png")));
		usernamelabel.setForeground(new Color(139, 0, 0));
		usernamelabel.setFont(new Font("��������", Font.BOLD, 30));
		usernamelabel.setBounds(44, 228, 207, 40);
		panel.add(usernamelabel);
		//����С˵���Ʊ�ǩ

		JLabel usernameshowlabel = new JLabel("");
		usernameshowlabel.setForeground(new Color(139, 0, 0));
		usernameshowlabel.setFont(new Font("����", Font.PLAIN, 25));
		usernameshowlabel.setBounds(233, 228, 229, 40);
		usernameshowlabel.setText(udi.user.getUsername());
		panel.add(usernameshowlabel);
		//����С˵������ʾ��ǩ

		JLabel phonelabel = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
		phonelabel.setIcon(new ImageIcon(UserInteractiveView.class.getResource("/images/\u7528\u6237.png")));
		phonelabel.setForeground(new Color(139, 0, 0));
		phonelabel.setFont(new Font("��������", Font.BOLD, 30));
		phonelabel.setBounds(44, 320, 224, 33);
		panel.add(phonelabel);
		//����С˵���߱�ǩ

		JLabel phoneshowlabel = new JLabel("");
		phoneshowlabel.setForeground(new Color(139, 0, 0));
		phoneshowlabel.setFont(new Font("����", Font.PLAIN, 25));
		phoneshowlabel.setBounds(233, 320, 245, 47);
		phoneshowlabel.setText(udi.user.getPhone());
		panel.add(phoneshowlabel);
		//����С˵������ʾ��ǩ

		JLabel introducelabel = new JLabel("\u4E2A\u4EBA\u7B80\u4ECB\uFF1A");
		introducelabel.setIcon(new ImageIcon(UserInteractiveView.class.getResource("/images/\u5199\u4F5C.png")));
		introducelabel.setForeground(new Color(139, 0, 0));
		introducelabel.setFont(new Font("��������", Font.BOLD, 30));
		introducelabel.setBounds(44, 411, 224, 33);
		panel.add(introducelabel);
		//����С˵��Ҫ��ǩ

		JLabel novelmainshowlabel = new JLabel("");
		novelmainshowlabel.setFont(new Font("΢���ź�", Font.PLAIN, 23));
		novelmainshowlabel.setForeground(new Color(139, 0, 0));
		novelmainshowlabel.setBounds(44, 450, 399, 234);
		udi.JlabelSetText(novelmainshowlabel,udi.user.getUserintroduce());//���ñ�ǩ���ı��Զ����з���
		panel.add(novelmainshowlabel);
		//����С˵��Ҫ��ʾ��ǩ

		JButton returnbutton = new JButton("\u8FD4\u56DE\u9996\u9875");		
		returnbutton.setForeground(new Color(176, 224, 230));
		returnbutton.setBounds(752, 37, 191, 40);
		panel.add(returnbutton);
		returnbutton.setFont(new Font("��������", Font.BOLD, 30));
        returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomepageView.homepageInit();//�������ذ�ť����,�������ת��ҳ����
			}
		});
        //�������ذ�ť
        
		JScrollPane jp = new JScrollPane();
		jp.setBounds(481, 99, 462, 724);
		panel.add(jp);
		//�����½��б�������

		JList list = new JList();
		System.out.println(udi.userid);
		System.out.println(adi.articlelist(conn, adi.d,"����Ĳ���"));;
		list.setFont(new Font("������κ", Font.PLAIN, 28));
		list.setForeground(Color.RED);
		list.setBackground(new Color(255, 228, 225));
		list.setModel(adi.d);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!list.getValueIsAdjusting()) { // ����ֻ���ͷ����ʱ�Ŵ���
					if (udi.user.getUserid()!= 0) {
						ndi.title = (String) list.getSelectedValue();
						ContentView.ContentViewInit();//��ת���½��Ķ�����
					} else
						JOptionPane.showMessageDialog(null, "����Ȩ�ޣ����ȵ�¼", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				}

			}

		});
		jp.setViewportView(list);
		
		JLabel idlabel = new JLabel("\u7528\u6237ID\uFF1A");
		idlabel.setIcon(new ImageIcon(UserInteractiveView.class.getResource("/images/\u7F16\u53F7.png")));
		idlabel.setForeground(new Color(139, 0, 0));
		idlabel.setFont(new Font("��������", Font.BOLD, 30));
		idlabel.setBounds(44, 144, 197, 33);
		panel.add(idlabel);
		
		
		JLabel idshowlabel = new JLabel((String) null);
		idshowlabel.setForeground(new Color(139, 0, 0));
		idshowlabel.setFont(new Font("����", Font.PLAIN, 25));
		idshowlabel.setBounds(209, 144, 191, 40);
		panel.add(idshowlabel);
		idshowlabel.setText(String.valueOf(udi.user.getUserid()));
		
		JLabel myarticlelabel = new JLabel("\u53D1\u8868\u7684\u535A\u6587\uFF1A");
		myarticlelabel.setIcon(new ImageIcon(UserInteractiveView.class.getResource("/images/\u521B\u4F5C(1).png")));
		myarticlelabel.setForeground(new Color(139, 0, 0));
		myarticlelabel.setFont(new Font("��������", Font.BOLD, 30));
		myarticlelabel.setBounds(479, 45, 224, 44);
		panel.add(myarticlelabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u535A\u5BA2\u4E3B\u9875");
		lblNewLabel_1.setForeground(new Color(139, 69, 19));
		lblNewLabel_1.setFont(new Font("��������", Font.PLAIN, 75));
		lblNewLabel_1.setBackground(new Color(255, 245, 238));
		lblNewLabel_1.setBounds(35, 10, 309, 113);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UserInteractiveView.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710224105.png")));
		lblNewLabel.setBounds(10, 0, 1550,870);
		panel.add(lblNewLabel);
		//�������ܽ��汳��ͼƬ
	}
	

	}

