package UserPackage.src.Dao;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import UserPackage.src.DaoImple.ChapterDaoilplement;

public class JListDemo {

	public static void main(String[] args) {
		JFrame frame=new JFrame("Java�б�����ʾ��");
        JScrollPane jp = new JScrollPane();   
		jp.setPreferredSize(new java.awt.Dimension(218, 164));
		  ChapterDaoilplement cdi=new ChapterDaoilplement();
        JList<String> list=new JList<String>();    //����JList
       System.out.println(cdi.chapterlist()); 
//        cdi.dd.addElement("a");
//        cdi.dd.addElement("b");
        list.setModel(cdi.aaa);
        jp.setViewportView(list); 
        frame.add(jp);
        frame.setBounds(300,200,400,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
