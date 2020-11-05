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
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addPicture(btnNewButton);
			}
		});
	
		btnNewButton.setBounds(355, 264, 141, 46);
		contentPane.add(btnNewButton);
	}

	
	//上传图片
	public static void addPicture(JButton button) {
		  JFileChooser chooser = new JFileChooser();
		  chooser.setMultiSelectionEnabled(true);
		  /** 过滤文件类型 * */
		  FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg","png");
		  chooser.setFileFilter(filter);
		  int returnVal = chooser.showOpenDialog(button);
		  if (returnVal == JFileChooser.APPROVE_OPTION) { ////
		   /** 得到选择的文件* */
		   File[] arrfiles = chooser.getSelectedFiles();
		   if (arrfiles == null || arrfiles.length == 0) {
		    return;
		   }
		   //判断是否有文件为jpg或者png
		 File  ff = chooser.getSelectedFile();
		 //创建一个fileName得到选择文件的名字
		 String fileName =ff.getName();
		 //lastIndexOf(".") 返回"."在文件名中最后一次出现的下标
		 //substring(int index)从指定的index开始截取后面的字符串
		 //比如： a.txt 最后一次出现的.下标是 1 substring(1)就是从下标1的位置开始截取 截取后的新字符串为 .txt
		 //所以这里需要+1 才能只截取文件类型 txt
		 String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
		 //判断选择的文件是否是图片文件 必须排除不是的情况 不然后续操作会报错
		 if(!(prefix.equals("jpg") || prefix.equals("png"))){
		 JOptionPane.showMessageDialog(new JDialog(),":请选择.jpg 或 .png格式的图片");
		 return;
		 }
		   FileInputStream input = null;
		   FileOutputStream out = null;
		   String path = "C:\\Users\\admin\\eclipse-workspace\\MySQLTest\\src\\png";
		   try {
		    for (File f : arrfiles) {
		     File dir = new File(path);
		     /** 目标文件夹 * */
		     File[] fs = dir.listFiles();
		     HashSet<String> set = new HashSet<String>();
		     for (File file : fs) {
		      set.add(file.getName());
		     }
		     /** 判断是否已有该文件* */
		     if (set.contains(f.getName())) {
		      JOptionPane.showMessageDialog(new JDialog(),
		        f.getName() + ":该文件已存在！");
		      return;
		     }
		     
		   //通过文件选择器对象拿到选择的文件.拿到该文件的绝对路径
		     String absolutePath = chooser.getSelectedFile().getAbsolutePath();
		   //创建一个ImageIcon对象 传入图片文件的绝对路径
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
		    JOptionPane.showMessageDialog(null, "上传成功！", "提示",
		      JOptionPane.INFORMATION_MESSAGE);
		   } catch (FileNotFoundException e1) {
		    JOptionPane.showMessageDialog(null, "上传失败！", "提示",
		      JOptionPane.ERROR_MESSAGE);
		    e1.printStackTrace();
		   } catch (IOException e1) {
		    JOptionPane.showMessageDialog(null, "上传失败！", "提示",
		      JOptionPane.ERROR_MESSAGE);
		    e1.printStackTrace();
		   }
		  }
		 }
		}

		


