package adminview;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import daoimplement.UserDaoImplement;
import entity.User;
import inputcheck.InputOrNot;
import inputcheck.PasswordTextKeyListener;
import inputcheck.TelephoneTextKeyListener;
import inputcheck.UserTextKeyListener;

import java.awt.Color;

public class UserAddInterFrm extends JFrame {
	private JTextField usernametext;
	private JPasswordField passwordtext;
	private JPasswordField ispasswordtext;
	private JTextField phonetext;
	private final ButtonGroup buttonGroup = new ButtonGroup();
    private JComboBox rightscomboBox;
    private jdbc.DLUtil dlutil=new jdbc.DLUtil();
    private UserDaoImplement usermangedao=new UserDaoImplement();
    private JTextField codetext;
    private JTextField recodetextField;
    private JButton codebutton;
    private JButton addbutton;
    private JLabel password_alert;
    private JTextField introducetext;

 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAddInterFrm frame = new UserAddInterFrm();
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
	public UserAddInterFrm() {
		
		getContentPane().setBackground(new Color(153, 204, 51));
		setTitle("\u6DFB\u52A0\u7528\u6237\u754C\u9762");
		setBounds(100, 100, 672, 729);
		
		JLabel usernamelabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		usernamelabel.setForeground(Color.WHITE);
		usernamelabel.setBounds(110, 24, 120, 32);
		usernamelabel.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u4F1A\u5458(1).png")));
		usernamelabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		
		usernametext = new JTextField();
		usernametext.setBounds(248, 29, 268, 32);
		usernametext.setColumns(10);
		
		JLabel passwordlabel = new JLabel("\u5BC6\u7801\uFF1A");
		passwordlabel.setForeground(Color.WHITE);
		passwordlabel.setBounds(133, 95, 96, 32);
		passwordlabel.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u5BC6\u7801(1).png")));
		passwordlabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		
		passwordtext = new JPasswordField();
		passwordtext.setBounds(248, 100, 268, 32);
		
		JLabel ispasswordlabel = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		ispasswordlabel.setForeground(Color.WHITE);
		ispasswordlabel.setBounds(94, 170, 136, 32);
		ispasswordlabel.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC,\u7B11\u8138.png")));
		ispasswordlabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		
		ispasswordtext = new JPasswordField();
		ispasswordtext.setBounds(248, 170, 268, 32);
		
		JLabel phonelabel = new JLabel("\u7528\u6237\u7535\u8BDD\uFF1A");
		phonelabel.setForeground(SystemColor.text);
		phonelabel.setBounds(94, 237, 136, 32);
		phonelabel.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u7535\u8BDD(1).png")));
		phonelabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		
		phonetext = new JTextField();
		phonetext.setBounds(248, 243, 268, 29);
		phonetext.setColumns(10);
		
		JLabel rightslabel = new JLabel("\u7528\u6237\u72B6\u6001\uFF1A");
		rightslabel.setForeground(SystemColor.text);
		rightslabel.setBounds(94, 300, 144, 32);
		rightslabel.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u72B6\u6001.png")));
		rightslabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		
	    rightscomboBox = new JComboBox();
	    rightscomboBox.setBackground(SystemColor.info);
		rightscomboBox.setBounds(248, 301, 269, 32);
		rightscomboBox.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		rightscomboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7CFB\u7EDF\u7BA1\u7406\u5458", "\u7528\u6237"}));
		
		addbutton = new JButton("\u6DFB\u52A0");
		addbutton.setBackground(SystemColor.info);
		addbutton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
				UserAdd(evt);
			}

		});
	

		
		addbutton.setBounds(90, 606, 136, 41);
		addbutton.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u786E\u8BA4.png")));
		addbutton.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		
		JButton rescorebutton = new JButton("\u91CD\u7F6E");
		rescorebutton.setBackground(SystemColor.info);
		rescorebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reSetValue(e);
			}
		});
		rescorebutton.setBounds(395, 606, 131, 41);
		rescorebutton.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		rescorebutton.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		getContentPane().setLayout(null);
		getContentPane().add(ispasswordlabel);
		getContentPane().add(passwordlabel);
		getContentPane().add(usernamelabel);
		getContentPane().add(phonelabel);
		getContentPane().add(phonetext);
		getContentPane().add(ispasswordtext);
		getContentPane().add(usernametext);
		getContentPane().add(passwordtext);
		getContentPane().add(rightslabel);
		getContentPane().add(rightscomboBox);
		getContentPane().add(addbutton);
		getContentPane().add(rescorebutton);
		
		JLabel codelabel = new JLabel("\u9A8C\u8BC1\u7801\uFF1A");
		codelabel.setForeground(SystemColor.text);
		codelabel.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u9A8C\u8BC1\u7801(1).png")));
		codelabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		codelabel.setBounds(110, 505, 116, 32);
		getContentPane().add(codelabel);
		
		codetext = new JTextField();
		codetext.setBounds(248, 505, 150, 41);
		getContentPane().add(codetext);
		codetext.setColumns(10);
		
		recodetextField = new JTextField();
		recodetextField.setBackground(SystemColor.info);
		int n=(int)Math.round((Math.random()*9+1)*100000);
		String shengchengcode=String.valueOf(n);//��������ת���ַ�������
		this.recodetextField.setText(shengchengcode);//��ȡ��֤������
		this.recodetextField.getText();

		
		recodetextField.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		recodetextField.setEditable(false);
		recodetextField.setBounds(440, 501, 140, 41);
		getContentPane().add(recodetextField);
		recodetextField.setColumns(10);
		
		codebutton = new JButton("\u70B9\u51FB\u83B7\u53D6\u9A8C\u8BC1\u7801");
		codebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ek) {
				CodeClick(ek);
			}
		});
		codebutton.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/images/\u5BC6\u7801.png")));
		codebutton.setFont(new Font("΢���ź�", Font.BOLD, 12));
		codebutton.setBounds(440, 552, 140, 23);
		getContentPane().add(codebutton);
		
		//�û������ǩ
		JLabel username_alert = new JLabel("");
		username_alert.setFont(new Font("����", Font.BOLD, 12));
		username_alert.setForeground(Color.YELLOW);
		username_alert.setBackground(SystemColor.scrollbar);
		username_alert.setBounds(255, 75, 261, 15);
		getContentPane().add(username_alert);
		
		
		//�û��������ǩ��ʾ
		UserTextKeyListener ul=new UserTextKeyListener(username_alert,usernametext,"register");
		this.usernametext.addKeyListener(ul);
		
		
		JLabel password_alert = new JLabel("");
		password_alert.setForeground(Color.YELLOW);
		password_alert.setBounds(248, 145, 400, 15);
		getContentPane().add(password_alert);
		
		
		//������֤�����ǩ
		 PasswordTextKeyListener pl=new  PasswordTextKeyListener(password_alert,passwordtext);
		 this.passwordtext.addKeyListener(pl);
	
		
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setForeground(Color.YELLOW);
		lblNewLabel_8.setBounds(258, 142, 332, 15);
		getContentPane().add(lblNewLabel_8);
		
		JLabel repassword_alert = new JLabel("");
		repassword_alert.setForeground(Color.YELLOW);
		repassword_alert.setBounds(248, 212, 299, 15);
		getContentPane().add(repassword_alert);
		
		//ȷ�����뾯���ǩ
		PasswordTextKeyListener rl=new PasswordTextKeyListener(repassword_alert,ispasswordtext);
		this.ispasswordtext.addKeyListener(rl);
		
		
		JLabel telephone_alert = new JLabel("");
		telephone_alert.setForeground(Color.YELLOW);
		telephone_alert.setBounds(258, 271, 261, 23);
		getContentPane().add(telephone_alert);
		
		TelephoneTextKeyListener tl=new TelephoneTextKeyListener(telephone_alert,phonetext);
		
		JLabel introducelabel = new JLabel("\u7528\u6237\u7B80\u4ECB\uFF1A");
		introducelabel.setForeground(Color.WHITE);
		introducelabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		introducelabel.setBounds(94, 411, 109, 32);
		getContentPane().add(introducelabel);
		
		introducetext = new JTextField();
		introducetext.setColumns(10);
		introducetext.setBounds(240, 376, 340, 98);
		getContentPane().add(introducetext);
		
		JLabel picturelabel = new JLabel("");
		picturelabel.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710215623.png")));
		picturelabel.setBounds(0, 0, 658, 692);
		getContentPane().add(picturelabel);
		this.phonetext.addKeyListener(tl);
	}
	


	//�����ȡ��֤���¼�
	private void CodeClick(ActionEvent ek) {
		// TODO Auto-generated method stub
		int n=(int)Math.round((Math.random()*9+1)*100000);
		String shengchengcode=String.valueOf(n);//��������ת���ַ�������
		this.recodetextField.setText(shengchengcode);//��ȡ��֤������
		this.recodetextField.getText();
	}

	//�û�����¼�����
	private void UserAdd(ActionEvent evt) {
		// TODO Auto-generated method stub
		String username=this.usernametext.getText();//�û���
		String password=new String(this.passwordtext.getPassword());//��ȡ����
		String resurepassword=new String(this.ispasswordtext.getPassword());//��ȡȷ������
		String telephone=this.phonetext.getText();//�绰
		String code=this.codetext.getText();//��֤��
		
		if(InputOrNot.isEmpty(username)) {
			JOptionPane.showMessageDialog(null,"�û�������Ϊ��");
			return;
		}
		//�û����ж�
				String re="^[a-zA-Z0-9\u4e00-\u9fa5]{3,20}";
				if(!username.matches(re)) {
				JOptionPane.showMessageDialog(null,"�û��������ʽΪ���ֻ���ĸ�����֣��������ɴ��䣬�䳤��Ϊ3-20λ������������");
					this.usernametext.setText("");
					return;	
				}
				if(InputOrNot.isEmpty(password)) {
					JOptionPane.showMessageDialog(null,"���벻��Ϊ��");
					return;
				}
				
				
				//�����ж�
				String mm="^[[a-zA-Z0-9]+$ ]{6,20}";
				if(!password.matches(mm)) {
					JOptionPane.showMessageDialog(null,"���������ʽΪӢ����ĸ�����֣��������ɴ��䣬�䳤��Ϊ6-20λ������������");
					this.passwordtext.setText("");
					return;	
				}
				
	
		if(InputOrNot.isEmpty(resurepassword)) {
			JOptionPane.showMessageDialog(null,"������ȷ������");
			return;
		}
		
		
		//�������������ж�	
		String passwordsure = null;
		if(password.equals(resurepassword)) {
			passwordsure=password;
		}else {
			JOptionPane.showMessageDialog(null,"�����������벻���ϣ���������һ��");
			this.passwordtext.setText("");
			this.ispasswordtext.setText("");
			return;
		}
		
		
		if(InputOrNot.isEmpty(telephone)) {
			JOptionPane.showMessageDialog(null,"�绰����Ϊ��");
			return;
		}
		
		//�绰��ʽ�ж�
				String zhengze="^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
				if(!telephone.matches(zhengze)) {
					JOptionPane.showMessageDialog(null,"�绰��ʽ��������������");
					this.phonetext.setText("");
					return;
				}

		if(InputOrNot.isEmpty(code)) {
			JOptionPane.showMessageDialog(null,"��������֤��");
			return;
		}
		
		
		//������֤��
		String shengchengcode=this.recodetextField.getText().trim();
		if(!code.equals(shengchengcode)) {
			JOptionPane.showMessageDialog(null, "��֤��������������������");
           return;
		}
		
		//����ʽ�ж�
		String mmm="^[a-zA-Z0-9\\u4e00-\\u9fa5]{3,500}";
		if(!introducetext.getText().matches(mmm)) {
			JOptionPane.showMessageDialog(null,"��������ʽΪ����Ϊ3-500λ������������");
			this.introducetext.setText("");
			return;	
		}
		

         if(InputOrNot.isEmpty(introducetext.getText())) {
	        JOptionPane.showMessageDialog(null,"��������");
	        return;
        } 
         String state="0";
        if("ϵͳ����Ա".equals(rightscomboBox.getSelectedItem())) {
        	state="2";
        }else {
        	state="1";
        }
		 
	
		
		//��װ�û�ʵ��
		User user=new User(0,username, password, telephone, Integer.valueOf(state), code,introducetext.getText());
		
		//�������ݿ�
		Connection conn=null;
		try {
			conn=dlutil.getCon();//�������ݿ�
			int addNum=usermangedao.add(conn, user);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null,"�û���ӳɹ�");
				reSetValue(evt);
			}else {
				JOptionPane.showMessageDialog(null,"�û����ʧ��");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"�û����ʧ��");
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
	private void reSetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		this.usernametext.setText("");
		this.passwordtext.setText("");
		this.ispasswordtext.setText("");
		this.phonetext.setText("");
		this.recodetextField.setText("");
		this.codetext.setText("");
		this.introducetext.setText("");
		this.rightscomboBox.setSelectedIndex(0);//���û�״̬��Ĭ��ѡ���һ��
	}
}
