package UserPackage.src.InputCheck;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChapternameTextKeyListener extends KeyAdapter{
	private String chaptername_str;
	private JLabel alert;
	private JTextField chapternameText;
	public String getChaptername_str() {
		return chaptername_str;
	}
	public void setChaptername_str(String chaptername_str) {
		this.chaptername_str = chaptername_str;
	}
	public ChapternameTextKeyListener(JLabel alert, JTextField chapternameText) {
		super();
		this.alert = alert;
		this.chapternameText = chapternameText;
	}
	public void keyReleased(KeyEvent e) {
		chaptername_str = chapternameText .getText().trim();
		if (chaptername_str.matches("^[a-zA-Z0-9\\u4e00-\\u9fa5]{3,20}")) {		
				alert.setText("");		
		} else {
			alert.setText("输入格式错误，输入字符为英文数字汉字，长度为3到20之间");
		}

	}
}
