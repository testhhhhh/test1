package alert;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class UsernametxtListener extends KeyAdapter {
private String username;
private JLabel alert;
private JTextField usernametxt;

/**
 * @wbp.parser.entryPoint
 */
public UsernametxtListener(JLabel alert, JTextField usernametxt) {
	super();
	this.alert = alert;
	this.usernametxt = usernametxt;
}

/**
 * @wbp.parser.entryPoint
 */
public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

/**
 * @wbp.parser.entryPoint
 */
public void keyReleased(KeyEvent e) {
	username=usernametxt.getText().trim();
	//�û����ж�
			String re="^[a-zA-Z0-9\u4e00-\u9fa5]{3,20}";
			if(!username.matches(re)) {
				alert.setText("��ʽΪ���ֻ���ĸ�����֣��䳤��Ϊ3-20λ");
				alert.getText();

			}else{alert.setText("");
}}
}
