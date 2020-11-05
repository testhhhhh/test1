package alert;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelephonetxtListener extends KeyAdapter {
	private String telephone;
	private JLabel alert;
	private JTextField telephonetxt;
	public TelephonetxtListener(JLabel alert, JTextField telephonetxt) {
		super();
		this.alert = alert;
		this.telephonetxt = telephonetxt;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void keyReleased(KeyEvent e) {
		//电话格式判断
		String telephone=this.telephonetxt.getText().trim();
		String zhengze="^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
		if(telephone.matches("\\d{11}")) {	
			if(telephone.matches(zhengze)) {
		
			alert.setText("");}
			else {
				alert.setText("电话格式错误，请重新输入");
			}
		}else {
			alert.setText("电话格式错误，请重新输入");
		
		}
		}
}
