package adminview;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import daoimplement.UserDaoImplement;
import entity.User;
import inputcheck.InputOrNot;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField usernametextField;
	private JPasswordField passwordField;
    public static int x=Toolkit.getDefaultToolkit().getScreenSize().width;
  	public static int y=Toolkit.getDefaultToolkit().getScreenSize().height;
  	public static int windowwidth=1550;
  	public static int windowheight=870;
  	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();			     
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
	public LoginFrm() {
		setResizable(false);
		setTitle("\u7BA1\u7406\u5458\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((x-windowwidth)/2, (y-windowheight)/2, 1675, 882);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(444, 217, 493, 413);
		panel.setBackground(SystemColor.activeCaption);
		panel.setLayout(null);
		
		JLabel titlelabel = new JLabel("\u535A\u5BA2\u7CFB\u7EDF\u7BA1\u7406\u767B\u5F55\u7AEF");
		titlelabel.setBounds(65, 50, 386, 48);
		panel.add(titlelabel);
		titlelabel.setFont(new Font("方正舒体", Font.BOLD, 32));
		titlelabel.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u56FE\u4E66(1).png")));
		
		JLabel usernameshowlabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		usernameshowlabel.setBounds(83, 138, 138, 32);
		panel.add(usernameshowlabel);
		usernameshowlabel.setIcon(null);
		usernameshowlabel.setFont(new Font("方正舒体", Font.BOLD, 25));
		
		usernametextField = new JTextField();
		usernametextField.setBounds(206, 138, 209, 32);
		panel.add(usernametextField);
		usernametextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(206, 227, 209, 32);
		panel.add(passwordField);
		
		JLabel passwordshowlabel = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		passwordshowlabel.setBounds(65, 227, 169, 32);
		panel.add(passwordshowlabel);
		passwordshowlabel.setIcon(null);
		passwordshowlabel.setFont(new Font("方正舒体", Font.BOLD, 25));
		
		JButton rigesterbutton = new JButton("\u91CD\u7F6E");
		rigesterbutton.setBounds(289, 313, 131, 41);
		panel.add(rigesterbutton);
		rigesterbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reSetValue(e);
			}
		});
		rigesterbutton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		rigesterbutton.setFont(new Font("方正舒体", Font.BOLD, 25));
		
		JButton loginbutton = new JButton("\u767B\u5F55");
		loginbutton.setBounds(67, 313, 129, 41);
		panel.add(loginbutton);
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Login(evt);
			}
		});
		contentPane.setLayout(null);
		loginbutton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC,\u7B11\u8138.png")));
		loginbutton.setFont(new Font("方正舒体", Font.BOLD, 25));
		contentPane.add(panel);
		
		JLabel piclabel = new JLabel("");
		piclabel.setIcon(new ImageIcon(LoginFrm.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710224042.png")));
		piclabel.setBounds(0, 0, 2168,870);
		contentPane.add(piclabel);
	}

	//登录事件处理
	private void Login(ActionEvent evt) {
		String username=this.usernametextField.getText();//获取界面上的组件文本
		String password= new String(this.passwordField.getPassword());//获取界面上的密码，getPassword返回的是char
		//判断用户名和密码是否为空
		if(InputOrNot.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(InputOrNot.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		//封装对象用于查询
		User admin=new User(username,password);
	
		Connection conn=null;
		int currentAdmin=-1;
	
		try {
			conn=jdbc.DLUtil.getCon();//数据库连接
			currentAdmin=new UserDaoImplement().isLogin(conn, admin);//返回查询结果
				if(currentAdmin==-1){
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
				this.passwordField.setText("");
				this.usernametextField.setText("");
				return;
			}
			//判断是否为管理员
		    User admin1=new User(username,password,2);
			int panduan=new UserDaoImplement().isLogin(conn, admin1);
			if(panduan==-1) {
				JOptionPane.showMessageDialog(null, "用户无权访问该界面哦");
				this.passwordField.setText("");
				this.usernametextField.setText("");
				return;
			}
			//如果返回值不为空，说明查到了，它会返回该条数据的完整信息
			if(currentAdmin!=-1) {
//			JOptionPane.showMessageDialog(null, "登陆成功");
		new MainView().setUsername(username);//获取登录界面的用户名
				new MainView().setVisible(true);
			this.dispose();//关闭原来窗体，释放部分资源
				
	}
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

//重置
	private void reSetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		this.usernametextField.setText("");
		this.passwordField.setText("");
		this.usernametextField.requestFocus();
	}
}
