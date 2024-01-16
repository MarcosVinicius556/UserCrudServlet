package dao;

import java.util.List;

import model.User;

public interface UserDAO {

	public void create(User user);
	public void delete(long id);
	public List<User> findAll(String pesquisa);
	public User findById(long id);
	public void update(User newData);
	
}
