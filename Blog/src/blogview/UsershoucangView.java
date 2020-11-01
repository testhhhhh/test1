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
import daoimplement.CollectionImplement;
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

public class UsershoucangView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void UsershoucangViewViewInit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsershoucangView frame = new UsershoucangView();
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
	public UsershoucangView() throws Exception {
		ArticleImplement ndi = new ArticleImplement();//����Daoʵ�������
		UserDaoImplement udi = new UserDaoImplement();//�����û�Daoʵ�������
		CollectionImplement cdi=new CollectionImplement();
		Connection conn = DLUtil.getCon();// ��ȡ���ݿ�����

		System.out.println(cdi.collectionlist(conn, udi.userid, cdi.d));;
		System.out.println( udi.userid);
		setTitle("\u6536\u85CF\u5939");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1048, 870);
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
		//����С˵��Ҫ��ʾ��ǩ

		JButton returnbutton = new JButton("\u8FD4\u56DE\u9996\u9875");		
		returnbutton.setIcon(new ImageIcon(UsershoucangView.class.getResource("/images/\u9000\u51FA.png")));
		returnbutton.setBackground(new Color(224, 255, 255));
		returnbutton.setForeground(new Color(139, 0, 0));
		returnbutton.setBounds(792, 42, 216, 47);
		panel.add(returnbutton);
		returnbutton.setFont(new Font("��������", Font.BOLD, 30));
        returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomepageView.homepageInit();//�������ذ�ť����,�������ת��ҳ����
			}
		});
		
		
		ArticleImplement adi = new ArticleImplement();//����Daoʵ�������
		adi.articlelist(conn, adi.d,"�ղصĲ���");
		
		JScrollPane jp_1 = new JScrollPane();
		jp_1.setBounds(102, 99, 625, 691);
		panel.add(jp_1);
		
		JList list_1 = new JList();
		list_1.setForeground(Color.RED);
		list_1.setFont(new Font("������κ", Font.PLAIN, 28));
		list_1.setBackground(new Color(255, 228, 225));
		list_1.setModel(cdi.d);
		list_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!list_1.getValueIsAdjusting()) { // ����ֻ���ͷ����ʱ�Ŵ���
					if (udi.userid!= 0) {
						ndi.title = (String) list_1.getSelectedValue();
						ContentView.ContentViewInit();//��ת���½��Ķ�����
					} else
						JOptionPane.showMessageDialog(null, "����Ȩ�ޣ����ȵ�¼", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				}

			}

		});
		jp_1.setViewportView(list_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u6536\u85CF\u5939");
		lblNewLabel_1.setIcon(new ImageIcon(UsershoucangView.class.getResource("/images/\u56FE\u4E66(3).png")));
		lblNewLabel_1.setForeground(new Color(139, 69, 19));
		lblNewLabel_1.setFont(new Font("��������", Font.PLAIN, 36));
		lblNewLabel_1.setBackground(new Color(255, 245, 238));
		lblNewLabel_1.setBounds(102, 23, 191, 66);
		panel.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UsershoucangView.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710224105.png")));
		lblNewLabel.setBounds(0, 0, 1550,870);
		panel.add(lblNewLabel);
		//����С˵���ܽ��汳��ͼƬ
	}
	}

