package AdminView;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Adminmodel.Book;
import Adminmodel.Chapter;
import Dao.BookDao;
import Dao.ChapterDao;
import util.DLUtil;
import util.StringUtil;

public class ChapterMangeInterFrm extends JFrame {
	private JTable chaptertable;
	private JTextField s_chapternametxt;
	private DLUtil dlutil=new DLUtil();
	private ChapterDao chapterdao=new ChapterDao();
	private BookDao bookdao=new BookDao();
    private JComboBox s_novelnamecomboBox;
    private JTextField chapternametxt;
    private JComboBox novelnamejcb;
    private JTextField idtextField;
    private JTextArea chaptercontenttextArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChapterMangeInterFrm frame = new ChapterMangeInterFrm();
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
	public ChapterMangeInterFrm() {
		getContentPane().setBackground(new Color(0, 204, 255));
		setTitle("\u7AE0\u8282\u7BA1\u7406\u7EF4\u62A4");
		setBounds(100, 100, 974, 767);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6846", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 204, 255));
		panel_1.setBorder(new TitledBorder(null, "\u64CD\u4F5C\u6846", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(21))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 881, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(46, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 849, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\u5C0F\u8BF4\u540D\u79F0\uFF1A");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setIcon(new ImageIcon(ChapterMangeInterFrm.class.getResource("/images/\u56FE\u4E66(3).png")));
		lblNewLabel_2.setFont(new Font("΢���ź�", Font.BOLD, 18));
		lblNewLabel_2.setBounds(296, 30, 134, 41);
		panel_1.add(lblNewLabel_2);
		
		novelnamejcb = new JComboBox();
		novelnamejcb.setBounds(440, 36, 110, 34);
		panel_1.add(novelnamejcb);
		
		JLabel lblNewLabel_3 = new JLabel("\u7AE0\u8282\u540D\u79F0\uFF1A");
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setIcon(new ImageIcon(ChapterMangeInterFrm.class.getResource("/images/\u521B\u4F5C(1).png")));
		lblNewLabel_3.setFont(new Font("΢���ź�", Font.BOLD, 18));
		lblNewLabel_3.setBounds(584, 33, 128, 41);
		panel_1.add(lblNewLabel_3);
		
		chapternametxt = new JTextField();
		chapternametxt.setBounds(718, 37, 147, 34);
		panel_1.add(chapternametxt);
		chapternametxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u7AE0\u8282\u5185\u5BB9\uFF1A");
		lblNewLabel_4.setForeground(SystemColor.text);
		lblNewLabel_4.setIcon(new ImageIcon(ChapterMangeInterFrm.class.getResource("/images/\u5199\u6587\u7AE0.png")));
		lblNewLabel_4.setFont(new Font("΢���ź�", Font.BOLD, 18));
		lblNewLabel_4.setBounds(37, 91, 134, 34);
		panel_1.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ee) {
				ChapterUpdate(ee);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ChapterMangeInterFrm.class.getResource("/images/\u4FEE\u6539.png")));
		btnNewButton_1.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		btnNewButton_1.setBounds(757, 155, 121, 41);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eee) {
				ChapterDelete(eee);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(ChapterMangeInterFrm.class.getResource("/images/\u5220\u9664(3).png")));
		btnNewButton_2.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		btnNewButton_2.setBounds(757, 258, 121, 41);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_5 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_5.setForeground(SystemColor.text);
		lblNewLabel_5.setIcon(new ImageIcon(ChapterMangeInterFrm.class.getResource("/images/\u7F16\u53F7.png")));
		lblNewLabel_5.setFont(new Font("΢���ź�", Font.BOLD, 18));
		lblNewLabel_5.setBounds(37, 30, 91, 41);
		panel_1.add(lblNewLabel_5);
		
		idtextField = new JTextField();
		idtextField.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		idtextField.setEditable(false);
		idtextField.setBounds(152, 34, 97, 34);
		panel_1.add(idtextField);
		idtextField.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(36, 132, 696, 216);
		panel_1.add(scrollPane_1);
		
