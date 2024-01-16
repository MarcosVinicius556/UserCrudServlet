package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
			createSQL = "INSERT INTO user VALUES(null, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(createSQL);
			ps.setString(1, user.getNome());
			ps.setString(2, user.getCpf());
			ps.setString(3, user.getNascimento());
			ps.setString(4, user.getSituacao());
			
			ps.executeUpdate();
			
			System.out.println("--correct insert on database");
		} catch (Exception e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll(String pesquisa) {
		Connection conn = null;
		String selectSQL = "SELECT * FROM users WHERE nome ILIKE '%s%%' OR cpf ILIKE '%s%%";
		List<User> users = new ArrayList<>();
		try {
			conn = H2Connection.getConnection();
			selectSQL = String.format(selectSQL, pesquisa, pesquisa);
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(selectSQL);
			
			while(rs.next()) {
				Long id = rs.getLong("id");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String nascimento = rs.getString("nascimento");
				String situacao = rs.getString("situacao");
				
				User user = new User(id, nome, cpf, nascimento, situacao);
				users.add(user);
			}
			
			System.out.println("--correct search on database");
		} catch (Exception e) {
			System.out.println("--incorrect search on database. " + e.getMessage());
			e.printStackTrace();
		}
		return users;
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
