package UserPackage.src.Dao;

import javax.swing.DefaultListModel;

public interface CommentDao {
	public boolean commentlist(Object nnovelname, int userid,DefaultListModel<String> d);
	public boolean commentupload(int novelid, int userid,String comments) ;
}
