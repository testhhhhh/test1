package alert;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PasswordtxtListener extends KeyAdapter {
private String password;
private JLabel alert;
private JTextField passwordtxt;
public PasswordtxtListener(JLabel alert, JTextField passwordtxt) {
	super();
	this.alert = alert;
	this.passwordtxt = passwordtxt;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public void keyReleased(KeyEvent e) {
	//��ʵ�����ж�
	String password=this.passwordtxt.getText().trim();
	//�����ж�
	String mm="^[[a-zA-Z0-9]+$ ]{6,20}";
	if(!password.matches(mm)) {
		alert.setText("��ʽΪӢ����ĸ�����֣��������ɴ��䣬�䳤��Ϊ6-20λ������������");
	}else {
		alert.setText("");
	}
	}
}
