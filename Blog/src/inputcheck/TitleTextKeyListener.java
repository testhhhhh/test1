package inputcheck;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class TitleTextKeyListener extends KeyAdapter{
	private String noveltitle_str;
	private JLabel alert;
	private JTextField noveltitleText;

	public TitleTextKeyListener(JLabel alert, JTextField noveltitleText) {
		super();
		this.alert = alert;
		this.noveltitleText = noveltitleText;
	}
	public String getNoveltitle_str() {
		return noveltitle_str;
	}
	public void setNoveltitle_str(String noveltitle_str) {
		this.noveltitle_str = noveltitle_str;
	}
	public void keyReleased(KeyEvent e) {
		noveltitle_str = noveltitleText.getText().trim();
		if (noveltitle_str.matches("^[a-zA-Z0-9\\u4e00-\\u9fa5]{3,20}")) {					
				alert.setText("");
		} else {
			   alert.setText("格式错误，输入字数在3到20之间");
		}

	}
}
