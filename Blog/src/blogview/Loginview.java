package blogview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import daoimplement.UserDaoImplement;
import entity.User;
import inputcheck.PasswordTextKeyListener;
import inputcheck.UserTextKeyListener;
import jdbc.DLUtil;

public class Loginview extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1193033664019583883L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void loginlnit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginview frame = new Loginview();
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
	public Loginview() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 1261, 768);
		setBounds(100, 100, 1253, 777);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//创建内容面板

				JPanel panel = new JPanel();
				panel.setBackground(new Color(255, 255, 204));
				panel.setBounds(0, 0, 680, 496);
				contentPane.add(panel);
				panel.setLayout(null);
				//创建一个面板

				JLabel usernamelabel = new JLabel("\u7528\u6237\u540D\uFF1A");
				usernamelabel.setForeground(Color.WHITE);
				usernamelabel.setBounds(104, 150, 130, 34);
				usernamelabel.setFont(new Font("方正舒体", Font.BOLD, 29));
				panel.add(usernamelabel);
				//创建用户名标签

				JLabel passwordlabel = new JLabel("\u5BC6   \u7801\uFF1A");
				passwordlabel.setForeground(Color.WHITE);
				passwordlabel.setFont(new Font("方正舒体", Font.BOLD, 29));
				passwordlabel.setBounds(115, 247, 119, 40);
				panel.add(passwordlabel);
				//创建密码标签

				JTextField usernametext = new JTextField();
				usernametext.setBounds(259, 153, 241, 41);
				panel.add(usernametext);
				usernametext.setColumns(10);
				//创建用户名文本框

				JButton loginbutton = new JButton("登陆");
				loginbutton.setBackground(new Color(255, 250, 205));
				loginbutton.setForeground(Color.BLACK);
				loginbutton.setFont(new Font("华文新魏", Font.PLAIN, 28));
				loginbutton.setBounds(176, 379, 104, 49);
				panel.add(loginbutton);
				//创建登录按钮

				JButton resetbutton = new JButton("重置");
				resetbutton.setBackground(new Color(255, 250, 205));
				resetbutton.setForeground(Color.BLACK);
				resetbutton.setFont(new Font("华文新魏", Font.PLAIN, 28));
				resetbutton.setBounds(422, 379, 104, 49);
				panel.add(resetbutton);
				//创建重置按钮
				
				JLabel sitetitlelabel = new JLabel("\u7528\u6237\u767B\u9646");
				sitetitlelabel.setForeground(Color.WHITE);
				sitetitlelabel.setFont(new Font("方正舒体", Font.BOLD, 63));
				sitetitlelabel.setBounds(238, 24, 430, 82);
				panel.add(sitetitlelabel);
				//创建网站标题标签

				JPasswordField passwordtext = new JPasswordField();
				passwordtext.setBounds(259, 254, 241, 41);
				panel.add(passwordtext);
				//创建密码文本框

				JLabel usernamewarnlabel = new JLabel("");
				usernamewarnlabel.setForeground(new Color(255, 255, 255));
				usernamewarnlabel.setBounds(259, 204, 418, 28);
				panel.add(usernamewarnlabel);
				//创建用户名输入警告标签

				JLabel passwordwarnlabel = new JLabel("");
				passwordwarnlabel.setForeground(new Color(255, 255, 255));
				passwordwarnlabel.setBounds(259, 305, 437, 28);
				panel.add(passwordwarnlabel);
				//创建密码输入警告标签	
				
				JLabel backgpiclabel = new JLabel("");
				backgpiclabel.setIcon(new ImageIcon(Loginview.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710224030.png")));
				backgpiclabel.setBounds(-294, 0, 1564, 740);
				panel.add(backgpiclabel);
				//创建背景图片标签

				UserTextKeyListener utkl = new UserTextKeyListener(usernamewarnlabel, usernametext, "login");
				usernametext.addKeyListener(utkl);
				PasswordTextKeyListener ptkl = new PasswordTextKeyListener(passwordwarnlabel, passwordtext);
				passwordtext.addKeyListener(ptkl);
				
				resetbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						usernametext.setText("");
						passwordtext.setText("");
						usernametext.requestFocus();
					}
				});
				//对重置按钮进行监听,将所有文本框重置为空,光标设置在第一个用户名框
				
				loginbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						User user=new User(usernametext.getText(),String.valueOf(passwordtext.getPassword()),1);
						UserDaoImplement udi=new UserDaoImplement();
						Connection conn=DLUtil.getCon();
						try {
							if(udi.isLogin(conn, user)!=0) {	
									JOptionPane.showMessageDialog(null, "登陆成功", "提示", JOptionPane.PLAIN_MESSAGE);
					                udi.userid=udi.isLogin(conn, user);
							}
								else {
									JOptionPane.showMessageDialog(null, "登陆失败", "提示", JOptionPane.PLAIN_MESSAGE);
								}
							}
						catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
					}
				});
	}
}
