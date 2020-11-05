package UserPackage.src.InputCheck;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NovelMainTextKeyListener  extends KeyAdapter{
	private String novelmain_str;
	private JLabel alert;
	private JTextField novelmaintext;
	public String getNovelmain_str() {
		return novelmain_str;
	}
	public void setNovelmain_str(String novelmain_str) {
		this.novelmain_str = novelmain_str;
	}
	public NovelMainTextKeyListener(JLabel alert, JTextField novelmaintext) {
		super();
		this.alert = alert;
		this.novelmaintext = novelmaintext;
	}
	public void keyReleased(KeyEvent e) {
		novelmain_str = novelmaintext.getText().trim();
		if (novelmain_str.matches("^[a-zA-Z0-9\\u4e00-\\u9fa5]{3,500}")) {		
				alert.setText("");		
		} else {
			   alert.setText("输入格式错误，输入字数在3到500之间");
		}

	}
	
}
