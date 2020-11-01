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
		//创建小说介绍界面窗口
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public UsershoucangView() throws Exception {
		ArticleImplement ndi = new ArticleImplement();//创建Dao实现类对象
		UserDaoImplement udi = new UserDaoImplement();//创建用户Dao实现类对象
		CollectionImplement cdi=new CollectionImplement();
		Connection conn = DLUtil.getCon();// 获取数据库连接

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
		//创建内容面板

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1578, 833);
		contentPane.add(panel);
		panel.setLayout(null);
		//创建小说概要显示标签

		JButton returnbutton = new JButton("\u8FD4\u56DE\u9996\u9875");		
		returnbutton.setIcon(new ImageIcon(UsershoucangView.class.getResource("/images/\u9000\u51FA.png")));
		returnbutton.setBackground(new Color(224, 255, 255));
		returnbutton.setForeground(new Color(139, 0, 0));
		returnbutton.setBounds(792, 42, 216, 47);
		panel.add(returnbutton);
		returnbutton.setFont(new Font("方正舒体", Font.BOLD, 30));
        returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomepageView.homepageInit();//创建返回按钮监听,点击则跳转首页界面
			}
		});
		
		
		ArticleImplement adi = new ArticleImplement();//创建Dao实现类对象
		adi.articlelist(conn, adi.d,"收藏的博文");
		
		JScrollPane jp_1 = new JScrollPane();
		jp_1.setBounds(102, 99, 625, 691);
		panel.add(jp_1);
		
		JList list_1 = new JList();
		list_1.setForeground(Color.RED);
		list_1.setFont(new Font("华文新魏", Font.PLAIN, 28));
		list_1.setBackground(new Color(255, 228, 225));
		list_1.setModel(cdi.d);
		list_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!list_1.getValueIsAdjusting()) { // 设置只有释放鼠标时才触发
					if (udi.userid!= 0) {
						ndi.title = (String) list_1.getSelectedValue();
						ContentView.ContentViewInit();//跳转至章节阅读界面
					} else
						JOptionPane.showMessageDialog(null, "您无权限，请先登录", "提示", JOptionPane.PLAIN_MESSAGE);
				}

			}

		});
		jp_1.setViewportView(list_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u6536\u85CF\u5939");
		lblNewLabel_1.setIcon(new ImageIcon(UsershoucangView.class.getResource("/images/\u56FE\u4E66(3).png")));
		lblNewLabel_1.setForeground(new Color(139, 69, 19));
		lblNewLabel_1.setFont(new Font("方正舒体", Font.PLAIN, 36));
		lblNewLabel_1.setBackground(new Color(255, 245, 238));
		lblNewLabel_1.setBounds(102, 23, 191, 66);
		panel.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UsershoucangView.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710224105.png")));
		lblNewLabel.setBounds(0, 0, 1550,870);
		panel.add(lblNewLabel);
		//创建小说介绍界面背景图片
	}
	}

