package adminview;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import daoimplement.UserDaoImplement;
import entity.User;
import inputcheck.InputOrNot;

public class UserMangeInterFrm extends JFrame {
	private JTable usertable;
	private JTextField usernametext;
    private jdbc.DLUtil dlutil=new jdbc.DLUtil();
//    private UserMangeInterFrm usermangedao=new UserMangeInterFrm();
    public int x=Toolkit.getDefaultToolkit().getScreenSize().width;
 	public int y=Toolkit.getDefaultToolkit().getScreenSize().height;
 	public int windowwidth=1520;
 	public int windowheight=770;
 	private JComboBox rightstxt;
 	private JTextField usernametxt;
 	private JTextField idtxt;
 	private JPasswordField passwordfield;
 	private JPasswordField statustext;
 	private JTextField phonetext;
 	private JTextField introducetext;
	/**
	 * Launch the application.
	 */
	public static void UserMangeInterFrmInit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMangeInterFrm frame = new UserMangeInterFrm();
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
	public UserMangeInterFrm() {
		getContentPane().setBackground(new Color(72, 209, 204));
		setTitle("\u7528\u6237\u7BA1\u7406");
		setBounds((x-windowwidth)/2, (y-windowheight)/2, 1400, 770);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel searchpanel = new JPanel();
		searchpanel.setBackground(new Color(72, 209, 204));
		searchpanel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6846", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel changepanel = new JPanel();
		changepanel.setBackground(new Color(72, 209, 204));
		changepanel.setBorder(new TitledBorder(null, "\u4FEE\u6539\u6846", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(30, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1193, GroupLayout.PREFERRED_SIZE)
							.addGap(102))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(searchpanel, GroupLayout.PREFERRED_SIZE, 1311, GroupLayout.PREFERRED_SIZE)
							.addGap(47))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(changepanel, GroupLayout.PREFERRED_SIZE, 1256, GroupLayout.PREFERRED_SIZE)
							.addGap(58))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(searchpanel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(changepanel, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_4 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_4.setForeground(SystemColor.text);
		lblNewLabel_4.setBounds(415, 41, 128, 32);
		lblNewLabel_4.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u4F1A\u5458(1).png")));
		lblNewLabel_4.setFont(new Font("΢���ź�", Font.BOLD, 20));
		
		usernametxt = new JTextField();
		usernametxt.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		usernametxt.setBounds(553, 44, 170, 35);
		usernametxt.setColumns(10);
		
		JLabel userchangeidlabel = new JLabel("\u7F16\u53F7\uFF1A");
		userchangeidlabel.setForeground(SystemColor.text);
		userchangeidlabel.setBounds(58, 44, 105, 32);
		userchangeidlabel.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u7F16\u53F7.png")));
		userchangeidlabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		
		idtxt = new JTextField();
		idtxt.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		idtxt.setBounds(180, 41, 112, 40);
		idtxt.setEnabled(false);
		idtxt.setColumns(10);
		
		JLabel passwordlabel = new JLabel("\u7528\u6237\u5BC6\u7801\uFF1A");
		passwordlabel.setForeground(SystemColor.text);
		passwordlabel.setBounds(22, 105, 148, 32);
		passwordlabel.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u5BC6\u7801(1).png")));
		passwordlabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		
		passwordfield = new JPasswordField();
		passwordfield.setBounds(180, 102, 154, 35);
		
		JLabel statuslabel = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		statuslabel.setForeground(SystemColor.text);
		statuslabel.setBounds(395, 103, 161, 32);
		statuslabel.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u786E\u8BA4.png")));
		statuslabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		
		statustext = new JPasswordField();
		statustext.setBounds(553, 103, 170, 33);
		
		JLabel intorducelabel = new JLabel("\u7528\u6237\u4ECB\u7ECD\uFF1A");
		intorducelabel.setForeground(SystemColor.text);
		intorducelabel.setBounds(22, 195, 161, 32);
		intorducelabel.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u8BC4\u8BBA(3).png")));
		intorducelabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		
		JButton changebutton = new JButton("\u4FEE\u6539");
		changebutton.setBackground(new Color(255, 255, 240));
		changebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent euu) {
				UserUpadte(euu);
			}
		});
		changebutton.setBounds(999, 129, 144, 41);
		changebutton.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u4FEE\u6539.png")));
		changebutton.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		
		JButton deletebutton = new JButton("\u5220\u9664");
		deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ed) {
				UserDelete(ed);
			}
		});
		deletebutton.setBounds(1004, 207, 139, 41);
		deletebutton.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u5220\u9664(3).png")));
		deletebutton.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		changepanel.setLayout(null);
		changepanel.add(passwordfield);
		changepanel.add(statuslabel);
		changepanel.add(statustext);
		changepanel.add(intorducelabel);
		changepanel.add(changebutton);
		changepanel.add(deletebutton);
		changepanel.add(userchangeidlabel);
		changepanel.add(idtxt);
		changepanel.add(lblNewLabel_4);
		changepanel.add(usernametxt);
		changepanel.add(passwordlabel);
		
		JLabel phonelabel = new JLabel("\u7528\u6237\u7535\u8BDD\uFF1A");
		phonelabel.setForeground(SystemColor.text);
		phonelabel.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u7535\u8BDD(1).png")));
		phonelabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		phonelabel.setBounds(812, 43, 143, 35);
		changepanel.add(phonelabel);
		
		phonetext = new JTextField();
		phonetext.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		phonetext.setBounds(987, 45, 170, 32);
		changepanel.add(phonetext);
		phonetext.setColumns(10);
		
		introducetext = new JTextField();
		introducetext.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		introducetext.setBounds(180, 170, 731, 84);
		changepanel.add(introducetext);
		introducetext.setColumns(10);
		
		JLabel picturelabel = new JLabel("");
		picturelabel.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/png/\u5FAE\u4FE1\u56FE\u7247_20200710215623.png")));
		picturelabel.setBounds(0, 0, 1256, 281);
		changepanel.add(picturelabel);
		
		JLabel usernamelabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		usernamelabel.setBounds(195, 49, 110, 24);
		usernamelabel.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u4F1A\u5458(1).png")));
		usernamelabel.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		
		usernametext = new JTextField();
		usernametext.setBounds(296, 49, 183, 33);
		usernametext.setColumns(10);
		searchpanel.setLayout(null);
		searchpanel.add(usernamelabel);
		searchpanel.add(usernametext);
		
		JLabel rightslabel = new JLabel("\u7528\u6237\u72B6\u6001\uFF1A");
		rightslabel.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u72B6\u6001.png")));
		rightslabel.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		rightslabel.setBounds(515, 50, 132, 24);
		searchpanel.add(rightslabel);
		
		JButton searchbutton = new JButton("\u67E5\u8BE2");
		searchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtt) {
		     userSearch(evtt);
			}
		});
		searchbutton.setIcon(new ImageIcon(UserMangeInterFrm.class.getResource("/images/\u67E5\u8BE2(3).png")));
		searchbutton.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		searchbutton.setBounds(891, 41, 121, 41);
		searchpanel.add(searchbutton);
		
		rightstxt = new JComboBox();
		rightstxt.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		rightstxt.setModel(new DefaultComboBoxModel(new String[] {"δѡ��","\u7BA1\u7406\u5458", "\u7528\u6237"}));
		rightstxt.setBounds(628, 49, 121, 27);
		searchpanel.add(rightstxt);
		
		usertable = new JTable();
		usertable.setBackground(new Color(216, 191, 216));
		usertable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserTbaleMouseAction(e);
			}
		});
		usertable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u7528\u6237\u540D", "\u7528\u6237\u5BC6\u7801", "�绰", "��ɫ","��֤��", "����"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false,false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(usertable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new User());//���������

	}
	
	
	//ɾ���û���Ϣ
	private void UserDelete(ActionEvent ed) {
		// TODO Auto-generated method stub
		String id=idtxt.getText();
		if(InputOrNot.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���ļ�¼");
			return;	
		}
		int n=JOptionPane.showConfirmDialog(null,"ȷ��Ҫɾ��������¼��");
		if(n==0) {
			Connection conn=null;
			try {
				conn=dlutil.getCon();
				int deleteNum=new UserDaoImplement().delete(conn, Integer.valueOf(id));
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");	
					reSetValue();//��������
					this.fillTable(new User());//���±������
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

	//���������¼�
	private void UserTbaleMouseAction(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=this.usertable.getSelectedRow();//��ȡ����
		//��ȡ�е�����
		this.idtxt.setText((String)usertable.getValueAt(row, 0));//���
		this.usernametxt.setText((String)usertable.getValueAt(row, 1));//�û���
		this.passwordfield.setText((String)usertable.getValueAt(row, 2));//����
		this.phonetext.setText((String)usertable.getValueAt(row, 3));//�绰
		this.rightstxt.setToolTipText((String) usertable.getValueAt(row, 4));//��ɫ
		this.introducetext.setText((String) usertable.getValueAt(row,5));//����	
	}

	//�޸��û���Ϣ
	private void UserUpadte(ActionEvent euu) {
		// TODO Auto-generated method stub
		//��ȡ�û�������Ϣ
		String id=this.idtxt.getText();
		if(InputOrNot.isEmpty(id)) {
			JOptionPane.showMessageDialog(null,"��ѡ��Ҫ�޸ĵļ�¼");
			return;
		}
		String username=this.usernametxt.getText();
		String password=new String(this.passwordfield.getPassword());
		String repassword=new String(this.statustext.getPassword());
		String introduce= this.introducetext.getText();
		String telephone=this.phonetext.getText();
		String state=(String)this.rightstxt.getToolTipText();
		if(InputOrNot.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼");
			return;
		}
		if(InputOrNot.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
			return;
		}
		if(InputOrNot.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
			return;
		}
		if(InputOrNot.isEmpty(repassword)) {
			JOptionPane.showMessageDialog(null, "ȷ�����벻��Ϊ��");
			return;
		}
		if(InputOrNot.isEmpty(telephone)) {
			JOptionPane.showMessageDialog(null, "�û��绰����Ϊ��");
			return;
		}
		if(InputOrNot.isEmpty(introduce)) {
			JOptionPane.showMessageDialog(null, "�û���鲻��Ϊ��");
			return;
		}
		if(InputOrNot.isEmpty(state)) {
			JOptionPane.showMessageDialog(null, "�û�״̬����Ϊ��");
			return;
		}
		if(!password.equals(repassword)) {
			JOptionPane.showMessageDialog(null, "�����������벻һ�£�����������");
			return;
		}
	 
		//ע������������������Ϊ���ݿ������userid��int���ͣ����ҵ�id��String���ͣ�û�н���ת�����³������������integer.parseInt(id)ǿ��ת��int��
		User user=new User(Integer.valueOf(id),username,password,telephone, Integer.valueOf(state),"0",introduce);
			Connection conn=null;
	
		try {
			conn=dlutil.getCon();//��ȡ����	
			int modifyNum=new UserDaoImplement().update(conn, user);
			if(modifyNum==1) {
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				this.reSetValue();//��������
				this.fillTable(new User());//ˢ�±������
			}
			else {
				JOptionPane.showMessageDialog(null, "�޸�ʧ��");
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
	

	//�������
	private void reSetValue() {
		// TODO Auto-generated method stub
		this.idtxt.setText("");
		this.usernametxt.setText("");
		this.passwordfield.setText("");
		this.statustext.setText("");
		this.phonetext.setText("");
		this.introducetext.setText("");
		this.rightstxt.setToolTipText("");
	}

	//�û���ѯ����
	private void userSearch(ActionEvent evtt) {
		// TODO Auto-generated method stub
		//��ȡ��ѯ�Ĳ���
		String username=this.usernametext.getText();
		String rights= (String)this.rightstxt.getSelectedItem();
		int right=0;
		if("����Ա".equals(rights)) {
			right=2;
		}
		else if("�û�".equals(rights)){
			right=1;
		}
        //��װʵ�����
        User user=new User(username,right);
        //���ñ������
        this.fillTable(user);
        //��ѯ�������ı���
        usernametext.setText("");
        rightstxt.setSelectedIndex(0);
	}

	
	//��ʼ���������
	private void fillTable(User user) {
		DefaultTableModel dtm=(DefaultTableModel) usertable.getModel();//���model�����г�ʼ��
		dtm.setRowCount(0);//���ó�0�У���ձ��
		Connection conn=null;
		try {
			conn=dlutil.getCon();//��ȡ���ݿ�����
			ResultSet rs=new UserDaoImplement().list(conn, user);
			//�ü��Ͻ��б���
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("userid"));
				v.add(rs.getString("username"));
				v.add(rs.getString("password"));
				v.add(rs.getString("phone"));
				v.add(rs.getString("rights"));
				v.add(rs.getString("code"));
				v.add(rs.getString("userintroduce"));
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
}
