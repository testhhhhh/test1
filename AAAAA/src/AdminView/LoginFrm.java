package AdminView;

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

import Adminmodel.Admin;
import Dao.AdminDao;
import util.DLUtil;
import util.StringUtil;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField usernametextField;
	private JPasswordField passwordField;
    private AdminDao admindao=new AdminDao();
    private DLUtil dlutil=new DLUtil();
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
					
//					JLabel imgLabel = new JLabel(img);//将背景图放在标签里。
//				       frame.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
//				       imgLabel.setBounds((x-windowwidth)/2,(y-windowheight)/2,windowwidth, windowheight);//设置背景标签的位置
//				       Container cp=frame.getContentPane();
//				       cp.setLayout(null);
//				       ((JPanel)cp).setOpaque(false); 
				       
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
		setBounds((x-windowwidth)/2, (y-windowheight)/2, windowwidth, windowheight);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(109, 178, 493, 413);
		panel.setBackground(new Color(255, 255, 204));
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E09\u5473\u4E66\u5C4B\u7BA1\u7406\u767B\u5F55\u7AEF");
		lblNewLabel_1.setBounds(65, 50, 386, 48);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("方正舒体", Font.BOLD, 32));
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u56FE\u4E66(1).png")));
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_2.setBounds(58, 138, 138, 32);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u4F1A\u5458(1).png")));
		lblNewLabel_2.setFont(new Font("方正舒体", Font.BOLD, 25));
		
		usernametextField = new JTextField();
		usernametextField.setBounds(206, 138, 209, 32);
		panel.add(usernametextField);
		usernametextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(206, 227, 209, 32);
		panel.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setBounds(27, 227, 169, 32);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u5BC6\u7801(1).png")));
		lblNewLabel_3.setFont(new Font("方正舒体", Font.BOLD, 25));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setBounds(289, 313, 131, 41);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reSetValue(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		btnNewButton_1.setFont(new Font("方正舒体", Font.BOLD, 25));
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setBounds(67, 313, 129, 41);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Login(evt);
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC,\u7B11\u8138.png")));
		btnNewButton.setFont(new Font("方正舒体", Font.BOLD, 25));
		contentPane.add(panel);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(LoginFrm.class.getResource("/png/27.jpg")));
		lblNewLabel_4.setBounds(0, 0, windowwidth,windowheight);
		contentPane.add(lblNewLabel_4);
	}
	
	
// public String user() {
//
//	 
//	 String name= this.usernametextField.getText();
//	 System.out.println(name);
//	 return name;
// }
	//登录事件处理
	private void Login(ActionEvent evt) {
		// TODO Auto-generated method stub
		String username=this.usernametextField.getText();//获取界面上的组件文本
		String password= new String(this.passwordField.getPassword());//获取界面上的密码，getPassword返回的是char
		//判断用户名和密码是否为空
		if(StringUtil.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		//封装对象用于查询
		Admin admin=new Admin(username,password);
	
		Connection conn=null;
	
		try {
			conn=dlutil.getCon();//数据库连接
			Admin currentAdmin=admindao.Login(conn, admin);//返回查询结果
				if(currentAdmin==null){
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
				this.passwordField.setText("");
				this.usernametextField.setText("");
				return;
			}
			//判断是否为管理员
			String panduan=admindao.Panduan(conn, admin);
			if(!panduan.equals("管理员")) {
				JOptionPane.showMessageDialog(null, "用户无权访问该界面哦");
				this.passwordField.setText("");
				this.usernametextField.setText("");
				return;
			}
			//如果返回值不为空，说明查到了，它会返回该条数据的完整信息
			if(currentAdmin!=null) {
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
