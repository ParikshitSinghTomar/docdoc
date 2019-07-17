package in.main.app.rest.dao;

import java.util.List;

import in.main.app.rest.entity.User;

public interface IUserDao {
	
	User saveUser(User user);
	
	List<User> getUserList();
	
	User getUser(int id);
	User getUser(String email,String mobileNo);
	User getUser(String username,String email,String mobileNo,String password);
	void deleteUser(int id);

	
}
