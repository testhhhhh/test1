package inputcheck;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class NovelPictureTextKeyListener extends KeyAdapter{
	private String novelpicture_str;
	private JLabel alert;
	private JTextField novelpictureText;
	public String getNovelpicture_str() {
		return novelpicture_str;
	}
	public void setNovelpicture_str(String novelpicture_str) {
		this.novelpicture_str = novelpicture_str;
	}
	public NovelPictureTextKeyListener(JLabel alert, JTextField novelpictureText) {
		super();
		this.alert = alert;
		this.novelpictureText = novelpictureText;
	}
	public void keyReleased(KeyEvent e) {
		novelpicture_str = novelpictureText.getText().trim();
		if (!"".equals(novelpicture_str)) {		
				alert.setText("");		
		} else {
			   alert.setText("ÇëÉÏ´«Í¼Æ¬");
		}

	}
}
