package blogview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import daoimplement.UserDaoImplement;
import entity.User;
import inputcheck.CodeTextKeyListener;
import inputcheck.IsPasswordTextKeyListener;
import inputcheck.PasswordTextKeyListener;
import inputcheck.TelephoneTextKeyListener;
import inputcheck.UserTextKeyListener;
import jdbc.DLUtil;

public class Registerview extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void registerInit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registerview frame = new Registerview();
					frame.setLocationRelativeTo(null);
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
	public Registerview() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1261, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//�����������

				JPanel panel = new JPanel();
				panel.setBackground(new Color(153, 204, 255));
				panel.setBounds(0, 0, 548, 360);
				contentPane.add(panel);
				panel.setLayout(null);
				//�������

				JTextField usernametext = new JTextField();
				usernametext.setBounds(258, 117, 227, 28);
				panel.add(usernametext);
				usernametext.setColumns(10);
				//�����û����ı���

				JLabel username = new JLabel("\u7528\u6237\u540D\uFF1A");
				username.setForeground(Color.WHITE);
				username.setFont(new Font("��������", Font.BOLD, 22));
				username.setBackground(Color.PINK);
				username.setBounds(133, 112, 98, 28);
				panel.add(username);
				//�����û�����ǩ

				JLabel password = new JLabel("\u5BC6   \u7801\uFF1A");
				password.setForeground(Color.WHITE);
				password.setBackground(Color.BLACK);
				password.setFont(new Font("��������", Font.BOLD, 22));
				password.setBounds(136, 193, 100, 28);
				panel.add(password);
				//���������ǩ

				JButton registerbutton = new JButton("\u6CE8\u518C");
				registerbutton.setBackground(new Color(255, 250, 205));
				registerbutton.setForeground(Color.BLACK);
				registerbutton.setFont(new Font("������κ", Font.PLAIN, 28));
				registerbutton.setBounds(184, 549, 104, 37);
				panel.add(registerbutton);
				//����ע�ᰴť

				JButton resetbutton = new JButton("����");
				resetbutton.setBackground(new Color(255, 250, 205));
				resetbutton.setForeground(Color.BLACK);
				resetbutton.setFont(new Font("������κ", Font.PLAIN, 28));
				resetbutton.setBounds(439, 549, 104, 37);
				panel.add(resetbutton);
				//�������ð�ť

				JLabel ispassword = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
				ispassword.setForeground(Color.WHITE);
				ispassword.setFont(new Font("��������", Font.BOLD, 22));
				ispassword.setBounds(114, 263, 122, 28);
				panel.add(ispassword);
				//����ȷ�������ǩ

				JLabel telephone = new JLabel("\u7535   \u8BDD\uFF1A");
				telephone.setForeground(Color.WHITE);
				telephone.setFont(new Font("��������", Font.BOLD, 22));
				telephone.setBounds(133, 333, 89, 28);
				panel.add(telephone);
				//���������ı���

				JTextField telephonetext = new JTextField();
				telephonetext.setBounds(258, 338, 227, 28);
				panel.add(telephonetext);
				telephonetext.setColumns(10);
				//�����绰�����ı���

				JTextField codetext = new JTextField();
				codetext.setBounds(258, 423, 157, 28);
				panel.add(codetext);
				codetext.setColumns(10);
				//������֤���ı���

				JLabel registtitlelabel = new JLabel("\u7528\u6237\u6CE8\u518C");
				registtitlelabel.setForeground(Color.WHITE);
				registtitlelabel.setIcon(new ImageIcon(Registerview.class.getResource("/images/\u56FE\u4E66(1).png")));
				registtitlelabel.setFont(new Font("��������", Font.BOLD, 50));
				registtitlelabel.setBounds(173, 20, 370, 47);
				panel.add(registtitlelabel);
				//����ע���������ǩ

				JLabel codelabel = new JLabel("\u9A8C\u8BC1\u7801\uFF1A");
				codelabel.setForeground(Color.WHITE);
				codelabel.setFont(new Font("��������", Font.BOLD, 22));
				codelabel.setBounds(132, 418, 99, 28);
				panel.add(codelabel);
				//������֤���ǩ

				JPasswordField passwordtext = new JPasswordField();
				passwordtext.setBounds(258, 193, 227, 28);
				panel.add(passwordtext);
				//���������ı���

				JPasswordField ispasswordtext = new JPasswordField();
				ispasswordtext.setBounds(258, 263, 227, 28);
				panel.add(ispasswordtext);
				//����ȷ�������ı���

				JLabel codeshowlabel = new JLabel("");
				codeshowlabel.setBackground(new Color(255, 255, 255));
				codeshowlabel.setFont(new Font("�����п�", Font.PLAIN, 30));
				codeshowlabel.setForeground(Color.WHITE);
				codeshowlabel.setBounds(439, 423, 122, 28);
				panel.add(codeshowlabel);
				//�����Ա�Ů��ѡ��ť

				JLabel usernamewarnlabel = new JLabel("");
				usernamewarnlabel.setForeground(new Color(255, 0, 0));
				usernamewarnlabel.setBounds(258, 150, 485, 22);
				panel.add(usernamewarnlabel);
				//�����û������뾯���ǩ

				JLabel passwordwarnlabel = new JLabel("");
				passwordwarnlabel.setForeground(Color.RED);
				passwordwarnlabel.setBounds(258, 225, 494, 28);
				panel.add(passwordwarnlabel);
				//�����������뾯���ǩ

				JLabel ispasswordwarnlabel = new JLabel("");
				ispasswordwarnlabel.setForeground(Color.RED);
				ispasswordwarnlabel.setBounds(258, 301, 139, 22);
				panel.add(ispasswordwarnlabel);
				//�����Ա�ѡ�񾯸��ǩ

				JLabel telephonewarnlabel = new JLabel("");
				telephonewarnlabel.setForeground(Color.RED);
				telephonewarnlabel.setBounds(258, 376, 98, 22);
				panel.add(telephonewarnlabel);		
				//�����绰�������뾯���ǩ

				JLabel codewarnlabel = new JLabel("");
				codewarnlabel.setForeground(Color.RED);
				codewarnlabel.setBounds(258, 461, 227, 22);
				panel.add(codewarnlabel);
				//������֤�����뾯���ǩ
				
		        codeshowlabel.setText(String.valueOf((int) (Math.random() * 10000 + 1)));
		        //�����Զ��������1~9999֮������������Ϊ��֤��
		        
				JLabel backgroundipclabel = new JLabel("");
				backgroundipclabel.setIcon(new ImageIcon(Registerview.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710224042.png")));
				backgroundipclabel.setBounds(-332, 0, 1580, 731);
				panel.add(backgroundipclabel);
				//����ע����汳��ͼƬ��ǩ
				
				UserTextKeyListener utkl = new UserTextKeyListener(usernamewarnlabel, usernametext, "register");
				usernametext.addKeyListener(utkl);
				PasswordTextKeyListener ptkl = new PasswordTextKeyListener(passwordwarnlabel, passwordtext);
				passwordtext.addKeyListener(ptkl);
				IsPasswordTextKeyListener iptkl = new IsPasswordTextKeyListener(passwordtext, ispasswordwarnlabel,ispasswordtext);
				ispasswordtext.addKeyListener(iptkl);
				TelephoneTextKeyListener ttkl = new TelephoneTextKeyListener(telephonewarnlabel, telephonetext);
				telephonetext.addKeyListener(ttkl);
				CodeTextKeyListener ctkl = new CodeTextKeyListener(codewarnlabel, codetext);
				codetext.addKeyListener(ctkl);
				
				resetbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						usernametext.setText("");
						passwordtext.setText("");
						ispasswordtext.setText("");
						telephonetext.setText("");
						codetext.setText("");
						usernamewarnlabel.setText("");
						passwordwarnlabel.setText("");
						ispasswordwarnlabel.setText("");
						telephonewarnlabel.setText("");
						codewarnlabel.setText("");
						usernametext.requestFocus();
					}
				});// ���ð�ť�ж�
				
				registerbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						User user=new User(0,usernametext.getText(),String.valueOf(passwordtext.getPassword()),telephonetext.getText(),1,codetext.getText(),"0");
						UserDaoImplement udi=new UserDaoImplement();
						Connection conn=DLUtil.getCon();
						try {
							if(udi.isRegisted(conn, usernametext.getText())==0) {
								if(udi.add(conn, user)!=0) {
									JOptionPane.showMessageDialog(null, "ע��ɹ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
								}
							}
								else {
									JOptionPane.showMessageDialog(null, "ע��ʧ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
								}
							}
						catch (SQLException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}}
				});
				
	}

}
