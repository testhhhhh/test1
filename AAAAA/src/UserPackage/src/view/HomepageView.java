package UserPackage.src.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import AdminView.LoginFrm;
import AdminView.UserAddInterFrm;
import Adminmodel.Book;
import Dao.BookDao;
import UserPackage.src.DaoImple.NovelDaoImplement;
import UserPackage.src.DaoImple.UserDaoImplement;
import util.DLUtil;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.table.DefaultTableModel;

public class HomepageView extends JFrame {
public static String username;
private JTable noveltable;
private DLUtil dlutil=new DLUtil();
private BookDao bookdao=new BookDao();
private JTextField searchtextField;
public static int userid;

public HomepageView(int userid) throws HeadlessException {
	super();
	this.userid=userid;
}
public static int getUserid() {
	return userid;
}
public static void setUserid(int userid) {
	HomepageView.userid = userid;
}
public HomepageView(String username) throws HeadlessException {
	super();
	this.username = username;
}
//传入用户名的参数
	public static String getUsername() {
	return username;
}

public static void setUsername(String username) {
	HomepageView.username = username;
}

	/**
	 * Launch the application.
	 */
	public static void homepageInit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomepageView frame = new HomepageView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//创建首页窗口
	}

	/**
	 * Create the frame.
	 */
	public HomepageView() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		int x = Toolkit.getDefaultToolkit().getScreenSize().width;
		int y = Toolkit.getDefaultToolkit().getScreenSize().height;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1550,870);
		getContentPane().setLayout(null);
		//创建内容面板		

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1536, 833);
		getContentPane().add(panel);
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.RED);
		panel.setLayout(null);
		//创建创作中心标签

		NovelDaoImplement ndi = new NovelDaoImplement();//创建小说Dao实现类对象
		ndi.novellist(5, ndi.d5);//调用小说列表展示方法

		ndi.novellist(2, ndi.d2);

		ndi.novellist(3, ndi.d3);

		ndi.novellist(4, ndi.d4);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setFont(new Font("华文新魏", Font.PLAIN, 30));
		tabbedPane.setBounds(10, 0,1550,870);
		panel.add(tabbedPane);
				
				JPanel userview = new JPanel();
				tabbedPane.addTab("登录注册端", null, userview, null);
				userview.setLayout(null);
				//创建注册按钮

				JLabel titlelabel = new JLabel("\u4E09\u5473\u4E66\u5C4B");
				
				titlelabel.setBounds(84, 62, 413, 106);
				userview.add(titlelabel);
				titlelabel.setForeground(new Color(255, 255, 204));
				titlelabel.setBackground(Color.BLACK);
				titlelabel.setFont(new Font("方正舒体", Font.BOLD, 99));
				//创建搜索文本框

				JButton loginbutton = new JButton("\u767B\u9646");
				loginbutton.setBounds(119, 340, 126, 37);
				userview.add(loginbutton);
				loginbutton.setBackground(new Color(255, 250, 205));
				loginbutton.setFont(new Font("方正舒体", Font.BOLD, 30));
				//创建登录按钮

				JButton registerbutton = new JButton("\u6CE8\u518C");
				registerbutton.setBounds(376, 340, 126, 37);
				userview.add(registerbutton);
				registerbutton.setBackground(new Color(255, 250, 205));
				registerbutton.setForeground(Color.BLACK);
				registerbutton.setFont(new Font("方正舒体", Font.BOLD, 30));
				
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setIcon(new ImageIcon(HomepageView.class.getResource("/png/ddc2c000c2e1a6ab1053860c9c4c982.png")));
				lblNewLabel_3.setBounds(0, 0, 1367, 835);
				userview.add(lblNewLabel_3);
				//为搜一搜按钮设置监听

				registerbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegisterView.registerInit();

					}
				});
				//为注册按钮设置监听,点击注册按钮跳转至注册界面

				loginbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						LoginView.loginlnit();
					}
				});
														
														
														UserDaoImplement udi1 = new UserDaoImplement();//创建用户Dao实现类对象
														//为个人中心标签设置鼠标监听,当用户id不为0时即用户登录后,才能跳转页面至个人中心页面
														
														
														UserDaoImplement udi = new UserDaoImplement();//创建用户Dao实现类对象
				
						JPanel mainview = new JPanel();
						
						tabbedPane.addTab("主界面", null, mainview, null);
						mainview.setBackground(new Color(153, 255, 204));
						JScrollPane schooljp = new JScrollPane();
						schooljp.setBounds(396, 222, 223, 604);
						
								JList schoollist = new JList();//创建青春校园列表
								schoollist.setForeground(Color.BLACK);
								schoollist.setFont(new Font("华文新魏", Font.PLAIN, 28));
								schoollist.setModel(ndi.d3);
								schoollist.setBackground(new Color(230, 230, 250));
								schoollist.addListSelectionListener(new ListSelectionListener() {
									public void valueChanged(ListSelectionEvent e) {
										if (!schoollist.getValueIsAdjusting()) { // 设置只有释放鼠标时才触发
											ndi.nnovelname = schoollist.getSelectedValue();
											NovelInteractiveView.NovelInteractiveViewInit();
										}

									}

								});
								schooljp.setViewportView(schoollist);
								JScrollPane sciencejp = new JScrollPane();
								sciencejp.setBounds(75, 222, 236, 604);
								
										JList sciencelist = new JList();//创建悬疑科幻列表
										sciencelist.setForeground(new Color(0, 0, 0));
										
											sciencelist.setFont(new Font("华文新魏", Font.PLAIN, 28));
											sciencelist.setModel(ndi.d2);
											sciencelist.setBackground(new Color(224, 255, 255));
											sciencelist.addListSelectionListener(new ListSelectionListener() {
												public void valueChanged(ListSelectionEvent e) {
													if (!sciencelist.getValueIsAdjusting()) { // 设置只有释放鼠标时才触发
														ndi.nnovelname = sciencelist.getSelectedValue();
														NovelInteractiveView.NovelInteractiveViewInit();
													}

												}

											});
											sciencejp.setViewportView(sciencelist);
											JScrollPane fantasyjp = new JScrollPane();
											fantasyjp.setBounds(998, 222, 230, 604);
											
													JList fantasylist = new JList();//创建玄幻仙侠列表
													fantasylist.setFont(new Font("华文新魏", Font.PLAIN, 28));
													fantasylist.setModel(ndi.d5);
													fantasylist.setForeground(new Color(0, 0, 0));
													fantasylist.setBackground(new Color(255, 228, 225));
													fantasylist.addListSelectionListener(new ListSelectionListener() {
														public void valueChanged(ListSelectionEvent e) {
															if (!fantasylist.getValueIsAdjusting()) { // 设置只有释放鼠标时才触发
																ndi.nnovelname = fantasylist.getSelectedValue();//将所选择的小说名存入nnovelname
																NovelInteractiveView.NovelInteractiveViewInit();//跳转至小说介绍界面
															}

														}

													});
													fantasyjp.setViewportView(fantasylist);
													JScrollPane classicjp = new JScrollPane();
													classicjp.setBounds(696, 222, 230, 604);
													
															JList classiclist = new JList();//创建经典名著列表
															classiclist.setForeground(new Color(0, 0, 0));
															classiclist.setFont(new Font("华文新魏", Font.PLAIN, 28));
															classiclist.setModel(ndi.d4);
															classiclist.setBackground(new Color(255, 255, 224));
															classiclist.addListSelectionListener(new ListSelectionListener() {
																public void valueChanged(ListSelectionEvent e) {
																	if (!classiclist.getValueIsAdjusting()) { // 设置只有释放鼠标时才触发
																		ndi.nnovelname = classiclist.getSelectedValue();
																		NovelInteractiveView.NovelInteractiveViewInit();

																	}

																}

															});
															classicjp.setViewportView(classiclist);
															mainview.setLayout(null);
															mainview.add(classicjp);
															mainview.add(fantasyjp);
															mainview.add(schooljp);
															mainview.add(sciencejp);
															
															JPanel panel_5 = new JPanel();
															panel_5.setBackground(new Color(255, 255, 204));
															panel_5.setBounds(0, 137, 1367, 86);
															mainview.add(panel_5);
															panel_5.setLayout(null);
															//创建分类面板

															JLabel schoollabel = new JLabel("\u9752\u6625\u6821\u56ED");
															schoollabel.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u82B1(1).png")));
															schoollabel.setBounds(94, 22, 205, 37);
															panel_5.add(schoollabel);
															schoollabel.setForeground(new Color(0, 0, 0));
															schoollabel.setBackground(new Color(0, 255, 0));
															schoollabel.setFont(new Font("方正舒体", Font.BOLD, 35));
															//创建玄幻仙侠标签

															JLabel sciencelabel = new JLabel("\u60AC\u7591\u79D1\u5E7B");
															sciencelabel.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u641C\u7D22.png")));
															sciencelabel.setBounds(389, 20, 205, 41);
															panel_5.add(sciencelabel);
															sciencelabel.setFont(new Font("方正舒体", Font.BOLD, 35));
															//创建青春校园标签

															JLabel fantasylabel = new JLabel("\u7384\u5E7B\u4ED9\u4FA0");
															fantasylabel.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u5200.png")));
															fantasylabel.setBounds(712, 21, 205, 38);
															panel_5.add(fantasylabel);
															fantasylabel.setFont(new Font("方正舒体", Font.BOLD, 35));
															//创建悬疑科幻标签

															JLabel classilabel = new JLabel("\u7ECF\u5178\u8457\u4F5C");
															classilabel.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u592A\u9633.png")));
															classilabel.setBounds(1016, 21, 188, 38);
															panel_5.add(classilabel);
															classilabel.setFont(new Font("方正舒体", Font.BOLD, 35));
															//创建网站标题标签

															JLabel personallabel = new JLabel("\u4E2A\u4EBA\u4E2D\u5FC3");
															personallabel.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC,\u7B11\u8138(1).png")));
															personallabel.setBounds(57, 48, 183, 37);
															mainview.add(personallabel);
															personallabel.setForeground(new Color(255, 255, 0));
															personallabel.setFont(new Font("方正舒体", Font.BOLD, 30));
															//创建个人中心标签

															JLabel uploadnovellabel = new JLabel("\u521B\u4F5C\u4E2D\u5FC3");
															uploadnovellabel.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u521B\u4F5C(1).png")));
															uploadnovellabel.setBounds(329, 42, 179, 48);
															mainview.add(uploadnovellabel);
															uploadnovellabel.setForeground(new Color(255, 255, 0));
															uploadnovellabel.setFont(new Font("方正舒体", Font.BOLD, 30));
															JLabel lblNewLabel_1 = new JLabel("\u8D2D\u5238\u4E2D\u5FC3");
															lblNewLabel_1.addMouseListener(new MouseAdapter() {
																@Override
																public void mouseClicked(MouseEvent e) {
																	if(udi1.userid!=0) {
																	new BuyView().setUserid(udi1.userid);
																	new BuyView().setVisible(true);}
																	else {
																		JOptionPane.showMessageDialog(null, "您无权限，请先登录", "提示", JOptionPane.PLAIN_MESSAGE);
																	}
																}
															});
															lblNewLabel_1.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u94B1\u888B\u5B50.png")));
															lblNewLabel_1.setForeground(new Color(255, 255, 102));
															lblNewLabel_1.setFont(new Font("方正舒体", Font.BOLD, 30));
															lblNewLabel_1.setBounds(608, 39, 218, 59);
															mainview.add(lblNewLabel_1);
															
															JLabel lblNewLabel = new JLabel("");
															lblNewLabel.setIcon(new ImageIcon(HomepageView.class.getResource("/png/89e350fe7644138f314702886cba20f.png")));
															lblNewLabel.setBounds(0, 0, 1367, 826);
															mainview.add(lblNewLabel);
															uploadnovellabel.addMouseListener(new MouseAdapter() {
																public void mouseClicked(MouseEvent e) {
																	if (udi.userid != 0) {
																		UploadNovelView.UploadNovelViewInit();}
																	 else
																		JOptionPane.showMessageDialog(null, "您无权限，请先登录", "提示", JOptionPane.PLAIN_MESSAGE);
																}
															});
															personallabel.addMouseListener(new MouseAdapter() {
																public void mouseClicked(MouseEvent e) {
																//为上传小说标签设置鼠标监听,当用户id不为0时即用户登录后,才能跳转页面至小说上传页面	
																	if (udi.userid != 0)
																		PersonalCentreView.PersonalCentrelnit();
																	else
																		JOptionPane.showMessageDialog(null, "您无权限，请先登录", "提示", JOptionPane.PLAIN_MESSAGE);
																}
															});
				
				JPanel searchnovel = new JPanel();
				tabbedPane.addTab("搜索小说", null, searchnovel, null);
				searchnovel.setLayout(null);
						
						JScrollPane scrollPane = new JScrollPane();
						scrollPane.setBounds(76, 215, 1202, 488);
						searchnovel.add(scrollPane);
						
						noveltable = new JTable();
						noveltable.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row=noveltable.getSelectedRow();//获取行数
							searchtextField.setText((String) noveltable.getValueAt(row, 0));	//小说名称
								ndi.nnovelname =searchtextField.getText();
								if (ndi.novelinteractive()) {
									NovelInteractiveView.NovelInteractiveViewInit();//有结果则跳转至小说介绍页面
								} else {
									JOptionPane.showMessageDialog(null, "无搜索结果", "提示", JOptionPane.PLAIN_MESSAGE);//弹出窗口提示无结果
								}
							}
						});
						noveltable.setRowHeight(33);
						noveltable.setForeground(SystemColor.textText);
						noveltable.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"\u5C0F\u8BF4\u540D\u79F0", "\u5C0F\u8BF4\u7B80\u4ECB", "\u5C0F\u8BF4\u4F5C\u8005", "\u5C0F\u8BF4\u70B9\u5238\u6570", "\u5C0F\u8BF4\u7C7B\u578B"
							}
						) {
							boolean[] columnEditables = new boolean[] {
								false, false, false, false, false
							};
							public boolean isCellEditable(int row, int column) {
								return columnEditables[column];
							}
						});
						noveltable.getColumnModel().getColumn(0).setPreferredWidth(88);
						noveltable.getColumnModel().getColumn(1).setPreferredWidth(158);
						noveltable.getColumnModel().getColumn(2).setPreferredWidth(86);
						noveltable.getColumnModel().getColumn(3).setPreferredWidth(85);
						noveltable.getColumnModel().getColumn(4).setPreferredWidth(84);
						noveltable.setFont(new Font("华文仿宋", Font.PLAIN, 26));
						scrollPane.setViewportView(noveltable);
						
						//搜索按钮
						JButton btnNewButton_1 = new JButton("\u641C\u7D22");
						btnNewButton_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent es) {
								SearchAction(es);
							}
						});
						btnNewButton_1.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u641C\u7D22.png")));
						btnNewButton_1.setFont(new Font("华文新魏", Font.PLAIN, 29));
						btnNewButton_1.setBounds(999, 78, 146, 46);
						searchnovel.add(btnNewButton_1);
						
						searchtextField = new JTextField();
						searchtextField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
						searchtextField.setBounds(478, 79, 441, 46);
						searchnovel.add(searchtextField);
						searchtextField.setColumns(10);
						
						JLabel lblNewLabel_4 = new JLabel("\u8F93\u5165\u5C0F\u8BF4\u540D\u79F0\uFF1A");
						lblNewLabel_4.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u56FE\u4E66(4).png")));
						lblNewLabel_4.setFont(new Font("方正舒体", Font.BOLD, 30));
						lblNewLabel_4.setBounds(227, 78, 254, 40);
						searchnovel.add(lblNewLabel_4);
						
						JLabel lblNewLabel_5 = new JLabel("\u70B9\u51FB\u4E0B\u65B9\u8868\u683C\u5185\u5BB9\u5373\u53EF\u8DF3\u8F6C\u76F8\u5E94\u5C0F\u8BF4");
						lblNewLabel_5.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u5411\u4E0B.png")));
						lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 23));
						lblNewLabel_5.setBounds(116, 163, 424, 40);
						searchnovel.add(lblNewLabel_5);
						
						JLabel lblNewLabel_6 = new JLabel("");
						lblNewLabel_6.setIcon(new ImageIcon(HomepageView.class.getResource("/png/2f7523d74431ae1cfcfce42320dc825.png")));
						lblNewLabel_6.setBounds(0, 0, 1377, 834);
						searchnovel.add(lblNewLabel_6);
						
						JPanel Adminview = new JPanel();
						tabbedPane.addTab("小说管理端", null, Adminview, null);
						Adminview.setLayout(null);
						
						JButton btnNewButton = new JButton("\u70B9\u51FB\u524D\u5F80\u7BA1\u7406\u7AEF");
						btnNewButton.setBackground(new Color(255, 255, 204));
						btnNewButton.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC,\u7B11\u8138.png")));
						btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 23));
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								new LoginFrm().setVisible(true);
								HomepageView();
							}
						});
						btnNewButton.setBounds(448, 313, 263, 58);
						Adminview.add(btnNewButton);
						
						JButton btnNewButton_2 = new JButton("\u6CE8\u518C");
						btnNewButton_2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								new UserAddInterFrm().setVisible(true);
							}
						});
						btnNewButton_2.setBackground(new Color(255, 255, 204));
						btnNewButton_2.setIcon(new ImageIcon(HomepageView.class.getResource("/images/\u7BA1\u7406\u5458(1).png")));
						btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 27));
						btnNewButton_2.setBounds(220, 313, 144, 58);
						Adminview.add(btnNewButton_2);
						
						JLabel lblNewLabel_2 = new JLabel("");
						lblNewLabel_2.setIcon(new ImageIcon(HomepageView.class.getResource("/png/d9cdc2d2ac7bac0cc654cd808836a62.png")));
						lblNewLabel_2.setBounds(0, 0, 1388, 855);
						Adminview.add(lblNewLabel_2);
		//创建背景图片标签 
		
		//填充表格数据
		this.filltable(new Book());
        this.noveltable.setVisible(true);
	}
	
	
	protected void HomepageView() {
		// TODO Auto-generated method stub
		this.dispose();
	}
	//小说搜索处理
	protected void SearchAction(ActionEvent es) {
		// TODO Auto-generated method stub
	String novelname=this.searchtextField.getText().trim();//获取小说名称
	Book book=new Book(novelname);//封装数据
	this.filltable(book);//调用表格数据
	this.searchtextField.setText("");
	}
	
	
		//初始化表格数据
		private void filltable(Book book) {
			DefaultTableModel dtm=(DefaultTableModel)noveltable.getModel();//获得model，进行初始化
			dtm.setRowCount(0);//设置成0行，清空表格
			Connection conn=null;
			try {
				conn=dlutil.getCon();//获取数据库连接
				ResultSet rs=bookdao.list(conn, book);
				
				//用集合进行遍历
				while(rs.next()) {
					Vector v=new Vector();
					v.add(rs.getString("novelname"));
					v.add(rs.getString("novelmain"));
					v.add(rs.getString("novelwriter"));
					v.add(rs.getString("novelmoney"));
					v.add(rs.getString("classifyname"));
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
