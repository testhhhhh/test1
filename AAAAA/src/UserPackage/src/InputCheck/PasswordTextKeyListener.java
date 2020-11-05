package UserPackage.src.InputCheck;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class PasswordTextKeyListener extends KeyAdapter{
	private String password_str;
	private JLabel alert;
	private JPasswordField passwordText;

	public String getPassword_str() {
		return password_str;
	}

	public void setPassword_str(String password_str) {
		this.password_str = password_str;
	}
	public PasswordTextKeyListener(JLabel alert, JPasswordField passwordText) {
		super();
		this.alert = alert;
		this.passwordText = passwordText;
	}
	public void keyReleased(KeyEvent e) {
		password_str = String.valueOf(passwordText.getPassword());
		if(password_str.matches("^[[a-zA-Z0-9]+$ ]{6,20}")) {
			alert.setText("");
		}else {
			alert.setText("���������ʽΪӢ����ĸ�����֣��������ɴ��䣬�䳤��Ϊ6-20λ������������");
		}
	}
}
