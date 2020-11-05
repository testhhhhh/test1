package UserPackage.src.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UserPackage.src.DaoImple.UserDaoImplement;
import UserPackage.src.InputCheck.PasswordTextKeyListener;
import UserPackage.src.InputCheck.UserTextKeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField usernametext;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordtext;

	/**
	 * Launch the application.
	 */
	public static void loginlnit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//������¼�����ʼ������
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 694, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//�����������

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(0, 0, 680, 496);
		contentPane.add(panel);
		panel.setLayout(null);
		//����һ�����

		JLabel usernamelabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		usernamelabel.setBounds(119, 150, 115, 34);
		usernamelabel.setFont(new Font("��������", Font.BOLD, 25));
		panel.add(usernamelabel);
		//�����û�����ǩ

		JLabel passwordlabel = new JLabel("\u5BC6   \u7801\uFF1A");
		passwordlabel.setFont(new Font("��������", Font.BOLD, 25));
		passwordlabel.setBounds(119, 255, 104, 26);
		panel.add(passwordlabel);
		//���������ǩ

		usernametext = new JTextField();
		usernametext.setBounds(259, 153, 241, 41);
		panel.add(usernametext);
		usernametext.setColumns(10);
		//�����û����ı���

		JButton loginbutton = new JButton("��½");
		loginbutton.setBackground(new Color(255, 250, 205));
		loginbutton.setForeground(Color.BLACK);
		loginbutton.setFont(new Font("������κ", Font.PLAIN, 28));
		loginbutton.setBounds(176, 379, 104, 49);
		panel.add(loginbutton);
		//������¼��ť

		JButton resetbutton = new JButton("����");
		resetbutton.setBackground(new Color(255, 250, 205));
		resetbutton.setForeground(Color.BLACK);
		resetbutton.setFont(new Font("������κ", Font.PLAIN, 28));
		resetbutton.setBounds(422, 379, 104, 49);
		panel.add(resetbutton);
		//�������ð�ť
		
		JLabel sitetitlelabel = new JLabel("\u4E09\u5473\u4E66\u5C4B\u767B\u5F55\u7AEF");
		sitetitlelabel.setFont(new Font("��������", Font.BOLD, 50));
		sitetitlelabel.setBounds(159, 48, 367, 57);
		panel.add(sitetitlelabel);
		//������վ�����ǩ

		passwordtext = new JPasswordField();
		passwordtext.setBounds(259, 254, 241, 41);
		panel.add(passwordtext);
		//���������ı���

		JLabel usernamewarnlabel = new JLabel("");
		usernamewarnlabel.setForeground(new Color(255, 69, 0));
		usernamewarnlabel.setBounds(176, 204, 418, 28);
		panel.add(usernamewarnlabel);
		//�����û������뾯���ǩ

		JLabel passwordwarnlabel = new JLabel("");
		passwordwarnlabel.setForeground(new Color(255, 69, 0));
		passwordwarnlabel.setBounds(176, 313, 437, 28);
		panel.add(passwordwarnlabel);
		//�����������뾯���ǩ

		UserTextKeyListener utkl = new UserTextKeyListener(usernamewarnlabel, usernametext, "Login");
		usernametext.addKeyListener(utkl);
		//���������û����ļ��̼�������
		
		PasswordTextKeyListener ptkl = new PasswordTextKeyListener(passwordwarnlabel, passwordtext);
		passwordtext.addKeyListener(ptkl);
		//������������ļ��̼�������

		JLabel backgpiclabel = new JLabel("");
		backgpiclabel.setIcon(new ImageIcon(LoginView.class.getResource("/UserPackage/src/newimages/c.jpeg")));
		backgpiclabel.setBounds(0, 0, 680, 496);
		panel.add(backgpiclabel);
		//��������ͼƬ��ǩ

		resetbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernametext.setText("");
				passwordtext.setText("");
				usernametext.requestFocus();
			}
		});
		//�����ð�ť���м���,�������ı�������Ϊ��,��������ڵ�һ���û�����
		
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDaoImplement ud = new UserDaoImplement();
				String username = usernametext.getText();
				String password = String.valueOf(passwordtext.getPassword());
				if (ud.isLogin(username, password) && !("".equals(username)) && !("".equals(password))) {//�����û���¼����(isLogin),��¼��������true���ı�������淶ʱ
					JOptionPane.showMessageDialog(null, "��½�ɹ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);//����������ʾ�ɹ�
					new BuyView().setUsername(username);//��ȡ������û���
					new HomepageView().setUsername(username);//�������ȡ�û���
					
				} else {
					JOptionPane.showMessageDialog(null, "��½ʧ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);//������ʾʧ��
				}
			}
		});
		//�Ե�¼��ť���м���
		
	}
}
