package UserPackage.src.Dao;

import javax.swing.DefaultListModel;

import UserPackage.src.Entity.Novel;

public interface NovelDao {
	public abstract boolean novellist(int classifyid,DefaultListModel<String> d);
	public abstract boolean novelinteractive();
	public abstract boolean novelupload();
}
