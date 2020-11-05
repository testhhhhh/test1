package AdminView;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class ShanggchuangFrm extends JFrame {

	private JPanel contentPane;
	private static JLabel lblNewLabel;
    private JButton btnNewButton ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShanggchuangFrm frame = new ShanggchuangFrm();
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
	public ShanggchuangFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(36, 39, 250, 250);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("\u4E0A\u4F20\u56FE\u7247");
		btnNewButton.setFont(new Font("����", Font.BOLD, 18));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addPicture(btnNewButton);
			}
		});
	
		btnNewButton.setBounds(355, 264, 141, 46);
		contentPane.add(btnNewButton);
	}

	
	//�ϴ�ͼƬ
	public static void addPicture(JButton button) {
		  JFileChooser chooser = new JFileChooser();
		  chooser.setMultiSelectionEnabled(true);
		  /** �����ļ����� * */
		  FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg","png");
		  chooser.setFileFilter(filter);
		  int returnVal = chooser.showOpenDialog(button);
		  if (returnVal == JFileChooser.APPROVE_OPTION) { ////
		   /** �õ�ѡ����ļ�* */
		   File[] arrfiles = chooser.getSelectedFiles();
		   if (arrfiles == null || arrfiles.length == 0) {
		    return;
		   }
		   //�ж��Ƿ����ļ�Ϊjpg����png
		 File  ff = chooser.getSelectedFile();
		 //����һ��fileName�õ�ѡ���ļ�������
		 String fileName =ff.getName();
		 //lastIndexOf(".") ����"."���ļ��������һ�γ��ֵ��±�
		 //substring(int index)��ָ����index��ʼ��ȡ������ַ���
		 //���磺 a.txt ���һ�γ��ֵ�.�±��� 1 substring(1)���Ǵ��±�1��λ�ÿ�ʼ��ȡ ��ȡ������ַ���Ϊ .txt
		 //����������Ҫ+1 ����ֻ��ȡ�ļ����� txt
		 String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
		 //�ж�ѡ����ļ��Ƿ���ͼƬ�ļ� �����ų����ǵ���� ��Ȼ���������ᱨ��
		 if(!(prefix.equals("jpg") || prefix.equals("png"))){
		 JOptionPane.showMessageDialog(new JDialog(),":��ѡ��.jpg �� .png��ʽ��ͼƬ");
		 return;
		 }
		   FileInputStream input = null;
		   FileOutputStream out = null;
		   String path = "C:\\Users\\admin\\eclipse-workspace\\MySQLTest\\src\\png";
		   try {
		    for (File f : arrfiles) {
		     File dir = new File(path);
		     /** Ŀ���ļ��� * */
		     File[] fs = dir.listFiles();
		     HashSet<String> set = new HashSet<String>();
		     for (File file : fs) {
		      set.add(file.getName());
		     }
		     /** �ж��Ƿ����и��ļ�* */
		     if (set.contains(f.getName())) {
		      JOptionPane.showMessageDialog(new JDialog(),
		        f.getName() + ":���ļ��Ѵ��ڣ�");
		      return;
		     }
		     
		   //ͨ���ļ�ѡ���������õ�ѡ����ļ�.�õ����ļ��ľ���·��
		     String absolutePath = chooser.getSelectedFile().getAbsolutePath();
		   //����һ��ImageIcon���� ����ͼƬ�ļ��ľ���·��
		     ImageIcon imageIcon = new ImageIcon(absolutePath);
		     lblNewLabel.setIcon(imageIcon);
		     lblNewLabel.getIcon();
		     input = new FileInputStream(f);
		     byte[] buffer = new byte[1024];
		     File des = new File(path, f.getName());
		     out = new FileOutputStream(des);
		     int len = 0;
		     while (-1 != (len = input.read(buffer))) {
		      out.write(buffer, 0, len);
		     }
		     out.close();
		     input.close();
		    }
		    JOptionPane.showMessageDialog(null, "�ϴ��ɹ���", "��ʾ",
		      JOptionPane.INFORMATION_MESSAGE);
		   } catch (FileNotFoundException e1) {
		    JOptionPane.showMessageDialog(null, "�ϴ�ʧ�ܣ�", "��ʾ",
		      JOptionPane.ERROR_MESSAGE);
		    e1.printStackTrace();
		   } catch (IOException e1) {
		    JOptionPane.showMessageDialog(null, "�ϴ�ʧ�ܣ�", "��ʾ",
		      JOptionPane.ERROR_MESSAGE);
		    e1.printStackTrace();
		   }
		  }
		 }
		}

		


