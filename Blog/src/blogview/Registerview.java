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
import inputcheck.CodeTextKeyListener;
import inputcheck.IsPasswordTextKeyListener;
import inputcheck.PasswordTextKeyListener;
import inputcheck.TelephoneTextKeyListener;
import inputcheck.UserTextKeyListener;
import jdbc.DLUtil;

public class Registerview extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void registerInit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registerview frame = new Registerview();
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
	public Registerview() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1261, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//创建内容面板

				JPanel panel = new JPanel();
				panel.setBackground(new Color(153, 204, 255));
				panel.setBounds(0, 0, 548, 360);
				contentPane.add(panel);
				panel.setLayout(null);
				//创建面板

				JTextField usernametext = new JTextField();
				usernametext.setBounds(258, 117, 227, 28);
				panel.add(usernametext);
				usernametext.setColumns(10);
				//创建用户名文本框

				JLabel username = new JLabel("\u7528\u6237\u540D\uFF1A");
				username.setForeground(Color.WHITE);
				username.setFont(new Font("方正舒体", Font.BOLD, 22));
				username.setBackground(Color.PINK);
				username.setBounds(133, 112, 98, 28);
				panel.add(username);
				//创建用户名标签

				JLabel password = new JLabel("\u5BC6   \u7801\uFF1A");
				password.setForeground(Color.WHITE);
				password.setBackground(Color.BLACK);
				password.setFont(new Font("方正舒体", Font.BOLD, 22));
				password.setBounds(136, 193, 100, 28);
				panel.add(password);
				//创建密码标签

				JButton registerbutton = new JButton("\u6CE8\u518C");
				registerbutton.setBackground(new Color(255, 250, 205));
				registerbutton.setForeground(Color.BLACK);
				registerbutton.setFont(new Font("华文新魏", Font.PLAIN, 28));
				registerbutton.setBounds(184, 549, 104, 37);
				panel.add(registerbutton);
				//创建注册按钮

				JButton resetbutton = new JButton("重置");
				resetbutton.setBackground(new Color(255, 250, 205));
				resetbutton.setForeground(Color.BLACK);
				resetbutton.setFont(new Font("华文新魏", Font.PLAIN, 28));
				resetbutton.setBounds(439, 549, 104, 37);
				panel.add(resetbutton);
				//创建重置按钮

				JLabel ispassword = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
				ispassword.setForeground(Color.WHITE);
				ispassword.setFont(new Font("方正舒体", Font.BOLD, 22));
				ispassword.setBounds(114, 263, 122, 28);
				panel.add(ispassword);
				//创建确认密码标签

				JLabel telephone = new JLabel("\u7535   \u8BDD\uFF1A");
				telephone.setForeground(Color.WHITE);
				telephone.setFont(new Font("方正舒体", Font.BOLD, 22));
				telephone.setBounds(133, 333, 89, 28);
				panel.add(telephone);
				//创建姓名文本框

				JTextField telephonetext = new JTextField();
				telephonetext.setBounds(258, 338, 227, 28);
				panel.add(telephonetext);
				telephonetext.setColumns(10);
				//创建电话号码文本框

				JTextField codetext = new JTextField();
				codetext.setBounds(258, 423, 157, 28);
				panel.add(codetext);
				codetext.setColumns(10);
				//创建验证码文本框

				JLabel registtitlelabel = new JLabel("\u7528\u6237\u6CE8\u518C");
				registtitlelabel.setForeground(Color.WHITE);
				registtitlelabel.setIcon(new ImageIcon(Registerview.class.getResource("/images/\u56FE\u4E66(1).png")));
				registtitlelabel.setFont(new Font("方正舒体", Font.BOLD, 50));
				registtitlelabel.setBounds(173, 20, 370, 47);
				panel.add(registtitlelabel);
				//创建注册界面标题标签

				JLabel codelabel = new JLabel("\u9A8C\u8BC1\u7801\uFF1A");
				codelabel.setForeground(Color.WHITE);
				codelabel.setFont(new Font("方正舒体", Font.BOLD, 22));
				codelabel.setBounds(132, 418, 99, 28);
				panel.add(codelabel);
				//创建验证码标签

				JPasswordField passwordtext = new JPasswordField();
				passwordtext.setBounds(258, 193, 227, 28);
				panel.add(passwordtext);
				//创建密码文本框

				JPasswordField ispasswordtext = new JPasswordField();
				ispasswordtext.setBounds(258, 263, 227, 28);
				panel.add(ispasswordtext);
				//创建确认密码文本框

				JLabel codeshowlabel = new JLabel("");
				codeshowlabel.setBackground(new Color(255, 255, 255));
				codeshowlabel.setFont(new Font("华文行楷", Font.PLAIN, 30));
				codeshowlabel.setForeground(Color.WHITE);
				codeshowlabel.setBounds(439, 423, 122, 28);
				panel.add(codeshowlabel);
				//创建性别女单选按钮

				JLabel usernamewarnlabel = new JLabel("");
				usernamewarnlabel.setForeground(new Color(255, 0, 0));
				usernamewarnlabel.setBounds(258, 150, 485, 22);
				panel.add(usernamewarnlabel);
				//创建用户名输入警告标签

				JLabel passwordwarnlabel = new JLabel("");
				passwordwarnlabel.setForeground(Color.RED);
				passwordwarnlabel.setBounds(258, 225, 494, 28);
				panel.add(passwordwarnlabel);
				//创建密码输入警告标签

				JLabel ispasswordwarnlabel = new JLabel("");
				ispasswordwarnlabel.setForeground(Color.RED);
				ispasswordwarnlabel.setBounds(258, 301, 139, 22);
				panel.add(ispasswordwarnlabel);
				//创建性别选择警告标签

				JLabel telephonewarnlabel = new JLabel("");
				telephonewarnlabel.setForeground(Color.RED);
				telephonewarnlabel.setBounds(258, 376, 98, 22);
				panel.add(telephonewarnlabel);		
				//创建电话号码输入警告标签

				JLabel codewarnlabel = new JLabel("");
				codewarnlabel.setForeground(Color.RED);
				codewarnlabel.setBounds(258, 461, 227, 22);
				panel.add(codewarnlabel);
				//创建验证码输入警告标签
				
		        codeshowlabel.setText(String.valueOf((int) (Math.random() * 10000 + 1)));
		        //设置自动随机生成1~9999之间任意整数作为验证码
		        
				JLabel backgroundipclabel = new JLabel("");
				backgroundipclabel.setIcon(new ImageIcon(Registerview.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710224042.png")));
				backgroundipclabel.setBounds(-332, 0, 1580, 731);
				panel.add(backgroundipclabel);
				//创建注册界面背景图片标签
				
				UserTextKeyListener utkl = new UserTextKeyListener(usernamewarnlabel, usernametext, "register");
				usernametext.addKeyListener(utkl);
				PasswordTextKeyListener ptkl = new PasswordTextKeyListener(passwordwarnlabel, passwordtext);
				passwordtext.addKeyListener(ptkl);
				IsPasswordTextKeyListener iptkl = new IsPasswordTextKeyListener(passwordtext, ispasswordwarnlabel,ispasswordtext);
				ispasswordtext.addKeyListener(iptkl);
				TelephoneTextKeyListener ttkl = new TelephoneTextKeyListener(telephonewarnlabel, telephonetext);
				telephonetext.addKeyListener(ttkl);
				CodeTextKeyListener ctkl = new CodeTextKeyListener(codewarnlabel, codetext);
				codetext.addKeyListener(ctkl);
				
				resetbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						usernametext.setText("");
						passwordtext.setText("");
						ispasswordtext.setText("");
						telephonetext.setText("");
						codetext.setText("");
						usernamewarnlabel.setText("");
						passwordwarnlabel.setText("");
						ispasswordwarnlabel.setText("");
						telephonewarnlabel.setText("");
						codewarnlabel.setText("");
						usernametext.requestFocus();
					}
				});// 重置按钮判断
				
				registerbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						User user=new User(0,usernametext.getText(),String.valueOf(passwordtext.getPassword()),telephonetext.getText(),1,codetext.getText(),"0");
						UserDaoImplement udi=new UserDaoImplement();
						Connection conn=DLUtil.getCon();
						try {
							if(udi.isRegisted(conn, usernametext.getText())==0) {
								if(udi.add(conn, user)!=0) {
									JOptionPane.showMessageDialog(null, "注册成功", "提示", JOptionPane.PLAIN_MESSAGE);
								}
							}
								else {
									JOptionPane.showMessageDialog(null, "注册失败", "提示", JOptionPane.PLAIN_MESSAGE);
								}
							}
						catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}}
				});
				
	}

}
