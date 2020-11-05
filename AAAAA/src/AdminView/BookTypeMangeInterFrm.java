package AdminView;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Adminmodel.BookType;
import Dao.BookDao;
import Dao.BookTypeDao;
import util.DLUtil;
import util.StringUtil;

public class BookTypeMangeInterFrm extends JFrame {
	private JTable bookTypetable;
	private DLUtil dlutil=new DLUtil();
	private BookTypeDao booktypedao=new BookTypeDao();
	private JTextField s_bookTypeNameTxt;
	private JTextField classifyidtextField;
	private JTextField bookTypenametxt;
	private BookDao bookdao=new BookDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeMangeInterFrm frame = new BookTypeMangeInterFrm();
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
	public BookTypeMangeInterFrm() {
		setTitle("\u5C0F\u8BF4\u7C7B\u578B\u7EF4\u62A4");
//		setClosable(true);
//		setIconifiable(true);
//		setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		setBounds(100, 100, 931, 700);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(249, 141, 493, 199);
		
		JLabel lblNewLabel = new JLabel("\u5C0F\u8BF4\u7C7B\u522B\u540D\u79F0\uFF1A");
		lblNewLabel.setBounds(180, 58, 199, 45);
		lblNewLabel.setIcon(new ImageIcon(BookTypeMangeInterFrm.class.getResource("/images/\u56FE\u4E66(4).png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 23));
		
		s_bookTypeNameTxt = new JTextField();
		s_bookTypeNameTxt.setBounds(397, 62, 293, 42);
		s_bookTypeNameTxt.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		s_bookTypeNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setBounds(708, 61, 129, 41);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeSearch(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookTypeMangeInterFrm.class.getResource("/images/\u67E5\u8BE2(3).png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 205));
		panel.setBounds(93, 358, 768, 256);
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(BookTypeMangeInterFrm.class.getResource("/images/\u7F16\u53F7.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		classifyidtextField = new JTextField();
		classifyidtextField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		classifyidtextField.setEditable(false);
		classifyidtextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(BookTypeMangeInterFrm.class.getResource("/images/\u56FE\u4E66(3).png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		bookTypenametxt = new JTextField();
		bookTypenametxt.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		bookTypenametxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.setBackground(new Color(204, 255, 153));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeUpdate(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookTypeMangeInterFrm.class.getResource("/images/\u4FEE\u6539.png")));
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.setBackground(new Color(204, 255, 153));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypedelete(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(BookTypeMangeInterFrm.class.getResource("/images/\u5220\u9664(3).png")));
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(115)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(16)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(classifyidtextField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(bookTypenametxt, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(249, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(classifyidtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookTypenametxt, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(21))
		);
		panel.setLayout(gl_panel);
		
		bookTypetable = new JTable();
		bookTypetable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTypeTableMousePressed(e);
			}
		});
		bookTypetable.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		bookTypetable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5206\u7C7B\u540D\u79F0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(bookTypetable);
		getContentPane().setLayout(null);
		getContentPane().add(lblNewLabel);
		getContentPane().add(s_bookTypeNameTxt);
		getContentPane().add(btnNewButton);
		getContentPane().add(panel);
		getContentPane().add(scrollPane);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(BookTypeMangeInterFrm.class.getResource("/png/12.jpg")));
		lblNewLabel_3.setBounds(-10, 0, 948, 671);
		getContentPane().add(lblNewLabel_3);

		//添加数据调用
		this.fillTable(new BookType());
	}
	
	//小说类别删除功能
	private void bookTypedelete(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id=classifyidtextField.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;	
		}
		int n=JOptionPane.showConfirmDialog(null,"确定要删除这条记录吗");
		if(n==0) {
			Connection conn=null;
			
			try {
				conn=dlutil.getCon();
				//判断小说类型下是否有小说
			boolean flag=bookdao.existBookByBookTypeId(conn, id);
			if(flag) {
				JOptionPane.showMessageDialog(null, "当前类别下有图书，不能删除此类别");
				return;
			}
				int deleteNum=booktypedao.delete(conn, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功");	
					this.reSetValue();//重置数据
					this.fillTable(new BookType());//重置表格
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

	//修改小说类别功能
	private void bookTypeUpdate(ActionEvent evtl) {
		// TODO Auto-generated method stub
		String id=classifyidtextField.getText();
		String booktypename=bookTypenametxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(booktypename)) {
			JOptionPane.showMessageDialog(null, "小说类别名称不能为空");
			return;
		}
	
		BookType booktype=new BookType(Integer.parseInt(id),booktypename);
			Connection conn=null;
	
		try {
			conn=dlutil.getCon();//获取连接	
			int modifyNum=booktypedao.update(conn, booktype);
			if(modifyNum==1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.reSetValue();//重置数据
				this.fillTable(new BookType());//刷新表格数据
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

	
	//表格行点击事件处理
	private void bookTypeTableMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	int row= bookTypetable.getSelectedRow();//返回行号
		classifyidtextField.setText((String)bookTypetable.getValueAt(row, 0));
		bookTypenametxt.setText((String)bookTypetable.getValueAt(row, 1));
		
	}

	//小说类别搜索功能
	private void bookTypeSearch(ActionEvent evt) {
		// TODO Auto-generated method stub
		String s_booktypeName=this.s_bookTypeNameTxt.getText();
		BookType bookType=new BookType();
		bookType.setClassifyname(s_booktypeName);//小说名称设置进去
		this.fillTable(bookType);
	}

	//初始化表格
	private void fillTable(BookType bookType) {
		DefaultTableModel dtm=(DefaultTableModel) bookTypetable.getModel();//获得model，进行初始化
		dtm.setRowCount(0);//设置成0行，清空表格
		Connection conn=null;
		try {
			conn=dlutil.getCon();//获取数据库连接
			ResultSet rs=booktypedao.list(conn, bookType);
			
			//用集合进行遍历
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("classifyid"));
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
	
	//重置表单
	private void reSetValue() {
		classifyidtextField.setText("");
		bookTypenametxt.setText("");
		bookTypenametxt.requestFocus();
	}
}
