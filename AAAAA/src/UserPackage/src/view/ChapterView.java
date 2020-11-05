package UserPackage.src.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UserPackage.src.DaoImple.ChapterDaoilplement;
import UserPackage.src.DaoImple.NovelDaoImplement;

import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextArea;

public class ChapterView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void ChapterViewInit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChapterView frame = new ChapterView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//�����½��Ķ�ҳ�洰��
	}

	/**
	 * Create the frame.
	 */
	public ChapterView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1217, 797);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//�����������

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("������κ", Font.PLAIN, 27));
		textArea.setLineWrap(true);// �Զ�����
		textArea.setBackground(new Color(250, 235, 215));
		//�����½��Ķ��ı���

		JScrollPane scrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				                                  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(36, 44, 1143, 693);
		scrollPane.setViewportView(textArea);
		contentPane.add(scrollPane);
		contentPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		//�����������

		ChapterDaoilplement cdi = new ChapterDaoilplement();//�����½�Daoʵ�������
		cdi.chaptercontentshow();//����������½�������ʾ����(chaptercontentshow)
		textArea.setText(cdi.chapter.getChaptercontent());//�ı���������chapterʵ���е��½�����Ϊ���ı�����
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ChapterView.class.getResource("/png/331accfedfa32255b471222cd480e1e.png")));
		lblNewLabel.setBounds(0, 0, 1218, 782);
		contentPane.add(lblNewLabel);
	}
}
