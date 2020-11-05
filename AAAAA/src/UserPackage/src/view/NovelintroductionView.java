package UserPackage.src.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class NovelintroductionView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovelintroductionView frame = new NovelintroductionView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NovelintroductionView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int x=Toolkit.getDefaultToolkit().getScreenSize().width;
		int y=Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds(0, 0, x, y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, x, y);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel photolabel = new JLabel("\u56FE\u7247\u533A\u57DF");
		photolabel.setIcon(new ImageIcon("C:\\Users\\93553\\Desktop\\\u8F6F\u4EF6\u5DE5\u7A0B\\\u5FAE\u4FE1\u56FE\u7247_20200508162153.png"));
		photolabel.setForeground(Color.BLACK);
		photolabel.setBackground(Color.BLACK);
		photolabel.setFont(new Font("华文行楷", Font.PLAIN, 29));
		photolabel.setBounds(66, 10, 238, 192);
		panel.add(photolabel);
		
		JLabel novelwriterlabel = new JLabel("\u4F5C\u8005:");
		novelwriterlabel.setFont(new Font("宋体", Font.PLAIN, 23));
		novelwriterlabel.setBounds(66, 227, 67, 36);
		panel.add(novelwriterlabel);
		
		JLabel writerlabel = new JLabel("New label");
		writerlabel.setFont(new Font("宋体", Font.PLAIN, 23));
		writerlabel.setBounds(138, 227, 108, 36);
		panel.add(writerlabel);
		
		JLabel novelnamelabel = new JLabel("\u5C0F\u8BF4\u540D\u79F0:");
		novelnamelabel.setFont(new Font("宋体", Font.PLAIN, 23));
		novelnamelabel.setBounds(20, 273, 119, 27);
		panel.add(novelnamelabel);
		
		JLabel namelabel = new JLabel("New label");
		namelabel.setFont(new Font("宋体", Font.PLAIN, 23));
		namelabel.setBounds(138, 273, 108, 27);
		panel.add(namelabel);
		
		JLabel novelmainlabel = new JLabel("\u6897\u6982:");
		novelmainlabel.setFont(new Font("宋体", Font.PLAIN, 23));
		novelmainlabel.setBounds(66, 387, 67, 27);
		panel.add(novelmainlabel);
		
		JLabel mainlabel = new JLabel("");
		String text="New labelxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
		mainlabel.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		mainlabel.setBounds(51, 379, 544, 500);
		mainlabel.setSize(400, 300);
		try {
			JlabelSetText(mainlabel, text);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		panel.add(mainlabel);
		
		JLabel novelmoneylabel = new JLabel("\u70B9\u5238:");
		novelmoneylabel.setFont(new Font("宋体", Font.PLAIN, 23));
		novelmoneylabel.setBounds(66, 311, 67, 27);
		panel.add(novelmoneylabel);
		
		JLabel moneylabel = new JLabel("New label");
		moneylabel.setFont(new Font("宋体", Font.PLAIN, 23));
		moneylabel.setBounds(138, 311, 108, 27);
		panel.add(moneylabel);
		
		JButton buybutton = new JButton("\u6211\u8981\u770B\u5B83");
		buybutton.setIcon(new ImageIcon(NovelintroductionView.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC,\u7B11\u8138(1).png")));
		buybutton.setFont(new Font("宋体", Font.PLAIN, 30));
		buybutton.setBounds(138, 700, 196, 75);
		panel.add(buybutton);
		
		JLabel novelclassifylabel = new JLabel("\u5206\u7C7B:");
		novelclassifylabel.setFont(new Font("宋体", Font.PLAIN, 23));
		novelclassifylabel.setBounds(66, 348, 67, 32);
		panel.add(novelclassifylabel);
		
		JLabel classifylabel = new JLabel("New label");
		classifylabel.setFont(new Font("宋体", Font.PLAIN, 23));
		classifylabel.setBounds(138, 351, 108, 27);
		panel.add(classifylabel);
		
		JLabel label = new JLabel("\u7AE0\u8282");
		label.setFont(new Font("宋体", Font.PLAIN, 30));
		label.setBounds(498, 10, 67, 51);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NovelintroductionView.class.getResource("/png/31.png")));
		lblNewLabel.setBounds(0, 0, 1536, 836);
		panel.add(lblNewLabel);
		
	}
	void JlabelSetText(JLabel jLabel, String longString) 
            throws InterruptedException {
        StringBuilder builder = new StringBuilder("<html>");
        char[] chars = longString.toCharArray();
        FontMetrics fontMetrics = jLabel.getFontMetrics(jLabel.getFont());
        int start = 0;
        int len = 0;
        while (start + len < longString.length()) {
            while (true) {
                len++;
                if (start + len > longString.length())break;
                if (fontMetrics.charsWidth(chars, start, len) 
                        > jLabel.getWidth()) {
                    break;
                }
            }
            builder.append(chars, start, len-1).append("<br/>");
            start = start + len - 1;
            len = 0;
        }
        builder.append(chars, start, longString.length()-start);
        builder.append("</html>");
        jLabel.setText(builder.toString());
    }
}
