package UserPackage.src.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Adminmodel.Book;
import Adminmodel.User;
import UserPackage.src.Dao.MoneyDao;
import UserPackage.src.Dao.UserDao;
import UserPackage.src.DaoImple.UserDaoImplement;
import UserPackage.src.Entity.Money;
import util.DLUtil;
import util.StringUtil;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class BuyView extends JFrame {
    private Money moneymoney;
	private JPanel contentPane;
	private JTextField investmoneytextField;
	private JLabel shengyumoney;
    public static String username;
    private JLabel usernametxt;//用户名标签
    private DLUtil dlutil=new DLUtil();
    private MoneyDao moneydao=new MoneyDao();
    private static int userid;
    private JButton btnNewButton;
    private JLabel lblNewLabel;
    private JLabel useridtxt;
    public static Double money;
  
    public static Double getMoney() {
		return money;
	}
	public static void setMoney(Double money) {
		BuyView.money = money;
	}
	public BuyView(double money) throws HeadlessException {
		super();
		this.money= money;
	} 
	public BuyView(int userid) throws HeadlessException {
		super();
		this.userid = userid;
	} 
    public static int getUserid() {
		return userid;
	}
	public static void setUserid(int userid) {
		BuyView.userid = userid;
	}
	public BuyView(String username) throws HeadlessException {
		super();
		this.username = username;
	}
	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		BuyView.username = username;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyView frame = new BuyView();
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
	public BuyView() {
	
		setBounds(100, 100, 625, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u5F53\u524D\u70B9\u5238\u6570\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(BuyView.class.getResource("/images/\u94B1\u888B\u5B50.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 27));
		lblNewLabel_1.setBounds(92, 190, 199, 33);
		contentPane.add(lblNewLabel_1);
		
	   shengyumoney = new JLabel("0.00");
		shengyumoney.setFont(new Font("宋体", Font.PLAIN, 25));
		shengyumoney.setBounds(302, 188, 176, 41);
		contentPane.add(shengyumoney);
		
		JLabel lblNewLabel_3 = new JLabel("\u652F\u4ED8\u91D1\u989D\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(BuyView.class.getResource("/images/\u94B1\u888B(1).png")));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 27));
		lblNewLabel_3.setBounds(118, 257, 173, 41);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u652F\u4ED8");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eb) {
				BuyAction(eb);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BuyView.class.getResource("/images/\u94B1\u888B.png")));
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 27));
		btnNewButton_1.setBounds(200, 356, 193, 41);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("\u4EB2\u7231\u7684\u7528\u6237\uFF1A");
		lblNewLabel_7.setIcon(new ImageIcon(BuyView.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC,\u7B11\u8138.png")));
		lblNewLabel_7.setFont(new Font("微软雅黑", Font.BOLD, 27));
		lblNewLabel_7.setBounds(92, 116, 199, 41);
		contentPane.add(lblNewLabel_7);
		
		usernametxt = new JLabel("");
		usernametxt.setFont(new Font("宋体", Font.PLAIN, 30));
		usernametxt.setBounds(299, 115, 302, 46);
		this.usernametxt.setText(BuyView.username);
		this.usernametxt.getText();
		contentPane.add(usernametxt);
		
		investmoneytextField = new JTextField();
		investmoneytextField.setBounds(301, 257, 211, 41);
		contentPane.add(investmoneytextField);
		investmoneytextField.setColumns(10);
		
		btnNewButton = new JButton("\u8FD4\u56DE\u9996\u9875");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomepageView.homepageInit();//创建返回按钮监听,点击则跳转首页界面
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 23));
		btnNewButton.setIcon(new ImageIcon(BuyView.class.getResource("/images/\u56FE\u4E66(4).png")));
		btnNewButton.setBounds(388, 24, 187, 41);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 25));
		lblNewLabel.setBounds(229, 78, 62, 28);
		contentPane.add(lblNewLabel);
		
		useridtxt = new JLabel("");
		useridtxt.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		useridtxt.setBounds(302, 75, 144, 30);
		
		contentPane.add(useridtxt);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(BuyView.class.getResource("/UserPackage/src/newimages/1.png")));
		lblNewLabel_2.setBounds(0, 0, 611, 493);
		contentPane.add(lblNewLabel_2);
	}

	
	//点券购买事件处理
//	private void BuyAction(ActionEvent eb) {
//		// TODO Auto-generated method stub
//		UserDaoImplement udi = new UserDaoImplement();
//		String id=String.valueOf(udi.userid);
//		this.useridtxt.setText(id);
//		this.useridtxt.getText();
//		String nowmoney=this.investmoneytextField.getText();//输入金额
//		Money money=new Money();
//		Double yuanlaimoney=money.getMoney();
//		String yuanmoney=String.valueOf(yuanlaimoney);
//		this.shengyumoney.setText(yuanmoney);//显示原来金额数
//		this.shengyumoney.getText();
//			
//		if(StringUtil.isEmpty(nowmoney)) {
//			JOptionPane.showMessageDialog(null, "您还未输入金额");
//			return;
//		}else {
//			double paymoney=Double.parseDouble(nowmoney);//输入金额
//			double totalmoney=money.getMoney()+paymoney;
//			String total=String.valueOf(totalmoney);
//			Connection conn=null;
//			try {
//				conn=dlutil.getCon();
//				ResultSet rs=moneydao.list(conn, money);
//				Double moneymoney=0.00;
//				while(rs.next()) {
//					Vector v=new Vector();
//					userid=rs.getInt("userid");
//					username=rs.getString("username");
//					moneymoney=rs.getDouble("money");
//					}
//				User user=new User();
//				int useridd=0;
//				if(user.getUsername().equals(BuyView.getUsername())){
//					useridd=user.getUserid();
//				}
//				Money money1=new Money(useridd, totalmoney);
////				int addNum=moneydao.update(conn, money1);
//				int addNum=moneydao.update(conn, money1);
//				if(addNum==1) {
//					JOptionPane.showMessageDialog(null, "充值成功");
//					this.useridtxt.setText(total);
//					this.useridtxt.getText();
//				}else {
//					JOptionPane.showMessageDialog(null, "充值失败");
//					return;
//				}
//			}catch(Exception e) {
//				e.printStackTrace();
//				JOptionPane.showMessageDialog(null, "充值失败");
//			}finally {
//				try {
//					dlutil.CloseCon(conn);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}	
//		}
//	}
	private void BuyAction(ActionEvent eb) {
		String money=this.investmoneytextField.getText();//获取当前的金额数
		
		if(StringUtil.isEmpty(money)) {
			JOptionPane.showMessageDialog(null, "请输入金额");
		}else {
			try {
		UserDao udi = new UserDaoImplement();//创建用户Dao实现类对象
		         
				Double nowmoney=Double.parseDouble(money);//获取当前的金额数
				this.moneymoney.setMoney(this.moneymoney.getMoney()+nowmoney);
				double total=this.moneymoney.getMoney();
            if(udi.upDateMoney(total)) {
			JOptionPane.showMessageDialog(null, "充值成功");
	          this.shengyumoney.setText(String.valueOf(moneymoney.getMoney()));
	          this.shengyumoney.getText();
			return;
	}else{
		JOptionPane.showMessageDialog(null, "充值失败");
		}
	}catch (NumberFormatException e2) {
		JOptionPane.showMessageDialog(null, "输入格式错误");
	}
			}
	}
}