	    chaptercontenttextArea = new JTextArea();
		chaptercontenttextArea.setLineWrap(true);
		scrollPane_1.setViewportView(chaptercontenttextArea);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(ChapterMangeInterFrm.class.getResource("/png/26.jpg")));
		lblNewLabel_6.setBounds(10, 20, 894, 346);
		panel_1.add(lblNewLabel_6);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5C0F\u8BF4\u540D\u79F0\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(ChapterMangeInterFrm.class.getResource("/images/\u56FE\u4E66(3).png")));
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 30, 142, 28);
		panel.add(lblNewLabel);
		
		s_novelnamecomboBox = new JComboBox();
		s_novelnamecomboBox.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		s_novelnamecomboBox.setBounds(149, 30, 160, 30);
		panel.add(s_novelnamecomboBox);
		
		JLabel lblNewLabel_1 = new JLabel("\u7AE0\u8282\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		lblNewLabel_1.setIcon(new ImageIcon(ChapterMangeInterFrm.class.getResource("/images/\u4EA4\u6613\u8BB0\u5F55.png")));
		lblNewLabel_1.setBounds(358, 31, 128, 26);
		panel.add(lblNewLabel_1);
		
		s_chapternametxt = new JTextField();
		s_chapternametxt.setBounds(496, 32, 160, 32);
		panel.add(s_chapternametxt);
		s_chapternametxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ChapterAdd(evt);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ChapterMangeInterFrm.class.getResource("/images/\u67E5\u8BE2(3).png")));
		btnNewButton.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		btnNewButton.setBounds(710, 23, 128, 41);
		panel.add(btnNewButton);
		
		chaptertable = new JTable();
		chaptertable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent ea) {
				TableClickAction(ea);
			}
		});
		chaptertable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5C0F\u8BF4\u540D\u79F0", "\u5C0F\u8BF4\u4F5C\u8005", "\u7AE0\u8282\u540D\u79F0", "\u7AE0\u8282\u5185\u5BB9"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		chaptertable.getColumnModel().getColumn(4).setPreferredWidth(215);
		scrollPane.setViewportView(chaptertable);
		getContentPane().setLayout(groupLayout);

		//���С˵������
		this.fillnovelType("search");
		this.fillnovelType("modify");
		
		//�������������
