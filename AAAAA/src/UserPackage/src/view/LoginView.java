package UserPackage.src.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UserPackage.src.DaoImple.UserDaoImplement;
import UserPackage.src.InputCheck.PasswordTextKeyListener;
import UserPackage.src.InputCheck.UserTextKeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField usernametext;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordtext;

	/**
	 * Launch the application.
	 */
	public static void loginlnit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//创建登录界面初始化窗口
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 694, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//创建内容面板

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(0, 0, 680, 496);
		contentPane.add(panel);
		panel.setLayout(null);
		//创建一个面板

		JLabel usernamelabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		usernamelabel.setBounds(119, 150, 115, 34);
		usernamelabel.setFont(new Font("方正舒体", Font.BOLD, 25));
		panel.add(usernamelabel);
		//创建用户名标签

		JLabel passwordlabel = new JLabel("\u5BC6   \u7801\uFF1A");
		passwordlabel.setFont(new Font("方正舒体", Font.BOLD, 25));
		passwordlabel.setBounds(119, 255, 104, 26);
		panel.add(passwordlabel);
		//创建密码标签

		usernametext = new JTextField();
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
		
		JLabel sitetitlelabel = new JLabel("\u4E09\u5473\u4E66\u5C4B\u767B\u5F55\u7AEF");
		sitetitlelabel.setFont(new Font("方正舒体", Font.BOLD, 50));
		sitetitlelabel.setBounds(159, 48, 367, 57);
		panel.add(sitetitlelabel);
		//创建网站标题标签

		passwordtext = new JPasswordField();
		passwordtext.setBounds(259, 254, 241, 41);
		panel.add(passwordtext);
		//创建密码文本框

		JLabel usernamewarnlabel = new JLabel("");
		usernamewarnlabel.setForeground(new Color(255, 69, 0));
		usernamewarnlabel.setBounds(176, 204, 418, 28);
		panel.add(usernamewarnlabel);
		//创建用户名输入警告标签

		JLabel passwordwarnlabel = new JLabel("");
		passwordwarnlabel.setForeground(new Color(255, 69, 0));
		passwordwarnlabel.setBounds(176, 313, 437, 28);
		panel.add(passwordwarnlabel);
		//创建密码输入警告标签

		UserTextKeyListener utkl = new UserTextKeyListener(usernamewarnlabel, usernametext, "Login");
		usernametext.addKeyListener(utkl);
		//创建输入用户名的键盘监听对象
		
		PasswordTextKeyListener ptkl = new PasswordTextKeyListener(passwordwarnlabel, passwordtext);
		passwordtext.addKeyListener(ptkl);
		//创建输入密码的键盘监听对象

		JLabel backgpiclabel = new JLabel("");
		backgpiclabel.setIcon(new ImageIcon(LoginView.class.getResource("/UserPackage/src/newimages/c.jpeg")));
		backgpiclabel.setBounds(0, 0, 680, 496);
		panel.add(backgpiclabel);
		//创建背景图片标签

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
				UserDaoImplement ud = new UserDaoImplement();
				String username = usernametext.getText();
				String password = String.valueOf(passwordtext.getPassword());
				if (ud.isLogin(username, password) && !("".equals(username)) && !("".equals(password))) {//调用用户登录方法(isLogin),登录方法返回true且文本框输入规范时
					JOptionPane.showMessageDialog(null, "登陆成功", "提示", JOptionPane.PLAIN_MESSAGE);//弹出窗口提示成功
					new BuyView().setUsername(username);//获取购买的用户名
					new HomepageView().setUsername(username);//主界面获取用户名
					
				} else {
					JOptionPane.showMessageDialog(null, "登陆失败", "提示", JOptionPane.PLAIN_MESSAGE);//否则提示失败
				}
			}
		});
		//对登录按钮进行监听
		
	}
}
