  package controllers;

import java.io.IOException;

import dao.UserDAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/CreateAndFind")
public class CreateAndFindUser extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		
		user.setNome(req.getParameter("nome"));
		user.setCpf(req.getParameter("cpf"));
		user.setNascimento(req.getParameter("nascimento"));
		user.setSituacao(req.getParameter("situacao"));
		
		UserDAOFactory.getDAO().create(user);
	}
	
}
