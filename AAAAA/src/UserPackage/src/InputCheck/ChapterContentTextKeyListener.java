package UserPackage.src.InputCheck;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChapterContentTextKeyListener  extends KeyAdapter{
	private String chaptercontent_str;
	private JLabel alert;
	private JTextField chaptercontentText;
	public String getChaptercontent_str() {
		return chaptercontent_str;
	}
	public void setChaptercontent_str(String chaptercontent_str) {
		this.chaptercontent_str = chaptercontent_str;
	}
	public ChapterContentTextKeyListener(JLabel alert, JTextField chaptercontentText) {
		super();
		this.alert = alert;
		this.chaptercontentText = chaptercontentText;
	}
	public void keyReleased(KeyEvent e) {
		chaptercontent_str = chaptercontentText .getText().trim();
		if (chaptercontent_str.length()<=21000) {		
				alert.setText("");				
		} else {
			alert.setText("输入格式错误，字数在21000以内");
		}

	}
}
