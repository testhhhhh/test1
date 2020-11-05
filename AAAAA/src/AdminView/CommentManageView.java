package AdminView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Adminmodel.Book;
import Adminmodel.Chapter;
import Adminmodel.Comment;
import Dao.BookDao;
import Dao.CommentDao;
import util.DLUtil;
import util.StringUtil;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class CommentManageView extends JFrame {

	private JPanel contentPane;
	private JTable commenttable;
    private DLUtil dlutil=new DLUtil();
    private CommentDao commentdao=new CommentDao();
    private BookDao bookdao=new BookDao();
    private JComboBox<Book> blognamecomboBox;
    private JTextField commentidtextField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CommentManageView frame = new CommentManageView();
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
	public CommentManageView() {
//		setClosable(true);
//		setIconifiable(true);
		setTitle("\u8BC4\u8BBA\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 769, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel searchblognamelabel = new JLabel("\u67E5\u627E\u535A\u5BA2\u540D\u79F0\uFF1A");
		searchblognamelabel.setForeground(Color.BLACK);
		searchblognamelabel.setIcon(new ImageIcon(CommentManageView.class.getResource("/images/\u56FE\u4E66(4).png")));
		searchblognamelabel.setBounds(71, 52, 224, 33);
		searchblognamelabel.setFont(new Font("微软雅黑", Font.BOLD, 25));
		
		JButton searchblognamebutton = new JButton("\u67E5\u8BE2");
		searchblognamebutton.setIcon(new ImageIcon(CommentManageView.class.getResource("/images/\u67E5\u8BE2(3).png")));
		searchblognamebutton.setBounds(567, 46, 123, 41);
		searchblognamebutton.setFont(new Font("微软雅黑", Font.BOLD, 23));
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(36, 109, 692, 346);
		
		commenttable = new JTable();
		commenttable.setModel(new DefaultTableModel(
			new Object[][] {},new String[] {"\u8BC4\u8BBAID", "\u5C0F\u8BF4ID", "\u5C0F\u8BF4\u540D\u79F0", "\u7528\u6237ID", "\u8BC4\u8BBA\u5185\u5BB9"}) {
			/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		commenttable.getColumnModel().getColumn(0).setPreferredWidth(61);
		commenttable.getColumnModel().getColumn(1).setPreferredWidth(65);
		commenttable.getColumnModel().getColumn(2).setPreferredWidth(80);
		commenttable.getColumnModel().getColumn(3).setPreferredWidth(64);
		commenttable.getColumnModel().getColumn(4).setPreferredWidth(161);
		scrollPane.setViewportView(commenttable);
		contentPane.setLayout(null);
		contentPane.add(searchblognamelabel);
		contentPane.add(searchblognamebutton);
		contentPane.add(scrollPane);
		
		blognamecomboBox = new JComboBox<Book>();
		blognamecomboBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		blognamecomboBox.setBounds(292, 52, 241, 33);
		contentPane.add(blognamecomboBox);
		
		JButton deletecommentbutton = new JButton("\u5220\u9664");
		deletecommentbutton.setIcon(new ImageIcon(CommentManageView.class.getResource("/images/\u5220\u9664(1).png")));
		deletecommentbutton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		deletecommentbutton.setBounds(314, 497, 130, 41);
		contentPane.add(deletecommentbutton);
		
		commentidtextField = new JTextField();
		commentidtextField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		commentidtextField.setEditable(false);
		commentidtextField.setBounds(147, 498, 97, 40);
		contentPane.add(commentidtextField);
		commentidtextField.setColumns(10);
		
		JLabel commentidlabel = new JLabel("\u8BC4\u8BBA\u7F16\u53F7\uFF1A");
		commentidlabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		commentidlabel.setBounds(46, 502, 97, 32);
		contentPane.add(commentidlabel);
		
		JLabel picturelabel = new JLabel("");
		picturelabel.setIcon(new ImageIcon(CommentManageView.class.getResource("/png/4.jpg")));
		picturelabel.setBounds(0, 0, 755, 596);
		contentPane.add(picturelabel);
	
		
		//填充小说名称项
		this.fillnovelType("search");
		this.fillnovelType("modify");
		
		searchblognamebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent es) {
				CommentSeclect(es);
			}
		});
		
		deletecommentbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ec) {
				CommentDelete(ec);
			}
		});
		
		commenttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ek) {
					Tableclick(ek);
			}
		});
		//表格填充数据
		this.filltable(new Comment());
	}
	
	
	    //鼠标点击事件
    private void Tableclick(MouseEvent ek) {
		// TODO Auto-generated method stub
	int row=this.commenttable.getSelectedRow();//获取行数
	//获取列的数据
	this.commentidtextField.setText((String) commenttable.getValueAt(row, 0));//编号
	}


    //删除评论信息
	private void CommentDelete(ActionEvent ec) {
		// TODO Auto-generated method stub
		String id=this.commentidtextField.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;	
		}
		int n=JOptionPane.showConfirmDialog(null,"确定要删除这条记录吗");
		if(n==0) {
			Connection conn=null;
			try {
				conn=dlutil.getCon();
				int deleteNum=commentdao.delete(conn, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功");	
					this.commentidtextField.setText("");
					this.filltable(new Comment());//更新表格数据
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

	
	//评论查询事件
	private void CommentSeclect(ActionEvent es) {
		// TODO Auto-generated method stub
	    //获取下拉框的选择对象
		Book book=(Book) this.blognamecomboBox.getSelectedItem();
		int novelid=book.getNovelid();
		Comment comment =new Comment(novelid);//封装数据
		this.filltable(comment);
		this.blognamecomboBox.setSelectedIndex(0);
	}

	
	//表格填充
	private void filltable(Comment comment) {
		DefaultTableModel dtm=(DefaultTableModel) commenttable.getModel();//获得model，进行初始化
		dtm.setRowCount(0);//设置成0行，清空表格
		Connection conn=null;
		try {
			conn=dlutil.getCon();//获取数据库连接
			ResultSet rs=commentdao.list(conn, comment);
			
			//用集合进行遍历
			while(rs.next()) {
				Vector<String> v=new Vector<String>();
				v.add(rs.getString("commentid"));
				v.add(rs.getString("novelid"));
				v.add(rs.getString("novelname"));
				v.add(rs.getString("userid"));
				v.add(rs.getString("comments"));
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
	
	
	//初始化下拉框小说名称
			//下拉框类型
			private void fillnovelType(String type) {
				Connection conn=null;
				Book book=null;
				try {
					conn=dlutil.getCon();
					ResultSet rs=bookdao.list(conn,new Book());
					if("search".equals(type)) {
						book=new Book();
						book.setNovelname("请选择.....");
						book.setNovelid(-1);
						this.blognamecomboBox.addItem(book);
					}
					//把小说类型数据导入到下拉框
					while(rs.next()) {
						book=new Book();
						book.setNovelname(rs.getString("novelname"));
						book.setNovelid(rs.getInt("novelid"));
						if("search".equals(type)) {
							this.blognamecomboBox.addItem(book);
						}else if("modify".equals(type)){
//							this.commentcomboBox.addItem(book);//这里出错过，因为我定义的下拉框没存入数据
						}
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
	}