//		this.fillnovel("search");
//		this.fillnovel("modify");
		
		//���������
		this.filltable(new Chapter());
	}
	
	
	//ɾ���½�
	private void ChapterDelete(ActionEvent eee) {
			String id=this.idtextField.getText();
			if(StringUtil.isEmpty(id)) {
				JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���ļ�¼");
				return;	
			}
			int n=JOptionPane.showConfirmDialog(null,"ȷ��Ҫɾ��������¼��");
			if(n==0) {
				Connection conn=null;
				try {
					conn=dlutil.getCon();
					int deleteNum=chapterdao.delete(conn, id);
					if(deleteNum==1) {
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");	
						reSetValue(eee);//��������
						this.filltable(new Chapter());//���±������
					}else {
						JOptionPane.showMessageDialog(null, "ɾ��ʧ��");		
					}
				}catch(Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��");	
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



	//�޸��½�
	private void ChapterUpdate(ActionEvent ee) {
		// TODO Auto-generated method stub
		String id=this.idtextField.getText();//id
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼");
			return;	
		}
		String chaptername=this.chapternametxt.getText();//�½�����
		String chaptercontent=this.chaptercontenttextArea.getText();//�½�����
		if(StringUtil.isEmpty(chaptername)) {
			JOptionPane.showMessageDialog(null,"�½����Ʋ���Ϊ��");
			return;
		}
		if(StringUtil.isEmpty(chaptercontent)) {
			JOptionPane.showMessageDialog(null,"�½����ݲ���Ϊ��");
			return;
		}	
		//��ȡС˵��id
		Book book=(Book)this.novelnamejcb.getSelectedItem();	
		int novelid=book.getNovelid();
		
		Chapter chapter=new Chapter(Integer.parseInt(id), novelid,chaptername, chaptercontent);
		Connection conn=null;
		try {
			conn=dlutil.getCon();
			int addNum=chapterdao.update(conn, chapter);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, "�½��޸ĳɹ�");
				reSetValue(ee);
				this.filltable(new Chapter());//���±������
			}else {
				JOptionPane.showMessageDialog(null, "�½��޸�ʧ��");
				return;
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

	
	//����
	private void reSetValue(ActionEvent ee) {
		// TODO Auto-generated method stub
		this.novelnamejcb.setSelectedIndex(0);
		this.chaptercontenttextArea.setText("");
		this.chaptercontenttextArea.setText("");
	}

	//���������¼�
	private void TableClickAction(MouseEvent ea) {
		// TODO Auto-generated method stub
		int row=this.chaptertable.getSelectedRow();//��ȡ����
		//��ȡ�е�����
		
		this.idtextField.setText((String) chaptertable.getValueAt(row, 0));//���
		String name=(String)this.chaptertable.getValueAt(row, 1);//С˵����
		this.chapternametxt.setText((String) chaptertable.getValueAt(row, 3));//�½�����
		this.chaptercontenttextArea.setText((String) chaptertable.getValueAt(row, 4));//�½�����
		int n=this.novelnamejcb.getItemCount();//�������ж�����
		//����������
		for(int i=0;i<n;i++) {
			Book item=(Book) this.novelnamejcb.getItemAt(i);//����
			if(item.getNovelname().equals(name)) {
				this.novelnamejcb.setSelectedIndex(i);
			}
		}
	}

	//�½ڲ�ѯ��
	private void ChapterAdd(ActionEvent evt) {
		// TODO Auto-generated method stub
		Book book=(Book) this.s_novelnamecomboBox.getSelectedItem();//��ȡ�������ѡ�����
		String chaptername=this.s_chapternametxt.getText();//��ȡ�½�����
	int novelid=book.getNovelid();
	Chapter chapter =new Chapter(novelid, chaptername);//��װ����
	this.filltable(chapter);
	this.s_chapternametxt.setText("");
	this.s_novelnamecomboBox.setSelectedIndex(0);
	
	}

	
	//��ʼ���������
	private void filltable(Chapter chapter) {
		DefaultTableModel dtm=(DefaultTableModel) chaptertable.getModel();//���model�����г�ʼ��
		dtm.setRowCount(0);//���ó�0�У���ձ��
		Connection conn=null;
		try {
			conn=dlutil.getCon();//��ȡ���ݿ�����
			ResultSet rs=chapterdao.list(conn, chapter);
			
			//�ü��Ͻ��б���
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("chapterid"));
				v.add(rs.getString("novelname"));
				v.add(rs.getString("novelwriter"));
				v.add(rs.getString("chaptername"));
				v.add(rs.getString("chaptercontent"));
				dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dlutil.CloseCon(conn);//�ر����ݿ�����
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	//�޷�ʵ�ֵ�ԭ������д����ֻ�ܷ���һ��ֵ	
//	//���߲�ѯ������
//	private void fillnovel(String type) {
//		Connection conn=null;
//		Book book=null;
//		try {
//			conn=dlutil.getCon();
//			ResultSet rs=bookdao.list(conn, book);
//			if("search".equals(type)) {
//				book=new Book();
//				book.setNovelwriter("��ѡ��.....");
//				book.setNovelid(-1);
//				this.s_novelwriter.addItem(book);
//			}
//			//���������ݵ��뵽������
//			while(rs.next()) {
//				book=new Book();
//	            book.setNovelwriter(rs.getString("novelwriter"));
//				book.setNovelid(rs.getInt("novelid"));
//				if("search".equals(type)) {	
//			this.s_novelwriter.addItem(book);//��������ע��,��add����set
//				}else if("modify".equals(type)){
//					this.s_novelwriter.addItem(book);
//				}
//			}
//	}catch(Exception e) {
//		e.printStackTrace();
//	}finally {
//		try {
//			dlutil.CloseCon(conn);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	}
//	
	
		//��ʼ��������С˵����
		//����������
		private void fillnovelType(String type) {
			Connection conn=null;
			Book book=null;
			try {
				conn=dlutil.getCon();
				ResultSet rs=bookdao.list(conn,new Book());
				if("search".equals(type)) {
					book=new Book();
					book.setNovelname("��ѡ��.....");
					book.setNovelid(-1);
					this.s_novelnamecomboBox.addItem(book);
				}
				//��С˵�������ݵ��뵽������
				while(rs.next()) {
					book=new Book();
					book.setNovelname(rs.getString("novelname"));
					book.setNovelid(rs.getInt("novelid"));
					if("search".equals(type)) {
						this.s_novelnamecomboBox.addItem(book);
					}else if("modify".equals(type)){
						this.novelnamejcb.addItem(book);//������������Ϊ�Ҷ����������û��������
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
