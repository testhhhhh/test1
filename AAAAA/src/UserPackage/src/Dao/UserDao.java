package UserPackage.src.Dao;

import UserPackage.src.Entity.Money;
import UserPackage.src.Entity.User;

public interface UserDao {
	public abstract boolean isLogin(String username,String password);
    public abstract boolean regist(User  user);
    public abstract boolean isRegisted(String username);
    public abstract boolean personalchange(String username,String password,String name,String sex,String telephone);
	public abstract boolean upDateMoney(double money);
}
