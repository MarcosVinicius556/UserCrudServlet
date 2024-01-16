package dao;

import java.sql.Connection;
import java.util.List;

import db.H2Connection;
import model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public void create(User user) {
		Connection conn = null;
		String createSQL = "";
		try {
			conn = H2Connection.getConnection();
			createSQL = "INSERT INTO user VALUES()";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll(String pesquisa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User newData) {
		// TODO Auto-generated method stub
		
	}

}
