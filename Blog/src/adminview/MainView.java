package adminview;

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

import blogview.HomepageView;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JButton;

public class MainView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private Object userobject;
   public static int x=Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int y=Toolkit.getDefaultToolkit().getScreenSize().height;
	public static int windowwidth=1550;
	public static int windowheight=870;
    private JLabel usernametxt;
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
	public MainView() {
		setBackground(SystemColor.info);
		setResizable(false);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/images/\u7BA1\u7406.png")));
		this.userobject=userobject;
		setTitle("\u7BA1\u7406\u5458\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((x-windowwidth)/2, (y-windowheight)/2, windowwidth, windowheight);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.info);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("\u7528\u6237\u7BA1\u7406");
		mnNewMenu_1.setIcon(null);
		mnNewMenu_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u7528\u6237\u6DFB\u52A0");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
new UserAddInterFrm().setVisible(true);
		
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainView.class.getResource("/images/\u6DFB\u52A0(3).png")));
		mntmNewMenuItem_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u7528\u6237\u5217\u8868\u7EF4\u62A4");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
 new	UserMangeInterFrm().setVisible(true);

			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainView.class.getResource("/images/\u7528\u6237.png")));
		mntmNewMenuItem_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("\u535A\u6587\u7BA1\u7406");
		mnNewMenu_2.setIcon(null);
		mnNewMenu_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u6DFB\u52A0\u535A\u6587");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
     new	ArticleAddInterFrm().setVisible(true);

			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(MainView.class.getResource("/images/\u56FE\u4E66\u5F55\u5165(1).png")));
		mntmNewMenuItem_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u535A\u6587\u5217\u8868\u7EF4\u62A4");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
    new	ArticleMangeInterFrm().setVisible(true);

			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(MainView.class.getResource("/images/\u67E5\u8BE2(1).png")));
		mntmNewMenuItem_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("\u8BC4\u8BBA\u7BA1\u7406");
		mnNewMenu_3.setIcon(null);
		mnNewMenu_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u8BC4\u8BBA\u5217\u8868");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CommentManageView().setVisible(true);
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon(MainView.class.getResource("/images/\u8BC4\u8BBA(3).png")));
		mntmNewMenuItem_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_3_1 = new JMenu("\u9000\u51FA\u7CFB\u7EDF");
		mnNewMenu_3_1.setIcon(null);
		mnNewMenu_3_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_3_1);
		
		JMenuItem mntmNewMenuItem_5_1 = new JMenuItem("\u8FD4\u56DE\u4E3B\u754C\u9762");
		mntmNewMenuItem_5_1.setIcon(new ImageIcon(MainView.class.getResource("/images/\u9000\u51FA.png")));
		mntmNewMenuItem_5_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mnNewMenu_3_1.add(mntmNewMenuItem_5_1);
		mntmNewMenuItem_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomepageView.homepageInit();
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernametxt = new JLabel("",JLabel.CENTER);
		usernametxt.setFont(new Font("·½ÕýÊæÌå", Font.BOLD, 60));
		usernametxt.setBounds(126, 306, 403, 94);
		this.usernametxt.setText(MainView.getUsername());//»ñÈ¡µÇÂ¼½çÃæµÄÓÃ»§Ãû
		this.usernametxt.getText();
		contentPane.add(usernametxt);
		//»ñÈ¡µ±Ç°Ê±¼ä
		Date date=new Date();
	    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    
	    JLabel lblNewLabel_2 = new JLabel("");
	    lblNewLabel_2.setIcon(new ImageIcon(MainView.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710215541.png")));
	    lblNewLabel_2.setBounds(0, 0, 1570, 809);
	    contentPane.add(lblNewLabel_2);
	
     
	}
public void init(String username) {
	usernametxt=new JLabel(username);
	contentPane.add(usernametxt);
	
}


}
