package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		PreparedStatement ps = null;
		try {
			conn = H2Connection.getConnection();
			createSQL = "INSERT INTO user VALUES(null, ?, ?, ?, ?)";
			
			ps = conn.prepareStatement(createSQL);
			ps.setString(1, user.getNome());
			ps.setString(2, user.getCpf());
			ps.setString(3, user.getNascimento());
			ps.setString(4, user.getSituacao());
			
			ps.executeUpdate();
			
			System.out.println("--correct insert on database");
		} catch (Exception e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)
					ps.close();
				ps = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(long id) {
		Connection conn = null;
		String deleteSQL = "";
		PreparedStatement ps = null;
		try {
			conn = H2Connection.getConnection();
			deleteSQL = "DELETE FROM user WHERE id = ?";
			
			ps = conn.prepareStatement(deleteSQL);
			ps.setLong(1, id);
			
			ps.executeUpdate();
			
			System.out.println("--correct delete on database");
		} catch (Exception e) {
			System.out.println("--incorrect delete on database. " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)
					ps.close();
				ps = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<User> findAll(String pesquisa) {
		Connection conn = null;
		String selectSQL = "SELECT * FROM users WHERE nome ILIKE '%s%%' OR cpf ILIKE '%s%%";
		List<User> users = new ArrayList<>();
		Statement st = null;
		try {
			conn = H2Connection.getConnection();
			selectSQL = String.format(selectSQL, pesquisa, pesquisa);
			
			st = conn.createStatement();
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
		}  finally {
			try {
				if(st != null)
					st.close();
				st = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	@Override
	public User findById(long userId) {
		Connection conn = null;
		String selectByIdSQL = "SELECT * FROM users WHERE id = %d";
		User user = null;
		Statement st = null;
		try {
			conn = H2Connection.getConnection();
			selectByIdSQL = String.format(selectByIdSQL, userId);
			
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(selectByIdSQL);
			
			while(rs.next()) {
				Long id = rs.getLong("id");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String nascimento = rs.getString("nascimento");
				String situacao = rs.getString("situacao");
				
				user = new User(id, nome, cpf, nascimento, situacao);
			}
			
			System.out.println("--correct search on database");
		} catch (Exception e) {
			System.out.println("--incorrect search on database. " + e.getMessage());
			e.printStackTrace();
		}  finally {
			try {
				if(st != null)
					st.close();
				st = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public void update(User user) {
		Connection conn = null;
		String createSQL = "";
		PreparedStatement ps = null;
		try {
			conn = H2Connection.getConnection();
			createSQL = "UPDATE user SET nome = ?, cpf = ?, nascimento = ?, situacao = ? WHERE id = ?)";
			
			ps = conn.prepareStatement(createSQL);
			ps.setString(1, user.getNome());
			ps.setString(2, user.getCpf());
			ps.setString(3, user.getNascimento());
			ps.setString(4, user.getSituacao());
			ps.setString(5, user.getId()+"");
			
			ps.executeUpdate();
			
			System.out.println("--correct update on database");
		} catch (Exception e) {
			System.out.println("--incorrect update on database. " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)
					ps.close();
				ps = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
