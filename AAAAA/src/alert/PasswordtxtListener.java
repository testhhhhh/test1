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
	//真实姓名判断
	String password=this.passwordtxt.getText().trim();
	//密码判断
	String mm="^[[a-zA-Z0-9]+$ ]{6,20}";
	if(!password.matches(mm)) {
		alert.setText("格式为英文字母或数字，或者自由搭配，其长度为6-20位，请重新输入");
	}else {
		alert.setText("");
	}
	}
}
