package AdminView;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Adminmodel.User;
import Dao.UserMangeDao;
import util.DLUtil;
import util.StringUtil;

public class UserMangeInterFrm extends JFrame {
	private JTable usertable;
	private JTextField s_usernametxt;
	private JTextField s_nametxt;
    private DLUtil dlutil=new DLUtil();
    private UserMangeDao usermangedao=new UserMangeDao();
    public int x=Toolkit.getDefaultToolkit().getScreenSize().width;
 	public int y=Toolkit.getDefaultToolkit().getScreenSize().height;
 	public int windowwidth=1520;
 	public int windowheight=770;
 	private JComboBox statetxt;
 	private JComboBox sextxt;
 	private JTextField usernametxt;
 	private JTextField idtxt;
 	private JPasswordField passwordField;
 	private JPasswordField resurepasswordField;
 	private JTextField nametxt;
 	private JTextField telephonetxt;
 	private JTextField sexboxjcb;
 	private JTextField stateboxjcb;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMangeInterFrm frame = new UserMangeInterFrm();
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
	public UserMangeInterFrm() {
		getContentPane().setBackground(new Color(255, 255, 204));
		setTitle("\u7528\u6237\u7BA1\u7406");
		setBounds((x-windowwidth)/2, (y-windowheight)/2, 1400, 770);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6846", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 240));
		panel_1.setBorder(new TitledBorder(null, "\u4FEE\u6539\u6846", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(30, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1193, GroupLayout.PREFERRED_SIZE)
							.addGap(102))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1311, GroupLayout.PREFERRED_SIZE)
							.addGap(47))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1256, GroupLayout.PREFERRED_SIZE)
							.addGap(58))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_4 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_4.setForeground(SystemColor.text);
		lblNewLabel_4.setBounds(415, 41, 128, 32);
		lblNewLabel_4.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u4F1A\u5458(1).png")));
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
		usernametxt = new JTextField();
		usernametxt.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		usernametxt.setBounds(553, 44, 170, 35);
		usernametxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_5.setForeground(SystemColor.text);
		lblNewLabel_5.setBounds(58, 44, 105, 32);
		lblNewLabel_5.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u7F16\u53F7.png")));
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
		idtxt = new JTextField();
		idtxt.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		idtxt.setBounds(180, 41, 112, 40);
		idtxt.setEnabled(false);
		idtxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u7528\u6237\u5BC6\u7801\uFF1A");
		lblNewLabel_6.setForeground(SystemColor.text);
		lblNewLabel_6.setBounds(22, 105, 148, 32);
		lblNewLabel_6.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u5BC6\u7801(1).png")));
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 102, 154, 35);
		
		JLabel lblNewLabel_7 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_7.setForeground(SystemColor.text);
		lblNewLabel_7.setBounds(397, 105, 146, 32);
		lblNewLabel_7.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u786E\u8BA4.png")));
		lblNewLabel_7.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
		resurepasswordField = new JPasswordField();
		resurepasswordField.setBounds(553, 103, 170, 33);
		
		JLabel lblNewLabel_8 = new JLabel("\u7528\u6237\u59D3\u540D\uFF1A");
		lblNewLabel_8.setForeground(SystemColor.text);
		lblNewLabel_8.setBounds(812, 44, 144, 32);
		lblNewLabel_8.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u4E2A\u4EBA\u4FE1\u606F_\u5B9D\u8D1D\u59D3\u540D.png")));
		lblNewLabel_8.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
		nametxt = new JTextField();
		nametxt.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		nametxt.setBounds(989, 45, 170, 32);
		nametxt.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("\u7528\u6237\u6027\u522B\uFF1A");
		lblNewLabel_9.setForeground(SystemColor.text);
		lblNewLabel_9.setBounds(18, 169, 145, 32);
		lblNewLabel_9.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u6027\u522B(1).png")));
		lblNewLabel_9.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
		JLabel lblNewLabel_10 = new JLabel("\u7528\u6237\u72B6\u6001\uFF1A");
		lblNewLabel_10.setForeground(SystemColor.text);
		lblNewLabel_10.setBounds(397, 164, 146, 41);
		lblNewLabel_10.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u72B6\u6001.png")));
		lblNewLabel_10.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.setBackground(new Color(255, 255, 240));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent euu) {
				UserUpadte(euu);
			}
		});
		btnNewButton_1.setBounds(796, 207, 144, 41);
		btnNewButton_1.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u4FEE\u6539.png")));
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ed) {
				UserDelete(ed);
			}
		});
		btnNewButton_2.setBounds(1004, 207, 139, 41);
		btnNewButton_2.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u5220\u9664(3).png")));
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		panel_1.setLayout(null);
		panel_1.add(passwordField);
		panel_1.add(lblNewLabel_7);
		panel_1.add(resurepasswordField);
		panel_1.add(lblNewLabel_8);
		panel_1.add(nametxt);
		panel_1.add(lblNewLabel_9);
		panel_1.add(lblNewLabel_10);
		panel_1.add(btnNewButton_1);
		panel_1.add(btnNewButton_2);
		panel_1.add(lblNewLabel_5);
		panel_1.add(idtxt);
		panel_1.add(lblNewLabel_4);
		panel_1.add(usernametxt);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_11 = new JLabel("\u7528\u6237\u7535\u8BDD\uFF1A");
		lblNewLabel_11.setForeground(SystemColor.text);
		lblNewLabel_11.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u7535\u8BDD(1).png")));
		lblNewLabel_11.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblNewLabel_11.setBounds(812, 98, 143, 35);
		panel_1.add(lblNewLabel_11);
		
		telephonetxt = new JTextField();
		telephonetxt.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		telephonetxt.setBounds(989, 102, 170, 32);
		panel_1.add(telephonetxt);
		telephonetxt.setColumns(10);
		
		sexboxjcb = new JTextField();
		sexboxjcb.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		sexboxjcb.setBounds(180, 170, 154, 32);
		panel_1.add(sexboxjcb);
		sexboxjcb.setColumns(10);
		
		stateboxjcb = new JTextField();
		stateboxjcb.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		stateboxjcb.setBounds(553, 171, 170, 30);
		panel_1.add(stateboxjcb);
		stateboxjcb.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/png/11.jpg")));
		lblNewLabel_13.setBounds(0, 21, 1246, 250);
		panel_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setBounds(16, 50, 110, 24);
		lblNewLabel.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u4F1A\u5458(1).png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		s_usernametxt = new JTextField();
		s_usernametxt.setBounds(128, 42, 114, 32);
		s_usernametxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u59D3\u540D\uFF1A");
		lblNewLabel_1.setBounds(274, 46, 132, 32);
		lblNewLabel_1.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u4E2A\u4EBA\u4FE1\u606F_\u5B9D\u8D1D\u59D3\u540D.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(s_usernametxt);
		panel.add(lblNewLabel_1);
		
		s_nametxt = new JTextField();
		s_nametxt.setBounds(398, 42, 121, 32);
		panel.add(s_nametxt);
		s_nametxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u72B6\u6001\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u72B6\u6001.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(552, 50, 132, 24);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u7528\u6237\u6027\u522B\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u6027\u522B(1).png")));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(867, 46, 132, 32);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtt) {
		userSearch(evtt);
			}
		});
		btnNewButton.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u67E5\u8BE2(3).png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnNewButton.setBounds(1169, 41, 121, 41);
		panel.add(btnNewButton);
		
		statetxt = new JComboBox();
		statetxt.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		statetxt.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u9009\u62E9", "\u7BA1\u7406\u5458", "\u7528\u6237"}));
		statetxt.setBounds(672, 52, 121, 27);
		panel.add(statetxt);
		
	    sextxt = new JComboBox();
		sextxt.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		sextxt.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u9009\u62E9", "\u7537", "\u5973"}));
		sextxt.setBounds(999, 50, 110, 27);
		panel.add(sextxt);
		
		usertable = new JTable();
		usertable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserTbaleMouseAction(e);
			}
		});
		usertable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u7528\u6237\u540D", "\u7528\u6237\u5BC6\u7801", "\u7528\u6237\u59D3\u540D", "\u7528\u6237\u6027\u522B", "\u7528\u6237\u7535\u8BDD", "\u7528\u6237\u72B6\u6001", "\u9A8C\u8BC1\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(usertable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new User());//填充表格数据

	}
	
	
	//删除用户信息
	private void UserDelete(ActionEvent ed) {
		// TODO Auto-generated method stub
		String id=idtxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;	
		}
		int n=JOptionPane.showConfirmDialog(null,"确定要删除这条记录吗");
		if(n==0) {
			Connection conn=null;
			try {
				conn=dlutil.getCon();
				int deleteNum=usermangedao.delete(conn, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功");	
					reSetValue();//重置数据
					this.fillTable(new User());//更新表格数据
				}else {
					JOptionPane.showMessageDialog(null, "删除失败");		
				}
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");	
			}finally {
				try {
					dlutil.CloseCon(conn);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	//鼠标点击表格事件
	private void UserTbaleMouseAction(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=this.usertable.getSelectedRow();//获取行数
		//获取列的数据
		this.idtxt.setText((String)usertable.getValueAt(row, 0));//编号
		this.usernametxt.setText((String)usertable.getValueAt(row, 1));//用户名
		this.passwordField.setText((String)usertable.getValueAt(row, 2));//密码
		this.nametxt.setText((String)usertable.getValueAt(row, 3));//姓名
		this.sexboxjcb.setText((String) usertable.getValueAt(row,4));//性别
		this.telephonetxt.setText((String)usertable.getValueAt(row, 5));//电话
		this.stateboxjcb.setText((String) usertable.getValueAt(row, 6));;//状态		
	}

	//修改用户信息
	private void UserUpadte(ActionEvent euu) {
		// TODO Auto-generated method stub
		//获取用户各项信息
		String id=this.idtxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null,"请选择要修改的记录");
			return;
		}
		String username=this.usernametxt.getText();
		String password=new String(this.passwordField.getPassword());
		String repassword=new String(this.resurepasswordField.getPassword());
		String name=this.nametxt.getText();
		String sex= this.sexboxjcb.getText();
		String telephone=this.telephonetxt.getText();
		String state=(String)this.stateboxjcb.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		if(StringUtil.isEmpty(repassword)) {
			JOptionPane.showMessageDialog(null, "确认密码不能为空");
			return;
		}
		if(StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, "用户姓名不能为空");
			return;
		}
		if(StringUtil.isEmpty(telephone)) {
			JOptionPane.showMessageDialog(null, "用户电话不能为空");
			return;
		}
		if(StringUtil.isEmpty(sex)) {
			JOptionPane.showMessageDialog(null, "用户性别不能为空");
			return;
		}
		if(StringUtil.isEmpty(state)) {
			JOptionPane.showMessageDialog(null, "用户状态不能为空");
			return;
		}
		if(!password.equals(repassword)) {
			JOptionPane.showMessageDialog(null, "两次密码输入不一致，请重新输入");
			return;
		}
	 
		//注意这里出错过！！！因为数据库里面的userid是int类型，而我的id是String类型，没有进行转换导致出错，解决方法：integer.parseInt(id)强制转成int型
		User user=new User(Integer.parseInt(id),username,password,name, sex, telephone,state);
			Connection conn=null;
	
		try {
			conn=dlutil.getCon();//获取连接	
			int modifyNum=usermangedao.update(conn, user);
			if(modifyNum==1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.reSetValue();//重置数据
				this.fillTable(new User());//刷新表格数据
			}
			else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dlutil.CloseCon(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	//清空重置
	private void reSetValue() {
		// TODO Auto-generated method stub
		this.idtxt.setText("");
		this.usernametxt.setText("");
		this.passwordField.setText("");
		this.resurepasswordField.setText("");
		this.telephonetxt.setText("");
		this.nametxt.setText("");
		this.sexboxjcb.setText("");
		this.stateboxjcb.setText("");
	}

	//用户查询处理
	private void userSearch(ActionEvent evtt) {
		// TODO Auto-generated method stub
		//获取查询的参数
		String username=this.s_usernametxt.getText();
		String name=this.s_nametxt.getText();
        String state= (String) this.statetxt.getSelectedItem();
         String sex=(String) this.sextxt.getSelectedItem();//获得选择对象
         //用户状态判断
         if(state.equals("请选择")) {
        	 state="";
         }
         //性别判断
         if(sex.equals("请选择")) {
        	 sex="";
         }
        //封装实体对象
        User user=new User(username, name,sex, state);
        //调用表格数据
        this.fillTable(user);
        //查询完就清空文本框
        s_usernametxt.setText("");
       s_nametxt.setText("");
        sextxt.setSelectedIndex(0);
       statetxt.setSelectedIndex(0);
	}

	
	//初始化表格数据
	private void fillTable(User user) {
		DefaultTableModel dtm=(DefaultTableModel) usertable.getModel();//获得model，进行初始化
		dtm.setRowCount(0);//设置成0行，清空表格
		Connection conn=null;
		try {
			conn=dlutil.getCon();//获取数据库连接
			ResultSet rs=usermangedao.list(conn, user);
			//用集合进行遍历
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("userid"));
				v.add(rs.getString("username"));
				v.add(rs.getString("password"));
				v.add(rs.getString("name"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("telephone"));
				v.add(rs.getString("state"));
				v.add(rs.getString("code"));
				dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dlutil.CloseCon(conn);//关闭数据库连接
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
