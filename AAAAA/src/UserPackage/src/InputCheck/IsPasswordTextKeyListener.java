package UserPackage.src.InputCheck;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class IsPasswordTextKeyListener extends KeyAdapter{
	private JPasswordField passwordText;
	private JLabel alert;
	private JPasswordField ispasswordText;

	public IsPasswordTextKeyListener(JPasswordField passwordText,JLabel alert, JPasswordField ispasswordText) {
		super();
		this.passwordText = passwordText;
		this.alert = alert;
		this.ispasswordText = ispasswordText;
	}
	public void keyReleased(KeyEvent e) {
		String ispassword_str = String.valueOf(ispasswordText.getPassword());
		String password_str = String.valueOf(passwordText.getPassword());
		if (ispassword_str.equals(password_str)) {
			alert.setText("");
		} else {
			alert.setText("两次输入的密码不同");
		}
	}
}
