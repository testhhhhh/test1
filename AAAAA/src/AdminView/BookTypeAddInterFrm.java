package AdminView;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Adminmodel.BookType;
import Dao.BookTypeDao;
import util.DLUtil;
import util.StringUtil;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class BookTypeAddInterFrm extends JFrame {
	private JTextField booktypeaddtextField;
private DLUtil dlutil=new DLUtil();
private BookTypeDao booktypedao=new BookTypeDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddInterFrm frame = new BookTypeAddInterFrm();
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
	public BookTypeAddInterFrm() {
		setResizable(true);
//		setIconifiable(true);
//	setClosable(true);
		setTitle("\u5C0F\u8BF4\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 520, 371);
		
		JLabel lblNewLabel = new JLabel("\u5C0F\u8BF4\u7C7B\u522B\u540D\u79F0\uFF1A");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(65, 80, 227, 46);
		lblNewLabel.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/\u56FE\u4E66(4).png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 25));
		
		booktypeaddtextField = new JTextField();
		booktypeaddtextField.setBounds(101, 154, 316, 44);
		booktypeaddtextField.setColumns(10);
		
		JButton booktypeaddButton = new JButton("\u6DFB\u52A0");
		booktypeaddButton.setBackground(new Color(255, 255, 204));
		booktypeaddButton.setBounds(65, 240, 125, 44);
		booktypeaddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				bookTypeadd(ae);
			}
		});
		booktypeaddButton.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/\u56FE\u4E66\u5F55\u5165(3).png")));
		booktypeaddButton.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		
		JButton ResetButton = new JButton("\u91CD\u7F6E");
		ResetButton.setBackground(new Color(255, 255, 204));
		ResetButton.setForeground(Color.BLACK);
		ResetButton.setBounds(326, 239, 116, 44);
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reSetValue(e);
			}
		});
		ResetButton.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		ResetButton.setFont(new Font("微软雅黑", Font.PLAIN, 23));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/png/16.jpg")));
		lblNewLabel_1.setBounds(0, 0, 508, 334);
		getContentPane().setLayout(null);
		getContentPane().add(booktypeaddButton);
		getContentPane().add(ResetButton);
		getContentPane().add(booktypeaddtextField);
		getContentPane().add(lblNewLabel);
		getContentPane().add(lblNewLabel_1);

	}
	
 //小说类别添加事件处理
	private void bookTypeadd(ActionEvent evt) {
		// TODO Auto-generated method stub
		String booktypename=this.booktypeaddtextField.getText();//获取字段
		if(StringUtil.isEmpty(booktypename)) {
			JOptionPane.showMessageDialog(null,"小说类别名称不能为空");
			return;
		}
		BookType bookType=new BookType(booktypename);
		Connection conn=null;
		try {
			conn=dlutil.getCon();
			int n=booktypedao.addBookType(conn, bookType);
			if(n==1) {
				JOptionPane.showMessageDialog(null,"图书类别添加成功");
				reSetValue(evt);
			}else {
				JOptionPane.showMessageDialog(null,"图书类别添加失败");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"图书类别添加失败");
		}finally {
			try {
				dlutil.CloseCon(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	//重置功能
	protected void reSetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		booktypeaddtextField.setText("");
		booktypeaddtextField.requestFocus();
	}
}
