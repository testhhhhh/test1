package UserPackage.src.InputCheck;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class NovelWriterTextKeyListener  extends KeyAdapter{
	private String novelwriter_str;
	private JLabel alert;
	private JTextField novelwriterText;
	public String getNovelwriter_str() {
		return novelwriter_str;
	}
	public void setNovelwriter_str(String novelwriter_str) {
		this.novelwriter_str = novelwriter_str;
	}
	public NovelWriterTextKeyListener(JLabel alert, JTextField novelwriterText) {
		super();
		this.alert = alert;
		this.novelwriterText = novelwriterText;
	}
	public void keyReleased(KeyEvent e) {
		novelwriter_str = novelwriterText.getText().trim();
		if (novelwriter_str.matches("^[a-zA-Z0-9\\u4e00-\\u9fa5]{3,20}")) {		
				alert.setText("");		
		} else {
			   alert.setText("格式错误，输入字数在3到20之间");
		}

	}
}
