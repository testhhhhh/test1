package AdminView;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import Adminmodel.User;
import Dao.UserMangeDao;
import alert.Nametxtlistener;
import alert.PasswordtxtListener;
import alert.RecodetxtListener;
import alert.ResurePasswordtxtListener;
import alert.TelephonetxtListener;
import alert.UsernametxtListener;
import util.DLUtil;
import util.StringUtil;
import java.awt.Color;

public class UserAddInterFrm extends JFrame {
	private JTextField usernametextField;
	private JPasswordField passwordField;
	private JPasswordField resurepasswordField;
	private JTextField nametextField;
	private JTextField telephonetextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
    private JComboBox statecomboBox;
    private JRadioButton ManRadioButton;
    private JRadioButton WomanRadioButton;
    private DLUtil dlutil=new DLUtil();
    private UserMangeDao usermangedao=new UserMangeDao();
    private JTextField codetextField;
    private JTextField recodetextField;
    private JButton btnNewButton_2;
    private JButton btnNewButton;
    private JLabel password_alert;

 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAddInterFrm frame = new UserAddInterFrm();
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
	public UserAddInterFrm() {
		
		getContentPane().setBackground(new Color(153, 204, 51));
		setTitle("\u6DFB\u52A0\u7528\u6237\u754C\u9762");
		setBounds(100, 100, 672, 729);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(110, 24, 120, 32);
		lblNewLabel.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u4F1A\u5458(1).png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
		usernametextField = new JTextField();
		usernametextField.setBounds(248, 29, 268, 32);
		usernametextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(133, 95, 96, 32);
		lblNewLabel_1.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u5BC6\u7801(1).png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(248, 100, 268, 32);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(94, 170, 136, 32);
		lblNewLabel_2.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC,\u7B11\u8138.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
		resurepasswordField = new JPasswordField();
		resurepasswordField.setBounds(248, 170, 268, 32);
		
		JLabel lblNewLabel_3 = new JLabel("\u7528\u6237\u59D3\u540D\uFF1A");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(90, 239, 140, 32);
		lblNewLabel_3.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u4E2A\u4EBA\u4FE1\u606F_\u5B9D\u8D1D\u59D3\u540D.png")));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
		nametextField = new JTextField();
		nametextField.setBounds(248, 244, 268, 32);
		nametextField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u7528\u6237\u6027\u522B\uFF1A");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(90, 317, 140, 32);
		lblNewLabel_4.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u6027\u522B(1).png")));
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
		ManRadioButton = new JRadioButton("\u7537");
		buttonGroup.add(ManRadioButton);
		ManRadioButton.setBackground(new Color(0, 204, 255));
		ManRadioButton.setBounds(248, 315, 65, 37);
		ManRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		WomanRadioButton = new JRadioButton("\u5973");
		buttonGroup.add(WomanRadioButton);
		WomanRadioButton.setBackground(new Color(51, 204, 255));
		WomanRadioButton.setBounds(355, 315, 60, 37);
		WomanRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JLabel lblNewLabel_5 = new JLabel("\u7528\u6237\u7535\u8BDD\uFF1A");
		lblNewLabel_5.setForeground(SystemColor.text);
		lblNewLabel_5.setBounds(90, 369, 136, 32);
		lblNewLabel_5.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u7535\u8BDD(1).png")));
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
		telephonetextField = new JTextField();
		telephonetextField.setBounds(248, 375, 268, 29);
		telephonetextField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u7528\u6237\u72B6\u6001\uFF1A");
		lblNewLabel_6.setForeground(SystemColor.text);
		lblNewLabel_6.setBounds(90, 442, 144, 32);
		lblNewLabel_6.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u72B6\u6001.png")));
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
	    statecomboBox = new JComboBox();
	    statecomboBox.setBackground(SystemColor.info);
		statecomboBox.setBounds(247, 443, 269, 32);
		statecomboBox.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		statecomboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7CFB\u7EDF\u7BA1\u7406\u5458", "\u7528\u6237"}));
		
		btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {

				UserAdd(evt);
			}

		});
	

		
		btnNewButton.setBounds(90, 606, 136, 41);
		btnNewButton.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u786E\u8BA4.png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setBackground(SystemColor.info);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reSetValue(e);
			}
		});
		btnNewButton_1.setBounds(395, 606, 131, 41);
		btnNewButton_1.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		getContentPane().setLayout(null);
		getContentPane().add(lblNewLabel_4);
		getContentPane().add(lblNewLabel_3);
		getContentPane().add(lblNewLabel_2);
		getContentPane().add(lblNewLabel_1);
		getContentPane().add(lblNewLabel);
		getContentPane().add(lblNewLabel_5);
		getContentPane().add(ManRadioButton);
		getContentPane().add(WomanRadioButton);
		getContentPane().add(telephonetextField);
		getContentPane().add(nametextField);
		getContentPane().add(resurepasswordField);
		getContentPane().add(usernametextField);
		getContentPane().add(passwordField);
		getContentPane().add(lblNewLabel_6);
		getContentPane().add(statecomboBox);
		getContentPane().add(btnNewButton);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("\u9A8C\u8BC1\u7801\uFF1A");
		lblNewLabel_7.setForeground(SystemColor.text);
		lblNewLabel_7.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u9A8C\u8BC1\u7801(1).png")));
		lblNewLabel_7.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblNewLabel_7.setBounds(110, 505, 116, 32);
		getContentPane().add(lblNewLabel_7);
		
		codetextField = new JTextField();
		codetextField.setBounds(248, 505, 150, 41);
		getContentPane().add(codetextField);
		codetextField.setColumns(10);
		
		recodetextField = new JTextField();
		recodetextField.setBackground(SystemColor.info);
		int n=(int)Math.round((Math.random()*9+1)*100000);
		String shengchengcode=String.valueOf(n);//把整数型转成字符串类型
		this.recodetextField.setText(shengchengcode);//获取验证码数据
		this.recodetextField.getText();

		
		recodetextField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		recodetextField.setEditable(false);
		recodetextField.setBounds(440, 501, 140, 41);
		getContentPane().add(recodetextField);
		recodetextField.setColumns(10);
		
		btnNewButton_2 = new JButton("\u70B9\u51FB\u83B7\u53D6\u9A8C\u8BC1\u7801");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ek) {
				CodeClick(ek);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u5BC6\u7801.png")));
		btnNewButton_2.setFont(new Font("微软雅黑", Font.BOLD, 12));
		btnNewButton_2.setBounds(440, 552, 140, 23);
		getContentPane().add(btnNewButton_2);
		
		//用户警告标签
		JLabel username_alert = new JLabel("");
		username_alert.setFont(new Font("宋体", Font.BOLD, 12));
		username_alert.setForeground(Color.YELLOW);
		username_alert.setBackground(SystemColor.scrollbar);
		username_alert.setBounds(255, 75, 261, 15);
		getContentPane().add(username_alert);
		
		
		//用户名警告标签提示
		UsernametxtListener ul=new UsernametxtListener(username_alert,usernametextField);
		this.usernametextField.addKeyListener(ul);
		
		
		JLabel password_alert = new JLabel("");
		password_alert.setForeground(Color.YELLOW);
		password_alert.setBounds(248, 145, 400, 15);
		getContentPane().add(password_alert);
		
		
		//密码验证警告标签
		 PasswordtxtListener pl=new  PasswordtxtListener(password_alert,passwordField);
		 this.passwordField.addKeyListener(pl);
		 
		JLabel nametxt_alert = new JLabel("");
		nametxt_alert.setForeground(Color.YELLOW);
		nametxt_alert.setBounds(248, 286, 346, 15);
		getContentPane().add(nametxt_alert);
		
		//用户姓名警告标签
		Nametxtlistener nl=new Nametxtlistener(nametxt_alert,nametextField);
		this.nametextField.addKeyListener(nl);
		
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setForeground(Color.YELLOW);
		lblNewLabel_8.setBounds(258, 142, 332, 15);
		getContentPane().add(lblNewLabel_8);
		
		JLabel repassword_alert = new JLabel("");
		repassword_alert.setForeground(Color.YELLOW);
		repassword_alert.setBounds(248, 212, 299, 15);
		getContentPane().add(repassword_alert);
		
		//确认密码警告标签
		ResurePasswordtxtListener rl=new ResurePasswordtxtListener(repassword_alert,passwordField,resurepasswordField);
		this.resurepasswordField.addKeyListener(rl);
		
		
		JLabel telephone_alert = new JLabel("");
		telephone_alert.setForeground(Color.YELLOW);
		telephone_alert.setBounds(248, 414, 261, 15);
		getContentPane().add(telephone_alert);
		
		TelephonetxtListener tl=new TelephonetxtListener(telephone_alert,telephonetextField);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/png/26.jpg")));
		lblNewLabel_9.setBounds(0, 0, 658, 692);
		getContentPane().add(lblNewLabel_9);
		this.telephonetextField.addKeyListener(tl);
	}
	


	//点击获取验证码事件
	private void CodeClick(ActionEvent ek) {
		// TODO Auto-generated method stub
		int n=(int)Math.round((Math.random()*9+1)*100000);
		String shengchengcode=String.valueOf(n);//把整数型转成字符串类型
		this.recodetextField.setText(shengchengcode);//获取验证码数据
		this.recodetextField.getText();
	}

	//用户添加事件处理
	private void UserAdd(ActionEvent evt) {
		// TODO Auto-generated method stub
		String username=this.usernametextField.getText();//用户名
		String password=new String(this.passwordField.getPassword());//获取密码
		String resurepassword=new String(this.resurepasswordField.getPassword());//获取确认密码
		String name=this.nametextField.getText();//用户姓名
		String telephone=this.telephonetextField.getText();//电话
		String code=this.codetextField.getText();//验证码
		
		if(StringUtil.isEmpty(username)) {
			JOptionPane.showMessageDialog(null,"用户名不能为空");
			return;
		}
		//用户名判断
				String re="^[a-zA-Z0-9\u4e00-\u9fa5]{3,20}";
				if(!username.matches(re)) {
				JOptionPane.showMessageDialog(null,"用户名输入格式为汉字或字母或数字，或者自由搭配，其长度为3-20位，请重新输入");
					this.usernametextField.setText("");
					return;	
				}
				if(StringUtil.isEmpty(password)) {
					JOptionPane.showMessageDialog(null,"密码不能为空");
					return;
				}
				
				
				//密码判断
				String mm="^[[a-zA-Z0-9]+$ ]{6,20}";
				if(!password.matches(mm)) {
					JOptionPane.showMessageDialog(null,"密码输入格式为英文字母或数字，或者自由搭配，其长度为6-20位，请重新输入");
					this.passwordField.setText("");
					return;	
				}
				
	
		if(StringUtil.isEmpty(resurepassword)) {
			JOptionPane.showMessageDialog(null,"请输入确认密码");
			return;
		}
		
		
		//两次输入密码判断	
		String passwordsure = null;
		if(password.equals(resurepassword)) {
			passwordsure=password;
		}else {
			JOptionPane.showMessageDialog(null,"两次密码输入不符合，请再输入一次");
			this.passwordField.setText("");
			this.resurepasswordField.setText("");
			return;
		}
		
		if(StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(null,"用户姓名不能为空");
			return;
		}
			
		//真实姓名判断
    	String na="^[a-zA-Z0-9\u4e00-\u9fa5]{2,20}";
		if(!name.matches(na)) {
			JOptionPane.showMessageDialog(null,"姓名输入格式为汉字或英文，其长度为2-20位，请重新输入");
			this.nametextField.setText("");
			return;
		}

		
		if(StringUtil.isEmpty(telephone)) {
			JOptionPane.showMessageDialog(null,"电话不能为空");
			return;
		}
		
		//电话格式判断
				String zhengze="^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
				if(!telephone.matches(zhengze)) {
					JOptionPane.showMessageDialog(null,"电话格式错误，请重新输入");
					this.telephonetextField.setText("");
					return;
				}

		if(StringUtil.isEmpty(code)) {
			JOptionPane.showMessageDialog(null,"请输入验证码");
			return;
		}
		
		
		//生成验证码
		String shengchengcode=this.recodetextField.getText().trim();
		if(!code.equals(shengchengcode)) {
			JOptionPane.showMessageDialog(null, "验证码输入有误，请重新输入");
           return;
		}
		
		//性别获取
		String sex="";
		if(ManRadioButton.isSelected()) {
			sex="男";
		}else if(WomanRadioButton.isSelected()) {
			sex="女";
		}
		String state=(String) statecomboBox.getSelectedItem();
	
		
		//封装用户实体
		User user=new User(username, password,  name, sex, telephone, state,  code);
		
		//调用数据库
		Connection conn=null;
		try {
			conn=dlutil.getCon();//连接数据库
			int addNum=usermangedao.add(conn, user);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null,"用户添加成功");
				reSetValue(evt);
			}else {
				JOptionPane.showMessageDialog(null,"用户添加失败");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"用户添加失败");
		}finally {
			try {
				dlutil.CloseCon(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	//重置
	private void reSetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		this.usernametextField.setText("");
		this.passwordField.setText("");
		this.resurepasswordField.setText("");
		this.nametextField.setText("");
		this.telephonetextField.setText("");
		this.buttonGroup.clearSelection();//清空性别选择
		this.recodetextField.setText("");
		this.codetextField.setText("");
		this.statecomboBox.setSelectedIndex(0);//将用户状态框默认选择第一个
	}
}
