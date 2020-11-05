package UserPackage.src.InputCheck;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class NameTextKeyListener extends KeyAdapter{
	private String name_str;
	private JLabel alert;
	private JTextField nameText;
	public NameTextKeyListener(JLabel alert, JTextField nameText) {
		super();
		this.alert = alert;
		this.nameText = nameText;
	}
	public void setName_str(String name_str) {
		this.name_str = name_str;
	}
	public String getName_str() {
		return name_str;
	}
	public void keyReleased(KeyEvent e) {
		name_str = nameText.getText().trim();
		if (name_str.matches("^[a-zA-Z0-9\\u4e00-\\u9fa5]{2,20}")) {		
				alert.setText("");		
		} else {
			alert.setText("姓名输入格式为汉字或英文，其长度为2-20位");
		}

	}
	
}
