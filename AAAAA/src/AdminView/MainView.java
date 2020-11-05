package AdminView;

import java.awt.Container;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Adminmodel.Admin;
import Dao.AdminDao;
import UserPackage.src.view.HomepageView;
import model.UserType;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JButton;

public class MainView extends JFrame {

	private JPanel contentPane;
    private UserType usertype;
    private Object userobject;
   public static int x=Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int y=Toolkit.getDefaultToolkit().getScreenSize().height;
	public static int windowwidth=1550;
	public static int windowheight=870;
    private JLabel usernametxt;
	private AdminDao admindao=new AdminDao();
	private Admin admin=new Admin();
	private JLabel timetxt;
	public static String username;
	
	public MainView(String username) throws HeadlessException {
		super();
		this.username = username;
	}

	public static String getUsername() {
		return username;
	}


	public static void setUsername(String username) {
		MainView.username = username;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.getContentPane().setLayout(null);			       
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
	//UserType usertype,Object userobject
	public MainView() {
		setBackground(SystemColor.info);
		setResizable(false);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/images/\u7BA1\u7406.png")));
		this.usertype=usertype;
		this.userobject=userobject;
		setTitle("\u7BA1\u7406\u5458\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((x-windowwidth)/2, (y-windowheight)/2, windowwidth, windowheight);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.info);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		mnNewMenu.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu.setIcon(new ImageIcon(MainView.class.getResource("/images/\u7CFB\u7EDF.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u8F6F\u4EF6\u95EE\u9898");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoftwareProblem(e);
			}
		});
		mntmNewMenuItem_8.setIcon(new ImageIcon(MainView.class.getResource("/images/\u7EF4\u62A4\u5DE5\u4F5C.png")));
		mntmNewMenuItem_8.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu.add(mntmNewMenuItem_8);
		
