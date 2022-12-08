package com.turhtkar.leaugevoicechatbot.Users;

import java.util.List;

public interface UserDaoImpl {
	
	public User getUser();
	public List<User> getAllUsers();
	public void updateUser(Account account);
	public void deleteUser(Account account);
	public void UpdateAllUsers(Account account);
	public void createUser(Account account);
}
