package alert;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Nametxtlistener extends KeyAdapter {
private String name;
private JLabel alert;
private JTextField nametxt;
public Nametxtlistener(JLabel alert, JTextField nametxt) {
	super();
	this.alert = alert;
	this.nametxt = nametxt;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public void keyReleased(KeyEvent e) {
	//真实姓名判断
	String name=this.nametxt.getText().trim();
	String na="^[a-zA-Z\u4e00-\u9fa5]{2,20}";
	if(!name.matches(na)) {
		alert.setText("姓名输入格式为汉字或英文，其长度为2-20位，请重新输入");
		alert.getText();
	}else {
		alert.setText("");
	}
	}
}
