package UserView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyView extends JFrame {

	private JPanel contentPane;
	private JTextField investmoneytextField;//��ֵ���
	private JLabel pricelabel;//�û���
    private JLabel userlabel;//�û���ʣ���
    private JLabel addtxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyView frame = new BuyView();
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
	public BuyView() {
		setTitle("\u8D2D\u4E70\u70B9\u5238");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u4EB2\u7231\u7684\u5BA2\u5B98\uFF1A");
		lblNewLabel.setBounds(159, 188, 218, 57);
		lblNewLabel.setIcon(new ImageIcon(BuyView.class.getResource("/images/\u4F1A\u5458(1).png")));
		lblNewLabel.setFont(new Font("΢���ź�", Font.BOLD, 30));
		
	    userlabel = new JLabel("New label");
		userlabel.setBounds(387, 194, 229, 38);
		
		JLabel lblNewLabel_2 = new JLabel("\u6240\u5269\u70B9\u5238\u6570\uFF1A");
		lblNewLabel_2.setBounds(159, 278, 218, 40);
		lblNewLabel_2.setIcon(new ImageIcon(BuyView.class.getResource("/images/\u94B1\u888B.png")));
		lblNewLabel_2.setFont(new Font("΢���ź�", Font.BOLD, 30));
		
		pricelabel = new JLabel("30000");
		pricelabel.setBounds(383, 278, 240, 40);
		
		JLabel lblNewLabel_4 = new JLabel("\u8F93\u5165\u5145\u503C\u91D1\u989D\uFF1A");
		lblNewLabel_4.setBounds(127, 360, 249, 40);
		lblNewLabel_4.setIcon(new ImageIcon(BuyView.class.getResource("/images/\u94B1\u888B(1).png")));
		lblNewLabel_4.setFont(new Font("΢���ź�", Font.BOLD, 30));
		
		investmoneytextField = new JTextField();
		investmoneytextField.setBounds(383, 364, 207, 39);
		investmoneytextField.setFont(new Font("΢���ź�", Font.PLAIN, 21));
		investmoneytextField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u5145\u503C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ema) {
				MoneyAdd(ema);
			}
		});
		btnNewButton.setBounds(282, 458, 154, 41);
		btnNewButton.setIcon(new ImageIcon(BuyView.class.getResource("/images/\u94B1\u888B\u5B50.png")));
		btnNewButton.setFont(new Font("΢���ź�", Font.PLAIN, 23));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(userlabel);
		contentPane.add(lblNewLabel_2);
		contentPane.add(pricelabel);
		contentPane.add(lblNewLabel_4);
		contentPane.add(investmoneytextField);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("\u4F60\u4E00\u6295\u6211\u4E00\u6295\uFF0C\u4F5C\u8005\u660E\u5929\u71AC\u51FA\u5934");
		lblNewLabel_5.setFont(new Font("΢���ź�", Font.BOLD, 22));
		lblNewLabel_5.setBounds(50, 21, 346, 38);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u8FD8\u5728\u72B9\u8C6B\u4EC0\u4E48\uFF0C\u8D2D\u4E70\u70B9\u5238\u4E3A\u559C\u6B22\u7684\u5C0F\u8BF4\u6253\u8D4F");
		lblNewLabel_6.setFont(new Font("΢���ź�", Font.BOLD, 23));
		lblNewLabel_6.setBounds(191, 69, 443, 28);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u5168\u6751\u90FD\u5728\u4F60\u7684\u6253\u8D4F");
		lblNewLabel_7.setFont(new Font("΢���ź�", Font.BOLD, 22));
		lblNewLabel_7.setBounds(50, 120, 212, 28);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\u636E\u8BF4\u597D\u770B\u7684\u4EBA\u90FD\u5145\u503C\u4E86");
		lblNewLabel_8.setFont(new Font("΢���ź�", Font.BOLD, 18));
		lblNewLabel_8.setBounds(319, 107, 207, 24);
		contentPane.add(lblNewLabel_8);
		
		addtxt = new JLabel("New label");
		addtxt.setBounds(46, 458, 90, 41);
		contentPane.add(addtxt);
	}

	
	//��ֵ����¼�����
	private void MoneyAdd(ActionEvent ema) {
		// TODO Auto-generated method stub
		String remain=this.pricelabel.getText();//��ʣ�����
		String money=this.investmoneytextField.getText();//��ֵ�����
		Double remainmoney=Double.parseDouble(remain);//��ʣ�����ת��double����
		Double chongzhimoney=Double.parseDouble(money);//��ֵ�����ת��double����
		Double add=remainmoney+chongzhimoney;//�ܽ��
		String add1=String.valueOf(add);
		//���������Ϊ��
		if(StringUtil.isEmpty(money)||add==remainmoney) {
			JOptionPane.showMessageDialog(null, "�������ֵ���");
			return;
		}
		if(add!=remainmoney) {
			JOptionPane.showMessageDialog(null, "��ֵ�ɹ�");
			this.addtxt.setText(add1);
			this.addtxt.getText();
			this.investmoneytextField.setText("");//��ճ�ֵ�ı���
			return;
		}
		
	}

}
