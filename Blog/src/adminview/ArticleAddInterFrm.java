package adminview;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import daoimplement.ArticleImplement;
import entity.Ariticle;
import inputcheck.InputOrNot;


public class ArticleAddInterFrm extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField titletext;
	private JTextField writertext;
	private JLabel contentlabel;
	private JTextArea contenttextArea;
	private JButton addbutton;
	private JButton resourebutton;
	private JLabel pictureuplabel;
	private JScrollPane scrollPane;
	private static JTextField picturetext;
	private ImageIcon img;
	private static JLabel pictureviewlabel;
	private JButton pictureupbutton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArticleAddInterFrm frame = new ArticleAddInterFrm();
			
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
	public ArticleAddInterFrm() {
//		setTitle("\u5C0F\u8BF4\u6DFB\u52A0\u754C\u9762");
//		setIconifiable(true);
		setTitle("\u5C0F\u8BF4\u6DFB\u52A0\u754C\u9762");
//		setFrameIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/\u5199\u4F5C.png")));
//		int x = Toolkit.getDefaultToolkit().getScreenSize().width;
//		int y = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds(100, 100, 854, 780);
		getContentPane().setLayout(null);	
		
		
		JLabel titlelabel = new JLabel("\u535A\u6587\u6807\u9898\uFF1A");
		titlelabel.setForeground(SystemColor.text);
		titlelabel.setBounds(104, 19, 168, 48);
		titlelabel.setIcon(new ImageIcon(ArticleAddInterFrm.class.getResource("/images/\u56FE\u4E66(1).png")));
		titlelabel.setFont(new Font("微软雅黑", Font.BOLD, 23));
		
		titletext = new JTextField();
		titletext.setBounds(290, 32, 221, 36);
		titletext.setColumns(10);
		
		JLabel writerlabel = new JLabel("\u4F5C\u8005\uFF1A");
		writerlabel.setForeground(SystemColor.text);
		writerlabel.setBounds(120, 91, 152, 32);
		writerlabel.setIcon(new ImageIcon(ArticleAddInterFrm.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC,\u7B11\u8138.png")));
		writerlabel.setFont(new Font("微软雅黑", Font.BOLD, 23));
		
		writertext = new JTextField();
		writertext.setBounds(290, 96, 221, 36);
		writertext.setColumns(10);
		
		contentlabel = new JLabel("\u535A\u6587\u5185\u5BB9\uFF1A");
		contentlabel.setForeground(SystemColor.text);
		contentlabel.setBounds(104, 250, 152, 32);
		contentlabel.setIcon(new ImageIcon(ArticleAddInterFrm.class.getResource("/images/\u521B\u4F5C(1).png")));
		contentlabel.setFont(new Font("微软雅黑", Font.BOLD, 23));
		
		addbutton = new JButton("\u6DFB\u52A0");
		addbutton.setBackground(new Color(153, 204, 255));
		addbutton.setBounds(194, 669, 141, 41);
		addbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ea) {
				bookAdd(ea);
			}
		});
		addbutton.setIcon(new ImageIcon(ArticleAddInterFrm.class.getResource("/images/\u56FE\u4E66\u5F55\u5165(1).png")));
		addbutton.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		
		resourebutton = new JButton("\u91CD\u7F6E");
		resourebutton.setBackground(new Color(153, 204, 255));
		resourebutton.setBounds(467, 669, 133, 41);
		resourebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				reSetValue(evt);
			}
		});
		resourebutton.setIcon(new ImageIcon(ArticleAddInterFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		resourebutton.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		getContentPane().setLayout(null);
		getContentPane().add(titlelabel);
		getContentPane().add(titletext);
		getContentPane().add(writerlabel);
		getContentPane().add(writertext);
		getContentPane().add(contentlabel);
		getContentPane().add(addbutton);
		getContentPane().add(resourebutton);
		
		pictureuplabel = new JLabel("\u56FE\u7247\u4E0A\u4F20\uFF1A");
		pictureuplabel.setForeground(SystemColor.text);
		pictureuplabel.setIcon(new ImageIcon(ArticleAddInterFrm.class.getResource("/images/\u4E0A\u4F20.png")));
		pictureuplabel.setFont(new Font("微软雅黑", Font.BOLD, 23));
		pictureuplabel.setBounds(120, 164, 158, 36);
		getContentPane().add(pictureuplabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 292, 654, 345);
		getContentPane().add(scrollPane);
		
		contenttextArea = new JTextArea();
		contenttextArea.setLineWrap(true);
		scrollPane.setViewportView(contenttextArea);
		
		//设置文本框的边框条条
		contenttextArea.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		
		picturetext = new JTextField();
		picturetext.setBounds(574, 77, 221, 21);
		getContentPane().add(picturetext);
		picturetext.setColumns(10);
		
		JLabel picturelooklabel = new JLabel("\u56FE\u7247\u6548\u679C\u9884\u89C8\uFF1A");
		picturelooklabel.setForeground(SystemColor.text);
		picturelooklabel.setIcon(new ImageIcon(ArticleAddInterFrm.class.getResource("/images/\u82B1.png")));
		picturelooklabel.setFont(new Font("微软雅黑", Font.BOLD, 23));
		picturelooklabel.setBounds(574, 32, 208, 35);
		getContentPane().add(picturelooklabel);
		
		pictureviewlabel = new JLabel("");
		pictureviewlabel.setBounds(529, 108, 287, 170);
		getContentPane().add(pictureviewlabel);
		
	    pictureupbutton = new JButton("\u70B9\u51FB\u4E0A\u4F20");
		pictureupbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ArticleImplement().addPicture(pictureupbutton,pictureviewlabel,picturetext);	
			}
		});
		pictureupbutton.setFont(new Font("微软雅黑", Font.BOLD, 18));
		pictureupbutton.setBounds(290, 167, 184, 36);
		getContentPane().add(pictureupbutton);
		
		JLabel picturelabel = new JLabel("");
		picturelabel.setIcon(new ImageIcon(ArticleAddInterFrm.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710224105.png")));
		picturelabel.setBounds(0, 0, 854, 780);
		getContentPane().add(picturelabel);

	}

	//重置事件处理
	private void reSetValue(ActionEvent evt) {
		// TODO Auto-generated method stub
		titletext.setText("");
		writertext.setText("");
		contenttextArea.setText("");
		titletext.requestFocus();
		this.picturetext.setText("");
		this.pictureviewlabel.setIcon(new ImageIcon());
	}

	//添加功能
	private void bookAdd(ActionEvent ea) {
		// TODO Auto-generated method stub
		String title=this.titletext.getText();
		String content=this.contenttextArea.getText();
		String writer=this.writertext.getText();
		String picture=this.picturetext.getText();
		
		if(InputOrNot.isEmpty(title)) {
			JOptionPane.showMessageDialog(null,"博文标题不能为空");
			return;
		}
		if(InputOrNot.isEmpty(writer)) {
			JOptionPane.showMessageDialog(null,"作者不能为空");
			return;
		}
		if(InputOrNot.isEmpty(content)) {
			JOptionPane.showMessageDialog(null,"博文内容不能为空");
			return;
		}
		
		Ariticle article=new Ariticle(0, title, content,  writer,picture);
		
		Connection conn=null;
		try {
			conn=jdbc.DLUtil.getCon();
			int addNum=new ArticleImplement().add(conn, article);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, "博文添加成功");
				reSetValue(ea);
			}else {
				JOptionPane.showMessageDialog(null, "博文添加失败");
				return;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				jdbc.DLUtil.CloseCon(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}