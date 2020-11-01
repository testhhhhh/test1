package adminview;

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
import java.awt.Window;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.CommentDao;
import daoimplement.ArticleImplement;
import daoimplement.CommentImplement;
import entity.Ariticle;
import entity.Comment;
import inputcheck.InputOrNot;
import jdbc.DLUtil;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Container;

public class CommentManageView extends JFrame {


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


	private JLabel searchblognamelabel;
	private JButton searchblognamebutton;
	private JTable commenttable;
	private JLabel commentidlabel;
	private JTextField commentidtextField;
	private JButton deletecommentbutton;
	private JComboBox<Ariticle> blognamecomboBox;

	/**
	 * Create the frame.
	 */
	public CommentManageView() {
//		setClosable(true);
//		setIconifiable(true);
		setTitle("\u8BC4\u8BBA\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 769, 621);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		searchblognamelabel = new JLabel("\u535A\u5BA2\u8BC4\u8BBA\u4FE1\u606F\uFF1A");
		searchblognamelabel.setForeground(Color.BLACK);
		searchblognamelabel.setIcon(new ImageIcon(CommentManageView.class.getResource("/images/\u56FE\u4E66(4).png")));
		searchblognamelabel.setBounds(71, 52, 224, 33);
		searchblognamelabel.setFont(new Font("΢���ź�", Font.BOLD, 25));
		
//		searchblognamebutton = new JButton("\u67E5\u8BE2");
//		searchblognamebutton.setIcon(new ImageIcon(CommentManageView.class.getResource("/images/\u67E5\u8BE2(3).png")));
//		searchblognamebutton.setBounds(567, 46, 123, 41);
//		searchblognamebutton.setFont(new Font("΢���ź�", Font.BOLD, 23));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 109, 692, 346);
		
		commenttable = new JTable();
		commenttable.setBackground(new Color(102, 205, 170));
		commenttable.setModel(new DefaultTableModel(
			new Object[][] {},new String[] {"����ID", "����ID", "����\u540D\u79F0", "�û�ID", "��������"}) {
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
//		contentPane.add(searchblognamebutton);
		contentPane.add(scrollPane);
		
//		blognamecomboBox = new JComboBox<Ariticle>();
//		blognamecomboBox.setFont(new Font("΢���ź�", Font.PLAIN, 15));
//		blognamecomboBox.setBounds(292, 52, 241, 33);
//		contentPane.add(blognamecomboBox);
		
		deletecommentbutton = new JButton("\u5220\u9664");
		(deletecommentbutton).setIcon(new ImageIcon(CommentManageView.class.getResource("/images/\u5220\u9664(1).png")));
		deletecommentbutton.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		deletecommentbutton.setBounds(314, 497, 130, 41);
		contentPane.add(deletecommentbutton);
		
		commentidtextField = new JTextField();
		commentidtextField.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		commentidtextField.setEditable(false);
		commentidtextField.setBounds(147, 498, 97, 40);
		contentPane.add(commentidtextField);
		commentidtextField.setColumns(10);
		
		commentidlabel = new JLabel("\u8BC4\u8BBA\u7F16\u53F7\uFF1A");
		commentidlabel.setFont(new Font("΢���ź�", Font.BOLD, 18));
		commentidlabel.setBounds(46, 502, 97, 32);
		contentPane.add(commentidlabel);
		
		JLabel picturelabel = new JLabel("");
		picturelabel.setIcon(new ImageIcon(CommentManageView.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710215623.png")));
		picturelabel.setBounds(0, 0, 755, 584);
		contentPane.add(picturelabel);
	
//		//���С˵������
//		this.fillnovelType("search");
//		this.fillnovelType("modify");
		
//		searchblognamebutton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent es) {
//				CommentSeclect(es);
//			}
//		});
		
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
		//����������
		this.filltable(new Comment());
	}
	
	
	//������¼�
    private void Tableclick(MouseEvent ek) {
	int row=this.commenttable.getSelectedRow();//��ȡ����
	this.commentidtextField.setText((String) commenttable.getValueAt(row, 0));//���//��ȡ�е�����
	}


    //ɾ��������Ϣ
	private void CommentDelete(ActionEvent ec) {
		String id=this.commentidtextField.getText();
		if(InputOrNot.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���ļ�¼");
			return;	
		}
		int n=JOptionPane.showConfirmDialog(null,"ȷ��Ҫɾ��������¼��");
		if(n==0) {
			Connection conn=null;
			try {
				conn=DLUtil.getCon();
				int deleteNum=new CommentImplement().delete(conn, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");	
					this.commentidtextField.setText("");
					this.filltable(new Comment());//���±������
				}else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��");		
				}
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "ɾ��ʧ��");	
			}finally {
				try {
					DLUtil.CloseCon(conn);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	
	//���۲�ѯ�¼�
	private void CommentSeclect(ActionEvent es) {
		// TODO Auto-generated method stub
	    //��ȡ�������ѡ�����
		Ariticle article=(Ariticle) this.blognamecomboBox.getSelectedItem();
		int articleid=article.getArticleid();
		Comment comment =new Comment(articleid);//��װ����
		this.filltable(comment);
		this.blognamecomboBox.setSelectedIndex(0);
	}

	
	//������
	private void filltable(Comment comment) {
		DefaultTableModel dtm=(DefaultTableModel) commenttable.getModel();//���model�����г�ʼ��
		dtm.setRowCount(0);//���ó�0�У���ձ��
		Connection conn=null;
		try {
			conn=DLUtil.getCon();//��ȡ���ݿ�����
			ResultSet rs=new CommentImplement().list(conn, comment);
			
			//�ü��Ͻ��б���
			while(rs.next()) {
				Vector<String> v=new Vector<String>();
				v.add(rs.getString("commentid"));
				v.add(rs.getString("articleid"));
				v.add(rs.getString("title"));
				v.add(rs.getString("userid"));
				v.add(rs.getString("commentcontent"));
				dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DLUtil.CloseCon(conn);//�ر����ݿ�����
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	//��ʼ��������С˵����
    //����������
    private void fillnovelType(String type) {
				Connection conn=null;
				Ariticle article=null;
				try {
					conn=DLUtil.getCon();
					ResultSet rs=new ArticleImplement().list(conn,new Ariticle());
					if("search".equals(type)) {
						article=new Ariticle();
						article.setTitle("��ѡ��.....");
						article.setArticleid(-1);
						this.blognamecomboBox.addItem(article);
					}
					while(rs.next()) {
						article=new Ariticle();
						article.setTitle(rs.getString("title"));
						article.setArticleid(rs.getInt("articleid"));
						if("search".equals(type)) {
							this.blognamecomboBox.addItem(article);
						}else if("modify".equals(type)){
//							this.blognamecomboBox.addItem(article);//������������Ϊ�Ҷ����������û��������
						}
					}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					DLUtil.CloseCon(conn);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
	}

