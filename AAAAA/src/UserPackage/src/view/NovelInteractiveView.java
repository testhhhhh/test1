package UserPackage.src.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Adminmodel.Book;
import UserPackage.src.DaoImple.ChapterDaoilplement;
import UserPackage.src.DaoImple.NovelDaoImplement;
import UserPackage.src.DaoImple.UserDaoImplement;
import UserPackage.src.Entity.Money;
import util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class NovelInteractiveView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 private Book book;
	private JLabel novelmoneyshowlabel;
	/**
	 * Launch the application.
	 */
	public static void NovelInteractiveViewInit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovelInteractiveView frame = new NovelInteractiveView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//创建小说介绍界面窗口
	}

	/**
	 * Create the frame.
	 */
	public NovelInteractiveView() {
		NovelDaoImplement ndi = new NovelDaoImplement();//创建小说Dao实现类对象
		UserDaoImplement udi = new UserDaoImplement();//创建用户Dao实现类对象
		ndi.novelinteractive();//调用小说介绍方法
		setTitle("\u5C0F\u8BF4\u754C\u9762");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1550, 870);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//创建内容面板

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1578, 833);
		contentPane.add(panel);
		panel.setLayout(null);
		//创建面板

		JLabel novelpicturelabel = new JLabel("");
		novelpicturelabel.setIcon(new ImageIcon(ndi.nnovel.getNovelpicture()));
		novelpicturelabel.setBounds(30, 65, 312, 320);
		panel.add(novelpicturelabel);
		//创建小说图片标签

		JLabel novelnamelabel = new JLabel("\u5C0F\u8BF4\u540D\u79F0:");
		novelnamelabel.setForeground(new Color(255, 255, 0));
		novelnamelabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		novelnamelabel.setBounds(80, 395, 156, 40);
		panel.add(novelnamelabel);
		//创建小说名称标签

		JLabel novelnameshowlabel = new JLabel("");
		novelnameshowlabel.setForeground(new Color(255, 255, 0));
		novelnameshowlabel.setFont(new Font("宋体", Font.PLAIN, 25));
		novelnameshowlabel.setBounds(248, 395, 273, 40);
		novelnameshowlabel.setText(ndi.nnovel.getNovelname());
		panel.add(novelnameshowlabel);
		//创建小说名称显示标签

		JLabel novelwriterlabel = new JLabel("\u4F5C\u8005\uFF1A");
		novelwriterlabel.setForeground(new Color(255, 255, 0));
		novelwriterlabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		novelwriterlabel.setBounds(142, 455, 94, 33);
		panel.add(novelwriterlabel);
		//创建小说作者标签

		JLabel novelwritershowlabel = new JLabel("");
		novelwritershowlabel.setForeground(new Color(255, 255, 0));
		novelwritershowlabel.setFont(new Font("宋体", Font.PLAIN, 25));
		novelwritershowlabel.setBounds(246, 455, 318, 47);
		novelwritershowlabel.setText(ndi.nnovel.getNovelwriter());
		panel.add(novelwritershowlabel);
		//创建小说作者显示标签

		JLabel novelmoneylabel = new JLabel("\u70B9\u5238\uFF1A");
		novelmoneylabel.setForeground(new Color(255, 255, 0));
		novelmoneylabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		novelmoneylabel.setBounds(142, 510, 94, 33);
		panel.add(novelmoneylabel);
		//创建小说点券数标签

		novelmoneyshowlabel = new JLabel("");
		novelmoneyshowlabel.setForeground(new Color(255, 255, 0));
		novelmoneyshowlabel.setFont(new Font("宋体", Font.PLAIN, 25));
		novelmoneyshowlabel.setBounds(246, 512, 88, 40);
		novelmoneyshowlabel.setText(String.valueOf(ndi.nnovel.getNovelmony()));
		panel.add(novelmoneyshowlabel);
		//创建小说点券数显示标签

		JLabel novelmainlabel = new JLabel("\u5C0F\u8BF4\u7B80\u4ECB\uFF1A");
		novelmainlabel.setForeground(new Color(255, 255, 0));
		novelmainlabel.setFont(new Font("方正舒体", Font.BOLD, 30));
		novelmainlabel.setBounds(80, 553, 156, 56);
		panel.add(novelmainlabel);
		//创建小说概要标签

		JLabel novelmainshowlabel = new JLabel("");
		novelmainshowlabel.setFont(new Font("微软雅黑", Font.PLAIN, 23));
		novelmainshowlabel.setForeground(new Color(255, 255, 0));
		novelmainshowlabel.setBounds(220, 553, 612, 213);
		try {
			ndi.JlabelSetText(novelmainshowlabel, ndi.nnovel.getNovelmain());//调用标签内文本自动换行方法
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		panel.add(novelmainshowlabel);
		//创建小说概要显示标签

		JButton returnbutton = new JButton("\u8FD4\u56DE\u9996\u9875");		
		returnbutton.setBounds(1255, 34, 178, 41);
		panel.add(returnbutton);
		returnbutton.setFont(new Font("方正舒体", Font.BOLD, 30));
        returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomepageView.homepageInit();//创建返回按钮监听,点击则跳转首页界面
			}
		});
        //创建返回按钮
        
		JScrollPane jp = new JScrollPane();
		jp.setBounds(930, 99, 462, 724);
		panel.add(jp);
		//创建章节列表滚动面板

		JList list = new JList();
		ChapterDaoilplement cdi = new ChapterDaoilplement();//创建章节Dao实现类对象
		cdi.chapterlist();//调用章节列表方法
		list.setFont(new Font("华文新魏", Font.PLAIN, 28));
		list.setModel(cdi.aaa);
		list.setForeground(Color.RED);
		list.setBackground(new Color(255, 228, 225));
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!list.getValueIsAdjusting()) { // 设置只有释放鼠标时才触发
					if (udi.userid != 0) {
						cdi.cchaptername = (String) list.getSelectedValue();//将点击的章节名存入cchaptername
						ChapterView.ChapterViewInit();//跳转至章节阅读界面
					} else
						JOptionPane.showMessageDialog(null, "您无权限，请先登录", "提示", JOptionPane.PLAIN_MESSAGE);
				}

			}

		});
		jp.setViewportView(list);
		
		JButton btnNewButton = new JButton("\u6211\u8981\u6253\u8D4F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eb) {
				BuyAction(eb);
			}
		});
		btnNewButton.setSelectedIcon(new ImageIcon(NovelInteractiveView.class.getResource("/images/\u82B1(1).png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		btnNewButton.setBounds(416, 281, 207, 65);
		panel.add(btnNewButton);
		
		
		
		JButton commentbutton = new JButton("\u6211\u8981\u8BC4\u8BBA");
		commentbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommentView.CommentViewInit();
			}
		});
		commentbutton.setFont(new Font("宋体", Font.PLAIN, 26));
		commentbutton.setBounds(416, 231, 207, 40);
		panel.add(commentbutton);
		//创建评论按钮
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NovelInteractiveView.class.getResource("/png/6e0e9020f9455d3613fdaf123059605.png")));
		lblNewLabel.setBounds(0, 0, 1550,870);
		panel.add(lblNewLabel);
		//创建小说介绍界面背景图片
	}
	
	
	//点券购买事件处理
	protected void BuyAction(ActionEvent eb) {
		// TODO Auto-generated method stub

  
		JOptionPane.showMessageDialog(null,"感谢您的打赏，作者会继续努力的");
	


			}	
	}

