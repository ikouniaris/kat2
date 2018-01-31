package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entities.User;

public interface adminDAO {
	

	public void insertUser(User u);
	
	public List<User> printUser();	
	
	public int modifyUser(User u, String email);
	
	public int deleteUser(String email);
}
