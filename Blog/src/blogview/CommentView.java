package blogview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import daoimplement.ArticleImplement;
import daoimplement.CommentImplement;
import daoimplement.UserDaoImplement;
import entity.Comment;
import inputcheck.CommentTextKeyListener;
import jdbc.DLUtil;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class CommentView extends JFrame {

	private JPanel contentPane;
	private JTextField commenttext;

	/**
	 * Launch the application.
	 */
	public static void CommentViewInit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CommentView frame = new CommentView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public CommentView() throws Exception {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 993, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 969, 568);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel commentlabel = new JLabel("\u53D1\u8868\u8BC4\u8BBA\uFF1A");
		commentlabel.setForeground(new Color(255, 255, 0));
		commentlabel.setBounds(62, 503, 120, 26);
		panel.add(commentlabel);
		commentlabel.setFont(new Font("方正舒体", Font.PLAIN, 24));
		
		commenttext = new JTextField();
		commenttext.setBounds(192, 504, 527, 35);
		panel.add(commenttext);
		commenttext.setColumns(10);
		
		JLabel commentwarnlabel = new JLabel("");
		commentwarnlabel.setForeground(Color.RED);
		commentwarnlabel.setBounds(192, 479, 532, 26);
		panel.add(commentwarnlabel);
		
		JButton okbutton = new JButton("\u786E\u8BA4");
		okbutton.setBackground(UIManager.getColor("Button.background"));
		okbutton.setBounds(783, 492, 132, 44);
		panel.add(okbutton);
		okbutton.setFont(new Font("方正舒体", Font.PLAIN, 25));
		
		JScrollPane sp = new JScrollPane();
		sp.setBounds(48, 24, 671, 456);
		panel.add(sp);
		
		UserDaoImplement udi=new UserDaoImplement();
		ArticleImplement adi=new ArticleImplement();
		CommentImplement cdi=new CommentImplement();
	
		Connection conn = null;
	    conn = DLUtil.getCon();// 获取数据库连接
		JList list = new JList();
		cdi.commentlist(conn,adi.title, udi.userid, cdi.d);
		adi.articleinteractive(conn,adi.title);
		list.setFont(new Font("华文宋体", Font.PLAIN, 21));
		list.setModel(cdi.d);
		list.setForeground(new Color(0, 0, 0));
		list.setBackground(new Color(230, 230, 250));
		sp.setViewportView(list);
		
		CommentTextKeyListener utkl = new CommentTextKeyListener(commentwarnlabel, commenttext);
		commenttext.addKeyListener(utkl);
		
	
		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		Comment comment=new Comment(udi.userid, adi.article.getArticleid(), commenttext.getText());
				Connection conn = null;
			    conn = DLUtil.getCon();// 获取数据库连接
				if(!"".equals(commenttext.getText())&&"".equals(commentwarnlabel.getText())){
				try {
					if(cdi.add(conn,comment)!=0) {
						commenttext.setText("");
						JOptionPane.showMessageDialog(null, "评论成功", "提示", JOptionPane.PLAIN_MESSAGE);
						
					}
				} catch (HeadlessException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
			}
			else {
					JOptionPane.showMessageDialog(null, "评论失败", "提示", JOptionPane.PLAIN_MESSAGE);
				}	
			}
		});
		
		JButton reflashbutton = new JButton("\u5237\u65B0");
		reflashbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommentView.CommentViewInit();
				
			}
		});
		reflashbutton.setFont(new Font("方正舒体", Font.PLAIN, 25));
		reflashbutton.setBounds(783, 408, 132, 44);
		panel.add(reflashbutton);
		
		
		
		JLabel commentbgpiclabel = new JLabel("");
		commentbgpiclabel.setIcon(new ImageIcon(CommentView.class.getResource("/png/983481d8770e04c8dcf89eada784630.png")));
		commentbgpiclabel.setBounds(0, 0, 979, 558);
		panel.add(commentbgpiclabel);
	}
}
