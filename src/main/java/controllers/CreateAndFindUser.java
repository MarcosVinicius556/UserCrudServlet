  package controllers;

import java.io.IOException;
import java.util.List;

import dao.UserDAOFactory;
import jakarta.servlet.RequestDispatcher;
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
		String pesquisa = req.getParameter("pesquisa") == null ? "" : req.getParameter("pesquisa");
		
		List<User> users = UserDAOFactory.getDAO().findAll(pesquisa);
		
		req.setAttribute("users", users);
		RequestDispatcher reqDispatcher = req.getRequestDispatcher("lista.jsp");
		reqDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		
		System.out.println("Chamou requisição POST");
		
		user.setNome(req.getParameter("nome"));
		user.setCpf(req.getParameter("cpf"));
		user.setNascimento(req.getParameter("nascimento"));
		user.setSituacao(req.getParameter("situacao"));
		
		UserDAOFactory.getDAO().create(user);
		
		doGet(req, resp);
	}
	
}
