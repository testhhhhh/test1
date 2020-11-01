package blogview;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import inputcheck.UserIntroduceTextKeyListener;
import jdbc.DLUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JRadioButton;

public class PersonalCentreView extends JFrame {

	private JPanel contentPane;
	private JTextField usernametext;
	private JPasswordField passwordtext;
	private JPasswordField ispasswordtext;
	private JTextField telephonetext;
	private JTextField introducetext;

	/**
	 * Launch the application.
	 */
	public static void PersonalCentrelnit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalCentreView frame = new PersonalCentreView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//�����������Ľ��洰��
	}

	/**
	 * Create the frame.
	 */
	public PersonalCentreView() {
		setTitle("\u4E2A\u4EBA\u4E2D\u5FC3");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 997, 688);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//�����������

		JButton returnbutton = new JButton("\u8FD4\u56DE\u9996\u9875");		
		returnbutton.setBackground(new Color(255, 240, 245));
		returnbutton.setFont(new Font("��������", Font.BOLD, 35));
		returnbutton.setBounds(763, 24, 210, 49);
		contentPane.add(returnbutton);		
        returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomepageView.homepageInit();//�����ť,��ת����ҳҳ��
			}
		});
        //�������ذ�ť
        
		JLabel useridlabel = new JLabel("\u7528\u6237ID\uFF1A");
		useridlabel.setForeground(new Color(255, 255, 0));
		useridlabel.setFont(new Font("��������", Font.BOLD, 30));
		useridlabel.setBounds(309, 78, 127, 49);
		contentPane.add(useridlabel);
		//�����û�id��ǩ

		JLabel idlabel = new JLabel("");
		idlabel.setForeground(new Color(255, 255, 0));
		idlabel.setFont(new Font("����", Font.BOLD, 30));
		idlabel.setBounds(446, 88, 137, 35);
		contentPane.add(idlabel);
		//�����û�id��ʾ��ǩ

		JLabel usernamelabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		usernamelabel.setForeground(new Color(255, 255, 0));
		usernamelabel.setFont(new Font("��������", Font.BOLD, 30));
		usernamelabel.setBounds(309, 148, 127, 35);
		contentPane.add(usernamelabel);
		//�����û�����ǩ

		usernametext = new JTextField();
		usernametext.setBounds(446, 153, 283, 30);
		contentPane.add(usernametext);
		usernametext.setColumns(10);
		//�����û����ı���

		JLabel passwordlabel = new JLabel("\u4FEE\u6539\u5BC6\u7801\uFF1A");
		passwordlabel.setForeground(new Color(255, 255, 0));
		passwordlabel.setFont(new Font("��������", Font.BOLD, 30));
		passwordlabel.setBounds(280, 214, 156, 35);
		contentPane.add(passwordlabel);
		//���������ǩ

		passwordtext = new JPasswordField();
		passwordtext.setBounds(446, 219, 283, 30);
		contentPane.add(passwordtext);
		//���������ı���

		JLabel ispasswordlabel = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		ispasswordlabel.setForeground(new Color(255, 255, 0));
		ispasswordlabel.setFont(new Font("��������", Font.BOLD, 30));
		ispasswordlabel.setBounds(277, 281, 159, 35);
		contentPane.add(ispasswordlabel);
		//����ȷ�������ǩ

		ispasswordtext = new JPasswordField();
		ispasswordtext.setBounds(446, 281, 283, 30);
		contentPane.add(ispasswordtext);
		//�����Ա��ǩ

		JLabel telephonelabel = new JLabel("\u7535\u8BDD\uFF1A");
		telephonelabel.setForeground(new Color(255, 255, 0));
		telephonelabel.setFont(new Font("��������", Font.BOLD, 30));
		telephonelabel.setBounds(335, 352, 100, 35);
		contentPane.add(telephonelabel);
		//�����绰�����ǩ

		telephonetext = new JTextField();
		telephonetext.setBounds(446, 363, 283, 30);
		contentPane.add(telephonetext);
		telephonetext.setColumns(10);
		//�����绰�����ı���

		JButton okbutton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		okbutton.setBackground(new Color(255, 240, 245));
		okbutton.setFont(new Font("������κ", Font.BOLD, 30));
		okbutton.setBounds(763, 115, 210, 49);
		contentPane.add(okbutton);
		//����ȷ�ϰ�ť

		daoimplement.UserDaoImplement ud = new daoimplement.UserDaoImplement();//�����û�Daoʵ�������
		idlabel.setText(String.valueOf(ud.userid));
		//�����Ա�Ů��ѡ��ť

		JLabel usernamewarnlabel = new JLabel("");
		usernamewarnlabel.setForeground(new Color(255, 0, 0));
		usernamewarnlabel.setBounds(396, 193, 376, 16);
		contentPane.add(usernamewarnlabel);
		//�����û������뾯���ǩ

		JLabel passwordwarnlabel = new JLabel("");
		passwordwarnlabel.setForeground(Color.RED);
		passwordwarnlabel.setBounds(396, 255, 376, 16);
		contentPane.add(passwordwarnlabel);
		//�����������뾯���ǩ

		JLabel ispasswordwarnlabel = new JLabel("");
		ispasswordwarnlabel.setForeground(Color.RED);
		ispasswordwarnlabel.setBounds(396, 326, 376, 16);
		contentPane.add(ispasswordwarnlabel);
		//�����Ա����뾯���ǩ

		JLabel telephonewarnlabel = new JLabel("");
		telephonewarnlabel.setForeground(Color.RED);
		telephonewarnlabel.setBounds(396, 397, 376, 16);
		contentPane.add(telephonewarnlabel);
		//�������汳��ͼƬ��ǩ

		ButtonGroup bg = new ButtonGroup();
		//�����Ա���,����Ů��ѡ��ť�������
		
		JLabel introducelabel = new JLabel("\u4E2A\u4EBA\u7B80\u4ECB\uFF1A");
		introducelabel.setForeground(Color.YELLOW);
		introducelabel.setFont(new Font("��������", Font.BOLD, 30));
		introducelabel.setBounds(280, 414, 156, 35);
		contentPane.add(introducelabel);
		
		introducetext = new JTextField();
		introducetext.setColumns(10);
		introducetext.setBounds(280, 447, 492, 170);
		contentPane.add(introducetext);
		
		JLabel introducewarnlabel = new JLabel("");
		introducewarnlabel.setForeground(Color.RED);
		introducewarnlabel.setBounds(309, 627, 422, 16);
		contentPane.add(introducewarnlabel);
		

		inputcheck.UserTextKeyListener utkl = new inputcheck.UserTextKeyListener(usernamewarnlabel, usernametext, "register");
		usernametext.addKeyListener(utkl);
		inputcheck.PasswordTextKeyListener ptkl = new inputcheck.PasswordTextKeyListener(passwordwarnlabel, passwordtext);
		passwordtext.addKeyListener(ptkl);
		inputcheck.IsPasswordTextKeyListener iptkl = new inputcheck.IsPasswordTextKeyListener(passwordtext, ispasswordwarnlabel,ispasswordtext);
		ispasswordtext.addKeyListener(iptkl);
		UserIntroduceTextKeyListener ntkl = new UserIntroduceTextKeyListener(introducewarnlabel, introducetext);
		inputcheck.TelephoneTextKeyListener ttkl = new inputcheck.TelephoneTextKeyListener(telephonewarnlabel, telephonetext);
		
		
		JLabel picturelabel = new JLabel("");
		picturelabel.setIcon(new ImageIcon(PersonalCentreView.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710224105.png")));
		picturelabel.setBounds(0, 0, 999, 651);
		contentPane.add(picturelabel);
		telephonetext.addKeyListener(ttkl);

		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn=DLUtil.getCon();
				String username = usernametext.getText();
				String password = String.valueOf(passwordtext.getPassword());
				String ispassword = String.valueOf(ispasswordtext.getPassword());
				String introduce = introducetext.getText();
				String telephone = telephonetext.getText();
				if (ispassword.equals(password) && !("".equals(username)) && !("".equals(password))
						&& !("".equals(ispassword)) && !("".equals(introduce))
						&& !("".equals(telephone)) && ("".equals(usernamewarnlabel.getText()))
						&& "".equals(passwordwarnlabel.getText()) && "".equals(ispasswordwarnlabel.getText())
						&& "".equals(introducewarnlabel.getText()) && "".equals(telephonewarnlabel.getText())
						) {
					try {System.out.println(ud.update(conn,new entity.User(0,username, ispassword,telephone,0,"0",introduce)));
						ud.update(conn,new entity.User(0,username, ispassword,telephone,0,"0",introduce));
						if(ud.isRegisted(conn,username)==0)
							JOptionPane.showMessageDialog(null, "�޸ĳɹ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
					} catch (HeadlessException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "�޸�ʧ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}
}
