package alert;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ResurePasswordtxtListener extends KeyAdapter {
private String password;
private String repassword;
private JLabel alert;
private JTextField passwordtxt;
private JTextField repasswordtxt;
public ResurePasswordtxtListener(JLabel alert, JTextField passwordtxt, JTextField repasswordtxt) {
	super();
	this.alert = alert;
	this.passwordtxt = passwordtxt;
	this.repasswordtxt = repasswordtxt;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public JTextField getPasswordtxt() {
	return passwordtxt;
}
public void setPasswordtxt(JTextField passwordtxt) {
	this.passwordtxt = passwordtxt;
}
//两次输入密码判断
public void keyReleased(KeyEvent e) {
		String repassword=this.repasswordtxt.getText().trim();
		String password=this.passwordtxt.getText().trim();
	String passwordsure = null;
	if(password.equals(repassword)) {
		alert.setText("");
	}else {
		alert.setText("两次密码输入不符合，请再输入一次");
	
	}
	}
}
