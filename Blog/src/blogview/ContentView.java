package blogview;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import daoimplement.ArticleImplement;
import daoimplement.CollectionImplement;
import daoimplement.UserDaoImplement;
import entity.Ariticle;
import jdbc.DLUtil;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class ContentView extends JFrame {
	Connection conn =conn = DLUtil.getCon();// ��ȡ���ݿ�����   
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void ContentViewInit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContentView frame = new ContentView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//�����½��Ķ�ҳ�洰��
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ContentView() throws SQLException {
		setTitle("\u535A\u6587");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1253, 797);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//�����������

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("������κ", Font.PLAIN, 27));
		textArea.setLineWrap(true);// �Զ�����
		textArea.setBackground(new Color(255, 248, 220));
		//�����ı���

		JScrollPane scrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				                                  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(36, 44, 973, 693);
		scrollPane.setViewportView(textArea);
		contentPane.add(scrollPane);
		contentPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		//�����������
		
		

		ArticleImplement adi = new ArticleImplement();//����Daoʵ�������
		Ariticle article = new Ariticle(adi.title);// ��װ����
		String content=adi.contentshow(conn, article);
		if(!"��".equals(content)) {
			textArea.setText(content);
		}
		//�ı���������chapterʵ���е��½�����Ϊ���ı�����
		
		JButton commentbutton = new JButton("\u8BC4\u8BBA\u533A");
		commentbutton.setIcon(new ImageIcon(ContentView.class.getResource("/images/\u4F1A\u5458(1).png")));
		commentbutton.setBackground(new Color(255, 182, 193));
		commentbutton.setFont(new Font("��������", Font.PLAIN, 33));
		commentbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommentView.CommentViewInit();
			}
		});
		commentbutton.setBounds(1019, 470, 174, 50);
		contentPane.add(commentbutton);
		
		CollectionImplement cdi=new CollectionImplement();
		UserDaoImplement udi=new UserDaoImplement();
		adi.articleinteractive(conn, adi.title);
		JButton collectbutton = new JButton("\u6536\u85CF");
		collectbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println(cdi.isadd(conn, udi.userid, adi.article.getArticleid()));
					if(!cdi.isadd(conn, udi.userid, adi.article.getArticleid())){
						if(cdi.add(conn, udi.userid, adi.article.getArticleid())!=0) {
							JOptionPane.showMessageDialog(null, "�ղسɹ���������ҳ�ղؼ��в���Ŷ", "�ղسɹ�", JOptionPane.PLAIN_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "ϵͳ�������ˣ����Ժ�����", "�ղ�ʧ��", JOptionPane.PLAIN_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "�ò������ղ����ղؼ���", "��ʾ", JOptionPane.PLAIN_MESSAGE);
					}
					
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		collectbutton.setIcon(new ImageIcon(ContentView.class.getResource("/images/\u5411\u4E0B.png")));
		collectbutton.setFont(new Font("��������", Font.PLAIN, 33));
		collectbutton.setBackground(new Color(255, 182, 193));
		collectbutton.setBounds(1019, 581, 174, 50);
		contentPane.add(collectbutton);
		
		
		
		JButton goodbutton = new JButton("\u70B9\u8D5E");
		goodbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(adi.good(conn,adi.title)!=0)
					JOptionPane.showMessageDialog(null, "��л����ޣ��һ���͵�", "���޳ɹ�", JOptionPane.PLAIN_MESSAGE);
					else {
						JOptionPane.showMessageDialog(null, "ϵͳ�������ˣ����Ժ�����", "����ʧ��", JOptionPane.PLAIN_MESSAGE);
					}
					
				} catch (HeadlessException | SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		goodbutton.setIcon(new ImageIcon(ContentView.class.getResource("/images/\u82B1(1).png")));
		goodbutton.setFont(new Font("��������", Font.PLAIN, 33));
		goodbutton.setBackground(new Color(255, 182, 193));
		goodbutton.setBounds(1019, 354, 174, 50);
		contentPane.add(goodbutton);
		
		JButton deletebutton = new JButton("\u53D6\u6D88\u6536\u85CF");
		deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(cdi.isadd(conn, udi.userid, adi.article.getArticleid())){
						if(cdi.delete(conn,udi.userid, adi.article.getArticleid())!=0) {
							JOptionPane.showMessageDialog(null, "��ȡ���ղ�", "ȡ���ղ�", JOptionPane.PLAIN_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "ϵͳ�������ˣ����Ժ�����", "ȡ���ղ�ʧ��", JOptionPane.PLAIN_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "�ò���û���ղ����ղؼ���", "��ʾ", JOptionPane.PLAIN_MESSAGE);
					}
				} catch (HeadlessException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		deletebutton.setIcon(new ImageIcon(ContentView.class.getResource("/images/\u5220\u9664(1).png")));
		deletebutton.setForeground(Color.BLACK);
		deletebutton.setFont(new Font("��������", Font.PLAIN, 33));
		deletebutton.setBackground(new Color(255, 192, 203));
		deletebutton.setBounds(1019, 687, 210, 50);
		contentPane.add(deletebutton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(1019, 46, 194, 233);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel writerlabell = new JLabel("New label");
		writerlabell.setFont(new Font("��������", Font.PLAIN, 33));
		writerlabell.setForeground(new Color(139, 0, 0));
		writerlabell.setBounds(10, 60, 174, 35);
		panel.add(writerlabell);
		writerlabell.setText(adi.article.getWriter());
		
		JLabel writerlabel = new JLabel("\u4F5C\u8005\uFF1A");
		writerlabel.setBounds(10, 15, 98, 35);
		panel.add(writerlabel);
		writerlabel.setForeground(new Color(139, 0, 0));
		writerlabel.setFont(new Font("��������", Font.PLAIN, 33));
		
		JLabel lblNewLabel_2 = new JLabel("\u70ED\u5EA6\uFF1A");
		lblNewLabel_2.setForeground(new Color(139, 0, 0));
		lblNewLabel_2.setFont(new Font("��������", Font.PLAIN, 33));
		lblNewLabel_2.setBounds(10, 125, 98, 35);
		panel.add(lblNewLabel_2);
		
		JLabel hotlabel = new JLabel("New label");
		hotlabel.setForeground(new Color(139, 0, 0));
		hotlabel.setFont(new Font("��������", Font.PLAIN, 33));
		hotlabel.setBounds(10, 170, 174, 35);
		panel.add(hotlabel);
		hotlabel.setText(String.valueOf((adi.article.getHot())));    
		
		JLabel piclabel = new JLabel("");
		piclabel.setIcon(new ImageIcon(ContentView.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710224038.png")));
		piclabel.setBounds(0, 0, 1279, 782);
		contentPane.add(piclabel);
	}
}
