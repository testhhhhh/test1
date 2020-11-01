package adminview;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import daoimplement.ArticleImplement;
import entity.Ariticle;
import inputcheck.InputOrNot;
import jdbc.DLUtil;


public class ArticleMangeInterFrm extends JFrame {
	private JTable bookTable;
	private JTextField titletext;
	private JTextField writertext;
    private JTextField idtextfield;
    private JTextField titlechangetext;
    private JTextField writerchangetext;
    private static JTextField pictureuptext;
    private static JLabel pictureviewlabel;
    private JTextArea contenttextArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArticleMangeInterFrm frame = new ArticleMangeInterFrm();
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
	public ArticleMangeInterFrm() {
		getContentPane().setBackground(new Color(72, 209, 204));
//		setClosable(true);
//		setIconifiable(true);
		setTitle("\u535A\u6587\u7BA1\u7406");
		setBounds(300, 80, 1229, 812);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(111, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1004, GroupLayout.PREFERRED_SIZE)
					.addGap(100))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1103, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1163, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		
		JLabel idlabel = new JLabel("\u7F16\u53F7\uFF1A");
		idlabel.setBounds(49, 27, 84, 32);
		idlabel.setIcon(new ImageIcon(ArticleMangeInterFrm.class.getResource("/images/\u7F16\u53F7.png")));
		idlabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		
		idtextfield = new JTextField();
		idtextfield.setBackground(SystemColor.control);
		idtextfield.setBounds(151, 27, 100, 32);
		idtextfield.setEditable(false);
		idtextfield.setColumns(10);
		
		JLabel titlechangelabel = new JLabel("\u535A\u6587\u6807\u9898\uFF1A");
		titlechangelabel.setBounds(382, 27, 116, 32);
		titlechangelabel.setIcon(new ImageIcon(ArticleMangeInterFrm.class.getResource("/images/\u56FE\u4E66.png")));
		titlechangelabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		
		titlechangetext = new JTextField();
		titlechangetext.setBounds(498, 30, 189, 32);
		titlechangetext.setColumns(10);
		
		JLabel writerchangelabel = new JLabel("\u535A\u6587\u4F5C\u8005\uFF1A");
		writerchangelabel.setBounds(774, 29, 120, 32);
		writerchangelabel.setIcon(new ImageIcon(ArticleMangeInterFrm.class.getResource("/images/\u4E2A\u4EBA\u4FE1\u606F_\u5B9D\u8D1D\u59D3\u540D.png")));
		writerchangelabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		
		writerchangetext = new JTextField();
		writerchangetext.setBounds(904, 29, 178, 33);
		writerchangetext.setColumns(10);
		panel_1.setLayout(null);
		panel_1.add(idlabel);
		panel_1.add(idtextfield);
		panel_1.add(titlechangelabel);
		panel_1.add(writerchangelabel);
		panel_1.add(writerchangetext);
		panel_1.add(titlechangetext);
		
		JLabel lblNewLabel_8 = new JLabel("\u535A\u6587\u5185\u5BB9\uFF1A");
		lblNewLabel_8.setIcon(new ImageIcon(ArticleMangeInterFrm.class.getResource("/images/\u56FE\u4E66(2).png")));
		lblNewLabel_8.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(382, 77, 109, 32);
		panel_1.add(lblNewLabel_8);
		
