package UserPackage.src.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import UserPackage.src.DaoImple.UserDaoImplement;
import UserPackage.src.Entity.User;
import UserPackage.src.InputCheck.CodeTextKeyListener;
import UserPackage.src.InputCheck.IsPasswordTextKeyListener;
import UserPackage.src.InputCheck.NameTextKeyListener;
import UserPackage.src.InputCheck.PasswordTextKeyListener;
import UserPackage.src.InputCheck.TelephoneTextKeyListener;
import UserPackage.src.InputCheck.UserTextKeyListener;

import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class RegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField usernametext;
	private JTextField nametext;
	private JTextField telephonetext;
	private JTextField codetext;
	private JPasswordField passwordtext;
	private JPasswordField ispasswordtext;

	/**
	 * Launch the application.
	 */
	public static void registerInit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView frame = new RegisterView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//����ע������ʼ������
	}

	/**
	 * Create the frame.
	 */
	public RegisterView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 726, 626);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
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

		usernametext = new JTextField();
		usernametext.setBounds(258, 79, 227, 28);
		panel.add(usernametext);
		usernametext.setColumns(10);
		//�����û����ı���

		JLabel username = new JLabel("\u7528\u6237\u540D\uFF1A");
		username.setForeground(Color.BLACK);
		username.setFont(new Font("��������", Font.BOLD, 22));
		username.setBackground(Color.PINK);
		username.setBounds(133, 74, 98, 28);
		panel.add(username);
		//�����û�����ǩ

		JLabel password = new JLabel("\u5BC6   \u7801\uFF1A");
		password.setForeground(Color.BLACK);
		password.setBackground(Color.BLACK);
		password.setFont(new Font("��������", Font.BOLD, 22));
		password.setBounds(133, 144, 100, 28);
		panel.add(password);
		//���������ǩ

		JButton registerbutton = new JButton("\u6CE8\u518C");
		registerbutton.setBackground(new Color(255, 250, 205));
		registerbutton.setForeground(Color.BLACK);
		registerbutton.setFont(new Font("������κ", Font.PLAIN, 28));
		registerbutton.setBounds(173, 507, 104, 37);
		panel.add(registerbutton);
		//����ע�ᰴť

		JButton resetbutton = new JButton("����");
		resetbutton.setBackground(new Color(255, 250, 205));
		resetbutton.setForeground(Color.BLACK);
		resetbutton.setFont(new Font("������κ", Font.PLAIN, 28));
		resetbutton.setBounds(439, 507, 104, 37);
		panel.add(resetbutton);
		//�������ð�ť

		JLabel ispassword = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		ispassword.setForeground(Color.BLACK);
		ispassword.setFont(new Font("��������", Font.BOLD, 22));
		ispassword.setBounds(123, 203, 122, 28);
		panel.add(ispassword);
		//����ȷ�������ǩ

		JLabel name = new JLabel("\u59D3   \u540D\uFF1A");
		name.setForeground(Color.BLACK);
		name.setFont(new Font("��������", Font.BOLD, 22));
		name.setBounds(133, 258, 89, 42);
		panel.add(name);
		//����������ǩ

		JLabel sex = new JLabel("\u6027   \u522B\uFF1A");
		sex.setForeground(Color.BLACK);
		sex.setFont(new Font("��������", Font.BOLD, 22));
		sex.setBounds(133, 333, 89, 37);
		panel.add(sex);
		//�����Ա��ǩ

		JLabel telephone = new JLabel("\u7535   \u8BDD\uFF1A");
		telephone.setForeground(Color.BLACK);
		telephone.setFont(new Font("��������", Font.BOLD, 22));
		telephone.setBounds(133, 380, 89, 28);
		panel.add(telephone);
		//�����绰�����ǩ

		nametext = new JTextField();
		nametext.setBounds(258, 270, 227, 28);
		panel.add(nametext);
		nametext.setColumns(10);
		//���������ı���

		telephonetext = new JTextField();
		telephonetext.setBounds(258, 380, 227, 28);
		panel.add(telephonetext);
		telephonetext.setColumns(10);
		//�����绰�����ı���

		codetext = new JTextField();
		codetext.setBounds(258, 447, 157, 28);
		panel.add(codetext);
		codetext.setColumns(10);
		//������֤���ı���

		JLabel registtitlelabel = new JLabel("\u4E09\u5473\u4E66\u5C4B\u6CE8\u518C");
		registtitlelabel.setIcon(new ImageIcon(RegisterView.class.getResource("/images/\u56FE\u4E66(1).png")));
		registtitlelabel.setFont(new Font("��������", Font.BOLD, 50));
		registtitlelabel.setBounds(173, 22, 370, 47);
		panel.add(registtitlelabel);
		//����ע���������ǩ

		JLabel codelabel = new JLabel("\u9A8C\u8BC1\u7801\uFF1A");
		codelabel.setFont(new Font("��������", Font.BOLD, 22));
		codelabel.setBounds(134, 442, 99, 28);
		panel.add(codelabel);
		//������֤���ǩ

		passwordtext = new JPasswordField();
		passwordtext.setBounds(258, 149, 227, 28);
		panel.add(passwordtext);
		//���������ı���

		ispasswordtext = new JPasswordField();
		ispasswordtext.setBounds(258, 208, 227, 28);
		panel.add(ispasswordtext);
		//����ȷ�������ı���

		JLabel codeshowlabel = new JLabel("");
		codeshowlabel.setBackground(new Color(255, 255, 255));
		codeshowlabel.setFont(new Font("�����п�", Font.PLAIN, 30));
		codeshowlabel.setForeground(new Color(0, 0, 0));
		codeshowlabel.setBounds(439, 431, 122, 28);
		panel.add(codeshowlabel);
		//������֤���ǩ

		JRadioButton manbutton = new JRadioButton("\u7537");
		manbutton.setFont(new Font("���Ŀ���", Font.PLAIN, 26));
		manbutton.setBounds(258, 336, 56, 28);
		panel.add(manbutton);
		//�����Ա��е�ѡ��ť

		JRadioButton womenbutton = new JRadioButton("\u5973");
		womenbutton.setFont(new Font("������κ", Font.PLAIN, 26));
		womenbutton.setBounds(346, 337, 61, 28);
		panel.add(womenbutton);
		//�����Ա�Ů��ѡ��ť

		JLabel usernamewarnlabel = new JLabel("");
		usernamewarnlabel.setForeground(new Color(255, 0, 0));
		usernamewarnlabel.setBounds(133, 112, 485, 22);
		panel.add(usernamewarnlabel);
		//�����û������뾯���ǩ

		JLabel passwordwarnlabel = new JLabel("");
		passwordwarnlabel.setForeground(Color.RED);
		passwordwarnlabel.setBounds(114, 182, 585, 22);
		panel.add(passwordwarnlabel);
		//�����������뾯���ǩ

		JLabel ispasswordwarnlabel = new JLabel("");
		ispasswordwarnlabel.setForeground(Color.RED);
		ispasswordwarnlabel.setBounds(258, 238, 139, 22);
		panel.add(ispasswordwarnlabel);
		//����ȷ���������뾯���ǩ

		JLabel namewarnlabel = new JLabel("");
		namewarnlabel.setForeground(Color.RED);
		namewarnlabel.setBounds(258, 308, 254, 22);
		panel.add(namewarnlabel);
		//�����������뾯���ǩ

		JLabel sexwarnlabel = new JLabel("");
		sexwarnlabel.setForeground(new Color(255, 0, 0));
		sexwarnlabel.setBounds(435, 333, 139, 28);
		panel.add(sexwarnlabel);
		//�����Ա�ѡ�񾯸��ǩ

		JLabel telephonewarnlabel = new JLabel("");
		telephonewarnlabel.setForeground(Color.RED);
		telephonewarnlabel.setBounds(258, 418, 98, 22);
		panel.add(telephonewarnlabel);		
		//�����绰�������뾯���ǩ

		JLabel codewarnlabel = new JLabel("");
		codewarnlabel.setForeground(Color.RED);
		codewarnlabel.setBounds(258, 475, 227, 22);
		panel.add(codewarnlabel);
		//������֤�����뾯���ǩ
		
        codeshowlabel.setText(String.valueOf((int) (Math.random() * 10000 + 1)));
        //�����Զ��������1~9999֮������������Ϊ��֤��
        
		JLabel backgroundipclabel = new JLabel("");
		backgroundipclabel.setIcon(new ImageIcon(RegisterView.class.getResource("/UserPackage/src/newimages/1.png")));
		backgroundipclabel.setBounds(0, 0, 711, 591);
		panel.add(backgroundipclabel);
		//����ע����汳��ͼƬ��ǩ
		
		

		ButtonGroup bg = new ButtonGroup();
		bg.add(manbutton);
		bg.add(womenbutton);
		//�����Ա���,����,Ů��ѡ��ť���������

		UserTextKeyListener utkl = new UserTextKeyListener(usernamewarnlabel, usernametext, "register");
		usernametext.addKeyListener(utkl);
		PasswordTextKeyListener ptkl = new PasswordTextKeyListener(passwordwarnlabel, passwordtext);
		passwordtext.addKeyListener(ptkl);
		IsPasswordTextKeyListener iptkl = new IsPasswordTextKeyListener(passwordtext, ispasswordwarnlabel,ispasswordtext);
		ispasswordtext.addKeyListener(iptkl);
		NameTextKeyListener ntkl = new NameTextKeyListener(namewarnlabel, nametext);
		nametext.addKeyListener(ntkl);
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
				nametext.setText("");
				bg.clearSelection();
				codetext.setText("");
				usernamewarnlabel.setText("");
				passwordwarnlabel.setText("");
				ispasswordwarnlabel.setText("");
				namewarnlabel.setText("");
				telephonewarnlabel.setText("");
				codewarnlabel.setText("");
				sexwarnlabel.setText("");
				usernametext.requestFocus();
			}
		});// ���ð�ť�ж�

		
		registerbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernametext.getText();
				String password = String.valueOf(passwordtext.getPassword());
				String ispassword = String.valueOf(ispasswordtext.getPassword());
				String name = nametext.getText();
				String sex = null;
				if (manbutton.isSelected()) {
					sex = "��";
				} else if (womenbutton.isSelected()) {
					sex = "Ů";
				} else {
					sexwarnlabel.setText("�Ա�ѡ���Ϊ��");
				}
				String telephone = telephonetext.getText();
				String code = codetext.getText();
				UserDaoImplement ud = new UserDaoImplement();
				if (code.equals(codeshowlabel.getText())) {
					if (ispassword.equals(password) && !("".equals(username)) && !("".equals(password))
							&& !("".equals(ispassword)) && !("".equals(name)) && !("".equals(sex))
							&& !("".equals(telephone)) && !("".equals(code)) && ("".equals(usernamewarnlabel.getText()))
							&& ("".equals(passwordwarnlabel.getText())) && "".equals(ispasswordwarnlabel.getText())
							&& "".equals(namewarnlabel.getText()) && "".equals(telephonewarnlabel.getText())) {
						if (ud.regist(new User(username, password, name, sex, telephone, Integer.valueOf(code))))
							JOptionPane.showMessageDialog(null, "ע��ɹ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "ע��ʧ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "��֤�����", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});// ע�ᰴť�ж�
	}
}
