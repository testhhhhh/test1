package inputcheck;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class UserIntroduceTextKeyListener  extends KeyAdapter{
	private String userintroduce_str;
	private JLabel alert;
	private JTextField userintroducetext;

	public String getUserintroduce_str() {
		return userintroduce_str;
	}

	public void setUserintroduce_str(String userintroduce_str) {
		this.userintroduce_str = userintroduce_str;
	}

	public UserIntroduceTextKeyListener(JLabel alert, JTextField userintroducetext) {
		super();
		this.alert = alert;
		this.userintroducetext = userintroducetext;
	}

	public void keyReleased(KeyEvent e) {
		userintroduce_str = userintroducetext.getText().trim();
		if (userintroduce_str.matches("^[a-zA-Z0-9\\u4e00-\\u9fa5]{3,500}")) {		
				alert.setText("");		
		} else {
			   alert.setText("输入格式错误，输入字数在3到500之间");
		}

	}
	
}
