package alert;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RecodetxtListener extends KeyAdapter {
private String shengchengcode;
private String code;
private JLabel alert;
private JTextField statetxt;
private JTextField codetxt;


public RecodetxtListener(JLabel alert, JTextField statetxt, JTextField codetxt) {
	super();
	this.alert = alert;
	this.statetxt = statetxt;
	this.codetxt = codetxt;
}


public String getShengchengcode() {
	return shengchengcode;
}


public void setShengchengcode(String shengchengcode) {
	this.shengchengcode = shengchengcode;
}


public String getCode() {
	return code;
}


public void setCode(String code) {
	this.code = code;
}


public void keyReleased(KeyEvent e) {
	//生成验证码
			String shengchengcodecode=this.statetxt.getText().trim();
			String code=this.codetxt.getText().trim();
			if(!code.equals(shengchengcode)) {
				this.alert.setText("验证码输入有误，请重新输入");
			}else {
				alert.setText("");
			}
	}
}
