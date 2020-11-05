package UserPackage.src.InputCheck;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CodeTextKeyListener extends KeyAdapter{
	private String code_str;
	private JLabel alert;
	private JTextField codeText;

	public CodeTextKeyListener(JLabel alert, JTextField codeText) {
		super();
		this.alert = alert;
		this.codeText = codeText;
	}
	public String getCode_str() {
		return code_str;
	}
	public void setCode_str(String code_str) {
		this.code_str = code_str;
	}
	public void keyReleased(KeyEvent e) {
		code_str = codeText.getText().trim();
		if (code_str.matches("^[0-9]{1,4}")) {		
				alert.setText("");		
		} else {
			alert.setText("输入格式错误，输入字符为数字，长度为1到4之间");
		}

	}
}