		//退出系统
		JMenuItem mntmNewMenuItem = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(MainView.this, "确定退出吗")==JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		mntmNewMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mntmNewMenuItem.setIcon(new ImageIcon(MainView.class.getResource("/images/\u9000\u51FA.png")));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("\u4F1A\u5458\u7BA1\u7406");
		mnNewMenu_1.setIcon(new ImageIcon(MainView.class.getResource("/images/\u4F1A\u5458(1).png")));
		mnNewMenu_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u4F1A\u5458\u6DFB\u52A0");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
new UserAddInterFrm().setVisible(true);
		
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainView.class.getResource("/images/\u6DFB\u52A0(3).png")));
		mntmNewMenuItem_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u4F1A\u5458\u5217\u8868\u7EF4\u62A4");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
 new	UserMangeInterFrm().setVisible(true);

			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainView.class.getResource("/images/\u7528\u6237.png")));
		mntmNewMenuItem_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("\u5C0F\u8BF4\u7BA1\u7406");
		mnNewMenu_2.setIcon(new ImageIcon(MainView.class.getResource("/images/\u56FE\u4E66(1).png")));
		mnNewMenu_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u6DFB\u52A0\u5C0F\u8BF4");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
     new	BookAddInterFrm().setVisible(true);

			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(MainView.class.getResource("/images/\u56FE\u4E66\u5F55\u5165(1).png")));
		mntmNewMenuItem_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u5C0F\u8BF4\u5217\u8868\u7EF4\u62A4");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
    new	BookMangeInterFrm().setVisible(true);

			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(MainView.class.getResource("/images/\u67E5\u8BE2(1).png")));
		mntmNewMenuItem_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_6 = new JMenu("\u5206\u7C7B\u7BA1\u7406");
		mnNewMenu_6.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu_6.setIcon(new ImageIcon(MainView.class.getResource("/images/\u5206\u7C7B_.png")));
		mnNewMenu_2.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u5C0F\u8BF4\u5206\u7C7B\u6DFB\u52A0");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	new BookTypeAddInterFrm().setVisible(true);
			}
		});
		mntmNewMenuItem_9.setIcon(new ImageIcon(MainView.class.getResource("/images/\u6DFB\u52A0(4).png")));
		mntmNewMenuItem_9.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu_6.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("\u5206\u7C7B\u5217\u8868\u7EF4\u62A4");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	  new BookTypeMangeInterFrm().setVisible(true);

			}
		});
		mntmNewMenuItem_10.setIcon(new ImageIcon(MainView.class.getResource("/images/\u8BC4\u8BBA(1).png")));
		mntmNewMenuItem_10.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu_6.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_7 = new JMenu("\u7AE0\u8282\u7BA1\u7406");
		menuBar.add(mnNewMenu_7);
		mnNewMenu_7.setIcon(new ImageIcon(MainView.class.getResource("/images/\u7BA1\u7406.png")));
		mnNewMenu_7.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("\u6DFB\u52A0\u7AE0\u8282");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
         new ChapterAddInterFrm().setVisible(true);
			
			}
		});
		mntmNewMenuItem_11.setIcon(new ImageIcon(MainView.class.getResource("/images/\u5199\u6587\u7AE0.png")));
		mntmNewMenuItem_11.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu_7.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("\u7AE0\u8282\u5217\u8868\u7EF4\u62A4");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		new ChapterMangeInterFrm().setVisible(true);
				
			}
		});
		mntmNewMenuItem_12.setIcon(new ImageIcon(MainView.class.getResource("/images/\u5199\u4F5C.png")));
		mntmNewMenuItem_12.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu_7.add(mntmNewMenuItem_12);
		
		JMenu mnNewMenu_3 = new JMenu("\u8BC4\u8BBA\u7BA1\u7406");
		mnNewMenu_3.setIcon(new ImageIcon(MainView.class.getResource("/images/\u521B\u4F5C(1).png")));
		mnNewMenu_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u8BC4\u8BBA\u5217\u8868");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CommentManageView().setVisible(true);
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon(MainView.class.getResource("/images/\u8BC4\u8BBA(3).png")));
		mntmNewMenuItem_5.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_4 = new JMenu("\u4EA4\u6613\u7BA1\u7406");
		mnNewMenu_4.setIcon(new ImageIcon(MainView.class.getResource("/images/\u4EA4\u6613.png")));
		mnNewMenu_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u4EA4\u6613\u5217\u8868");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TransactionManageView().setVisible(true);
			}
		});
		mntmNewMenuItem_6.setIcon(new ImageIcon(MainView.class.getResource("/images/\u4EA4\u6613\u8BB0\u5F55.png")));
		mntmNewMenuItem_6.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu_4.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_5 = new JMenu("\u5E2E\u52A9");
		mnNewMenu_5.setIcon(new ImageIcon(MainView.class.getResource("/images/\u5E2E\u52A9.png")));
		mnNewMenu_5.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutUs(e);
			}
		});
		mntmNewMenuItem_7.setIcon(new ImageIcon(MainView.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC,\u7B11\u8138.png")));
		mntmNewMenuItem_7.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu_5.add(mntmNewMenuItem_7);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u5458\uFF0C\u6B22\u8FCE\u767B\u5F55\u4F7F\u7528\u672C\u7CFB\u7EDF");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("方正舒体", Font.BOLD, 60));
		lblNewLabel.setBounds(539, 291, 860, 94);
		contentPane.add(lblNewLabel);
		
		usernametxt = new JLabel("",JLabel.CENTER);
		usernametxt.setFont(new Font("方正舒体", Font.BOLD, 60));
		usernametxt.setBounds(126, 306, 403, 94);
		this.usernametxt.setText(MainView.getUsername());//获取登录界面的用户名
		this.usernametxt.getText();
		contentPane.add(usernametxt);
	
		
		JLabel lblNewLabel_1 = new JLabel("三味书屋");
		lblNewLabel_1.setFont(new Font("方正舒体", Font.BOLD, 99));
		lblNewLabel_1.setBounds(602, 82, 452, 199);
		contentPane.add(lblNewLabel_1);
		
		timetxt = new JLabel("");
		timetxt.setFont(new Font("微软雅黑", Font.PLAIN, 38));
		timetxt.setBounds(241, 22, 612, 73);	
		//获取当前时间
		Date date=new Date();
	    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    this.timetxt.setText("登录时间为"+df.format(date));
		this.timetxt.getText();
	    contentPane.add(timetxt);
	    
	    JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		HomepageView.homepageInit();
	    	}
	    });
	    btnNewButton.setIcon(new ImageIcon(MainView.class.getResource("/images/\u592A\u9633.png")));
	    btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 25));
	    btnNewButton.setBounds(1280, 82, 243, 66);
	    contentPane.add(btnNewButton);
	    
	    JLabel lblNewLabel_2 = new JLabel("");
	    lblNewLabel_2.setIcon(new ImageIcon(MainView.class.getResource("/png/30.jpg")));
	    lblNewLabel_2.setBounds(0, 0, 1570, 809);
	    contentPane.add(lblNewLabel_2);
	
     
	}
	



//软件问题功能
protected void SoftwareProblem(ActionEvent e) {
		// TODO Auto-generated method stub
	String info="我们将为您提供软件问题答疑";
		String[] buttons= {"去看看","这么麻烦不去了"};
		int pl=JOptionPane.showOptionDialog(this, info, "软件问题", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, new ImageIcon(MainView.class.getResource("/images/\u7EF4\u62A4\u5DE5\u4F5C.png")), buttons, null);
		if(pl==0) {
			//用Java调用系统浏览器打开制定网址
			try {
				URI uri=new URI("http://programmer.ischoolbar.com");
				Desktop.getDesktop().browse(uri);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
			else {
				JOptionPane.showMessageDialog(this,"真抱歉没能帮你解决问题");
			}	
	}
public void init(String username) {
	usernametxt=new JLabel(username);
	contentPane.add(usernametxt);
	
}
//关于我们功能实现
	protected void aboutUs(ActionEvent e) {
		// TODO Auto-generated method stub
		String info="欢迎来到三味书屋~\n";
		info +="书中自有颜如玉     书中自有黄金屋\n";
		info +="还在等什么，海量精美小说包您满意\n";
		
		Object[] buttons= {"去看看","暂时不想去"};
		 int ret=JOptionPane.showOptionDialog(this, info, "关于我们", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, new ImageIcon(MainView.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC,\u7B11\u8138.png")),buttons, null);
		if(ret==0) {
			JOptionPane.showMessageDialog(this,"开启三味书屋之旅");
			HomepageView.homepageInit();
		}else {
			JOptionPane.showMessageDialog(this,"欢迎下次光临");
		}
	}


}
