package UserPackage.src.InputCheck;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import UserPackage.src.DaoImple.UserDaoImplement;

public class CommentTextKeyListener  extends KeyAdapter{
	private String commentText_str;
	private JLabel alert;
	private JTextField commentText;
	public CommentTextKeyListener() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public CommentTextKeyListener(JLabel alert, JTextField commentText) {
		super();
		this.alert = alert;
		this.commentText = commentText;
	}

	public String getCommentText_str() {
		return commentText_str;
	}

	public void setCommentText_str(String commentText_str) {
		this.commentText_str = commentText_str;
	}

	public void keyReleased(KeyEvent e) {
		commentText_str = commentText.getText().trim();
		if (commentText_str.length()<=199) {	
				alert.setText("");
		} else {
			alert.setText("评论输入格式错误，字数在200以内");
		}

	}
}
