package UserPackage.src.InputCheck;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import UserPackage.src.DaoImple.UserDaoImplement;

public class UserTextKeyListener extends KeyAdapter{
	private String userText_str;
	private JLabel alert;
	private JTextField userText;
	private String way;

	public String getUserText_str() {
		return userText_str;
	}

	public void setUserText_str(String userText_str) {
		this.userText_str = userText_str;
	}
	public UserTextKeyListener(JLabel alert, JTextField userText, String way) {
		super();
		this.alert = alert;
		this.userText = userText;
		this.way = way;
	}
	public void keyReleased(KeyEvent e) {
		userText_str = userText.getText().trim();
		if (userText_str.matches("^[a-zA-Z0-9\\u4e00-\\u9fa5]{3,20}")) {
			if (way.equals("register") && new UserDaoImplement().isRegisted(userText_str)) {
				alert.setText("�û����Ѿ�����");
			} 
			else {
				alert.setText("");
			}
		} else {
			alert.setText("�û��������ʽΪ���ֻ���ĸ�����֣��������ɴ��䣬�䳤��Ϊ3-20λ");
		}

	}
}