		JButton changebutton = new JButton("\u4FEE\u6539");
		changebutton.setBackground(SystemColor.control);
		changebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtt) {
				bookUpdate(evtt);
			}
		});
		changebutton.setIcon(new ImageIcon(ArticleMangeInterFrm.class.getResource("/images/\u4FEE\u6539.png")));
		changebutton.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		changebutton.setBounds(995, 232, 110, 37);
		panel_1.add(changebutton);
		
		JButton deletebutton = new JButton("\u5220\u9664");
		deletebutton.setBackground(SystemColor.control);
		deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ee) {
				bookDelete(ee);
			}
		});
		deletebutton.setIcon(new ImageIcon(ArticleMangeInterFrm.class.getResource("/images/\u5220\u9664(1).png")));
		deletebutton.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		deletebutton.setBounds(995, 350, 109, 38);
		panel_1.add(deletebutton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(382, 133, 568, 279);
		panel_1.add(scrollPane_1);
		
	    contenttextArea = new JTextArea();
	    contenttextArea.setLineWrap(true);
		scrollPane_1.setViewportView(contenttextArea);
				
				JLabel picuplabel = new JLabel("\u56FE\u7247\u4E0A\u4F20\uFF1A");
				picuplabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));
				picuplabel.setIcon(new ImageIcon(ArticleMangeInterFrm.class.getResource("/images/\u4E0A\u4F20.png")));
				picuplabel.setBounds(778, 77, 116, 32);
				panel_1.add(picuplabel);
				
				pictureuptext = new JTextField();
				pictureuptext.setBounds(16, 121, 352, 33);
				panel_1.add(pictureuptext);
				pictureuptext.setColumns(10);
				
				JLabel pictureuplabel = new JLabel("\u56FE\u7247\u6548\u679C\u9884\u89C8\uFF1A");
				pictureuplabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));
				pictureuplabel.setIcon(new ImageIcon(ArticleMangeInterFrm.class.getResource("/images/\u82B1.png")));
				pictureuplabel.setBounds(16, 79, 155, 32);
				panel_1.add(pictureuplabel);
				
				pictureviewlabel = new JLabel("");
				pictureviewlabel.setFont(new Font("΢���ź�", Font.BOLD, 12));
				pictureviewlabel.setBounds(27, 164, 341, 248);
				panel_1.add(pictureviewlabel);
				
				JButton picupbutton = new JButton("\u70B9\u51FB\u4E0A\u4F20");
				picupbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new ArticleImplement().addPicture(picupbutton,pictureviewlabel,pictureuptext);	
					}
				});
				picupbutton.setFont(new Font("΢���ź�", Font.BOLD, 16));
				picupbutton.setBounds(927, 79, 155, 32);
				panel_1.add(picupbutton);
				
				JButton pictureupbutton = new JButton("\u70B9\u51FB\u67E5\u770B\u539F\u56FE");
				pictureupbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ep) {
						PitcureClick(ep);
					}
				});
				pictureupbutton.setFont(new Font("����", Font.BOLD, 14));
				pictureupbutton.setBounds(142, 84, 130, 23);
				panel_1.add(pictureupbutton);
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(ArticleMangeInterFrm.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710215623.png")));
				lblNewLabel.setBounds(0, 10, 1163, 439);
				panel_1.add(lblNewLabel);
		
		JLabel titlelabel = new JLabel("\u535A\u6587\u6807\u9898\uFF1A");
		titlelabel.setBounds(183, 31, 116, 32);
		titlelabel.setIcon(new ImageIcon(ArticleMangeInterFrm.class.getResource("/images/\u56FE\u4E66.png")));
		titlelabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		
		titletext = new JTextField();
		titletext.setBounds(331, 33, 148, 33);
		titletext.setColumns(10);
		
		JLabel writerlabel = new JLabel("\u4F5C\u8005\uFF1A");
		writerlabel.setBounds(615, 31, 96, 32);
		writerlabel.setIcon(new ImageIcon(ArticleMangeInterFrm.class.getResource("/images/\u4E2A\u4EBA\u4FE1\u606F_\u5B9D\u8D1D\u59D3\u540D.png")));
		writerlabel.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		
		writertext = new JTextField();
		writertext.setBounds(721, 34, 127, 32);
		writertext.setColumns(10);
		
		JButton searchbutton = new JButton("\u67E5\u8BE2");
		searchbutton.setBounds(938, 32, 112, 36);
		searchbutton.setBackground(SystemColor.control);
		searchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearch(e);
			}
		});
		searchbutton.setIcon(new ImageIcon(ArticleMangeInterFrm.class.getResource("/images/\u67E5\u8BE2(2).png")));
		searchbutton.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		panel.setLayout(null);
		panel.add(titlelabel);
		panel.add(titletext);
		panel.add(writerlabel);
		panel.add(writertext);
		panel.add(searchbutton);
		
		bookTable = new JTable();
		bookTable.setBackground(new Color(72, 209, 204));
		bookTable.setForeground(new Color(0, 0, 0));
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			
			//�����������
			public void mousePressed(MouseEvent me) {
				booktableMousePressed(me);
			}
		});
		bookTable.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"���", "���ı���", "����", "����","ͼƬ"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(2).setPreferredWidth(178);
		scrollPane.setViewportView(bookTable);
		getContentPane().setLayout(groupLayout);
		this.filltable(new Ariticle());//�����ݿ����ݽ��е��뵽���
	}
	//�鿴ԭͼ��ť�¼�
	private void PitcureClick(ActionEvent ep) {
		String picture=this.pictureuptext.getText();
		this.pictureviewlabel.setIcon(new ImageIcon(picture));
		this.pictureviewlabel.getIcon();
	}
		
	//С˵ɾ���¼�����
	private void bookDelete(ActionEvent ee) {
		// TODO Auto-generated method stub
		String id=idtextfield.getText();
		if(InputOrNot.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���ļ�¼");
			return;	
		}
		int n=JOptionPane.showConfirmDialog(null,"ȷ��Ҫɾ��������¼��");
		if(n==0) {
			Connection conn=null;
			try {
				conn=jdbc.DLUtil.getCon();	
				int deleteNum=new ArticleImplement().delete(conn, Integer.valueOf(id));
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");	
					reSetValue(ee);//��������
					this.filltable(new Ariticle());//���±������
				}else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��");		
				}
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "ɾ��ʧ��");	
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

	
	
	//�޸�С˵�¼�����
	private void bookUpdate(ActionEvent evtt) {
		// TODO Auto-generated method stub
		String id=this.idtextfield.getText();//����û�ûѡ�����idΪ��
		if(InputOrNot.isEmpty(id)) {
			JOptionPane.showMessageDialog(null,"��ѡ��Ҫ�޸ĵļ�¼");
			return;
		}
		String title=this.titlechangetext.getText();//С˵����
		String content=this.contenttextArea.getText();//С˵���
		String writer=this.writerchangetext.getText();//С˵����
		String picture=this.pictureuptext.getText();//ͼƬ·��
		this.pictureviewlabel.setIcon(new ImageIcon(picture));
		this.pictureviewlabel.getIcon();
		if(InputOrNot.isEmpty(title)) {
			JOptionPane.showMessageDialog(null,"���ı��ⲻ��Ϊ��");
			return;
		}
		if(InputOrNot.isEmpty(writer)) {
			JOptionPane.showMessageDialog(null,"���߲���Ϊ��");
			return;
		}
		if(InputOrNot.isEmpty(content)) {
			JOptionPane.showMessageDialog(null,"�������ݲ���Ϊ��");
			return;
		}
		 Ariticle article=new Ariticle(Integer.parseInt(id), title, content, writer,picture);
		Connection conn=null;
		try {
			conn=DLUtil.getCon();
			int addNum=new ArticleImplement().update(conn, article);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				reSetValue(evtt);
				this.filltable(new Ariticle());//���±������
			}else {
				JOptionPane.showMessageDialog(null, "�޸�ʧ��");
				return;
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

	
	//����
	private void reSetValue(ActionEvent eaa) {
		// TODO Auto-generated method stub
		this.idtextfield.setText("");
		this.titlechangetext.setText("");
		this.contenttextArea.setText("");
		this.writerchangetext.setText("");
		this.titlechangetext.requestFocus();
		this.pictureuptext.setText("");
		this.pictureviewlabel.setIcon(new ImageIcon());
		
	}

	
	//����е���¼�����
	private void booktableMousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		int row=this.bookTable.getSelectedRow();//��ȡ����
		//��ȡ�е�����
		this.idtextfield.setText((String)bookTable.getValueAt(row, 0));//���
		this.titlechangetext.setText((String)bookTable.getValueAt(row, 1));//����
		this.contenttextArea.setText((String)bookTable.getValueAt(row, 2));//���
		this.writerchangetext.setText((String)bookTable.getValueAt(row, 3));//����
		this.pictureuptext.setText((String) bookTable.getValueAt(row, 4));}//ͼƬ·��


	
	//��ѯ����
	private void bookSearch(ActionEvent evt) {
		// TODO Auto-generated method stub
		String bookname=this.titletext.getText().toString();
		String bookwriter=this.writertext.getText();
	    Ariticle article=new Ariticle(bookname,bookwriter);//��װ����
	this.filltable(article);//���ñ������
	titletext.setText("");
	writertext.setText("");
	}

	
	//��ʼ���������
	private void filltable(Ariticle article) {
		DefaultTableModel dtm=(DefaultTableModel) bookTable.getModel();//���model�����г�ʼ��
		dtm.setRowCount(0);//���ó�0�У���ձ��
		Connection conn=null;
		try {
			conn=jdbc.DLUtil.getCon();//��ȡ���ݿ�����
			ResultSet rs=new ArticleImplement().list(conn, article);
			
			//�ü��Ͻ��б���
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("articleid"));
				v.add(rs.getString("title"));
				v.add(rs.getString("content"));
				v.add(rs.getString("writer"));
				v.add(rs.getString("picture"));
				dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				jdbc.DLUtil.CloseCon(conn);//�ر����ݿ�����
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
