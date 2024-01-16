package dao;

public class UserDAOFactory {

	private static UserDAO dao;
	
	public static UserDAO getDAO() {
		if(dao == null) {
			dao = new UserDAOImpl();
		}
		return dao;
	}
	
}
