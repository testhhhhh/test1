package AdminView;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Adminmodel.Book;
import Adminmodel.Chapter;
import Dao.BookDao;
import Dao.ChapterDao;
import util.DLUtil;
import util.StringUtil;

public class ChapterAddInterFrm extends JFrame {
	private JTextField chaptertxt;
	private JTextArea contenttxt;
    private DLUtil dlutil=new DLUtil();
    private ChapterDao chapterdao=new ChapterDao();
    private BookDao bookdao=new BookDao();
    private JComboBox noveltxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChapterAddInterFrm frame = new ChapterAddInterFrm();
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
	public ChapterAddInterFrm() {
		setTitle("\u7AE0\u8282\u6DFB\u52A0\u754C\u9762");
		setBounds(100, 100, 600, 750);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u9009\u62E9\u5C0F\u8BF4\u540D\u79F0\uFF1A");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon(ChapterAddInterFrm.class.getResource("/images/\u56FE\u4E66(1).png")));
		lblNewLabel.setBounds(22, 53, 212, 45);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7AE0\u8282\u540D\u79F0\uFF1A");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setIcon(new ImageIcon(ChapterAddInterFrm.class.getResource("/images/\u521B\u4F5C(1).png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblNewLabel_1.setBounds(98, 130, 136, 37);
		getContentPane().add(lblNewLabel_1);
		
		chaptertxt = new JTextField();
		chaptertxt.setBounds(251, 134, 232, 37);
		getContentPane().add(chaptertxt);
		chaptertxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6DFB\u52A0\u7AE0\u8282\u5185\u5BB9\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(ChapterAddInterFrm.class.getResource("/images/\u5199\u6587\u7AE0.png")));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblNewLabel_3.setBounds(57, 197, 182, 37);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ChapterAdd(evt);
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton.setIcon(new ImageIcon(ChapterAddInterFrm.class.getResource("/images/\u4FEE\u6539.png")));
		btnNewButton.setBounds(357, 629, 156, 45);
		getContentPane().add(btnNewButton);
		
	    noveltxt = new JComboBox();
	    noveltxt.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		noveltxt.setForeground(Color.BLACK);
		noveltxt.setBounds(248, 58, 232, 37);
		getContentPane().add(noveltxt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 266, 537, 317);
		getContentPane().add(scrollPane);
		
		contenttxt = new JTextArea();
		contenttxt.setBounds(22, 266, 537, 317);
		scrollPane.setViewportView(contenttxt);
		contenttxt.setLineWrap(true);
		//设置文本框的边框条条
		contenttxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ChapterAddInterFrm.class.getResource("/png/15.jpg")));
		lblNewLabel_2.setBounds(0, 0, 588, 721);
		getContentPane().add(lblNewLabel_2);
		
		//填充小说选择项
	   fillBook();
	}

	//添加章节事件处理
	private void ChapterAdd(ActionEvent evt) {
		// TODO Auto-generated method stub
		String chaptername=this.chaptertxt.getText();//章节名字
		String chaptercontent=this.contenttxt.getText();//章节内容
		if(StringUtil.isEmpty(chaptername)) {
			JOptionPane.showMessageDialog(null,"章节名称不能为空");
			return;
		}
		if(StringUtil.isEmpty(chaptercontent)) {
			JOptionPane.showMessageDialog(null,"章节内容不能为空");
			return;
		}
		Book book=(Book) this.noveltxt.getSelectedItem();
		int novelid=book.getNovelid();

	   Chapter chapter=new Chapter(novelid, chaptername,chaptercontent);
	   Connection conn=null;
		try {
			conn=dlutil.getCon();
			int addNum=chapterdao.add(conn, chapter);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, "小说添加成功");
				reSetValue(evt);
			}else {
				JOptionPane.showMessageDialog(null, "小说添加失败");
				return;
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "小说添加失败");
		}finally {
			try {
				dlutil.CloseCon(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}}

	//重置事件处理
	private void reSetValue(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.noveltxt.setSelectedIndex(0);
		this.chaptertxt.setText("");
		this.contenttxt.setText("");
		this.noveltxt.requestFocus();
	}

	//初始化图书类别下拉框
	private void fillBook() {
		Connection conn=null;
		Book book=null;
		try {
			conn=dlutil.getCon();//数据库连接
		ResultSet rs=bookdao.list(conn, new Book());
		//分类表集合遍历
			while(rs.next()) {
				book=new Book();
				book.setNovelid(rs.getInt("novelid"));
				book.setNovelname(rs.getString("novelname"));
				this.noveltxt.addItem(book);//添加项				
			}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		
	}
}
}
