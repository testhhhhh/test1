package UserPackage.src.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UserPackage.src.DaoImple.UserDaoImplement;
import UserPackage.src.Entity.User;
import UserPackage.src.InputCheck.CodeTextKeyListener;
import UserPackage.src.InputCheck.IsPasswordTextKeyListener;
import UserPackage.src.InputCheck.NameTextKeyListener;
import UserPackage.src.InputCheck.PasswordTextKeyListener;
import UserPackage.src.InputCheck.TelephoneTextKeyListener;
import UserPackage.src.InputCheck.UserTextKeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JRadioButton;

public class PersonalCentreView extends JFrame {

	private JPanel contentPane;
	private JTextField usernametext;
	private JPasswordField passwordtext;
	private JPasswordField ispasswordtext;
	private JTextField nametext;
	private JTextField telephonetext;

	/**
	 * Launch the application.
	 */
	public static void PersonalCentrelnit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalCentreView frame = new PersonalCentreView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//创建个人中心界面窗口
	}

	/**
	 * Create the frame.
	 */
	public PersonalCentreView() {
		setTitle("\u4E2A\u4EBA\u4E2D\u5FC3");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 997, 688);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//创建内容面板

		JButton returnbutton = new JButton("\u8FD4\u56DE\u9996\u9875");		
		returnbutton.setBackground(new Color(255, 255, 204));
		returnbutton.setFont(new Font("方正舒体", Font.BOLD, 35));
		returnbutton.setBounds(727, 31, 210, 49);
		contentPane.add(returnbutton);		
        returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomepageView.homepageInit();//点击按钮,跳转至首页页面
			}
		});
        //创建返回按钮
        
		JLabel useridlabel = new JLabel("\u7528\u6237ID\uFF1A");
		useridlabel.setForeground(new Color(255, 255, 0));
		useridlabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		useridlabel.setBounds(309, 78, 127, 49);
		contentPane.add(useridlabel);
		//创建用户id标签

		JLabel idlabel = new JLabel("");
		idlabel.setForeground(new Color(255, 255, 0));
		idlabel.setFont(new Font("宋体", Font.BOLD, 30));
		idlabel.setBounds(446, 88, 137, 35);
		contentPane.add(idlabel);
		//创建用户id显示标签

		JLabel usernamelabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		usernamelabel.setForeground(new Color(255, 255, 0));
		usernamelabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		usernamelabel.setBounds(309, 148, 127, 35);
		contentPane.add(usernamelabel);
		//创建用户名标签

		usernametext = new JTextField();
		usernametext.setBounds(446, 153, 283, 30);
		contentPane.add(usernametext);
		usernametext.setColumns(10);
		//创建用户名文本框

		JLabel passwordlabel = new JLabel("\u4FEE\u6539\u5BC6\u7801\uFF1A");
		passwordlabel.setForeground(new Color(255, 255, 0));
		passwordlabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		passwordlabel.setBounds(280, 214, 156, 35);
		contentPane.add(passwordlabel);
		//创建密码标签

		passwordtext = new JPasswordField();
		passwordtext.setBounds(446, 219, 283, 30);
		contentPane.add(passwordtext);
		//创建密码文本框

		JLabel ispasswordlabel = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		ispasswordlabel.setForeground(new Color(255, 255, 0));
		ispasswordlabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		ispasswordlabel.setBounds(277, 281, 159, 35);
		contentPane.add(ispasswordlabel);
		//创建确认密码标签

		ispasswordtext = new JPasswordField();
		ispasswordtext.setBounds(446, 281, 283, 30);
		contentPane.add(ispasswordtext);
		//创建确认密码文本框

		JLabel namelabel = new JLabel("\u59D3\u540D\uFF1A");
		namelabel.setForeground(new Color(255, 255, 0));
		namelabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		namelabel.setBounds(336, 350, 97, 35);
		contentPane.add(namelabel);
		//创建姓名标签

		nametext = new JTextField();
		nametext.setBounds(446, 355, 283, 30);
		contentPane.add(nametext);
		nametext.setColumns(10);
		//创建姓名文本框

		JLabel sexlabel = new JLabel("\u6027\u522B\uFF1A");
		sexlabel.setForeground(new Color(255, 255, 0));
		sexlabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		sexlabel.setBounds(336, 433, 100, 35);
		contentPane.add(sexlabel);
		//创建性别标签

		JLabel telephonelabel = new JLabel("\u7535\u8BDD\uFF1A");
		telephonelabel.setForeground(new Color(255, 255, 0));
		telephonelabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		telephonelabel.setBounds(336, 504, 100, 35);
		contentPane.add(telephonelabel);
		//创建电话号码标签

		telephonetext = new JTextField();
		telephonetext.setBounds(446, 509, 283, 30);
		contentPane.add(telephonetext);
		telephonetext.setColumns(10);
		//创建电话号码文本框

		JButton okbutton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		okbutton.setBackground(new Color(255, 255, 204));
		okbutton.setFont(new Font("华文新魏", Font.BOLD, 30));
		okbutton.setBounds(772, 549, 186, 41);
		contentPane.add(okbutton);
		//创建确认按钮

		UserDaoImplement ud = new UserDaoImplement();//创建用户Dao实现类对象
		idlabel.setText(String.valueOf(ud.userid));//设置id标签文本为userid

		JRadioButton manbutton = new JRadioButton("\u7537");
		manbutton.setBackground(new Color(255, 204, 153));
		manbutton.setFont(new Font("方正舒体", Font.PLAIN, 30));
		manbutton.setBounds(443, 433, 73, 35);
		contentPane.add(manbutton);
		//创建性别男单选按钮

		JRadioButton womenbutton = new JRadioButton("\u5973");
		womenbutton.setBackground(new Color(255, 204, 153));
		womenbutton.setFont(new Font("华文新魏", Font.PLAIN, 30));
		womenbutton.setBounds(565, 433, 73, 35);
		contentPane.add(womenbutton);
		//创建性别女单选按钮

		JLabel usernamewarnlabel = new JLabel("");
		usernamewarnlabel.setForeground(new Color(255, 0, 0));
		usernamewarnlabel.setBounds(396, 193, 376, 16);
		contentPane.add(usernamewarnlabel);
		//创建用户名输入警告标签

		JLabel passwordwarnlabel = new JLabel("");
		passwordwarnlabel.setForeground(Color.RED);
		passwordwarnlabel.setBounds(396, 255, 376, 16);
		contentPane.add(passwordwarnlabel);
		//创建密码输入警告标签

		JLabel ispasswordwarnlabel = new JLabel("");
		ispasswordwarnlabel.setForeground(Color.RED);
		ispasswordwarnlabel.setBounds(396, 326, 376, 16);
		contentPane.add(ispasswordwarnlabel);
		//创建确认密码输入警告标签

		JLabel namewarnlabel = new JLabel("");
		namewarnlabel.setForeground(Color.RED);
		namewarnlabel.setBounds(396, 395, 376, 16);
		contentPane.add(namewarnlabel);
		//创建姓名输入警告标签

		JLabel sexwarnlabel = new JLabel("");
		sexwarnlabel.setForeground(new Color(255, 255, 51));
		sexwarnlabel.setBounds(396, 478, 376, 16);
		contentPane.add(sexwarnlabel);
		//创建性别输入警告标签

		JLabel telephonewarnlabel = new JLabel("");
		telephonewarnlabel.setForeground(Color.RED);
		telephonewarnlabel.setBounds(396, 549, 376, 16);
		contentPane.add(telephonewarnlabel);
		//创建界面背景图片标签

		ButtonGroup bg = new ButtonGroup();
		bg.add(manbutton);
		bg.add(womenbutton);
		//创建性别组,将男女单选按钮添加入组

		UserTextKeyListener utkl = new UserTextKeyListener(usernamewarnlabel, usernametext, "register");
		usernametext.addKeyListener(utkl);
		PasswordTextKeyListener ptkl = new PasswordTextKeyListener(passwordwarnlabel, passwordtext);
		passwordtext.addKeyListener(ptkl);
		IsPasswordTextKeyListener iptkl = new IsPasswordTextKeyListener(passwordtext, ispasswordwarnlabel,ispasswordtext);
		ispasswordtext.addKeyListener(iptkl);
		NameTextKeyListener ntkl = new NameTextKeyListener(namewarnlabel, nametext);
		nametext.addKeyListener(ntkl);
		TelephoneTextKeyListener ttkl = new TelephoneTextKeyListener(telephonewarnlabel, telephonetext);
		
		JLabel lblNewLabel = new JLabel("\u8DDF\u8FC7\u53BB\u7684\u81EA\u5DF1\u8BF4\u518D\u89C1\uFF0C\u6539\u5934\u6362\u9762");
		lblNewLabel.setFont(new Font("华文新魏", Font.BOLD, 35));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(10, 34, 518, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PersonalCentreView.class.getResource("/png/16b97aa2804187bdcb2892aa6d6c7ec.png")));
		lblNewLabel_1.setBounds(0, 0, 999, 651);
		contentPane.add(lblNewLabel_1);
		telephonetext.addKeyListener(ttkl);

		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernametext.getText();
				String password = String.valueOf(passwordtext.getPassword());
				String ispassword = String.valueOf(ispasswordtext.getPassword());
				String name = nametext.getText();
				String sex = null;
				if (manbutton.isSelected()) {
					sexwarnlabel.setText("");
					sex = "男";
				} else if (womenbutton.isSelected()) {
					sexwarnlabel.setText("");
					sex = "女";
				} else {
					sexwarnlabel.setText("性别选项不能为空");
				}
				String telephone = telephonetext.getText();
				if (ispassword.equals(password) && !("".equals(username)) && !("".equals(password))
						&& !("".equals(ispassword)) && !("".equals(name)) && !("".equals(sex))
						&& !("".equals(telephone)) && ("".equals(usernamewarnlabel.getText()))
						&& "".equals(passwordwarnlabel.getText()) && "".equals(ispasswordwarnlabel.getText())
						&& "".equals(namewarnlabel.getText()) && "".equals(telephonewarnlabel.getText())
						&& "".equals(sexwarnlabel.getText())) {
					if (ud.personalchange(username, ispassword, name, sex, telephone) && ud.isRegisted(username))
						JOptionPane.showMessageDialog(null, "修改成功", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "修改失败", "提示", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}
}
