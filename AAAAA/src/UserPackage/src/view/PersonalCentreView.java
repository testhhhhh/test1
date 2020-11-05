package UserPackage.src.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UserPackage.src.DaoImple.UserDaoImplement;
import UserPackage.src.Entity.User;
import UserPackage.src.InputCheck.CodeTextKeyListener;
import UserPackage.src.InputCheck.IsPasswordTextKeyListener;
import UserPackage.src.InputCheck.NameTextKeyListener;
import UserPackage.src.InputCheck.PasswordTextKeyListener;
import UserPackage.src.InputCheck.TelephoneTextKeyListener;
import UserPackage.src.InputCheck.UserTextKeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JTextField nametext;
	private JTextField telephonetext;

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
		returnbutton.setBackground(new Color(255, 255, 204));
		returnbutton.setFont(new Font("��������", Font.BOLD, 35));
		returnbutton.setBounds(727, 31, 210, 49);
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
		//����ȷ�������ı���

		JLabel namelabel = new JLabel("\u59D3\u540D\uFF1A");
		namelabel.setForeground(new Color(255, 255, 0));
		namelabel.setFont(new Font("��������", Font.BOLD, 30));
		namelabel.setBounds(336, 350, 97, 35);
		contentPane.add(namelabel);
		//����������ǩ

		nametext = new JTextField();
		nametext.setBounds(446, 355, 283, 30);
		contentPane.add(nametext);
		nametext.setColumns(10);
		//���������ı���

		JLabel sexlabel = new JLabel("\u6027\u522B\uFF1A");
		sexlabel.setForeground(new Color(255, 255, 0));
		sexlabel.setFont(new Font("��������", Font.BOLD, 30));
		sexlabel.setBounds(336, 433, 100, 35);
		contentPane.add(sexlabel);
		//�����Ա��ǩ

		JLabel telephonelabel = new JLabel("\u7535\u8BDD\uFF1A");
		telephonelabel.setForeground(new Color(255, 255, 0));
		telephonelabel.setFont(new Font("��������", Font.BOLD, 30));
		telephonelabel.setBounds(336, 504, 100, 35);
		contentPane.add(telephonelabel);
		//�����绰�����ǩ

		telephonetext = new JTextField();
		telephonetext.setBounds(446, 509, 283, 30);
		contentPane.add(telephonetext);
		telephonetext.setColumns(10);
		//�����绰�����ı���

		JButton okbutton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		okbutton.setBackground(new Color(255, 255, 204));
		okbutton.setFont(new Font("������κ", Font.BOLD, 30));
		okbutton.setBounds(772, 549, 186, 41);
		contentPane.add(okbutton);
		//����ȷ�ϰ�ť

		UserDaoImplement ud = new UserDaoImplement();//�����û�Daoʵ�������
		idlabel.setText(String.valueOf(ud.userid));//����id��ǩ�ı�Ϊuserid

		JRadioButton manbutton = new JRadioButton("\u7537");
		manbutton.setBackground(new Color(255, 204, 153));
		manbutton.setFont(new Font("��������", Font.PLAIN, 30));
		manbutton.setBounds(443, 433, 73, 35);
		contentPane.add(manbutton);
		//�����Ա��е�ѡ��ť

		JRadioButton womenbutton = new JRadioButton("\u5973");
		womenbutton.setBackground(new Color(255, 204, 153));
		womenbutton.setFont(new Font("������κ", Font.PLAIN, 30));
		womenbutton.setBounds(565, 433, 73, 35);
		contentPane.add(womenbutton);
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
		//����ȷ���������뾯���ǩ

		JLabel namewarnlabel = new JLabel("");
		namewarnlabel.setForeground(Color.RED);
		namewarnlabel.setBounds(396, 395, 376, 16);
		contentPane.add(namewarnlabel);
		//�����������뾯���ǩ

		JLabel sexwarnlabel = new JLabel("");
		sexwarnlabel.setForeground(new Color(255, 255, 51));
		sexwarnlabel.setBounds(396, 478, 376, 16);
		contentPane.add(sexwarnlabel);
		//�����Ա����뾯���ǩ

		JLabel telephonewarnlabel = new JLabel("");
		telephonewarnlabel.setForeground(Color.RED);
		telephonewarnlabel.setBounds(396, 549, 376, 16);
		contentPane.add(telephonewarnlabel);
		//�������汳��ͼƬ��ǩ

		ButtonGroup bg = new ButtonGroup();
		bg.add(manbutton);
		bg.add(womenbutton);
		//�����Ա���,����Ů��ѡ��ť�������

		UserTextKeyListener utkl = new UserTextKeyListener(usernamewarnlabel, usernametext, "register");
		usernametext.addKeyListener(utkl);
		PasswordTextKeyListener ptkl = new PasswordTextKeyListener(passwordwarnlabel, passwordtext);
		passwordtext.addKeyListener(ptkl);
		IsPasswordTextKeyListener iptkl = new IsPasswordTextKeyListener(passwordtext, ispasswordwarnlabel,ispasswordtext);
		ispasswordtext.addKeyListener(iptkl);
		NameTextKeyListener ntkl = new NameTextKeyListener(namewarnlabel, nametext);
		nametext.addKeyListener(ntkl);
		TelephoneTextKeyListener ttkl = new TelephoneTextKeyListener(telephonewarnlabel, telephonetext);
		
		JLabel lblNewLabel = new JLabel("\u8DDF\u8FC7\u53BB\u7684\u81EA\u5DF1\u8BF4\u518D\u89C1\uFF0C\u6539\u5934\u6362\u9762");
		lblNewLabel.setFont(new Font("������κ", Font.BOLD, 35));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(10, 34, 518, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PersonalCentreView.class.getResource("/png/16b97aa2804187bdcb2892aa6d6c7ec.png")));
		lblNewLabel_1.setBounds(0, 0, 999, 651);
		contentPane.add(lblNewLabel_1);
		telephonetext.addKeyListener(ttkl);

		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernametext.getText();
				String password = String.valueOf(passwordtext.getPassword());
				String ispassword = String.valueOf(ispasswordtext.getPassword());
				String name = nametext.getText();
				String sex = null;
				if (manbutton.isSelected()) {
					sexwarnlabel.setText("");
					sex = "��";
				} else if (womenbutton.isSelected()) {
					sexwarnlabel.setText("");
					sex = "Ů";
				} else {
					sexwarnlabel.setText("�Ա�ѡ���Ϊ��");
				}
				String telephone = telephonetext.getText();
				if (ispassword.equals(password) && !("".equals(username)) && !("".equals(password))
						&& !("".equals(ispassword)) && !("".equals(name)) && !("".equals(sex))
						&& !("".equals(telephone)) && ("".equals(usernamewarnlabel.getText()))
						&& "".equals(passwordwarnlabel.getText()) && "".equals(ispasswordwarnlabel.getText())
						&& "".equals(namewarnlabel.getText()) && "".equals(telephonewarnlabel.getText())
						&& "".equals(sexwarnlabel.getText())) {
					if (ud.personalchange(username, ispassword, name, sex, telephone) && ud.isRegisted(username))
						JOptionPane.showMessageDialog(null, "�޸ĳɹ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "�޸�ʧ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}
}
