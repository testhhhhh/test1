package model;
/*
 * ѡ���û����߹���Ա
 */
public enum UserType {
azmin("ϵͳ����Ա",0),user("�û�",1);
	private String name;
	private int index;
	private UserType(String name, int index) {
		this.name = name;
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
public String toString() {
	return this.name;
}
}
