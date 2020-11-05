package UserPackage.src.InputCheck;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelephoneTextKeyListener extends KeyAdapter{
	private String telephone_str;
	private JLabel alert;
	private JTextField telephoneText;

	public String getTelephone_str() {
		return telephone_str;
	}

	public void setTelephone_str(String telephone_str) {
		this.telephone_str = telephone_str;
	}

	public TelephoneTextKeyListener(JLabel alert, JTextField telephoneText) {
		super();
		this.alert = alert;
		this.telephoneText = telephoneText;
	}

	public void keyReleased(KeyEvent e) {
		telephone_str = telephoneText.getText().trim();
		if (telephone_str.matches("^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$")) {		
				alert.setText("");		
		} else {
			   alert.setText("电话格式错误");
		}

	}
}
