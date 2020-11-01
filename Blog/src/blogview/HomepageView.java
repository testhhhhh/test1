package blogview;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.table.DefaultTableModel;

import adminview.LoginFrm;
import adminview.UserAddInterFrm;
import daoimplement.ArticleImplement;
import daoimplement.UserDaoImplement;
import entity.Ariticle;
import jdbc.DLUtil;

public class HomepageView extends JFrame {
	public static String username;
	private JTable blogtable;
	private JTextField searchtextField;
	Connection conn=DLUtil.getCon();

	/**
	 * Launch the application.
	 */
	public static void homepageInit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomepageView frame = new HomepageView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		// ������ҳ����
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public HomepageView() throws Exception {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		int x = Toolkit.getDefaultToolkit().getScreenSize().width;
		int y = Toolkit.getDefaultToolkit().getScreenSize().height;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1550, 870);
		getContentPane().setLayout(null);
		// �����������

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1536, 833);
		getContentPane().add(panel);
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.RED);
		panel.setLayout(null);
		// �����������ı�ǩ

		ArticleImplement ndi = new ArticleImplement();// ����Daoʵ�������
		ndi.articlelist(jdbc.DLUtil.getCon(), ndi.d5,"��ҳ���Ų���");// �����б�չʾ����

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBackground(new Color(176, 224, 230));
		tabbedPane.setFont(new Font("������κ", Font.PLAIN, 30));
		tabbedPane.setBounds(0, 0, 1536, 870);
		panel.add(tabbedPane);

		JPanel userview = new JPanel();
		tabbedPane.addTab("��¼ע�����", null, userview, null);
		userview.setLayout(null);
		// ����ע�ᰴť

		JLabel titlelabel = new JLabel("\u65E7\u6D6A\u535A\u5BA2");

		titlelabel.setBounds(84, 62, 596, 180);
		userview.add(titlelabel);
		titlelabel.setForeground(new Color(255, 255, 204));
		titlelabel.setBackground(Color.BLACK);
		titlelabel.setFont(new Font("��������", Font.BOLD, 99));

		JButton loginbutton = new JButton("\u767B\u9646");
		loginbutton.setBounds(215, 299, 157, 37);
		userview.add(loginbutton);
		loginbutton.setBackground(new Color(173, 216, 230));
		loginbutton.setFont(new Font("��������", Font.BOLD, 30));
		// ������¼��ť

		JButton registerbutton = new JButton("\u6CE8\u518C");
		registerbutton.setBounds(215, 405, 157, 37);
		userview.add(registerbutton);
		registerbutton.setBackground(new Color(173, 216, 230));
		registerbutton.setForeground(Color.BLACK);
		registerbutton.setFont(new Font("��������", Font.BOLD, 30));

		JLabel loginpiclabel = new JLabel("");
		loginpiclabel
				.setIcon(new ImageIcon(HomepageView.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710215515.png")));
		loginpiclabel.setBounds(0, 0, 1356, 833);
		userview.add(loginpiclabel);

		registerbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registerview.registerInit();

			}
		});
		// Ϊע�ᰴť���ü���,���ע�ᰴť��ת��ע�����

		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loginview.loginlnit();
			}
		});

		UserDaoImplement udi1 = new UserDaoImplement();// �����û�Daoʵ�������
		// Ϊ�������ı�ǩ����������,���û�id��Ϊ0ʱ���û���¼��,������תҳ������������ҳ��

		UserDaoImplement udi = new UserDaoImplement();// �����û�Daoʵ�������

		JPanel mainview = new JPanel();

		tabbedPane.addTab("���˲���", null, mainview, null);
		mainview.setBackground(new Color(153, 255, 204));
		mainview.setLayout(null);
		JScrollPane schooljp = new JScrollPane();
		schooljp.setBounds(25, 182, 620, 644);		
		mainview.add(schooljp);		
		JList list = new JList();
		list.setForeground(new Color(0, 0, 0));		
		list.setFont(new Font("������κ", Font.PLAIN, 28));
		list.setModel(ndi.d5);
		list.setBackground(new Color(224, 255, 255));
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!list.getValueIsAdjusting()) { // ����ֻ���ͷ����ʱ�Ŵ���
			    ndi.title=(String)list.getSelectedValue(); 		
				ContentView.ContentViewInit();// �н������ת������ҳ��					
				}
			}
		});
		schooljp.setViewportView(list);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 204));
		panel_5.setBounds(0, 42, 1367, 59);
		mainview.add(panel_5);
		panel_5.setLayout(null);
		// �����������ı�ǩ

		JLabel uploadbloglabel = new JLabel("\u521B\u4F5C\u4E2D\u5FC3");
		uploadbloglabel.setBounds(336, 5, 179, 48);
		panel_5.add(uploadbloglabel);
		uploadbloglabel.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u521B\u4F5C(1).png")));
		uploadbloglabel.setForeground(new Color(0, 100, 0));
		uploadbloglabel.setFont(new Font("��������", Font.BOLD, 30));
		uploadbloglabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (udi.userid != 0) {
					UploadNovelView.UploadNovelViewInit();
				} else
					JOptionPane.showMessageDialog(null, "����Ȩ�ޣ����ȵ�¼", "��ʾ", JOptionPane.PLAIN_MESSAGE);
			}
		});
				JLabel personallabel = new JLabel("\u4E2A\u4EBA\u4E2D\u5FC3");
				personallabel.setBounds(80, 11, 183, 37);
				panel_5.add(personallabel);
				personallabel.setIcon(
						new ImageIcon(HomepageView.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC,\u7B11\u8138(1).png")));
				personallabel.setForeground(new Color(0, 100, 0));
				personallabel.setFont(new Font("��������", Font.BOLD, 30));
				personallabel.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						// Ϊ�ϴ���ǩ����������,���û�id��Ϊ0ʱ���û���¼��,������תҳ�����ϴ�ҳ��
						if (udi.userid != 0)
							PersonalCentreView.PersonalCentrelnit();
						else
							JOptionPane.showMessageDialog(null, "����Ȩ�ޣ����ȵ�¼", "��ʾ", JOptionPane.PLAIN_MESSAGE);
					}
				});
				
				JLabel shoucanglabel = new JLabel("\u6536\u85CF\u5939");
				shoucanglabel.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u56FE\u4E66(3).png")));
				shoucanglabel.setForeground(new Color(0, 100, 0));
				shoucanglabel.setFont(new Font("��������", Font.BOLD, 30));
				shoucanglabel.setBounds(650, 5, 179, 48);
				panel_5.add(shoucanglabel);
				shoucanglabel.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						// Ϊ�ϴ���ǩ����������,���û�id��Ϊ0ʱ���û���¼��,������תҳ�����ϴ�ҳ��
						if (udi.userid != 0)
							UsershoucangView.UsershoucangViewViewInit();
						else
							JOptionPane.showMessageDialog(null, "����Ȩ�ޣ����ȵ�¼", "��ʾ", JOptionPane.PLAIN_MESSAGE);
					}
				});
				
				JLabel zhuyelabel = new JLabel("\u6211\u7684\u4E3B\u9875");
				zhuyelabel.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u91CD\u7F6E.png")));
				zhuyelabel.setForeground(new Color(0, 100, 0));
				zhuyelabel.setFont(new Font("��������", Font.BOLD, 30));
				zhuyelabel.setBounds(877, 11, 183, 37);
				panel_5.add(zhuyelabel);
				zhuyelabel.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						// Ϊ�ϴ���ǩ����������,���û�id��Ϊ0ʱ���û���¼��,������תҳ�����ϴ�ҳ��
						if (udi.userid != 0)
							UserInteractiveView.UserInteractiveViewInit();
						else
							JOptionPane.showMessageDialog(null, "����Ȩ�ޣ����ȵ�¼", "��ʾ", JOptionPane.PLAIN_MESSAGE);
					}
				});
		
		
		JScrollPane schooljp_1 = new JScrollPane();
		schooljp_1.setBounds(687, 182, 620, 644);
		mainview.add(schooljp_1);
		
		ndi.articlelist(jdbc.DLUtil.getCon(), ndi.d,"��ҳ���²���");// �����б�չʾ����
		JList list_1 = new JList();
		list_1.setForeground(Color.BLACK);
		list_1.setFont(new Font("������κ", Font.PLAIN, 28));
		list_1.setBackground(new Color(230, 230, 250));
		list_1.setModel(ndi.d);
		list_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!list_1.getValueIsAdjusting()) { // ����ֻ���ͷ����ʱ�Ŵ���
			    ndi.title=(String)list_1.getSelectedValue(); 		
				ContentView.ContentViewInit();// �н������ת������ҳ��					
				}
			}
		});
		schooljp_1.setViewportView(list_1);
				
				JLabel lblNewLabel = new JLabel("\u70ED\u95E8\u535A\u5BA2\uFF1A");
				lblNewLabel.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u592A\u9633.png")));
				lblNewLabel.setForeground(new Color(220, 20, 60));
				lblNewLabel.setFont(new Font("��������", Font.PLAIN, 37));
				lblNewLabel.setBounds(25, 126, 292, 59);
				mainview.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("\u6700\u65B0\u535A\u5BA2\uFF1A");
				lblNewLabel_1.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u82B1.png")));
				lblNewLabel_1.setForeground(new Color(255, 218, 185));
				lblNewLabel_1.setFont(new Font("��������", Font.PLAIN, 37));
				lblNewLabel_1.setBounds(687, 132, 279, 46);
				mainview.add(lblNewLabel_1);
		
				JLabel mainpiclabel = new JLabel("");
				mainpiclabel.setIcon(new ImageIcon(HomepageView.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710215623.png")));
				mainpiclabel.setBounds(0, 0, 1367, 832);
				mainview.add(mainpiclabel);

		JPanel searchblog = new JPanel();
		tabbedPane.addTab("��������", null, searchblog, null);
		searchblog.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 215, 1202, 488);
		searchblog.add(scrollPane);

		blogtable = new JTable();
		blogtable.setBackground(new Color(255, 245, 238));
		blogtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = blogtable.getSelectedRow();// ��ȡ����
				searchtextField.setText((String) blogtable.getValueAt(row, 0)); // ����
				ndi.title = searchtextField.getText();
				Connection conn=new DLUtil().getCon();
				try {
					if (ndi.articleinteractive(conn,ndi.title)) {
						ContentView.ContentViewInit();// �н������ת������ҳ��
					} else {
						JOptionPane.showMessageDialog(null, "���������", "��ʾ", JOptionPane.PLAIN_MESSAGE);// ����������ʾ�޽��
					}
				} catch (HeadlessException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		blogtable.setRowHeight(33);
		blogtable.setForeground(SystemColor.textText);
		blogtable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "���ͱ���", "����", "��������" }) {
			boolean[] columnEditables = new boolean[] { false, false, false};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		blogtable.getColumnModel().getColumn(0).setPreferredWidth(88);
		blogtable.getColumnModel().getColumn(1).setPreferredWidth(158);
		blogtable.getColumnModel().getColumn(2).setPreferredWidth(86);
		blogtable.setFont(new Font("���ķ���", Font.PLAIN, 26));
		scrollPane.setViewportView(blogtable);

		// ������ť
		JButton searchbutton = new JButton("\u641C\u7D22");
		searchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent es) {
				SearchAction(es);
			}
		});
		searchbutton.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u641C\u7D22.png")));
		searchbutton.setFont(new Font("������κ", Font.PLAIN, 29));
		searchbutton.setBounds(944, 78, 146, 46);
		searchblog.add(searchbutton);

		searchtextField = new JTextField();
		searchtextField.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		searchtextField.setBounds(478, 79, 441, 46);
		searchblog.add(searchtextField);
		searchtextField.setColumns(10);

		JLabel inputlabel = new JLabel("\u8F93\u5165\u8BCD\u6761\uFF1A");
		inputlabel.setBackground(new Color(0, 0, 0));
		inputlabel.setForeground(new Color(0, 0, 0));
		inputlabel.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u56FE\u4E66(4).png")));
		inputlabel.setFont(new Font("��������", Font.BOLD, 30));
		inputlabel.setBounds(263, 78, 206, 40);
		searchblog.add(inputlabel);

		JLabel blogshowlabel = new JLabel(
				"\u70B9\u51FB\u4E0B\u65B9\u8868\u683C\u5185\u5BB9\u5373\u53EF\u8DF3\u8F6C\u76F8\u5E94\u535A\u5BA2");
		blogshowlabel.setForeground(new Color(0, 0, 0));
		blogshowlabel.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u5411\u4E0B.png")));
		blogshowlabel.setFont(new Font("��������", Font.PLAIN, 23));
		blogshowlabel.setBounds(117, 159, 424, 46);
		searchblog.add(blogshowlabel);

		JLabel searchpiclabel = new JLabel("");
		searchpiclabel.setBackground(new Color(255, 255, 255));
		searchpiclabel
				.setIcon(new ImageIcon(HomepageView.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710224042.png")));
		searchpiclabel.setBounds(0, 0, 1377, 834);
		searchblog.add(searchpiclabel);

		JPanel Adminview = new JPanel();
		tabbedPane.addTab("���͹����", null, Adminview, null);
		Adminview.setLayout(null);

		JButton adminbutton = new JButton("\u767B\u9646\u5165\u53E3");
		adminbutton.setBackground(new Color(173, 216, 230));
		adminbutton.setIcon(
				new ImageIcon(HomepageView.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC,\u7B11\u8138.png")));
		adminbutton.setFont(new Font("΢���ź�", Font.PLAIN, 23));
		adminbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginFrm().setVisible(true);
				HomepageView();
			}
		});
		adminbutton.setBounds(281, 318, 221, 58);
		Adminview.add(adminbutton);
		
		JLabel titlelabel_1 = new JLabel("\u65E7\u6D6A\u535A\u5BA2\u7BA1\u7406\u7AEF");
		titlelabel_1.setForeground(new Color(255, 255, 204));
		titlelabel_1.setFont(new Font("��������", Font.BOLD, 99));
		titlelabel_1.setBackground(Color.BLACK);
		titlelabel_1.setBounds(61, 59, 732, 180);
		Adminview.add(titlelabel_1);

		JLabel adminpiclabel = new JLabel("");
		adminpiclabel
				.setIcon(new ImageIcon(HomepageView.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710224054.png")));
		adminpiclabel.setBounds(-593, -24, 1916, 855);
		Adminview.add(adminpiclabel);
		// ��������ͼƬ��ǩ

		// ���������
		this.filltable(new Ariticle());
		this.blogtable.setVisible(true);
	}

	protected void HomepageView() {
		// TODO Auto-generated method stub
		this.dispose();
	}

	// ��������
	protected void SearchAction(ActionEvent es) {
		// TODO Auto-generated method stub
		String title = this.searchtextField.getText().trim();// ��ȡС˵����
		Ariticle article = new Ariticle(title);// ��װ����
		this.filltable(article);// ���ñ������
		this.searchtextField.setText("");
	}

	// ��ʼ���������
	private void filltable(Ariticle article) {
		DefaultTableModel dtm = (DefaultTableModel) blogtable.getModel();// ���model�����г�ʼ��
		dtm.setRowCount(0);// ���ó�0�У���ձ��
		Connection conn = null;
		try {
			conn = DLUtil.getCon();// ��ȡ���ݿ�����
			ResultSet rs = new ArticleImplement().list(conn, article);

			// �ü��Ͻ��б���
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("title"));
				v.add(rs.getString("content"));
				v.add(rs.getString("writer"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DLUtil.CloseCon(conn);// �ر����ݿ�����
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
